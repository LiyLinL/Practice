package com.liy.generator.quartz.listener;

import com.liy.generator.entity.QuartzTaskRecords;
import com.liy.generator.service.QuartzService;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

public class SystemJobListener extends JobListenerSupport {

    @Autowired
    private QuartzService quartzService;

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public void jobToBeExecuted( JobExecutionContext context ) {
    }

    @Override
    public void jobWasExecuted( JobExecutionContext context, JobExecutionException jobException ) {
        QuartzTaskRecords quartzTaskRecords = new QuartzTaskRecords();

        long runTime = context.getJobRunTime();
        JobDetail jobDetail = context.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String jobGroup = jobDetail.getKey().getGroup();
        Map jobDataMap = jobDetail.getJobDataMap().getWrappedMap();

        if (jobException != null) {
            System.out.println("Fail");
            quartzTaskRecords.setTaskStatus("Fail");
        } else {
            System.out.println("Success");
            quartzTaskRecords.setTaskStatus("Success");
        }

        String jobKey = context.getJobDetail().getKey().toString();
        System.out.println(jobKey + " ==== " + new Date());

        quartzTaskRecords.setTaskNo(jobName);
        quartzTaskRecords.setExecuteTime(new Date());
        quartzService.insertJobRecords(quartzTaskRecords);
    }
}
