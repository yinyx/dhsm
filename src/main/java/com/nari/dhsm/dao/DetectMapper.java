package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@Mapper
@Repository
public interface DetectMapper {

    /**
     * 获取变电站信息
     * @return
     */
    List<HashMap<String,Object>> getStationMap();

    /**
     * 获取变电站状态
     * @param stationId
     * @return
     */
    Boolean getStationStatus(String stationId);

    /**
     * 根据变电站Id获取设备信息
     * @param stationId
     * @return
     */
    List<HashMap<String,Object>> getDeviceMap(String stationId);

    /**
     * 根据设备Id 获取硬件模块状态
     * @param deviceId
     * @return
     */
    Boolean getHmoduleStatus(String deviceId);

    /**
     * 根据设备Id 获取软件模块状态
     * @param deviceId
     * @return
     */
    Boolean getSmoduleStatus(String deviceId);
}
