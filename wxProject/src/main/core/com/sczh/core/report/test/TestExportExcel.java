package com.sczh.core.report.test;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.sczh.core.report.apply.Excel;
import com.sczh.core.report.apply.Excel.Sheet.Column;
import com.sczh.core.report.apply.ExportReportManager;
import com.sczh.core.report.utils.ColumnTitleUtils;
import com.sczh.core.utils.XmlUtils;

public class TestExportExcel {
	/** 测试--生成EXCEL表单的列标题 */
	private static void testColumnTitle(Excel excel) throws Exception {
		Excel.Sheet sheet = excel.getSheets().get(0);
		Workbook wb = new SXSSFWorkbook(100);// 保持在内存中100行，超出行数就被刷到磁盘
		Sheet sh = wb.createSheet("测试复合表头");
		List<Column> leafColumns = ColumnTitleUtils.generate(wb, sh, sheet);
		// 保存excel文件
		FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test3.xlsx");
		wb.write(out);
		out.flush();
		out.close();
		// 叶子节点列
		System.out.println(leafColumns);
	}

	public static void main(String[] args) throws Exception {
		/* 加载EXCEL配置文件 */
		//String filePath = "file:E:\\workspace\\myeclipse10.7\\tccpap\\src\\main\\core\\com\\sczh\\core\\report\\test\\testExportExcelConfig.xml";
		String filePath = "classpath:com/sczh/core/report/test/testExportExcelConfig.xml";
		ExportReportManager report = new ExportReportManager();
		report.getXmlFilePaths().add(filePath);
		report.init();
		/* 生成EXCEL表单的列标题 */
		testColumnTitle(ExportReportManager.getReportConfig("testlist"));
		/* 根据EXCEL配置对象生成XML字符串 */
		System.out.println(XmlUtils.object2Xml(ExportReportManager.getReportConfig("testlist")));	
	}
}