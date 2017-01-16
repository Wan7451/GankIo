package com.yztc.gankio.ui.classify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yztc.gankio.R;
import com.yztc.gankio.base.BaseRecycleAdapter;
import com.yztc.gankio.base.BaseViewHolder;
import com.yztc.gankio.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wanggang on 2016/12/12.
 */

public class ClassifyAdapter extends BaseRecycleAdapter<ClassifyBean> {

    private RequestManager requestManager;

    public static final int TYPE_ICON = 0;
    public static final int TYPE_NO_ICON = 1;


    public ClassifyAdapter(Context context, ArrayList<ClassifyBean> data, RequestManager requestManager) {
        super(context, data);
        this.requestManager = requestManager;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case TYPE_ICON:
                v = inflater.inflate(R.layout.item_classify_icon, parent, false);
                return new ClassifyIconHolder(v, requestManager);
            case TYPE_NO_ICON:
                v = inflater.inflate(R.layout.item_classify, parent, false);
                return new ClassifyHolder(v);
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        List<String> images = data.get(position).getImages();
        if (images != null && images.size() > 0) {
            return TYPE_ICON;
        } else {
            return TYPE_NO_ICON;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ClassifyBean clsBean = data.get(position);
        holder.fillData(clsBean);
    }


    static class ClassifyHolder extends BaseViewHolder<ClassifyBean> {
        @BindView(R.id.classify_title)
        TextView classifyTitle;
        @BindView(R.id.classify_author)
        TextView classifyAuthor;
        @BindView(R.id.classify_time)
        TextView classifyTime;

        ClassifyHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        public void fillData(ClassifyBean clsBean) {
            classifyTitle.setText(clsBean.getDesc());
            classifyAuthor.setText(clsBean.getWho());
            //2017-01-02T04:04:34.34Z
            //2017-01-02 04:04:34
            String date = clsBean.getPublishedAt().replace('T', ' ').replace('Z', ' ');
            classifyTime.setText(DateUtils.friendlyTime(date));
        }
    }

    static class ClassifyIconHolder extends BaseViewHolder<ClassifyBean> {
        @BindView(R.id.classify_icon)
        ImageView classifyIcon;
        @BindView(R.id.classify_title)
        TextView classifyTitle;
        @BindView(R.id.classify_author)
        TextView classifyAuthor;
        @BindView(R.id.classify_time)
        TextView classifyTime;

        private RequestManager requestManager;

        public ClassifyIconHolder(View itemView, RequestManager requestManager) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.requestManager = requestManager;
        }

        @Override
        public void fillData(ClassifyBean clsBean) {
            //唯一标示
            classifyTitle.setText(clsBean.getDesc());
            classifyAuthor.setText(clsBean.getWho());
            String date = clsBean.getPublishedAt().replace('T', ' ').replace('Z', ' ');
            classifyTime.setText(DateUtils.friendlyTime(date));
            String url = clsBean.getImages().get(0);
            requestManager.load(url).centerCrop().into(classifyIcon);

        }
    }
}
