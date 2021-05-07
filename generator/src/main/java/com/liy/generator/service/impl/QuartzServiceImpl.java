package com.liy.generator.service.impl;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskRecords;
import com.liy.generator.repository.QuartzRepo;
import com.liy.generator.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private QuartzRepo quartzRepo;

    @Override
    public List<QuartzTaskInformations> findJob() {
        return quartzRepo.findJob();
    }

    @Override
    public void insertJob( QuartzTaskInformations quartzTaskInformations ) {
        quartzRepo.insertJob(quartzTaskInformations);
    }

    @Override
    public List<QuartzTaskRecords> findJobRecords() {
        return quartzRepo.findJobRecords();
    }

    @Override
    public void insertJobRecords( QuartzTaskRecords quartzTaskRecords ) {
        quartzRepo.insertJobRecords(quartzTaskRecords);
    }
}
