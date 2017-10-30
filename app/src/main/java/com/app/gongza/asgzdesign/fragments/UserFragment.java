package com.app.gongza.asgzdesign.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.libs.base.BaseFragment;

public class UserFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container,false);
        return view;
    }
}
