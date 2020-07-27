package com.nari.dhsm.controller;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangheng
 * @version 1.0 2020/7/21
 */
@RestController
@RequestMapping(value="/statistic")
@Api(value="/statistic",tags = {"统计模块接口"},description = "统计模块接口Api")
public class StatisticController {
    private Logger log = LoggerFactory.getLogger(StatisticController.class);

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value="/getStatisticList",method= RequestMethod.POST)
    @ApiOperation("获取统计信息")
    public JSONObject getStatisticList(@RequestParam Map<String,Object> map){
        log.info("==== 获取统计信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            String stationId = (String) map.get("stationId");
            String StationName = statisticService.getStationName(stationId);
            int DeviceNum = statisticService.getDeviceNum(stationId);
            int OnlineDeviceNum = statisticService.getOnlineDeviceNum(stationId);
            int FaultNum = statisticService.getFaultNum(stationId);
            int SoftFaultNum = statisticService.getSoftFaultNum(stationId);
            int HardFaultNum = statisticService.getHardFaultNum(stationId);
            List<Map<String, Object>> DeviceMapList = statisticService.getDeviceList(stationId);

            List<String> DeviceNameList = new ArrayList<>();
            List<Integer> SoftNumList = new ArrayList<>();
            List<Integer> HardNumList = new ArrayList<>();
            for (int i=0;i<DeviceMapList.size();i++){
                Map<String, Object> deviceMap = DeviceMapList.get(i);
                String deviceId = (String)deviceMap.get("id");
                String deviceNmae = statisticService.getDeviceNameById(deviceId);
                DeviceNameList.add(deviceNmae);
                Integer SoftNum = statisticService.getSoftNumById(deviceId);
                SoftNumList.add(SoftNum);
                Integer HardNum = statisticService.getHardNumById(deviceId);
                HardNumList.add(HardNum);
            }

            List<Integer> ModuleNumList = new ArrayList<>();
            Map<String,Object> parammap = new HashMap<>();
            //此处i表示信号类型值
            for (int i=0;i<12;i++)
            {
                parammap.put("stationId", stationId);
                parammap.put("moduleIndex", i);
                Integer ModuleNum =  statisticService.getModuleNum(parammap);
                ModuleNumList.add(ModuleNum);
            }
            //System.out.print(ModuleNumList);
            List<Integer> PwrModuleMonthList = new ArrayList<>();
            Map<String,Object> HistoryParammap = new HashMap<>();
            String start_time = "";
            String end_time = "";
            //此处j表示月份
            for (int j=1;j<13;j++)
            {
                HistoryParammap.put("stationId", stationId);
                //第一个模块PWR
                HistoryParammap.put("moduleIndex", 3);
                if (j<9)
                {
                    start_time = "2020-0"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-0"+String.valueOf(j+1)+"-01 00:00:00";
                }
                else if (j==9)
                {
                    start_time = "2020-0"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-"+String.valueOf(j+1)+"-01 00:00:00";
                }
                else
                {
                    start_time = "2020-"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-"+String.valueOf(j+1)+"-01 00:00:00";
                }

                HistoryParammap.put("start_time", start_time);
                HistoryParammap.put("end_time", end_time);

                Integer ModuleNum =  statisticService.getModuleHistoryNum(HistoryParammap);
                PwrModuleMonthList.add(ModuleNum);
            }

                jsonObject.put("StationName",StationName);
                jsonObject.put("DeviceNum",DeviceNum);
                jsonObject.put("OnlineDeviceNum",OnlineDeviceNum);
                jsonObject.put("FaultNum",FaultNum);
                jsonObject.put("SoftFaultNum",SoftFaultNum);
                jsonObject.put("HardFaultNum",HardFaultNum);
                jsonObject.put("DeviceNameList",DeviceNameList);
                jsonObject.put("SoftNumList",SoftNumList);
                jsonObject.put("HardNumList",HardNumList);
                jsonObject.put("ModuleNumList",ModuleNumList);
                jsonObject.put("PwrModuleMonthList",PwrModuleMonthList);

                jsonObject.put("code", ErrorCodeEnum.E00_0001.getCode());
                jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());

            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", ErrorCodeEnum.E00_0002.getCode());
            jsonObject.put("message", ErrorCodeEnum.E00_0002.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/getModuleHistoryList",method= RequestMethod.POST)
    @ApiOperation("获取模块历史统计信息")
    public JSONObject getModuleHistoryList(@RequestParam Map<String,Object> map){
        log.info("==== 获取模块历史统计信息 ====");
        JSONObject jsonObject = new JSONObject();
        try{
            String stationId = (String) map.get("stationId");
            String moduleId = (String)map.get("moduleType");
            int iModuleId = Integer.parseInt(moduleId);

            //System.out.print(ModuleNumList);
            List<Integer> PwrModuleMonthList = new ArrayList<>();
            Map<String,Object> HistoryParammap = new HashMap<>();
            String start_time = "";
            String end_time = "";
            //此处j表示月份
            for (int j=1;j<13;j++)
            {
                HistoryParammap.put("stationId", stationId);
                //第一个模块PWR
                HistoryParammap.put("moduleIndex", iModuleId);
                if (j<9)
                {
                    start_time = "2020-0"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-0"+String.valueOf(j+1)+"-01 00:00:00";
                }
                else if (j==9)
                {
                    start_time = "2020-0"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-"+String.valueOf(j+1)+"-01 00:00:00";
                }
                else
                {
                    start_time = "2020-"+String.valueOf(j)+"-01 00:00:00";
                    end_time = "2020-"+String.valueOf(j+1)+"-01 00:00:00";
                }

                HistoryParammap.put("start_time", start_time);
                HistoryParammap.put("end_time", end_time);

                Integer ModuleNum =  statisticService.getModuleHistoryNum(HistoryParammap);
                PwrModuleMonthList.add(ModuleNum);
            }

            jsonObject.put("PwrModuleMonthList",PwrModuleMonthList);

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