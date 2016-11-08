package com.app.gongza.asgzdesign.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.libs.base.BaseFragment;


public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
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
