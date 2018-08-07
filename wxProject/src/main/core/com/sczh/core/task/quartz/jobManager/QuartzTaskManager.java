package com.sczh.core.task.quartz.jobManager;

import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.sczh.core.task.service.ITaskConfigService;

/**
 * Quartz自定义任务管理器 
 */
public class QuartzTaskManager {
	private static final Logger log = LoggerFactory.getLogger(QuartzTaskManager.class);
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	private ITaskConfigService taskConfigService;

	//Bean工厂方法，初始化并加载调度任务
	public void init() throws Exception {
		//获取调度器并启动--基于spring
		Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
		scheduler.start();
		//查询任务并添加到调度中
		List<Map<String, Object>> taskConfigs = this.taskConfigService.qryTaskConfig(null);
		for (Map<String, Object> taskConfig : taskConfigs) {
			try {
				//任务配置参数
				String jobName = taskConfig.get("TASK_ID")+"_JOB_NAME";
				String triggerName = taskConfig.get("TASK_ID")+"_TRIGGER_NAME";
				String groupName = taskConfig.get("TASK_ID")+"_GROUP_NAME";
				String cronExpression = (String)taskConfig.get("CRON_EXPR");
				Class jobClass = Class.forName((String)taskConfig.get("JOB_CLASS"));
				//任务		
				JobDetail jobDetail = JobBuilder.newJob(jobClass)
					      .withIdentity(jobName, groupName)
					      //.usingJobData(dataKey, value) //简单数据类型的参数传递
					      //.usingJobData(newJobDataMap) //复杂数据类型的参数传递,newJobDataMap = new JobDataMap();
					      .build();
				//复杂数据类型的参数传递--与上效果等同
				jobDetail.getJobDataMap().put("taskConfig", taskConfig);
				//触发器
				Trigger trigger = TriggerBuilder.newTrigger()
					      .withIdentity(triggerName,groupName)
					      .startNow()
					      .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					      .build();
				//添加任务到调度中
				scheduler.scheduleJob(jobDetail, trigger);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("调度任务[{}]加载失败！", taskConfig.get("TASK_NAME"));
			}
		}
	}
}
