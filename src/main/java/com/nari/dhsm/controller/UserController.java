package com.nari.dhsm.controller;

import com.nari.dhsm.Interceptor.LoginInterceptor;
import com.nari.dhsm.entity.ErrorCodeEnum;
import com.nari.dhsm.entity.LoginVo;
import com.nari.dhsm.service.UserService;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.swagger.annotations.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yinyx
 * @version 1.0 2020/6/19
 */

@RestController
@RequestMapping(value="/user")
@Api(value="/user",tags = {"用户接口"},description = "用户接口Api")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ApiOperation("登录校验")
    public JSONObject userAuthCheck(@RequestParam Map<String,Object> userMap,HttpSession session){
        log.info("==== 进行登录校验 ====");
        if(userMap.get("username").toString().length() != 11){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorCodeEnum.E01_1000.getCode());
            jsonObject.put("message",ErrorCodeEnum.E01_1000.getMessage());
            return jsonObject;
        }
        if(userService.loginVoCheck(userMap)){
            JSONObject jsonObject = new JSONObject();
            session.setAttribute("userMap", userMap);
            jsonObject.put("code",ErrorCodeEnum.E00_0001.getCode());
            jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
            jsonObject.put("data",userMap);
            return jsonObject;
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",ErrorCodeEnum.E01_1001.getCode());
            jsonObject.put("message",ErrorCodeEnum.E01_1001.getMessage());
            return jsonObject;
        }
    }

    @RequestMapping(value="/logout",method= RequestMethod.POST)
    @ApiOperation("注销")
    public JSONObject loginOut(HttpSession session){
        log.info("==== 注销登录 ====");
        session.removeAttribute("userMap");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",ErrorCodeEnum.E00_0001.getCode());
        jsonObject.put("message",ErrorCodeEnum.E00_0001.getMessage());
        return jsonObject;
    }
}
