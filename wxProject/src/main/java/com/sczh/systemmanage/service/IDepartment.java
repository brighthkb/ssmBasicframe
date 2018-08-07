package com.sczh.systemmanage.service;

import java.util.List;
import java.util.Map;

import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.model.Department;

public interface IDepartment {

	PagingResult<Department> findDeptByPage(Paging paging, Map<String, Object> mapQuery);

	Department viewUser(Department dept);

	Result add(Department dept);

	Result edit(Department dept);

	Result delete(Department dept);

	List<Department> findAllDept() throws Exception;

}
