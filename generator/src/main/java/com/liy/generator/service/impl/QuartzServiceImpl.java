package com.liy.generator.service.impl;

import com.liy.generator.domain.RecordsInfo;
import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskRecords;
import com.liy.generator.repository.QuartzRepo;
import com.liy.generator.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public void updateJob( QuartzTaskInformations quartzTaskInformations ) {
        quartzRepo.updateJob(quartzTaskInformations);
    }

    @Override
    public List<RecordsInfo> findJobRecords( String taskNo ) {
        QuartzTaskRecords quartzTaskRecords = new QuartzTaskRecords();
        quartzTaskRecords.setTaskNo(taskNo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return quartzRepo.findJobRecords(quartzTaskRecords)
                .stream()
                .sorted(Comparator.comparing(QuartzTaskRecords::getExecuteTime).reversed())
                .map(obj -> {
                    RecordsInfo recordsInfo = new RecordsInfo();
                    recordsInfo.setExecuteTimeStr(sdf.format(obj.getExecuteTime()));
                    recordsInfo.setTaskStatus(obj.getTaskStatus());

                    return recordsInfo;
                }).collect(Collectors.toList());
    }

    @Override
    public void insertJobRecords( QuartzTaskRecords quartzTaskRecords ) {
        quartzRepo.insertJobRecords(quartzTaskRecords);
    }
}
