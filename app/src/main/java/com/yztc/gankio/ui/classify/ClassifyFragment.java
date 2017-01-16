package com.yztc.gankio.ui.classify;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;

import com.yztc.gankio.R;
import com.yztc.gankio.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 分类Fragment
 */
public class ClassifyFragment extends BaseFragment implements SearchView.OnQueryTextListener {


    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.searchView)
    ImageView mSearchView;

    private ArrayList<ClassifyItemFragment> fragments;

    private String[] titles = {"全部分类", "Android", "iOS", "休息视频", "拓展资源", "前端"};
    private String[] type = {"all", "Android", "iOS", "休息视频", "拓展资源", "前端"};


    public ClassifyFragment() {
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void onInitView(View view, Bundle savedInstanceState) {
        fragments = new ArrayList<>();
        for (int i = 0, len = titles.length; i < len; i++) {
            fragments.add(ClassifyItemFragment.newInstance(type[i]));
        }

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ClassifyFragmentAdapter adapter = new ClassifyFragmentAdapter(getChildFragmentManager(), fragments, titles);
        //预加载界面的个数
        mViewPager.setOffscreenPageLimit(fragments.size());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);


//        //设置该SearchView默认是否自动缩小为图标
//        mSearchView.setIconifiedByDefault(true);
//        //为该SearchView组件设置事件监听器
//        mSearchView.setOnQueryTextListener(this);
//        //设置该SearchView显示搜索按钮
//        mSearchView.setSubmitButtonEnabled(true);
//        //设置该SearchView内默认显示的提示文本
//        mSearchView.setQueryHint("搜索");
    }

    @Override
    protected void onInitData() {

    }

    @Override
    protected void onInitPreData(View view, Bundle savedInstanceState) {
        super.onInitPreData(view, savedInstanceState);
        //===========
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
