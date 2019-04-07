package org.yjr.utils;

public class ReturnResult {
    final static ReturnResult SUCCESS = new ReturnResult("SUCCESS");
    private String code;
    private String msg;
    private Object obj;
    private String status;


    public ReturnResult() {

    }

    public ReturnResult(String status) {
        this.status = status;
        this.code = "1";
        this.msg = "SUCCESS";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
