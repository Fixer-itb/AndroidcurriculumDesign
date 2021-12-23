package com.example.curriculumdesign.fragment;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.ClassAdapter;
import com.example.curriculumdesign.entity.ClassEntity;

import java.util.ArrayList;
import java.util.List;

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