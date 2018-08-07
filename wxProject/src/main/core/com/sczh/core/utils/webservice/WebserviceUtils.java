package com.sczh.core.utils.webservice;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.sczh.core.utils.Collections3;

/**
 * 基于CXF实现的webservice client工具类，
 * @author chentao
 *
 */
public class WebserviceUtils {
    public static final int DEFAULT_CXF_CLIENT_CONNECT_TIMEOUT = 15 * 1000;  
    public static final int DEFAULT_CXF_CLIENT_RECEIVE_TIMEOUT = 15 * 1000;
	public static final String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    
    /**
     * 获取CXF客户端
     * 
     * @param wsdlUrl wsdl地址
     * @param outInterceptors CXF客户端 <b>输出</b> 拦截器
     * @param inInterceptors CXF客户端 <b>输入</b> 拦截器
     * @return org.apache.cxf.endpoint.Client
     */
	public static Client getClient(String wsdlUrl,
			List<? extends Interceptor<? extends Message>> outInterceptors,
			List<? extends Interceptor<? extends Message>> inInterceptors) {
		//工厂创建一个客户端对象
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient(wsdlUrl);

		// 添加CXF客户端输出拦截器
		if (!Collections3.isEmpty(outInterceptors)) {
			client.getOutInterceptors().addAll(outInterceptors);
		}
		// 添加CXF客户端输入拦截器
		if (!Collections3.isEmpty(inInterceptors)) {
			client.getInInterceptors().addAll(inInterceptors);
		}

		// webservice参数设置
		HTTPConduit http = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setConnectionTimeout(DEFAULT_CXF_CLIENT_CONNECT_TIMEOUT);// 设置连接服务超时时间
		httpClientPolicy.setAllowChunking(false);
		httpClientPolicy.setReceiveTimeout(DEFAULT_CXF_CLIENT_RECEIVE_TIMEOUT);// 设置接收服务后反馈结果超时时间
		http.setClient(httpClientPolicy);

		return client;
	}
	
	/**
	 * 获取CXF客户端
	 * 
	 * @param wsdlUrl wsdl地址
	 * @return org.apache.cxf.endpoint.Client
	 */
	public static Client getClient(String wsdlUrl) {
		return getClient(wsdlUrl, null, null);
	}
	
	/**
	 * 关闭CXF客户端
	 */
	public static void closeClient(Client client) {
		if (client != null) {
			client.destroy();
			client = null;
		}
	}
	
	/**
	 * 调用webservice服务
	 * 
	 * @param wsdlUrl wsdl地址
	 * @param outInterceptors CXF客户端 <b>输出</b> 拦截器
     * @param inInterceptors CXF客户端 <b>输入</b> 拦截器
	 * @param operationName 服务方法
	 * @param handler 返回结果数据处理器
	 * @param params 服务方法的参数
	 * @return
	 */
	public static <T> T callService(String wsdlUrl,
			List<? extends Interceptor<? extends Message>> outInterceptors,
			List<? extends Interceptor<? extends Message>> inInterceptors,
			String operationName, Handler<T> handler, Object... params) {
		Client client = null;
		try {
			client = getClient(wsdlUrl, outInterceptors, inInterceptors);
			//问题：CXF动态客户端在处理此问题时，会报No operation was found with the name的异常 ，因为 WebService接口和实现类的namespace不同。
			//Object[] result = client.invoke(operationName, params);
			//解决方式1：静态指定到接口类所在包 
			//QName opName = new QName("http://service.ws.systemmanage.sczh.com/", operationName);
			//解决方式2：动态指定到接口类所在包
			Endpoint endpoint = client.getEndpoint();
			QName opName = new QName(endpoint.getService().getName().getNamespaceURI(), operationName);
			BindingInfo bindingInfo = endpoint.getEndpointInfo().getBinding();
			if (bindingInfo.getOperation(opName) == null) {
				for (BindingOperationInfo operationInfo : bindingInfo.getOperations()) {
					if (operationName.equals(operationInfo.getName().getLocalPart())) {
						opName = operationInfo.getName();
						break;
					}
				}
			}
			Object[] result = client.invoke(opName, params);
			
			return handler.handle(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeClient(client);
		}
	}

	/**
	 * 调用webservice服务
	 * 
	 * @param wsdlUrl wsdl地址
	 * @param operationName 服务方法
	 * @param handler 返回结果数据处理器
	 * @param params 服务方法的参数
	 * @return
	 */
	public static <T> T callService(String wsdlUrl, 
			String operationName, Handler<T> handler, Object... params) {
		return callService(wsdlUrl, null, null, operationName, handler, params);
	}

	/**
	 * 结果数据处理器
	 */
	public interface Handler<T> {
		public T handle(Object[] result);
	}
}
