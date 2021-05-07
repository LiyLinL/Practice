package com.liy.generator.quartz.service;

public interface ScheduleService {

    void addJob();

    void deleteJob();

    void updJob();

    void runJob();

    void pauseJob();

    void resumeJob();

}
