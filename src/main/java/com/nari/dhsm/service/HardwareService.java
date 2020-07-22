package com.nari.dhsm.service;

import com.nari.dhsm.entity.PluginTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/20
 */
public interface HardwareService {

    List<PluginTemplate> getPwrTemplateList();

    List<PluginTemplate> getAdcTemplateList();

    List<PluginTemplate> getAiTemplateList();


    List<HashMap<String,Object>> getPwrOnlineList(String deviceId,int slot);
}
