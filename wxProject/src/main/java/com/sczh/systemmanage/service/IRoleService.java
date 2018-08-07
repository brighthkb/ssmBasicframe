package com.sczh.systemmanage.service;

import java.util.List;
import java.util.Map;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.Role;

public interface IRoleService{
	
	/**
	 *  分页查询角色信息
	 */
	public PagingResult<Role> findRoleByPage(Paging paging, Map<String,Object> mapQuery);

	/**
	 *  查看角色信息
	 */
	public Role viewRole(Role role);
	
	/**
	 *  新增角色信息
	 */
	public Result add(Role role);
	
	/**
	 *  修改角色信息
	 */
	public Result edit(Role role);
	
	/**
	 *  删除角色信息
	 */
	public Result delete(Role role);
	
	/**
	 *  查询角色信息
	 */
	public List<Role> findRole();
}
