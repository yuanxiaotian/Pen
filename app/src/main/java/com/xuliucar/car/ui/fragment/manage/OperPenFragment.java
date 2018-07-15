package com.xuliucar.car.ui.fragment.manage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.cangmaomao.lib.action.FragmentActionKt;
import com.cangmaomao.lib.base.BaseFragment;
import com.cangmaomao.lib.event.AppEvent;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.OpenPenAdapter;
import com.xuliucar.car.contract.OpenPenContract;
import com.xuliucar.car.view.NoScrollListview;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class OperPenFragment extends BaseFragment<OpenPenContract.Presenter> {


    private NoScrollListview oftenRecycler,nearbyRecycler;
    private OpenPenAdapter openPenAdapter,nearbyAdapter;
    private View addHeaderView;

    public void initView(Bundle savedInstanceState) {
        oftenRecycler = getMView().findViewById(R.id.oftenRecycler);
        nearbyRecycler =getMView().findViewById(R.id.nearbyRecycler);
        openPenAdapter = new OpenPenAdapter(2);
        oftenRecycler.setAdapter(openPenAdapter);
        nearbyAdapter =new OpenPenAdapter(10);
        addHeaderView = LayoutInflater.from(getMContext())
                .inflate(R.layout.header_oper_open_layout,null);
        nearbyRecycler.addHeaderView(addHeaderView);
        nearbyRecycler.setAdapter(nearbyAdapter);
        initListener();
    }

    private void initListener(){
        nearbyAdapter.setCallBack(position -> {
            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_often_conn()));
        });
//        oftenRecycler.setOnItemClickListener((parent,view,position,id)->{
//            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_often_conn()));
//        });
        nearbyAdapter.setCallBack(position -> {
            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_often_conn()));
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_open_pen;
    }

    @Override
    public void onRightClick(){

    }
}
