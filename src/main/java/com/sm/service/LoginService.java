package com.sm.service;

import com.sm.po.UsrInfo;

public interface LoginService {
    /**
     * 判断用户是否可以登录
     * @param usrInfo
     * @return
     */
    public boolean login(UsrInfo usrInfo);


    /**
     * 将token添加到redis
     */
    void addToken(String tokenValue);
}
