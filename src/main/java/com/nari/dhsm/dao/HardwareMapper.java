package com.nari.dhsm.dao;

import com.nari.dhsm.entity.PluginTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<HashMap<String,Object>> getPwrOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getAdcOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getAiOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getBiOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getBoOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getLcdOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getSvOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getCpuOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);
    List<HashMap<String,Object>> getBoxOnlineList(@Param("deviceId")String deviceId, @Param("slot")int slot);

}
