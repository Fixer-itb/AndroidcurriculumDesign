package com.example.curriculumdesign.activity;


import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.HomeAdapter;
import com.example.curriculumdesign.adapter.StuAdapter;
import com.example.curriculumdesign.adapter.StuSignAdapter;
import com.example.curriculumdesign.entity.SignEntity;
import com.example.curriculumdesign.fragment.ClassFragment;
import com.example.curriculumdesign.fragment.SignStuFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class SignDetailActivity extends BaseActivity {

    private SignEntity sign;
    private ImageView btnBack;
    private Button stop_btn;
    private TextView sign_detail_title;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles={"已签到学生","未签到学生"};
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;




    @Override
    protected int initLayout() {
        return R.layout.activity_sign_detail;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void initView() {
        sign = (SignEntity)getIntent().getExtras().getSerializable("sign");
        sign_detail_title=findViewById(R.id.sign_detail_title);
        btnBack=findViewById(R.id.btn_back_class);
        viewPager=findViewById(R.id.SignFixedViewpager);
        slidingTabLayout=findViewById(R.id.slidingSignTabLayout);
        stop_btn=findViewById(R.id.stop_btn);
        if (sign.getStatus()==0) {stop_btn.setEnabled(true);
        stop_btn.setBackground(getResources().getDrawable(R.color.Gray_red));
        }
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener((v -> {finish();}));
        sign_detail_title.setText(sign.getSignName());

        initTab();
    }

    /**
     * 初始化导航条
     */
    private void initTab(){
        int i=0;
        for (String title: mTitles) {
            mFragments.add(SignStuFragment.newInstance(i,sign));
            i++;
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new StuAdapter(getSupportFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }

}