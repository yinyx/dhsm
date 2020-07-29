package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/27
 */
public interface HistoryService {

   HashMap<String,Object> getHistorySignalList(String deviceId,String signalId);

}
