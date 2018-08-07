package com.sczh.systemmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index页面控制器
 *  
 */
@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/** 系统主页  */
	@RequestMapping("/")
	public String index(Model model) {
		logger.info("进入系统主页...");
		return "index";
	}
	/** 系统主页  */
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		logger.info("进入系统欢迎主页...");
		return "welcome";
	}
}