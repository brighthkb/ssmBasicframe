package com.sczh.systemmanage.service;

import java.util.List;
import java.util.Map;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.User;

public interface IUserService {

	/**
	 * 分页查询用户信息
	 */
	public PagingResult<User> findUserByPage(Paging paging, Map<String, Object> mapQuery);

	/**
	 * 查询用户信息
	 */
	public List<User> findUser(Map<String, Object> mapQuery);

	/**
	 * 根据相关条件查询相关用户列表数据
	 * @param mapQuery
	 * @return
	 */
	public List<User> findUserBy(Map<String,Object> mapQuery);
	
	/**
	 * 查看用户信息
	 */
	public User viewUser(User user);

	/**
	 * 新增用户信息
	 */
	public Result add(User user);

	/**
	 * 修改用户信息
	 */
	public Result edit(User user);

	/**
	 * 删除用户信息
	 */
	public Result delete(User user);

	/**
	 * 修改密码
	 * 
	 * @param userId 用户id
	 * @param originalPassword 旧密码
	 * @param password 新密码
	 * @param isVerifyOriginalPassword 是否验证旧密码
	 * @return
	 */
	public Result modifyPassword(String userId, String originalPassword, String password, boolean isVerifyOriginalPassword);
}