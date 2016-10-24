package com.app.gongza.asgzdesign.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.libs.base.BaseAcitivity;

/**
 * Created by gongza on 2016/10/22.
 */

public class TestActivity extends BaseAcitivity {
    private TextView tv_metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        showMetrics();

    }

    private void initView() {
        tv_metrics = (TextView) findViewById(R.id.tv_metrics);
    }

    private void showMetrics() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        int densityDpi = displayMetrics.densityDpi;
        float xdpi = displayMetrics.xdpi;
        float ydpi = displayMetrics.ydpi;
        // dpi/160
        float density = displayMetrics.density;
        // 字体缩放比例
        float scaledDensity = displayMetrics.scaledDensity;
        tv_metrics.setText("测试界面\n" + widthPixels + "*" + heightPixels + "\nDpi=" + densityDpi
                + "\nxdpi=" + xdpi + "--ydpi=" + ydpi + "\ndensity=" + density + "\nscaledDensity=" + scaledDensity);
    }
}
