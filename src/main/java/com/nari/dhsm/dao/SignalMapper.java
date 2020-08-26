package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<HashMap<String,Object>> getBlockSignalList(@Param("deviceId")String deviceId, @Param("type")Integer type);

    List<HashMap<String,Object>> getOtherSignalList(@Param("deviceId")String deviceId, @Param("type")Integer type);


    Boolean checkFirstSignal(@Param("deviceId")String deviceId, @Param("type")int type);

    Boolean checkSecSignal(@Param("deviceId")String deviceId, @Param("type")int type);

    Boolean checkThirdSignal(@Param("deviceId")String deviceId, @Param("type")int type);

    Boolean checkForthSignal(@Param("deviceId")String deviceId, @Param("type")int type);
}
