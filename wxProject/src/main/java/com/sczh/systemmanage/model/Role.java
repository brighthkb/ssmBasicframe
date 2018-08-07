package com.sczh.systemmanage.model;

import java.util.Date;

/**
 * 角色
 */
//对应表：ss_role【角色信息表】、ss_role_permission【角色权限关联表】
public class Role {
	private String id;
	private String name;
	private String description;
	private String creator;//创建人
	private Date createDate;//创建时间	
	private String modifier;//修改人
	private Date modifyDate;//修改时间
	private String permissionIds;//已选权限ID
	private String permissionNames;//已选权限名称
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
	public String getPermissionNames() {
		return permissionNames;
	}
	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}
}
