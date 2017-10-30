package com.app.gongza.asgzdesign;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.app.gongza.libs.base.BaseAcitivity;


public class MainActivity extends BaseAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mogu);

    }

//    private TextView tv_first;
//    private ImageView iv_first;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setFullscreen();
////        setStatusBarHide();
//        init();
//        getImage();
//    }
//
//
//    private void init() {
//        iv_first = (ImageView) findViewById(R.id.iv_first);
//        tv_first = (TextView) findViewById(R.id.tv_first);
//        tv_first.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                showSnackbar("你好MacGit");
//                startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                finish();
//            }
//        });
//    }
//
//    public void getImage() {
////        String url = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
//        String url = "http://news-at.zhihu.com/api/7/prefetch-launch-images/1080*1920";
//        OkHttpUtils
//                .get()
//                .url(url)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        showSnackbar("Error==" + e.getMessage());
//                        Glide.with(MainActivity.this).
//                                load(R.drawable.af3c66f37f9e31d7815f0b196b5865ec).
//                                crossFade(2000).//淡入淡出
//                                into(iv_first);
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        String imgUrl = null;
//                        try {
//                            JSONObject mJsonObject = new JSONObject(response);
//                            JSONArray mCreatives=mJsonObject.getJSONArray("creatives");
//                            JSONObject urlobj= (JSONObject) mCreatives.get(0);
//                            imgUrl = urlobj.getString("url");
////                            imgUrl = mJsonObject.getString("img");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        Glide.with(MainActivity.this).
//                                load(imgUrl).
//                                crossFade(2000).//淡入淡出
//                                into(new GlideDrawableImageViewTarget(iv_first) {
//                            @Override
//                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
//                                super.onResourceReady(resource, animation);
//                                iv_first.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                                        finish();
//                                    }
//                                }, 3000);
//                            }
//                        });
//                    }
//                });
//
//    }
}
