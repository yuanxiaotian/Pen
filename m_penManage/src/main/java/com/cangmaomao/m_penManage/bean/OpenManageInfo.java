package com.cangmaomao.m_penManage.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/15 0015.
 */

public class OpenManageInfo implements Serializable{

    private String OpenName;
    private boolean isSelect;
    private boolean isOften;

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

    public boolean isOften() {
        return isOften;
    }

    public void setOften(boolean often) {
        isOften = often;
    }
}
