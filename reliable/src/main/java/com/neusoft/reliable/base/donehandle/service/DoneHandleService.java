package com.neusoft.reliable.base.donehandle.service;

import com.neusoft.common.context.DistributedContext;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.donehandle.dao.DoneHandleDao;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.message.SendMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 信息处理完成业务
 */
@Service
public class DoneHandleService {

    private static final Logger logger = LoggerFactory.getLogger(DoneHandleService.class);

    @Resource
    private DoneHandleDao doneHandleDao;

    @Autowired
    private SendMQMessage sendMQMessage;

    /**
     * 信息处理完成接口
     * @param param
     * @return
     */
    public String doneHandle(OrderInfo param){
        logger.info("可靠性服务系统》》》：转账已完成处理开始");
        ReliableEntity entity = new ReliableEntity();
        entity.setOrderId(param.getOrderId());
        entity.setOrderInfo(param.getOrderInfo());
        entity.setOrderStatus(param.getStatus());
        entity.setEditor("1");
        entity.setIntegralStatus(DistributedContext.DOING);
        entity.setEditTime(new Date());
        int num = doneHandleDao.saveDoneHandleInfo(entity);
        if(num == 1){
            sendMQMessage.sendMsg(param);
        }
        logger.info("可靠性服务系统》》》：转账已完成处理结束");
        return "success";
    }
}
