package com.liy.generator.mapper;

import com.liy.generator.entity.QuartzTaskRecords;
import com.liy.generator.entity.QuartzTaskRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuartzTaskRecordsMapper {
    long countByExample(QuartzTaskRecordsExample example);

    int deleteByExample(QuartzTaskRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskRecords record);

    int insertSelective(QuartzTaskRecords record);

    List<QuartzTaskRecords> selectByExample(QuartzTaskRecordsExample example);

    QuartzTaskRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuartzTaskRecords record, @Param("example") QuartzTaskRecordsExample example);

    int updateByExample(@Param("record") QuartzTaskRecords record, @Param("example") QuartzTaskRecordsExample example);

    int updateByPrimaryKeySelective(QuartzTaskRecords record);

    int updateByPrimaryKey(QuartzTaskRecords record);
}