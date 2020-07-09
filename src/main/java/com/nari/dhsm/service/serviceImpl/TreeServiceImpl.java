package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.TreeDataMapper;
import com.nari.dhsm.service.TreeService;
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
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDataMapper treeDataMapper;


    @Override
    public List<HashMap<String, Object>> getStationInfoList() {
        List<HashMap<String,Object>> stationList = treeDataMapper.getStationMap();
        Iterator<HashMap<String,Object>> iterator = stationList.iterator();
        while(iterator.hasNext()){//遍历所有变电站信息，如有设备报警则将显示图标置为报错
            HashMap<String,Object> stationMap = iterator.next();
            if(treeDataMapper.getStationStatus((String) stationMap.get("id"))){
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
    public List<HashMap<String, Object>> getDeviceInfoList() {
        List<HashMap<String,Object>> deviceList = treeDataMapper.getDeviceMap();
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
    public List<HashMap<String, Object>> getModuleInfoList(String deviceId) {
        HashMap<String,Object> hmoduleMap = new HashMap<>();
        HashMap<String,Object> smoduleMap = new HashMap<>();
        if(treeDataMapper.getHmoduleStatus(deviceId)){
            hmoduleMap.put("id",0);
            hmoduleMap.put("name","硬件模块");
            hmoduleMap.put("icon","fault");
            hmoduleMap.put("leaf","false");
            hmoduleMap.put("deviceId",deviceId);
        }else{
            hmoduleMap.put("id",0);
            hmoduleMap.put("name","硬件模块");
            hmoduleMap.put("icon","normal");
            hmoduleMap.put("leaf","false");
            hmoduleMap.put("deviceId",deviceId);
        }

        if(treeDataMapper.getSmoduleStatus(deviceId)){
            smoduleMap.put("id",1);
            smoduleMap.put("name","软件模块");
            smoduleMap.put("icon","fault");
            smoduleMap.put("leaf","true");
            smoduleMap.put("deviceId",deviceId);
        }else{
            smoduleMap.put("id",1);
            smoduleMap.put("name","软件模块");
            smoduleMap.put("icon","normal");
            smoduleMap.put("leaf","true");
            smoduleMap.put("deviceId",deviceId);
        }
        List<HashMap<String,Object>> arrList = new ArrayList<>();
        arrList.add(hmoduleMap);
        arrList.add(smoduleMap);
        return arrList;
    }

    @Override
    public List<HashMap<String, Object>> getPluginInfoList(String deviceId ,int src) {
        List<HashMap<String,Object>> hPluginList = new ArrayList<>();
        if(src == 0){
             hPluginList = treeDataMapper.getHardwarePluginMap(deviceId);
            Iterator<HashMap<String,Object>> iterator = hPluginList.iterator();
            while(iterator.hasNext()){//遍历设备列表，如有报错则将显示图标置为报错
                HashMap<String,Object> hPluginMap = iterator.next();
                if(hPluginMap.get("alarmFlag").equals(1)){
                    String name = hPluginMap.get("name") + " 槽号：" + hPluginMap.get("slot");
                    hPluginMap.put("name",name);
                    hPluginMap.put("icon","fault");
                    hPluginMap.put("leaf","true");
                }else{
                    String name = hPluginMap.get("name") + " 槽号：" + hPluginMap.get("slot");
                    hPluginMap.put("name",name);
                    hPluginMap.put("icon","normal");
                    hPluginMap.put("leaf","true");
                }
            }
            return hPluginList;
        }
        return hPluginList;
    }
}
