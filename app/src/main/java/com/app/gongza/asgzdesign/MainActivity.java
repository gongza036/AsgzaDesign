package com.app.gongza.asgzdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.gongza.asgzdesign.activities.HomeActivity;
import com.app.gongza.libs.base.BaseAcitivity;
import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;
import com.app.gongza.libs.tools.okhttp.okhttputils.callback.StringCallback;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;


public class MainActivity extends BaseAcitivity {
    private TextView tv_first;
    private ImageView iv_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFullscreen();
//        setStatusBarHide();
        init();
        getImage();
    }


    private void init() {
        iv_first = (ImageView) findViewById(R.id.iv_first);
        tv_first = (TextView) findViewById(R.id.tv_first);
        tv_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showSnackbar("你好MacGit");
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    public void getImage() {
        String url = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showSnackbar("Error==" + e.getMessage());
                        Glide.with(MainActivity.this).
                                load(R.drawable.af3c66f37f9e31d7815f0b196b5865ec).
                                crossFade(2000).//淡入淡出
                                into(iv_first);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        String imgUrl = null;
                        try {
                            JSONObject mJsonObject = new JSONObject(response);
                            imgUrl = mJsonObject.getString("img");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Glide.with(MainActivity.this).
                                load(imgUrl).
                                crossFade(2000).//淡入淡出
                                into(new GlideDrawableImageViewTarget(iv_first) {
                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                                super.onResourceReady(resource, animation);
                                iv_first.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                        finish();
                                    }
                                }, 3000);
                            }
                        });
                    }
                });

    }
}
