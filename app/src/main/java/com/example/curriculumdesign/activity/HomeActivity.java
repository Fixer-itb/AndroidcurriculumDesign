package com.example.curriculumdesign.activity;


import android.content.SharedPreferences;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.adapter.MyPagerAdapter;
import com.example.curriculumdesign.api.Api;
import com.example.curriculumdesign.api.ApiConfig;
import com.example.curriculumdesign.api.CallBack;
import com.example.curriculumdesign.entity.BaseResponse;
import com.example.curriculumdesign.entity.ResponseBody;
import com.example.curriculumdesign.entity.TabEntity;
import com.example.curriculumdesign.entity.User;
import com.example.curriculumdesign.fragment.HomeFragment;
import com.example.curriculumdesign.fragment.MessageFragment;
import com.example.curriculumdesign.fragment.MyFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.Response;

public class HomeActivity extends BaseActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;
    //导航栏标题
    private String[] mTitles = {"首页", "消息", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect, R.mipmap.collect_unselect,
            R.mipmap.my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.collect_selected,
            R.mipmap.my_selected
    };
    //导航栏 end

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }



    @Override
    protected void initData() {
       initTablaout();
        getUserInfo();

    }

    /**
     * 获取当前数据
     */
    private void getUserInfo(){
        Api.config(ApiConfig.CURRENT, null).getRequest(this, new CallBack() {
            @Override
            public void OnSuccess(String res, Response response) {
//                Log.e("onSuccess", res);
                Gson gson = new Gson();
                ResponseBody body = gson.fromJson(res, ResponseBody.class);
                SaveToSP("user_info",body.getResult().toString().replaceAll(":", "：")
                        .replace("/", ""));

            }
            @Override
            public void OnFailure(Exception e) {
                    getUserInfo();
            }
        });

    }

    /**
     * 初始化导航栏
     */
    private void initTablaout(){
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(MessageFragment.newInstance());
        mFragments.add(MyFragment.newInstance());
        //绑定
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
    }
}