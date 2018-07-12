package com.xuliucar.car.ui.fragment

import android.os.Bundle
import android.util.Log
import com.cangmaomao.lib.action.f_penManage
import com.cangmaomao.lib.base.BaseFragment
import com.cangmaomao.lib.event.AppEvent
import com.cangmaomao.lib.utils.e
import com.cangmaomao.lib.utils.toast
import com.xuliucar.car.R
import com.xuliucar.car.contract.MainContract
import kotlinx.android.synthetic.main.f_main.*
import org.greenrobot.eventbus.EventBus

class MainFragment() : BaseFragment<MainContract.MainPresenter>() {

    override val contentViewLayoutID: Int
        get() = R.layout.f_main

    override fun initView(savedInstanceState: Bundle?) {
        //开启笔记
        iv_c.setOnClickListener {
            toast("开启笔迹");
        }

        //智能笔管理
        bt_manage.setOnClickListener {
            e("bt_manage")
            EventBus.getDefault().post(AppEvent(f_penManage))
//            start(PenMangeFragmet())
        }

        //我的笔记
        bt_mePen.setOnClickListener {
            start(MyNoteFragment())
        }
    }
}