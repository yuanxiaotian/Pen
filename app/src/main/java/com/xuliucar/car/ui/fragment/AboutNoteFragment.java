package com.xuliucar.car.ui.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AboutNoteFragment extends BaseFragment {

    private TextView mVersionName;
    private String versionName;

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(getString(R.string.about_note),Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c));
        mVersionName=getMView().findViewById(R.id.versionName);
        mVersionName.setText(String.valueOf("版本：V"+versionName));
    }

    @Override
    protected int getContentViewLayoutID() {
        try {
            //当前包名，0代表是获取版本信息
            PackageInfo packageInfo = getMContext().getPackageManager()
                    .getPackageInfo(getMContext().getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return R.layout.f_about_note;
    }

    @Override
    public void onRightClick(){

    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
