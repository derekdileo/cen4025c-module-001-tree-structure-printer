package com.derekdileo;

import java.util.List;

public class TreeDirectory {

    String parentDirectory;
    List<TreeFile> children;
    long totalDirectorySize;

    public String getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public List<TreeFile> getChildren() {
        return children;
    }

    public void setChildren(List<TreeFile> children) {
        this.children = children;
    }

    public long getTotalDirectorySize() {
        return totalDirectorySize;
    }

    public void setTotalDirectorySize(long totalDirectorySize) {
        this.totalDirectorySize = totalDirectorySize;
    }
}
