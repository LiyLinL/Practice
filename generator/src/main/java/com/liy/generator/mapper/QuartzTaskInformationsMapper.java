package com.liy.generator.mapper;

import com.liy.generator.entity.QuartzTaskInformations;
import com.liy.generator.entity.QuartzTaskInformationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuartzTaskInformationsMapper {
    long countByExample(QuartzTaskInformationsExample example);

    int deleteByExample(QuartzTaskInformationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskInformations record);

    int insertSelective(QuartzTaskInformations record);

    List<QuartzTaskInformations> selectByExample(QuartzTaskInformationsExample example);

    QuartzTaskInformations selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuartzTaskInformations record, @Param("example") QuartzTaskInformationsExample example);

    int updateByExample(@Param("record") QuartzTaskInformations record, @Param("example") QuartzTaskInformationsExample example);

    int updateByPrimaryKeySelective(QuartzTaskInformations record);

    int updateByPrimaryKey(QuartzTaskInformations record);
}