package com.sczh.systemmanage.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sczh.systemmanage.model.Role;

@Repository
public interface RoleMapper{
	
	/**
	 *  分页查询角色信息
	 */
	public List<Role> findRoleByPage(Map<String,Object> mapQuery);

	/**
	 *  查询角色总条数
	 */
	public int count(Map<String,Object> mapQuery);
	
	/**
	 *  查看角色信息
	 */
	public Role viewRole(Role role);
	
	/**
	 *  判断是否存在角色信息
	 */
	public int isExist(Role role);
	
	/**
	 *  新增角色信息
	 */
	public int insert(Role role);
	
	/**
	 *  修改角色信息
	 */
	public int update(Role role);
	
	/**
	 *  删除角色信息
	 */
	public int delete(Role role);
	
	/**
	 *  新增角色与权限的关联
	 */
	public int insertRel(Map<String,Object> mapQuery);
	
	/**
	 *  删除角色与权限的关联 
	 */
	public int deleteRel(Role role);
	
	/**
	 *  删除角色与用户的关联
	 */
	public int deleteRel2(Role role);
	
	/**
	 *  查询角色信息
	 */
	public List<Role> findRole();
	
}
