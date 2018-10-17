package com.neusoft.reliable.base.receivemsg.service;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.base.receivemsg.dao.ReceiveMsgDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 接收积分模块推送的数据
 */
@Service
public class ReceiveMsgService {

    private static final Logger logger = LoggerFactory.getLogger(ReceiveMsgService.class);

    @Resource
    private ReceiveMsgDao receiveMsgDao;

    /**
     * 接收积分模块推送的数据
     * @param param
     * @return
     */
    public String receiveMsg(OrderInfo param){
        logger.info("可靠性服务系统》》》：接受积分系统推送数据开始");
        ReliableEntity entity = new ReliableEntity();
        entity.setOrderId(param.getOrderId());
        entity.setEditor("1");
        entity.setEditTime(new Date());
        entity.setIntegralStatus(param.getStatus());
        entity.setOrderInfo(param.getOrderInfo());
        receiveMsgDao.saveReveiveMsgInfo(entity);
        logger.info("可靠性服务系统》》》：接受积分系统推送数据结束");
        return "success";
    }
}
