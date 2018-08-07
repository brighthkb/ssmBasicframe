package com.sczh.core.report.apply;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.sczh.core.utils.XmlUtils;

/**
 * 报表导出管理器
 */
public class ExportReportManager {
	private static final Logger logger = LoggerFactory.getLogger(ExportReportManager.class);
	private static final Map<String, Excel> reportConfig = new HashMap<String, Excel>();
	private List<String> xmlFilePaths = new ArrayList<String>();
	
	//Bean工厂方法，初始化并加载EXCEL报表配置
	public void init() throws Exception {
		for (int j = 0; j < xmlFilePaths.size(); j++) {
			try {
				ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
				Resource[] resources = patternResolver.getResources(xmlFilePaths.get(j));
				if (resources != null && resources.length > 0) {
					for (int i = 0; i < resources.length; i++) {
						InputStream in = null;
						Reader reader = null;
						BufferedReader bufferedReader = null;
						try {
							Resource resource = resources[i];
							if (resource.exists()) {
								in = resource.getInputStream();
								reader = new InputStreamReader(in, "utf-8");
								bufferedReader = new BufferedReader(reader);
								String readLine = null;
								StringBuffer sb = new StringBuffer("");
								while ((readLine = bufferedReader.readLine()) != null) {
									sb.append(readLine).append("\r\n");
								}
								this.parseXml(sb.toString());
							} else {
								logger.error("资源文件不存在!");
							}
						} catch (Exception e) {
							logger.error(e.getMessage());
							e.printStackTrace();
						} finally {
							if (bufferedReader != null) {
								bufferedReader.close();
							}
							if (reader != null) {
								reader.close();
							}
							if (in != null) {
								in.close();
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("初始化加载报表配置失败！");
				e.printStackTrace();
			}
		}
	}
	
	//解析xml
	private void parseXml(String xmlStr) throws Exception{
		if(StringUtils.isBlank(xmlStr)){
			return;
		}
		
		try {
			Excel excelConfig = XmlUtils.xml2Object(xmlStr, Excel.class);
			//缓存报表配置【没有验证EXCEL表单名称重复】【没有验证EXCEL表单内的列名称重复】
			reportConfig.put(excelConfig.getId(), excelConfig);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	/**
	 * 获取导出报表配置
	 * 
	 * @param excelId
	 * @return
	 */
	public static Excel getReportConfig(String excelId) {
		return reportConfig.get(excelId);
	}

	public List<String> getXmlFilePaths() {
		return xmlFilePaths;
	}

	public void setXmlFilePaths(List<String> xmlFilePaths) {
		this.xmlFilePaths = xmlFilePaths;
	}
}