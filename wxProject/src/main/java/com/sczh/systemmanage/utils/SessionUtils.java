package com.sczh.systemmanage.utils;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.sczh.core.utils.WebUtils;
import com.sczh.systemmanage.model.User;
  
/** 
 * 会话操作工具类
 * 
 */  
public final class SessionUtils {
	private static final Logger logger = LoggerFactory.getLogger(SessionUtils.class);
	
	private final static String SYS_SESSION_REL_INFO = "sys_session_rel_info";//系统会话相关信息
	public final static String SESSION_USER_KEY = "session_user_key";//用户信息KEY
	public final static String SESSION_USER_LOGIN_TIME_KEY = "session_user_login_time_key";//用户登陆时间KEY
	public final static String SESSION_USER_PERMISSION_KEY = "session_user_permission_key";//用户权限KEY
	public final static String SESSION_USER_MENU_TREE_KEY = "session_user_menu_tree_key";//用户菜单树KEY
    
	/**
     * 判断是否登录
     */
	public static boolean isLogin(HttpServletRequest request){
		Map<String, Object> relInfo = getSysSessionRelInfo(request);
		return relInfo!=null && relInfo.get(SESSION_USER_KEY)!=null;
	}
	
	 /**
     * 获取系统会话相关信息
     */
	@SuppressWarnings("unchecked")
	public synchronized static Map<String, Object> getSysSessionRelInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> relInfo = (Map<String, Object>)session.getAttribute(SYS_SESSION_REL_INFO);
		if(relInfo == null){
			relInfo = Maps.newConcurrentMap();
			session.setAttribute(SYS_SESSION_REL_INFO, relInfo);
		}
		
		return relInfo;
	}
	
	/**
     * 删除系统会话相关信息
     */
	public static void removeLoginInfo(HttpServletRequest request){
		//清空系统会话相关信息
		Map<String, Object> relInfo = getSysSessionRelInfo(request);
		relInfo.clear();
		relInfo = null;
		//再从session移出键值
		HttpSession session = request.getSession();
		session.removeAttribute(SYS_SESSION_REL_INFO);
	}

	/**
     * 添加会话属性值
     * @param name
     * @param value
     */
	public static void setSessionAttr(HttpServletRequest request, String key, Object value){
		Map<String, Object> relInfo = getSysSessionRelInfo(request);
		relInfo.put(key, value);
	}
	
	/**
     * 获取会话属性值
     * @param name
     * @param value
     */
	public static Object getSessionAttr(HttpServletRequest request, String key){
		Map<String, Object> relInfo = getSysSessionRelInfo(request);
		return relInfo.get(key);
	}
	
	/**
     * 获取当前登录用户id
     */
	public static String getCurrUserId(){
		try {
			return getCurrUser().getId();
		} catch (Exception e) {
			logger.error("获取当前登录用户id失败！");
		}
		
		return null;
	}
	
	/**
     * 获取当前登录用户信息
     */
	public static User getCurrUser(){
		try {
			HttpServletRequest request = WebUtils.getRequest();  
			Map<String, Object> relInfo = getSysSessionRelInfo(request);
			return (User)relInfo.get(SESSION_USER_KEY);
		} catch (Exception e) {
			logger.error("获取当前登录用户信息失败！");
		}
		
		return null;
	}

	/** 
	 * 设置当前用户会话信息
	 */
	public static void setupCurrUserSessionInfo(HttpServletRequest request, User user) {
		setSessionAttr(request, SESSION_USER_KEY, user);
		setSessionAttr(request, SESSION_USER_LOGIN_TIME_KEY, new Date());
		setSessionAttr(request, SESSION_USER_PERMISSION_KEY, PermissionUtils.getUserPermission(user.getId()));
		setSessionAttr(request, SESSION_USER_MENU_TREE_KEY, PermissionUtils.getUserMenuTree(user.getId()));
	}
}
