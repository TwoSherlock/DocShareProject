package com.sm.serviceImpl;

import com.sm.common.DocShareMsgException;
import com.sm.docShare.DocShareHelper;
import com.sm.mapper.UsrInfoMapper;
import com.sm.po.UsrInfo;
import com.sm.po.UsrInfoExample;
import com.sm.service.RegisterService;
import com.sm.util.MD5Util;
import com.sm.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static final  Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private UsrInfoMapper usrInfoMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean register(UsrInfo usrInfo) {
        try {
            String md5Pwd = MD5Util.md5SoltGenerator(usrInfo.getUsrPwd());
            usrInfo.setUsrPwd(md5Pwd);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("加密时发生异常!");
        }
        usrInfo.setCrtr("SYSTEM");
        usrInfo.setUpdtr("SYSTEM");
        usrInfo.setCrtm(new Date());
        usrInfo.setUpdtm(new Date());
        int i = usrInfoMapper.insertSelective(usrInfo);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public void checkData(String usrNm, String usrPwd, String usrPwd2, String email, String inviteCode) throws DocShareMsgException {
        if(StringUtils.isBlank(usrNm)){
            throw new DocShareMsgException("用户名为空!");
        }
        if(StringUtils.isBlank(usrPwd)){
            throw new DocShareMsgException("密码为空!");
        }
        if(StringUtils.isBlank(usrPwd2)){
            throw new DocShareMsgException("第二次输入的密码为空!");
        }
        if(!usrPwd2.equals(usrPwd)){
            throw new DocShareMsgException("两次密码不一致!");
        }
        if(StringUtils.isBlank(email)){
            throw new DocShareMsgException("邮箱为空!");
        }
        /******邮箱格式校验******/
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if (!m.matches()){
            throw new DocShareMsgException("错误的邮箱格式!");
        }
        if(StringUtils.isBlank(inviteCode)){
            throw new DocShareMsgException("邀请码为空!");
        }
        /*****去缓存中查找邀请码*****/
        if(!redisUtil.hasKey(DocShareHelper.invitedkey+inviteCode)){
            throw new DocShareMsgException("邀请码不存在或已过期!");
        }
        UsrInfoExample usrInfoExample = new UsrInfoExample();
        UsrInfoExample.Criteria criteria = usrInfoExample.createCriteria();
        criteria.andUsrNmEqualTo(usrNm);
        if(usrInfoMapper.countByExample(usrInfoExample)>0){
            throw new DocShareMsgException("用户名已被占用!");
        }
    }
}
