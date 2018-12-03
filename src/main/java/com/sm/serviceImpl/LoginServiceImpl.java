package com.sm.serviceImpl;

import com.sm.mapper.UsrInfoMapper;
import com.sm.po.UsrInfo;
import com.sm.po.UsrInfoExample;
import com.sm.service.LoginService;
import com.sm.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UsrInfoMapper usrInfoMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean login(UsrInfo usrInfo) {
        UsrInfoExample usrInfoExample = new UsrInfoExample();
        UsrInfoExample.Criteria criteria = usrInfoExample.createCriteria();
        criteria.andUsrNmEqualTo(usrInfo.getUsrNm());
        criteria.andUsrPwdEqualTo(usrInfo.getUsrPwd());
        List<UsrInfo> usrInfos = usrInfoMapper.selectByExample(usrInfoExample);
        if(usrInfos!=null && usrInfos.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void addToken(String tokenValue) {
        redisUtil.set(tokenValue,tokenValue);
        redisUtil.expire(tokenValue,1800);//设置失效时间为半小时
        logger.info("添加token入reids:"+tokenValue);
    }
}
