package com.app.gongza.asgzdesign.fragments.action;

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.app.gongza.asgzdesign.unity.beans.NewsThemesBean;
import com.app.gongza.libs.base.BaseFragment;
import com.app.gongza.libs.view.scrollablelayout.ScrollableLayout;
import com.app.gongza.libs.view.tabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public abstract class NewsBasePagerFragment extends BaseFragment {
    private List<String> titleList;
    private NewsFragmentPagerAdapter titleAdapter;

    public void initFragmentPager(ViewPager viewPager, PagerSlidingTabStrip pagerSlidingTabStrip, final ScrollableLayout mScrollLayout) {
        final ArrayList<NewsScrollAbleFragment> fragmentList = new ArrayList<>();
        fragmentList.add(NewslatestFragment.newInstance());
//        fragmentList.add(ListFragment.newInstance());
//        fragmentList.add(ScrollViewFragment.newInstance());
//        fragmentList.add(RecyclerViewFragment.newInstance());
//        fragmentList.add(WebViewFragment.newInstance());

//        titleList = new ArrayList<>();
//        titleList.add("news");
//        titleList.add("ListView");
//        titleList.add("ScrollView");
//        titleList.add("RecyclerView");
//        titleList.add("WebView");
        titleAdapter = new NewsFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(titleAdapter);
        mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(0));
        pagerSlidingTabStrip.setViewPager(viewPager);
        pagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.e("onPageSelected", "page:" + i);
                /** 标注当前页面 **/
                mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setCurrentItem(0);
    }

    public void setTitleList(List<NewsThemesBean.OthersBean> othersList) {
        if (othersList != null) {
            titleList = new ArrayList<>();
            for (NewsThemesBean.OthersBean othersBean : othersList) {
                String name = othersBean.getName();
                Log.i("龚正", "othersBean.getName()==" + name);
                titleList.add(name);
            }
        }
    }
}
