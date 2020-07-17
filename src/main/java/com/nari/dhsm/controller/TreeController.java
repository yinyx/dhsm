package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.TreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@RestController
@RequestMapping(value="/status")
@Api(value="/status",tags = {"监测模块接口"},description = "监测模块接口Api")
public class TreeController {
    private Logger log = LoggerFactory.getLogger(TreeController.class);

    @Autowired
    private TreeService treeService;

    @RequestMapping(value="/getUserStationList",method= RequestMethod.POST)
    @ApiOperation("获取变电站列表信息")
    public JSONObject getUserStationList(){
        log.info("==== 获取变电站列表信息 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String, Object>> stationList = treeService.getStationInfoList();
                jsonObject.put("list", stationList);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
                jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getDeviceList",method= RequestMethod.POST)
    @ApiOperation("获取设备列表信息")
    public JSONObject getDeviceList(){
        log.info("==== 获取设备列表信息 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String, Object>> deviceList = treeService.getDeviceInfoList();
                jsonObject.put("list", deviceList);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
                jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getModuleList",method= RequestMethod.POST)
    @ApiOperation("获取模块列表信息")
    public JSONObject getModuleList(@RequestParam Map<String,Object> map){
        log.info("==== 获取模块列表信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            List<HashMap<String,Object>> moduleList = treeService.getModuleInfoList((String) map.get("deviceId"));
                jsonObject.put("list",moduleList);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getPluginList",method= RequestMethod.POST)
    @ApiOperation("获取插件列表信息")
    public JSONObject getPluginList(@RequestParam Map<String,Object> map){
        log.info("==== 获取插件列表信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            List<HashMap<String,Object>> pluginList = treeService.getPluginInfoList((String) map.get("deviceId"), Integer.valueOf((String) map.get("src")));
            jsonObject.put("list",pluginList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getSignalTypeList",method= RequestMethod.POST)
    @ApiOperation("获取信号类型信息")
    public JSONObject getSignalTypeList(@RequestParam Map<String,Object> map){
        log.info("==== 获取信号类型信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            List<HashMap<String,Object>> signalTypeList = treeService.getSignalTypeList((String) map.get("deviceId"));
            jsonObject.put("list",signalTypeList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }
}
