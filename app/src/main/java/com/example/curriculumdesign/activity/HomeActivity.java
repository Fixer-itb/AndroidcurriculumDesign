package com.example.curriculumdesign.activity;



import android.os.Bundle;

import com.example.curriculumdesign.R;

public class HomeActivity extends BaseActivity {
    //导航栏标题
    private String[] mTitles = {"首页", "消息", "我的"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected int initLayout() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}