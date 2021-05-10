package com.liy.generator.quartz.service;

import com.liy.generator.domain.TaskInfo;

public interface ScheduleService {

    void addJob();

    void deleteJob();

    void updJob( TaskInfo taskInfo );

    void runJob();

    void pauseJob();

    void resumeJob();
}
