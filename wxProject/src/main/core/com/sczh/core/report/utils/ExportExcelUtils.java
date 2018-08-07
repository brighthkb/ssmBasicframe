package com.sczh.core.report.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sczh.core.report.apply.Excel;
import com.sczh.core.report.apply.Excel.Sheet.Column;
import com.sczh.core.report.apply.ExportReportManager;
import com.sczh.core.web.dto.PagingResult;

/**
 * 导出excel报表工具类
 * 
 */
public class ExportExcelUtils {
	private static Logger log = LoggerFactory.getLogger(ExportExcelUtils.class);

	/**
	 * 导出EXCEL报表
	 * 
	 * @param excelId
	 * @param data
	 * @return
	 */
	public static String export(String excelId, final Object data) {
		final Excel excel = ExportReportManager.getReportConfig(excelId);
		if (data instanceof Handler) {
			return export(excel, (Handler) data);
		} else {
			return export(excel, new Handler() {
				@Override
				public String getSheetName() {
					return excel.getSheets().get(0).getTitle();
				}

				@Override
				public Object getData() {
					return data;
				}
			});
		}
	}

	/**
	 * 导出EXCEL报表
	 * 
	 * @param excelId
	 * @param sheetName
	 * @param data
	 * @return
	 */
	public static String export(String excelId, final String sheetName, final Object data) {
		final Excel excel = ExportReportManager.getReportConfig(excelId);
		return export(excel, new Handler() {
			@Override
			public String getSheetName() {
				return sheetName;
			}

			@Override
			public Object getData() {
				return data;
			}
		});
	}
	
	/**
	 * 导出EXCEL报表
	 * 
	 * @param excelId
	 * @param handlers
	 * @return
	 */
	public static String export(String excelId, Handler... handlers) {
		final Excel excel = ExportReportManager.getReportConfig(excelId);
		return export(excel, handlers);
	}
	

	/**
	 * 导出EXCEL报表
	 * 
	 * @param excel
	 * @param handlers
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized static String export(Excel excel, Handler... handlers) {
		String filePath = generateFilePath(excel.getTitle());
		FileOutputStream out = null;
		try {
			// 创建EXCEL工作簿
			Workbook wb = new SXSSFWorkbook(100);// 保持在内存中100行，超出行数就被刷到磁盘
			CellStyle leftCellStyle = getCellStyle(wb, "left"), centerCellStyle = getCellStyle(wb, "center"), rightCellStyle = getCellStyle(wb, "right");
			// EXCEL表单处理器
			for (Handler handler : handlers) {
				// 获取EXCEL表单对应的业务数据
				Object data = handler.getData();
				// 只支持PagingResult或List格式的数据
				List<Object> rowDataList = new ArrayList<>();
				if (data != null && data instanceof PagingResult) {
					rowDataList = ((PagingResult<Object>) data).getRows();
				} else if (data != null && data instanceof List) {
					rowDataList = (List<Object>) data;
				} else if(("oversize").equals(data)){
					return "oversize";
				}
				// 获取EXCEL表单名称
				String sheetName = handler.getSheetName();
				// 获取EXCEL表单配置
				Excel.Sheet sheet = getSheetConfig(excel, sheetName);
				if (sheet == null || sheet.getColumns() == null || sheet.getColumns().isEmpty()) {
					break;
				}

				/**************** 开始导出数据到EXCEL表单 ****************/
				// 创建EXCEL表单
				Sheet sh = wb.createSheet(sheetName);				
				// 生成EXCEL表单的列标题
				List<Column> leafColumns = ColumnTitleUtils.generate(wb, sh, sheet);
				// 数据行
				int rowIndex = sh.getPhysicalNumberOfRows()-1;
				for (Iterator<Object> iterator = rowDataList.iterator(); iterator.hasNext();) {
					Object rowData = iterator.next();
					Row row = sh.createRow(rowIndex);
					int columnIndex = 0;
					for (Iterator<Excel.Sheet.Column> iterator2 = leafColumns.iterator(); iterator2.hasNext();) {
						Excel.Sheet.Column column = iterator2.next();
						Cell dataCell = row.createCell(columnIndex);
						dataCell.setCellStyle("center".equalsIgnoreCase(column.getAlign()) ? centerCellStyle : ("right".equalsIgnoreCase(column.getAlign()) ? rightCellStyle : leftCellStyle));
						dataCell.setCellType(Cell.CELL_TYPE_STRING);
						dataCell.setCellValue(getValue(rowData, column.getFieldName(), column.getFormatMethodName()));
						columnIndex++;
					}
					rowIndex++;
				}
				
				//释放资源
				data = null;
				rowDataList.clear();
				rowDataList = null;
				sheet = null;
				System.gc();
			}
			
			// 保存excel文件，并返回文件路径
			out = new FileOutputStream(filePath);
			wb.write(out);
			return filePath;
		} catch (Exception e) {
			log.debug("导出EXCEL报表异常！");
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * EXCEL表单处理器
	 */
	public interface Handler {
		/**
		 * 获取EXCEL表单名称
		 * 
		 * @return
		 */
		public String getSheetName();

		/**
		 * 获取EXCEL表单对应的业务数据【只支持PagingResult或List格式的数据】
		 * 
		 * @return
		 */
		public Object getData();
	}
	
	/**
	 * 获取EXCEL表单配置
	 * 
	 * @param excel
	 * @param sheetName
	 * @return
	 */
	private static Excel.Sheet getSheetConfig(Excel excel, String sheetName) {
		for (Excel.Sheet sheet : excel.getSheets()) {
			if (StringUtils.equals(sheet.getTitle(), sheetName)) {
				return sheet;
			}
		}

		return null;
	}
	
	/**
	 * 生成EXCEL文件名【包含目录路径】
	 * 
	 * @param excelTitle
	 * @return
	 */
	private static String generateFilePath(String excelTitle) {
		String dirPath = System.getProperty("java.io.tmpdir") + File.separator;
		String fileName = excelTitle + "_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".xlsx";
		return dirPath + fileName;
	}

	/**
	 * 数据单元格样式
	 * 
	 * @param wb
	 * @param align
	 * @return
	 */
	private static CellStyle getCellStyle(Workbook wb, String align) {
		CellStyle cellStyle = wb.createCellStyle();// 创建单元格样式
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直居中
		if ("center".equalsIgnoreCase(align)) {
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER); // 水平居中
		} else if ("right".equalsIgnoreCase(align)) {
			cellStyle.setAlignment(CellStyle.ALIGN_RIGHT); // 水平居右
		} else {
			cellStyle.setAlignment(CellStyle.ALIGN_LEFT); // 默认水平居左
		}
		return cellStyle;
	}

	/**
	 * 获取对象的值【注：支持级联取值】
	 * 
	 * @param rowData
	 * @param fieldName
	 * @param formatMethodName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String getValue(Object rowData, String fieldName, String formatMethodName) {
		try {
			if (rowData != null && StringUtils.isNotBlank(fieldName)) {
				Object val = rowData;
				String[] fieldNames = fieldName.split("\\.");
				for (int i = 0; i < fieldNames.length && val != null; i++) {
					if (val instanceof Map) {
						val = ((Map<String, Object>) val).get(fieldNames[i]);
					} else {// bean
						val = FieldUtils.readField(val, fieldNames[i], true);
					}
				}

				if (val != null && StringUtils.isNotBlank(formatMethodName)) {
					val = MethodUtils.invokeStaticMethod(ColumnFormatUtils.class, formatMethodName, val, rowData);
				}

				return ObjectUtils.toString(val, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}