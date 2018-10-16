package com.neusoft.integral.base.addintegral.service;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.common.uti.Utils;
import com.neusoft.integral.base.addintegral.dao.AddIntegralDao;
import com.neusoft.integral.base.addintegral.entity.IntegralEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 模拟增加积分
 */
@Service
public class AddIntegralService {

    @Resource
    private AddIntegralDao addIntegralDao;

    public void addIntegral(OrderInfo info){
        IntegralEntity entity = new IntegralEntity();
        String id = Utils.getUUID();
        entity.setId(id);
        entity.setCreater("1");
        entity.setCreateTime(new Date());
        entity.setOrderId(info.getOrderId());
        addIntegralDao.addIntegral(entity);
    }
}
