package com.sm.serviceImpl;

import com.sm.mapper.UsersMapper;
import com.sm.po.Users;
import com.sm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getAllUsers() {
        List<Users> usersList = usersMapper.getAllUsers();
        return usersList;
    }
}
