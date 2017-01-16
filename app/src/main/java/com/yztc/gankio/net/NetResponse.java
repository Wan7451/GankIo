package com.yztc.gankio.net;

/**
 * Created by wanggang on 2017/1/16.
 */

public interface NetResponse {

    void onResponse(Object data);

    void onError(String msg);

}
