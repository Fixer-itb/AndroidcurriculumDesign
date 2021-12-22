package com.example.curriculumdesign.base_ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curriculumdesign.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText mETUserName;//创建新的用户真实姓名
    private EditText mETNewUserName;//监听新建账号
    private EditText mETPassword;//监听新的密码
    private EditText mETPasswordAck;//监听确认新的密码

    private Button mBtnRegesterCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //获取输入框内容
        mETUserName = findViewById(R.id.edt_name);
        mETNewUserName = findViewById(R.id.edt_ID);
        mETPassword = findViewById(R.id.edt_password);
        mETPasswordAck = findViewById(R.id.edt_new_password);

        //监听按钮事件
        mBtnRegesterCheck = findViewById(R.id.btn_register_check);

        mETUserName.addTextChangedListener(new TextWatcher() {
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
        mETNewUserName.addTextChangedListener(new TextWatcher() {
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
        mETPasswordAck.addTextChangedListener(new TextWatcher() {
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


        /*****************************************
         TODO 根据获取的内容判断注册是否成功，加入数据库
         如果执行成功执行下面的语句，跳转到登录界面进行登录
        ******************************************/
        if(/*注册成功*/) {
            //登录成功提示
            Toast.makeText(RegisterActivity.this, "注册成功，正在跳转到登录界面", Toast.LENGTH_SHORT).show();
            mBtnRegesterCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                }
            });

        }





    }
}
