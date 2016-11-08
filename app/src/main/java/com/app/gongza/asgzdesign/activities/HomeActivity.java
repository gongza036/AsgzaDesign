package com.app.gongza.asgzdesign.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
    private LinearLayout layout_main;
    private Button bt_home, bt_demo, bt_other, bt_user;

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
        layout_main = (LinearLayout) findViewById(R.id.layout_main);
        bt_home = (Button) findViewById(R.id.bt_home);
        bt_demo = (Button) findViewById(R.id.bt_demo);
        bt_other = (Button) findViewById(R.id.bt_other);
        bt_user = (Button) findViewById(R.id.bt_user);
        bt_home.setOnClickListener(this);
        bt_demo.setOnClickListener(this);
        bt_other.setOnClickListener(this);
        bt_user.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_home:
                setTabSelection(0);
                break;
            case R.id.bt_demo:
                setTabSelection(1);
                break;
            case R.id.bt_other:
                setTabSelection(2);
                break;
            case R.id.bt_user:
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
                bt_home.setTextColor(0xff7f7fbf);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.layout_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                bt_demo.setTextColor(0xff7f7fbf);
                if (demoFragment == null) {
                    demoFragment = new DemoFragment();
                    transaction.add(R.id.layout_main, demoFragment);
                } else {
                    transaction.show(demoFragment);
                }
                break;
            case 2:
                bt_other.setTextColor(0xff7f7fbf);
                if (otherFragment == null) {
                    otherFragment = new OtherFragment();
                    transaction.add(R.id.layout_main, otherFragment);
                } else {
                    transaction.show(otherFragment);
                }
                break;
            case 3:
                bt_user.setTextColor(0xff7f7fbf);
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
        bt_home.setTextColor(0xffffffff);
        bt_demo.setTextColor(0xffffffff);
        bt_other.setTextColor(0xffffffff);
        bt_user.setTextColor(0xffffffff);
    }

}
