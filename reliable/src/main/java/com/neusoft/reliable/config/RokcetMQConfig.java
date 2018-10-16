package com.neusoft.reliable.config;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RokcetMQConfig {

    @Value("${spring.application.name}")
    private String producerGroupName;

    @Value("${spring.rocket-mq.namesrv-addr}")
    private String namesrvAddr;

    @Bean(destroyMethod = "shutdown")
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroupName);

        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        producer.start();
        return producer;
    }

    public void init(){

    }


}
