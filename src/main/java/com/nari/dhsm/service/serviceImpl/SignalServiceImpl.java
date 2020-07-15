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
    public List<HashMap<String, Object>> querySoftMonitorSignal(String deviceId) {
        List<HashMap<String,Object>> signalList = signalMapper.querySoftMonitorSignal(deviceId);
        List<HashMap<String,Object>> rtnList = new ArrayList<>();
        for (HashMap<String,Object> temp:
             signalList) {
            if(((int) temp.get("valid") == 1) && ((float)temp.get("value") == 0.0)){
                temp.put("value",false);
            }else if(((int) temp.get("valid") == 1) && ((float)temp.get("value") == 1.0)){
                temp.put("value",true);
            }else{
                temp.put("value",null);
            }
            if(temp.get("cDescription")!= null){
                temp.put("description",temp.get("cDescription"));
            }else if(temp.get("mDescription")!=null){
                temp.put("description",temp.get("mDescription"));
            }else if(temp.get("cDescription")!= null && temp.get("mDescription")!=null){
                temp.put("description",null);
            }
            rtnList.add(temp);
        }

        return rtnList;
    }
}
