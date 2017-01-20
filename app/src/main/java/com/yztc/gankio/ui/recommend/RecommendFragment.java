package com.yztc.gankio.ui.recommend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yztc.gankio.R;
import com.yztc.gankio.ui.recommend.mvp.RecommendConstraint;
import com.yztc.gankio.ui.recommend.mvp.RecommendPresenterImpl;
import com.yztc.gankio.widget.RotateTransformer;
import com.yztc.gankio.widget.StatusViewLayout;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends Fragment implements RecommendConstraint.RecommendView {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private StatusViewLayout statusView;

    public RecommendFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        statusView = (StatusViewLayout) view.findViewById(R.id.statusView);

        viewPager.setPageTransformer(true, new RotateTransformer());

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
            fragments.add(RecommendItemFragment
                    .getInstance(tabBean.getTitle(), tabBean.getPublishedAt()));
        }
        RecommendFragmentAdapter adapter = new RecommendFragmentAdapter(
                getChildFragmentManager(), fragments);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
