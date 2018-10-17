package com.neusoft.pay.base.queryinfo.controller;

import com.neusoft.pay.base.queryinfo.service.QueryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询状态接口
 */
@RestController
public class QueryInfoController {

    @Autowired
    private QueryInfoService queryInfoService;

    /**
     * 查询状态
     * @param list
     * @return
     */
    @RequestMapping(value = "queryInfo", method = RequestMethod.POST)
    public String transfer(String list)  {
        return queryInfoService.queryInfo(list);
    }

}
