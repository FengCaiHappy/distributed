package com.neusoft.integral.base.addintegral.service;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.common.uti.HttpUtil;
import com.neusoft.common.uti.Utils;
import com.neusoft.integral.base.addintegral.dao.AddIntegralDao;
import com.neusoft.integral.base.addintegral.entity.IntegralEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟增加积分
 */
@Service
public class AddIntegralService {

    @Value("${spring.application.consumingSeconds}")
    private Integer consumingSeconds;

    @Resource
    private AddIntegralDao addIntegralDao;

    public void addIntegral(OrderInfo info){
        IntegralEntity entity = new IntegralEntity();
        String id = Utils.getUUID();
        entity.setId(id);
        entity.setCreater("1");
        entity.setCreateTime(new Date());
        entity.setOrderId(info.getOrderId());
        int num = addIntegralDao.addIntegral(entity);

        if(num == 0){
            return;
        }

        try {
            Thread.sleep(consumingSeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //推送处理结果
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", info.getOrderId());
        map.put("status", "1");
        map.put("orderInfo", "abc123");
        //TODO
        String res = HttpUtil.doPost("http://localhost:8083/reliable/receiveMsg", map);
    }
}
