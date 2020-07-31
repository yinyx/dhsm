package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/13
 */
@Mapper
@Repository
public interface AlarmMapper {
    /**
     * 根据设备Id获取报警信息
     * @param deviceId
     * @return
     */
    List<HashMap<String,Object>> getAlarmMap(Map<String,Object> map);

    /**
     * 根据设备Id获取报警数目
     * @param deviceId
     * @return
     */
    int getAlarmNum(String deviceId);

    /**
     * 根据设备Id,报警记录Id设置该条报警记录状态为已处理
     * @param deviceId，alarmId
     * @return
     */
    void setAlarmStatus(Map<String,Object> map);

    /**
     * 根据设备Id,报警记录Id,批次id获取当前批次的所有监测信号值
     * @param deviceId，alarmId，callId
     * @return
     */
    List<HashMap<String,Object>>  getSignalMap(Map<String,Object> map);
}
