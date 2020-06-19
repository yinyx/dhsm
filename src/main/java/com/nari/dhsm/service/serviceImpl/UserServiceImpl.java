package com.nari.dhsm.service.serviceImpl;

import com.nari.dhsm.dao.UserMapper;
import com.nari.dhsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yinyx
 * @version 1.0 2020/6/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean loginVoCheck(Map<String, Object> map) {
        return userMapper.loginVoCheck(map);
    }
}
