package com.liy.generator.quartz.controller;

import com.liy.generator.quartz.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartzController {

    @Autowired
    private ScheduleService scheduleService;

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
