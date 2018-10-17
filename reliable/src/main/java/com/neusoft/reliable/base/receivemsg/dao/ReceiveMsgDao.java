package com.neusoft.reliable.base.receivemsg.dao;

import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiveMsgDao {
    /**
     * 保存预处理信息
     * @param entity
     * @return
     */
    int saveReveiveMsgInfo(ReliableEntity entity);

}
