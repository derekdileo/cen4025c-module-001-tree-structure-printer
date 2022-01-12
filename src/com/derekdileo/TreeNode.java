package com.derekdileo;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TreeNode extends TreeFile{

    private List<TreeFile> children;
    private long totalSize;
    private int numFiles;

    public TreeNode(int depth, Path path, BasicFileAttributes attr) {
        super(depth, path, attr);
        this.children = new ArrayList<TreeFile>();
        totalSize = 0;
        numFiles = 0;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public BasicFileAttributes getAttr() {
        return attr;
    }

    public void setAttr(BasicFileAttributes attr) {
        this.attr = attr;
    }

    public List<TreeFile> getChildren() {
        return children;
    }

    public void setChildren(List<TreeFile> children) {
        this.children = children;
    }

    public void addChild(TreeFile treeFile) {
        this.children.add(treeFile);
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
