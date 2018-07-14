package com.xuliucar.car.ui.fragment

import android.os.Bundle
import com.cangmaomao.lib.base.BaseFragment
import com.xuliucar.car.R
import com.xuliucar.car.contract.OpenPenContract

/**
 * 开启笔记
 */
class OpenPenFragment() : BaseFragment<OpenPenContract.Presenter>() {

    override fun onRightClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val contentViewLayoutID: Int
        get() = R.layout.f_openpen

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getString(R.string.openPen))
    }
}