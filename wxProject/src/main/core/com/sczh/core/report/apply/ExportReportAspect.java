package com.sczh.core.report.apply;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sczh.core.report.utils.ExportExcelUtils;
import com.sczh.core.utils.FileUtils;
import com.sczh.core.utils.WebUtils;

@Aspect
@Component
public class ExportReportAspect {
	private static final Logger logger = LoggerFactory.getLogger(ExportReportAspect.class);
	
	/**
	 * 定义一个切入点 
	 */
	@Pointcut("execution(public * com.sczh..controller.*Controller.*(..))")
	public void pointcut() {
	}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws Throwable {
	}
	
	@AfterReturning(pointcut = "pointcut()", returning = "result")
	public void afterReturning(Object result) throws Throwable {
	}
	
	@After("pointcut()")
	public void after(JoinPoint joinPoint) throws Throwable {
	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
	public void afterThrowing(Exception e) throws Throwable{
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object object = null;
		try {
			object = pjp.proceed();// 执行该方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//excel下载处理
		HttpServletRequest request = WebUtils.getRequest();
		HttpServletResponse response = (HttpServletResponse)request.getAttribute("HttpServletResponse");
		InputStream is = null;
		BufferedInputStream br =null;
		ServletOutputStream sout =null;
		String filePath = null;
		try{
			if(StringUtils.isNotBlank(request.getParameter("reportConfigId"))){
				/* 1、生成报表文件     */
				filePath = ExportExcelUtils.export(request.getParameter("reportConfigId"), object);
				if(StringUtils.isNotBlank(filePath)){
					object = null;
					/* 2、下载参数设置     */
					String downloadFileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
					response.reset();			
					//迅雷下载时，需要设置此参数。is.available()有可能为0
					//response.setContentLength(-1);
					response.setContentLength((int) new File(filePath).length());
					response.setContentType("application/x-msdownload");
					response.setHeader("Content-Disposition", "attachment; filename=" + new String(downloadFileName.getBytes("utf-8"), "ISO-8859-1"));
					
					/* 3、文件下载     */
					is = new FileInputStream(filePath);//文件二进制流
					br = new BufferedInputStream(is);
					byte[] buf = new byte[2048];
					int len = 0;
					sout = response.getOutputStream();	
					while((len = br.read(buf)) >0)
						sout.write(buf,0,len);
				}
			}
		}catch(Exception ex){
			logger.error("下载excel失败!" + ex.getMessage());
			try {
				response.sendError(404, "excel文件不存在，请与管理员联系!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}finally{
			request.removeAttribute("HttpServletResponse");
			request = null;
			response = null;
			try {
				if(sout != null){
					sout.flush();
					sout.close();
					sout = null;
				}
				if(br != null){
					br.close();
					br = null;
				}
				if(is != null){
					is.close();
					is = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			/* 4、删除文件     */
			if(StringUtils.isNotBlank(filePath)){
				FileUtils.delFile(filePath);
			}
		}
		
		return object;
	}
}