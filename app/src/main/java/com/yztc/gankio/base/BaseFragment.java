package com.yztc.gankio.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by wanggang on 2017/1/15.
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    /**
     * 设置Fragment显示的布局
     *
     * @return Fragment显示的布局
     */
    @LayoutRes
    protected abstract int getLayoutResource();

    /**
     * 初始化 UI
     *
     * @param view               RootView
     * @param savedInstanceState 销毁前缓存的数据
     */
    protected abstract void onInitView(View view, Bundle savedInstanceState);

    /**
     * 加载数据
     */
    protected abstract void onInitData();

    /***
     * 用于在初始化Data之前做一些事
     */
    protected void onInitPreData(View view, Bundle savedInstanceState) {
    }

    /**
     * 是否需要使用EventBus
     *
     * @return true 使用  false 默认不使用
     */
    protected boolean isNeedInitEventBus() {
        return false;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNeedInitEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getLayoutResource() != 0) {
            mRootView = inflater.inflate(getLayoutResource(), container, false);
        } else {
            mRootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onInitView(view, savedInstanceState);
        onInitPreData(view, savedInstanceState);

        //在布局加载完成之后，再加载数据
        //自动加载
        mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //在布局加载完成之后，才能执行，不然看不到效果
                onInitData();
                mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isNeedInitEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }


    //在系统内存不足，所有后台程序（优先级为background的进程，
    // 不是指后台运行的进程）都被杀死时，系统会调用OnLowMemory。
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(getContext()).clearMemory();
    }

}
