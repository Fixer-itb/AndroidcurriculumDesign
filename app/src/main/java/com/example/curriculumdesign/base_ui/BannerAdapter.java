package com.example.curriculumdesign.base_ui;

/**
 * 用于轮播的适配器，页面显示在fragment_home.xml
 * */

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.xuexiang.xui.widget.banner.recycler.BannerLayout;
import com.xuexiang.xui.widget.imageview.ImageLoader;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{

//    private String[] urls;
    private List<Integer> list;
    private Context context;
    //轮播条的 item 点击事件
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

/* 可以换成网络资源
    public BannerAdapter(Context context, String[] urls){
        this.urls = urls;
        this.context = context;
    }
 */
    public BannerAdapter(Context context, List<Integer> list){
        this.list = list;
        this.context = context;
    }

    //给 activity 提供设置 item 点击事件的方法
    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener itemClickListener){
        this.onBannerItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_home, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ImageView imageView = holder.imageView;
//        ImageLoader.get().loadImage(imageView, urls[position]);
        ImageLoader.get().loadImage(imageView, list.get(position));

        //由于每个 item 就一张图片，所以我们直接给 item 中的imageView 添加点击事件，即表示
        //banner 中的某一个 item 被点击。
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBannerItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
//    public int getItemCount() {
//        return urls.length;
//    }
    public int getItemCount() {
        return list.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item);
        }
    }
}