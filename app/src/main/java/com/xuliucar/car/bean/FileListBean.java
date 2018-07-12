package com.xuliucar.car.bean;

public class FileListBean {
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
