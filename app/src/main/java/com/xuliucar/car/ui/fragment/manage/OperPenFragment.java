package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.contract.OpenPenContract;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class OperPenFragment extends BaseFragment<OpenPenContract.OpenPenPresenter> {


    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_open_pen;
    }
}
