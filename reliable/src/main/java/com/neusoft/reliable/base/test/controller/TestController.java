package com.neusoft.reliable.base.test.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Map<String, String> activityorder(String param) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        byte[] b = new byte[10];
        Message msg = new Message("TopicTest", "tag", b);
        SendResult sendResult = defaultMQProducer.send(msg);
        Map<String, String> map = new HashMap<>();
        map.put("res", param);
        return map;
    }

}
