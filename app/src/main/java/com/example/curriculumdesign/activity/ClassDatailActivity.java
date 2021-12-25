package com.example.curriculumdesign.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.SignAdapter_stu;
import com.example.curriculumdesign.adapter.SignAdapter_tea;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.SignEntity;
import com.example.curriculumdesign.entity.TblUser;

import java.util.ArrayList;
import java.util.List;

public class ClassDatailActivity extends BaseActivity {

    private ClassEntity currentClass;//接受到id
    private RecyclerView recyclerView;
    private ImageView btnBack;
    private TextView class_detail_title;
    private TextView class_detail_content;

    private Button sign_btn;

    /**
     * 学生适配器
     */
    private SignAdapter_stu adapter_stu;
    private SignAdapter_tea adapter_tea;


    private List<SignEntity> list = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;



    @Override
    protected int initLayout() {
        return R.layout.activity_class_datail;
    }

    @Override
    protected void initView() {
        currentClass =(ClassEntity)bundle.get("class");
        sign_btn=findViewById(R.id.sign_now_btn);
        btnBack=findViewById(R.id.btn_back_home);
        recyclerView=findViewById(R.id.recyclerSignView);
        class_detail_title=findViewById(R.id.class_detail_title);
        class_detail_content=findViewById(R.id.class_detail_content);
        adapter_stu=new SignAdapter_stu(mContext);
        adapter_tea=new SignAdapter_tea(mContext);
    }

    @Override
    protected void initData() {
        //返回
        btnBack.setOnClickListener((v -> {
            finish();
        }));
        if(haveAuth()){
            sign_btn.setOnClickListener(v -> {
                ShowToast("发起签到");
            });
        }
        class_detail_title.setText(currentClass.getClassName());
        class_detail_content.setText(currentClass.getClassContent());
        initRecyclerView();
        for (int i = 0; i <8 ; i++) {
            list.add(new SignEntity("2021-12-25","2021年12月20日21点12分的签到",0));
        }
        if (haveAuth()){
            adapter_tea.setDatas(list);
            adapter_tea.setOnItemClickListener((obj)->{
                SignEntity entity=(SignEntity) obj;
                Bundle bundle = new Bundle();
                bundle.putSerializable("sign",obj);
                navigateToWithBundle(SignDetailActivity.class,bundle);
            });
            recyclerView.setAdapter(adapter_tea);
        }
        else{
            adapter_stu.setDatas(list);
            adapter_stu.setOnItemClickListener((obj)->{
                SignEntity entity=(SignEntity) obj;
            });
            recyclerView.setAdapter(adapter_stu);
        }
        ShowToast(currentUser.getPassword());
    }

    /**
     * 加载view
     */
    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    public Boolean haveAuth(){
        TblUser user = sp.getUserFromSP(this);
        if (user.getRoleId()==0  || (user.getRoleId()==2&&currentUser.getUserId().equals(currentClass.getCreateId()))){
            return true;
        }
        else
        return false;
    }


}