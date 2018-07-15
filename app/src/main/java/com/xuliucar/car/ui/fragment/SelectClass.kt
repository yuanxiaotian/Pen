package com.xuliucar.car.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.cangmaomao.lib.base.BaseFragment
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
        initToolBarNav(getString(R.string.fileClass), getString(R.string.new_class))
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


    override fun onRightClick() {
        val dialog = AlertDialog.Builder(_mActivity).create()
        val view = View.inflate(_mActivity, R.layout.dialog_add_sort, null)
        view.findViewById<TextView>(R.id.sure).setOnClickListener {

        }
        view.findViewById<TextView>(R.id.cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.setView(view)
        dialog.show()
    }
}