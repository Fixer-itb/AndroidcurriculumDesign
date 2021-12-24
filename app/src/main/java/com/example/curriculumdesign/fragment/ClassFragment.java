package com.example.curriculumdesign.fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Response;

public class ClassFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private String title;
    private TextView  tv;
    private List<ClassEntity> datas = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView() {
//        tv = mRootView.findViewById(R.id.title);
        initRecyclerView();
        showToast("触发列表");
//        getSelectedClass();
        for (int i = 0; i <8 ; i++) {
            datas.add(new ClassEntity("深度学习(2021_10_17)","快来选课"));
        }
        ClassAdapter adapter = new ClassAdapter(getActivity(),datas);
        recyclerView.setAdapter(adapter);
//        tv.setText(title);

    }
    @Override
    protected void initData() {

    }

    /**
     * 获取选课列表
     */
    private void getSelectedClass(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("pageNum",1);
        params.put("pageSize",10);
        Api.config(ApiConfig.CLASSLIST,params).getRequest(getActivity(), new CallBack() {
            @Override
            public void OnSuccess(String res, Response response) {
                Gson gson = new Gson();
//                res=res.replaceAll(":", "：").replace("/", "");
                pageResponse body = gson.fromJson(res, pageResponse.class);
                System.out.println(body);
//                Log.e("onSuccess", body.getPage().getList());


//                list = fromToJson(body.getResult().toString(),new TypeToken<List<ClassEntity>>(){}.getType());

//                Page page = gson.fromJson(body.getResult().toString(), Page.class);
//                System.out.println(page.getList());

            }

            @Override
            public void OnFailure(Exception e) {
                getSelectedClass();
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
        recyclerView=mRootView.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }


}