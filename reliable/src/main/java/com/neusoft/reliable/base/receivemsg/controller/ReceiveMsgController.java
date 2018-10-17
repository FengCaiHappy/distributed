package com.neusoft.reliable.base.receivemsg.controller;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.receivemsg.service.ReceiveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 接收积分模块推送的数据
 */
@Controller
public class ReceiveMsgController {

    @Autowired
    private ReceiveMsgService receiveMsgService;

    /**
     * 接收数据接口
     * @param param
     * @return
     */
    @RequestMapping(value = "receiveMsg", method = RequestMethod.POST)
    @ResponseBody
    public String receiveMsg(OrderInfo param) {
        receiveMsgService.receiveMsg(param);
        return "success";
    }
}
