package com.example.curriculumdesign.fragment;



import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.ClassAdapter;
import com.example.curriculumdesign.adapter.StuSignAdapter;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class SignStuFragment extends BaseFragment {

    private int categoryId;//0为已签到的学生名单
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private String title;
    private TextView tv;
    private List<TblUser> datas = new ArrayList<>();
    private StuSignAdapter adapter ;




    @Override
    protected int initLayout() {
        return R.layout.fragment_sign_stu;
    }

    @Override
    protected void initView() {
        refreshLayout = mRootView.findViewById(R.id.stuRefreshLayout);
        recyclerView=mRootView.findViewById(R.id.recyclerStuView);
        adapter = new StuSignAdapter(getActivity());

    }

    @Override
    protected void initData() {

    }

    public static SignStuFragment newInstance(int categoryId) {
        SignStuFragment fragment = new SignStuFragment();
        fragment.categoryId=categoryId;
        return fragment;
    }
}