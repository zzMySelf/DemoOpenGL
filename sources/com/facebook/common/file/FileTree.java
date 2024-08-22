package com.facebook.common.file;

import java.io.File;

public class FileTree {
    public static String sMaxLengthFileName = null;

    public static void walkFileTree(File directory, FileTreeVisitor visitor) {
        File[] files;
        visitor.preVisitDirectory(directory);
        try {
            files = directory.listFiles();
        } catch (OutOfMemoryError e2) {
            System.gc();
            files = listFiles(directory, directory.list());
        }
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    walkFileTree(file, visitor);
                } else {
                    visitor.visitFile(file);
                    String path = file.getPath();
                    if (path != null) {
                        if (sMaxLengthFileName == null) {
                            sMaxLengthFileName = path;
                        } else if (path.length() > sMaxLengthFileName.length()) {
                            sMaxLengthFileName = path;
                        }
                    }
                }
            }
        }
        visitor.postVisitDirectory(directory);
    }

    public static boolean deleteContents(File directory) {
        File[] files = directory.listFiles();
        boolean success = true;
        if (files != null) {
            for (File file : files) {
                success &= deleteRecursively(file);
            }
        }
        return success;
    }

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }

    private static File[] listFiles(File parentFile, String[] fileNames) {
        if (parentFile == null || fileNames == null || fileNames.length == 0) {
            return null;
        }
        return filenamesToFiles(parentFile, fileNames);
    }

    private static File[] filenamesToFiles(File parentFile, String[] filenames) {
        String dirPath = parentFile.getPath();
        int count = filenames.length;
        File[] result = new File[count];
        for (int i2 = 0; i2 < count; i2++) {
            result[i2] = new File(getSubFilePath(dirPath, filenames[i2]));
        }
        return result;
    }

    private static String getSubFilePath(String dirPath, String fileName) {
        if (dirPath.isEmpty()) {
            return fileName;
        }
        if (fileName.isEmpty()) {
            return dirPath;
        }
        return join(dirPath, fileName);
    }

    private static String join(String prefix, String suffix) {
        int prefixLength = prefix.length();
        boolean z = false;
        boolean haveSlash = prefixLength > 0 && prefix.charAt(prefixLength + -1) == File.separatorChar;
        if (!haveSlash) {
            if (suffix.length() > 0 && suffix.charAt(0) == File.separatorChar) {
                z = true;
            }
            haveSlash = z;
        }
        if (haveSlash) {
            StringBuilder sb = new StringBuilder(prefix.length() + suffix.length());
            sb.append(prefix).append(suffix);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(prefix.length() + suffix.length() + 1);
        sb2.append(prefix).append(File.separatorChar).append(suffix);
        return sb2.toString();
    }
}
