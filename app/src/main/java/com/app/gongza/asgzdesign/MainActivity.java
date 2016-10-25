package com.app.gongza.asgzdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.gongza.asgzdesign.unity.entities.NewEntity;
import com.app.gongza.libs.base.BaseAcitivity;

import org.litepal.crud.DataSupport;

import java.util.List;


public class MainActivity extends BaseAcitivity {
    private TextView tv_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarHide();
        saveData();
        init();
    }

    private void saveData() {
        NewEntity mNewEntity = new NewEntity();
        mNewEntity.setTitle("科技新闻");
        mNewEntity.setContent("android7.0发布");
        mNewEntity.setCommentCount(1245);
        mNewEntity.save();
        NewEntity mNewEntity2 = new NewEntity();
        mNewEntity2.setTitle("游戏新闻");
        mNewEntity2.setContent("魔兽世界资料片上线");
        mNewEntity2.setCommentCount(325);
        mNewEntity2.save();
    }

    private void showData() {
        List<NewEntity> list = DataSupport.findAll(NewEntity.class);
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i).getTitle() + "," + list.get(i).getContent() + "\n";
        }
        tv_first.setText(str);
    }

    private void init() {
        tv_first = (TextView) findViewById(R.id.tv_first);
        tv_first.setText("你好MacGit");
        tv_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showSnackbar("你好MacGit");
//                startActivity(new Intent(MainActivity.this, TestActivity.class));

                showData();
            }
        });
    }

}
