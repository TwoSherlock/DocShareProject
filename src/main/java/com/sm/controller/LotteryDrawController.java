package com.sm.controller;

import com.sm.common.DocShareMessage;
import com.sm.docShare.DocShareHelper;
import com.sm.po.BiliBiliReplies;
import com.sm.po.UsrInfo;
import com.sm.service.LoginService;
import com.sm.serviceImpl.LotteryDrawServiceImpl;
import com.sm.util.MD5Util;
import com.sm.webMagic.BilibiliWebMagicPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping(value="/",method = RequestMethod.POST)
public class LotteryDrawController extends  SmParentController{

    @Autowired
    private LotteryDrawServiceImpl lotteryDrawServiceImpl;

    @RequestMapping("/lotteryDrawList")
    @ResponseBody
    public DocShareMessage login(@RequestBody String json, HttpServletRequest request, HttpServletResponse response){
        try{
            logInfo("抽奖名单接口传参为："+json);
            BiliBiliReplies bbr = gson.fromJson(json,BiliBiliReplies.class);
            BilibiliWebMagicPageProcessor bwmpp = new BilibiliWebMagicPageProcessor();//创建一个爬虫对象
            bwmpp.setOid(bbr.getAvId());//av号
            bwmpp.setPageSize(bbr.getPageSize());//评论页数
            bwmpp.setExcludeUsrs(bbr.getExcludeUsrs());//排除的用户名称
            List<String> replyUserNames = bwmpp.getReplyUserNames();
            return DocShareMessage.ok(lotteryDrawServiceImpl.getLuckyUsr(replyUserNames));
        }catch (Exception e){
            e.printStackTrace();
            logError("抽奖名单接口发生错误!");
            return DocShareMessage.build(400,"未知错误!");
        }
    }
}
