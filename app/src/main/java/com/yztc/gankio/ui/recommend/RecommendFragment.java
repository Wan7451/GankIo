package com.yztc.gankio.ui.recommend;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yztc.gankio.R;
import com.yztc.gankio.base.BaseFragment;
import com.yztc.gankio.ui.recommend.mvp.RecommendConstraint;
import com.yztc.gankio.ui.recommend.mvp.RecommendPresenterImpl;
import com.yztc.gankio.ui.recommend.web.WebFragment;
import com.yztc.gankio.widget.RotateTransformer;
import com.yztc.gankio.widget.StatusViewLayout;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends BaseFragment implements RecommendConstraint.RecommendView {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private StatusViewLayout statusView;

    public RecommendFragment() {
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void onInitView(View view, Bundle savedInstanceState) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        statusView = (StatusViewLayout) view.findViewById(R.id.statusView);

        viewPager.setPageTransformer(true, new RotateTransformer());
    }

    @Override
    protected void onInitData() {
        RecommendConstraint.RecommendPresenter presenter =
                new RecommendPresenterImpl(this);
        presenter.loadTab(5);
    }


    @Override
    public void showLoading() {
        statusView.showLoading();
    }

    @Override
    public void showContent() {
        statusView.showContent();
    }

    @Override
    public void showError(String msg) {
        statusView.showError(msg);
    }

    @Override
    public void fillData(Object data) {
        List<RecommendTabBean> tabBeans = (List<RecommendTabBean>) data;
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < tabBeans.size(); i++) {
            RecommendTabBean tabBean = tabBeans.get(i);
//            fragments.add(RecommendItemFragment
//                    .getInstance(tabBean.getTitle(), tabBean.getPublishedAt()));
            fragments.add(WebFragment.getInstance(tabBean.getTitle(), tabBean.getContent()));
        }
        RecommendFragmentAdapter adapter = new RecommendFragmentAdapter(
                getChildFragmentManager(), fragments);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tabLayout.setupWithViewPager(viewPager);
    }
}
