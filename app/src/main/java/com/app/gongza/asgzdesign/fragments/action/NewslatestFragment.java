package com.app.gongza.asgzdesign.fragments.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.app.gongza.libs.tools.utils.L;
import com.app.gongza.libs.view.scrollablelayout.ScrollableHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by gongza on 2016/11/13.
 */

public class NewslatestFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer {
    private RecyclerView rv_news;
    private List<NewsLatestBean> mList;
    private NewslatestRecyclerAdapter adapter;

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
//        List<String> strlist = new ArrayList<String>();
//        for (int i = 0; i < new Random().nextInt(100) + 31; i++) {
//            strlist.add(String.valueOf(i));
//        }
        mList = new ArrayList<NewsLatestBean>();
        adapter = new NewslatestRecyclerAdapter(getActivity(), mList);
        rv_news = (RecyclerView) view.findViewById(R.id.rv_news);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
//        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_news.setLayoutManager(manager);
        rv_news.setAdapter(adapter);
        return view;
    }

    @Override
    public View getScrollableView() {

        return rv_news;
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
//                        Toast.makeText(getActivity(),""+response,Toast.LENGTH_SHORT).show();
                        L.json(response);
                        List<NewsLatestBean> tList = parseNewsJson(response);
                        mList.addAll(tList);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private List<NewsLatestBean> parseNewsJson(String json) {
        List<NewsLatestBean> mList = null;
        try {
            JSONObject jo = new JSONObject(json);
            JSONArray ja = jo.getJSONArray("stories");
            mList = new ArrayList<>();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject tjo = ja.getJSONObject(i);
                NewsLatestBean bean = new NewsLatestBean();
                bean.setTitle(tjo.getString("title"));
                bean.setImages(paarseImgJsonarray(tjo.getJSONArray("images")));
                mList.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }

    private ArrayList<String> paarseImgJsonarray(JSONArray jImg) throws JSONException {
        ArrayList<String> imgs = new ArrayList<>();
        for (int i = 0; i <jImg.length() ; i++) {
            String img=jImg.getString(i);
            imgs.add(img);
        }
        return imgs;
    }

}
