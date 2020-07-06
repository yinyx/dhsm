package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
public interface DetectService {

    List<HashMap<String,Object>>  getStationInfo();

    List<HashMap<String,Object>>  getDeviceInfo(String stationId);

    List<HashMap<String,Object>>  getModuleInfo(String deviceId);
}
