package com.sczh.core.web.dto;


import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.github.orderbyhelper.OrderByHelper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
  
/** 
 * 分页操作工具类 
 * 
 */  
public final class PagingUtils {  
	/**
	 * 向SQL查询语句追加分页参数
	 * 
	 * @param mapQuery
	 * @param paging
	 */
	public static Map<String, Object> appendPageParam(Map<String, Object> mapQuery, Paging paging) {
		if (mapQuery == null)
			mapQuery = Maps.newHashMap();

		if (paging == null)
			return mapQuery;

		mapQuery.put("startRowNo_", paging.getStartRowNo());
		mapQuery.put("endRowNo_", paging.getEndRowNo());

		return mapQuery;
	}
	
	/**
	 * 【通过Mybatis插件方式】执行SQL分页功能
	 * 
	 * @param paging
	 */
	public static void excutePage(Paging paging) {
		if (paging != null) {
			PageHelper.startPage(paging.getPage(), paging.getRows());
		}
	}
	
	/**
	 * 【通过Mybatis插件方式】获取分页总条数
	 * 
	 * @param list
	 */
	public static long getTotal(List<?> list) {
		if (list instanceof Page<?>) {
			return ((Page<?>) list).getTotal();
		} else {
			if (CollectionUtils.isEmpty(list)) {
				return 0L;
			} else {
				return list.size();
			}
		}
	}
	
	/**
	 * 【通过Mybatis插件方式】执行SQL排序功能
	 * 
	 * @param orderBy
	 */
	public static void excuteSort(String orderBy) {
		if (StringUtils.isNotBlank(orderBy)) {
			OrderByHelper.orderBy(orderBy);
		}
	}
	
	/**
	 * 【通过Mybatis插件方式】执行SQL分页和排序功能
	 * 
	 * @param orderBy
	 * @param paging
	 */
	public static void excuteSortAndPage(String orderBy, Paging paging) {
		excuteSort(orderBy);
		excutePage(paging);
	}
}
