package com.sczh.core.dict;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sczh.core.utils.Collections3;

public class DictUtils {
	private static List<Dict> dictTable = Lists.newArrayList(); 
	public static List<Dict> getDictTable() {
		return dictTable;
	}
	public static void setDictTable(List<Dict> dictTable) {
		DictUtils.dictTable = dictTable;
	}


	/**
	 * 获取字典数据
	 */
	public static Map<String, String> getDict(String name){
		if(StringUtils.isNotBlank(name) && !Collections3.isEmpty(dictTable)){
			for (Iterator<Dict> iterator = dictTable.iterator(); iterator.hasNext();) {
				Dict dict = iterator.next();
				if (StringUtils.equalsIgnoreCase(dict.getName(), name)) {
					return dict.getDictItems();
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 获取字典数据
	 */
	public static List<Map<String, String>> getDict2(String name) {
		Map<String, String> dict = DictUtils.getDict(name);
		if (dict != null && dict.size() > 0) {
			List<Map<String, String>> dictItems = Lists.newArrayList();
			for (Iterator<Entry<String, String>> iterator = dict.entrySet().iterator(); iterator.hasNext();) {
				Entry<String, String> entry = iterator.next();

				Map<String, String> dictItem = Maps.newHashMap();
				dictItem.put("key", entry.getKey());
				dictItem.put("value", entry.getValue());
				dictItems.add(dictItem);
			}

			return dictItems;
		}

		return null;
	}
}
