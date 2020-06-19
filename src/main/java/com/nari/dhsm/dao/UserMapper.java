package com.nari.dhsm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    boolean loginVoCheck(Map<String,Object> map);

}
