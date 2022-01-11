package com.derekdileo;

import java.nio.file.Path;

public class TreeFile {
    Path parentDirectory;
    long fileSize;

    public TreeFile(Path parentDirectory, long fileSize) {
        this.parentDirectory = parentDirectory;
        this.fileSize = fileSize;
    }

    public Path getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Path parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
