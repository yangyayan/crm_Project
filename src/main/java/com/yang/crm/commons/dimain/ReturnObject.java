package com.yang.crm.commons.dimain;

public class ReturnObject {
    private String code;
    private String message;
    private Object retData;//其他数据

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", retData=" + retData +
                '}';
    }

    public ReturnObject() {
    }

    public ReturnObject(String code, String message, Object retData) {
        this.code = code;
        this.message = message;
        this.retData = retData;
    }
    public ReturnObject(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ReturnObject(String code, Object retData) {
        this.code = code;
        this.retData = retData;
    }
    public ReturnObject(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }
}
