package com.cangmaomao.m_penManage.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.cangmaomao.m_penManage.R;

import static com.cangmaomao.lib.utils.LogUtilsKt.e;

/**
 * Created by Administrator on 2018/7/14 0014.
 */

public class DeleConnDialog extends AlertDialog {

    private View mView;
    private ImageView dele_Close;
    public LinearLayout l_commit;
    private Context mContext;

    public DeleConnDialog(Context context) {
        super(context);
       mContext = context;
       mView = LayoutInflater.from(mContext).
                inflate(R.layout.dialog_dele_conn,null);
       initView();
       initListener();
       setCancelable(false);
    }

    public void  showDialog(){
        setView(mView);
        show();
    }

    private void initView(){
        dele_Close = mView.findViewById(R.id.dele_Close);
        l_commit = mView.findViewById(R.id.l_commit);
    }

    private void initListener(){
        dele_Close.setOnClickListener(v->{
            dismiss();
        });
        l_commit.setOnClickListener(v->{
            e("确定");
        });
    }
}
