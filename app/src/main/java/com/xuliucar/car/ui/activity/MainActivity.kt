package com.xuliucar.car.ui.activity

import com.cangmaomao.lib.action.*
import com.cangmaomao.lib.base.BaseActivity
import com.cangmaomao.lib.event.AppEvent
import com.cangmaomao.lib.utils.StatusBarUtil
import com.cangmaomao.m_penManage.fragment.OftenConnFragment
import com.cangmaomao.m_penManage.fragment.PenMangeFragmet
import com.xuliucar.car.R
import com.xuliucar.car.contract.MainContract
import com.xuliucar.car.ui.fragment.*
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
        StatusBarUtil.setStatusBarColor(this, R.color.c_w)
        StatusBarUtil.StatusBarLightMode(this)
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
            f_often_conn -> {
                val edit = OftenConnFragment()
                edit.arguments = event.bundle
                start(edit)
            }
            f_select_class -> start(SelectClass())
            f_edit_handwriting -> {
                val edit = EditHandwriting()
                edit.arguments = event.bundle
                start(edit)
            }
            f_sortList->{
                val edit = SortListFragment()
                edit.arguments = event.bundle
                start(edit)
            }
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