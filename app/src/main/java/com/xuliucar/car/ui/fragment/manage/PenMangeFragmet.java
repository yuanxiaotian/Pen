package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.contract.PenManageContract;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class PenMangeFragmet extends BaseFragment<PenManageContract.ManagePresenter> {

    Toolbar toolbar_subtitle;

    @Override
    public void initView(Bundle savedInstanceState) {

//        loadRootFragment(R.id.fl_manage,OperPenFragment.class);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_pen_manage;
    }


}
