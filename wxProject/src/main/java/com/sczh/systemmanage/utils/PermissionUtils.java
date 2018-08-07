package com.sczh.systemmanage.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sczh.core.spring.common.SpringContextUtils;
import com.sczh.core.utils.Collections3;
import com.sczh.systemmanage.model.Permission;
import com.sczh.systemmanage.service.IPermissionService;
import com.sczh.systemmanage.service.impl.PermissionServiceImpl;

  
/** 
 * 权限操作工具类
 * 
 */  
public final class PermissionUtils { 
	private static final String PERMISSION_NAMES_DELIMETER = ",";	
	
	/**
     * 获取用户权限信息
     */
	public static List<Permission> getUserPermission(String userId){
		return getUserPermission(userId, false);
	}

	/**
	 * 获取用户权限信息
	 * @param userId 用户ID
	 * @param isOnlyMenu 是否仅仅查询菜单权限
	 * @return
	 */
	private static List<Permission> getUserPermission(String userId, boolean isOnlyMenu){
		IPermissionService permissionService = SpringContextUtils.getBean(PermissionServiceImpl.class);
		Map<String,Object> mapQuery = Maps.newHashMap();
		mapQuery.put("userId", userId);
		mapQuery.put("isOnlyMenu", isOnlyMenu);
		return permissionService.findPermissionOfUser(mapQuery);
	}
	
	/**
     * 获取用户菜单树
     */
	public static List<Map<String, Object>> getUserMenuTree(String userId){
		List<Permission> list = getUserPermission(userId, true);//只查询菜单权限
		List<Map<String, Object>> menus = Lists.newArrayList();
		
		for (Iterator<Permission> iterator = list.iterator(); iterator.hasNext();) {
			Permission item = iterator.next();
			if(StringUtils.isBlank(item.getParentId())){//根节点
				Map<String, Object> menu = Maps.newHashMap();
				menu.put("menu", item);
				menu.put("children", getChildrenOfMenu(list, item.getId()));
				menus.add(menu);
			}
		}
		
		return menus;
	}
	
	/**
     * 获取菜单子节点(树形递归)
     */
	private static List<Map<String, Object>> getChildrenOfMenu(List<Permission> list, String parentId){
		List<Map<String, Object>> children = Lists.newArrayList();
		
		for (Iterator<Permission> iterator = list.iterator(); iterator.hasNext();) {
			Permission item = iterator.next();
			if(StringUtils.equals(item.getParentId(), parentId)){
				Map<String, Object> child = Maps.newHashMap();
				child.put("menu", item);
				child.put("children", getChildrenOfMenu(list, item.getId()));
				children.add(child);
			}
		}
		
		return Collections3.isEmpty(children)?null:children;
	}
	
	/**
	 * 获取权限树
	 * @param isOnlyMenu 是否仅仅查询菜单权限
	 * @return
	 */
	public static List<Map<String, Object>> getPermissionTree(boolean isOnlyMenu){
		IPermissionService permissionService = SpringContextUtils.getBean(PermissionServiceImpl.class);
		Map<String,Object> mapQuery = Maps.newHashMap();
		mapQuery.put("isOnlyMenu", isOnlyMenu);
		List<Permission> list = permissionService.findPermission(mapQuery);
		List<Map<String, Object>> nodes = Lists.newArrayList();
		
		for (Iterator<Permission> iterator = list.iterator(); iterator.hasNext();) {
			Permission item = iterator.next();
			if(StringUtils.isBlank(item.getParentId())){//根节点
				Map<String, Object> node = Maps.newHashMap();
				node.put("id", item.getId());
				node.put("text", item.getName());
				node.put("state", "open");
				node.put("checked", false);
				node.put("children", getChildrenOfPermission(list, item.getId()));
				node.put("iconCls", node.get("children")==null?null:null);
				nodes.add(node);
			}
		}
		
		return nodes;
	}
	
	/**
     * 获取权限子节点(树形递归)
     */
	private static List<Map<String, Object>> getChildrenOfPermission(List<Permission> list, String parentId){
		List<Map<String, Object>> children = Lists.newArrayList();
		
		for (Iterator<Permission> iterator = list.iterator(); iterator.hasNext();) {
			Permission item = iterator.next();
			if(StringUtils.equals(item.getParentId(), parentId)){
				Map<String, Object> child = Maps.newHashMap();
				child.put("id", item.getId());
				child.put("text", item.getName());
				child.put("state", "open");
				child.put("checked", false);
				child.put("children", getChildrenOfPermission(list, item.getId()));
				child.put("iconCls", child.get("children")==null?null:null);
				children.add(child);
			}
		}
		
		return Collections3.isEmpty(children)?null:children;
	}
	
	/**
     * 当前登录用户是否拥有此权限
     */
	@SuppressWarnings("unchecked")
	public static boolean hasAnyPermissions(HttpServletRequest request, String permissionKeys){
		if (SessionUtils.isLogin(request) && StringUtils.isNotBlank(permissionKeys)) {
			Map<String, Object> relInfo = SessionUtils.getSysSessionRelInfo(request);
			List<Permission> list = (List<Permission>) relInfo.get(SessionUtils.SESSION_USER_PERMISSION_KEY);
			List<String> __permissionKeys = Collections3.extractToList(list, "permissionKey");
			
			if(!Collections3.isEmpty(__permissionKeys)){
				for (String permissionKey : permissionKeys.split(PERMISSION_NAMES_DELIMETER)) {
					if (__permissionKeys.contains(permissionKey)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
