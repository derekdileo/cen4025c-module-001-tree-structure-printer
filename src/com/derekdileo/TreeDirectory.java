package com.derekdileo;

import java.nio.file.Path;
import java.util.List;

public class TreeDirectory {

    Path parentDirectory;
    int depth;
    List<TreeFile> children;
    long totalSize;
    int numFiles;

    public TreeDirectory(Path parentDirectory, int depth) {
        this.parentDirectory = parentDirectory;
        this.depth = depth;
        this.getChildren();
        this.getTotalSize();
        this.getNumFiles();
    }

    public Path getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Path parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<TreeFile> getChildren() {
        return children;
    }

    public void addChild(TreeFile treeFile) {
        children.add(treeFile);
    }

    public void setChildren(List<TreeFile> children) {
        this.children = children;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }
}
