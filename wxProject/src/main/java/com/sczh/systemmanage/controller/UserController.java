package com.sczh.systemmanage.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.User;
import com.sczh.systemmanage.service.IDepartment;
import com.sczh.systemmanage.service.IUserService;
/**
 * 用户管理
 * 
 */
@Controller
@RequestMapping("/systemmanage/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private IUserService userService;
	@Autowired
    private IDepartment deptService;
	/** 用户列表页面 */
	@RequestMapping("")
	public String list(Model model) {
		return "systemmanage/user/userlist";
	}
	
	/***
     * 用户列表数据查询
     */
    @RequestMapping("/search")
    public @ResponseBody PagingResult<User> search(Paging paging,
    		@RequestParam(value = "loginName", required = false) String loginName,
    		@RequestParam(value = "state", required = false) String state,
    		@RequestParam(value = "dept", required = false) String dept,
    		@RequestParam(value = "createDate_start", required = false) String createDate_start,
    		@RequestParam(value = "createDate_end", required = false) String createDate_end) {   	
    	Map<String,Object> mapQuery = Maps.newHashMap();
    	mapQuery.put("loginName", loginName);
    	mapQuery.put("state", state);
    	mapQuery.put("dept", dept);
    	mapQuery.put("createDate_start", createDate_start);
    	mapQuery.put("createDate_end", createDate_end);
    	
    	return userService.findUserByPage(paging, mapQuery);
    }
    
    /***
     * 用户详情页面
     */
    @RequestMapping("/initDetail")
    public String initDetail(Model model, User user,
    		@RequestParam(value = "oper", required = false) String oper) {  
    	try {
	    	model.addAttribute("oper", oper);
	    	model.addAttribute("user", userService.viewUser(user));//加载实体
			model.addAttribute("depts",deptService.findAllDept());
		} catch (Exception e) {
			logger.error("获取用户详情信息出错", e);
		}//部门信息
    	return "systemmanage/user/userInfo";
    }
    
    /***
     * 新增用户
     */
    @RequestMapping("/add")
    public @ResponseBody Result add(User user) {
    	try {
    		return userService.add(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，新增失败！");
		}
    }
    
    /***
     * 修改用户
     */
    @RequestMapping("/edit")
    public @ResponseBody Result edit(User user) {   	
    	try {
    		return userService.edit(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，修改失败！");
		}
    }
    
    /***
     * 删除用户
     */
    @RequestMapping("/delete")
    public @ResponseBody Result delete(User user) {   	
    	try {
    		return userService.delete(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常， 删除失败！");
		}
    }
    

    /***
     * 修改密码
     */
    @RequestMapping("/modifyPassword")
	public @ResponseBody Result modifyPassword(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "originalPassword", required = true) String originalPassword,
			@RequestParam(value = "password", required = true) String password) {
    	try {
        	return userService.modifyPassword(userId, originalPassword, password, true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常， 修改密码失败！");
		}
	}
}