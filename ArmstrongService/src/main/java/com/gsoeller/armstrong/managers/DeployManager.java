package com.gsoeller.armstrong.managers;

import java.util.List;

import org.joda.time.DateTime;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.google.inject.Inject;
import com.gsoeller.armstrong.daos.DeployDao;
import com.gsoeller.armstrong.jobs.DeployJob;
import com.gsoeller.armstrong.pojos.Deploy;

public class DeployManager {

	private DeployDao dao;
	
	@Inject
	public DeployManager(DeployDao dao) {
		this.dao = dao;
	}
	
	public List<Deploy> getDeploys() {
		return dao.getDeploys();
	}
	
	public int deploy(Deploy deploy) throws SchedulerException {
		// need to write a job to deploy something and start the job here
		startDeploy(deploy.getAppName());
		return dao.deploy(deploy.getAppName(), true, DateTime.now().getMillis());
	}
	
	private void startDeploy(String appName) throws SchedulerException {
		SchedulerFactory schedFact = new StdSchedulerFactory();

		  Scheduler sched = schedFact.getScheduler();

		  sched.start();

		  JobDetail job = JobBuilder.newJob(DeployJob.class)
		      .withIdentity("Deploy Job", "group1")
		      .build();
		  
		  job.getJobDataMap().put("applicationName", appName);

		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("Deploy Trigger", "group1")
		      .startNow()
		      .withSchedule(SimpleScheduleBuilder.simpleSchedule())
		      .build();

		  sched.scheduleJob(job, trigger);	  
	}
}
