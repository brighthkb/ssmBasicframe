package com.sczh.core.config;

/** 
 * 全局配置类
 * @author chentao
 * @since 3.2.1
 *  */
public class ConfigUtils {
	
	/** 属性文件加载对象 */
	private static PropertiesLoader propertiesLoader;
	
	private static String configFilePath = "application.properties";
	
	/** 获取String类型的属性配置，如果都為Null则抛出异常。*/
	public static String getConfig(String key) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader(configFilePath);
		}
		
		return propertiesLoader.getProperty(key);
	}
	
	/** 获取String类型的属性配置，如果都為Null則返回Default值。 */
	public static String getConfig(String key, String defaultValue) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader(configFilePath);
		}
		
		return propertiesLoader.getProperty(key, defaultValue);
	}
}
