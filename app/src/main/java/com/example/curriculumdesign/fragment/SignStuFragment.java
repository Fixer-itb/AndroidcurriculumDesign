package com.example.curriculumdesign.fragment;



import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.activity.ClassDatailActivity;
import com.example.curriculumdesign.adapter.StuSignAdapter;
import com.example.curriculumdesign.api.Api;
import com.example.curriculumdesign.api.ApiConfig;
import com.example.curriculumdesign.api.CallBack;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.SignEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.example.curriculumdesign.entity.responseBody.SignStuResponse;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PrimitiveIterator;

import okhttp3.Response;

public class SignStuFragment extends BaseFragment {

    private int categoryId;//0为已签到的学生名单 1为未签到
    private RecyclerView recyclerView;
    private SignEntity currentSign;
    private RefreshLayout refreshLayout;
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
        adapter = new StuSignAdapter(getActivity(),categoryId,currentSign);
        initRecyclerView();
        recyclerView.setAdapter(adapter);
        getStu();

    }

    @Override
    protected void initData() {

    }

    private void getStu(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("classSignId",currentSign.getClassSignId());
        Gson gson = new Gson();
        if (categoryId==0){
            Api.config(ApiConfig.FINISHSTUDENT,params).getRequest(mRootView.getContext(), new CallBack() {
                @Override
                public void OnSuccess(String res, Response response) {
                    refreshLayout.finishRefresh(true);//延时多久关闭动画
                    getActivity().runOnUiThread(()->{
                    SignStuResponse json = gson.fromJson(res, SignStuResponse.class);
                    List<TblUser> list = json.getResult();
                        if (response!=null &&list.size()>0) {
                            list.remove(0);
                            datas=list;

                        }
                        else showToastSync("暂时加载无数据");

                });
                    adapter.notifyDataSetChanged();//刷新数据
                }

                @Override
                public void OnFailure(Exception e) {
                    showToast("网络超时");
                    refreshLayout.finishRefresh(true);
                }
            });
        }
        else{
            Api.config(ApiConfig.UNFINISHSTUDENT,params).getRequest(mRootView.getContext(), new CallBack() {
                @Override
                public void OnSuccess(String res, Response response) {
                    refreshLayout.finishRefresh(true);//延时多久关闭动画
                    getActivity().runOnUiThread(() -> {
                        SignStuResponse json = gson.fromJson(res, SignStuResponse.class);
                        List<TblUser> list = json.getResult();
                        if (response!=null &&list.size()>0)
                        {
                        datas=json.getResult();

                        }
                        else{
                            showToastSync("暂时加载无数据");
                        }
                        adapter.notifyDataSetChanged();//刷新数据
                    });

                }

                @Override
                public void OnFailure(Exception e) {
                    showToast("网络超时");
                    refreshLayout.finishRefresh(true);
                }
            });

        }
    }


    public static SignStuFragment newInstance(int categoryId,SignEntity currentSign) {
        SignStuFragment fragment = new SignStuFragment();
        fragment.categoryId=categoryId;
        fragment.currentSign=currentSign;
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
            getStu();
        });
    }
}