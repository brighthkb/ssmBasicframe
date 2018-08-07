package com.sczh.systemmanage.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sczh.systemmanage.model.Permission;

@Repository
public interface PermissionMapper{
	
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
	 *  判断是否存在权限信息
	 */
	public int isExist(Permission permission);
	
	/**
	 *  新增权限信息
	 */
	public int insert(Permission permission);
	
	/**
	 *  修改权限信息
	 */
	public int update(Permission permission);
	
	/**
	 *  删除权限信息
	 */
	public int delete(Permission permission);
	
	/**
	 *  删除角色与权限的关联 
	 */
	public int deleteRel(Permission permission);

}
