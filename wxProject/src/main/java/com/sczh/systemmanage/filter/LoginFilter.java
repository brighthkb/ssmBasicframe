package com.sczh.systemmanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sczh.core.utils.IdentityUtils;
import com.sczh.systemmanage.utils.SessionUtils;

/**
 * 登录操作过滤器
 * 
 * @author chentao
 */
public class LoginFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String uuid = IdentityUtils.uuid2();
		// 设置uuid参数【用于界面元素唯一识别】
		request.setAttribute("uuid", uuid);
		// 报表下载中获取response对象
		if (StringUtils.isNotBlank(request.getParameter("reportConfigId"))) {
			request.setAttribute("HttpServletResponse", response);
		}

		/* 忽略URL路径 */
		String contextPath = req.getServletContext().getContextPath();
		String loginURI = contextPath + "/login"; // 系统登录地址
		String logoutURI = contextPath + "/logout"; // 系统登出地址
		String staticResourceURI = contextPath + "/static/"; // 静态资源
		String testURL = contextPath + "/test/"; // 微信访问地址
		String appURL = contextPath + "/weinxin/"; // 微信访问地址
		String weixinfileURL = contextPath + "/MP_verify_"; // 微信访问资源
		String requestURI = request.getRequestURI();
		if (SessionUtils.isLogin(request) || requestURI.equals(loginURI) || requestURI.equals(logoutURI)
				|| requestURI.startsWith(staticResourceURI) || requestURI.startsWith(weixinfileURL)  
				|| requestURI.startsWith(testURL)
				|| requestURI.startsWith(appURL)) {
			if (requestURI.startsWith(appURL)) {
				if (!requestURI.startsWith(contextPath + "/weinxin/wechatcontroller")) {
					if(!requestURI.startsWith(contextPath + "/weinxin/wxindexmain/checkrandomVcode")) {
//						if(!requestURI.startsWith(contextPath + "/weinxin/wxindexmain/towxindex")) {
						HttpServletRequest httpRequest = (HttpServletRequest) request;
						HttpSession session = httpRequest.getSession();
						if (session.getAttribute("wxuseropp") == null || session.getAttribute("wxuser") == null) {
							if (requestURI.startsWith(contextPath + "/weinxin/wxindexmain/towxindex")) {
								logger.info("URI" + requestURI);
								String wxbindingURI = contextPath + "/weinxin/wxindexmain/tobindingwechart.action"; // 微信登录地址
								response.sendRedirect(wxbindingURI);
							}
						}
//					 }
					}
				}
			}
			filterChain.doFilter(request, res);
		} else {
			logger.info("URI" + requestURI);
			response.sendRedirect(loginURI);
		}
	}

	public void destroy() {

	}
}
