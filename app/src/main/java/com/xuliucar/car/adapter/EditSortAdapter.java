package com.xuliucar.car.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xuliucar.car.R;
import com.xuliucar.car.bean.EditSortBean;
import com.xuliucar.car.bean.FileListBean;

import java.util.List;

public class EditSortAdapter extends BaseAdapter {

    private Context context;
    private List<EditSortBean> data;
    private OnUpdateClickListener updateClickListener;
    private OnDeleteClickListener onDeleteClickListener;
    private OnSaveClickListener onSaveClickListener;
    private OnContentClickListener onContentClickListener;

    public EditSortAdapter(Context context, List<EditSortBean> data,OnUpdateClickListener updateClickListener,
                           OnDeleteClickListener onDeleteClickListener,OnSaveClickListener onSaveClickListener,
                           OnContentClickListener onContentClickListener) {
        this.context = context;
        this.data = data;
        this.updateClickListener=updateClickListener;
        this.onDeleteClickListener=onDeleteClickListener;
        this.onSaveClickListener=onSaveClickListener;
        this.onContentClickListener=onContentClickListener;
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
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_edit_sort, null);
            holder = new ViewHolder(view);
            holder.mTextWatcher = new TextWatcher1();
            holder.fileName.addTextChangedListener(holder.mTextWatcher);
            holder.updatePosition(position);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
            holder.updatePosition(position);
        }
        holder.fileName.setText(data.get(position).getFileName());
        if (data.get(position).isEdit()){
            holder.fileName.setEnabled(true);
            holder.ll_layout.setVisibility(View.GONE);
            holder.save.setVisibility(View.VISIBLE);
            holder.fileName.setTextColor(context.getResources().getColor(R.color.color_999999));
            holder.fileName.setFocusable(true);
            holder.fileName.setFocusableInTouchMode(true);
            holder.fileName.requestFocus();
            holder.fileName.setSelection(holder.fileName.getText().length());
        }else {
            holder.fileName.setEnabled(false);
            holder.ll_layout.setVisibility(View.VISIBLE);
            holder.save.setVisibility(View.GONE);
            holder.fileName.setTextColor(context.getResources().getColor(R.color.color_333333));
            holder.fileName.setFocusable(false);
            holder.fileName.setFocusableInTouchMode(false);
            holder.fileName.requestFocus();
        }
        holder.update.setOnClickListener(v -> {
            //修改
            updateClickListener.onUpdate(position);
        });
        holder.delete.setOnClickListener(v -> {
            //删除
            onDeleteClickListener.onDelete(position);
        });
        holder.save.setOnClickListener(v -> {
            //保存
            onSaveClickListener.onSave(position);
        });
        return view;
    }

    class TextWatcher1 implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if ("".equals(s.toString())) return;
            onContentClickListener.onContent(position, s.toString());
        }
    }

    class ViewHolder {
        EditText fileName;
        TextView update, delete, save;
        LinearLayout ll_layout;
        TextWatcher1 mTextWatcher;

        public ViewHolder(View view) {
            fileName = view.findViewById(R.id.fileName);
            update = view.findViewById(R.id.update);
            delete = view.findViewById(R.id.delete);
            save = view.findViewById(R.id.save);
            ll_layout = view.findViewById(R.id.ll_layout);
        }
        public void updatePosition(int position) {
            mTextWatcher.updatePosition(position);
        }
    }

    public interface OnUpdateClickListener{
        void onUpdate(int position);
    }

    public interface OnDeleteClickListener{
        void onDelete(int position);
    }

    public interface OnSaveClickListener{
        void onSave(int position);
    }

    public interface OnContentClickListener{
        void onContent(int position,String content);
    }
}
