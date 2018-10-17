package com.neusoft.reliable.base.queryfailintegral.service;

import com.neusoft.common.context.DistributedContext;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.base.queryfailintegral.dao.QueryFailIntegralDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryFailIntegralService {

    @Resource
    private QueryFailIntegralDao queryFailIntegralDao;

    public List<ReliableEntity> queryFailIntegral(){
        ReliableEntity entity = new ReliableEntity();
        entity.setIntegralStatus(DistributedContext.FAIL);
        return queryFailIntegralDao.queryFailIntegral(entity);
    }
}
