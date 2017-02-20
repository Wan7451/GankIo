package com.yztc.gankio.base.mvp;

/**
 * Created by wanggang on 2017/2/13.
 */

public interface IBaseListPresenter<T extends IBaseListView> {

    void attachView(T view);

    void detachView();

    void loadData();

    void addData();


}
