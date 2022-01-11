package com.derekdileo;

public class TreeFile {
    String parentDirectory;
    String fileName;
    Object fileKey;  //attr.getFileKey()
    long fileSize;

    public TreeFile(String parentDirectory, String fileName, Object fileKey, long fileSize) {
        this.parentDirectory = parentDirectory;
        this.fileName = fileName;
        this.fileKey = fileKey;
        this.fileSize = fileSize;
    }

    public String getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getFileKey() {
        return fileKey;
    }

    public void setFileKey(Object fileKey) {
        this.fileKey = fileKey;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
