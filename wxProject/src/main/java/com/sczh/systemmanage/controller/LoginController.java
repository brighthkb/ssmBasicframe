package com.sczh.systemmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sczh.core.dict.DictUtils;
import com.sczh.systemmanage.model.User;
import com.sczh.systemmanage.service.IUserService;
import com.sczh.systemmanage.utils.PasswordUtils;
import com.sczh.systemmanage.utils.SessionUtils;

/**
 * 登录、登出操作
 * 
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private IUserService userService;
	
	
	/** GET方式登录 */
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session) {
		if(SessionUtils.isLogin(request)){
			return "redirect:/";
		}else{
			return "login";
		}
	}
	
	/** POST方式登录 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, Model model,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "code", required = false) String code) {
		//错误提示信息
		String errorMsg = "用户名或密码错误！";
		
		/* 1、删除系统会话相关信息 */
		SessionUtils.removeLoginInfo(request);
		/* 2、获取用户信息【根据用户名】 */
		User user = new User();
		user.setLoginName(username);
		user = userService.viewUser(user);
		/* 3、登录验证 */
		//系统生成验证码
		Object verifyRandImgObj = session.getAttribute("verifyRandImg_loginCode");
		session.removeAttribute("verifyRandImg_loginCode");// 移除掉session
		String verifyRandImgStr = "";
		if (null != verifyRandImgObj && !"".equals(verifyRandImgObj)) {
			verifyRandImgStr = verifyRandImgObj.toString();
		}
		logger.error("session code1:"+verifyRandImgObj+"------------------------------------------");
		logger.error("session code2:"+verifyRandImgStr+"------------------------------------------");
		logger.error("用户输入的验证码:"+code+"------------------------------------------");
		System.out.println("session code1:"+verifyRandImgObj+"------------------------------------------");
		System.out.println("session code2:"+verifyRandImgStr+"------------------------------------------");
		System.out.println("用户输入的验证码:"+code+"------------------------------------------");
		if (null != verifyRandImgStr && !"".equals(verifyRandImgStr)&& null != code && verifyRandImgStr.equalsIgnoreCase(code)) {
			if(user != null){//用户是否存在
				if(StringUtils.equals(DictUtils.getDict("user_state").get("启用"), user.getState())){//用户是否停用
					if(PasswordUtils.verifyPassword(user, password)){//用户密码是否正确
						/* 4、添加系统会话相关信息 */
						SessionUtils.setupCurrUserSessionInfo(request, user);
						/* 5.1、登录成功跳转  */
						logger.info("用户【{}】登录成功！", username);
						return "redirect:/";
					}
				}else{
					errorMsg = "登录用户已停用！";
				}
			}
		}else{
			errorMsg = "验证码有误，请重新登录！";
		}
		/* 5.2、登录失败跳转 */
		logger.info("用户【{}】登录失败！", username);
		model.addAttribute("username", username);
		model.addAttribute("errorMsg", errorMsg);
		return "login";
	}
	
	/** 用户登出 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {	
		//删除系统会话相关信息
		SessionUtils.removeLoginInfo(request);
		session.invalidate();
		
		return "redirect:/login";
	}
}