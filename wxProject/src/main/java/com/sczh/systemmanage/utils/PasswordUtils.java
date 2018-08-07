package com.sczh.systemmanage.utils;

import org.apache.commons.lang3.StringUtils;

import com.sczh.core.config.ConfigUtils;
import com.sczh.core.utils.RandomUtils;
import com.sczh.core.utils.encrypt.Md5Utils;
import com.sczh.systemmanage.model.User;

  
/** 
 * 权限操作工具类
 * 
 */  
public final class PasswordUtils { 
	/**
     * 生成用户密文密码
     * @param user 用户信息
	 * @param password 明文密码
	 * @return
	 */
	public static void generatePassword(User user, String password){
		if(StringUtils.isBlank(password)){
			password = ConfigUtils.getConfig("defaultPassword");
		}
		
		String salt = RandomUtils.getRandomString(10);
		String encPassword  = Md5Utils.getMD5Str(password+salt, "UTF-8");//根据盐对明文密码MD5加密
		user.setSalt(salt);
		user.setPassword(encPassword);//设置为加密后的密码
	}

	/**
	 * 验证密码正确性
	 * @param user 用户信息
	 * @param password 明文密码
	 * @return
	 */
	public static boolean verifyPassword(User user, String password){
		String salt = user.getSalt();
		String encPassword  = Md5Utils.getMD5Str(password+salt, "UTF-8");//根据盐对明文密码MD5加密
		return StringUtils.equals(user.getPassword(), encPassword);//比较是否一致
	}
	
	public static void main(String[] args) {
		User user =  new User();
		generatePassword(user,"123456");
		System.out.println(user.getSalt());
		System.out.println(user.getPassword());
	}
}
