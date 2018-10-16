package com.neusoft.reliable.base.donehandle.controller;


import com.neusoft.common.entity.OrderInfo;
import com.neusoft.reliable.base.donehandle.service.DoneHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 信息处理完成接口
 */
@Controller
public class DoneHandleController {

    @Autowired
    private DoneHandleService doneHandleService;

    /**
     * 信息处理完成接口
     * @param param
     * @return
     */
    @RequestMapping(value = "doneHandle", method = RequestMethod.POST)
    @ResponseBody
    public String preHandle(OrderInfo param) {
        doneHandleService.doneHandle(param);
        return "success";
    }
}
