package com.sczh.core.task.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sczh.core.task.mapper.TaskConfigMapper;
import com.sczh.core.task.service.ITaskConfigService;

@Service
public class TaskConfigServiceImpl implements ITaskConfigService {
	private static final Logger log = LoggerFactory.getLogger(TaskConfigServiceImpl.class);

	@Autowired
	private TaskConfigMapper taskConfigMapper;

	
	@Override
	public List<Map<String, Object>> qryTaskConfig(Map<String, Object> req){
		return this.taskConfigMapper.qryTaskConfig(req);
	}
}
