package com.app.gongza.asgzdesign.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.fragments.DemoFragment;
import com.app.gongza.asgzdesign.fragments.HomeFragment;
import com.app.gongza.asgzdesign.fragments.OtherFragment;
import com.app.gongza.asgzdesign.fragments.UserFragment;
import com.app.gongza.libs.base.BaseAcitivity;


/**
 * Created by gongza on 2016/11/7.
 */

public class HomeActivity extends BaseAcitivity implements View.OnClickListener {
    private LinearLayout layout_main, layout_home, layout_demo, layout_other, layout_user;
    private TextView tv_home, tv_demo, tv_other, tv_user;
    private ImageView iv_home, iv_demo, iv_other, iv_user;

    private FragmentManager fragmentManager;
    private Fragment homeFragment;
    private Fragment demoFragment;
    private Fragment otherFragment;
    private Fragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
//        setStatusBarHide();
        layout_main = (LinearLayout) findViewById(R.id.layout_main);
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_demo = (LinearLayout) findViewById(R.id.layout_demo);
        layout_other = (LinearLayout) findViewById(R.id.layout_other);
        layout_user = (LinearLayout) findViewById(R.id.layout_user);
        layout_home.setOnClickListener(this);
        layout_demo.setOnClickListener(this);
        layout_other.setOnClickListener(this);
        layout_user.setOnClickListener(this);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_demo = (ImageView) findViewById(R.id.iv_demo);
        iv_other = (ImageView) findViewById(R.id.iv_other);
        iv_user = (ImageView) findViewById(R.id.iv_user);
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_demo = (TextView) findViewById(R.id.tv_demo);
        tv_other = (TextView) findViewById(R.id.tv_other);
        tv_user = (TextView) findViewById(R.id.tv_user);

        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_home:
                setTabSelection(0);
                break;
            case R.id.layout_demo:
                setTabSelection(1);
                break;
            case R.id.layout_other:
                setTabSelection(2);
                break;
            case R.id.layout_user:
                setTabSelection(3);
                break;

            default:
                break;
        }
    }

    private void setTabSelection(int index) {
        resetBtn();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
//                layout_home.setBackgroundResource(R.drawable.bg_app_ripple);
                iv_home.setImageResource(R.drawable.ad_home_icon_on);
                tv_home.setTextColor(0xff2fb3ff);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.layout_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
//                layout_demo.setBackgroundResource(R.drawable.bg_app_ripple);
                iv_demo.setImageResource(R.drawable.ad_demo_icon_on);
                tv_demo.setTextColor(0xff2fb3ff);
                if (demoFragment == null) {
                    demoFragment = new DemoFragment();
                    transaction.add(R.id.layout_main, demoFragment);
                } else {
                    transaction.show(demoFragment);
                }
                break;
            case 2:
//                layout_other.setBackgroundResource(R.drawable.bg_app_ripple);
                iv_other.setImageResource(R.drawable.ad_other_icon_on);
                tv_other.setTextColor(0xff2fb3ff);
                if (otherFragment == null) {
                    otherFragment = new OtherFragment();
                    transaction.add(R.id.layout_main, otherFragment);
                } else {
                    transaction.show(otherFragment);
                }
                break;
            case 3:
//                layout_user.setBackgroundResource(R.drawable.bg_app_ripple);
                iv_user.setImageResource(R.drawable.ad_user_icon_on);
                tv_user.setTextColor(0xff2fb3ff);
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    transaction.add(R.id.layout_main, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;
        }
        transaction.commit();

    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (demoFragment != null) {
            transaction.hide(demoFragment);
        }
        if (otherFragment != null) {
            transaction.hide(otherFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }

    }

    private void resetBtn() {
        iv_home.setImageResource(R.drawable.ad_home_icon);
        iv_demo.setImageResource(R.drawable.ad_demo_icon);
        iv_other.setImageResource(R.drawable.ad_other_icon);
        iv_user.setImageResource(R.drawable.ad_user_icon);

        tv_home.setTextColor(0xff696D71);
        tv_demo.setTextColor(0xff696D71);
        tv_other.setTextColor(0xff696D71);
        tv_user.setTextColor(0xff696D71);
//        layout_user.setBackgroundResource(R.drawable.bg_white_ripple);
    }

}
