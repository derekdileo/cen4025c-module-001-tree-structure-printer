package com.derekdileo;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static int numFiles = 0;
    public static long totalSize = 0;
    public static TreeDirectory treeDirectory;

    public static Path currentPath;

    public static void main(String[] args) throws Exception {
        currentPath = Paths.get(System.getProperty("user.dir"));
        System.out.println("\ncurrentPath = " + currentPath + "\n");
        listDir(currentPath, 0);
    }

    public static void listDir(Path path, int depth) throws Exception {

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        // if directory, list the files, and traverse down inside each
        if(attr.isDirectory()) {
            treeDirectory = new TreeDirectory(path.getParent(), depth);

            // list the directory
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);

            // print directory name, number of files, total size of files, list of child folders
//            System.out.println(spacesForDepth(depth) + " >" + path.getFileName() + " [Directory Size: " + attr.size() + " B], [Number of Files: " + numFiles + "], [Total Size: " + totalSize + "]");

            // if subdirectory is found, call listDir recursively
            for (Path tempPath: paths) {
                listDir(tempPath, depth + 1);
            }

        } else {
//            System.out.println(spacesForDepth(depth) + " - - " + path.getFileName() + " [File Size: " + attr.size() + " B]");
            TreeFile treeFile = new TreeFile(path, attr.size());
            treeDirectory.addChild(treeFile);
            treeDirectory.setTotalSize(treeDirectory.getTotalSize() + attr.size());
        }

    }



    public static String spacesForDepth(int depth) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    public static String getFileSize(long size) {
        String result;

        if(size > 1000000) {
            result = size + " MB]";
        } else if (size > 1000) {
            result = size + " KB]";
        } else {
            result = size + " B]";
        }

        return result;
    }


}


