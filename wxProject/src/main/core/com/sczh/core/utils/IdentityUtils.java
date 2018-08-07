package com.sczh.core.utils;

import java.util.UUID;


/**
 * 封装各种生成唯一性ID算法的工具类.
 * 
 */
public final class IdentityUtils {

	

	/**
	 * 封装JDK自带的UUID
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 封装JDK自带的UUID, 中间无"-"分割.
	 */
	public static String uuid2() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	
}
