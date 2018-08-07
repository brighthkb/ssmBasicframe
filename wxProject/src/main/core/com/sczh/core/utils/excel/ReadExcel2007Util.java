package com.sczh.core.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import com.sczh.core.utils.AttachmentUtils.AttachmentVo;
import com.sczh.core.utils.StringUtils;

/**
 * 读Excel 2007 工具类
 * <p>poi.jar------支持excel 2007</p>
 * @author 陈涛
 */
public class ReadExcel2007Util {
	/**
	 * 获取excel工作薄对象
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static XSSFWorkbook  getWorkbook(InputStream is) throws Exception{
		XSSFWorkbook wb = null;
		
        try {
			wb = new XSSFWorkbook(is);//创建工作薄
		}finally{
			IOUtils.closeQuietly(is);
		}
		
	    return wb;
	}
	
	/**
	 * 获取excel指定索引工作表对象 
	 * @param wb  excel工作薄对象
	 * @param sheetName  注：工作表名称
	 * @throws Exception
	 */
	public static XSSFSheet getSheet(XSSFWorkbook  wb,String sheetName) throws Exception{
		XSSFSheet sheet = wb.getSheet(sheetName);

		if(sheet==null)
			throw new Exception("未获取到excel表单错误");
		
		return sheet;
	}	
	
	/**
	 * 获取excel数据
	 * <p>注：sheet表的行和列的索引都是从0开始的，自定义获取数据的范围</p>
	 * @param sheet excel工作表对象
	 * @param beginRowIndex 开始读取行索引
	 * @param endRowIndex  结束读取行索引
	 * @param beginColumnIndex 开始读取列索引
	 * @param endColumnIndex 结束读取列索引 
	 * @return
	 * @throws Exception
	 */
	public static List<Map<Integer,String>> getData(XSSFSheet sheet,int beginRowIndex,int endRowIndex,
			int beginColumnIndex,int endColumnIndex) throws Exception{
		List<Map<Integer,String>> data = new ArrayList<Map<Integer,String>>();//数据列表
		NumberFormat nf = NumberFormat.getInstance(); 
		nf.setGroupingUsed(false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try
		{
			if(sheet!=null && sheet.getPhysicalNumberOfRows()>0 //有效行数
			   && beginRowIndex>=0
			   && beginRowIndex<=endRowIndex
			   && beginColumnIndex>=0
			   //当前行的有效单元格数：row.getPhysicalNumberOfCells()-1，不能满足：行含有空单元格
			   //当前行最后一个有效单元格列顺序号：row.getLastCellNum()，不能满足：行最后面的列是空单元格
			   //所以需要定义要扫描的行的开始和结束列索引
			   && beginColumnIndex<=endColumnIndex)
			{
				int _endRowIndex = sheet.getLastRowNum();//表单有效最大行号
				for (int i = beginRowIndex; i <= endRowIndex; i++)
				{
					if(i>_endRowIndex){//当前构造的行号 大于 表单有效最大行号，会报数组越界异常
						break;//不再向下循环处理表格行数据
					}
					XSSFRow row=sheet.getRow(i);//excel行
					if(row==null || row.getPhysicalNumberOfCells()==0){//遇到空行,继续循环下一行
						data.add(null);//空行
						continue;
					}
					Map<Integer,String> rowData =new HashMap<Integer,String>();
					boolean isNullRow = true;//是否是空数据行
					
					for (int j = beginColumnIndex; j <=endColumnIndex; j++) {
						XSSFCell cell = row.getCell(j);//excel单元格
						if(cell==null 
						   || cell.getCellType()==XSSFCell.CELL_TYPE_BLANK 
						   || cell.getCellType()==XSSFCell.CELL_TYPE_ERROR 
						   || cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA)
						{
							rowData.put(j,null);
						}else{
							isNullRow = false;
							if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){//如数值类型单元格用字符串读取方式抛出异常
								//组件把日期和数值都当作数字类型，可以把excel日期单元格类型设置为文本型,也可以如下
								if(HSSFDateUtil.isCellDateFormatted(cell)){//终于解决这个遗留问题
									rowData.put(j,sdf.format(cell.getDateCellValue()));
								}else{
									//rowData.add(String.valueOf(cell.getNumericCellValue()));//用科学计数方式显示
									rowData.put(j,nf.format(cell.getNumericCellValue()));//直接显示数字
								}
							}else if(cell.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN) {
								rowData.put(j,String.valueOf(cell.getBooleanCellValue()));
							}else{//CELL_TYPE_STRING
								rowData.put(j,cell.toString());
								//rowData.add(cell.getStringCellValue());
							}
						}
					}
					
					if(!isNullRow){//不是空数据行
						data.add(rowData);
					}else{
						data.add(null);//空行
					}
				}
			}else{
				throw new Exception("获取excel数据的方法的参数非法");
			}
		}catch(Exception e) {
			throw new Exception("获取excel数据错误");
		}
			
		loadImg(sheet, data, beginRowIndex, endRowIndex, beginColumnIndex, endColumnIndex);
		return data;
	}
	
	/**
	 * 获取并解析excel图片
	 */
	private static void loadImg(XSSFSheet sheet, List<Map<Integer,String>> data, int beginRowIndex, int endRowIndex,
			int beginColumnIndex, int endColumnIndex) throws Exception {
		if (sheet == null || data == null || data.isEmpty()) {
			return;
		}
		
		//附件插入接口
		//AttachmentService attachmentService = (AttachmentService)SpringContextUtils.getBean("attachmentService");
		Map<String, Object> req = new HashMap<String, Object>();
		
		//获取excel图片
		for (POIXMLDocumentPart dr : sheet.getRelations()) {
			if (dr instanceof XSSFDrawing) {
				List<XSSFShape> shapes = ((XSSFDrawing)dr).getShapes();
				for (XSSFShape shape : shapes) {
					XSSFPicture pic = (XSSFPicture) shape;
					XSSFClientAnchor anchor = pic.getPreferredSize();
					CTMarker ctMarker = anchor.getFrom();
					//图片在exel表单中第几行/第几列
					int rowIndex = ctMarker.getRow(), colIndex = ctMarker.getCol();
					if(rowIndex>=beginRowIndex && rowIndex<=endRowIndex && data.get(rowIndex-beginRowIndex)!=null){
						XSSFPictureData pictureData = pic.getPictureData();
						ByteArrayInputStream is = new ByteArrayInputStream(pictureData.getData());
						String fileName = "excel导入图片." + pictureData.suggestFileExtension();
						AttachmentVo attachment = new AttachmentVo(fileName, is.available(), is);
						Map<Integer,String> rowData = data.get(rowIndex-beginRowIndex);
						if(colIndex>=beginColumnIndex && colIndex<=endColumnIndex && StringUtils.isBlank(rowData.get(colIndex))){
							//rowData.put(colIndex, attachmentService.insertAttach(req, attachment));//插入附件，返回附件ID值
						}
					}
				}
			}
		}
	}
	
}