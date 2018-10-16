package com.neusoft.reliable.base.donehandle.dao;

import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoneHandleDao {
    /**
     * 保存已处理信息
     * @param entity
     * @return
     */
    int saveDoneHandleInfo(ReliableEntity entity);

}
