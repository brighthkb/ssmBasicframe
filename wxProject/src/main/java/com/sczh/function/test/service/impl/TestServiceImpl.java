package com.sczh.function.test.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.PagingUtils;
import com.sczh.core.web.dto.Result;
import com.sczh.function.test.mapper.TestMapper;
import com.sczh.function.test.model.Subject;
import com.sczh.function.test.service.ITestService;

@Service
public class TestServiceImpl implements ITestService {
	 @Autowired
	 private TestMapper testMapper;

	@Override
	public List<Subject> getSubjectList(Paging paging, Map<String, Object> mapQuery) {
	//	mapQuery = PagingUtils.appendPageParam(mapQuery, paging);
		List<Subject> list = testMapper.getSubjectList(mapQuery);
		return list;
	}

	@Override
	public Result add(String key, String userId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String, Object>> list = testMapper.getValueBuKey(key);
		if(null != list && list.size()>0 && StringUtils.isNotEmpty(userId)) {
			if(null != userId) {
				map.put("key", key);
				map.put("value", list.get(0).get("value"));
				map.put("userid", userId);
				map.put("id",UUID.randomUUID().toString().replaceAll("-", ""));
				testMapper.add(map);
				return  new Result(true,(String)list.get(0).get("value"));
			}
		}else {
			new Result(false,"系统内部错误，请稍后再试！");
		}
		return  new Result(false,"添加对象不能为空！");
	
	}
}
