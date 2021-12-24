package com.example.curriculumdesign.fragment;



import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.HomeAdapter;
import com.flyco.tablayout.SlidingTabLayout;

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
        CodeBtn.setOnClickListener((View v) -> showToast("点击扫码事件") );
        initTab();
        showToast("触发");

    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    /**
     * 初始化导航条
     */
    private void initTab(){

        for (String title: mTitles) {
            mFragments.add(ClassFragment.newInstance(title));
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new HomeAdapter(getFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }










}