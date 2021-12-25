package com.example.curriculumdesign.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.OnClick;;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.base_ui.LoginActivity;


public class MyFragment extends BaseFragment {


    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }
    @OnClick({R.id.img_header,R.id.btn_logout})
    public void onViewClicked(View view){
        switch(view.getId()){
            case R.id.img_header:
                break;
            case R.id.btn_logout:
                navigateTo(LoginActivity.class);
                showToast("退出登录");
        }
    }

}