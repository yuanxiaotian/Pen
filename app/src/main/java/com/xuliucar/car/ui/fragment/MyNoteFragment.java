package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MyNoteFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout fileList, myCollect, aboutNote;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(Objects.requireNonNull(getMView()).findViewById(R.id.toolbar), R.string.my_note);
        fileList = getMView().findViewById(R.id.fileList);
        myCollect = getMView().findViewById(R.id.myCollect);
        aboutNote = getMView().findViewById(R.id.aboutNote);
        fileList.setOnClickListener(this);
        myCollect.setOnClickListener(this);
        aboutNote.setOnClickListener(this);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_my_note;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fileList://文件列表
                start(new FileListFragment());
                break;
            case R.id.myCollect://我的收藏
                start(new MyCollectFragment());
                break;
            case R.id.aboutNote://关于云享笔迹
                start(new AboutNoteFragment());
                break;
        }
    }
}
