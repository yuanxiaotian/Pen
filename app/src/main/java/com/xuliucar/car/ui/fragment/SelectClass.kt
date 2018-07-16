package com.xuliucar.car.ui.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.cangmaomao.lib.base.BaseFragment
import com.cangmaomao.lib.event.SelectClassEvent
import com.cangmaomao.lib.utils.toast
import com.cangmaomao.recyclerview.adapter.CMMAdapter
import com.cangmaomao.recyclerview.adapter.contract.OnItemClick
import com.xuliucar.car.R
import com.xuliucar.car.adapter.SelectClassAdapter
import com.xuliucar.car.contract.SelectClassContract
import com.xuliucar.car.presenter.SelectClassPresenter
import kotlinx.android.synthetic.main.f_select_class.*

/**
 * 选择分类
 */
class SelectClass : BaseFragment<SelectClassContract.Presenter>(), SelectClassContract.View, OnItemClick {

    private lateinit var mAdapter: SelectClassAdapter
    private lateinit var setList: HashSet<String>

    override val contentViewLayoutID: Int
        get() = R.layout.f_select_class

    override fun initView(savedInstanceState: Bundle?) {
        initToolBarNav(getString(R.string.fileClass), getString(R.string.new_class))
        recyclerView.layoutManager = LinearLayoutManager(_mActivity)
        recyclerView.addItemDecoration(DividerItemDecoration(_mActivity, LinearLayoutManager.VERTICAL))
        mAdapter = SelectClassAdapter(R.layout.item_select_class)
        mAdapter.setOnItemClickListener(this)
        recyclerView.adapter = mAdapter
        SelectClassPresenter(this)
        p.readClass()
    }

    override fun context(): Context = _mActivity

    override fun classList(list: HashSet<String>) {
        this.setList = list
        val classList = ArrayList<String>()
        for (i in setList) {
            classList.add(i)
        }
        mAdapter.addList(classList)
    }

    override fun getClassList(): HashSet<String> = setList

    override fun onRightClick() {
        val dialog = AlertDialog.Builder(_mActivity).create()
        val view = View.inflate(_mActivity, R.layout.dialog_add_sort, null)
        val sortName = view.findViewById<EditText>(R.id.sortName)
        view.findViewById<TextView>(R.id.sure).setOnClickListener {
            if (TextUtils.isEmpty(sortName.text.toString())) {
                toast("分类名称不能为空!")
                return@setOnClickListener
            }
            setList.add(sortName.text.toString())
            mAdapter.addData(sortName.text.toString())
            p.saveClass()
            dialog.dismiss()
        }
        view.findViewById<TextView>(R.id.cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.setView(view)
        dialog.show()
    }

    override fun onItemClick(p0: CMMAdapter<*>?, p1: Any?, p2: Int) {
        val list = mAdapter.data as ArrayList<String>
        val className = list.get(p2)
        val fragments = _mActivity.supportFragmentManager.fragments
        for (fragment in fragments) {
            if (fragment.javaClass == OpenPenFragment::class.java) {
                val f = fragment as OpenPenFragment
                f.messageEvent(SelectClassEvent(className))
            }
        }
        pop()
    }
}