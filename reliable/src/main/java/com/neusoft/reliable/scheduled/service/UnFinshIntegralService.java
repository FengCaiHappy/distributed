package com.neusoft.reliable.scheduled.service;

import com.neusoft.common.context.DistributedContext;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.message.SendMQMessage;
import com.neusoft.reliable.scheduled.dao.UnFinshIntegralDao;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理未完成积分信息
 */
@Service
public class UnFinshIntegralService {

    @Value("${spring.application.send-times}")
    private int sendTimes;

    @Resource
    private UnFinshIntegralDao unFinshIntegralDao;

    @Autowired
    private SendMQMessage sendMQMessage;

    public void execUnFinshIntegral(){
        //查询处理中的积分信息
        ReliableEntity entity = new ReliableEntity();
        entity.setIntegralStatus(DistributedContext.DOING);
        //重发次数小于等于5次
        entity.setMessageSendTimes(sendTimes);
        List<OrderInfo> list = unFinshIntegralDao.queryUnFinshIntegral(entity);

        if(list == null || list.size() == 0){
            return;
        }

        //获取到的集合数据发送消息队列
        SendResult sendResult = sendMQMessage.sendMsgs(list);

        //更新数据已发送次数
        unFinshIntegralDao.updateIntegralStatus(list);
    }
}
