package com.liy.generator.quartz.listener;

import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JobListenerConfig extends AdaptableJobFactory {

    @Autowired
    Scheduler scheduler;

    /**
     * AutowireCapableBeanFactory接口是BeanFactory的子类
     * 可以连接和填充那些生命周期不被Spring管理的已存在的bean实例
     */
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @PostConstruct
    public void init() {
        try {
            JobListener jobListener = new SystemJobListener();
            capableBeanFactory.autowireBean(jobListener);
            scheduler.getListenerManager().addJobListener(jobListener);
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }
}
