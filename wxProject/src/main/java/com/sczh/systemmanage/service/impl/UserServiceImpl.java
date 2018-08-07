package com.sczh.systemmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.sczh.core.utils.IdentityUtils;
import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.PagingUtils;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.mapper.DepartmentMapper;
import com.sczh.systemmanage.mapper.UserMapper;
import com.sczh.systemmanage.model.Department;
import com.sczh.systemmanage.model.User;
import com.sczh.systemmanage.service.IUserService;
import com.sczh.systemmanage.utils.PasswordUtils;
import com.sczh.systemmanage.utils.SessionUtils;

@Service
public class UserServiceImpl implements IUserService{
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
	@Override
	public PagingResult<User> findUserByPage(Paging paging, Map<String, Object> mapQuery) {
		mapQuery = PagingUtils.appendPageParam(mapQuery, paging);
		List<User> list = userMapper.findUserByPage(mapQuery);
		for (User user : list) {
			String dept = user.getDept();
			if(StringUtils.isNotEmpty(dept)) {
				Department deptObject = departmentMapper.selectByPrimaryKey(dept);
				if(null != deptObject && null != deptObject.getName()) {
					user.setDept(deptObject.getName());
				}
			}
		}
		int count = userMapper.count(mapQuery);
		return new PagingResult<User>(count, list);
	}
	
	@Override
	public List<User> findUser(Map<String, Object> mapQuery) {
		Paging paging = new Paging(1, userMapper.count(mapQuery));
		mapQuery = PagingUtils.appendPageParam(mapQuery, paging);
		return userMapper.findUserByPage(mapQuery);
	}

	@Override
	public User viewUser(User user) {	
		return userMapper.viewUser(user);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result add(User user) {
		if(userMapper.isExist(user) != 0 ){
			return new Result(false,"用户名已存在，新增失败！");
		}
		
		/* 1、新增用户信息 */
		user.setId(IdentityUtils.uuid2());//生成ID标识
		user.setCreator(SessionUtils.getCurrUserId());
		PasswordUtils.generatePassword(user, user.getPassword());//加密明文密码
		userMapper.insert(user);
		/* 2、新增用户与角色的关联 */
		if(StringUtils.isNotBlank(user.getRoleIds())){
			Map<String, Object> mapQuery = Maps.newHashMap();
			mapQuery.put("userId", user.getId());
			
			String[] roleIds = user.getRoleIds().split(",");
			for (int i = 0; i < roleIds.length; i++) {
				mapQuery.put("roleId", roleIds[i]);
				userMapper.insertRel(mapQuery);
			}
		}
		
		return new Result(true,"新增成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result edit(User user) {
		if(StringUtils.equals("1", user.getId())){
			return new Result(false, "admin 是系统超级管理员，不能编辑！");
		}
		if(userMapper.isExist(user) != 0 ){
			return new Result(false,"用户名已存在，编辑失败！");
		}
		
		/* 1、修改用户信息 */
		user.setModifier(SessionUtils.getCurrUserId());
		if(StringUtils.isBlank(user.getPassword())){//当没有修改密码时
			User _user = new User();
			_user.setId(user.getId());
			_user = userMapper.viewUser(_user);
			
			user.setSalt(_user.getSalt());
			user.setPassword(_user.getPassword());
		}else{
			PasswordUtils.generatePassword(user, user.getPassword());//加密明文密码
		}
		userMapper.update(user);
		/* 2、删除用户与角色的关联 */
		userMapper.deleteRel(user);
		/* 3、新增用户与角色的关联 */
		if(StringUtils.isNotBlank(user.getRoleIds())){
			Map<String, Object> mapQuery = Maps.newHashMap();
			mapQuery.put("userId", user.getId());
			
			String[] roleIds = user.getRoleIds().split(",");
			for (int i = 0; i < roleIds.length; i++) {
				mapQuery.put("roleId", roleIds[i]);
				userMapper.insertRel(mapQuery);
			}
		}
		
		return new Result(true,"编辑成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result delete(User user) {
		if(userMapper.viewUser(user)==null){
			return new Result(false, "用户信息不存在！");
		}
		if(StringUtils.equals("1", user.getId())){
			return new Result(false, "admin 是系统超级管理员，不能删除！");
		}
		/* 1、删除用户与角色的关联 */
		userMapper.deleteRel(user);
		/* 2、删除用户信息 */
		userMapper.delete(user);
		
		return new Result(true,"删除成功！");
	}
	
	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result modifyPassword(String userId, String originalPassword, String password, boolean isVerifyOriginalPassword) {
		User _user = new User();
		_user.setId(userId);
		
		User user = userMapper.viewUser(_user);
		if(isVerifyOriginalPassword){
			if(!PasswordUtils.verifyPassword(user, originalPassword)){//验证旧密码是否正确
				return new Result(false, "旧密码输入错误，修改密码失败！");
			}
		}
		
		user.setModifier(SessionUtils.getCurrUserId());
		PasswordUtils.generatePassword(user, password);//加密明文密码
		userMapper.update(user);
		
		return new Result(true, "修改密码成功！"); 	
	}

	@Override
	public List<User> findUserBy(Map<String, Object> mapQuery) {
		// TODO Auto-generated method stub
		return userMapper.findUserBy(mapQuery);
	}
	
}
