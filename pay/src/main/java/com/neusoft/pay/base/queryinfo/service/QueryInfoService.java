package com.neusoft.pay.base.queryinfo.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.pay.base.queryinfo.dao.QueryInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询状态
 */
@Service
public class QueryInfoService {

    @Resource
    private QueryInfoDao queryInfoDao;

    /**
     * 转账请求
     * @param param
     * @return
     */
    @Transactional
    public String queryInfo(String param){
        List<OrderInfo> list = JSONObject.parseObject(param, new TypeReference<List<OrderInfo>>(){});
        List<OrderInfo> res = queryInfoDao.queryInfo(list);
        return JSONObject.toJSON(res).toString();
    }
}
