package org.yjr.serverInfo.entity;

import java.io.Serializable;

public class ResponseServerEntity implements Serializable {
    private Object obj;
    private String msg;
    private boolean flag = true;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
