package com.cangmaomao.lib.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.toolbar_view.*
import me.yokeyword.fragmentation.ISupportFragment


/**
 * Author:帅气的potato
 */

abstract class BaseFragment<T : BasePresenter> : BaseAppCompatFragment(), BaseView<T> {

    lateinit var p: T
    var mRxPermissions: RxPermissions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRxPermissions = RxPermissions(_mActivity)
    }

    override fun setPresenter(presenter: T) {
        p = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }


    abstract fun initView(savedInstanceState: Bundle?)


    protected fun initToolBarNav(title: String?, toolbar: Toolbar = toolbar_c) {
        toolbar_title.text = title
        toolbar.setNavigationOnClickListener { pop() }
    }

    protected fun initToolBarNav(title: String?, toolbar: Toolbar = toolbar_c, subTitle: String?) {
        toolbar_title.text = title
        toolbar_subtitle.text = subTitle
        toolbar.setNavigationOnClickListener { pop() }
        toolbar_subtitle.setOnClickListener({
            onRightClick()
        })
    }

    protected fun initToolBarNav(title: String?, subTitle: String?, toolbar: Toolbar = toolbar_c) {
        toolbar_title.text = title
        toolbar_subtitle.text = subTitle
        toolbar.setNavigationOnClickListener { pop() }
        toolbar_subtitle.setOnClickListener({
            onRightClick()
        })
    }

    abstract fun onRightClick()

    /****
     * 从栈中移除当前fragment
     */
    override fun pop() {
        super.pop()
    }

    /****
     * 跳转至目标fragment
     */
    override fun start(toFragment: ISupportFragment?) {
        super.start(toFragment)
    }

    /***
     * toFragment：目标fragment
     * targetFragmentClass:当前fragment
     * includeTargetFragment:是否在栈中保留当前fragment
     */
    override fun startWithPopTo(toFragment: ISupportFragment?, targetFragmentClass: Class<*>?, includeTargetFragment: Boolean) {
        super.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
    }


    /****
     * 加载fragment
     * containerId：加载的id
     * toFragment:被加载的fargment对象
     */
    override fun loadRootFragment(containerId: Int, toFragment: ISupportFragment?) {
        super.loadRootFragment(containerId, toFragment)
    }


    /****
     * 替换fragment
     */
    override fun replaceFragment(toFragment: ISupportFragment?, addToBackStack: Boolean) {
        super.replaceFragment(toFragment, addToBackStack)
    }


}
