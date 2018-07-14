package com.xuliucar.car.bean;

public class EditSortBean {
    private String fileName;
    private boolean isEdit;

    public EditSortBean(String fileName,boolean isEdit) {
        this.fileName = fileName;
        this.isEdit=isEdit;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }
}
