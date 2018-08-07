package com.sczh.core.web.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sczh.core.dict.DictUtils;
import com.sczh.core.utils.Collections3;
import com.sczh.core.web.dto.Result;

/**
 * 通用请求控制器
 * 
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	/** 获取字典数据  */
	@RequestMapping(value = "/dict")
	public @ResponseBody Result getDict(@RequestParam(value = "_name", required = true) String name) {
		List<Map<String, String>> dictItems = DictUtils.getDict2(name);
		return new Result(!Collections3.isEmpty(dictItems), null, dictItems);
	}
	
	/** 获取字典数据  */
	@RequestMapping(value = "/dict2")
	public @ResponseBody List<Map<String,String>> getDict2(@RequestParam(value = "_name", required = true) String name) {
		return  DictUtils.getDict2(name);
	}
}