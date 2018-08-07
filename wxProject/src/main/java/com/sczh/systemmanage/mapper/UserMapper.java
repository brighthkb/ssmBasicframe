package com.sczh.systemmanage.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sczh.systemmanage.model.User;

@Repository
public interface UserMapper{
	
	/**
	 *  分页查询用户信息
	 */
	public List<User> findUserByPage(Map<String,Object> mapQuery);

	/**
	 *  查询用户总条数
	 */
	public int count(Map<String,Object> mapQuery);
	
	/**
	 *  查看用户信息
	 */
	public User viewUser(User user);
	
	/**
	 *  判断是否存在用户信息
	 */
	public int isExist(User user);
	/**
	 * 根据相关条件查询相关用户列表数据
	 * @param mapQuery
	 * @return
	 */
	public List<User> findUserBy(Map<String,Object> mapQuery);
	
	/**
	 *  新增用户信息
	 */
	public int insert(User user);
	
	/**
	 *  修改用户信息
	 */
	public int update(User user);
	
	/**
	 *  删除用户信息
	 */
	public int delete(User user);
	
	/**
	 *  新增用户与角色的关联
	 */
	public int insertRel(Map<String,Object> mapQuery);
	
	/**
	 * 删除用户与角色的关联
	 */
	public int deleteRel(User user);
}
