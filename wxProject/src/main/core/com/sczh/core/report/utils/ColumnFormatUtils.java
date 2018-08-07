package com.sczh.core.report.utils;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.sczh.core.utils.DateUtils;

/**
 * 定义列格式化函数
 * 
 */
public class ColumnFormatUtils {
	// 格式化日期
	public static String formatData(Object val, Object row) {
		if (val != null && val instanceof Date)
			return DateUtils.getFormatTimeString((Date) val, "yyyy-MM-dd");

		return null;
	}

	// 格式化时间
	public static String formatTime(Object val, Object row) {
		if (val != null && val instanceof Date)
			return DateUtils.getFormatTimeString((Date) val,"yyyy-MM-dd HH:mm:ss");

		return null;
	}

	// 格式化告警类型
	public static String formatAlarmType(Object val, Object row) {
		if ("delay".equals(val)) {
			return "时延ms";
		} else if ("jitter".equals(val)) {
			return "抖动ms";
		} else if ("packetLossRatio".equals(val)) {
			return "丢包率%";
		} else {
			return ObjectUtils.toString(val, null);
		}
	}
	
	// 格式化派单延时
	public static String formatEomsSendDelay(Object val, Object row) {
		if (StringUtils.isNotBlank(ObjectUtils.toString(val)))
			return ObjectUtils.toString(val) + "分钟";

		return null;
	}
		
	// 格式化派单状态
	public static String formatEnabled(Object val, Object row) {
		if ("0".equals(ObjectUtils.toString(val))) {
			return "启用";
		} else if ("1".equals(ObjectUtils.toString(val))) {
			return "未启用";
		} else {
			return ObjectUtils.toString(val, null);
		}
	}
		
	// 格式化审核状态
	public static String formatAudited(Object val, Object row) {
		if ("0".equals(ObjectUtils.toString(val))) {
			return "已审核";
		} else if ("1".equals(ObjectUtils.toString(val))) {
			return "未审核";
		} else {
			return ObjectUtils.toString(val, null);
		}
	}
		
	// 格式化审核状态
	public static String formatSeverity(Object val, Object row) {
		if ("1".equals(ObjectUtils.toString(val))) {
			return "一级";
		} else if ("2".equals(ObjectUtils.toString(val))) {
			return "二级";
		} else if ("3".equals(ObjectUtils.toString(val))) {
			return "三级";
		} else if ("4".equals(ObjectUtils.toString(val))) {
			return "四级";
		} else {
			return ObjectUtils.toString(val, null);
		}
	}
	
	// 格式化周期
	public static String formatGranularity(Object val, Object row) {
		if("DAY".equals(val)){
			return "日";  
		}else if("WEEK".equals(val)){
			return "周";  
		}else if("MONTH".equals(val)){
			return "月";  
		}else{
			return ObjectUtils.toString(val, null);
		}
	}
	
	// 格式化地市
	@SuppressWarnings("unchecked")
	public static String formatCityAndDISTRICT(Object val, Object row) {
		Map<String,Object> map = (Map<String,Object>)row; 
		String city = (String) map.get("CITY");
		String district = (String) map.get("DISTRICT");
		if(StringUtils.isBlank(district)){
			return ObjectUtils.toString(val, null);
		}else{
			return ObjectUtils.toString(district, null);
		}
	}
}