package com.yztc.gankio.event;

/**
 * Created by wanggang on 2017/1/18.
 */

public class Event {

    public static final int CODE_INIT_FINISH = 0;

    private int code;
    private Object data;


    public Event(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
