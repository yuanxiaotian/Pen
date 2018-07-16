package com.xuliucar.car.ui.fragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cangmaomao.lib.base.BaseFragment;
import com.xuliucar.car.R;
import com.xuliucar.car.adapter.SortListAdapter;
import com.xuliucar.car.bean.SortListBean;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SortListFragment extends BaseFragment implements SortListAdapter.OnShareClickListener,
        SortListAdapter.IsCollectClickListener, SortListAdapter.IsDeleteClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private TextView allChecked, delete;
    private RelativeLayout rl_Edit;
    private List<SortListBean> data = new ArrayList<>();
    private SortListAdapter adapter;
    private AlertDialog shareDialog, deleteDialog;
    private String title;
    private boolean isEdit;//是否编辑
    private boolean isAllChecked;//是否全选

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        deleteDialog = new AlertDialog.Builder(getMContext()).create();
        shareDialog = new AlertDialog.Builder(getMContext()).create();
        title = getArguments().getString("name");
        initToolBarNav(title, Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c), getString(R.string.editData));
        recyclerView = getMView().findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        recyclerView.setLayoutManager(manager);
        rl_Edit = getMView().findViewById(R.id.rl_Edit);
        allChecked = getMView().findViewById(R.id.allChecked);
        delete = getMView().findViewById(R.id.delete);
        allChecked.setOnClickListener(this);
        delete.setOnClickListener(this);
        initData();
    }

    private void initData() {
        data.add(new SortListBean("2018/07/15 20:00", "", "", "语文课笔记", 0, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "语文课笔记", 0, false, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, false, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "语文课笔记", 0, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "随手绘画，绘于雨过天晴的下午", 1, true, false));
        data.add(new SortListBean("2018/07/15 20:00", "", "", "英语课老师的微课视频", 2, true, false));
        if (adapter == null) {
            adapter = new SortListAdapter(getMContext(), data, this, this, this);
            adapter.setData(isEdit);
            recyclerView.setAdapter(adapter);
        } else adapter.notifyDataSetChanged();
    }

    @Override
    public void onRightClick() {
        isEdit = !isEdit;
        if (isEdit) {
            initToolBarNav(title, Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c), getString(R.string.cancel));
            rl_Edit.setVisibility(View.VISIBLE);
            updateLayoutParams(isEdit);
        } else {
            initToolBarNav(title, Objects.requireNonNull(getMView()).findViewById(R.id.toolbar_c), getString(R.string.editData));
            rl_Edit.setVisibility(View.GONE);
            updateLayoutParams(isEdit);
        }
        adapter.setData(isEdit);
        adapter.notifyDataSetChanged();
        //初始化数据
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setDelete(false);
        }
        isAllChecked = false;
        setAllCheckedImg(R.drawable.icon_checked_unnormal);
    }

    /**
     * 编辑状态下更新布局
     * */
    private void updateLayoutParams(boolean isEdit) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
        if (isEdit) {
            params.setMargins(0, dip2px(10), 0, dip2px(60));
        }else {
            params.setMargins(dip2px(20), dip2px(10), dip2px(20), dip2px(10));
        }
        recyclerView.requestLayout();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.f_sort_list;
    }

    @Override
    public void setPresenter(Object presenter) {

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

    @Override
    public void isDelete(int position) {
        data.get(position).setDelete(!data.get(position).isDelete());
        adapter.notifyDataSetChanged();
        if (isAllChecked()) {
            isAllChecked = true;
            setAllCheckedImg(R.drawable.icon_checked_normal);
        } else {
            isAllChecked = false;
            setAllCheckedImg(R.drawable.icon_checked_unnormal);
        }
    }

    /**
     * 检查数据是否全部选中
     */
    private boolean isAllChecked() {
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).isDelete()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 检查数据是否有选中
     * */
    private boolean isHaveChecked() {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isDelete()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allChecked://全选
                if (isAllChecked) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setDelete(false);
                    }
                    setAllCheckedImg(R.drawable.icon_checked_unnormal);
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setDelete(true);
                    }
                    setAllCheckedImg(R.drawable.icon_checked_normal);
                }
                isAllChecked = !isAllChecked;
                adapter.notifyDataSetChanged();
                break;
            case R.id.delete://删除
                if (isHaveChecked()){
                    deleteData();
                }else {
                    Toast.makeText(getMContext(), "请选择需要删除的文件", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 删除选中数据
     */
    private void deleteData() {
        View view = LayoutInflater.from(getMContext()).inflate(R.layout.dialog_delete, null);
        ImageView imageView = view.findViewById(R.id.close);
        TextView textView = view.findViewById(R.id.sure);
        imageView.setOnClickListener(v -> deleteDialog.dismiss());
        textView.setOnClickListener(v -> {
            for (int i = data.size()-1; i >= 0; i--) {
                if (data.get(i).isDelete()) {
                    data.remove(i);
                }
            }
            adapter.notifyDataSetChanged();
            deleteDialog.dismiss();
        });
        deleteDialog.setView(view);
        deleteDialog.show();
        Objects.requireNonNull(deleteDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加这句代码
    }

    /**
     * 设置全选或取消图片
     */
    private void setAllCheckedImg(int imgResources) {
        Drawable drawable = getResources().getDrawable(imgResources);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        allChecked.setCompoundDrawables(drawable, null, null, null);
    }
}
