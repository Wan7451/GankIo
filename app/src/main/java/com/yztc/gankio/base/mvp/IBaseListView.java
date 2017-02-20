package com.yztc.gankio.base.mvp;

/**
 * Created by wanggang on 2017/2/13.
 */

public interface IBaseListView {

    void showLoading();

    void showContent();

    void showError(String msg);


}
