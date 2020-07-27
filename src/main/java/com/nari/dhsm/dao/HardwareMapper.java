package com.nari.dhsm.dao;

import com.nari.dhsm.entity.PluginTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/7
 */
@Mapper
@Repository
public interface HardwareMapper {

    List<PluginTemplate> getPluginTemplate(String pluginType);

    List<HashMap<String,Object>> getPwrOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getAdcOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getAiOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getBiOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getBoOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getLcdOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getSvOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getCpuOnlineList(String deviceId,int slot);
    List<HashMap<String,Object>> getBoxOnlineList(String deviceId,int slot);

}
