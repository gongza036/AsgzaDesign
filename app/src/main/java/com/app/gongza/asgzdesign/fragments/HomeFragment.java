package com.app.gongza.asgzdesign.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.fragments.action.NewsBasePagerFragment;
import com.app.gongza.asgzdesign.unity.beans.NewsLatestBean;
import com.app.gongza.asgzdesign.unity.beans.NewsThemesBean;
import com.app.gongza.libs.base.BaseApplication;
import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;
import com.app.gongza.libs.tools.okhttp.okhttputils.callback.StringCallback;
import com.app.gongza.libs.view.bannerviewpager.BannerViewPager;
import com.app.gongza.libs.view.bannerviewpager.OnPageClickListener;
import com.app.gongza.libs.view.bannerviewpager.ViewPagerAdapter;
import com.app.gongza.libs.view.scrollablelayout.ScrollableLayout;
import com.app.gongza.libs.view.tabstrip.PagerSlidingTabStrip;
import com.bumptech.glide.Glide;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


public class HomeFragment extends NewsBasePagerFragment implements View.OnClickListener {
    private ScrollableLayout layout_main;
    private ViewPager viewpager_home;
    private BannerViewPager banner;
    private RelativeLayout layout_head;
    private ViewPagerAdapter bannerAdapter;
    private View v_zhanwei;
    private List<ImageView> imgList = new ArrayList<>();
    private int sbHeight;

    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private List<NewsThemesBean.OthersBean> othersList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        BaseApplication app = (BaseApplication) getActivity().getApplication();
        sbHeight = (int) app.getData().get("sbHeight");

        layout_head = (RelativeLayout) view.findViewById(R.id.layout_head);
        //Banner
        viewpager_home = (ViewPager) view.findViewById(R.id.viewpager_home);
        banner = (BannerViewPager) view.findViewById(R.id.banner);
        //获取BannerViewPager实例
        //实例化ViewPagerAdapter，第一个参数是View集合，第二个参数是页面点击监听器
        bannerAdapter = new ViewPagerAdapter(imgList, new OnPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Log.d("banner", "position:" + position);
            }
        });
        //设置适配器
        banner.setAdapter(bannerAdapter);


        // ScrollableLayout
        layout_main = (ScrollableLayout) view.findViewById(R.id.layout_main);
        layout_main.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                ViewHelper.setTranslationY(layout_head, (float) (currentY * 0.5));
                setZheight((int) (currentY * 0.2));
            }
        });
        // 扩展点击头部滑动范围
//        int headHeight = getResources().getDimensionPixelSize(R.dimen.head_height);
//        int tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
//        mScrollLayout.setClickHeadExpand(headHeight + tabHeight);
        pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tab_home);
//        initFragmentPager(viewpager_home, pagerSlidingTabStrip, layout_main);

        v_zhanwei = view.findViewById(R.id.v_zhanwei);
    }

    private void setZheight(int height) {
        if (height > sbHeight) height = sbHeight;
        ViewGroup.LayoutParams lp = v_zhanwei.getLayoutParams();
        lp.height = height;
        v_zhanwei.setLayoutParams(lp);
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
                        for (int i = 0; i < newsLatestBean.getTop_stories().size(); i++) {
                            ImageView iv = new ImageView(getActivity());
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            Glide.with(getActivity()).
                                    load(newsLatestBean.getTop_stories().get(i).getImage()).
                                    asBitmap().//强制处理为bitmap
                                    into(iv);//显示到目标View中
                            imgList.add(iv);
                        }
                        bannerAdapter.notifyDataSetChanged();
                    }
                });

        String themesUrl = "http://news-at.zhihu.com/api/4/themes";
        OkHttpUtils
                .get()
                .url(themesUrl)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "themes Error==" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        NewsThemesBean newsThemesBean = NewsThemesBean.objectFromData(response);
                        othersList.addAll(newsThemesBean.getOthers());

                        HomeFragment.this.setTitleList(othersList);
                        initFragmentPager(viewpager_home, pagerSlidingTabStrip, layout_main);
                    }
                });
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case layout_dian:
//                break;
//            default:
//                break;
//        }
    }


}
