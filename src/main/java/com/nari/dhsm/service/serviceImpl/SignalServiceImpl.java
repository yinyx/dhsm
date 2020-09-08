package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.SignalMapper;
import com.nari.dhsm.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/7
 */
@Service
public class SignalServiceImpl implements SignalService {


    @Autowired
    private SignalMapper signalMapper;


    @Override
    public List<HashMap<String, Object>> getBlockSignalList(String deviceId,Integer type){
        List<HashMap<String,Object>> blockList = signalMapper.getBlockSignalList(deviceId,type);
        List<HashMap<String,Object>> rtnList = new ArrayList<>();
        for (HashMap<String,Object> temp: blockList) {
            switch(type){
                case 0:
                    temp.put("typeName","闭锁信号");
                    break;
                case 1:
                    temp.put("typeName","告警信号");
                    break;
                default: break;
            }
            if(((int) temp.get("valid") == 0) ){
                temp.put("value","无效");
            }
            rtnList.add(temp);
        }
        return rtnList;
    }
    @Override
    public List<HashMap<String, Object>> getOtherSignalList(String deviceId,Integer type){
        List<HashMap<String,Object>> blockList = signalMapper.getOtherSignalList(deviceId,type);
        List<HashMap<String,Object>> rtnList = new ArrayList<>();
        for (HashMap<String,Object> temp: blockList) {
            switch(type){
                case 2:
                    temp.put("typeName","智能板卡报警闭锁信号");
                    break;
                default: break;
            }
            if(("mergedno000005".equals(temp.get("signalId")))&&(1.0 == (double)temp.get("value"))){
                temp.put("bjj",0);
                temp.put("bsj",1);
            }
            else if(!("mergedno000005".equals(temp.get("signalId")))&&(1.0 == (double)temp.get("value"))){
                temp.put("bjj",0);
                temp.put("bsj",0);
            }else{
                temp.put("bjj",0);
                temp.put("bsj",0);
            }
            if(((int) temp.get("valid") == 0) ){
                temp.put("value","无效");
            }
            rtnList.add(temp);
        }
        return rtnList;
    }
}
