package com.sm.webMagic;

import com.google.gson.Gson;
import com.sm.po.BiliBiliReplies;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.*;
public class BilibiliWebMagicPageProcessor  implements PageProcessor {
    private int pageSize = 1;
    private String oid = "";
    public static List<String> usrNmList = new ArrayList<String>();//用来保存所有评论用户的名称
    public String[] excludeUsrs = new String[]{};

    public String[] getExcludeUsrs() {
        return excludeUsrs;
    }

    public void setExcludeUsrs(String[] excludeUsrs) {
        this.excludeUsrs = excludeUsrs;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public List<String> getUsrNmList() {
        return usrNmList;
    }

    public void setUsrNmList(List<String> usrNmList) {
        this.usrNmList = usrNmList;
    }

    private Gson gson = new Gson();//json转换工具类
    private Site site = Site.me().setRetryTimes(3)//爬虫的相关配置
            .setTimeOut(30000)
            .setSleepTime(1800)
            .setCycleRetryTimes(3)
            .setUseGzip(true)
            .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")
            .addHeader("Accept","application/json, text/plain, */*")
            .addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addHeader("Accept-Encoding","gzip, deflate, br")
            .addHeader("X-Requested-With","XMLHttpRequest")
            .addHeader("Content-Type","application/x-www-form-urlencoded")
            .addHeader("Referer","https://www.bilibili.com/video/av46606546");

    @Override
    public void process(Page page) {
        Map<String, String> resultMap = new HashMap<String, String>();
        //响应的结构中，member{}包含用户的mid和用户名
        List<String> members = new JsonPathSelector("$.data.replies[*].member").selectList(page.getRawText());
        for (String member : members) {
            BiliBiliReplies reply = gson.fromJson(member, BiliBiliReplies.class);
            resultMap.put(reply.getMid(),reply.getUname());//采用map去重
        }
        usrNmList.addAll(resultMap.values());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public List<String> getReplyUserNames(){
        usrNmList.clear();
        for (int i = 1;i <= this.pageSize;i++){
            Spider.create(new BilibiliWebMagicPageProcessor()).addUrl("https://api.bilibili.com/x/v2/reply?pn="+i+"&type=1&oid="+this.oid).thread(1).run();
        }
//        usrNmList.remove("TwoSherlock");//去除指定的评论
        for(String excludeUsr :excludeUsrs){
            usrNmList.remove(excludeUsr);
        }
//        Random random = new Random(new Date().getTime());//生成随机数
//        int i = random.nextInt(list.size());
//        String s = this.usrNmList.get(i);//取得用户列表中第i个
//        System.out.println("恭喜用户  "+s+"  中奖！");
        return usrNmList;
    }
}
