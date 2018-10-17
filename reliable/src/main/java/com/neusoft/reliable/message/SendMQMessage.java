package com.neusoft.reliable.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.common.context.DistributedContext;
import com.neusoft.common.entity.OrderInfo;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 发送消息队列信息
 */
@Component
public class SendMQMessage {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 发送信息
     * @param info
     */
    public void sendMsg(OrderInfo info){
        List<OrderInfo> list = new ArrayList<>();
        list.add(info);
        sendMsgs(list);
    }

    public SendResult sendMsgs(List<OrderInfo> list){
        List<Message> messages = new ArrayList<>();
        SendResult sendResult = null;
        try {
            for(OrderInfo info: list){
                Message msg = new Message(DistributedContext.TOPIC, DistributedContext.TAG,
                        objectMapper.writeValueAsString(info).getBytes(RemotingHelper.DEFAULT_CHARSET));
                messages.add(msg);
            }
            sendResult = defaultMQProducer.send(messages);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sendResult;
    }
}
