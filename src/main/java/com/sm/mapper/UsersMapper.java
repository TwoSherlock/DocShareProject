package com.sm.mapper;

import com.sm.po.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> getAllUsers();
}