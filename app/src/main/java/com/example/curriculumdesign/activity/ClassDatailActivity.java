package com.example.curriculumdesign.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.SignAdapter_stu;
import com.example.curriculumdesign.adapter.SignAdapter_tea;
import com.example.curriculumdesign.api.Api;
import com.example.curriculumdesign.api.ApiConfig;
import com.example.curriculumdesign.api.CallBack;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.Gps;
import com.example.curriculumdesign.entity.ResponseBody;
import com.example.curriculumdesign.entity.SignEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.example.curriculumdesign.entity.responseBody.SignResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Response;

public class ClassDatailActivity extends BaseActivity {

    private ClassEntity currentClass;//接受到id
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private ImageView btnBack;
    private TextView class_detail_title;
    private TextView class_detail_content;
    private ImageView btnCode;
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
        refreshLayout=findViewById(R.id.refreshLayoutSign);
        currentClass =(ClassEntity)bundle.get("class");
        sign_btn=findViewById(R.id.sign_now_btn);
        btnCode=findViewById(R.id.classToQrCode);
        btnBack=findViewById(R.id.btn_back_home);
        recyclerView=findViewById(R.id.recyclerSignView);
        class_detail_title=findViewById(R.id.class_detail_title);
        class_detail_content=findViewById(R.id.class_detail_content);
        adapter_stu=new SignAdapter_stu(mContext);
        adapter_tea=new SignAdapter_tea(mContext);
        btnCode.setOnClickListener((v -> {
            Bundle bundle = new Bundle();
            bundle.putString("classId",String.valueOf(currentClass.getId()));
            navigateToWithBundle(CodeActivity.class,bundle);
        }));
    }

    @Override
    protected void initData() {
        //返回
        btnBack.setOnClickListener((v -> {
            finish();
        }));
        if(haveAuth()){
            sign_btn.setVisibility(View.VISIBLE);
            sign_btn.setOnClickListener(v -> {
                Intent intent=new Intent(mContext,SigninActivity.class);
                intent.putExtra("classId",String.valueOf(currentClass.getId()));
                startActivity(intent);
            });
            recyclerView.setAdapter(adapter_tea);
        }
        else {
            recyclerView.setAdapter(adapter_stu);
        }
        class_detail_title.setText(currentClass.getClassName());
        class_detail_content.setText(currentClass.getClassContent());
        initRecyclerView();
        getSignList();


    }


    private void getSignList(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("classId",currentClass.getId());
        Api.config(ApiConfig.SIGNLIST,params).getRequest(mContext, new CallBack() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void OnSuccess(String res, Response response) {
                refreshLayout.finishRefresh(true);//延时多久关闭动画
               runOnUiThread(()->{
                   Gson gson = new Gson();
                   SignResponse body = gson.fromJson(res, SignResponse.class);
//                   System.out.println(body);
                   if (haveAuth()){
                       adapter_tea.setDatas(body.getResult());
                       adapter_tea.setOnItemClickListener((obj)->{
                           SignEntity entity=(SignEntity) obj;
//                           Log.d("1", "OnSuccess: "+entity);
                           Bundle bundle = new Bundle();
                           bundle.putSerializable("sign",obj);
                           navigateToWithBundle(SignDetailActivity.class,bundle);
                       });
                       adapter_tea.notifyDataSetChanged();//刷新数据

                   }
                   else{
                       adapter_stu.setDatas(body.getResult());
                       adapter_stu.notifyDataSetChanged();//刷新数据
                       adapter_stu.setOnItemClickListener((obj,s)->{
                           SignEntity entity=(SignEntity) obj;
                           if (entity.getStatus()==0){
                               ShowToast("签到已结束");
                           }
                           else{
                               if (entity.getSignType()==0){//二维码
                                   navgateTo(QrCodeActivity.class);
                               }
                               else{
                                   Bundle bundle = new Bundle();
                                   bundle.putString("signid",entity.getClassSignId().toString());
                                   navgateTo(GpsActivity.class);
                               }
                           }


                       });

                   }

               });


            }

            @Override
            public void OnFailure(Exception e) {
                refreshLayout.finishRefresh(true);
            }
        });
    }


    /**
     * 加载view
     */
    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        refreshLayout.setOnRefreshListener((refreshLayout)->{
//            refreshLayout.finishRefresh(1000);//延时多久关闭动画
            getSignList();
        });
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