package com.neusoft.reliable.scheduled.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.neusoft.common.entity.OrderInfo;
import com.neusoft.common.uti.HttpUtil;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.scheduled.dao.UnFinshTransferDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 处理未完成转账信息
 */
@Service
public class UnFinshTransferService {

    @Resource
    private UnFinshTransferDao unFinshTransferDao;

    /**
     * 处理未完成的转账信息
     */
    public void execUnFinshTransfer(){
        ReliableEntity entity = new ReliableEntity();
        //查询处理中的
        entity.setOrderStatus("2");
        //查询一天时间内的，一天没处理完，多半是挂了
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        //日期减1天
        rightNow.add(Calendar.DAY_OF_YEAR,-1);
        entity.setCreateTime(rightNow.getTime());
        List<ReliableEntity> list = unFinshTransferDao.queryUnFinshTransfer(entity);
        if(list == null || list.size() == 0){
            return;
        }
        //TODO
        //获取到处理中的数据，然后去pay工程调用接口查询对应订单的结果
        Map<String, Object> map = new HashMap<>();
        map.put("list", JSONObject.toJSON(list).toString());
        String res = HttpUtil.doPost("http://localhost:8082/pay/queryInfo", map);

        //更新表信息
        if(res != null){
            List<OrderInfo> resList = JSONObject.parseObject(res, new TypeReference<List<OrderInfo>>(){});
            if(resList != null && resList.size() > 0){
                unFinshTransferDao.updateTransferStatus(resList);
            }
        }
    }
}
