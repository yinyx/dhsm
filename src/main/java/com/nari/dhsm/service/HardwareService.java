package com.nari.dhsm.service;

import com.nari.dhsm.entity.PluginTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/20
 */
public interface HardwareService {

    List<PluginTemplate> getPluginTemplateList(String pluginType);


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
