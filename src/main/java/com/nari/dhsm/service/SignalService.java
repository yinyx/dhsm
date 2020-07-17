package com.nari.dhsm.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/7
 */
public interface SignalService {


    List<HashMap<String,Object>> getBlockSignalList(String deviceId,Integer type);

}
