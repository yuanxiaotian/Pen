package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        initToolBarNav(Objects.requireNonNull(getMView()).findViewById(R.id.toolbar), R.string.file_list);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.preview_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.preview) {
            EventBus.getDefault().post(new AppEvent(FragmentActionKt.getF_editSort()));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_file_list;
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
