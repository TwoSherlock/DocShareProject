package com.sm.serviceImpl;

import com.sm.mapper.UsrInfoMapper;
import com.sm.po.UsrInfo;
import com.sm.po.UsrInfoExample;
import com.sm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsrInfoMapper usrInfoMapper;

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
}
