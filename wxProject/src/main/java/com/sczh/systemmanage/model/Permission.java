package com.sczh.systemmanage.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 权限
 */
//对应表：ss_permission【权限信息表】
public class Permission {
	private String id;
	private String name;//权限名称
	private String permissionKey;//权限标识
	private Integer isMenu ; //是否是菜单：1、0
	private String menuUrl;//菜单URL链接
	private String menuIcon;//菜单图标
	private Integer orderNo;//排序
	@JsonProperty("_parentId")
	private String parentId;//父节点	
	private String creator;//创建人
	private Date createDate;//创建时间
	private String modifier;//修改人
	private Date modifyDate;//修改时间
	
	
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
	public String getPermissionKey() {
		return permissionKey;
	}
	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}
	public Integer getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
}
