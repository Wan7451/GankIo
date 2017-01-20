package com.yztc.gankio.ui.recommend.mvp;

import com.yztc.gankio.net.BaseReslut;
import com.yztc.gankio.net.NetResponse;
import com.yztc.gankio.net.NetUtils;
import com.yztc.gankio.ui.recommend.RecommendTabBean;
import com.yztc.gankio.ui.recommend.RecommendTypeBean;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wanggang on 2017/1/20.
 */

public class RecommendRxModelImpl implements RecommendConstraint.RecommendModel {

    @Override
    public void loadTab(int size, final NetResponse response) {
        Observable<BaseReslut<List<RecommendTabBean>>> observable =
                NetUtils.getInstance().getApi().getTabRx(size);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseReslut<List<RecommendTabBean>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (response != null) {
                            response.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(BaseReslut<List<RecommendTabBean>> reslut) {
                        if (!reslut.isError()) {
                            if (response != null) {
                                response.onResponse(reslut.getResults());
                            }
                        } else {
                            if (response != null) {
                                response.onError(reslut.getMsg());
                            }
                        }
                    }
                });


    }


    @Override
    public void loadContent(String date, final NetResponse response) {
        Observable<BaseReslut<RecommendTypeBean>> observable =
                NetUtils.getInstance().getApi().getRecommendRx(date);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseReslut<RecommendTypeBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (response != null) {
                            response.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(BaseReslut<RecommendTypeBean> reslut) {
                        if (!reslut.isError()) {
                            if (response != null) {
                                response.onResponse(reslut.getResults());
                            }
                        } else {
                            if (response != null) {
                                response.onError(reslut.getMsg());
                            }
                        }
                    }
                });
    }
}
