package com.app.gongza.asgzdesign.fragments.action;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.libs.base.BaseAcitivity;
import com.app.gongza.libs.tools.okhttp.okhttputils.OkHttpUtils;
import com.app.gongza.libs.tools.okhttp.okhttputils.callback.StringCallback;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;

/**
 * Created by gongza on 2016/12/5.
 */

public class NewsInfoActivity extends BaseAcitivity {
    private WebView wv_news;
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        init();
        initData();
    }


    private void init() {
        wv_news = (WebView) findViewById(R.id.wv_news);
        int newId = getIntent().getIntExtra("newId", 0);
        url = "http://news-at.zhihu.com/api/4/news/" + newId;
    }

    private void showNews(String html) {
        wv_news.getSettings().setJavaScriptEnabled(true);
        wv_news.getSettings().setDomStorageEnabled(true);
        wv_news.getSettings().setAllowContentAccess(true);
        wv_news.getSettings().setAppCacheEnabled(true);
        wv_news.getSettings().setDisplayZoomControls(true);
        wv_news.setWebChromeClient(new WebChromeClient());
        wv_news.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//适应屏幕，内容将自动缩放
        wv_news.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        wv_news.loadUrl(url);

        //设置img标签的css样式
        String imgStyle = "<style> img{ max-width:100%; height:auto;} </style>";

        if (TextUtils.isEmpty(html)) {
            html = "";
        } else {
            html = replaceImgStyle(html);
        }
        html = imgStyle + html;//html.replaceAll("<img","<img width=" + "\'" + width + "\'");

        wv_news.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
    }

    private void initData() {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(NewsInfoActivity.this, "Error==" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        String html = "";
                        try {
                            JSONObject mJsonObject = new JSONObject(response);
                            html = mJsonObject.getString("body");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        showNews(html);
                    }
                });
    }

    /**
     * 使用正则表达式 把html标签中的style属性全部替换成""
     */
    private String replaceImgStyle(String html) {
        String reg = "style=\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(html);
        return matcher.replaceAll("");
    }
}
