package com.neusoft.reliable.base.prehandle.controller;

import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.prehandle.service.PreHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 信息预处理
 */
@Controller
public class PreHandleController {

    @Autowired
    private PreHandleService preHandleService;

    /**
     * 信息预处理接口
     * @param param
     * @return
     */
    @RequestMapping(value = "preHandle", method = RequestMethod.POST)
    @ResponseBody
    public String preHandle(OrderInfo param) {
        preHandleService.preHandle(param);
        return "success";
    }
}
