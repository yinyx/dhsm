package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.HardwareService;
import com.nari.dhsm.service.HistoryService;
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
 * @version 1.0 2020/7/27
 */
@RestController
@RequestMapping(value="/history")
@Api(value="/history",tags = {"信号历史数据接口"},description = "信号历史数据接口Api")
public class HistoryDataController {
    private Logger log = LoggerFactory.getLogger(HistoryDataController.class);

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value="/getHistorySignalList",method= RequestMethod.POST)
    @ApiOperation("获取历史信号列表")
    public JSONObject getHistorySignalList(@RequestParam Map<String,Object> map){
        log.info("==== 获取历史信号列表 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            HashMap<String, Object> historySignal = historyService.getHistorySignalList((String) map.get("deviceId"),(String)map.get("id"));
            if(historySignal != null) {
                jsonObject.put("list", historySignal);
                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message", ErrorCodeEnum.E00_0001.getMessage());
            }else{
                jsonObject.put("list", null);
                jsonObject.put("code", ErrorCodeEnum.E02_1000.getCode());
                jsonObject.put("message", ErrorCodeEnum.E02_1000.getMessage());
            }
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

}
