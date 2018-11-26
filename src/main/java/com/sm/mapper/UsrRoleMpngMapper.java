package com.sm.mapper;

import com.sm.po.UsrRoleMpng;
import com.sm.po.UsrRoleMpngExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsrRoleMpngMapper {
    long countByExample(UsrRoleMpngExample example);

    int deleteByExample(UsrRoleMpngExample example);

    int deleteByPrimaryKey(Integer mpngId);

    int insert(UsrRoleMpng record);

    int insertSelective(UsrRoleMpng record);

    List<UsrRoleMpng> selectByExample(UsrRoleMpngExample example);

    UsrRoleMpng selectByPrimaryKey(Integer mpngId);

    int updateByExampleSelective(@Param("record") UsrRoleMpng record, @Param("example") UsrRoleMpngExample example);

    int updateByExample(@Param("record") UsrRoleMpng record, @Param("example") UsrRoleMpngExample example);

    int updateByPrimaryKeySelective(UsrRoleMpng record);

    int updateByPrimaryKey(UsrRoleMpng record);
}