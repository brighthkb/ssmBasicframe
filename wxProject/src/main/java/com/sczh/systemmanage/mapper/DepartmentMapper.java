package com.sczh.systemmanage.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sczh.systemmanage.model.Department;
@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    /**
	 *  分页查询部门信息
	 */
	public List<Department> findDeptByPage(Map<String,Object> mapQuery);
	/**
	 * 查询总共的部门数量
	 * @param mapQuery
	 * @return
	 */
	public int count(Map<String,Object> mapQuery);
	/**
	 * 判断新建的部门是否存在
	 * @param dept
	 * @return
	 */
	int isExist(Department dept);

	List<Department> findAllDept(Map<String,Object> mapQuery) throws Exception;

}