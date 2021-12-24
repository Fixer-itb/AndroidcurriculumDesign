package com.example.curriculumdesign.adapter;

import android.content.Context;
import android.util.Log;
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
import com.squareup.picasso.Picasso;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ClassEntity> datas;

    public ClassAdapter(Context context) {
        this.mContext = context;

    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<ClassEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<ClassEntity> datas) {
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
        //
//        Picasso.with(mContext).load(entity.getURl).into(viewHolder.class_url);
    }

    @Override
    public int getItemCount() {
        if (datas!=null&& datas.size()>0)
        return datas.size();

        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private long id;
        private TextView class_name;
        private TextView class_content;

        public ViewHolder(@NonNull View view) {
            super(view);
            class_name=view.findViewById(R.id.class_name);
            class_content=view.findViewById(R.id.class_content);

        }

        @Override
        public void onClick(View v) {
            Log.d("d", "onClick: ");
        }
    }
}
