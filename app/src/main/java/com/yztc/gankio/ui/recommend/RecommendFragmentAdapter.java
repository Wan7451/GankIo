package com.yztc.gankio.ui.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wanggang on 2017/1/20.
 */

//FragmentStatePagerAdapter    remove(fragment)   add(container.getId(), fragment);
//Fragment特别多    推荐 FragmentStatePagerAdapter

//FragmentPagerAdapter         detach(fragment)   attach(fragment);
//Fragment 少   推荐 FragmentPagerAdapter

public class RecommendFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public RecommendFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public RecommendFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }
}
