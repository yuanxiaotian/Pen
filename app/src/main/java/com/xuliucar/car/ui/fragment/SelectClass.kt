package com.xuliucar.car.ui.fragment

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.cangmaomao.lib.base.BaseFragment
import com.xuliucar.car.R
import com.xuliucar.car.adapter.SelectClassAdapter
import com.xuliucar.car.contract.SelectClassContract
import com.xuliucar.car.presenter.SelectClassPresenter
import kotlinx.android.synthetic.main.f_select_class.*

/**
 * 选择分类
 */
class SelectClass() : BaseFragment<SelectClassContract.Presenter>(), SelectClassContract.View, Parcelable {
    override fun onRightClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mAdapter: SelectClassAdapter

    override val contentViewLayoutID: Int
        get() = R.layout.f_select_class

    constructor(parcel: Parcel) : this() {

    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SelectClass> {
        override fun createFromParcel(parcel: Parcel): SelectClass {
            return SelectClass(parcel)
        }

        override fun newArray(size: Int): Array<SelectClass?> {
            return arrayOfNulls(size)
        }
    }
}