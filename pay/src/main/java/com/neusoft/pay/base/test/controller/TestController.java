package com.neusoft.pay.base.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Map<String, String> activityorder(String param)  {
        Map<String, String> map = new HashMap<>();
        map.put("res", param);
        return map;
    }

}
