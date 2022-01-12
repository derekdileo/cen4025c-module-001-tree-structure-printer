package com.derekdileo;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class TreeFile {
    int depth;
    Path path;
    BasicFileAttributes attr;

    public TreeFile(int depth, Path path, BasicFileAttributes attr) {
        this.depth = depth;
        this.path = path;
        this.attr = attr;
    }

    public int getDepth() {
        return depth;
    }

    public Path getPath() {
        return path;
    }

    public BasicFileAttributes getAttr() {
        return attr;
    }
}
