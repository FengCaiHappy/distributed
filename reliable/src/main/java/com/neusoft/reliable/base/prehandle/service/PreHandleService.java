package com.neusoft.reliable.base.prehandle.service;

import com.neusoft.common.context.DistributedContext;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.common.uti.Utils;
import com.neusoft.reliable.base.prehandle.dao.PreHandleDao;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 信息预处理
 */
@Service
public class PreHandleService {

    private static final Logger logger = LoggerFactory.getLogger(PreHandleService.class);

    @Resource
    private PreHandleDao preHandleDao;

    /**
     * 信息预处理
     * @param param
     * @return
     */
    public String preHandle(OrderInfo param){
        logger.info("可靠性服务系统》》》：转账预处理开始");
        ReliableEntity entity = new ReliableEntity();
        String id = Utils.getUUID();
        entity.setId(id);
        entity.setOrderId(param.getOrderId());
        entity.setCreater("1");
        entity.setCreateTime(new Date());
        entity.setOrderStatus(DistributedContext.DOING);
        entity.setOrderInfo(param.getOrderInfo());
        preHandleDao.savePreHandleInfo(entity);
        logger.info("可靠性服务系统》》》：转账预处理结束");
        return "success";
    }
}
