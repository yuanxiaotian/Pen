package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.cangmaomao.lib.action.FragmentActionKt;
import com.cangmaomao.lib.base.BaseFragment;
import com.cangmaomao.lib.event.AppEvent;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.FileListAdapter;
import com.xuliucar.car.bean.FileListBean;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileListFragment extends BaseFragment {

    private ListView listView;
    private List<FileListBean> data = new ArrayList<>();
    private FileListAdapter adapter;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.file_list),Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c),getString(R.string.edit_sort));
        listView = getMView().findViewById(R.id.listView);
        initData();
    }

    private void initData() {
        data.add(new FileListBean("默认分类", 15));
        data.add(new FileListBean("手绘彩稿01版", 15));
        data.add(new FileListBean("微课视频已录好", 5));
        data.add(new FileListBean("语文课张老师的笔迹", 15));
        data.add(new FileListBean("数学课陈老师的笔迹", 15));
        data.add(new FileListBean("英语课高老师的笔迹", 15));
        if (adapter == null) {
            adapter = new FileListAdapter(getMContext(), data);
            listView.setAdapter(adapter);
        } else adapter.notifyDataSetChanged();
    }

    @Override
    public void onRightClick(){
        EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_editSort(),null));
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_file_list;
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
