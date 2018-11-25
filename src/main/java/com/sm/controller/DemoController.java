package com.sm.controller;


import com.sm.po.Users;
import com.sm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController extends  SmParentController{

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public String home() {

        List<Users> allUsers = userService.getAllUsers();
        logInfo("======查询到用户======");
        String s = gson.toJson(allUsers);
        return s;
    }
}
