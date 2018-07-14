package com.xuliucar.car.presenter

import com.xuliucar.car.contract.OpenPenContract
import com.xuliucar.car.contract.SelectClassContract
import java.util.ArrayList

class SelectClassPresenter(val view: SelectClassContract.View) : SelectClassContract.Presenter {

    override fun start() {
    }


    init {
        view.setPresenter(this)
    }

    override fun readClass() {
        val list = ArrayList<String>()
        for (i in 0..10) {
            list.add("小田的笔记$i")
        }
        view.classList(list)
    }


}