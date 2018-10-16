package com.neusoft.reliable.base.donehandle.service;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.donehandle.dao.DoneHandleDao;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.message.SendMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 信息处理完成业务
 */
@Service
public class DoneHandleService {

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
        ReliableEntity entity = new ReliableEntity();
        entity.setOrderId(param.getOrderId());
        entity.setOrderInfo(param.getOrderInfo());
        entity.setOrderStatus(param.getStatus());
        entity.setEditor("1");
        entity.setEditTime(new Date());
        doneHandleDao.saveDoneHandleInfo(entity);
        sendMQMessage.sendMsg(param);
        return "success";
    }
}
