package com.neusoft.reliable.base.prehandle.dao;

import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreHandleDao {
    /**
     * 保存预处理信息
     * @param entity
     * @return
     */
    int savePreHandleInfo(ReliableEntity entity);

}
