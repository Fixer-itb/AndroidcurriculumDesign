package com.example.curriculumdesign.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.curriculumdesign.R;


public class MyFragment extends BaseFragment {


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


    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }
}