package com.xuliucar.car.presenter

import com.xuliucar.car.contract.MainContract

class MainPresenter(val view: MainContract.MainView) : MainContract.MainPresenter {

    override fun start() {
    }


    init {
        view.setPresenter(this)
    }


}