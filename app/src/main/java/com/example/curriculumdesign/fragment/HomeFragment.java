package com.example.curriculumdesign.fragment;



import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.activity.QrCodeActivity;
import com.example.curriculumdesign.adapter.HomeAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.king.zxing.CaptureActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeFragment extends BaseFragment  {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles={"我选的课","我教的课"};
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;
    private HomeAdapter mAdapter;
    //二维码按钮
    private ImageView CodeBtn;


    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
    CodeBtn=mRootView.findViewById(R.id.codeBtn);
    viewPager=mRootView.findViewById(R.id.fixedViewpager);
    slidingTabLayout=mRootView.findViewById(R.id.slidingTabLayout);
    }

    @Override
    protected void initData() {
        CodeBtn.setOnClickListener((View v) -> navigateTo(QrCodeActivity.class) );
        initTab();


    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    /**
     * 初始化导航条
     */
    private void initTab(){
        int i=0;
        for (String title: mTitles) {
            mFragments.add(ClassFragment.newInstance(i));
            i++;
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new HomeAdapter(getFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }










}