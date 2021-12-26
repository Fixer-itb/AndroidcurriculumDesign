package com.example.curriculumdesign.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.base_ui.LoginActivity;

public class NewClassActivity extends BaseActivity {
    private ImageView ivBackup;//返回图标
    private EditText edtClassName;//课程名称
    private EditText edtClassContent;//课程内容
    private Button btnCreateClass;//创建课程按钮


    @Override
    protected int initLayout() {
        return R.layout.activity_newclass;
    }

    @Override
    protected void initView() {
        ivBackup = findViewById(R.id.iv_back_up);
        edtClassName = findViewById(R.id.edt_courseName);
        edtClassContent = findViewById(R.id.edt_course_content);
        btnCreateClass = findViewById(R.id.btn_create_course);

    }

    @Override
    protected void initData() {
        ivBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navgateTo(LoginActivity.class);
            }
        });
        //获取课程名称
        edtClassName.addTextChangedListener(new TextWatcher() {
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
        //获取课程内容
        edtClassContent.addTextChangedListener(new TextWatcher() {
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

        btnCreateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navgateTo(LoginActivity.class);
            }
        });


    }
}