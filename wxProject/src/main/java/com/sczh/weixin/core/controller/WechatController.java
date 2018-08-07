package com.sczh.weixin.core.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sczh.core.config.ConfigUtils;
import com.sczh.weixin.core.base.service.impl.WechatService;
import com.sczh.weixin.core.util.SignUtil;
/**
 * 微信请求接受控制类
 * @author tjun
 *
 */
@Controller
@RequestMapping("/weinxin/wechatcontroller")
public class WechatController {
	@Autowired
	private WechatService wechatService;
	private static final Logger logger = LoggerFactory.getLogger(WechatController.class);
	/**
	 * 
	 * wechatGet方法
	 * <p>微信平台接入</p>
	 * @param wechatGet
	 * @return void
	 * @author tjun
	 * Nov 21, 2017 10:30:29 AM
	 * @throws IOException 
	 */
	@RequestMapping(value="wechat", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request,
			HttpServletResponse response,  String signature, String timestamp, String nonce,String echostr) throws IOException {
		System.out.println("**************************微信访问服务器*************************");
		logger.info("**************************微信访问服务器*************************");
		if (SignUtil.checkSignature(ConfigUtils.getConfig("WINXIN_TOKEN"), signature,
				timestamp, nonce)) {
			try {
				response.getWriter().print(echostr);//注意此处必须返回echostr以完成验证
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{           
				response.getWriter().close();        
			}
			
		}
	}

	@RequestMapping(value = "wechat", method = RequestMethod.POST)
	public void wechatPost(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String respMessage = wechatService.coreService(request);
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}

}
