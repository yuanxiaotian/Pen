package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.view.dialog.DeleConnDialog;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class OftenConnFragment extends BaseFragment {

    private Toolbar toolbar;
    private TextView tv_dele;
    private DeleConnDialog dialog;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        toolbar = getMView().findViewById(R.id.toolbar);
        tv_dele = getMView().findViewById(R.id.tv_dele);
        initToolBarNav(toolbar,"连接智能笔");
        initListener();
        dialog = new DeleConnDialog(getMContext());
    }

    //设置监听
    private void initListener(){
        tv_dele.setOnClickListener(v->{
            dialog.showDialog();
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
