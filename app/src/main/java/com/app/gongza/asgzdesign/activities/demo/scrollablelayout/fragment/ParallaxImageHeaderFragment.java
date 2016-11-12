package com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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


public class ParallaxImageHeaderFragment extends BasePagerFragment {

    private ScrollableLayout mScrollLayout;
    private ImageView imageHeader;
    private RelativeLayout rl_head;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_imageheader_scrollablelayout, container, false);
        ViewPager viewPager = (ViewPager) layout.findViewById(R.id.viewpager);
        imageHeader = (ImageView) layout.findViewById(R.id.imageHeader);
        rl_head= (RelativeLayout) layout.findViewById(R.id.rl_head);
        // ScrollableLayout
        mScrollLayout = (ScrollableLayout) layout.findViewById(R.id.scrollableLayout);
        mScrollLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                ViewHelper.setTranslationY(rl_head, (float) (currentY * 0.5));
            }
        });
        // 扩展点击头部滑动范围
//        int headHeight = getResources().getDimensionPixelSize(R.dimen.head_height);
//        int tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
//        mScrollLayout.setClickHeadExpand(headHeight + tabHeight);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) layout.findViewById(R.id.pagerStrip);
        initFragmentPager(viewPager, pagerSlidingTabStrip, mScrollLayout);
        return layout;
    }

}
