package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.entity.PluginTemplate;
import com.nari.dhsm.service.HardwareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@RestController
@RequestMapping(value="/status/plugin")
@Api(value="/status/plugin",tags = {"硬件信号接口"},description = "硬件信号接口Api")
public class HardwareController {
    private Logger log = LoggerFactory.getLogger(HardwareController.class);

    @Autowired
    private HardwareService hardwareService;

    @RequestMapping(value="/getPluginTemplate",method= RequestMethod.POST)
    @ApiOperation("按类型获取插件模板量")
    public JSONObject getPluginTemplate(@RequestParam Map<String,Object> map){
        log.info("==== 按类型获取插件模板量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<PluginTemplate> pluginTemplatesList = hardwareService.getPluginTemplateList((String)map.get("pluginType"));
                jsonObject.put("list", pluginTemplatesList);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
                jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }


    @RequestMapping(value="/getPwrOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取PWR实时量")
    public JSONObject getPwrOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取PWR实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> pwrOnlineList = hardwareService.getPwrOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", pwrOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getAdcOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取ADC实时量")
    public JSONObject getAdcOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取ADC实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> adcOnlineList = hardwareService.getAdcOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", adcOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getAiOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取AI实时量")
    public JSONObject getAiOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取AI实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> aiOnlineList = hardwareService.getAiOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", aiOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getBiOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取BI实时量")
    public JSONObject getBiOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取BI实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> biOnlineList = hardwareService.getBiOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", biOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getBoOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取BO实时量")
    public JSONObject getBoOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取BO实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> boOnlineList = hardwareService.getBoOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", boOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getLcdOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取LCD实时量")
    public JSONObject getLcdOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取LCD实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> lcdOnlineList = hardwareService.getLcdOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", lcdOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getSvOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取SV/GOOSE实时量")
    public JSONObject getSvOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取SV/GOOSE实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> svOnlineList = hardwareService.getSvOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", svOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getCpuOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取CPU实时量")
    public JSONObject getCpuOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取SV/GOOSE实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> cpuOnlineList = hardwareService.getCpuOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", cpuOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getBoxOnlineSignal",method= RequestMethod.POST)
    @ApiOperation("获取机箱实时量")
    public JSONObject getBoxOnlineSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取机箱实时量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String,Object>> boxOnlineList = hardwareService.getBoxOnlineList((String) map.get("deviceId"), Integer.parseInt((String)map.get("slot")));
            jsonObject.put("list", boxOnlineList);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }
}
