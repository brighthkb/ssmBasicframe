package com.sczh.core.utils.webservice.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**  
 * CXF客户端登录请求拦截器
 */
public class CxfClientLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private static final Logger logger = LoggerFactory.getLogger(CxfClientLoginInterceptor.class);
	
	private String usernameField = "username";
	private String passwordField = "password";
	private String username;
	private String password;
	
	//客户端在"准备发送"阶段拦截
	public CxfClientLoginInterceptor(String username, String password) {
		super(Phase.PREPARE_SEND);
		
		this.username = username;
		this.password = password;
	}
	
	public CxfClientLoginInterceptor(String usernameField, String username, String passwordField, String password) {
		this(username, password);
		
		this.usernameField = usernameField;
		this.passwordField = passwordField;
	}

	/* (non-Javadoc)
	 * @see org.apache.cxf.interceptor.Interceptor#handleMessage(org.apache.cxf.message.Message)
	 */
	@Override
	public void handleMessage(SoapMessage soap) throws Fault {
		logger.debug("客户端添加用户名和密码！");
		
		List<Header> headers = soap.getHeaders();
		
		Document doc = DOMUtils.createDocument();
		Element auth = doc.createElement("authrity");
		
		Element username = doc.createElement(this.usernameField);
		username.setTextContent(this.username);
		auth.appendChild(username);
		
		Element password = doc.createElement(this.passwordField);
		password.setTextContent(this.password);
		auth.appendChild(password);
		
		//doc.appendChild(auth);
		headers.add(0, new Header(new QName("tiamaes"), auth));
	}
}
