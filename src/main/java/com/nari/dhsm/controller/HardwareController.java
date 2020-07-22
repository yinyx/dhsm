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

    @RequestMapping(value="/getPwrTemplate",method= RequestMethod.POST)
    @ApiOperation("获取PWR模板量")
    public JSONObject getPwrTemplate(){
        log.info("==== 获取PWR模板量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<PluginTemplate> blockSignalList = hardwareService.getPwrTemplateList();
                jsonObject.put("list", blockSignalList);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
                jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }



    @RequestMapping(value="/getAdcTemplate",method= RequestMethod.POST)
    @ApiOperation("获取ADC模板量")
    public JSONObject getAdcTemplate(){
        log.info("==== 获取ADC模板量 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<PluginTemplate> blockSignalList = hardwareService.getAdcTemplateList();
            jsonObject.put("list", blockSignalList);
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

}
