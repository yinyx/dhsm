package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/21
 */
public interface StatisticService {

    String getStationName(String stationId);

    int getDeviceNum(String stationId);

    int getOnlineDeviceNum(String stationId);

    int getFaultNum(String stationId);

    int getSoftFaultNum(String stationId);

    int getHardFaultNum(String stationId);

    List<Map<String, Object>> getDeviceList(String stationId);

    String getDeviceNameById(String deviceId);

    int getSoftNumById(String deviceId);

    int getHardNumById(String deviceId);

    int getModuleNum(Map<String,Object> paramap);

    int getModuleHistoryNum(Map<String,Object> paramap);

    List<HashMap<String, Object>> getStationList();

    List<HashMap<String, Object>> getPWRCfgList(String stationId, String moduleName);

    int getPwrDetailNum(String PWRId);

    //List<HashMap<String, Object>> getADCCfgList(String stationId);

    //int getAdcDetailNum(String ADCId);
}
