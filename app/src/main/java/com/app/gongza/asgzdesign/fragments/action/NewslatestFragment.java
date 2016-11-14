package com.app.gongza.asgzdesign.fragments.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.base.ScrollAbleFragment;
import com.app.gongza.asgzdesign.adapters.NewslatestRecyclerAdapter;
import com.app.gongza.asgzdesign.unity.beans.NewsLatestBean;
import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;
import com.app.gongza.libs.tools.okhttp.okhttputils.callback.StringCallback;
import com.app.gongza.libs.view.scrollablelayout.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by gongza on 2016/11/13.
 */

public class NewslatestFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer {
    private RecyclerView rv_news;
    private NewslatestRecyclerAdapter adapter;
    private List<NewsLatestBean.StoriesBean> mList;

    public static NewslatestFragment newInstance() {
        NewslatestFragment mNewslatestFragment = new NewslatestFragment();
        return mNewslatestFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_lastest, container, false);
        initView(view);
        return view;
    }

    @Override
    public View getScrollableView() {

        return rv_news;
    }

    private void initView(View view) {
        //主列表
        mList = new ArrayList<>();
        adapter = new NewslatestRecyclerAdapter(getActivity(), mList);
        rv_news = (RecyclerView) view.findViewById(R.id.rv_news);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_news.setLayoutManager(manager);
        rv_news.setAdapter(adapter);
    }

    private void initData() {
        String url = "http://news-at.zhihu.com/api/4/news/latest";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "Error==" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        NewsLatestBean newsLatestBean = NewsLatestBean.objectFromData(response);

                        mList.addAll(newsLatestBean.getStories());
                        adapter.notifyDataSetChanged();
                    }
                });
    }

}
