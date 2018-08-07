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
import com.sczh.systemmanage.model.Role;
import com.sczh.systemmanage.service.IRoleService;

/**
 * 角色管理
 * 
 */
@Controller
@RequestMapping("/systemmanage/role")
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
    private IRoleService roleService;
	
	/** 角色列表页面 */
	@RequestMapping("")
	public String list(Model model) {
		return "systemmanage/role/rolelist";
	}	
	
	/***
     * 角色列表数据查询
     */
    @RequestMapping("/search")
    public @ResponseBody PagingResult<Role> search(Paging paging,
    		@RequestParam(value = "name", required = false) String name) {
    	Map<String,Object> mapQuery = Maps.newHashMap();
    	mapQuery.put("name", name);
    	
    	return roleService.findRoleByPage(paging, mapQuery);
    }

    /***
     * 角色详情页面
     */
    @RequestMapping("/initDetail")
    public String initDetail(Model model, Role role,
    		@RequestParam(value = "oper", required = false) String oper) {  	
    	model.addAttribute("oper", oper);
    	model.addAttribute("role", roleService.viewRole(role));//加载实体
    	
    	return "systemmanage/role/roleInfo";
    }
    
    /***
     * 新增角色
     */
    @RequestMapping("/add")
    public @ResponseBody Result add(Role role) {
    	try {
    		return roleService.add(role);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，新增失败！");
		}
    }
    
    /***
     * 修改角色
     */
    @RequestMapping("/edit")
    public @ResponseBody Result edit(Role role) {   	
    	try {
    		return roleService.edit(role);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，修改失败！");
		}
    }
    
    /***
     * 删除角色
     */
    @RequestMapping("/delete")
    public @ResponseBody Result delete(Role role) {   	
    	try {
    		return roleService.delete(role);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常， 删除失败！");
		}
    }
    
    /***
     * 查询角色
     */
    @RequestMapping("/findRole")
    public @ResponseBody Result findRole() {
    	try {
    		return new Result(true, "查询角色成功！", roleService.findRole());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，查询角色失败！", null);
		}
    }
}