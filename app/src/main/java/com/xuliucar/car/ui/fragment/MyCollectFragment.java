package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MyCollectFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.my_collect),Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c),getString(R.string.clear_collect));
        recyclerView = getMView().findViewById(R.id.recyclerView);
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
