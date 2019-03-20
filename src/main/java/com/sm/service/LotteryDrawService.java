package com.sm.service;

import com.sm.common.DocShareMsgException;
import com.sm.po.UsrInfo;

import java.util.List;
import java.util.Map;

public interface LotteryDrawService {

    public Map<String, Object> getLuckyUsr(List<String> replyUserNames);
}
