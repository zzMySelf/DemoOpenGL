package com.baidu.live.framework.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class BdFileHelper {
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;
    private static final char SYSTEM_SEPARATOR = File.separatorChar;
    private static final char WINDOWS_SEPARATOR = '\\';

    public static void copyFile(File srcFile, File destFile) throws IOException {
        copyFile(srcFile, destFile, true);
    }

    public static void copyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        } else if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!srcFile.exists()) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        } else if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' exists but is a directory");
        } else if (!srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
            File parentFile = destFile.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!destFile.exists() || destFile.canWrite()) {
                doCopyFile(srcFile, destFile, preserveFileDate);
            } else {
                throw new IOException("Destination '" + destFile + "' exists but is read-only");
            }
        } else {
            throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
        }
    }

    private static void doCopyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        File file = srcFile;
        File file2 = destFile;
        if (!destFile.exists() || !destFile.isDirectory()) {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            FileChannel input = null;
            FileChannel output = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(file2);
                FileChannel input2 = fis.getChannel();
                try {
                    FileChannel output2 = fos.getChannel();
                    try {
                        long size = input2.size();
                        long pos = 0;
                        while (pos < size) {
                            long count = 31457280;
                            if (size - pos <= 31457280) {
                                count = size - pos;
                            }
                            pos += output2.transferFrom(input2, pos, count);
                        }
                        close((Closeable) output2);
                        close((Closeable) fos);
                        close((Closeable) input2);
                        close((InputStream) fis);
                        if (srcFile.length() != destFile.length()) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        } else if (preserveFileDate) {
                            file2.setLastModified(srcFile.lastModified());
                        }
                    } catch (Error e2) {
                        output = output2;
                        input = input2;
                        try {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        } catch (Throwable th2) {
                            e = th2;
                            close((Closeable) output);
                            close((Closeable) fos);
                            close((Closeable) input);
                            close((InputStream) fis);
                            throw e;
                        }
                    } catch (Throwable th3) {
                        e = th3;
                        output = output2;
                        input = input2;
                        close((Closeable) output);
                        close((Closeable) fos);
                        close((Closeable) input);
                        close((InputStream) fis);
                        throw e;
                    }
                } catch (Error e3) {
                    input = input2;
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                } catch (Throwable th4) {
                    e = th4;
                    input = input2;
                    close((Closeable) output);
                    close((Closeable) fos);
                    close((Closeable) input);
                    close((InputStream) fis);
                    throw e;
                }
            } catch (Error e4) {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
        } else {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception e2) {
        }
        try {
            return file.delete();
        } catch (Exception e3) {
            return false;
        }
    }

    public static void cleanDirectory(File directory) throws IOException {
        if (!directory.exists()) {
            throw new IllegalArgumentException(directory + " does not exist");
        } else if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                IOException exception = null;
                for (File file : files) {
                    try {
                        forceDelete(file);
                    } catch (IOException ioe) {
                        exception = ioe;
                    }
                }
                if (exception != null) {
                    throw exception;
                }
                return;
            }
            throw new IOException("Failed to list contents of " + directory);
        } else {
            throw new IllegalArgumentException(directory + " is not a directory");
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean filePresent = file.exists();
        if (file.delete()) {
            return;
        }
        if (!filePresent) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void deleteDirectory(File directory) throws IOException {
        if (directory.exists()) {
            if (!isSymlink(directory)) {
                cleanDirectory(directory);
            }
            if (!directory.delete()) {
                throw new IOException("Unable to delete directory " + directory + ".");
            }
        }
    }

    public static boolean isSymlink(File file) throws IOException {
        File fileInCanonicalDir;
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (isSystemWindows()) {
            return false;
        } else {
            if (file.getParent() == null) {
                fileInCanonicalDir = file;
            } else {
                fileInCanonicalDir = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            if (fileInCanonicalDir.getCanonicalFile().equals(fileInCanonicalDir.getAbsoluteFile())) {
                return false;
            }
            return true;
        }
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static void close(InputStream inStream) {
        if (inStream != null) {
            try {
                inStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static void close(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Throwable th2) {
            }
        }
    }
}
