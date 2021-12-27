package com.example.curriculumdesign.fragment;



import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.MessageAdapter;
import com.example.curriculumdesign.adapter.StuSignAdapter;
import com.example.curriculumdesign.entity.MessageEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends BaseFragment {


    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private List<MessageEntity> datas = new ArrayList<>();
    private MessageAdapter adapter ;

    @Override
    protected int initLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {
        refreshLayout=mRootView.findViewById(R.id.refreshMessageLayout);
        recyclerView=mRootView.findViewById(R.id.recyclerMessageView);
        adapter = new MessageAdapter(getActivity());
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
            for (int i = 0; i < 20; i++) {
                datas.add(new MessageEntity("全局消息","酷酷酷酷酷酷"));
            }
//            adapter.setOnItemClickListener((obj)->{
//                showToast("点击了");
//            });
    }

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
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