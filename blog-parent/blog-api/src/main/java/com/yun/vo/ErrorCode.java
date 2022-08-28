package com.yun.vo;

/**
 * @author : ljg
 * @date : 2022/5/21 12:36
 * @description : 错误码
 */
public enum ErrorCode {

    /**
     * 错误码
     */
    PARAMs_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    TOKEN_ILLEGAL(10003,"token不合法"),
    ACCOUNT_EXIST(10004,"账号已经存在"),
    NOT_PERMISSION(70001,"无访问权限"),
    SESSION_TIME_OUT(90001,"会话超时"),
    NOT_LOGIN(90002,"未登录"),;

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
