package com.sm.controller;

import com.sm.common.DocShareMessage;
import com.sm.docShare.DocShareHelper;
import com.sm.po.UsrInfo;
import com.sm.service.LoginService;
import com.sm.util.MD5Util;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public DocShareMessage login(@RequestBody String json, HttpServletRequest request, HttpServletResponse response){
        try{
            logInfo("登录传参为："+json);
            UsrInfo usrInfo = gson.fromJson(json,UsrInfo.class);
            String usrPwd = usrInfo.getUsrPwd();
            String md5Pwd = MD5Util.md5SoltGenerator(usrPwd);
            usrInfo.setUsrPwd(md5Pwd);
            boolean login = loginService.login(usrInfo);
            String tokenValue = MD5Util.md5SoltGenerator(usrInfo.getUsrNm());
            /*将盐值加密后的用户名作为value放入redis和cookie
            *redis的存储格式为:  tokenValue,tokenValue
            * cookie的存储格式为:DocShareHelper.token,tokenValue
            * */
            Cookie cookie = new Cookie(DocShareHelper.token,tokenValue);
            logInfo("生成token："+tokenValue);
            loginService.addToken(tokenValue);
            cookie.setMaxAge(1800);//30min
            cookie.setPath("/");
            response.addCookie(cookie);
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
