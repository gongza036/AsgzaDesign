package com.app.gongza.asgzdesign.fragments.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.adapters.NewsOthersRecyclerAdapter;
import com.app.gongza.asgzdesign.unity.beans.NewsOthersBean;
import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;
import com.app.gongza.libs.tools.okhttp.okhttputils.callback.StringCallback;
import com.app.gongza.libs.view.scrollablelayout.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by gongza on 2016/12/4.
 */

public class NewsOthersFragment extends NewsScrollAbleFragment implements ScrollableHelper.ScrollableContainer {
    private RecyclerView rv_news;
    private NewsOthersRecyclerAdapter adapter;
    private List<NewsOthersBean.StoriesBean> mList;
    private String json = null;
    private int typeId;

    public NewsOthersFragment() {

    }

    public NewsOthersFragment(int typeId) {
        this.typeId = typeId;
    }

    public static NewsOthersFragment newInstance(int typeId) {
        NewsOthersFragment mNewsOthersFragment = new NewsOthersFragment(typeId);
        return mNewsOthersFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) json = savedInstanceState.getString("json");
        initData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_lastest, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (json != null) {
            NewsOthersBean newsOthersBean = NewsOthersBean.objectFromData(json);
            mList.clear();
            mList.addAll(newsOthersBean.getStories());
            for (int i = 0; i < mList.size(); i++) {
                if (mList.get(i).getImages() == null || mList.get(i).getImages().size() == 0 || TextUtils.isEmpty(mList.get(i).getImages().get(0))) {
                    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                    rv_news.setLayoutManager(manager);
                    adapter.notifyDataSetChanged();
                    return;
                }
            }
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
            rv_news.setLayoutManager(manager);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public View getScrollableView() {

        return rv_news;
    }

    private void initView(View view) {
        //主列表
        mList = new ArrayList<>();
        adapter = new NewsOthersRecyclerAdapter(getActivity(), mList);
        rv_news = (RecyclerView) view.findViewById(R.id.rv_news);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_news.setLayoutManager(manager);
        rv_news.setAdapter(adapter);
    }

    private void initData() {
        if (json != null) {
            NewsOthersBean newsOthersBean = NewsOthersBean.objectFromData(json);
            mList.addAll(newsOthersBean.getStories());
            adapter.notifyDataSetChanged();
            return;
        }
        String url = "http://news-at.zhihu.com/api/4/theme/" + typeId;
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
                        json = response;
                        NewsOthersBean newsOthersBean = NewsOthersBean.objectFromData(response);

                        mList.addAll(newsOthersBean.getStories());

                        for (int i = 0; i < mList.size(); i++) {
                            if (mList.get(i).getImages() == null || mList.get(i).getImages().size() == 0 || TextUtils.isEmpty(mList.get(i).getImages().get(0))) {
                                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                                rv_news.setLayoutManager(manager);
                                adapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
                        rv_news.setLayoutManager(manager);
                        adapter.notifyDataSetChanged();

                    }
                });
    }

}
