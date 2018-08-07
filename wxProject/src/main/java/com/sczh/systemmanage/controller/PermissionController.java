package com.sczh.systemmanage.controller;

import java.util.List;
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
import com.sczh.core.utils.Collections3;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.Permission;
import com.sczh.systemmanage.service.IPermissionService;
import com.sczh.systemmanage.utils.PermissionUtils;



/**
 * 权限管理
 * 
 */
@Controller
@RequestMapping("/systemmanage/permission")
public class PermissionController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	
	@Autowired
    private IPermissionService permissionService;
	
	/** 权限列表页面 */
	@RequestMapping("")
	public String list(Model model) {
		return "systemmanage/permission/permissionlist";
	}
	
	/***
     * 权限列表数据查询
     */
    @RequestMapping("/search")
    public @ResponseBody PagingResult<Permission> search() {   	
    	Map<String,Object> mapQuery = Maps.newHashMap();
    	List<Permission> list = permissionService.findPermission(mapQuery);//已排序的树形结构数据
    	return new PagingResult<Permission>(Collections3.isEmpty(list)?0:list.size(), list);
    }
    
    /***
     * 权限详情页面
     */
    @RequestMapping("/initDetail")
    public String initDetail(Model model, Permission permission,
    		@RequestParam(value = "oper", required = false) String oper) {  	
    	model.addAttribute("oper", oper);
    	model.addAttribute("permission", permissionService.viewPermission(permission));//加载实体
    	
    	return "systemmanage/permission/permissionInfo";
    }
    
    /***
     * 新增权限
     */
    @RequestMapping("/add")
    public @ResponseBody Result add(Permission permission) {
    	try {
    		if("".equals(permission.getParentId())) {
    			permission.setParentId(null);
    		}
    		return permissionService.add(permission);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，新增失败！");
		}
    }
    
    /***
     * 修改权限
     */
    @RequestMapping("/edit")
    public @ResponseBody Result edit(Permission permission) {   	
    	try {
    		if("".equals(permission.getParentId())) {
    			permission.setParentId(null);
    		}
    		return permissionService.edit(permission);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，修改失败！");
		}
    }
    
    /***
     * 删除权限
     */
    @RequestMapping("/delete")
    public @ResponseBody Result delete(Permission permission) {   	
    	try {
    		return permissionService.delete(permission);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常， 删除失败！");
		}
    }
    
    /***
     * 获取权限树信息
     */
    @RequestMapping("/getPermissionTree")
    public @ResponseBody Object getPermissionTree() {
    	return PermissionUtils.getPermissionTree(false);
    }
}