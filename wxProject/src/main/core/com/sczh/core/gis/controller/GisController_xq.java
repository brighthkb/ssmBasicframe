package com.sczh.core.gis.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.sczh.core.config.ConfigUtils;
import com.sczh.core.gis.service.GisService;
/*import com.sczh.core.gis.service.IImageScrollService;*/
/*import com.sczh.core.gis.utils.EmergencyJKTopoUtils;
import com.sczh.core.gis.utils.EmergencyUtils;
import com.sczh.core.gis.utils.EmergencyWXTopoUtils;*/
import net.sf.json.JSONArray;

/**
 * 突发事件场景
 * 
 */
@Controller
@RequestMapping("/gis")
public class GisController_xq {

	private static final Logger logger = LoggerFactory.getLogger(GisController_xq.class);

	@Autowired
	private GisService gisService;
	
	/** 突发事件GIS图层面板  */
	@RequestMapping("/getEmergencyGisMapLayer")
	public String getEmergencyGisMapLayer(Model model,
			@RequestParam(value = "senId", required = false) String senId) {
		return "/gis/gisMapLayer_xq";
	}
	
	/** 获取地市city树状图  */
	@RequestMapping("/getCityMenuPage")
	public String getCityMenuPage(Model model,
			@RequestParam(value = "mapDivId", required = false) String mapDivId) {
		logger.info("返回 cityMenuPage 页面 id是:" + mapDivId);
		return "/gis/cityMenuPage";
	}
	
	/**
	 *  查询2G/3G/4G基站
	 */
	@RequestMapping("/findJiZhanList_xq")
	@ResponseBody
	public List<Map<String, Object>> findJiZhanList_xq(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "btsEquipmentType", required = false) String btsEquipmentType,
			@RequestParam(value = "btsFaultType", required = false) String btsFaultType) {
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("city", city);
		mapQuery.put("btsEquipmentType", btsEquipmentType);
		
		logger.info(city + btsEquipmentType + btsFaultType);
		
		if("退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.findJiZhanList(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.findJiZhanList(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			return list1 ;
		}else if("正常,退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.findJiZhanList(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.findJiZhanList(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.findJiZhanList(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			list1.addAll(list);
			return list1 ;
		}else if("正常,退服".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.findJiZhanList(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.findJiZhanList(mapQuery);
			
			list1.addAll(list);
			return list1 ;
		}else if("正常,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.findJiZhanList(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.findJiZhanList(mapQuery);
			
			list2.addAll(list);
			return list2 ;
		}else{
			mapQuery.put("btsFaultType", btsFaultType);
			return gisService.findJiZhanList(mapQuery);
		}
		
	}
	
	/** 获取省份菜单 */
	@RequestMapping("/getCity")
	@ResponseBody
	public List<Map<String, Object>> getCityMenu() {
		logger.info(gisService.getCityMenu().toString());
		return gisService.getCityMenu();
	}
	
	/** 查询当前区县的基站信息 */
	@RequestMapping("/getCountynamePosition")
	@ResponseBody
	public List<Map<String, Object>> getCountynamePosition(
			@RequestParam(value = "btsEquipmentType", required = false) String btsEquipmentType,
			@RequestParam(value = "btsFaultType", required = false) String btsFaultType,
			@RequestParam(value = "countyname", required = false) String countyname) {
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("btsEquipmentType", btsEquipmentType);
		mapQuery.put("countyname", countyname);
		
		logger.info("查询区县基站信息                  开始-----------------------------------------------------------------");
		logger.info("查询区县基站信息   参数 btsEquipmentType:" + btsEquipmentType);
		logger.info("查询区县基站信息   参数 btsFaultType:" + btsFaultType);
		
		if("退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.getCountynamePosition(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.getCountynamePosition(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			return list1 ;
		}else if("正常,退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.getCountynamePosition(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.getCountynamePosition(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.getCountynamePosition(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			list1.addAll(list);
			return list1 ;
		}else if("正常,退服".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.getCountynamePosition(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.getCountynamePosition(mapQuery);
			
			list1.addAll(list);
			return list1 ;
		}else if("正常,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.getCountynamePosition(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.getCountynamePosition(mapQuery);
			
			list2.addAll(list);
			return list2 ;
		}else{
			mapQuery.put("btsFaultType", btsFaultType);
			return gisService.getCountynamePosition(mapQuery);
		}
		
	}
	
	/** 查询全省的基站信息 */
	@RequestMapping("/loadProvinceBData")
	@ResponseBody
	public List<Map<String, Object>> loadProvinceBData(
			@RequestParam(value = "btsEquipmentType", required = false) String btsEquipmentType,
			@RequestParam(value = "btsFaultType", required = false) String btsFaultType
			) {
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("btsEquipmentType", btsEquipmentType);
		
		logger.info("查询区县基站信息                  开始-----------------------------------------------------------------");
		logger.info("查询区县基站信息   参数 btsEquipmentType:" + btsEquipmentType);
		logger.info("查询区县基站信息   参数 btsFaultType:" + btsFaultType);
		
		if("退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.loadProvinceBData(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.loadProvinceBData(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			return list1 ;
		}else if("正常,退服,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.loadProvinceBData(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.loadProvinceBData(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.loadProvinceBData(mapQuery);
			
			list1.removeAll(list2);
			list1.addAll(list2);
			list1.addAll(list);
			return list1 ;
		}else if("正常,退服".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.loadProvinceBData(mapQuery);
			mapQuery.put("btsFaultType", "退服");
			List<Map<String, Object>> list1 = gisService.loadProvinceBData(mapQuery);
			
			list1.addAll(list);
			return list1 ;
		}else if("正常,停电".equals(btsFaultType)){
			mapQuery.put("btsFaultType", "正常");
			List<Map<String, Object>> list = gisService.loadProvinceBData(mapQuery);
			mapQuery.put("btsFaultType", "停电");
			List<Map<String, Object>> list2 = gisService.loadProvinceBData(mapQuery);
			
			list2.addAll(list);
			return list2 ;
		}else{
			mapQuery.put("btsFaultType", btsFaultType);
			return gisService.loadProvinceBData(mapQuery);
		}
		
	}
	
	/** 获取resourceView 界面 */
	@RequestMapping("/getResourceView")
	public String getResourceView(Model model,
			@RequestParam(value = "senId", required = false) String senId) {
		return "/gis/resourceView";
	}
	
	/**查询基站资源**/
	@RequestMapping("/searchResourceInfo")
	@ResponseBody
	public List<Map<String, Object>> searchResourceInfo(
			@RequestParam(value = "OBJECTID", required = false) String OBJECTID, 
			@RequestParam(value = "OBJECT_TYPE", required = false) String OBJECT_TYPE,
			@RequestParam(value = "COUNTYNAME", required = false) String COUNTYNAME) {
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("OBJECTID", OBJECTID);
		mapQuery.put("OBJECT_TYPE", OBJECT_TYPE);
		
		logger.info("OBJECTID:" + OBJECTID);
		logger.info("OBJECT_TYPE:" + OBJECT_TYPE);
		logger.info("COUNTYNAME:" + COUNTYNAME);
		
		List<Map<String, Object>> list = gisService.searchResourceInfo(mapQuery);
		logger.info("获取字段:" + list.toString());
		Map<String, Object> map = gisService.queryProCellNum(mapQuery);
		map.put("RESOURCE_TYPE","基本信息");
		map.put("value",map.get("count"));
		map.put("RES_COL_LABEL","工程状态小区总数");
		
		StringBuffer sql = new StringBuffer("SELECT '1'");
		for(int i = 0; i < list.size();i++){
			sql.append("," + list.get(i).get("RES_COLUMN"));
			if(i == list.size() - 1){
				sql.append(" FROM " + list.get(i).get("RES_TABLE"));
			}
		}
		sql.append(" WHERE objectid = '" + OBJECTID + "'");
		mapQuery.put("sql", sql);
		logger.info("全部数据查询sql:" + sql);
		Map<String, Object> map1 = gisService.queryColumns(mapQuery);
		logger.info("数据返回:" + map1.toString());
		for(Map<String, Object> j : list){
			String RES_COLUMN = j.get("RES_COLUMN").toString();
			j.put("value", map1.get(RES_COLUMN));
			logger.info(RES_COLUMN + map1.get(RES_COLUMN));
		}
		
		list.add(map);
		logger.info("返回数据:" + list.toString());
		return list;
	}
	
	/** 获取resourceView 界面 */
	@RequestMapping("/getPerformance")
	public String getPerformance(Model model,
			@RequestParam(value = "senId", required = false) String senId) {
		return "/gis/performance";
	}
	
	/**性能查看**/
	@RequestMapping("/searchCapInfo")
	@ResponseBody
	public Map<String, Object> searchCapInfo(
			@RequestParam(value = "OBJECTID", required = false) String OBJECTID, 
			@RequestParam(value = "OBJECT_TYPE", required = false) String OBJECT_TYPE,
			@RequestParam(value = "COUNTYNAME", required = false) String COUNTYNAME) {
		
		if (OBJECTID != null && OBJECTID.indexOf(",") > 0) {
			OBJECTID = OBJECTID.replaceAll(",", "','");
		}
		
		logger.info("OBJECTID :" + OBJECTID);
		logger.info("OBJECT_TYPE :" + OBJECT_TYPE);
		logger.info("COUNTYNAME :" + COUNTYNAME);
		String nmsType = "资源性能";
		String neType  = OBJECT_TYPE;
		
		if ("MSS".equals(neType)) {
			neType = "MSC";
		}
		
		if (neType.equals("HOTSPOT") || neType.equals("WLAN_AP")) {
			nmsType = "数据网";
		}
		
		if ("enodeb".equalsIgnoreCase(neType)) {
			neType = "ENODEB";
		}
		
		
		
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("OBJECTID", OBJECTID);
		mapQuery.put("neType", neType);
		mapQuery.put("nmsType", nmsType);
		logger.info(gisService.searchCapInfo(mapQuery).toString());
		List<Map<String, Object>> list = gisService.searchCapInfo(mapQuery);
		
		logger.info("返回字段:" + list.toString());
		
		StringBuffer sql = new StringBuffer("SELECT createtime");
		for(int i = 0; i < list.size();i++){
			sql.append("," + list.get(i).get("PERF_COLUMN"));
			if(i == list.size() - 1){
				sql.append(" FROM " + list.get(i).get("PERF_TABLE").toString().toLowerCase().replace("_tp", ""));
			}
		}
		StringBuffer sqlStr = new StringBuffer("SELECT * FROM (" + sql + " t ");
		sqlStr.append("WHERE t.objectid = '" + OBJECTID + "' AND t.INTOTIME > sysdate - 2 ");
		if(neType.equals("ENODEB")) sqlStr.append("AND t.granularity = '15' ");
		sqlStr.append("ORDER by createtime desc) WHERE rownum <= 12 ");
		sqlStr.append("ORDER by createtime ");
		
		logger.info("sql:" + sqlStr);
		mapQuery.put("sql", sqlStr);
		List<Map<String, Object>> list1 = gisService.searchCapInfoMessage(mapQuery);
		
		//传入拼写SQL
		logger.info("返回数据:" + list1.toString());
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("coulmn", list);
		json.put("line", list1);
		return json;
	}
	
	/** 获取resourceView 界面 */
	@RequestMapping("/getGiveAnAlarm")
	public String getGiveAnAlarm(Model model,
			@RequestParam(value = "senId", required = false) String senId) {
		return "/gis/giveAnAlarm";
	}
	
	/** 加载Gis的iframe页面 */
	@RequestMapping("/iframe_xq")
	public String list(Model model) {
		model.addAttribute("arcgis_rest_services_tiledurl", ConfigUtils.getConfig("arcgis_rest_services_tiledurl_sczhNetwork"));
		model.addAttribute("arcgis_rest_services_tiledurl2", ConfigUtils.getConfig("arcgis_rest_services_tiledurl_mobileNetwork"));
		return "gis/iframe";
	}
	
	/**告警查看**/
	@RequestMapping("/giveAnAlarm")
	@ResponseBody
	public Map<String, Object> giveAnAlarm(
			@RequestParam(value = "OBJECTID", required = false) String OBJECTID, 
			@RequestParam(value = "OBJECT_TYPE", required = false) String OBJECT_TYPE,
			@RequestParam(value = "COUNTYNAME", required = false) String COUNTYNAME,
			@RequestParam(value = "FAULT_TYPE", required = false) String FAULT_TYPE) {
		Map<String, Object> mapQuery = Maps.newHashMap();
		mapQuery.put("OBJECTID", OBJECTID);
		mapQuery.put("OBJECT_TYPE", OBJECT_TYPE);
		mapQuery.put("COUNTYNAME", COUNTYNAME);
		mapQuery.put("FAULT_TYPE", FAULT_TYPE);			//基站类型 停电 退服 正常
		if(OBJECT_TYPE.equals("ENODEB")) OBJECT_TYPE = "ENodeB";
		
		logger.info("OBJECTID : " + OBJECTID);
		logger.info("OBJECT_TYPE : " + OBJECT_TYPE);
		logger.info("COUNTYNAME : " + COUNTYNAME);
		logger.info("FAULT_TYPE : " + FAULT_TYPE);
		
		List<Map<String, Object>> list = gisService.queryGiveAnAlarmCoulmn(mapQuery);
		logger.info("返回字段 : " + list.toString());
		StringBuffer sql = new StringBuffer("SELECT '1'");
		for(int i = 0; i < list.size();i++){
			sql.append("," + list.get(i).get("RES_COLUMN"));
			if(i == list.size() - 1){
				if(FAULT_TYPE.equals("3")){
					sql.append(" FROM " + "(SELECT *  FROM fm_alarm f  WHERE f.title in ('市电停电告警', '停电告警','一级低压脱离断开告警','电池组总电压过低告警','直流欠压告警','输出电压过低告警')");
					sql.append(" and f.is_cleared = 0  and f.first_occurrence_time > sysdate - 10 and exists (select 1 from rm_allbts_mv rm where rm.dh_juzhan = f.ne_name");
					sql.append(" and rm.objectid = '" + OBJECTID + "')");
					sql.append(" union all SELECT * FROM fm_alarm f WHERE f.title in ('一级低压脱离告警', '交流输入停电告警', '直流输出电压过低告警', '电池总电压过低','二级低压脱离告警','交流电压过低告警')");
					sql.append(" and f.is_cleared = 0 and f.first_occurrence_time > sysdate - 10 and (exists (select 1 from rm_allbts_mv rm join rm_site rs");
					sql.append(" on rm.site = rs.objectid where rs.objectid = f.ne_id and rm.objectid = '" + OBJECTID + "') or exists");
					sql.append(" (select 1  from rm_allbts_mv rm  join rm_room rs on rm.room = rs.objectid  where rs.objectid = f.ne_id");
					sql.append(" and rm.objectid = '" + OBJECTID + "')))");
				}else{
					sql.append(" FROM " + list.get(i).get("RES_TABLE"));
					sql.append(" t where t.resource_id = '" + OBJECTID + "' and t.device_class = '" + OBJECT_TYPE + "'");
				}
			}
		}
		
		logger.info("sql : " + sql.toString());
		mapQuery.put("sql",sql);
		List<Map<String, Object>> list1 = gisService.queryGiveAnAlarmLine(mapQuery);
		logger.info("返回数据 : " + list1.toString());
		
		Map<String,Object> json = new HashMap<String,Object>();
		json.put("coulmn", list);
		json.put("line", list1);
		return json;
	}
}