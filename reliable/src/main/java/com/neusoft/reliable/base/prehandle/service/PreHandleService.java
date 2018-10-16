package com.neusoft.reliable.base.prehandle.service;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.common.uti.Utils;
import com.neusoft.reliable.base.prehandle.dao.PreHandleDao;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 信息预处理
 */
@Service
public class PreHandleService {

    @Resource
    private PreHandleDao preHandleDao;

    /**
     * 信息预处理
     * @param param
     * @return
     */
    public String preHandle(OrderInfo param){
        ReliableEntity entity = new ReliableEntity();
        String id = Utils.getUUID();
        entity.setId(id);
        entity.setOrderId(param.getOrderId());
        entity.setCreater("1");
        entity.setCreateTime(new Date());
        entity.setOrderStatus("2");
        entity.setOrderInfo(param.getOrderInfo());
        preHandleDao.savePreHandleInfo(entity);
        return "success";
    }
}
