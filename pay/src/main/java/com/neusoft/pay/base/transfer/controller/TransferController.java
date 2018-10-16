package com.neusoft.pay.base.transfer.controller;

import com.neusoft.common.entity.restful.AppResponse;
import com.neusoft.pay.base.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟转账
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    /**
     * 转账请求
     * @param param
     * @return
     */
    @RequestMapping(value = "transfer", method = RequestMethod.POST)
    public AppResponse transfer(String param)  {
        transferService.doTransfer(param);
        return AppResponse.success("处理成功");
    }

}
