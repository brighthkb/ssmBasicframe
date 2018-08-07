package com.sczh.systemmanage.service.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.sczh.core.utils.IdentityUtils;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.mapper.PermissionMapper;
import com.sczh.systemmanage.model.Permission;
import com.sczh.systemmanage.service.IPermissionService;
import com.sczh.systemmanage.utils.SessionUtils;

@Service
public class PermissionServiceImpl implements IPermissionService{
    private static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionMapper permissionMapper;

	@Override
	public List<Permission> findPermission(Map<String, Object> mapQuery) {
		List<Permission> list = permissionMapper.findPermission(mapQuery);
		return list;
	}

	@Override
	public List<Permission> findPermissionOfUser(Map<String, Object> mapQuery) {
		List<Permission> list = permissionMapper.findPermissionOfUser(mapQuery);
		return list;
	}

	@Override
	public Permission viewPermission(Permission permission) {
		return permissionMapper.viewPermission(permission);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result add(Permission permission) {
		if(permissionMapper.isExist(permission) != 0 ){
			return new Result(false,"权限标识已存在，新增失败！");
		}
		
		permission.setId(IdentityUtils.uuid2());//生成ID标识
		permission.setCreator(SessionUtils.getCurrUserId());
		permissionMapper.insert(permission);
		
		return new Result(true,"新增成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result edit(Permission permission) {
		if(permissionMapper.isExist(permission) != 0 ){
			return new Result(false,"权限标识已存在，编辑失败！");
		}
		
		permission.setModifier(SessionUtils.getCurrUserId());
		permissionMapper.update(permission);
		
		return new Result(true,"编辑成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result delete(Permission permission) {
		/* 1、获取当前权限的子节点 */
		Map<String,Object> mapQuery = Maps.newHashMap();
		mapQuery.put("parentId", permission.getId());
		List<Permission> childrenPermission = permissionMapper.findPermission(mapQuery);//查询父权限节点为parentId下的所有子节点
		Collections.reverse(childrenPermission);//防止父子节点约束关系，从子节点开始删除
		/* 2、删除当前权限的子节点及权限与角色的关联 */
		for (Iterator<Permission> iterator = childrenPermission.iterator(); iterator.hasNext();) {
			Permission childPermission = iterator.next();
			permissionMapper.deleteRel(childPermission);//删除角色与权限的关联 
			permissionMapper.delete(childPermission);//删除权限子节点
		}
		/* 3、删除当前权限节点及权限与角色的关联  */
		permissionMapper.deleteRel(permission);//删除角色与权限的关联 
		permissionMapper.delete(permission);//删除当前权限节点
		
		return new Result(true,"删除成功！");
	}
	
}
