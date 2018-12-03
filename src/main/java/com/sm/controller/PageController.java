package com.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/")
public class PageController extends SmParentController {
//    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
//    public String indexPage(HttpServletRequest req, HttpServletResponse rep){
//        return "login";
//    }

    @RequestMapping(value = "/registerPage",method = RequestMethod.GET)
    public String registerPage(HttpServletRequest req, HttpServletResponse rep){
        return "register";
    }
}
