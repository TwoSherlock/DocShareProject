package com.sm.controller;

import com.sm.common.DocShareMessage;
import com.sm.common.DocShareMsgException;
import com.sm.docShare.DocShareHelper;
import com.sm.po.UsrInfo;
import com.sm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.Map;

@Controller
@RequestMapping(value="/")
public class RegisterController extends SmParentController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/registerPage",method = RequestMethod.GET)
    public String register(HttpServletRequest req, HttpServletResponse rep){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public DocShareMessage userRegister(@RequestBody String json){
       try {
           logInfo("注册接口入参:"+json);
           Map<String,String> map = gson.fromJson(json, Map.class);
           String usrNm = map.get("usrNm");
           String usrPwd = map.get("usrPwd");
           String usrPwd2 = map.get("usrPwd2");
           String email = map.get("email");
           String inviteCode = map.get("inviteCode");
           registerService.checkData(usrNm,usrPwd,usrPwd2,email,inviteCode);
           UsrInfo usrInfo = new UsrInfo();
           usrInfo.setUsrNm(usrNm);
           usrInfo.setUsrPwd(usrPwd);
           usrInfo.setEmail(email);
           boolean register = registerService.register(usrInfo);
           if(register) {
               return DocShareMessage.ok("注册成功!");
           }else{
               return DocShareMessage.build(400,"注册失败！");
           }
       }catch (DocShareMsgException e){
           e.printStackTrace();
           logError("注册接口发生错误!");
           return DocShareMessage.build(400,e.getMsg());
       }catch (Exception e){
           e.printStackTrace();
           logError("注册接口发生错误!");
           return DocShareMessage.build(400,"未知错误!");
       }
    }

}
