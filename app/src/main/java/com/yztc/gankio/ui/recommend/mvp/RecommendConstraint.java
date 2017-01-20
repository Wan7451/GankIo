package com.yztc.gankio.ui.recommend.mvp;

import com.yztc.gankio.net.NetResponse;

/**
 * Created by wanggang on 2017/1/20.
 */

public class RecommendConstraint {

    public interface RecommendView {
        void showLoading();

        void showContent();

        void showError(String msg);

        void fillData(Object data);
    }

    public interface RecommendPresenter {
        void loadTab(int size);

        void loadContent(String date, String title);
    }

    public interface RecommendModel {
        void loadTab(int size, NetResponse response);

        void loadContent(String date, NetResponse response);
    }

}
