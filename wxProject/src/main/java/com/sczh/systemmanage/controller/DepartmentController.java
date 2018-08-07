package com.sczh.systemmanage.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.sczh.systemmanage.model.Department;
import com.sczh.systemmanage.service.IDepartment;

/**
 * 用户管理
 * 
 */
@Controller
@RequestMapping("/systemmanage/dept")
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
    private IDepartment deptService;
	
	/** 部门列表页面 */
	@RequestMapping("")
	public String list(Model model) {
		return "systemmanage/dept/deptlist";
	}
	
	/***
     * 用户列表数据查询
     */
    @RequestMapping("/search")
    public @ResponseBody PagingResult<Department> search(Paging paging,
    		@RequestParam(value = "name", required = false) String name) {
    	Map<String,Object> mapQuery = Maps.newHashMap();
    	if(StringUtils.isNotEmpty(name)) {
    		mapQuery.put("name", "%"+name+"%");
    	}
    	return deptService.findDeptByPage(paging, mapQuery);
    }
    /***
     * 用户详情页面
     */
    @RequestMapping("/initDetail")
    public String initDetail(Model model, Department dept,
    		@RequestParam(value = "oper", required = false) String oper) {  	
    	model.addAttribute("oper", oper);
    	model.addAttribute("dept", deptService.viewUser(dept));//加载实体
    	
    	return "systemmanage/dept/deptInfo";
    }
    
    /***
     * 新增用户
     */
    @RequestMapping("/add")
    public @ResponseBody Result add(Department dept) {
    	try {
    		return deptService.add(dept);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，新增失败！");
		}
    }
    
    /***
     * 修改用户
     */
    @RequestMapping("/edit")
    public @ResponseBody Result edit(Department dept) {   	
    	try {
    		return deptService.edit(dept);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常，修改失败！");
		}
    }
    
    /***
     * 删除用户
     */
    @RequestMapping("/delete")
    public @ResponseBody Result delete(Department dept) {   	
    	try {
    		return deptService.delete(dept);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Result(false, "未知异常， 删除失败！");
		}
    }
}