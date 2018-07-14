package com.xuliucar.car.ui.fragment

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.cangmaomao.lib.base.BaseFragment
import com.cangmaomao.lib.base.BasePresenter
import com.xuliucar.car.R
import com.xuliucar.car.adapter.SelectClassAdapter
import com.xuliucar.car.contract.SelectClassContract
import com.xuliucar.car.presenter.SelectClassPresenter
import kotlinx.android.synthetic.main.f_select_class.*

/**
 * 选择分类
 */
class SelectClass : BaseFragment<SelectClassContract.Presenter>(), SelectClassContract.View {

    private lateinit var mAdapter: SelectClassAdapter

    override val contentViewLayoutID: Int
        get() = R.layout.f_select_class

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getString(R.string.fileClass))
        recyclerView.layoutManager = LinearLayoutManager(_mActivity)
        recyclerView.addItemDecoration(DividerItemDecoration(_mActivity, LinearLayoutManager.VERTICAL))
        mAdapter = SelectClassAdapter(R.layout.item_select_class)
        recyclerView.adapter = mAdapter

        SelectClassPresenter(this)
        p.readClass()
    }

    override fun classList(list: ArrayList<String>) {
        mAdapter.addList(list)
    }
}