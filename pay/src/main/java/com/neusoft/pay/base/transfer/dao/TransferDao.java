package com.neusoft.pay.base.transfer.dao;

import com.neusoft.pay.base.transfer.entity.TransferEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransferDao {
    /**
     * 保存转账信息
     * @param entity
     * @return
     */
    int saveTransferInfo(TransferEntity entity);

    /**
     * 修改转账信息
     * @param entity
     * @return
     */
    int updateTransferInfo(TransferEntity entity);
}
