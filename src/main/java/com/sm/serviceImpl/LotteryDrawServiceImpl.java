package com.sm.serviceImpl;

import com.sm.service.LotteryDrawService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotteryDrawServiceImpl implements LotteryDrawService {
    @Override
    public Map<String, Object> getLuckyUsr(List<String> replyUserNames) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Random random = new Random(new Date().getTime());//生成随机数
        int i = random.nextInt(replyUserNames.size());
        String luckyUsr = replyUserNames.get(i);//取得用户列表中第i个
        resultMap.put("replyUserNames",replyUserNames);
        resultMap.put("luckyUsr",luckyUsr);
        return resultMap;
    }
}
