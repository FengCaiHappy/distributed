package com.neusoft.reliable.scheduled;

import com.neusoft.reliable.scheduled.service.UnFinshIntegralService;
import com.neusoft.reliable.scheduled.service.UnFinshTransferService;
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

    @Scheduled(cron = "1 * * * * ?")
    public void scheduled(){
        unFinshTransferService.execUnFinshTransfer();
        logger.info("=====>>>>>1m",System.currentTimeMillis());
    }
    @Scheduled(cron = "1 * * * * ?")
    public void scheduled1() {
        logger.info("=====>>>>>5s", System.currentTimeMillis());
    }
}
