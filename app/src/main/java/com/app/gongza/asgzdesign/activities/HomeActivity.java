package com.app.gongza.asgzdesign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.demo.DemoAESActivity;
import com.app.gongza.asgzdesign.activities.demo.DemoBlurActivity;
import com.app.gongza.asgzdesign.activities.demo.DemoLitepalActivity;
import com.app.gongza.libs.base.BaseAcitivity;

/**
 * Created by gongza on 2016/11/7.
 */

public class HomeActivity extends BaseAcitivity implements View.OnClickListener {
    private Button bt_aes, bt_blur, bt_litepal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        bt_aes = (Button) findViewById(R.id.bt_aes);
        bt_aes.setOnClickListener(this);
        bt_blur = (Button) findViewById(R.id.bt_blur);
        bt_blur.setOnClickListener(this);
        bt_litepal = (Button) findViewById(R.id.bt_litepal);
        bt_litepal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_aes:
                startActivity(new Intent(HomeActivity.this, DemoAESActivity.class));
                break;
            case R.id.bt_blur:
                startActivity(new Intent(HomeActivity.this, DemoBlurActivity.class));
                break;
            case R.id.bt_litepal:
                startActivity(new Intent(HomeActivity.this, DemoLitepalActivity.class));
                break;
            default:
                break;
        }

    }
}
