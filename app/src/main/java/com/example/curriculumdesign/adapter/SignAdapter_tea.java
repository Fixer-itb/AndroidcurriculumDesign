package com.example.curriculumdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.entity.SignEntity;

import java.io.Serializable;
import java.util.List;

public class SignAdapter_tea extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<SignEntity> datas;
    private ClassAdapter.OnItemClickListener mOnItemClickListener;


    public SignAdapter_tea(Context context) {
        mContext=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_class_detail_for_stu, parent, false);
        SignAdapter_tea.ViewHolder viewHolder = new SignAdapter_tea.ViewHolder(view);
        return viewHolder;
    }

    public List<SignEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<SignEntity> datas) {
        this.datas = datas;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SignAdapter_tea.ViewHolder viewHolder=(SignAdapter_tea.ViewHolder)holder;
        SignEntity entity = datas.get(position);
        viewHolder.sign_name.setText(entity.getSignName());
        viewHolder.sign_createTime.setText(entity.getGmtCreated());
        viewHolder.signEntity=entity;
    }

    @Override
    public int getItemCount() {
        if (datas!=null&& datas.size()>0)
            return datas.size();
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private long id;
        private TextView sign_name;
        private TextView sign_createTime;
        private SignEntity signEntity;

        public ViewHolder(@NonNull View view) {
            super(view);
            sign_name=view.findViewById(R.id.sign_stu_name);
            sign_createTime=view.findViewById(R.id.sign_stu_create_time);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(signEntity);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }
    public void setOnItemClickListener(ClassAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}