package com.gsoeller.armstrong.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DeployJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("deploying " + context.getJobDetail().getJobDataMap().getString("applicationName"));
	}
	
	

}
