package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.MyCollectAdapter;
import com.xuliucar.car.bean.MyCollectBean;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyCollectFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<MyCollectBean> data=new ArrayList<>();
    private MyCollectAdapter adapter;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.my_collect),Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c),getString(R.string.clear_collect));
        recyclerView = getMView().findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getMContext());
        recyclerView.setLayoutManager(manager);
        data.add(new MyCollectBean("2018/07/15 20:00","","","语文课笔记",0));
        data.add(new MyCollectBean("2018/07/15 20:00","","","随手绘画，绘于雨过天晴的下午",1));
        data.add(new MyCollectBean("2018/07/15 20:00","","","英语课老师的微课视频",2));
        data.add(new MyCollectBean("2018/07/15 20:00","","","语文课笔记",0));
        data.add(new MyCollectBean("2018/07/15 20:00","","","随手绘画，绘于雨过天晴的下午",1));
        data.add(new MyCollectBean("2018/07/15 20:00","","","英语课老师的微课视频",2));
        data.add(new MyCollectBean("2018/07/15 20:00","","","语文课笔记",0));
        data.add(new MyCollectBean("2018/07/15 20:00","","","随手绘画，绘于雨过天晴的下午",1));
        data.add(new MyCollectBean("2018/07/15 20:00","","","英语课老师的微课视频",2));
        if (adapter==null){
            adapter=new MyCollectAdapter(getMContext(),data);
            recyclerView.setAdapter(adapter);
        }else adapter.notifyDataSetChanged();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_my_collect;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void onRightClick() {
        Toast.makeText(getMContext(), "点击", Toast.LENGTH_LONG).show();
    }
}
