package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
public interface DetectService {

    List<HashMap<String,Object>>  getStationInfoList();

    List<HashMap<String,Object>>  getDeviceInfoList();

    List<HashMap<String,Object>>  getModuleInfoList(String deviceId);

    List<HashMap<String,Object>>  getPluginInfoList(String deviceId,int src);
}
