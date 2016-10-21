package com.app.gongza.asgzdesign;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.app.gongza.asgzdesign.base.BaseAcitivity;
import com.app.gongza.asgzdesign.tools.logger.L;


public class MainActivity extends BaseAcitivity {
    private TextView tv_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.e("Hello, %s ", "gongza");
        init();
    }

    private void init() {
        tv_first = (TextView) findViewById(R.id.tv_first);
        tv_first.setText("你好MacGit ");
        tv_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar mSnackbar = Snackbar.make(tv_first, "新Snackbar", Snackbar.LENGTH_LONG);
                mSnackbar.show();
                mSnackbar.setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        mSnackbar.dismiss();
                        L.json("{\"name\":\"龚正\",\"age\":24}");
                    }
                });
            }
        });
    }

}
