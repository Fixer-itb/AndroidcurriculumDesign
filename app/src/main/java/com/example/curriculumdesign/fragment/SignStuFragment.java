package com.example.curriculumdesign.fragment;



import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.StuSignAdapter;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class SignStuFragment extends BaseFragment {

    private int categoryId;//0为已签到的学生名单 1为未签到
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
        initRecyclerView();
        getStu();
        adapter.setDatas(datas);
        adapter.notifyDataSetChanged();//刷新数据
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }


    private void getStu(){
        if (categoryId==0){
            for (int i = 0; i < 20; i++) {
                datas.add(new TblUser("李姐姐签到"));
            }
        }
        else{
            for (int i = 0; i < 20; i++) {
                datas.add(new TblUser("李姐姐不签到"));
            }
        }
    }


    public static SignStuFragment newInstance(int categoryId) {
        SignStuFragment fragment = new SignStuFragment();
        fragment.categoryId=categoryId;
        return fragment;
    }


    /**
     * 加载view
     */
    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        refreshLayout.setOnRefreshListener((refreshLayout)->{
            refreshLayout.finishRefresh(1000);//延时多久关闭动画
        });
    }
}