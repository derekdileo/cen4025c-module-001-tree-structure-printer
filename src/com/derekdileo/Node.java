package com.derekdileo;

import java.nio.file.Path;
import java.util.ArrayList;

public class Node {
    private int numFiles;
    private long totalSize;
    private String name;
    private ArrayList<Path> childFolders;
    private ArrayList<TreeFile> childFiles;

    public Node() {
        this.numFiles = 0;
        this.totalSize = 0;
        this.name = null;
        childFolders = new ArrayList<>();
        childFiles = new ArrayList<>();
    }

    public void incrementNumFiles() {
        this.numFiles++;
    }

    public int getNumFiles() {
        return numFiles;
    }

    private void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChildFolder(Path path) {
        this.childFolders.add(path);
    }

    public ArrayList<Path> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(ArrayList<Path> childFolders) {
        this.childFolders = childFolders;
    }

    public void addChildFile(TreeFile treeFile) {
        this.childFiles.add(treeFile);
    }

    public ArrayList<TreeFile> getChildFiles() {
        return childFiles;
    }

    public void setChildFiles(ArrayList<TreeFile> childFiles) {
        this.childFiles = childFiles;
    }

}
