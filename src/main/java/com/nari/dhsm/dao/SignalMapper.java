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

    List<HashMap<String,Object>> querySoftMonitorSignal(String deviceId);

}
