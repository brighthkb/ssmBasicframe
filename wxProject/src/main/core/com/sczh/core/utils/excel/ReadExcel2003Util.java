package com.sczh.core.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Image;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.sczh.core.utils.AttachmentUtils.AttachmentVo;




/**
 * 读Excel 2003 工具类
 * <p>jxl.jar------妈的，支持excel 2003</p>
 * @author 陈涛
 */
public class ReadExcel2003Util {
	/**
	 * 获取excel工作薄对象
	 * @param is 是InputStream的实现类,如FileInputStream
	 * @return
	 * @throws Exception
	 */
	//@Deprecated
	public static Workbook  getWorkbook(InputStream is) throws Exception{
		Workbook wb = null; //工作薄对象  
		
		try{
			wb=Workbook.getWorkbook(is);//构造Workbook（工作薄）对象  
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
	public static Sheet getSheet(Workbook wb,String sheetName) throws Exception{
		Sheet sheet= wb.getSheet(sheetName);
		
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
	public static List<Map<Integer,String>> getData(Sheet sheet,int beginRowIndex,int endRowIndex,
			int beginColumnIndex,int endColumnIndex) throws Exception{
		List<Map<Integer,String>> data = new ArrayList<Map<Integer,String>>();//数据列表
		NumberFormat nf = NumberFormat.getInstance(); 
		nf.setGroupingUsed(false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try{
			if(sheet!=null && sheet.getRows()>0
			   && beginRowIndex>=0 
			   && beginRowIndex<=endRowIndex
			   && beginColumnIndex>=0
			   //excel行包含的单元格:Cell[] rowCells=sheet.getRow(i)，
			   //不能满足：有空单元格，就会报数组越界异常，列索引大于数组索引
			   && beginColumnIndex<=endColumnIndex)
			{
				int _endRowIndex = sheet.getRows()-1;//表单有效最大行号
				int _endColumnIndex = sheet.getColumns()-1;//表单有效最大列号
				for (int i = beginRowIndex; i <= endRowIndex; i++)
				{
					if(i>_endRowIndex){//当前构造的行号 大于 表单有效最大行号，会报数组越界异常
						break;//不再向下循环处理表格行数据
					}
					Map<Integer,String> rowData =new HashMap<Integer,String>();
					boolean isAvailableRow = false; //是可用行,即不是空行数据
					
					for (int j = beginColumnIndex; j <= endColumnIndex; j++) {
						if(j>_endColumnIndex){//当前构造的列号 大于 表单有效最大列号，会报数组越界异常
							rowData.put(j,null);
							continue;//继续构造空列数据
						}
						Cell cell= sheet.getCell(j, i);//列，行
						//rowData.add(cell.getContents());//这个方法获取的值太粗糙了...根据类型取值才正确
						if(cell!=null && cell.getType()==CellType.NUMBER){
							rowData.put(j,nf.format(((NumberCell)cell).getValue()));//直接显示数字
							isAvailableRow = true ;	
						}else if(cell!=null && cell.getType()==CellType.LABEL){
							rowData.put(j,((LabelCell)cell).getString());
							isAvailableRow = true ;	
						}else if(cell!=null && cell.getType()==CellType.BOOLEAN){
							rowData.put(j,String.valueOf(((BooleanCell)cell).getValue()));
							isAvailableRow = true ;	
						}else if(cell!=null && cell.getType()==CellType.DATE){//注意：是格式时间
							//判读:是时间（是不完整的日期,比如18:30:20）；还是完整日期
							if(!((DateCell)cell).isTime()){
								rowData.put(j,sdf.format(convertGmtToLacalDate(((DateCell)cell).getDate())));
							}else{// If this refers to a time, then get rid of the integer part
								rowData.put(j,((DateCell)cell).getContents());
							}
							isAvailableRow = true ;	
						}else{//EMPTY、ERROR、*FORMULA*
							rowData.put(j,null);
						}
					}
					
					if(isAvailableRow){
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
	
	//格林时间转换成本地时间，JXL组件默认是GMT时区
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
	public static Date convertGmtToLacalDate(Date jxlDate) throws ParseException{
		if(jxlDate==null) return null;
		//根据GMT时区转换成本地时间格式字符串
		TimeZone gmtZone = TimeZone.getTimeZone("GMT");
		df.setTimeZone(gmtZone);
		String localDate = df.format(jxlDate);
		//根据本地时区转换成日期对象
		TimeZone localZone = TimeZone.getDefault();
		df.setTimeZone(localZone);
		return df.parse(localDate);
	}
	
	/**
	 * 获取并解析excel图片
	 */
	private static void loadImg(Sheet sheet, List<Map<Integer, String>> data,int beginRowIndex, int endRowIndex,
			int beginColumnIndex, int endColumnIndex) throws Exception {
		if (sheet == null || data == null || data.isEmpty()) {
			return;
		}

		// 附件插入接口
		//AttachmentService attachmentService = (AttachmentService) SpringContextUtils.getBean("attachmentService");
		Map<String, Object> req = new HashMap<String, Object>();

		// 获取excel图片
		int imgNumber = sheet.getNumberOfImages();// 获得sheet所包含的图片数
		for (int i = 0; i < imgNumber; i++) {
			Image image = sheet.getDrawing(i);
			// 图片在exel表单中第几行/第几列
			int rowIndex = (int) image.getRow(), colIndex = (int) image.getColumn();
			if (rowIndex >= beginRowIndex && rowIndex <= endRowIndex && data.get(rowIndex - beginRowIndex) != null) {
				ByteArrayInputStream is = new ByteArrayInputStream(image.getImageData());
				String fileName = "excel导入图片.jpg";
				AttachmentVo attachment = new AttachmentVo(fileName, is.available(), is);
				Map<Integer, String> rowData = data.get(rowIndex - beginRowIndex);
				if (colIndex >= beginColumnIndex && colIndex <= endColumnIndex && StringUtils.isBlank(rowData.get(colIndex))) {
					//rowData.put(colIndex, attachmentService.insertAttach(req, attachment));// 插入附件，返回附件ID值
				}
			}
		}
	}

	/***
	 * 工具方法，处理单元格的值
	 * @param cell
	 * @return
	 */
	public static void setStringCellValue(WritableSheet sheet,WritableCell cell,Object value) throws Exception {
		if(cell.getType() == CellType.LABEL){
			Label labelCell = (Label)cell;
			labelCell.setString(value+"");
		}else if(cell.getType() == CellType.NUMBER){
			NumberCell labelCell = (NumberCell)cell;
			int row = labelCell.getRow();
			int col = labelCell.getColumn();
			Label label = new Label(col, row, value+"");
			sheet.addCell(label);
		}
	}
	public static double getDouble(String str) {
		try {
			return Double.parseDouble(StringUtils.isEmpty(str)?"0":str.trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getInteger(String numberStr) {
		try {
			return Integer.parseInt(StringUtils.isEmpty(numberStr)?"0":numberStr.trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
}