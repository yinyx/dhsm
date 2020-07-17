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
                case 2:
                    temp.put("typeName","智能板卡报警闭锁信号");
                    break;
                case 3:
                    temp.put("typeName","B02额外报警信号");
                    break;
                default:
            }
            if(((int) temp.get("valid") == 1) && ((float)temp.get("value") == 0.0)){
                temp.put("value",false);
            }else if(((int) temp.get("valid") == 1) && ((float)temp.get("value") == 1.0)){
                temp.put("value",true);
            }
            rtnList.add(temp);
        }
        return rtnList;
    }
}
