package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.StatisticMapper;
import com.nari.dhsm.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/13
 */
@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public String getStationName(String stationId){
        String StationName = statisticMapper.getStationName(stationId);
        return StationName;
    }

    @Override
    public int getDeviceNum(String stationId){
        int DeviceNum = statisticMapper.getDeviceNum(stationId);
        return DeviceNum;
    }

    @Override
    public int getOnlineDeviceNum(String stationId){
        int OnlineDeviceNum = statisticMapper.getOnlineDeviceNum(stationId);
        return OnlineDeviceNum;
    }

    @Override
    public int getFaultNum(String stationId){
        List<Map<String, Object>>  DeviceList = statisticMapper.getDeviceList(stationId);
        int sum = 0;
        for(int i=0;i<DeviceList.size();i++){
            String deviceId = (String) DeviceList.get(i).get("id");
            int deviceFaultNum = statisticMapper.getDeviceFaultNum(deviceId);
            sum += deviceFaultNum;
        }
        return sum;
    }

    @Override
    public int getSoftFaultNum(String stationId){
        List<Map<String, Object>>  DeviceList = statisticMapper.getDeviceList(stationId);
        int sum = 0;
        for(int i=0;i<DeviceList.size();i++){
            String deviceId = (String) DeviceList.get(i).get("id");
            int deviceFaultNum = statisticMapper.getSoftDeviceFaultNum(deviceId);
            sum += deviceFaultNum;
        }
        return sum;
    }

    @Override
    public int getHardFaultNum(String stationId){
        List<Map<String, Object>>  DeviceList = statisticMapper.getDeviceList(stationId);
        int sum = 0;
        for(int i=0;i<DeviceList.size();i++){
            String deviceId = (String) DeviceList.get(i).get("id");
            int deviceFaultNum = statisticMapper.getHardDeviceFaultNum(deviceId);
            sum += deviceFaultNum;
        }
        return sum;
    }

    @Override
    public List<Map<String, Object>> getDeviceList(String stationId){
        List<Map<String, Object>>  DeviceList = statisticMapper.getDeviceList(stationId);
        return DeviceList;
    }

    @Override
    public String getDeviceNameById(String deviceId){
        String DeviceName = statisticMapper.getDeviceNameById(deviceId);
        return DeviceName;
    }

    @Override
    public int getSoftNumById(String deviceId){
        int SoftNum = statisticMapper.getSoftDeviceFaultNum(deviceId);
        return SoftNum;
    }

    @Override
    public int getHardNumById(String deviceId){
        int HardNum = statisticMapper.getHardDeviceFaultNum(deviceId);
        return HardNum;
    }

    @Override
    public int getModuleNum(Map<String,Object> paramap){
        int ModuleNum = statisticMapper.getModuleNum(paramap);
        return ModuleNum;
    }

    @Override
    public int getModuleHistoryNum(Map<String,Object> paramap){
        int ModuleNum = statisticMapper.getModuleHistoryNum(paramap);
        return ModuleNum;
    }
}
