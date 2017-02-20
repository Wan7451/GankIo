package com.yztc.gankio.ui.recommend;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yztc.gankio.base.mvp.BaseListFragmentMVP;
import com.yztc.gankio.base.mvp.IBaseListPresenter;
import com.yztc.gankio.base.mvp.IBaseListView;

import java.util.ArrayList;


public class RecommendItemFragmentMVP
        extends BaseListFragmentMVP<RecommendItemFragmentMVP.ListPresenter>
        implements IBaseListView {

    private ArrayList<ItemType> data = new ArrayList<>();


    public RecommendItemFragmentMVP() {
    }


    public static RecommendItemFragmentMVP getInstance(String title, String data) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("date", data);
        RecommendItemFragmentMVP fragment = new RecommendItemFragmentMVP();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void showContent() {
        super.showContent();
    }

    @Override
    public void showError(String msg) {
        super.showError(msg);
    }

//    @Override
//    public void fillData(Object reeult) {
//        data.addAll((Collection<? extends ItemType>) reeult);
//        loadfinish();
//    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new RecommmandAdapter(getContext(), data);
    }

    @Override
    protected boolean enableRefresh() {
        return false;
    }

    @Override
    protected boolean isAddItemDecoration() {
        return false;
    }

    @Override
    protected void loadData() {

        Bundle args = getArguments();
        String title = args.getString("title");
        String date = args.getString("date");

//        RecommendConstraint.RecommendPresenter presenter = new
//                RecommendPresenterImpl(this);
//        presenter.loadContent(date, title);
    }

    @Override
    protected void addData() {

    }

    static class ListPresenter implements IBaseListPresenter {

        @Override
        public void attachView(IBaseListView view) {

        }

        @Override
        public void detachView() {

        }

        @Override
        public void loadData() {

        }

        @Override
        public void addData() {

        }
    }

}
