package com.sczh.core.gis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface GisMapper {

	/**
	 * 查询当前所有的有效场景
	 * 
	 * @date 2017年6月29日
	 * @param mapQuery
	 * @return
	 */
	List<Map<String, Object>> findJiZhanList(Map<String, Object> mapQuery);
	
	/**
	 * 查询地市菜单
	 * 
	 * @date 2017年7月1日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> getCityMenu();
	/**
	 * 查询地市菜单
	 * 
	 * @date 2017年7月1日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> getCityPosition();
	
	/**
	 * 查询当前区县的第一个基站经纬度
	 * 
	 * @date 2017年7月1日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> getCountynamePosition(Map<String, Object> mapQuery);
	
	/**
	 * 查询基站资源
	 * 
	 * @date 2017年7月1日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> searchResourceInfo(Map<String, Object> mapQuery);
	/**
	 * 查询小区
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public Map<String, Object> queryProCellNum(Map<String, Object> mapQuery);
	/**
	 * 查询小区
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public Map<String, Object> queryColumns(Map<String, Object> mapQuery);
	/**
	 * 性能查看
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> searchCapInfo(Map<String, Object> mapQuery);
	/**
	 * 性能查看数据查询
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> searchCapInfoMessage(Map<String, Object> mapQuery);
	/**
	 * 告警字段数据查询
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> queryGiveAnAlarmCoulmn(Map<String, Object> mapQuery);
	/**
	 * 告警数据查询
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> queryGiveAnAlarmLine(Map<String, Object> mapQuery);
	
	/**
	 * 查询全省基站信息
	 * 
	 * @date 2017年8月18日
	 * @param mapQuery
	 * @return
	 */
	public List<Map<String, Object>> loadProvinceBData(Map<String, Object> mapQuery);
	
}
