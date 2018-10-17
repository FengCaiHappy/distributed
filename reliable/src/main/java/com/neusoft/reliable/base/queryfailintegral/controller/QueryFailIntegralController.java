package com.neusoft.reliable.base.queryfailintegral.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.reliable.base.prehandle.entity.ReliableEntity;
import com.neusoft.reliable.base.queryfailintegral.service.QueryFailIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 查询积分处理失败的数据
 */
@Controller
public class QueryFailIntegralController {

    @Autowired
    private QueryFailIntegralService queryFailIntegralService;

    /**
     * 查询信息接口
     * @return
     */
    @RequestMapping(value = "queryFailIntegral", method = RequestMethod.POST)
    @ResponseBody
    public String queryFailIntegral() {
        List<ReliableEntity> list = queryFailIntegralService.queryFailIntegral();
        return JSONObject.toJSON(list).toString();
    }
}
