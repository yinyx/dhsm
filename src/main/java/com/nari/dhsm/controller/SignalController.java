package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.SignalService;
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
@RequestMapping(value="/status/signal")
@Api(value="/status/signal",tags = {"软件信号接口"},description = "软件信号接口Api")
public class SignalController {
    private Logger log = LoggerFactory.getLogger(SignalController.class);

    @Autowired
    private SignalService signalService;

    @RequestMapping(value="/getSoftSignal",method= RequestMethod.POST)
    @ApiOperation("获取软件信号")
    public JSONObject getSoftSignal(@RequestParam Map<String,Object> map){
        log.info("==== 获取软件信号 ====");
        JSONObject jsonObject = new JSONObject();
        try {
            List<HashMap<String, Object>> blockSignalList = signalService.getBlockSignalList((String) map.get("deviceId"),Integer.valueOf((String) map.get("type")));
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



}
