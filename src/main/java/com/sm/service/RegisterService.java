package com.sm.service;

import com.sm.po.UsrInfo;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    public boolean register(UsrInfo usrInfo);
}
