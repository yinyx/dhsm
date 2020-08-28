package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/13
 */
public interface AlarmService {

    List<HashMap<String,Object>>  getAlarmList(Map<String,Object> map);

    int getAlarmNum(String deviceId);

    void setAlarmStatus(Map<String,Object> map);

    List<HashMap<String,Object>> getSignalList(Map<String,Object> map);

    int getSignalNum(Map<String,Object> map);

}
