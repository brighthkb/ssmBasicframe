package com.sczh.core.utils.webservice.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sczh.core.config.ConfigUtils;

/**  
 * CXF服务端登录认证拦截器
 */
public class CxfServerLoginAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private static final Logger logger = LoggerFactory.getLogger(CxfServerLoginAuthInterceptor.class);
	
	//服务端在"调用之前"阶段拦截
	public CxfServerLoginAuthInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	/**
	 * 自定义拦截器需要实现handleMessage方法，该方法抛出Fault异常，
	 * <p>可以自定义异常继承Fault类， 也可以new Fault(Throwable t)</p>
	 */
	public void handleMessage(SoapMessage soap) throws Fault {
		logger.debug("服务端开始验证用户信息！");
		
		List<Header> headers = soap.getHeaders();
		//检查headers是否存在
		if(headers == null | headers.size()<1){
			throw new Fault(new IllegalArgumentException("找不到Header，无法验证用户信息"));
		}
		Element el = (Element)headers.get(0).getObject();
		
		//获取用户名
		NodeList users = el.getElementsByTagName("username");
		if(users.getLength()<1){
			throw new Fault(new IllegalArgumentException("找不到用户信息"));
		}
		String username = users.item(0).getTextContent().trim();
		
		//获取密码
		NodeList passwords = el.getElementsByTagName("password");
		if(passwords.getLength()<1){
			throw new Fault(new IllegalArgumentException("找不到密码信息"));
		}
		String password = passwords.item(0).getTextContent();
		
		//检查用户名和密码是否正确
		if(ConfigUtils.getConfig("ws.service.username").equals(username) 
		&& ConfigUtils.getConfig("ws.service.password").equals(password)){
			logger.debug("用户名密码正确允许访问");
		}else{
			throw new Fault(new IllegalArgumentException("用户名或密码不正确"));
		}
	}
}