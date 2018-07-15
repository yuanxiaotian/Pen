package com.cangmaomao.m_penManage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.cangmaomao.lib.action.FragmentActionKt;
import com.cangmaomao.lib.base.BaseFragment;
import com.cangmaomao.lib.event.AppEvent;
import com.cangmaomao.m_penManage.R;
import com.cangmaomao.m_penManage.adapter.NearbyAdapter;
import com.cangmaomao.m_penManage.adapter.OpenPenAdapter;
import com.cangmaomao.m_penManage.bean.OpenManageInfo;
import com.cangmaomao.m_penManage.contract.OperPenContract;
import com.cangmaomao.m_penManage.view.NotScrollListview;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class OperPenFragment extends BaseFragment<OperPenContract.Presenter> {


    private NotScrollListview oftenRecycler,nearbyRecycler;
    private OpenPenAdapter openPenAdapter;
    private NearbyAdapter nearbyAdapter;
    private View addHeaderView;
    private List<OpenManageInfo>openList = new ArrayList<>();
    private List<OpenManageInfo>nearbyList = new ArrayList<>();

    @Override
    public void initView(Bundle savedInstanceState) {
        oftenRecycler = getMView().findViewById(R.id.oftenRecycler);
        nearbyRecycler =getMView().findViewById(R.id.nearbyRecycler);
        initData();
        openPenAdapter = new OpenPenAdapter(openList);
        oftenRecycler.setAdapter(openPenAdapter);
        nearbyAdapter =new NearbyAdapter(nearbyList);
        addHeaderView = LayoutInflater.from(getMContext())
                .inflate(R.layout.header_oper_open_layout,null);
        nearbyRecycler.addHeaderView(addHeaderView);
        nearbyRecycler.setAdapter(nearbyAdapter);
        initListener();
    }

    private void initData(){
        for (int index =1;index<3;index++){
            openList.add(new OpenManageInfo("孙孙的智能笔"+index+"号"));
        }
        for (int index =1;index<11;index++){
            nearbyList.add(new OpenManageInfo("孙孙的智能笔"+index+"号"));
        }
    }

    private void initListener(){
        nearbyAdapter.setCallBack(position -> {
            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_often_conn()));
        });
        nearbyAdapter.setCallBack(position -> {
            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_often_conn()));
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_open_pen;
    }

}
