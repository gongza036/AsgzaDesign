package com.app.gongza.asgzdesign.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.base.BasePagerFragment;
import com.app.gongza.libs.view.scrollablelayout.ScrollableLayout;
import com.app.gongza.libs.view.tabstrip.PagerSlidingTabStrip;
import com.nineoldandroids.view.ViewHelper;


public class HomeFragment extends BasePagerFragment implements View.OnClickListener {
    private ScrollableLayout layout_main;
    private ImageView iv_head;
    private RelativeLayout layout_head;

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
        ViewPager viewpager_home = (ViewPager) view.findViewById(R.id.viewpager_home);
        iv_head = (ImageView) view.findViewById(R.id.iv_head);
        layout_head = (RelativeLayout) view.findViewById(R.id.layout_head);
        // ScrollableLayout
        layout_main = (ScrollableLayout) view.findViewById(R.id.layout_main);
        layout_main.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                ViewHelper.setTranslationY(layout_head, (float) (currentY * 0.5));
            }
        });
        // 扩展点击头部滑动范围
//        int headHeight = getResources().getDimensionPixelSize(R.dimen.head_height);
//        int tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
//        mScrollLayout.setClickHeadExpand(headHeight + tabHeight);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tab_home);
        initFragmentPager(viewpager_home, pagerSlidingTabStrip, layout_main);
    }
    
    private void initData() {
//        String url = "http://news-at.zhihu.com/api/4/news/latest";
//        OkHttpUtils
//                .get()
//                .url(url)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Toast.makeText(getActivity(),"Error=="+e.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
////                        Toast.makeText(getActivity(),""+response,Toast.LENGTH_SHORT).show();
//                        L.json(response);
//                    }
//                });
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
