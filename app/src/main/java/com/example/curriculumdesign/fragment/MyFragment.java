package com.example.curriculumdesign.fragment;

import android.content.Intent;

import android.view.View;

import butterknife.OnClick;;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.activity.LoginActivity;


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
                sp.clear(mRootView.getContext());
                removeByKey("Authorization");
                removeByKey("user_info");
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                showToast("退出登录");
        }
    }

}