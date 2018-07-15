package com.cangmaomao.m_penManage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cangmaomao.m_penManage.R;
import com.cangmaomao.m_penManage.bean.OpenManageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/7/15 0015.
 */

public class NearbyAdapter extends BaseAdapter {

    private List<OpenManageInfo> manageInfos;

    public NearbyAdapter(List<OpenManageInfo> manageInfos) {
        this.manageInfos = manageInfos;
    }

    @Override
    public int getCount() {
        return manageInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return manageInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private OpenHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_oper_pen, null);
            holder = new OpenHolder();
            holder.tv_open_author = convertView.findViewById(R.id.tv_open_author);
            convertView.setTag(holder);
        } else {
            holder = (OpenHolder) convertView.getTag();
        }
        holder.tv_open_author.setText(manageInfos.get(position).getOpenName());
        convertView.setOnClickListener(v -> {
            if (callBack != null)
                callBack.ConnectInfo(position);
        });
        return convertView;
    }

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {
        void ConnectInfo(int position);
    }

    class OpenHolder {
        TextView tv_open_author;
    }
}
