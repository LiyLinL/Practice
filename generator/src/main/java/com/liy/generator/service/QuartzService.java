package com.liy.generator.service;

import com.liy.generator.domain.RecordsInfo;
import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskRecords;

import java.util.List;

public interface QuartzService {

    List<QuartzTaskInformations> findJob();

    void insertJob( QuartzTaskInformations quartzTaskInformations );

    void updateJob( QuartzTaskInformations quartzTaskInformations );

    List<RecordsInfo> findJobRecords( String taskName );

    void insertJobRecords( QuartzTaskRecords quartzTaskRecords );
}
