package com.neusoft.reliable.scheduled.dao;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnFinshIntegralDao {

    List<OrderInfo> queryUnFinshIntegral(ReliableEntity entity);

    int updateIntegralStatus(List<OrderInfo> list);
}
