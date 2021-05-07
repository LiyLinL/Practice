package com.liy.generator.quartz.listener;

import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JobListenerConfig {

    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void init() {
        try {
            JobListener jobListener = new SystemJobListener();
            scheduler.getListenerManager().addJobListener(jobListener);
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }
}
