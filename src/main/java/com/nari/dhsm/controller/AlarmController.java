package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.AlarmService;
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
 * @author zhangheng
 * @version 1.0 2020/7/13
 */
@RestController
@RequestMapping(value="/alarm")
@Api(value="/alarm",tags = {"报警模块接口"},description = "报警模块接口Api")
public class AlarmController {
    private Logger log = LoggerFactory.getLogger(AlarmController.class);

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value="/getAlarmList",method= RequestMethod.POST)
    @ApiOperation("获取报警列表信息")
    public JSONObject getAlarmList(@RequestParam Map<String,Object> map){
        log.info("==== 获取报警列表信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            String start = (String)map.get("startRecord");
            int startRecord = Integer.parseInt(start);
            map.put("startRecord", startRecord);
            String length = (String)map.get("lengthRecord");
            int lengthRecord = Integer.parseInt(length);
            map.put("lengthRecord", lengthRecord);
            List<HashMap<String,Object>> alarmList = alarmService.getAlarmList(map);
            int alarmNum = alarmService.getAlarmNum((String) map.get("deviceId"));
                jsonObject.put("list",alarmList);
                jsonObject.put("num",alarmNum);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/setAlarmStatus",method= RequestMethod.POST)
    @ApiOperation("设置报警为已处理")
    public JSONObject setAlarmStatus(@RequestParam Map<String,Object> map){
        log.info("==== 设置报警为已处理 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            alarmService.setAlarmStatus(map);
            jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getAlarmDetail",method= RequestMethod.POST)
    @ApiOperation("获取报警同批次上召信息")
    public JSONObject getAlarmDetail(@RequestParam Map<String,Object> map){
        log.info("==== 获取报警同批次上召信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            List<HashMap<String,Object>> signalList = alarmService.getSignalList(map);
            jsonObject.put("data",signalList);
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
