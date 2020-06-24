package com.nari.dhsm.entity;

/**
 * @author yinyx
 * @version 1.0 2020/6/19
 */
public enum ErrorCodeEnum {
    /**
     * 命名约定：E【功能模块码】_【错误码】
     * 按模块设置返回前端详细内容，前端根据描述和错误码进行界面反馈
     */
    E00_0001("00","通用",20000,"成功"),

    E01_1000("01","登录",001000,"密码长度不符"),
    E01_1001("01","登录",001001,"登录校验不通过");


    private String functionCode;
    private String functionDesc;
    /**
     * 由功能模块代码和错误代码组成
     */
    private int code;
    private String message;

    /**
     *
     * @param functionCode 功能模块码
     * @param functionDesc  功能模块描述
     * @param code  错误码
     * @param message   错误描述
     */
    ErrorCodeEnum(String functionCode,String functionDesc,int code,String message){
        this.functionCode = functionCode;
        this.functionDesc = functionDesc;
        this.code = code;
        this.message = message;
    };


    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{" +
                "functionCode='" + functionCode + '\'' +
                ", functionDesc='" + functionDesc + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
