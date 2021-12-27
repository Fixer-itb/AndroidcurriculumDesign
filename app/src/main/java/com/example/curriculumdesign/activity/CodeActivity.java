package com.example.curriculumdesign.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.utils.QRCodeUtil;

public class CodeActivity extends BaseActivity {

    QRCodeUtil util;
    private ImageView button;
    private ImageView code;
    String classSign;
    private String classId;


    @Override
    protected int initLayout() {
        return R.layout.activity_code;
    }

    @Override
    protected void initView() {
        util = new QRCodeUtil();
        button=findViewById(R.id.btn_back);
        code=findViewById(R.id.img_qr);
        button.setOnClickListener((v -> {
            finish();
        }));
        Intent intent=getIntent();
        String classSign = intent.getStringExtra("signid");
        String classId = intent.getStringExtra("classId");
        ShowToast(intent.getStringExtra("signid"));
    }

    @Override
    protected void initData() {
        if (classSign==null){//加课二维码
            Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("1,"+classId, 250, 250);
            code.setImageBitmap(mBitmap);
        }
    }



}