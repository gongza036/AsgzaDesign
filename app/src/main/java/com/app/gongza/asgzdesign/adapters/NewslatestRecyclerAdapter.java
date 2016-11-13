package com.app.gongza.asgzdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.unity.beans.NewsLatestBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by gongza on 2016/11/13.
 */

public class NewslatestRecyclerAdapter extends RecyclerView.Adapter<NewslatestRecyclerAdapter.NewsViewHolder> {
    private Context mContext;
    private List<NewsLatestBean> mList;

    public NewslatestRecyclerAdapter(Context mContext, List<NewsLatestBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public NewslatestRecyclerAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_newslatest_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bindData(mContext,mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tv_title;
        ImageView iv_images;
        NewsLatestBean bean;
        int position;

        public NewsViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            iv_images = (ImageView) itemView.findViewById(R.id.iv_images);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "title==" + bean.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindData(Context mContext,NewsLatestBean bean, int position) {
            this.position = position;
            this.bean = bean;
            tv_title.setText(bean.getTitle());
            Glide.with(mContext).
                    load(bean.getImages().get(0)).
                    asBitmap().//强制处理为bitmap
                    into(iv_images);//显示到目标View中
        }
    }
}
