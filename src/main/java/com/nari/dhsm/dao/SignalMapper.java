package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/7
 */
@Mapper
@Repository
public interface SignalMapper {

    List<HashMap<String,Object>> getBlockSignalList(String deviceId,Integer type);

    List<HashMap<String,Object>> getOtherSignalList(String deviceId,Integer type);


    Boolean checkFirstSignal(String deviceId,int type);

    Boolean checkSecSignal(String deviceId ,int type);

    Boolean checkThirdSignal(String deviceId, int type);

    Boolean checkForthSignal(String deviceId, int type);
}
