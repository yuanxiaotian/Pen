package com.xuliucar.car.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xuliucar.car.R;
import com.xuliucar.car.bean.FileListBean;

import java.util.List;

public class FileListAdapter extends BaseAdapter {

    private Context context;
    private List<FileListBean> data;

    public FileListAdapter(Context context, List<FileListBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder=null;
        if (view == null) {
            view=LayoutInflater.from(context).inflate(R.layout.item_file_list, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.fileName.setText(data.get(position).getFileName());
        holder.fileNum.setText(String.valueOf(data.get(position).getFileNum()+"个文件"));
        return view;
    }

    class ViewHolder {
        TextView fileName, fileNum;

        public ViewHolder(View view) {
            fileName = view.findViewById(R.id.fileName);
            fileNum = view.findViewById(R.id.fileNum);
        }
    }
}
