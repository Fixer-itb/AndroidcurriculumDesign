package com.example.curriculumdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.entity.TblUser;
import com.example.curriculumdesign.entity.TblUserSign;

import java.io.Serializable;
import java.util.List;

public class StuSignAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<TblUser> datas;
    private StuSignAdapter.OnItemClickListener mOnItemClickListener;

    public StuSignAdapter(Context context) {
        this.mContext = context;
    }


    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }
    public void setOnItemClickListener(StuSignAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public List<TblUser> getDatas() {
        return datas;
    }

    public void setDatas(List<TblUser> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sign_stu, parent, false);
        StuSignAdapter.ViewHolder viewHolder = new StuSignAdapter.ViewHolder(view);
        return viewHolder;
    }


    /**
     * 绑定数据
     * @param holder 当前的holder对象
     * @param position 下标
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StuSignAdapter.ViewHolder viewHolder=(StuSignAdapter.ViewHolder)holder;
        TblUser entity = datas.get(position);
        viewHolder.Stu_name.setText(entity.getUsername());
        viewHolder.entity=entity;
        //
//        Picasso.with(mContext).load(entity.getURl).into(viewHolder.class_url);
    }

    @Override
    public int getItemCount() {
        if (datas!=null&& datas.size()>0)
            return datas.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private long id;
        private TextView Stu_name;
        private TblUser entity;

        public ViewHolder(@NonNull View view) {
            super(view);
            Stu_name=view.findViewById(R.id.class_name);
//            class_content=view.findViewById(R.id.class_content);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(entity);
                }
            });

        }
    }
}
