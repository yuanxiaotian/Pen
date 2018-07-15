package com.xuliucar.car.adapter

import com.cangmaomao.recyclerview.adapter.CMMAdapter
import com.cangmaomao.recyclerview.adapter.CMMViewHolder
import com.xuliucar.car.R

/**
 * 分类适配器
 */
class SelectClassAdapter(layoutId: Int) : CMMAdapter<String>(layoutId) {

    override fun convert(p0: CMMViewHolder, p1: String?, p2: Int) {
        p0.setText(R.id.tv_name, p1)
    }
}