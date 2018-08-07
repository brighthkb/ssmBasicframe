package com.sczh.core.task.service;

import java.util.List;
import java.util.Map;

/**
 * 定时任务配置
 */
public interface ITaskConfigService {
	/**
	 * 查询定时任务配置
	 * @param req
	 * @return
	 */
	public List<Map<String, Object>> qryTaskConfig(Map<String, Object> req);
}
