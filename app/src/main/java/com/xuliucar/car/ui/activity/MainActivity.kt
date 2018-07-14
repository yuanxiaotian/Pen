package com.xuliucar.car.ui.activity

import com.cangmaomao.lib.action.*
import com.cangmaomao.lib.base.BaseActivity
import com.cangmaomao.lib.event.AppEvent
import com.xuliucar.car.R
import com.xuliucar.car.contract.MainContract
import com.xuliucar.car.ui.fragment.*
import com.xuliucar.car.ui.fragment.manage.OftenConnFragment
import com.xuliucar.car.ui.fragment.manage.PenMangeFragmet
import org.greenrobot.eventbus.EventBus
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
        loadRootFragment(addViewId(), MainFragment(), false, false)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun messageEvent(event: AppEvent) {
        when (event.actionId) {
            f_penManage -> start(PenMangeFragmet())
            f_myNote -> start(MyNoteFragment())
            f_fileList -> start(FileListFragment())
            f_myCollect -> start(MyCollectFragment())
            f_aboutNote -> start(AboutNoteFragment())
            f_editSort -> start(EditSortFragment())
            f_openPen -> start(OpenPenFragment())
            f_often_conn->start(OftenConnFragment())
        }
    }

    override fun onBackPressedSupport() {
        if (topFragment == MainFragment()) {
            finish()
        } else {
            pop()
        }
    }
}