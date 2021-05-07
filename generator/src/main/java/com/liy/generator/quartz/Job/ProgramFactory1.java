package com.liy.generator.quartz.Job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ProgramFactory1 implements Job {

    @Override
    public void execute( JobExecutionContext context ) throws JobExecutionException {

        JobDataMap j = context.getMergedJobDataMap();
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String name = String.valueOf(jobDataMap.get("Name"));
        String s = String.valueOf(jobDataMap.get("Scheduler"));
    }
}
