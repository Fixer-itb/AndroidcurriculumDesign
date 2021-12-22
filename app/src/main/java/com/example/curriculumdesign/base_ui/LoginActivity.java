package com.example.curriculumdesign.base_ui;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curriculumdesign.activity.BaseActivity;
import com.example.curriculumdesign.R;

public class LoginActivity extends BaseActivity {
    private Button mBtnLogin;//登录按钮
    private Button mBtnRegister;//注册按钮
    private EditText mETUserName;//监听用户名
    private EditText mETPassword;//监听密码


    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //获取输入框内容
        mETUserName = findViewById(R.id.edt_userID);
        mETPassword = findViewById(R.id.edt_password_OK);
        //找到按钮
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
        //设置监听事件
        mETUserName.addTextChangedListener(new TextWatcher() {
            @Override //输入前
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override //输入中
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override //输入后
            public void afterTextChanged(Editable s) {

            }
        });
        mETPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //设置对应的点击事件
        //监听登录按钮
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 上面获取的输入框的文字对比数据库中的数据
                if( true/*登录成功*/) {
                    //登录成功提示
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //TODO 跳转到主界面
                }
            }
        });

        //监听注册按钮
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            }
        });
    }
}
