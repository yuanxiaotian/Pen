package com.xuliucar.car.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import com.cangmaomao.lib.action.f_edit_handwriting
import com.cangmaomao.lib.action.f_select_class
import com.cangmaomao.lib.base.BaseFragment
import com.cangmaomao.lib.event.AppEvent
import com.cangmaomao.lib.event.SelectClassEvent
import com.cangmaomao.lib.utils.toast
import com.xuliucar.car.R
import com.xuliucar.car.contract.OpenPenContract
import kotlinx.android.synthetic.main.f_openpen.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 开启笔记
 */
class OpenPenFragment() : BaseFragment<OpenPenContract.Presenter>() {

    override fun onRightClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val contentViewLayoutID: Int
        get() = R.layout.f_openpen

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getString(R.string.openPen))

        //选择分类
        tv_select.setOnClickListener { EventBus.getDefault().post(AppEvent(f_select_class, null)) }

        //确定新建
        bt_create.setOnClickListener {
            val fileName = et_name.text.toString()
            if (TextUtils.isEmpty(fileName)) {
                toast("文件夹名称不能空!")
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putString("fileName", fileName)
            EventBus.getDefault().post(AppEvent(f_edit_handwriting, bundle))
        }

    }

    fun messageEvent(event: SelectClassEvent) {
        tv_select.text = event.name
    }
}