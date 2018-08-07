package com.sczh.core.report.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.sczh.core.report.apply.Excel;
import com.sczh.core.report.apply.Excel.Sheet.Column;

public class ColumnTitleUtils {
	private final static int ROW_HEIGHT = 20;
	
	/**
	 * 生成EXCEL表单的列标题【支持复合表头】
	 * 
	 * @param wb
	 * @param sh
	 * @param sheet EXCEL表单配置信息
	 * @return 叶子节点列
	 */
	public static List<Column> generate(Workbook wb, Sheet sh, Excel.Sheet sheet) {
		// 标题单元格样式
		CellStyle tilteCellStyle = getCellStyle(wb);
		// 生成列标题
		List<Column> leafColumns = ColumnTitleUtils.writeTitles(wb, sh, tilteCellStyle, sheet.getColumns(), 0, null);
		// 合并列
		ColumnTitleUtils.mergeColumns(wb, sh);
		// 合并行
		ColumnTitleUtils.mergeRows(wb, sh);
		// 标题行与数据行的分隔线
		ColumnTitleUtils.writeDelimiter(wb, sh);
		// 冻结标题行
		ColumnTitleUtils.freezeTitle(wb, sh);
		// 释放资源
		System.gc();
		// 返回叶子节点列
		return leafColumns;
	}
	
	/**
	 * 生成列标题
	 * 
	 * @param wb
	 * @param sh
	 * @param tilteCellStyle
	 * @param columns
	 * @param rowIndex
	 * @param parentTitle
	 * @return
	 */
	private static List<Column> writeTitles(Workbook wb, Sheet sh, CellStyle tilteCellStyle, List<Column> columns, int rowIndex, String parentTitle) {
		List<Column> leafColumns = new ArrayList<Column>();// 叶子节点列
		Row lastRow = rowIndex == 0 ? null : sh.getRow(rowIndex - 1);
		Row row = sh.getRow(rowIndex);
		if(row == null){
			row = sh.createRow(rowIndex);
			row.setHeight((short) (ROW_HEIGHT * 20));// 行高
		}

		// 遍历当前行，获取行最多的单元格的个数，因为如果之前行之前有单元格是空的，会对列索引造成问题
		int currentMaxColumns = 0;
		for (int x = 0; x < rowIndex; x++) {
			Row rr = sh.getRow(x);
			if (rr.getPhysicalNumberOfCells() > currentMaxColumns) {
				currentMaxColumns = rr.getPhysicalNumberOfCells();
			}
		}

		// 查找上一级的列开始位置
		int _colIndex = -1;
		if (lastRow != null && parentTitle != null) {
			for (int i = 0; i < currentMaxColumns; i++) {
				if (lastRow.getCell(i) != null
				&& lastRow.getCell(i).getStringCellValue() != null
				&& lastRow.getCell(i).getStringCellValue().equals(parentTitle)) {
					_colIndex = i;
					break;
				}
			}
		}
		_colIndex = _colIndex == -1 ? 0 : _colIndex;

		//
		Iterator<Column> it = columns.iterator();
		while (it.hasNext()) {
			Column column = it.next();
			// 获取子节点数量
			int count = getSubNodesCount(column);
			// 没有子节点就是叶子节点，如果子节点为0，将count设置为1，是为了能够让下面的for循环执行一次，将标题写入
			if (count == 0) {
				count = 1;
			}
			// 根据子节点的数量，写入相应数量的父节点的名称，待完成后合并列
			for (int i = 0; i < count; i++) {
				Cell cell = row.createCell(_colIndex++);
				if (!column.isComplexColumn()) {
					leafColumns.add(column);
					// 设置列宽，列宽是根据叶子节点来的，其他地方定义不生效,列索引由于上面已经+1了，所以这里要减1
					sh.setColumnWidth(_colIndex - 1, column.getWidth() * 256);
				}

				cell.setCellStyle(getCellStyle(wb));
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(column.getTitle());
				// 判断是否写到最后一个父节点名称
				if (i == count - 1) {
					// 如果有子节点,递归写入子节点
					if (column.isComplexColumn()) {
						leafColumns.addAll(writeTitles(wb, sh, tilteCellStyle, column.getChildren(), rowIndex + 1, column.getTitle()));
					}
				}
			}
		}

		return leafColumns;
	}

	/**
	 * 获取当前节点的子节点数量
	 * 
	 * @param column
	 * @return
	 */
	private static int getSubNodesCount(Column column) {
		if (column.isComplexColumn()) {
			Iterator<Column> it = column.getChildren().iterator();
			int count = column.getChildren().size();
			while (it.hasNext()) {
				int c = getSubNodesCount(it.next());
				count += c > 0 ? c - 1 : c;
			}
			return count;
		} else {
			return 0;
		}
	}

	/**
	 * 合并行
	 * 
	 * @param wb
	 * @param sh
	 */
	private static void mergeRows(Workbook wb, Sheet sh) {
		int rowsCount = sh.getPhysicalNumberOfRows();// 行数
		int colsCount = sh.getRow(0).getPhysicalNumberOfCells();// 列数
		int rowSpan = 0;
		for (int c = 0; c < colsCount; c++) {
			rowSpan = 0;
			for (int r = rowsCount - 1; r > -1; r--) {
				Row row = sh.getRow(r);
				Cell cell = row.getCell(c);
				if (cell != null && r == rowsCount - 1) {
					break;
				} else if (cell != null && r != rowsCount - 1) {
					// 合并列
					sh.addMergedRegion(new CellRangeAddress(rowsCount - rowSpan - 1, rowsCount - 1, c, c));
					break;
				} else {
					// 行合并数+1
					rowSpan++;
				}
			}
		}
	}

	/**
	 * 合并列
	 * 
	 * @param wb
	 * @param sh
	 */
	private static void mergeColumns(Workbook wb, Sheet sh) {
		int rowsCount = sh.getPhysicalNumberOfRows();// 行数
		int colsCount = sh.getRow(0).getPhysicalNumberOfCells();// 列数
		int colSpan = 0;
		for (int r = 0; r < rowsCount; r++) {
			// 重置
			colSpan = 0;
			Row row = sh.getRow(r);
			for (int c = 0; c < colsCount; c++) {
				Cell cell1 = row.getCell(c);
				Cell cell2 = row.getCell(c + 1);
				if (cell1 == null) {// 如果当前单元格是空的，跳过，继续当前行的后一个单元格查找
					if (c == colsCount - 1) {
						break;
					} else {
						continue;
					}
				}
				if (cell2 == null) {// 说明当前行已经到最后一个单元格了
					if (colSpan >= 1) {// 判断colSpan是否大于等于1，大于1就要合并了
						// 合并行中连续相同的值的单元格
						sh.addMergedRegion(new CellRangeAddress(r, r, c - colSpan, c));
						break;
					}
				}
				if (cell1 != null && cell2 != null) {
					// 如果当前单元格和下一个单元格内容相同，那么colSpan加1
					if (cell1.getStringCellValue().equals(cell2.getStringCellValue())) {
						colSpan++;
					} else {
						// 如果当前单元格和下一个不等，那么判断colSpan是否大于等于1
						if (colSpan >= 1) {
							// 合并行中连续相同的值的单元格
							sh.addMergedRegion(new CellRangeAddress(r, r, c - colSpan, c));
							// 合并后重置colSpan
							colSpan = 0;
							continue;
						}
					}
				}
			}
		}
	}

	/**
	 * 标题行与数据行的分隔线
	 * 
	 * @param wb
	 * @param sh
	 */
	private static void writeDelimiter(Workbook wb, Sheet sh) {
		int rowsCount = sh.getPhysicalNumberOfRows();// 行数
		int colsCount = sh.getRow(0).getPhysicalNumberOfCells();// 列数
		Row row = sh.createRow(rowsCount);
		CellStyle cellStyle = wb.createCellStyle();
		// cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		for (int c = 0; c < colsCount; c++) {
			Cell cell = row.createCell(c);
			cell.setCellStyle(cellStyle);
		}
	}

	/**
	 * 冻结表头
	 * 
	 * @param wb
	 * @param sh
	 */
	private static void freezeTitle(Workbook wb, Sheet sh) {
		int rowsCount = sh.getPhysicalNumberOfRows();
		sh.createFreezePane(0, rowsCount - 1);
	}

	/**
	 * 标题单元格样式
	 * 
	 * @param wb
	 * @return
	 */
	private static CellStyle getCellStyle(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();// 创建单元格样式
		Font font = wb.createFont();// 创建字体
		font.setFontName("宋体");// 字体名
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 字体加粗
		font.setFontHeightInPoints((short) 12);// 字体大小
		cellStyle.setFont(font);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直居中
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER); // 水平居中
		return cellStyle;
	}
}