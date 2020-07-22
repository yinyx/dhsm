package com.nari.dhsm.entity;

import org.springframework.stereotype.Component;

/**
 * @author yinyx
 * @version 1.0 2020/7/20
 */
@Component
public class PluginTemplate {

    private String id;
    //插件类型
    private String pluginType;
    //监测名称
    private String monitorItem;
    //值类型
    private int valueType;
    //值单位
    private String valueUnit;
    //最大值
    private String maxValue;
    //最小值
    private String minValue;
    //典型值
    private String typicalValue;
    //报警值
    private float alarmThreshold;
    //非侵入信号为1，其他信号为0
    private int monitorMode;
    //公共信号为1，私有信号为0
    private int belongFlag;
    //默认值
    private float defaultValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPluginType() {
        return pluginType;
    }

    public void setPluginType(String pluginType) {
        this.pluginType = pluginType;
    }

    public String getMonitorItem() {
        return monitorItem;
    }

    public void setMonitorItem(String monitorItem) {
        this.monitorItem = monitorItem;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getTypicalValue() {
        return typicalValue;
    }

    public void setTypicalValue(String typicalValue) {
        this.typicalValue = typicalValue;
    }

    public float getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(float alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
    }

    public int getMonitorMode() {
        return monitorMode;
    }

    public void setMonitorMode(int monitorMode) {
        this.monitorMode = monitorMode;
    }

    public int getBelongFlag() {
        return belongFlag;
    }

    public void setBelongFlag(int belongFlag) {
        this.belongFlag = belongFlag;
    }

    public float getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "PluginTemplate{" +
                "id='" + id + '\'' +
                ", pluginType='" + pluginType + '\'' +
                ", monitorItem='" + monitorItem + '\'' +
                ", valueType=" + valueType +
                ", valueUnit='" + valueUnit + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", minValue='" + minValue + '\'' +
                ", typicalValue='" + typicalValue + '\'' +
                ", alarmThreshold='" + alarmThreshold + '\'' +
                ", monitorMode='" + monitorMode + '\'' +
                ", belongFlag='" + belongFlag + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
