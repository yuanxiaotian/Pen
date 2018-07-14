package com.xuliucar.car.contract

import com.cangmaomao.lib.base.BasePresenter
import com.cangmaomao.lib.base.BaseView

/**
 * Created by Administrator on 2018/7/11 0011.
 */
interface SelectClassContract {

    interface View : BaseView<Presenter> {

        fun classList(list: ArrayList<String>)

    }

    interface Presenter : BasePresenter {

        fun readClass()

    }
}