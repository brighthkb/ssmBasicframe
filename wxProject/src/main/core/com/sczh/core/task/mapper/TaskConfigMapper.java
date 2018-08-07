package com.sczh.core.task.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskConfigMapper {	
	/**
	 * 查询定时任务配置
	 * @param req
	 * @return
	 */
	public abstract List<Map<String, Object>> qryTaskConfig(Map<String, Object> req);
}
