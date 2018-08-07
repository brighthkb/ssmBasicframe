package com.sczh.core.utils;

import org.apache.commons.lang3.ObjectUtils;

@SuppressWarnings("all")
public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	
	/**
	 * 对象转换成字符串
	 * @param obj 最好是object override toString()方法
	 * @return
	 */
	public static String asString(Object obj){
		return asString(obj, "");
	}
	
	
	/**
	 * 对象转换成字符串
	 * @param obj 最好是object override toString()方法
	 * @param defaultValue
	 * @return
	 */
	public static String asString(Object obj,String defaultValue){
		if(isBlank(ObjectUtils.toString(obj))) 
			return defaultValue;
		
		return ObjectUtils.toString(obj);
	}
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj){
		return isBlank(ObjectUtils.toString(obj));
	}
	
	/**
	 * 判断对象是否不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlank(Object obj){
		return isNotBlank(ObjectUtils.toString(obj));
	}
	
	/**
	 * sql转义
	 * @param str
	 * @return
	 */
	public static String escapeSql(String str) {
        return isNotBlank(str) ? replace(str, "'", "''") : null;
    }
}