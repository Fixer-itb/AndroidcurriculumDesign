package com.example.curriculumdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.curriculumdesign.base_ui.BannerAdapter;
import com.xuexiang.xui.widget.banner.recycler.BannerLayout;

import com.xuexiang.xui.widget.toast.XToast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BannerLayout.OnBannerItemClickListener {
    private BannerAdapter mAdapter;
    private BannerLayout mBl;

    public String[] urls = new String[]{
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144160323071011277.jpg",
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144158380433341332.jpg",
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144160286644953923.jpg",
            "http://photocdn.sohu.com/tvmobilemvms/20150902/144115156939164801.jpg",
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144159406950245847.jpg",
    };

    public List<Integer> PicList = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      看网络情况，网络情况不好就用 本地的
//        mAdapter = new BannerAdapter(this,urls);
//        PicList.add(R.drawable.pone);
//        PicList.add(R.drawable.ptwo);
//        PicList.add(R.drawable.pthree);
//        PicList.add(R.drawable.pfour);
//        PicList.add(R.drawable.pfive);
        PicList.add(R.drawable.p1);
        PicList.add(R.drawable.p2);
        PicList.add(R.drawable.p3);
        PicList.add(R.drawable.p4);
        PicList.add(R.drawable.p5);
        mBl = findViewById(R.id.main_bl);
        mAdapter = new BannerAdapter(this ,PicList);
        mBl.setAdapter(mAdapter);

        //当轮播到某一项时执行
//        mBl.setOnIndicatorIndexChangedListener(new BannerLayout.OnIndicatorIndexChangedListener() {
//            @Override
//            public void onIndexChanged(int position) {
//                XToast.normal(MainActivity.this,"轮播到了第 "+position+" 个"  ).show();
//            }
//        });
        //设置 item 点击事件
        mAdapter.setOnBannerItemClickListener(this);
    }
    @Override
    public void onItemClick(int position) {
        XToast.normal(MainActivity.this,"点击了第 "+(position+1)+" 个"  ).show();
    }
}