package com.sczh.systemmanage.service;

import java.util.List;
import java.util.Map;

import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.Permission;

public interface IPermissionService{
	
	/**
	 *  查询权限信息
	 */
	public List<Permission> findPermission(Map<String,Object> mapQuery);

	/**
	 *  查询用户拥有的权限
	 */
	public List<Permission> findPermissionOfUser(Map<String,Object> mapQuery);
	
	/**
	 *  查看权限信息
	 */
	public Permission viewPermission(Permission permission);
	
	/**
	 *  新增权限信息
	 */
	public Result add(Permission permission);
	
	/**
	 *  修改权限信息
	 */
	public Result edit(Permission permission);
	
	/**
	 *  删除权限信息
	 */
	public Result delete(Permission permission);
	
}
