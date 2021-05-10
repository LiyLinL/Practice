package com.liy.generator.quartz.service.impl;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.quartz.service.ScheduleService;
import com.liy.generator.quartz.util.ScheduleUtil;
import com.liy.generator.service.QuartzService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService, InitializingBean {

    @Autowired
    Scheduler scheduler;

    @Autowired
    private QuartzService quartzService;

    @Override
    public void afterPropertiesSet() throws Exception {
        String jobName = "program1";
        String jobClass = "com.liy.generator.quartz.Job.ProgramFactory1";
        String cronExpression = "* 1 * * * ?";
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Test");
        map.put("Scheduler", "true");

        ScheduleUtil.createScheduleJob(scheduler, jobName, jobClass, "default",
                "description", cronExpression, map);

        List<QuartzTaskInformations> list = quartzService.findJob();
        if (list.size() == 0) {
            QuartzTaskInformations quartzTaskInformations = new QuartzTaskInformations();
            quartzTaskInformations.setTaskNo(jobName);
            quartzTaskInformations.setTaskName(jobName);
            quartzTaskInformations.setClassName(jobClass);
            quartzTaskInformations.setSchedulerRule(cronExpression);
            quartzTaskInformations.setFrozenStatus("0");
            quartzTaskInformations.setCreateTime(new Date());
            quartzService.insertJob(quartzTaskInformations);
        }
    }

    @Override
    public void addJob() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Test");
        map.put("Scheduler", "true");

        ScheduleUtil.createScheduleJob(scheduler, "program1", "com.liy.generator.quartz.Job.ProgramFactory1", "default",
                "description", "* 1 * * * ?", map);
    }

    @Override
    public void deleteJob() {
        ScheduleUtil.deleteScheduleJob(scheduler, "program1", "default");
    }

    @Override
    public void updJob() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Test");
        map.put("Scheduler", "true");

        ScheduleUtil.updateScheduleJob(scheduler, "program1", "default", "*/5 * * * * ?", map);
    }

    @Override
    public void runJob() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Test");
        map.put("Scheduler", "true");

        ScheduleUtil.runScheduleJob(scheduler, "program1", "default", map);
    }

    @Override
    public void pauseJob() {
        ScheduleUtil.pauseScheduleJob(scheduler, "program1", "default");
    }

    @Override
    public void resumeJob() {
        ScheduleUtil.resumeScheduleJob(scheduler, "program1", "default");
    }
}
