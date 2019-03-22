package com.sm.service;

import com.sm.common.DocShareMsgException;
import com.sm.po.UsrInfo;

import java.util.List;
import java.util.Map;

public interface LotteryDrawService {

    public List<Object> getreplyUsrs(String oid);

    public void addRedisHash(String oid, Map<String, Object> resultMap);

    public void clearRedisHash(String oid);

    public String getLuckUsr(List<Object> list);

}
