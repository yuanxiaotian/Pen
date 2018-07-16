package com.xuliucar.car.ui.fragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.MyCollectAdapter;
import com.xuliucar.car.bean.MyCollectBean;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyCollectFragment extends BaseFragment implements MyCollectAdapter.OnShareClickListener, MyCollectAdapter.IsCollectClickListener {

    private RecyclerView recyclerView;
    private List<MyCollectBean> data = new ArrayList<>();
    private MyCollectAdapter adapter;
    private AlertDialog clearDialog,shareDialog;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.my_collect), Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c), getString(R.string.clear_collect));
        clearDialog = new AlertDialog.Builder(getMContext()).create();
        shareDialog = new AlertDialog.Builder(getMContext()).create();
        recyclerView = getMView().findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        recyclerView.setLayoutManager(manager);
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "语文课笔记", 0, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "语文课笔记", 0, false));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, false));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "语文课笔记", 0, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true));
        data.add(new MyCollectBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, true));
        if (adapter == null) {
            adapter = new MyCollectAdapter(getMContext(), data, this, this);
            recyclerView.setAdapter(adapter);
        } else adapter.notifyDataSetChanged();
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
        View view = LayoutInflater.from(getMContext()).inflate(R.layout.dialog_collect, null);
        ImageView imageView = view.findViewById(R.id.close);
        TextView textView = view.findViewById(R.id.sure);
        imageView.setOnClickListener(v -> clearDialog.dismiss());
        textView.setOnClickListener(v -> {
            data.clear();
            adapter.notifyDataSetChanged();
            clearDialog.dismiss();
        });
        clearDialog.setView(view);
        clearDialog.show();
        Objects.requireNonNull(clearDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加这句代码
    }

    @Override
    public void onShare(int position) {
        View view = LayoutInflater.from(getMContext()).inflate(R.layout.dialog_collect_share, null);
        ImageView imageView = view.findViewById(R.id.close);
        TextView shareWx = view.findViewById(R.id.shareWx);
        TextView shareQQ = view.findViewById(R.id.shareQQ);
        TextView shareFriend = view.findViewById(R.id.shareFriend);
        imageView.setOnClickListener(v -> shareDialog.dismiss());
        shareWx.setOnClickListener(v -> {
            //微信
            Toast.makeText(getMContext(), "分享至微信", Toast.LENGTH_SHORT).show();
            shareDialog.dismiss();
        });
        shareQQ.setOnClickListener(v -> {
            //qq
            Toast.makeText(getMContext(), "分享至QQ", Toast.LENGTH_SHORT).show();
            shareDialog.dismiss();
        });
        shareFriend.setOnClickListener(v -> {
            //朋友圈
            Toast.makeText(getMContext(), "分享至朋友圈", Toast.LENGTH_SHORT).show();
            shareDialog.dismiss();
        });
        shareDialog.setView(view);
        shareDialog.show();
        Objects.requireNonNull(shareDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加这句代码
    }

    @Override
    public void isCollect(int position) {
        if (data.get(position).isCollect()) {
            Toast.makeText(getMContext(), "取消收藏", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getMContext(), "收藏成功", Toast.LENGTH_SHORT).show();
        }
        data.get(position).setCollect(!data.get(position).isCollect());
        adapter.notifyDataSetChanged();
    }
}
