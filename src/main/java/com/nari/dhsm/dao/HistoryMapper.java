package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinyx
 * @version 1.0 2020/7/28
 */
@Mapper
@Repository
public interface HistoryMapper {

    List<HashMap<String,Object>> getHistoryList(@Param("deviceId")String deviceId, @Param("signalId")String signalId);

}
