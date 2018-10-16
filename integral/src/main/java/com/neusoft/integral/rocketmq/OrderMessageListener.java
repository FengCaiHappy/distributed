package com.neusoft.integral.rocketmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.integral.base.addintegral.service.AddIntegralService;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class OrderMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AddIntegralService addIntegralService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt msg : msgs) {
            byte[] bytes = msg.getBody();
            String body = new String(bytes);
            try {
                OrderInfo info = objectMapper.readValue(body, OrderInfo.class);
                addIntegralService.addIntegral(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("积分模块接收消息队列消息" + body);
        }
        //返回消费成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}
