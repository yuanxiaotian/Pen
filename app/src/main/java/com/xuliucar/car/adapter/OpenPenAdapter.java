package com.xuliucar.car.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xuliucar.car.R;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class OpenPenAdapter extends BaseAdapter {

    private int count;

    public OpenPenAdapter( int count){
        this.count =count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private OpenHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_oper_pen,null);
            holder = new OpenHolder();
            convertView.setTag(holder);
        }else{
            holder = (OpenHolder) convertView.getTag();
        }
        return convertView;
    }

    class OpenHolder{
        TextView tv_open_author;
    }

}
