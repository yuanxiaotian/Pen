package com.xuliucar.car.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xuliucar.car.R;
import com.xuliucar.car.bean.MyCollectBean;

import java.util.List;

public class MyCollectAdapter extends RecyclerView.Adapter<MyCollectAdapter.ViewHolder> {

    private Context context;
    private List<MyCollectBean> data;

    public MyCollectAdapter(Context context, List<MyCollectBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_collect,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (data.get(position).getType()==0){//文本
            Drawable drawable=context.getResources().getDrawable(R.drawable.icon_note_img);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.item_time.setCompoundDrawables(drawable, null, null, null);
            holder.item_img.setVisibility(View.GONE);
            holder.item_video.setVisibility(View.GONE);
        }else if (data.get(position).getType()==1){//图片
            Drawable drawable=context.getResources().getDrawable(R.drawable.icon_paint_img);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.item_time.setCompoundDrawables(drawable, null, null, null);
            holder.item_img.setVisibility(View.VISIBLE);
            holder.item_video.setVisibility(View.GONE);
        }else if (data.get(position).getType()==2){//视频
            Drawable drawable=context.getResources().getDrawable(R.drawable.icon_video_img);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.item_time.setCompoundDrawables(drawable, null, null, null);
            holder.item_img.setVisibility(View.GONE);
            holder.item_video.setVisibility(View.VISIBLE);
        }
        holder.item_content.setText(data.get(position).getContent());
        holder.item_share.setOnClickListener(v -> {
            //分享
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_time,item_content;
        ImageView item_collect,item_share,item_img,item_video_img,item_startVideo;
        FrameLayout item_video;

        public ViewHolder(View itemView) {
            super(itemView);
            item_time=itemView.findViewById(R.id.item_time);
            item_content=itemView.findViewById(R.id.item_content);
            item_collect=itemView.findViewById(R.id.item_collect);
            item_share=itemView.findViewById(R.id.item_share);
            item_img=itemView.findViewById(R.id.item_img);
            item_video_img=itemView.findViewById(R.id.item_video_img);
            item_startVideo=itemView.findViewById(R.id.item_startVideo);
            item_video=itemView.findViewById(R.id.item_video);
        }
    }
}
