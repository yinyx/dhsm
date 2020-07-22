package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.HardwareMapper;
import com.nari.dhsm.entity.PluginTemplate;
import com.nari.dhsm.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/20
 */
@Service
public class HardwareServiceImpl  implements HardwareService {

    @Autowired
    HardwareMapper hardwareMapper;

    @Override
    public List<PluginTemplate> getPwrTemplateList() {
        return hardwareMapper.getPluginTemplate("PWR");
    }

    @Override
    public List<PluginTemplate> getAdcTemplateList() {
        return hardwareMapper.getPluginTemplate("ADC");
    }

    @Override
    public List<PluginTemplate> getAiTemplateList() {
        return hardwareMapper.getPluginTemplate("AI");
    }

    @Override
    public List<HashMap<String, Object>> getPwrOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getPwrOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();

        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
        }

        return hardwareList;


    }
}
