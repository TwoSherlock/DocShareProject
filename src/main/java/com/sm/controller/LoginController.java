package com.sm.controller;

import com.sm.common.DocShareMessage;
import com.sm.docShare.DocShareHelper;
import com.sm.po.UsrInfo;
import com.sm.service.LoginService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.lang.annotation.ElementType;
import java.security.MessageDigest;

@Controller
@RequestMapping(value="/",method = RequestMethod.POST)
public class LoginController extends  SmParentController{

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public DocShareMessage login(@RequestBody String json){
        try{
            UsrInfo usrInfo = gson.fromJson(json,UsrInfo.class);
            String usrPwd = usrInfo.getUsrPwd();
            MessageDigest md5= MessageDigest.getInstance("MD5");
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(md5.digest(usrPwd.getBytes("utf-8")))+DocShareHelper.solt;
            String md5Pwd = encoder.encode(md5.digest(encode.getBytes("utf-8")));
            usrInfo.setUsrPwd(md5Pwd);
            boolean login = loginService.login(usrInfo);
            if(login){
                return DocShareMessage.ok("登陆成功!");
            }else{
                return DocShareMessage.build(400,"该帐号不存在！");
            }
        }catch (Exception e){
            e.printStackTrace();
            logError("登录接口发生错误!");
            return DocShareMessage.build(400,"未知错误!");
        }
    }
}
