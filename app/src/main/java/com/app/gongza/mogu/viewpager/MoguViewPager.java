package com.app.gongza.mogu.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.HomeActivity;

import java.util.ArrayList;
import java.util.List;


public class MoguViewPager extends RelativeLayout {

    private MoguViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private TransforView mTransforView;
    private List<View> mViewList = new ArrayList<>();
    private int[] mLayouts = new int[]{R.layout.guide_view_one, R.layout.guide_view_two, R.layout.guide_view_three,
            R.layout.guide_view_four};

    public MoguViewPager(Context context) {
        super(context);
        init();
    }

    public MoguViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void setClick(View view) {
        view.findViewById(R.id.btn_start).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), HomeActivity.class));
//                            v.getContext().finish();
            }
        });
    }

    private void init() {
        inflate(getContext(), R.layout.layout_mogu_viewpager, this);

        mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        mTransforView = (TransforView) this.findViewById(R.id.transfor_view);

        {
            /** 初始化4个页面 */
            for (int i = 0; i < mLayouts.length; i++) {
                View view = View.inflate(getContext(), mLayouts[i], null);
                mViewList.add(view);
                if (i==3){
                    setClick(view);
                }
            }
        }


        mAdapter = new MoguViewPagerAdapter(mViewList, getContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                mTransforView.transfor(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
