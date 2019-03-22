package com.sm.serviceImpl;

import com.sm.service.LotteryDrawService;
import com.sm.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotteryDrawServiceImpl implements LotteryDrawService {


    private static final Logger logger = LoggerFactory.getLogger(LotteryDrawServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public List<Object> getreplyUsrs(String oid) {
        Map<Object,Object> map = redisUtil.hmget(oid);
        List<Object> usrNmList = new ArrayList<Object>(map.values());
        return usrNmList;
    }

    @Override
    public void addRedisHash(String oid, Map<String, Object> resultMap) {
        logger.info("向reids写入hash数据："+oid+"--"+resultMap);
        boolean bl = redisUtil.hmset(oid, resultMap);
        if(!bl){
            logger.error("参与抽奖用户 装填redis失败");
        }
    }

    @Override
    public void clearRedisHash(String oid) {
        logger.info("从reids删除hash数据："+oid);
        redisUtil.del(oid);
    }

    @Override
    public String getLuckUsr(List<Object> list) {
        Random random = new Random(new Date().getTime());//生成随机数
        int i = random.nextInt(list.size());
        return (String) list.get(i);//取得用户列表中第i个
    }
}
