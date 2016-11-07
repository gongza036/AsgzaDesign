package com.app.gongza.asgzdesign.activities.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gongza.asgzdesign.R;
import com.app.gongza.libs.base.BaseAcitivity;
import com.app.gongza.libs.tools.widget.BlurPopWin;

public class DemoBlurActivity extends BaseAcitivity {
    private TextView tv_blur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_blur);
        initView();
    }

    private void initView() {
        tv_blur= (TextView) findViewById(R.id.tv_blur);
        tv_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BlurPopWin.Builder(DemoBlurActivity.this).setContent("该配合你演出的我,眼视而不见,在比一个最爱你的人即兴表演")
                        //Radius越大耗时越长,被图片处理图像越模糊
                        .setRadius(3).setTitle("我是标题")
                        //设置居中还是底部显示
                        .setshowAtLocationType(0)
                        .onClick(new BlurPopWin.PopupCallback() {
                            @Override
                            public void onClick(@NonNull BlurPopWin blurPopWin) {
                                Toast.makeText(DemoBlurActivity.this, "中间被点了", Toast.LENGTH_SHORT).show();
                                blurPopWin.dismiss();
                            }
                        }).show(tv_blur);
            }
        });
    }
}
