package com.xuliucar.car.contract

import android.content.Context
import android.support.v4.util.ArraySet
import com.cangmaomao.lib.base.BasePresenter
import com.cangmaomao.lib.base.BaseView

/**
 * Created by Administrator on 2018/7/11 0011.
 */
interface SelectClassContract {

    interface View : BaseView<Presenter> {

        fun context(): Context

        fun classList(list: HashSet<String>)

        fun getClassList(): HashSet<String>

    }

    interface Presenter : BasePresenter {

        fun readClass()

        fun saveClass()

    }
}