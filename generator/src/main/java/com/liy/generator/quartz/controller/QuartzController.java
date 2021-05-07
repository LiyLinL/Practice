package com.liy.generator.quartz.controller;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.quartz.service.ScheduleService;
import com.liy.generator.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/upd")
    public void upd() {
        scheduleService.updJob();
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
}
