package com.example.curriculumdesign.fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.ClassAdapter;
import com.example.curriculumdesign.api.Api;
import com.example.curriculumdesign.api.ApiConfig;
import com.example.curriculumdesign.api.CallBack;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.Page;
import com.example.curriculumdesign.entity.ResponseBody;
import com.example.curriculumdesign.entity.pageResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.LongFunction;

import okhttp3.Response;

public class ClassFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private String title;
    private TextView  tv;
    private List<ClassEntity> datas = new ArrayList<>();
    private int pageNum=1;
    private ClassAdapter adapter ;


    @Override
    protected int initLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView() {
//        tv = mRootView.findViewById(R.id.title);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
        recyclerView=mRootView.findViewById(R.id.recyclerView);
        adapter = new ClassAdapter(getActivity());
        initRecyclerView();
//        showToast("触发列表");
        getSelectedClass(true);



        recyclerView.setAdapter(adapter);
//        tv.setText(title);

    }
    @Override
    protected void initData() {

    }

    /**
     * 获取选课列表
     */
    private void getSelectedClass(boolean isRefresh){
        HashMap<String,Object> params = new HashMap<>();
        params.put("pageNum",pageNum);
        params.put("pageSize",ApiConfig.PAGE_SIZE);
        Api.config(ApiConfig.CLASSLIST,params).getRequest(getActivity(), new CallBack() {
            @Override
            public void OnSuccess(String res, Response response) {
                Log.e("onsuccess",res);
                getActivity().runOnUiThread(()->{
                    if (isRefresh){
                        refreshLayout.finishRefresh(true);//关闭下拉刷新
                    }
                    else
                    {
                        refreshLayout.finishLoadMore(true);
                    }
                    Gson gson = new Gson();
                    List<ClassEntity> list = new ArrayList<>();
//                res=res.replaceAll(":", "：").replace("/", "");
                    try {
                        pageResponse body = gson.fromJson(res, pageResponse.class);
                        list= body.getResult().getList();
                        Log.e("list",list.toString());
                    }catch (Exception e){
                        Log.d("error!!!:::",res);
                        for (int i = 0; i <8 ; i++) {
                            list.add(new ClassEntity("深度学习(2021_10_17)","快来选课"));
                        }
                    }
                    if (response!=null &&list.size()>0)
                    {
                        if(isRefresh)
                            datas=list;
                        else
                            datas.addAll(list);

                        adapter.setDatas(datas);
                        adapter.notifyDataSetChanged();//刷新数据
                    }
                    else{
                        if(isRefresh)
                            showToast("暂时加载无数据");
                        else
                            showToast("没有更多数据");
                    }

                });

            }

            @Override
            public void OnFailure(Exception e) {
               if (isRefresh) {
                    refreshLayout.finishRefresh(true);
                } else {
                    refreshLayout.finishLoadMore(true);
                }
            }
        });
    }




    public static ClassFragment newInstance(String title) {
        ClassFragment fragment = new ClassFragment();
        fragment.title=title;
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
//            refreshLayout.finishRefresh(100);//延时多久关闭动画
            pageNum=1;
            getSelectedClass(true);
        });
        refreshLayout.setOnLoadMoreListener((refreshLayout)->{
            pageNum++;
            getSelectedClass(false);
        });
        getSelectedClass(true);
    }



}