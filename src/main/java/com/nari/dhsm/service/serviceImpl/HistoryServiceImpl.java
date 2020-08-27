package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.HistoryMapper;
import com.nari.dhsm.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/27
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;


    @Override
    public HashMap<String, Object> getHistorySignalList(String deviceId, String id){
        List<HashMap<String, Object>> mapList = historyMapper.getHistoryList(deviceId,id);
        List<String> timeList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        for (HashMap<String,Object> dataMap: mapList) {
            SimpleDateFormat formatter = new SimpleDateFormat();
            String createTime = formatter.format(dataMap.get("createTime"));
            timeList.add(createTime);
            valueList.add(dataMap.get("value").toString());
        }
        HashMap<String,Object> rtnMap = new HashMap<>();
        rtnMap.put("timeList",timeList);
        rtnMap.put("valueList",valueList);
        return rtnMap;
    }
}
