package com.sm.controller;

import com.sm.common.DocShareMessage;
import com.sm.docShare.DocShareHelper;
import com.sm.po.UsrInfo;
import com.sm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

@Controller
@RequestMapping(value="/",method = RequestMethod.POST)
public class RegisterController extends SmParentController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public DocShareMessage UserRegister(@RequestBody String json){
       try {
           UsrInfo usrInfo = gson.fromJson(json,UsrInfo.class);
           String usrPwd = usrInfo.getUsrPwd();
           MessageDigest md5= MessageDigest.getInstance("MD5");
           BASE64Encoder encoder = new BASE64Encoder();
           String encode = encoder.encode(md5.digest(usrPwd.getBytes("utf-8")))+DocShareHelper.solt;
           String md5Pwd = encoder.encode(md5.digest(encode.getBytes("utf-8")));
           usrInfo.setUsrPwd(md5Pwd);
           boolean register = registerService.register(usrInfo);
           if(register){
               return DocShareMessage.ok("注册成功!");
           }else{
               return DocShareMessage.build(400,"注册失败，请重新再试！");
           }
       }catch (Exception e){
           e.printStackTrace();
           logError("注册接口发生错误!");
           return DocShareMessage.build(400,"未知错误!");
       }
    }

}
