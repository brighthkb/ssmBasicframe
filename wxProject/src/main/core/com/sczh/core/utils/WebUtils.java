package com.sczh.core.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtils {	
	/**
	 * 返回json格式数据
	 * @param request
	 * @param response
	 * @param data
	 * @throws Exception
	 */
	public static void outputJson(HttpServletRequest request, HttpServletResponse response, Object data) throws Exception{
		response.reset();
		response.addHeader("Content-Type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(data));
		out.flush();
		out.close();
		out = null;
		data = null;
	}
	
	/**
	 * 获取HTTP请求的IP地址
	 * @return
	 */
	public static String getIpAddr() {
		HttpServletRequest request = getRequest();
		if(request==null) 
			return null;
		
        String ip = request.getHeader("x-forwarded-for");      
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
        	ip = request.getHeader("Proxy-Client-IP");      
        }      
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
        	ip = request.getHeader("WL-Proxy-Client-IP");      
        }      
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
        	ip = request.getRemoteAddr();      
        }     
       
        return ip.split(",")[0].trim();      
    }
	
	/**
	 * 通过spring web上下文获取HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
