package com.xuliucar.car.ui.activity

import com.cangmaomao.lib.base.BaseActivity
import com.cangmaomao.lib.event.AppEvent
import com.xuliucar.car.R
import com.xuliucar.car.contract.MainContract
import com.xuliucar.car.ui.fragment.MainFragment
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity<MainContract.MainPresenter>() {

    override fun layViewId(): Int {
        return R.layout.a_main
    }

    override fun addViewId(): Int {
        return R.id.frameLayout
    }

    override fun initView() {
        loadRootFragment(addViewId(),MainFragment())

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: AppEvent) {
        when (event.actionId) {

        }
    }

}