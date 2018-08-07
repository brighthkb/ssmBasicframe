package com.sczh.systemmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sczh.core.utils.IdentityUtils;
import com.sczh.core.web.dto.Paging;
import com.sczh.core.web.dto.PagingResult;
import com.sczh.core.web.dto.PagingUtils;
import com.sczh.core.web.dto.Result;
import com.sczh.systemmanage.mapper.DepartmentMapper;
import com.sczh.systemmanage.model.Department;
import com.sczh.systemmanage.service.IDepartment;
@Service
public class DepartmentServiceImpl implements IDepartment {
	 @Autowired
	 private DepartmentMapper departmentMapper;
	@Override
	public PagingResult<Department> findDeptByPage(Paging paging, Map<String, Object> mapQuery) {
		mapQuery = PagingUtils.appendPageParam(mapQuery, paging);
		List<Department> list = departmentMapper.findDeptByPage(mapQuery);
		int count = departmentMapper.count(mapQuery);
		return new PagingResult<Department>(count, list);
	}
	@Override
	public Department viewUser(Department dept) {
		if(null == dept.getId()) {
			return null;
		}
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(dept.getId());
	}
	@Override
	public Result add(Department dept) {
		if(departmentMapper.isExist(dept) != 0 ){
			return new Result(false,"部门已存在，新增失败！");
		}
		dept.setId(IdentityUtils.uuid2());
		dept.setStatus(0);
		departmentMapper.insert(dept);
		return new Result(true,"新增成功！");
	}
	@Override
	public Result edit(Department dept) {
		Department dept1 = departmentMapper.selectByPrimaryKey(dept.getId());
		if(null != dept1 && null != dept1.getName() && !dept1.getName().equals(dept.getName())) {
			if(departmentMapper.isExist(dept) != 0 ){
				return new Result(false,"部门已存在，修改失败！");
			}
		}
		departmentMapper.updateByPrimaryKeySelective(dept);
		return new Result(true,"修改成功！");
	}
	@Override
	public Result delete(Department dept) {
		dept.setStatus(1);
		departmentMapper.updateByPrimaryKeySelective(dept);
		return new Result(true,"删除成功！");
	}
	@Override
	public List<Department> findAllDept() throws Exception{
		return departmentMapper.findAllDept(new HashMap<String, Object>());
	}

}
