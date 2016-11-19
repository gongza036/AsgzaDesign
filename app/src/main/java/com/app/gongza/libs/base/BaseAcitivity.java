package com.app.gongza.libs.base;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


public class BaseAcitivity extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    private BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(BaseApplication)getApplication();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 设置系统状态栏不占据空间
     */
    protected void setStatusBarHide() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * 设置系统状态栏颜色
     */
    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setStatusBarColor(color);
        }
    }

    /**
     * 获得系统状态栏高度
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        application.getData().put("sbHeight",result);
        return result;
    }

    /**
     * 设置全屏
     */
    public void setFullscreen() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Snackbar
     */
    protected void showSnackbar(String msg) {
        String tMsg = "新Snackbar";
        if (msg != null) tMsg = msg;
        View rootView = getWindow().getDecorView();
        final Snackbar mSnackbar = Snackbar.make(rootView, tMsg, Snackbar.LENGTH_LONG);
        mSnackbar.getView().setBackgroundColor(0xff7f7fbf);
        mSnackbar.getView().setAlpha(0.5f);
        mSnackbar.show();
        mSnackbar.setAction("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar.dismiss();
//                L.json("{\"name\":\"龚正\",\"age\":24}");
            }
        });
    }

    /**
     * 通过泛型来简化findViewById
     */
    protected final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Could not cast View to concrete class.", ex);
            throw ex;
        }
    }

}
