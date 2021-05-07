package com.liy.generator.repository;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskRecords;

import java.util.List;

public interface QuartzRepo {

    List<QuartzTaskInformations> findJob();

    void insertJob( QuartzTaskInformations quartzTaskInformations );

    List<QuartzTaskRecords> findJobRecords();

    void insertJobRecords( QuartzTaskRecords quartzTaskRecords );
}
