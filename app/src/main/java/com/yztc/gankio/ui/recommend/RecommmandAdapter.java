package com.yztc.gankio.ui.recommend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yztc.gankio.R;

import java.util.ArrayList;

/**
 * Created by wanggang on 2017/1/20.
 */

public class RecommmandAdapter extends RecyclerView.Adapter<RecommmandAdapter.RecommendHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemType> data;

    public RecommmandAdapter(Context context, ArrayList<ItemType> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    @Override
    public RecommendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ItemType.TYPE_TITLE:
                View title = inflater.inflate(R.layout.item_recommend_title, parent, false);
                return new TitleHolder(title);
            case ItemType.TYPE_IMAGE:
                View image = inflater.inflate(R.layout.item_recommend_image, parent, false);
                return new ImageHolder(context, image);
            case ItemType.TYPE_SUB_TITLE:
                View subTitle = inflater.inflate(R.layout.item_recommend_subtitle, parent, false);
                return new SubTitleHolder(subTitle);
            case ItemType.TYPE_CONTENT:
                View content = inflater.inflate(R.layout.item_recommend_content, parent, false);
                return new ContentHolder(content);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecommendHolder holder, int position) {
        holder.fill(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    public static class ImageHolder extends RecommendHolder {

        private ImageView imageView;
        private Context context;

        public ImageHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            imageView = (ImageView) itemView.findViewById(R.id.recommend_image);
        }

        @Override
        public void fill(ItemType data) {
            RecommmendBean bean = (RecommmendBean) data.getData();
            String url = bean.getUrl();
            Glide.with(context).load(url).into(imageView);
        }
    }

    public static class ContentHolder extends RecommendHolder {
        private TextView title;

        public ContentHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.recommend_content);
        }

        @Override
        public void fill(ItemType data) {
            RecommmendBean bean = (RecommmendBean) data.getData();
            title.setText(bean.getDesc());
        }
    }

    public static class SubTitleHolder extends RecommendHolder {
        private TextView title;

        public SubTitleHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.recommend_subTitle);
        }

        @Override
        public void fill(ItemType data) {
            title.setText((String) data.getData());
        }
    }

    public static class TitleHolder extends RecommendHolder {
        private TextView title;

        public TitleHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.recommend_title);
        }

        @Override
        public void fill(ItemType data) {
            title.setText((String) data.getData());
        }
    }


    public static abstract class RecommendHolder extends RecyclerView.ViewHolder {
        public RecommendHolder(View itemView) {
            super(itemView);
        }

        public abstract void fill(ItemType data);
    }
}
