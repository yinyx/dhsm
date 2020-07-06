package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.DetectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@RestController
@RequestMapping(value="/status")
@Api(value="/status",tags = {"监测模块接口"},description = "监测模块接口Api")
public class DetectController {
    private Logger log = LoggerFactory.getLogger(DetectController.class);

    @Autowired
    private DetectService detectService;

    @RequestMapping(value="/getUserStation",method= RequestMethod.POST)
    @ApiOperation("获取变电站信息")
    public JSONObject getUserStation(){
        log.info("==== 获取变电站信息 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String, Object>> stationList = detectService.getStationInfo();
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

    @RequestMapping(value="/getDevice",method= RequestMethod.POST)
    @ApiOperation("获取设备信息")
    public JSONObject getDevice(@RequestParam Map<String,Object> map){
        log.info("==== 获取设备信息 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String, Object>> deviceList = detectService.getDeviceInfo((String) map.get("stationId"));
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

    @RequestMapping(value="/getModule",method= RequestMethod.POST)
    @ApiOperation("获取模块信息")
    public JSONObject getModule(@RequestParam Map<String,Object> map){
        log.info("==== 获取模块信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            List<HashMap<String,Object>> moduleList = detectService.getModuleInfo((String) map.get("deviceId"));
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

}
