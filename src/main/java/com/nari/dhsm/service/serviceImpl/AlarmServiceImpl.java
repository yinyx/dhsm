package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.AlarmMapper;
import com.nari.dhsm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhangheng
 * @version 1.0 2020/7/13
 */
@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmMapper alarmMapper;

    @Override
    public List<HashMap<String, Object>> getAlarmList(Map<String,Object> map) {
        List<HashMap<String,Object>> alarmList = new ArrayList<>();
        alarmList = alarmMapper.getAlarmMap(map);
        return alarmList;
    }

    @Override
    public int getAlarmNum(String deviceId) {
        int alarmNum = alarmMapper.getAlarmNum(deviceId);
        return alarmNum;
    }

    @Override
    public void setAlarmStatus(Map<String,Object> map){
        alarmMapper.setAlarmStatus(map);
    }

    @Override
    public List<HashMap<String,Object>> getSignalList(Map<String,Object> map){
        List<HashMap<String,Object>> signalList = new ArrayList<>();
        signalList = alarmMapper.getSignalMap(map);
        return signalList;
    }
}
