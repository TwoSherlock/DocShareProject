package com.sm.mapper;

import com.sm.po.UsrInfo;
import com.sm.po.UsrInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsrInfoMapper {
    long countByExample(UsrInfoExample example);

    int deleteByExample(UsrInfoExample example);

    int deleteByPrimaryKey(Integer usrId);

    int insert(UsrInfo record);

    int insertSelective(UsrInfo record);

    List<UsrInfo> selectByExample(UsrInfoExample example);

    UsrInfo selectByPrimaryKey(Integer usrId);

    int updateByExampleSelective(@Param("record") UsrInfo record, @Param("example") UsrInfoExample example);

    int updateByExample(@Param("record") UsrInfo record, @Param("example") UsrInfoExample example);

    int updateByPrimaryKeySelective(UsrInfo record);

    int updateByPrimaryKey(UsrInfo record);
}