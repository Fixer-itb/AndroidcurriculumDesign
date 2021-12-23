package com.example.curriculumdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curriculumdesign.R;
import com.example.curriculumdesign.entity.ClassEntity;
import com.example.curriculumdesign.fragment.ClassFragment;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ClassEntity> datas;

    public ClassAdapter(Context context, List<ClassEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_class_layout_new, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }






    /**
     * 绑定数据
     * @param holder 当前的holder对象
     * @param position 下标
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        ClassEntity entity = datas.get(position);
        viewHolder.class_name.setText(entity.getClassName());
        viewHolder.class_content.setText(entity.getClassContent());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView class_name;
        private TextView class_content;

        public ViewHolder(@NonNull View view) {
            super(view);
            class_name=view.findViewById(R.id.class_name);
            class_content=view.findViewById(R.id.class_content);

        }

    }
}
