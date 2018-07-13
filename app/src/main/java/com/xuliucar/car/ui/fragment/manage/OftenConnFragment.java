package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class OftenConnFragment extends BaseFragment {

    private Toolbar toolbar;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        toolbar = getMView().findViewById(R.id.toolbar);
        initToolBarNav(toolbar,"连接智能笔");

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_often_connect;
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
