package com.xuliucar.car.ui.fragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.EditSortAdapter;
import com.xuliucar.car.bean.EditSortBean;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditSortFragment extends BaseFragment implements EditSortAdapter.OnUpdateClickListener,
        EditSortAdapter.OnDeleteClickListener,EditSortAdapter.OnSaveClickListener,EditSortAdapter.OnContentClickListener{

    private ListView listView;
    private List<EditSortBean> data=new ArrayList<>();
    private EditSortAdapter adapter;
    private AlertDialog dialog;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.edit_sort),Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c),getString(R.string.add_sort));
        listView=getMView().findViewById(R.id.listView);
        dialog=new AlertDialog.Builder(getMContext()).create();
        initData();
    }

    private void initData() {
        data.add(new EditSortBean("默认分类",false));
        data.add(new EditSortBean("手绘彩稿01版",false));
        data.add(new EditSortBean("微课视频已录好",false));
        data.add(new EditSortBean("语文课张老师的笔迹",false));
        data.add(new EditSortBean("数学课陈老师的笔迹",false));
        data.add(new EditSortBean("英语课高老师的笔迹",false));
        if (adapter==null){
            adapter=new EditSortAdapter(getMContext(),data,this,this,this,this);
            listView.setAdapter(adapter);
        }else adapter.notifyDataSetChanged();
    }

    @Override
    public void onRightClick(){
        View view = LayoutInflater.from(getMContext()).inflate(R.layout.dialog_add_sort, null);
        EditText sortName=view.findViewById(R.id.sortName);
        TextView cancel=view.findViewById(R.id.cancel);
        TextView sure=view.findViewById(R.id.sure);
        cancel.setOnClickListener(v -> {
            //取消
            dialog.dismiss();
        });
        sure.setOnClickListener(v -> {
            //确定
            String content=sortName.getText().toString();
            if (TextUtils.isEmpty(content)){
                Toast.makeText(getMContext(),"请输入分类名",Toast.LENGTH_SHORT).show();
                return;
            }
            data.add(new EditSortBean(content,false));
            adapter.notifyDataSetChanged();
            sortName.getText().clear();
            dialog.dismiss();
        });
        dialog.setView(view);
        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加这句代码
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_edit_sort;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void onUpdate(int position) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setEdit(false);
        }
        data.get(position).setEdit(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDelete(int position) {
        data.remove(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSave(int position) {
        data.get(position).setEdit(false);
        adapter.notifyDataSetChanged();
        hideSoftInput();
    }

    @Override
    public void onContent(int position, String content) {
        data.get(position).setFileName(content);
    }
}
