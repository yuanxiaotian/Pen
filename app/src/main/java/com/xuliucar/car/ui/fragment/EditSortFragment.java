package com.xuliucar.car.ui.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class EditSortFragment extends BaseFragment {

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        initToolBarNav(Objects.requireNonNull(getMView()).findViewById(R.id.toolbar), R.string.edit_sort);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_edit_sort;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.edit_sort_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.preview) {
            Toast.makeText(getMContext(), "点击", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
