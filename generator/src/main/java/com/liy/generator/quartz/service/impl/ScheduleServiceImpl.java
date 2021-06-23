package com.liy.generator.quartz.service.impl;

import com.liy.generator.domain.TaskInfo;
import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.quartz.service.ScheduleService;
import com.liy.generator.quartz.util.ScheduleUtil;
import com.liy.generator.service.QuartzService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService, InitializingBean {

    @Autowired
    Scheduler scheduler;

    @Autowired
    private QuartzService quartzService;

    @Override
    public void afterPropertiesSet() throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("Name", "Test");
//        map.put("Scheduler", "true");
//
//        List<QuartzTaskInformations> list = quartzService.findJob();
//        if (list.size() > 0) {
//            list.forEach(obj -> {
//                ScheduleUtil.createScheduleJob(scheduler, obj.getTaskName(), obj.getClassName(), "default",
//                        "description", obj.getSchedulerRule(), map);
//
//                if (!obj.getFrozenStatus().equals("0")) {
//                    QuartzTaskInformations quartzTaskInformations = new QuartzTaskInformations();
//                    quartzTaskInformations.setTaskName(obj.getTaskName());
//                    quartzTaskInformations.setFrozenStatus("0");
//                    quartzService.updateJob(quartzTaskInformations);
//                }
//            });
//        }
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
    public void updJob( TaskInfo taskInfo ) {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Test");
        map.put("Scheduler", "true");

        ScheduleUtil.updateScheduleJob(scheduler, taskInfo.getTaskNo(), "default", taskInfo.getCron(), map);

        QuartzTaskInformations quartzTaskInformations = new QuartzTaskInformations();
        quartzTaskInformations.setTaskName(taskInfo.getTaskNo());
        quartzTaskInformations.setSchedulerRule(taskInfo.getCron());
        quartzTaskInformations.setFrozenStatus("0");
        quartzService.updateJob(quartzTaskInformations);
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

        QuartzTaskInformations quartzTaskInformations = new QuartzTaskInformations();
        quartzTaskInformations.setTaskName("program1");
        quartzTaskInformations.setFrozenStatus("1");
        quartzService.updateJob(quartzTaskInformations);
    }

    @Override
    public void resumeJob() {
        ScheduleUtil.resumeScheduleJob(scheduler, "program1", "default");

        QuartzTaskInformations quartzTaskInformations = new QuartzTaskInformations();
        quartzTaskInformations.setTaskName("program1");
        quartzTaskInformations.setFrozenStatus("0");
        quartzService.updateJob(quartzTaskInformations);
    }
}
