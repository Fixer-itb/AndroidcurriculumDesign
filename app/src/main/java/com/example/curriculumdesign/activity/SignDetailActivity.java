package com.example.curriculumdesign.activity;


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
    private TextView sign_detail_title;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles={"已签到学生","未签到学生"};
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;




    @Override
    protected int initLayout() {
        return R.layout.activity_sign_detail;
    }

    @Override
    protected void initView() {
        sign = (SignEntity)bundle.getSerializable("sign");
        sign_detail_title=findViewById(R.id.sign_detail_title);
        btnBack=findViewById(R.id.btn_back_class);
        viewPager=findViewById(R.id.SignFixedViewpager);
        slidingTabLayout=findViewById(R.id.slidingSignTabLayout);


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
            mFragments.add(SignStuFragment.newInstance(i));
            i++;
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new StuAdapter(getSupportFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }

}