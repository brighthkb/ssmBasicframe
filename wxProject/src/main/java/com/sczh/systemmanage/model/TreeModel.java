package com.sczh.systemmanage.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeModel{
	
	/**
	 * ID号
	 */
	private String id;
	
	/**
	 * 名称
	 */
	private String text;
	
	/**
	 * 父节点ID号
	 */
	private String parentId; 
	
	/**
	 * 子节点
	 */
	private List<TreeModel> children = new ArrayList<>();

	private String type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public static List<TreeModel> getsTree(List<TreeModel> ban) {
		if (ban != null && !ban.isEmpty()) {
				List<TreeModel> tree = new ArrayList<TreeModel>();
				Map<String, TreeModel> map = new HashMap<String, TreeModel>();
				for (TreeModel data : ban) {
					if (data.getParentId() == null || "".equals(data.getParentId())) {
						tree.add(data);
					}
					map.put((data.getId()+"").trim(), data);
				}
				for (TreeModel data : ban) {
					TreeModel parent = map.get((data.getParentId()+"").trim());
					if (parent != null) {
						if (parent.getChildren() == null) {
							parent.setChildren(new ArrayList<TreeModel>());
						}
						parent.getChildren().add(data);
							
					}
				}
				return tree;
		}
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	 
}
