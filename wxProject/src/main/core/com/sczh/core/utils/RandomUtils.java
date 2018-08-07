package com.sczh.core.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
* 随机值工具类
* @date 2014.10.28
* @author chentao
*/
public class RandomUtils {
	
	//获取length长度的随机字符串
	public static String getRandomString(int length) {
	    StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"); 
	    StringBuffer sb = new StringBuffer(); 
	    Random r = new Random(); 
	    int range = buffer.length(); 
	    for (int i = 0; i < length; i ++) { 
	        sb.append(buffer.charAt(r.nextInt(range))); 
	    } 
	    return sb.toString(); 
	}
	
	// 获取随机长度的随机字符串
	public static String getRandomString() {	    
	    return getRandomString(getRandomInt(100)); 
	}
	
	// 获取随机整数
	public static int getRandomInt(int maxValue) {
		// Math.random() 获取0～1之间的double类型数值
		int randomInt = (int)(Math.random()*maxValue); // 获取0～maxValue之间的整数
		
		return randomInt;
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		SecureRandom random = new SecureRandom();
		return Math.abs(random.nextLong());
	}
}
