package com.sczh.systemmanage.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
public class IllegalCharacterFilter implements Filter {
	private String[] characterParams = null;
	private boolean OK = true; 
	private final static int MAX_LENGTH = 7000;
	private String[] excludedPageArray = null;   
	public void destroy() {   
		// TODO Auto-generated method stub   
	} 


	  /** 
	  * 此程序块主要用来解决参数带非法字符等过滤功能   */ 
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException, ServletException { 
		  HttpServletRequest servletrequest = (HttpServletRequest) request; 
		  HttpServletResponse servletresponse = (HttpServletResponse) response; 
		  boolean status = false; 
		  java.util.Enumeration params = request.getParameterNames();
		  String param = "";
		  String paramValue = ""; 
		  servletresponse.setContentType("text/html");   servletresponse.setCharacterEncoding("utf-8");   boolean isExcludedPage = false; 
		  // 请求的uri 
		  HttpServletRequest request1 = (HttpServletRequest) request;   String uri = request1.getRequestURI(); 
		  for (String page : excludedPageArray) {// 判断是否在过滤url之外   
			  if (uri.indexOf(page) > 0) {
				  isExcludedPage = true;
				  break; 
			  } 
		  } 
		  while (params.hasMoreElements()) {
			  param = (String) params.nextElement(); 
			  String[] values = request.getParameterValues(param);
			  paramValue = ""; 
			  if (OK) {// 过滤字符串为0个时 不对字符过滤
				  for (int i = 0; i < values.length; i++)
					  paramValue = paramValue + values[i];
				  for (int i = 0; i < characterParams.length; i++)
					  if (paramValue.length() > MAX_LENGTH || paramValue.indexOf(characterParams[i]) >= 0 || paramValue.toLowerCase().indexOf(characterParams[i]) >= 0) { 
						  // System.out.println(param + "=" + paramValue + ";"); 
						  status = true;       break; 
					  } 
		
				  if (status)      
					  break; 
			  	} 
		  } 
	  // System.out.println(param+"="+paramValue+";");   
		  if (isExcludedPage) {// 在过滤url之外    
			  arg2.doFilter(request, response); 
	  	} else {// 不在过滤url之外，判断session是否存在    
	  		if (status) {     
	  			PrintWriter out = servletresponse.getWriter(); 
	  			out.print("<script language='javascript'>alert(\"对不起！您输入内容含有非法字符或长度已超过7000字符!\");" 
	  					+ "window.history.go(-1);</script>");   
	  		} else     
	  			arg2.doFilter(request, response); 
	  
	  	} 
	  }   
	 public void init(FilterConfig config) throws ServletException {   
		 if (config.getInitParameter("characterParams").length() < 1)    
			 OK = false; 
		 else {  
			 this.characterParams = config.getInitParameter("characterParams").split(",");//获取过滤的特殊字符    
			 this.excludedPageArray = config.getInitParameter("excludedPages").split(",");//获取排除过滤的特殊页面
		 } 
	 } 
}