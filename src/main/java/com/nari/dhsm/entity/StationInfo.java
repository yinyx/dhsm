package com.nari.dhsm.entity;

import org.springframework.stereotype.Component;

/**
 * @author yinyx
 * @version 1.0 2020/7/2
 */
@Component
public class StationInfo {

    private String id;

    private String number;

    private String name;

    private String address;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StationInfo{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
