package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.DetectMapper;
import com.nari.dhsm.service.DetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@Service
public class DetectServiceImpl implements DetectService {

    @Autowired
    private DetectMapper detectMapper;


    @Override
    public List<HashMap<String, Object>> getStationInfo() {
        List<HashMap<String,Object>> stationList = detectMapper.getStationMap();
        Iterator<HashMap<String,Object>> iterator = stationList.iterator();
        while(iterator.hasNext()){//遍历所有变电站信息，如有设备报警则将显示图标置为报错
            HashMap<String,Object> stationMap = iterator.next();
            if(detectMapper.getStationStatus((String) stationMap.get("id"))){
                stationMap.put("icon","fault");
                stationMap.put("leaf","false");
            }else{
                stationMap.put("icon","normal");
                stationMap.put("leaf","false");
            }
        }
        return stationList;
    }

    @Override
    public List<HashMap<String, Object>> getDeviceInfo(String stationId) {
        List<HashMap<String,Object>> deviceList = detectMapper.getDeviceMap(stationId);
        Iterator<HashMap<String,Object>> iterator = deviceList.iterator();

        while(iterator.hasNext()){//遍历设备列表，如有报错则将显示图标置为报错
            HashMap<String,Object> deviceMap = iterator.next();
            if(1 == (int)deviceMap.get("alarmFlag")){
                String name = deviceMap.get("name") + " 型号：" + deviceMap.get("model");
                deviceMap.put("name",name);
                deviceMap.put("icon","fault");
                deviceMap.put("leaf","false");
            }else{
                String name = deviceMap.get("name") + " 型号：" + deviceMap.get("model");
                deviceMap.put("name",name);
                deviceMap.put("icon","normal");
                deviceMap.put("leaf","false");
            }

        }
        return deviceList;
    }

    @Override
    public List<HashMap<String, Object>> getModuleInfo(String deviceId) {
        HashMap<String,Object> HmoduleMap = new HashMap<>();
        HashMap<String,Object> SmoduleMap = new HashMap<>();
        if(detectMapper.getHmoduleStatus(deviceId)){
            HmoduleMap.put("id",deviceId);
            HmoduleMap.put("name","硬件模块");
            HmoduleMap.put("icon","fault");
            HmoduleMap.put("leaf","false");
        }else{
            HmoduleMap.put("id",deviceId);
            HmoduleMap.put("name","硬件模块");
            HmoduleMap.put("icon","normal");
            HmoduleMap.put("leaf","false");
        }

        if(detectMapper.getSmoduleStatus(deviceId)){
            SmoduleMap.put("id",deviceId);
            HmoduleMap.put("name","软件模块");
            HmoduleMap.put("icon","fault");
            HmoduleMap.put("leaf","false");
        }else{
            SmoduleMap.put("id",deviceId);
            HmoduleMap.put("name","软件模块");
            HmoduleMap.put("icon","normal");
            HmoduleMap.put("leaf","false");
        }
        List<HashMap<String,Object>> arrList = new ArrayList<>();
        arrList.add(HmoduleMap);
        arrList.add(SmoduleMap);
        return arrList;
    }
}
