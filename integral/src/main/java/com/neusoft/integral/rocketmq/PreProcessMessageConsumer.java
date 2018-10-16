package com.neusoft.integral.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PreProcessMessageConsumer implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(PreProcessMessageConsumer.class);

    private DefaultMQPushConsumer consumer;

    @Value("${spring.rocket-mq.namesrv-addr}")
    private String namesrvAddr;

    @Value("${spring.application.name}")
    private String groupName;

    @Value("${spring.rocket-mq.consume-thread-min}")
    private Integer consumeThreadMin;

    @Value("${spring.rocket-mq.consume-thread-max}")
    private Integer consumeThreadMax;

    @Resource
    private OrderMessageListener orderMessageListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            consumer = new DefaultMQPushConsumer(groupName);
            consumer.setNamesrvAddr(namesrvAddr);
            consumer.subscribe("TopicTest","tag");
            consumer.registerMessageListener(orderMessageListener);
            consumer.setConsumeThreadMax(consumeThreadMax);
            consumer.setConsumeThreadMin(consumeThreadMin);
            consumer.start();

            logger.info("------消息队列消费者初始化完成------");

        } catch (Exception e) {
            logger.error("------消息队列消费者初始化失败------", e);
        }
    }


    @Override
    public void destroy() {
        if (consumer != null) {
            consumer.shutdown();
            logger.info("------消息队列消费者销毁化完成------");
        }
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
