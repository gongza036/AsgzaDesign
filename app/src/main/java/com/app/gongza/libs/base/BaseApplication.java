package com.app.gongza.libs.base;

import android.app.Application;

import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;

import org.litepal.LitePalApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by gongzheng on 2016/10/21.
 */

public class BaseApplication extends Application {
    private Map<String, Object> mData;

    public Map<String, Object> getData() {
        return mData;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LitePalApplication.initialize(this);
        okHttp();
        mData = new HashMap<String, Object>();
    }

    private void okHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
