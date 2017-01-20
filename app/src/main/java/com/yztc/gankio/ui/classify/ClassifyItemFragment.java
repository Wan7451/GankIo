package com.yztc.gankio.ui.classify;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yztc.gankio.base.BaseListFragment;
import com.yztc.gankio.ui.classify.mvp.ClassifyConstraint;
import com.yztc.gankio.ui.classify.mvp.ClassifyPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ClassifyItemFragment extends BaseListFragment
        implements ClassifyConstraint.IClassifyView {

    private static final String BUNDLE_KEY = "CLASSIFY";

    private String type;
    private ArrayList<ClassifyBean> mData = new ArrayList<>();


    public ClassifyItemFragment() {
    }

    public static ClassifyItemFragment newInstance(String type) {
        ClassifyItemFragment fragment = new ClassifyItemFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, type);
        fragment.setArguments(args);
        return fragment;
    }

    ClassifyConstraint.IClassifyPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(BUNDLE_KEY);
        }
        presenter = new ClassifyPresenterImpl(getContext(), this, type);
    }


    @Override
    protected RecyclerView.Adapter getAdapter() {
        RequestManager requestManager = Glide.with(this);
        return new ClassifyAdapter(getContext(), mData, requestManager);
    }

    @Override
    protected void loadData() {
        presenter.pull();
    }

    @Override
    protected void addData() {
        presenter.push();
    }


    @Override
    public void onPull(List<ClassifyBean> data) {
        //下拉刷新
        mData.clear();
        mData.addAll(data);
    }

    @Override
    public void onPush(List<ClassifyBean> data) {
        //上拉加载
        mData.addAll(data);
    }

    @Override
    public void loadFinish() {
        loadfinish();
        mStatusView.showContent();
    }

    @Override
    public void loadError(String msg) {
        mStatusView.showEmpty(msg);
    }
}
