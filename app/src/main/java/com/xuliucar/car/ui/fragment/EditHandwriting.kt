package com.xuliucar.car.ui.fragment

import android.os.Bundle
import com.cangmaomao.lib.base.BaseFragment
import com.xuliucar.car.R
import com.xuliucar.car.contract.EditHandwritingContract

/**
 * 编辑笔迹
 */
class EditHandwriting : BaseFragment<EditHandwritingContract.Presenter>(), EditHandwritingContract.View {


    override val contentViewLayoutID: Int
        get() = R.layout.f_edit_handwriting

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getFileName(), "保存")
    }

    override fun getFileName(): String {
        return arguments!!.getString("fileName")
    }

    override fun onRightClick() {
    }
}