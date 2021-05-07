package com.liy.generator.quartz.listener;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;

import java.util.Date;
import java.util.Map;

public class SystemJobListener extends JobListenerSupport {

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public void jobToBeExecuted( JobExecutionContext context ) {
    }

    @Override
    public void jobWasExecuted( JobExecutionContext context, JobExecutionException jobException ) {
        long runTime = context.getJobRunTime();
        JobDetail jobDetail = context.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String jobGroup = jobDetail.getKey().getGroup();
        Map jobDataMap = jobDetail.getJobDataMap().getWrappedMap();

        if (jobException != null) {
            System.out.println("Fail");
        } else {
            System.out.println("Success");
        }

        String jobKey = context.getJobDetail().getKey().toString();
        System.out.println(jobKey + " ==== " + new Date());
    }
}
