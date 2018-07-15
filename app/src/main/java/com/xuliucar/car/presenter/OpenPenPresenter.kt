package com.xuliucar.car.presenter

import com.xuliucar.car.contract.OpenPenContract

class OpenPenPresenter(val view: OpenPenContract.View) : OpenPenContract.Presenter {

    override fun start() {
    }


    init {
        view.setPresenter(this)
    }


}