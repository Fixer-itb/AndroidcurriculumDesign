package com.example.curriculumdesign.fragment;



import com.example.curriculumdesign.R;


public class MessageFragment extends BaseFragment {

    @Override
    protected int initLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }
}