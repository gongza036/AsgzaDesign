package com.app.gongza.asgzdesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.demo.DemoBlurActivity;
import com.app.gongza.asgzdesign.activities.demo.DemoEncryptAesActivity;
import com.app.gongza.asgzdesign.activities.demo.DemoLitepalActivity;
import com.app.gongza.libs.base.BaseFragment;

public class DemoFragment extends BaseFragment implements View.OnClickListener {
    private Button bt_aes, bt_blur, bt_litepal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bt_aes = (Button) view.findViewById(R.id.bt_aes);
        bt_aes.setOnClickListener(this);
        bt_blur = (Button) view.findViewById(R.id.bt_blur);
        bt_blur.setOnClickListener(this);
        bt_litepal = (Button) view.findViewById(R.id.bt_litepal);
        bt_litepal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_aes:
                startActivity(new Intent(getActivity(), DemoEncryptAesActivity.class));
                break;
            case R.id.bt_blur:
                startActivity(new Intent(getActivity(), DemoBlurActivity.class));
                break;
            case R.id.bt_litepal:
                startActivity(new Intent(getActivity(), DemoLitepalActivity.class));
                break;
            default:
                break;
        }
    }
}
