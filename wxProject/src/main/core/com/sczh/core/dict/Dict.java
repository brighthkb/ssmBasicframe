package com.sczh.core.dict;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 字典集
 * @author chentao
 *
 */
public class Dict {
	private String name;//字典名称

	private Map<String, String> dictItems = Maps.newLinkedHashMap();//字典项

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getDictItems() {
		return dictItems;
	}

	public void setDictItems(Map<String, String> dictItems) {
		this.dictItems = dictItems;
	}
}
