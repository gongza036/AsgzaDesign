package com.app.gongza.asgzdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.gongza.asgzdesign.activity.TestActivity;
import com.app.gongza.libs.base.BaseAcitivity;


public class MainActivity extends BaseAcitivity {
    private TextView tv_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarHide();
        init();
    }

    private void init() {
        tv_first = (TextView) findViewById(R.id.tv_first);
        tv_first.setText("你好MacGit");
        tv_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showSnackbar("你好MacGit");
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }

}
