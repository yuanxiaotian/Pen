package com.cangmaomao.m_penManage.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.cangmaomao.lib.base.BaseFragment;
import com.cangmaomao.m_penManage.R;
import com.cangmaomao.m_penManage.bean.OpenManageInfo;
import com.cangmaomao.m_penManage.literal.Contract;
import com.cangmaomao.m_penManage.view.dialog.DeleConnDialog;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class OftenConnFragment extends BaseFragment {

    private TextView tv_dele;
    private DeleConnDialog dialog;
    private CheckBox iv_manage,iv_set;
    private EditText ed_Name;
    private Button b_commit;
    private OpenManageInfo info;

    @Override
    public void initView(Bundle savedInstanceState) {
        tv_dele = getMView().findViewById(R.id.tv_dele);
        iv_manage = getMView().findViewById(R.id.iv_manage);
        iv_set = getMView().findViewById(R.id.iv_set);
        ed_Name = getMView().findViewById(R.id.ed_Name);
        b_commit = getMView().findViewById(R.id.b_commit);
        dialog = new DeleConnDialog(getMContext());
        initToolBarNav("连接智能笔",getMView().findViewById(R.id.toolbar_c));
        info = (OpenManageInfo) getArguments().getSerializable(Contract.OPENNAME);
        initData();
        initListener();
    }

    private void initData(){
        if (info.isOften()){
            iv_set.setChecked(true);
        }else{
            iv_set.setChecked(false);
        }
        if (info.isSelect()){
            iv_manage.setChecked(true);
        }else{
            iv_manage.setChecked(false);
        }
    }

    //设置监听
    private void initListener(){
        tv_dele.setOnClickListener(v->{
            dialog.showDialog();
        });
        dialog.l_commit.setOnClickListener(v->{
            pop();
        });
        iv_manage.setOnCheckedChangeListener((buttonView,isChecked)->{
            if (isChecked){
                iv_manage.setChecked(true);
            }else{
                iv_manage.setChecked(false);
            }
        });
        iv_set.setOnCheckedChangeListener((buttonView,isChecked)->{
            if (isChecked){
                iv_set.setChecked(true);
            }else {
                iv_set.setChecked(false);
            }
        });
        b_commit.setOnClickListener(v->{
            pop();
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_often_connect;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void onRightClick(){

    }
}
