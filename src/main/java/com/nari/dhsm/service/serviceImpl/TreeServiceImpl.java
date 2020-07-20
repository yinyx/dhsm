package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.SignalMapper;
import com.nari.dhsm.dao.TreeDataMapper;
import com.nari.dhsm.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDataMapper treeDataMapper;
    @Autowired
    private SignalMapper signalMapper;

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
            hmoduleMap.put("type",100);
        }else{
            hmoduleMap.put("id",0);
            hmoduleMap.put("name","硬件模块");
            hmoduleMap.put("icon","normal");
            hmoduleMap.put("leaf","false");
            hmoduleMap.put("deviceId",deviceId);
            hmoduleMap.put("type",100);
        }

        if(treeDataMapper.getSmoduleStatus(deviceId)){
            smoduleMap.put("id",1);
            smoduleMap.put("name","软件模块");
            smoduleMap.put("icon","fault");
            smoduleMap.put("leaf","false");
            smoduleMap.put("deviceId",deviceId);
            smoduleMap.put("type",111);
        }else{
            smoduleMap.put("id",1);
            smoduleMap.put("name","软件模块");
            smoduleMap.put("icon","normal");
            smoduleMap.put("leaf","false");
            smoduleMap.put("deviceId",deviceId);
            smoduleMap.put("type",111);
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
                    hPluginMap.put("icon","fault");
                    hPluginMap.put("leaf",true);
                    hPluginMap.put("type",hPluginMap.get("name"));
                    hPluginMap.put("name",name);
                    hPluginMap.put("slot", hPluginMap.get("slot"));
                }else{
                    String name = hPluginMap.get("name") + " 槽号：" + hPluginMap.get("slot");
                    hPluginMap.put("type",hPluginMap.get("name"));
                    hPluginMap.put("name",name);
                    hPluginMap.put("icon","normal");
                    hPluginMap.put("leaf",true);
                    hPluginMap.put("slot", hPluginMap.get("slot"));
                }
            }
            return hPluginList;
        }
        return hPluginList;
    }

    @Override
    public List<HashMap<String, Object>> getSignalTypeList(String deviceId) {
        List<HashMap<String,Object>> signalTypeList = new ArrayList<>();
        HashMap<String,Object> firTypeMap = new HashMap<>();
        HashMap<String,Object> secTypeMap = new HashMap<>();
        HashMap<String,Object> thirdTypeMap = new HashMap<>();

        if(signalMapper.checkFirstSignal(deviceId,0)){
                firTypeMap.put("id", UUID.randomUUID().toString());
                firTypeMap.put("name","闭锁信号");
                firTypeMap.put("icon","fault");
                firTypeMap.put("leaf",true);
                firTypeMap.put("type",0);
                firTypeMap.put("deviceId",deviceId);
            }else{
                firTypeMap.put("id", UUID.randomUUID().toString());
                firTypeMap.put("name","闭锁信号");
                firTypeMap.put("icon","normal");
                firTypeMap.put("leaf",true);
                firTypeMap.put("type",0);
                firTypeMap.put("deviceId",deviceId);
            }
        if(signalMapper.checkSecSignal(deviceId,1)){
            secTypeMap.put("id", UUID.randomUUID().toString());
            secTypeMap.put("name","告警信号");
            secTypeMap.put("icon","fault");
            secTypeMap.put("leaf",true);
            secTypeMap.put("type",1);
            secTypeMap.put("deviceId",deviceId);
        }else{
            secTypeMap.put("id", UUID.randomUUID().toString());
            secTypeMap.put("name","告警信号");
            secTypeMap.put("icon","normal");
            secTypeMap.put("leaf",true);
            secTypeMap.put("type",1);
            secTypeMap.put("deviceId",deviceId);
        }

        if(signalMapper.checkThirdSignal(deviceId,2)){
            thirdTypeMap.put("id", UUID.randomUUID().toString());
            thirdTypeMap.put("name","智能板卡报警闭锁信号");
            thirdTypeMap.put("icon","fault");
            thirdTypeMap.put("leaf",true);
            thirdTypeMap.put("type",2);
            thirdTypeMap.put("deviceId",deviceId);
        }else{
            thirdTypeMap.put("id", UUID.randomUUID().toString());
            thirdTypeMap.put("name","智能板卡报警闭锁信号");
            thirdTypeMap.put("icon","normal");
            thirdTypeMap.put("leaf",true);
            thirdTypeMap.put("type",2);
            thirdTypeMap.put("deviceId",deviceId);
        }
        signalTypeList.add(firTypeMap);
        signalTypeList.add(secTypeMap);
        signalTypeList.add(thirdTypeMap);

        return signalTypeList;
    }
}
