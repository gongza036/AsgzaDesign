package com.app.gongza.libs.base;

import android.app.Application;

import org.litepal.LitePalApplication;

/**
 * Created by gongzheng on 2016/10/21.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
