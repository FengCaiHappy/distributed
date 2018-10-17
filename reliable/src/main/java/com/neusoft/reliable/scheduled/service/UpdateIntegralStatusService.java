package com.neusoft.reliable.scheduled.service;

import com.neusoft.reliable.scheduled.dao.UpdateIntegralStatusDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UpdateIntegralStatusService {

    @Resource
    private UpdateIntegralStatusDao updateIntegralStatusDao;

    public void updateIntegralStatus(){
        updateIntegralStatusDao.updateIntegralStatus();
    }
}
