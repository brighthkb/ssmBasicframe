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
import com.sczh.systemmanage.mapper.RoleMapper;
import com.sczh.systemmanage.model.Role;
import com.sczh.systemmanage.service.IRoleService;
import com.sczh.systemmanage.utils.SessionUtils;

@Service
public class RoleServiceImpl implements IRoleService{
    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

	@Override
	public PagingResult<Role> findRoleByPage(Paging paging, Map<String, Object> mapQuery) {
		mapQuery = PagingUtils.appendPageParam(mapQuery, paging);
		List<Role> list = roleMapper.findRoleByPage(mapQuery);
		int count = roleMapper.count(mapQuery);
		return new PagingResult<Role>(count, list);
	}

	@Override
	public Role viewRole(Role role) {
		return roleMapper.viewRole(role);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result add(Role role) {
		if(roleMapper.isExist(role) != 0 ){
			return new Result(false,"角色名称已存在，新增失败！");
		}
		
		/* 1、新增角色信息 */
		role.setId(IdentityUtils.uuid2());//生成ID标识
		role.setCreator(SessionUtils.getCurrUserId());
		roleMapper.insert(role);
		/* 2、新增角色与权限的关联 */
		if(StringUtils.isNotBlank(role.getPermissionIds())){
			Map<String, Object> mapQuery = Maps.newHashMap();
			mapQuery.put("roleId", role.getId());
			
			String[] permissionIds = role.getPermissionIds().split(",");
			for (int i = 0; i < permissionIds.length; i++) {
				mapQuery.put("permissionId", permissionIds[i]);
				roleMapper.insertRel(mapQuery);
			}
		}
		
		return new Result(true,"新增成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result edit(Role role) {
		if(roleMapper.isExist(role) != 0 ){
			return new Result(false,"角色名称已存在，编辑失败！");
		}
		
		/* 1、修改角色信息 */
		role.setModifier(SessionUtils.getCurrUserId());
		roleMapper.update(role);
		/* 2、删除角色与权限的关联 */
		roleMapper.deleteRel(role);
		/* 3、新增角色与权限的关联 */
		if(StringUtils.isNotBlank(role.getPermissionIds())){
			Map<String, Object> mapQuery = Maps.newHashMap();
			mapQuery.put("roleId", role.getId());
			
			String[] permissionIds = role.getPermissionIds().split(",");
			for (int i = 0; i < permissionIds.length; i++) {
				mapQuery.put("permissionId", permissionIds[i]);
				roleMapper.insertRel(mapQuery);
			}
		}
		
		return new Result(true,"编辑成功！");
	}

	@Override
	@Transactional(readOnly=false, rollbackFor = Exception.class)
	public Result delete(Role role) {
		/* 1、删除角色与权限的关联 */
		roleMapper.deleteRel(role);
		/* 2、删除角色与用户的关联 */
		roleMapper.deleteRel2(role);
		/* 3、删除角色信息 */
		roleMapper.delete(role);
		
		return new Result(true,"删除成功！");
	}
		
	@Override
	public List<Role> findRole() {
		return roleMapper.findRole();
	}
}
