package com.yztc.gankio.ui.recommend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yztc.gankio.R;
import com.yztc.gankio.ui.recommend.mvp.RecommendConstraint;
import com.yztc.gankio.ui.recommend.mvp.RecommendPresenterImpl;
import com.yztc.gankio.widget.StatusViewLayout;

import java.util.ArrayList;
import java.util.Collection;


public class RecommendItemFragment extends Fragment implements RecommendConstraint.RecommendView {

    private RecyclerView recyclerView;
    private ArrayList<ItemType> data = new ArrayList<>();
    private RecommmandAdapter adapter;
    private StatusViewLayout statusView;

    public RecommendItemFragment() {
    }


    public static RecommendItemFragment getInstance(String title, String data) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("date", data);
        RecommendItemFragment fragment = new RecommendItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        final String title = args.getString("title");
        //2017-01-16T14:12:00.424Z
        String date = args.getString("date");

        statusView = (StatusViewLayout) view.findViewById(R.id.statusView);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        adapter = new RecommmandAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecommendConstraint.RecommendPresenter presenter = new
                RecommendPresenterImpl(this);
        presenter.loadContent(date, title);
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
    public void fillData(Object reeult) {
        data.addAll((Collection<? extends ItemType>) reeult);
        adapter.notifyDataSetChanged();
    }
}
