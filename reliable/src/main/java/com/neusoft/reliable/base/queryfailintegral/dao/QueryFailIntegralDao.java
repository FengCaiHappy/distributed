package com.neusoft.reliable.base.queryfailintegral.dao;

import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueryFailIntegralDao {
    List<ReliableEntity> queryFailIntegral(ReliableEntity entity);
}
