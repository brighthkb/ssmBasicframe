package com.sczh.core.utils.excel;

import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sczh.core.utils.AttachmentUtils;
import com.sczh.core.utils.AttachmentUtils.AttachmentVo;
import com.sczh.core.utils.StringUtils;

public class ExcelUtils {
	private static Logger log = LoggerFactory.getLogger(ExcelUtils.class);
	
	/**
	 * @param fileName
	 * @return Excel2003:返回1 ；Excel2007:返回2 ； 其它返回-1
	 */
	public static int verifyExcelVersion(String fileName) {
		if(StringUtils.isNotBlank(fileName)){
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			if(StringUtils.equalsIgnoreCase(".xls", fileType)){
				return 1;//Excel2003
			}
			if(StringUtils.equalsIgnoreCase(".xlsx", fileType)){
				return 2;//Excel2007
			}
		}
		
		return -1;//其它文件类型
	}
	
	public static class Excel{
		private AttachmentVo attachment;
		private int excelVersion;
		private Object workbook; //excel工作簿
	
		public Excel(AttachmentVo attachment) throws Exception{
			this.attachment = attachment;
			this.excelVersion = ExcelUtils.verifyExcelVersion(this.attachment.getFilePath());
			if(this.excelVersion==1){
				log.info("excel解析引擎JXL-2003");
				this.workbook = ReadExcel2003Util.getWorkbook(this.attachment.getInputStream());
			}else if(this.excelVersion==2){
				log.info("excel解析引擎POI-2007");
				this.workbook = ReadExcel2007Util.getWorkbook(this.attachment.getInputStream());
			}else{
				throw new Exception("excel导入解析不支持其它文件类型");
			}
		}
		
		//获取excel工作表单对象
		private Object getSheet(String sheetName) throws Exception{			
			if(1 == this.excelVersion){
				return ReadExcel2003Util.getSheet((Workbook)workbook, sheetName);
			}else{
				return ReadExcel2007Util.getSheet((XSSFWorkbook)workbook, sheetName);				
			}
		}

		//获取excel表单数据
		private List<Map<Integer,String>> getSheetData(Object sheet,
				int beginRowIndex, int endRowIndex, int beginColumnIndex, int endColumnIndex) throws Exception{
			if(1 == this.excelVersion){
				return ReadExcel2003Util.getData((Sheet)sheet, 
						beginRowIndex, endRowIndex,beginColumnIndex,endColumnIndex);				
			}else{
				return ReadExcel2007Util.getData((XSSFSheet)sheet, 
						beginRowIndex, endRowIndex,beginColumnIndex,endColumnIndex);
			}
		}
		
		//获取excel表单数据
		public List<Map<Integer,String>> getSheetData(String sheetName) throws Exception{
			//获取表单
			Object sheet = this.getSheet(sheetName);
			
			int beginRowIndex=0 , endRowIndex=0, beginColumnIndex=0, endColumnIndex=0;			
			if(1 == this.excelVersion){
				endRowIndex = ((Sheet)sheet).getRows()-1;					
			}else{
				endRowIndex = ((XSSFSheet)sheet).getLastRowNum();//最后一行。有效行数(不包括空行)：getPhysicalNumberOfRows()-1;
			}
			if(1 == this.excelVersion){
				endColumnIndex = ((Sheet)sheet).getColumns()-1;					
			}else{
				endColumnIndex = ((XSSFSheet)sheet).getRow(0).getLastCellNum();//第一行的最后一列。有效列数(不包括空列)：getPhysicalNumberOfCells()-1;
			}
			
			return this.getSheetData(sheet, beginRowIndex, endRowIndex, beginColumnIndex, endColumnIndex);
		}
				
		//获取excel表单数据
		public List<Map<Integer,String>> getSheetData(String sheetName, int beginRowIndex, int endColumnIndex) throws Exception{
			//获取表单
			Object sheet = this.getSheet(sheetName);
			
			int endRowIndex=beginRowIndex, beginColumnIndex=0;			
			if(1 == this.excelVersion){
				endRowIndex = ((Sheet)sheet).getRows()-1;					
			}else{
				endRowIndex = ((XSSFSheet)sheet).getLastRowNum();//最后一行。有效行数(不包括空行)：getPhysicalNumberOfRows()-1;
			}
			
			return this.getSheetData(sheet, beginRowIndex, endRowIndex, beginColumnIndex, endColumnIndex);
		}
		
		//获取excel表单数据
		public List<Map<Integer,String>> getSheetData(String sheetName,
				int beginRowIndex, int endRowIndex, int beginColumnIndex, int endColumnIndex) throws Exception{		
			//获取表单
			Object sheet = this.getSheet(sheetName);
			
			return this.getSheetData(sheet, beginRowIndex, endRowIndex, beginColumnIndex, endColumnIndex);
		}
		
		//获取excel表单数据
		public List<Map<Integer,String>> getSheetData(String sheetName, Map<String, Object> sheetConfig) throws Exception{
			//获取表单
			Object sheet = this.getSheet(sheetName);
			
			//开始扫描行号
			int beginRowIndex = NumberUtils.toInt(StringUtils.asString(sheetConfig.get("BEGIN_SCAN_ROWNUM")))-1;
			
			//结束扫描行号
			int endRowIndex = beginRowIndex;
			if(StringUtils.isBlank(sheetConfig.get("END_SCAN_ROWNUM"))){
				if(1 == this.excelVersion){
					endRowIndex = ((Sheet)sheet).getRows()-1;					
				}else{
					endRowIndex = ((XSSFSheet)sheet).getLastRowNum();//有效行数：getPhysicalNumberOfRows()-1;
				}
			}else{
				endRowIndex = NumberUtils.toInt(StringUtils.asString(sheetConfig.get("END_SCAN_ROWNUM")))-1;
			}
			if(endRowIndex < beginRowIndex){
				throw new Exception("excel表单配置错误"); 
			}
			
			//开始扫描列号
			int beginColumnIndex = 0;
			if(StringUtils.isBlank(sheetConfig.get("BEGIN_SCAN_COLNUM"))){
				beginColumnIndex = 0;
			}else{
				beginColumnIndex = NumberUtils.toInt(StringUtils.asString(sheetConfig.get("BEGIN_SCAN_COLNUM")))-1;
			}
			
			//结束扫描列号
			int endColumnIndex = NumberUtils.toInt(StringUtils.asString(sheetConfig.get("END_SCAN_COLNUM")))-1;
			if(endColumnIndex < beginColumnIndex){
				throw new Exception("excel表单配置错误"); 
			}
			
			return this.getSheetData(sheet, beginRowIndex, endRowIndex, beginColumnIndex, endColumnIndex);
		}
	}
	
	public static void destroy(Excel excel){
		if(excel==null)
			return;
		
		if(excel.attachment!=null){
			AttachmentUtils.destroy(excel.attachment);
			excel.attachment=null;
		}
		
		if(excel.workbook!=null){
			if(1 == excel.excelVersion){
				((Workbook)excel.workbook).close();
			}
			excel.workbook= null;
		}
		
		excel.excelVersion=-1;
	}
	
	/**
	 * 用于将Excel表格中列号字母转成列索引，从1对应A开始
	 * 
	 * @param column 列号
	 * @return 列索引
	 */
	public static int columnToIndex(String column) {
		if (!column.matches("[A-Z]+")) {
			try {
				throw new Exception("Invalid parameter");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int index = 0;
		char[] chars = column.toUpperCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			index += ((int) chars[i] - (int) 'A' + 1)
					* (int) Math.pow(26, chars.length - i - 1);
		}
		
		return index;
	}

	/**
	 * 用于将excel表格中列索引转成列号字母，从A对应1开始
	 * 
	 * @param index 列索引
	 * @return excel列号
	 */
	public static String indexToColumn(int index) {
		if (index <= 0) {
			try {
				throw new Exception("Invalid parameter");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		index--;
		String column = "";
		do {
			if (column.length() > 0) {
				index--;
			}
			column = ((char) (index % 26 + (int) 'A')) + column;
			index = (int) ((index - index % 26) / 26);
		} while (index > 0);
		
		return column;
	}
}
