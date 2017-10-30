package com.app.gongza.mogu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.asgzdesign.activities.HomeActivity;
import com.app.gongza.libs.base.BaseAcitivity;

/**
 * Created by gongza on 2017/4/13.
 */

public class MoguActivity extends BaseAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mogu);

    }

}
