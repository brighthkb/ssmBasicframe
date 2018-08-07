package com.sczh.core.task.test;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sczh.core.task.quartz.job.Job;
import com.sczh.systemmanage.service.IPermissionService;

/**
 * 测试-自定义JOB任务
 */
@DisallowConcurrentExecution
// 防止并发执行
public class TestJob extends Job {
	private static final Logger log = LoggerFactory.getLogger(TestJob.class);

	@Autowired
	private IPermissionService permissionService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("调度任务名称 : {}", this.taskConfig.get("TASK_NAME"));
		
		try {
			System.out.println(permissionService.findPermission(null));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
