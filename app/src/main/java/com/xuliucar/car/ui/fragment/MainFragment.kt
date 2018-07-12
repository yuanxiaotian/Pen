package com.xuliucar.car.ui.fragment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cangmaomao.lib.base.BaseFragment
import com.xuliucar.car.R
import com.xuliucar.car.contract.MainContract
import com.xuliucar.car.ui.fragment.manage.PenMangeFragmet
import kotlinx.android.synthetic.main.f_main.*

class MainFragment() : BaseFragment<MainContract.MainPresenter>() {
    override val contentViewLayoutID: Int
        get() = R.layout.f_main

    override fun initView(savedInstanceState: Bundle?) {
        //开启笔记
        iv_c.setOnClickListener { }

        //智能笔管理
        bt_manage.setOnClickListener {
            Log.e("msg","d")
            popTo(PenMangeFragmet::class.java,true)
//            start(PenMangeFragmet::class.java)
        }

        //我的笔记
        bt_mePen.setOnClickListener { }
    }
}