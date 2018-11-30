package com.sm.service;

import com.sm.common.DocShareMsgException;
import com.sm.po.UsrInfo;
import org.springframework.stereotype.Service;

public interface RegisterService {
    public boolean register(UsrInfo usrInfo);

    void checkData(String usrNm, String usrPwd, String usrPwd2, String email, String inviteCode) throws DocShareMsgException;
}
