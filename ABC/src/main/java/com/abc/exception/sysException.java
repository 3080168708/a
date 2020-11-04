package com.abc.exception;

/**
 * 自定义异常类 做提示信息
 */
public class sysException extends Exception{
    private String mac;

    public sysException(String mac) {
        this.mac = mac;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}
