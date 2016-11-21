package com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.base;/**
 * Created by cpoopc on 2015/9/15.
 */

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.adapter.MyFragmentPagerAdapter;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.ListFragment;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.RecyclerViewFragment;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.ScrollViewFragment;
import com.app.gongza.asgzdesign.activities.demo.scrollablelayout.fragment.WebViewFragment;
import com.app.gongza.libs.base.BaseFragment;
import com.app.gongza.libs.view.scrollablelayout.ScrollableLayout;
import com.app.gongza.libs.view.tabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cpoopc
 * Date: 2015-09-15
 * Time: 10:31
 * Ver.: 0.1
 */
public abstract class BasePagerFragment extends BaseFragment {
    private List<String> titleList;
    private MyFragmentPagerAdapter titleAdapter ;

    public void initFragmentPager(ViewPager viewPager, PagerSlidingTabStrip pagerSlidingTabStrip, final ScrollableLayout mScrollLayout) {
        final ArrayList<ScrollAbleFragment> fragmentList = new ArrayList<>();
        fragmentList.add(ListFragment.newInstance());
        fragmentList.add(ScrollViewFragment.newInstance());
        fragmentList.add(RecyclerViewFragment.newInstance());
        fragmentList.add(WebViewFragment.newInstance());

        titleList = new ArrayList<>();
        titleList.add("news");
        titleList.add("ListView");
        titleList.add("ScrollView");
        titleList.add("RecyclerView");
        titleList.add("WebView");
        titleAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
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

}
