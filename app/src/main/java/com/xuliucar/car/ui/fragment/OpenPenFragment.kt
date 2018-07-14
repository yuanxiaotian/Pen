package com.xuliucar.car.ui.fragment

import android.os.Bundle
import com.cangmaomao.lib.action.f_select_class
import com.cangmaomao.lib.base.BaseFragment
import com.cangmaomao.lib.event.AppEvent
import com.xuliucar.car.R
import com.xuliucar.car.contract.OpenPenContract
import kotlinx.android.synthetic.main.f_openpen.*
import org.greenrobot.eventbus.EventBus

/**
 * 开启笔记
 */
class OpenPenFragment() : BaseFragment<OpenPenContract.Presenter>() {

    override val contentViewLayoutID: Int
        get() = R.layout.f_openpen

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getString(R.string.openPen))

        tv_select.setOnClickListener {
            EventBus.getDefault().post(AppEvent(f_select_class))
        }

    }
}