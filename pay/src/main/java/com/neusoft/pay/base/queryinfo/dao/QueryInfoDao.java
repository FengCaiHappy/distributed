package com.neusoft.pay.base.queryinfo.dao;

import com.neusoft.common.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueryInfoDao {
    /**
     * 查询状态
     * @param list
     * @return
     */
    List<OrderInfo> queryInfo(List<OrderInfo> list);

}
