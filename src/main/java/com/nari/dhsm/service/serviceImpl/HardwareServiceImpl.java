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
    public List<PluginTemplate> getPluginTemplateList(String pluginType) {
        return hardwareMapper.getPluginTemplate(pluginType);
    }

    @Override
    public List<HashMap<String, Object>> getPwrOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getPwrOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getAdcOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getAdcOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getAiOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getAiOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getBiOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getBiOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getBoOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getBoOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getLcdOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getLcdOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getSvOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getSvOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getCpuOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getCpuOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }

    @Override
    public List<HashMap<String, Object>> getBoxOnlineList(String deviceId,int slot) {
        List<HashMap<String,Object>> hardwareList = hardwareMapper.getBoxOnlineList(deviceId,slot);
        Iterator<HashMap<String,Object>> iterator = hardwareList.iterator();
        while(iterator.hasNext()){
            HashMap<String,Object> tempMap = iterator.next();
            tempMap.put("typeName","硬件模块");
            if(0 == (int)tempMap.get("valid")){
                tempMap.put("value",null);
            }
        }
        return hardwareList;
    }
}
