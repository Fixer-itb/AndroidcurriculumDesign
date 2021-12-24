package com.example.curriculumdesign.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.curriculumdesign.R;

public class GpsActivity extends BaseActivity {


    @Override
    protected int initLayout() {
        return R.layout.activity_gps;
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        ShowToast(intent.getStringExtra("signid"));
    }

    @Override
    protected void initData() {

    }
}