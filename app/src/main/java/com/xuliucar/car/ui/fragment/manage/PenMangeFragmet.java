package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.contract.PenManageContract;

import java.util.Objects;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class PenMangeFragmet extends BaseFragment<PenManageContract.ManagePresenter> {

    private Toolbar toolbar;
    private CheckBox iv_manage;
    private FrameLayout fl_manage;

    @Override
    public void initView(Bundle savedInstanceState) {
        toolbar = Objects.requireNonNull(getMView())
                .findViewById(R.id.toolbar);
        initToolBarNav(toolbar,"智能笔管理");
        loadRootFragment(R.id.fl_manage, new OperPenFragment());
        iv_manage=  getMView().findViewById(R.id.iv_manage);
        fl_manage = getMView().findViewById(R.id.fl_manage);
        initListener();
    }

    private void initListener(){
        iv_manage.setOnCheckedChangeListener((v,isChecked)->{
            if (isChecked){
                iv_manage.setChecked(true);
                fl_manage.setVisibility(View.VISIBLE);
            }else{
                iv_manage.setChecked(false);
                fl_manage.setVisibility(View.GONE);
            }
        });
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_pen_manage;
    }

    @Override
    public void onRightClick(){

    }


}
