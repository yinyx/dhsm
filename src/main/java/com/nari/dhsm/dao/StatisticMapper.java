package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/21
 */
@Mapper
@Repository
public interface StatisticMapper {
    /**
     * 根据变电站Id查询变电站名称
     * @param stationId
     * @return
     */
    String getStationName(String stationId);

    /**
     * 根据变电站Id查询所属装置数量
     * @param stationId
     * @return
     */
    int getDeviceNum(String stationId);

    /**
     * 根据变电站Id查询所属在线装置数量
     * @param stationId
     * @return
     */
    int getOnlineDeviceNum(String stationId);

    /**
     * 根据变电站Id查询所属在线装置集合
     * @param stationId
     * @return
     */
    List<Map<String, Object>> getDeviceList(String stationId);

    /**
     * 根据装置Id查询该装置的实时故障数
     * @param deviceId
     * @return
     */
    int getDeviceFaultNum(String deviceId);

    /**
     * 根据装置Id查询该装置的实时软件故障数
     * @param deviceId
     * @return
     */
    int getSoftDeviceFaultNum(String deviceId);

    /**
     * 根据装置Id查询该装置的实时硬件故障数
     * @param deviceId
     * @return
     */
    int getHardDeviceFaultNum(String deviceId);

    /**
     * 根据变电站Id获取所属装置id列表
     * @param stationId
     * @return
     */
    List<String> getDeviceIdList(String stationId);

    /**
     * 根据装置Id查询装置名称
     * @param deviceId
     * @return
     */
    String getDeviceNameById(String deviceId);

    /**
     * 根据变电站id,模块类型查询该类型当前报警数目
     * @param paramap
     * @return
     */
    int getModuleNum(Map<String,Object> paramap);

    /**
     * 根据变电站id,模块类型,时间范围查询该类型历史报警数目
     * @param paramap
     * @return
     */
    int getModuleHistoryNum(Map<String,Object> paramap);
}
