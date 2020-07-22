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

    HashMap<String,Object> getPluginValue(String deviceId,String signalId,int slot);
}
