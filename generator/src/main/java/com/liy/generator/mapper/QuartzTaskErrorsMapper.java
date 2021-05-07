package com.liy.generator.mapper;

import com.liy.generator.entity.QuartzTaskErrors;
import com.liy.generator.entity.QuartzTaskErrorsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuartzTaskErrorsMapper {
    long countByExample(QuartzTaskErrorsExample example);

    int deleteByExample(QuartzTaskErrorsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskErrors record);

    int insertSelective(QuartzTaskErrors record);

    List<QuartzTaskErrors> selectByExampleWithBLOBs(QuartzTaskErrorsExample example);

    List<QuartzTaskErrors> selectByExample(QuartzTaskErrorsExample example);

    QuartzTaskErrors selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuartzTaskErrors record, @Param("example") QuartzTaskErrorsExample example);

    int updateByExampleWithBLOBs(@Param("record") QuartzTaskErrors record, @Param("example") QuartzTaskErrorsExample example);

    int updateByExample(@Param("record") QuartzTaskErrors record, @Param("example") QuartzTaskErrorsExample example);

    int updateByPrimaryKeySelective(QuartzTaskErrors record);

    int updateByPrimaryKeyWithBLOBs(QuartzTaskErrors record);

    int updateByPrimaryKey(QuartzTaskErrors record);
}