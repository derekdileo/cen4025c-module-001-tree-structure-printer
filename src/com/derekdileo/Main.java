package com.derekdileo;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static int numFiles = 0;
    public static long totalSize = 0;
    public static List<TreeFile> allNodes = new ArrayList<>();
    public static List<File> parentFileList = new ArrayList<File>();
    public static List<Files> parentFilesList = new ArrayList<Files>();
    public static TreeNode treeNode;

    // Integer = depth, Node
    public static HashMap<Integer, Node> nodeMap = new LinkedHashMap<>();

    public static Path currentPath;

    public static void main(String[] args) throws Exception {
        currentPath = Paths.get(System.getProperty("user.dir"));
        System.out.println("\ncurrentPath = " + currentPath + "\n");

        listDir(currentPath, 0);
//        simpleListDir(currentPath, 0, nodeMap);
        System.out.println("nodeMap.size(): " + nodeMap.size());

        printSimpleListDir(currentPath, 0, nodeMap);

    }

    public static long simpleListDir(Path path, int depth, HashMap<Integer, Node> map) throws Exception{

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        Node node = new Node();
        // if directory, list the files, and traverse down into each
        if(attr.isDirectory()) {

            node.setName(path.getFileName().toString());
            map.put(depth, node);
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);

            for(Path tempPath : paths) {
//                node.addChildFolder(tempPath);
//                map.replace(depth, node);
                simpleListDir(tempPath, depth + 1, map);
            }
        } else {
            // Add TreeFile to Node, update totalSize, inc numFiles, update nodeMap
            TreeFile treeFile = new TreeFile(depth, path, attr);
            node.addChildFile(treeFile);
            node.setTotalSize(node.getTotalSize() + attr.size());
            node.incrementNumFiles();
            map.replace(depth, node);
            System.out.println(node.getTotalSize());
        }

        return node.getTotalSize();

    }


    public static void printSimpleListDir(Path path, int depth, HashMap<Integer, Node> map) throws Exception {

        for(int i = 0; i < map.size(); i++) {

            if(map.get(depth) != null) {
                Node node = map.get(depth);

                // print directory name, number of files, total size of files, list of child folders
                System.out.println(spacesForDepth(depth) +
                        " >" + node.getName() +
                        " [Directory Size: " + node.getTotalSize() +
                        " B], [Number of Files: " + node.getNumFiles() + "]");



            }

        }

    }

    public static void listDir(Path path, int depth) throws Exception {

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        // if directory, list the files, and traverse down inside each
        if(attr.isDirectory()) {

            // list available directories
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);

            // print directory name, number of files, total size of files, list of child folders
            System.out.println(spacesForDepth(depth) + " >" + path.getFileName() + " [Directory Size: " + attr.size() + " B], [Number of Files: " + numFiles + "], [Total Size: " + totalSize + "]");

            // if subdirectory is found, call listDir recursively
            for (Path tempPath: paths) {
                listDir(tempPath, depth + 1);
            }

        } else {
            System.out.println(spacesForDepth(depth) + " - - " + path.getFileName() + " [File Size: " + attr.size() + " B]");
        }

    }




    public static void printNodes(Path path, int depth) throws Exception {

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        if(attr.isDirectory()) {

        }


        DirectoryStream<Path> paths = Files.newDirectoryStream(path);




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


//    public static TreeNode listDirAtPath(Path path, int depth, List<TreeFile> parentNodeList) throws Exception {
//
//        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
//        nodeMap = new LinkedHashMap<>();
//
//        // if directory, list the files, and traverse down inside each
//        if(attr.isDirectory()) {
//            treeNode = new TreeNode(depth, path, attr);
//            nodeMap.put(depth, treeNode);
//            parentNodeList.add(treeNode);
//            List<TreeFile> currentList = new ArrayList<>();
//
//            // list available directories
//            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
//
//            // print directory name, number of files, total size of files, list of child folders
////            System.out.println(spacesForDepth(depth) + " >" + path.getFileName() + " [Directory Size: " + attr.size() + " B], [Number of Files: " + numFiles + "], [Total Size: " + totalSize + "]");
//
//            // if subdirectory is found, call listDir recursively
//            for (Path tempPath: paths) {
//                listDirAtPath(tempPath, depth + 1, currentList);
////                nodeMap.put(1, attr.size());
//            }
//
//        } else {
////            System.out.println(spacesForDepth(depth) + " - - " + path.getFileName() + " [File Size: " + attr.size() + " B]");
//            TreeFile treeFile = new TreeFile(depth, path, attr);
//            parentNodeList.add(treeFile);
//            //treeNode.setTotalSize(treeNode.getTotalSize() + attr.size());
//        }
//
//        return treeNode;
//
//    }


}


