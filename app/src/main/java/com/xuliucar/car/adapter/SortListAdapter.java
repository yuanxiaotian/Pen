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

import com.cangmaomao.lib.utils.GlideImageLoader;
import com.xuliucar.car.R;
import com.xuliucar.car.bean.SortListBean;

import java.util.List;

public class SortListAdapter extends RecyclerView.Adapter<SortListAdapter.ViewHolder> {

    private Context context;
    private List<SortListBean> data;
    private OnShareClickListener onShareClickListener;
    private IsCollectClickListener isCollectClickListener;
    private IsDeleteClickListener isDeleteClickListener;
    private boolean isEdit;//是否编辑

    public SortListAdapter(Context context, List<SortListBean> data, OnShareClickListener onShareClickListener,
                           IsCollectClickListener isCollectClickListener,IsDeleteClickListener isDeleteClickListener) {
        this.context = context;
        this.data = data;
        this.onShareClickListener=onShareClickListener;
        this.isCollectClickListener=isCollectClickListener;
        this.isDeleteClickListener=isDeleteClickListener;
    }

    public void setData(boolean isEdit){
        this.isEdit=isEdit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sort_list,parent,false));
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
        if (data.get(position).isCollect()){
            holder.item_collect.setImageResource(R.drawable.icon_collect_img_normal);
        }else {
            holder.item_collect.setImageResource(R.drawable.icon_collect_img_unnormal);
        }
        if (isEdit){
            holder.item_checked.setVisibility(View.VISIBLE);
            if (data.get(position).isDelete()){
                holder.item_checked.setImageResource(R.drawable.icon_checked_normal);
            }else {
                holder.item_checked.setImageResource(R.drawable.icon_checked_unnormal);
            }
        }else {
            holder.item_checked.setVisibility(View.GONE);
        }
        holder.item_content.setText(data.get(position).getContent());
        holder.item_share.setOnClickListener(v -> {
            //分享
            onShareClickListener.onShare(position);
        });
        holder.item_collect.setOnClickListener(v -> {
            //收藏
            isCollectClickListener.isCollect(position);
        });
        holder.item_checked.setOnClickListener(v -> {
            //是否删除
            isDeleteClickListener.isDelete(position);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_time,item_content;
        ImageView item_collect,item_share,item_img,item_video_img,item_startVideo,item_checked;
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
            item_checked=itemView.findViewById(R.id.item_checked);
        }
    }

    public interface OnShareClickListener{
        void onShare(int position);
    }

    public interface IsCollectClickListener{
        void isCollect(int position);
    }

    public interface IsDeleteClickListener{
        void isDelete(int position);
    }
}
