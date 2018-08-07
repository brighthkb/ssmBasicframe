package com.sczh.core.task.quartz.job;

import java.util.Map;

/**
 * JOB任务抽象类
 */
//@DisallowConcurrentExecution //防止并发执
public abstract class Job implements org.quartz.Job{
	protected Map<String, Object> taskConfig;//当前Job的任务配置
	//在Job context中取值，与如上取值方式效果一样
    //context.getMergedJobDataMap().get("taskConfig");

	
	public void setTaskConfig(Map<String, Object> taskConfig) {
		this.taskConfig = taskConfig;
	}
}
