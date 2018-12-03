package com.sm.service;

import com.sm.common.DocShareMsgException;
import com.sm.po.UsrInfo;
import org.springframework.stereotype.Service;

public interface RegisterService {

    /**
     * 注册接口
     * @param usrInfo
     * @return
     */
    public boolean register(UsrInfo usrInfo);

    /**
     * 检查用户注册时填写的信息是否符合要求 同时验证码要正确
     * @param usrNm
     * @param usrPwd
     * @param usrPwd2
     * @param email
     * @param inviteCode
     * @throws DocShareMsgException
     */
    void checkData(String usrNm, String usrPwd, String usrPwd2, String email, String inviteCode) throws DocShareMsgException;

    /**
     * 生成6位数邀请码
     * @return
     * @throws DocShareMsgException
     */
    String generateInviteCode() throws DocShareMsgException;
}
