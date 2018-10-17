package com.neusoft.reliable.scheduled.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpdateIntegralStatusDao {
    void updateIntegralStatus();
}
