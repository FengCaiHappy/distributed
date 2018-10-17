package com.neusoft.reliable.scheduled;

import com.neusoft.reliable.scheduled.service.UnFinshIntegralService;
import com.neusoft.reliable.scheduled.service.UnFinshTransferService;
import com.neusoft.reliable.scheduled.service.UpdateIntegralStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Async
@Component
public class ScheduledService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledService.class);

    @Autowired
    private UnFinshTransferService unFinshTransferService;

    @Autowired
    private UnFinshIntegralService unFinshIntegralService;

    @Autowired
    private UpdateIntegralStatusService updateIntegralStatusService;

    /**
     * 处理未完成的转账信息
     */
    @Scheduled(cron = "1 * * * * ?")
    public void unFinshTransfer(){
        unFinshTransferService.execUnFinshTransfer();
        logger.info("定时任务：处理未完成的转账信息", System.currentTimeMillis());
    }

    /**
     * 处理未完成的积分信息
     */
    @Scheduled(cron = "1 * * * * ?")
    public void unFinshIntegral() {
        unFinshIntegralService.execUnFinshIntegral();
        logger.info("定时任务：处理未完成的积分信息", System.currentTimeMillis());
    }

    /**
     * 修改已发送5次还在处理中状态的数据
     */
    @Scheduled(cron = "2 * * * * ?")
    public void updateIntegralStatus() {
        updateIntegralStatusService.updateIntegralStatus();
        logger.info("定时任务：修改已发送5次还在处理中状态的数据", System.currentTimeMillis());
    }
}
