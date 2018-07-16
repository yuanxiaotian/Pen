package com.xuliucar.car.bean;

import java.io.Serializable;

public class FileListBean implements Serializable {
    private String fileName;
    private int fileNum;

    public FileListBean(String fileName, int fileNum) {
        this.fileName = fileName;
        this.fileNum = fileNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }
}
