package com.rvbs.pm.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS("000000","交易成功"),//成功
    CONNECT("200","通讯成功"),//成功
    FAIL("400","交易失败"),//失败
    AUTHORIZEDISNULL("401","签名未上送"),//签名未上送（签名错误）
    UNAUTHORIZED("402","签名认证错误"),//未认证（签名错误）
    NOT_FOUND("404","接口不存在，请联系技术人员确认"),//接口不存在
    INTERNAL_SERVER_ERROR("500","服务器内部服务错误");//服务器内部错误

    private final String code;
    private final String msg;

    ResultCode(String code,String msg) {
    	this.msg = msg;
        this.code = code;
    }

    public String code() {
        return code;
    }
    
    public String msg() {
    	return msg;
    }
}
