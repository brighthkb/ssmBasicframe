package com.sczh.function.test.service;

import java.util.List;
import java.util.Map;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.Result;
import com.sczh.function.test.model.Subject;

public interface ITestService {

	List<Subject> getSubjectList(Paging paging, Map<String, Object> mapQuery);
	public Result add(String key,String userId)throws Exception;
}
