package com.liy.generator.repository.impl;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskInformationsExample;
import com.liy.generator.entity.QuartzTaskRecords;
import com.liy.generator.entity.QuartzTaskRecordsExample;
import com.liy.generator.mapper.QuartzTaskInformationsMapper;
import com.liy.generator.mapper.QuartzTaskRecordsMapper;
import com.liy.generator.repository.QuartzRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuartzRepoImpl implements QuartzRepo {

    @Autowired
    private QuartzTaskInformationsMapper quartzTaskInformationsMapper;

    @Autowired
    private QuartzTaskRecordsMapper quartzTaskRecordsMapper;

    @Override
    public List<QuartzTaskInformations> findJob() {
        QuartzTaskInformationsExample example = new QuartzTaskInformationsExample();
        return quartzTaskInformationsMapper.selectByExample(example);
    }

    @Override
    public void insertJob( QuartzTaskInformations quartzTaskInformations ) {
        quartzTaskInformationsMapper.insertSelective(quartzTaskInformations);
    }

    @Override
    public void updateJob( QuartzTaskInformations quartzTaskInformations ) {
        QuartzTaskInformationsExample example = new QuartzTaskInformationsExample();
        example.createCriteria().andTaskNameEqualTo(quartzTaskInformations.getTaskName());
        quartzTaskInformationsMapper.updateByExampleSelective(quartzTaskInformations, example);
    }

    @Override
    public List<QuartzTaskRecords> findJobRecords( QuartzTaskRecords quartzTaskRecords ) {
        QuartzTaskRecordsExample example = new QuartzTaskRecordsExample();
        example.createCriteria().andTaskNameEqualTo(quartzTaskRecords.getTaskName());
        return quartzTaskRecordsMapper.selectByExample(example);
    }

    @Override
    public void insertJobRecords( QuartzTaskRecords quartzTaskRecords ) {
        quartzTaskRecordsMapper.insertSelective(quartzTaskRecords);
    }

}
