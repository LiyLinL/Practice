package com.liy.generator.quartz.controller;

import com.liy.generator.domain.RecordsInfo;
import com.liy.generator.domain.TaskInfo;
import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.quartz.service.ScheduleService;
import com.liy.generator.service.QuartzService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = { "*" })
@RestController
public class QuartzController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private QuartzService quartzService;

    @GetMapping("/findJob")
    public List<QuartzTaskInformations> findJob() {
        return quartzService.findJob();
    }

    @GetMapping("/add")
    public void add() {
        scheduleService.addJob();
    }

    @GetMapping("/delete")
    public void delete() {
        scheduleService.deleteJob();
    }

    @PostMapping("/upd")
    public void upd( @RequestBody TaskInfo taskInfo ) {
        scheduleService.updJob(taskInfo);
    }

    @GetMapping("/run")
    public void run() {
        scheduleService.runJob();
    }

    @GetMapping("/pause")
    public void pause() {
        scheduleService.pauseJob();
    }

    @GetMapping("/resume")
    public void resume() {
        scheduleService.resumeJob();
    }

    @GetMapping("/findJobRecords")
    public List<RecordsInfo> findJobRecords( @Param("taskNo") String taskNo ) {
        return quartzService.findJobRecords(taskNo);
    }
}
