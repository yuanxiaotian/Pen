package com.xuliucar.car.contract

import com.cangmaomao.lib.base.BasePresenter
import com.cangmaomao.lib.base.BaseView

/**
 * Created by Administrator on 2018/7/11 0011.
 */
interface EditHandwritingContract {

    interface View : BaseView<Presenter> {

        fun getFileName(): String

    }

    interface Presenter : BasePresenter {


    }
}