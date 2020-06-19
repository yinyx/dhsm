package com.nari.dhsm.entity;


import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;


/**
 * @author yinyx
 * @version 1.0 2020/6/19
 */
@Component
public class LoginVo {


    private int id;

    @NotNull
    @Size(min=11,max=11,message = "手机号位数不正确")
    private String iphone;

    @NotNull
    @Size(min = 6,message = "密码不能低于6位")
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "id=" + id +
                ", iphone='" + iphone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
