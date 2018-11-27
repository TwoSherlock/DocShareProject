package com.sm.serviceImpl;

import com.sm.mapper.UsrInfoMapper;
import com.sm.po.UsrInfo;
import com.sm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UsrInfoMapper usrInfoMapper;

    @Override
    public boolean register(UsrInfo usrInfo) {
        UsrInfo registerUser = new UsrInfo();
        registerUser.setUsrNm(usrInfo.getUsrNm());
        registerUser.setUsrPwd(usrInfo.getUsrPwd());
        int i = usrInfoMapper.insertSelective(registerUser);
        if (i>0){
            return true;
        }
        return false;
    }
}
