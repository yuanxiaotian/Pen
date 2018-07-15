package com.cangmaomao.m_penManage.bean;

/**
 * Created by Administrator on 2018/7/15 0015.
 */

public class OpenManageInfo {

    private String OpenName;
    private boolean isSelect;

    public OpenManageInfo(String openName) {
        OpenName = openName;
    }

    public String getOpenName() {
        return OpenName;
    }

    public void setOpenName(String openName) {
        OpenName = openName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
