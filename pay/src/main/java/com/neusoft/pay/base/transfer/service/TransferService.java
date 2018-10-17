package com.neusoft.pay.base.transfer.service;

import com.neusoft.common.context.DistributedContext;
import com.neusoft.common.uti.HttpUtil;
import com.neusoft.common.uti.Utils;
import com.neusoft.pay.base.transfer.dao.TransferDao;
import com.neusoft.pay.base.transfer.entity.TransferEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟转账
 */
@Service
public class TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);

    @Value("${httpuri.pre-handle}")
    private String preHandlerUrl;

    @Value("${httpuri.done-handle}")
    private String doneHandlerUrl;

    @Value("${spring.application.consumingSeconds}")
    private Integer consumingSeconds;

    @Resource
    private TransferDao transferDao;

    /**
     * 转账请求
     * @param param
     * @return
     */
    @Transactional
    public String doTransfer(String param){
        logger.info("转账系统》》》：转账开始");
        //处理前，缓存下数据，暂时直接保存到库里，完成更新该条数据
        String id = Utils.getUUID();
        String orderId = Utils.getUUID();
        TransferEntity entity = new TransferEntity();
        entity.setId(id);
        entity.setOrderId(orderId);
        entity.setCreater("1");
        entity.setCreateTime(new Date());
        entity.setStatus(DistributedContext.DOING);
        transferDao.saveTransferInfo(entity);

        //发送预处理信息
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("status", DistributedContext.DOING);
        map.put("orderInfo", "abc123");
        String res = HttpUtil.doPost(preHandlerUrl, map);

        //模拟转账耗时请求,非常复杂的业务请求~
        try {
            Thread.sleep(consumingSeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //处理成功后，更新表数据
        entity.setStatus(DistributedContext.SUCCESS);
        entity.setEditor("1");
        entity.setEditTime(new Date());
        transferDao.updateTransferInfo(entity);

        //发送已处理信息
        map.clear();
        map.put("orderId", orderId);
        map.put("status", DistributedContext.SUCCESS);
        map.put("orderInfo", "abc123");
        String doneRes = HttpUtil.doPost(doneHandlerUrl, map);
        logger.info("转账系统》》》：转账结束");
        return "success";
    }
}
