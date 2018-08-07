package com.sczh.function.test.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.Result;
import com.sczh.function.test.model.MapValueComparator;
import com.sczh.function.test.model.Subject;
import com.sczh.function.test.service.ITestService;
import com.sczh.weixin.model.WxUser;
/***
 * 台账管理---材料管理控制器
 * @author lan
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
    private ITestService testService;
	/**
	 * 获取LIST
	 * @param model
	 * @param oper
	 * @return
	 */
    @RequestMapping("/toup")
    public String getMaterialList(Model model) {  
    	Map<String, Object> mapQuery = new HashMap<String, Object>();
    	List<Subject> subjectList = testService.getSubjectList(new Paging(),mapQuery);
    	model.addAttribute("pagingList", subjectList);
    	return "function/test/toup";
    }
    @RequestMapping("/getSubjectList")
	public @ResponseBody List<Subject> getCostMachineDetail(Paging paging){
		 Map<String, Object> mapQuery = new HashMap<String, Object>();
		return testService.getSubjectList(paging,mapQuery);
	}
    /***
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(int R,int A,int I,int S,int E,int C,HttpServletRequest request) {
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> mp = (Map<String, String>) request.getSession().getAttribute("wxuseropp");
			String userId = mp.get("openid");
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("R",R);
			map.put("A",A);
			map.put("I",I);
			map.put("S",S);
			map.put("E",E);
			map.put("C",C);
			 Map<String, Integer> resultMap = sortMapByValue(map); 
			 StringBuffer value = new StringBuffer();
			 for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
				 	value.append(entry.getKey());
				 	if(value.length()==3) {
				 		break;
				 	}
		      }
			return  testService.add(value.toString(), userId);
		} catch (Exception e) {
			logger.error("新增出错", e);
			return new Result(false, "未知异常，新增失败！");
		}
    }
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());
        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
}
