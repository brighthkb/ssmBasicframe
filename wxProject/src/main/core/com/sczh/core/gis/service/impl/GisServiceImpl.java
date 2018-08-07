package com.sczh.core.gis.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.PagingUtils;

import com.sczh.core.gis.mapper.GisMapper;
import com.sczh.core.gis.service.GisService;

@Service
public class GisServiceImpl implements GisService {
	private static Logger logger = LoggerFactory.getLogger(GisServiceImpl.class);
	
	@Autowired
	private GisMapper gisMapper;
	
	public List<Map<String, Object>> findJiZhanList(Map<String, Object> mapQuery) {
		return gisMapper.findJiZhanList(mapQuery);
	}
	
	public List<Map<String, Object>> getCityMenu() {
		return gisMapper.getCityMenu();
	}
	
	public List<Map<String, Object>> getCityPosition() {
		return gisMapper.getCityPosition();
	}
	
	public List<Map<String, Object>> getCountynamePosition(Map<String, Object> mapQuery) {
		return gisMapper.getCountynamePosition(mapQuery);
	}
	
	public List<Map<String, Object>> loadProvinceBData(Map<String, Object> mapQuery) {
		return gisMapper.loadProvinceBData(mapQuery);
	}
	
	public List<Map<String, Object>> searchResourceInfo(Map<String, Object> mapQuery) {
		return gisMapper.searchResourceInfo(mapQuery);
	}
	
	public Map<String, Object> queryProCellNum(Map<String, Object> mapQuery) {
		return gisMapper.queryProCellNum(mapQuery);
	}
	
	public Map<String, Object> queryColumns(Map<String, Object> mapQuery) {
		return gisMapper.queryColumns(mapQuery);
	}
	
	public List<Map<String, Object>> searchCapInfo(Map<String, Object> mapQuery) {
		return gisMapper.searchCapInfo(mapQuery);
	}
	
	public List<Map<String, Object>> searchCapInfoMessage(Map<String, Object> mapQuery) {
		return gisMapper.searchCapInfoMessage(mapQuery);
	}
	
	public List<Map<String, Object>> queryGiveAnAlarmCoulmn(Map<String, Object> mapQuery) {
		return gisMapper.queryGiveAnAlarmCoulmn(mapQuery);
	}
	
	public List<Map<String, Object>> queryGiveAnAlarmLine(Map<String, Object> mapQuery) {
		return gisMapper.queryGiveAnAlarmLine(mapQuery);
	}
}