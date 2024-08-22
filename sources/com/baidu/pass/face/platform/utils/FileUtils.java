package com.baidu.pass.face.platform.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class FileUtils {
    private static final Pattern RESERVED_CHARS_PATTERN = Pattern.compile("[\\\\/:\\*\\?\\\"<>|]");
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;

    private FileUtils() {
    }

    public static void cleanDir(File file) {
        deleteDir(file, false);
    }

    public static void cleanDir(File file, FileFilter fileFilter) {
        deleteDir(file, false, fileFilter);
    }

    public static void cleanDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, false, filenameFilter);
    }

    public static long computeFolderSize(File file) {
        long computeFolderSize;
        long j2 = 0;
        if (file == null) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    computeFolderSize = file2.length();
                } else if (file2.isDirectory()) {
                    j2 += file2.length();
                    computeFolderSize = computeFolderSize(file2);
                }
                j2 += computeFolderSize;
            }
        }
        return j2;
    }

    public static void copyDirectory(File file, File file2) {
        if (file.exists()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    if (file3.isDirectory()) {
                        copyDirectory(file3, new File(file2, file3.getName()));
                    } else {
                        copyFile(file3, new File(file2, file3.getName()));
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r9, java.io.File r10) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0040, all -> 0x003b }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0040, all -> 0x003b }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = 0
            long r5 = r10.size()     // Catch:{ IOException -> 0x0030, all -> 0x002b }
            r2 = r10
            r7 = r0
            r2.transferTo(r3, r5, r7)     // Catch:{ IOException -> 0x0030, all -> 0x002b }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r10)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            goto L_0x005d
        L_0x002b:
            r2 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x005f
        L_0x0030:
            r2 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x004e
        L_0x0035:
            r2 = move-exception
            r10 = r0
            goto L_0x003e
        L_0x0038:
            r2 = move-exception
            r10 = r0
            goto L_0x0043
        L_0x003b:
            r2 = move-exception
            r9 = r0
            r10 = r9
        L_0x003e:
            r0 = r1
            goto L_0x0048
        L_0x0040:
            r2 = move-exception
            r9 = r0
            r10 = r9
        L_0x0043:
            r0 = r1
            goto L_0x004d
        L_0x0045:
            r2 = move-exception
            r9 = r0
            r10 = r9
        L_0x0048:
            r1 = r10
            goto L_0x005f
        L_0x004a:
            r2 = move-exception
            r9 = r0
            r10 = r9
        L_0x004d:
            r1 = r10
        L_0x004e:
            r2.printStackTrace()     // Catch:{ all -> 0x005e }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r10)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
        L_0x005d:
            return
        L_0x005e:
            r2 = move-exception
        L_0x005f:
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r10)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.face.platform.utils.FileUtils.copyFile(java.io.File, java.io.File):void");
    }

    public static void copyFile(String str, String str2) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                a.a((InputStream) fileInputStream2, new File(str2));
                a.a((Closeable) fileInputStream2);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    a.a((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    a.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                a.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            a.a((Closeable) fileInputStream);
        }
    }

    public static File createCollectDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, "CollectBest");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static void deleteDir(File file, FileFilter fileFilter) {
        deleteDir(file, true, fileFilter);
    }

    public static void deleteDir(File file, FilenameFilter filenameFilter) {
        deleteDir(file, true, filenameFilter);
    }

    public static void deleteDir(File file, boolean z) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static void deleteDir(File file, boolean z, FileFilter fileFilter) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z, fileFilter);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static void deleteDir(File file, boolean z, FilenameFilter filenameFilter) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles(filenameFilter);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z, filenameFilter);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static void deleteDir(String str) {
        deleteDir(new File(str));
    }

    public static boolean deleteFileIfExist(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean deleteFileIfExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void ensureDir(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else {
                return;
            }
        }
        file.mkdirs();
    }

    public static boolean ensureMkdir(File file) {
        if (file == null) {
            return false;
        }
        File file2 = file;
        int i2 = 1;
        while (file2.exists()) {
            file2 = new File(file.getParent(), file.getName() + FileViewerActivity.LEFT_BRACKET + i2 + ")");
            i2++;
        }
        return file2.mkdir();
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file != null && (parentFile = file.getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(lastIndexOf + 1) : "";
    }

    public static String getExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getExtension(new File(str));
    }

    public static String getFileNameWithoutExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf >= 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static String getFileNameWithoutExtensionByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileNameWithoutExtension(new File(str));
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getUserHome() {
        return new File(System.getProperty("user.home"));
    }

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static boolean isFilenameValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !RESERVED_CHARS_PATTERN.matcher(str).find();
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static FileOutputStream openNewFileOutput(File file) {
        deleteFileIfExist(file);
        ensureParent(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static byte[] readAssetFileContent(AssetManager assetManager, String str) {
        Log.i("FileUtil", " try to read asset file :" + str);
        InputStream open = assetManager.open(str);
        int available = open.available();
        byte[] bArr = new byte[available];
        int read = open.read(bArr);
        if (read == available) {
            open.close();
            return bArr;
        }
        throw new IOException("realSize is not equal to size: " + read + " : " + available);
    }

    public static String readAssetFileUtf8String(AssetManager assetManager, String str) {
        try {
            return new String(readAssetFileContent(assetManager, str), Charset.forName("UTF-8"));
        } catch (IOException e2) {
            return "realSize is not equal to size";
        }
    }

    public static Map<String, String> readConfig(File file) {
        HashMap hashMap = new HashMap();
        String readFileText = readFileText(file);
        if (readFileText != null && !TextUtils.isEmpty(readFileText)) {
            for (String trim : readFileText.split("\n")) {
                String trim2 = trim.trim();
                if (!TextUtils.isEmpty(trim2) && !trim2.startsWith("#")) {
                    String[] split = trim2.split("=", 2);
                    if (split.length >= 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    }
                }
            }
        }
        return hashMap;
    }

    public static byte[] readFileBytes(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    a.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a.a((Closeable) fileInputStream2);
                throw th;
            }
            try {
                byte[] b2 = a.b(fileInputStream);
                a.a((Closeable) fileInputStream);
                return b2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                a.a((Closeable) fileInputStream);
                return null;
            }
        }
        return null;
    }

    public static String readFileText(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (existsFile(file)) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    a.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a.a((Closeable) fileInputStream2);
                throw th;
            }
            try {
                String a2 = a.a((InputStream) fileInputStream);
                a.a((Closeable) fileInputStream);
                return a2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                a.a((Closeable) fileInputStream);
                return null;
            }
        }
        return null;
    }

    public static String readFileText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileText(new File(str));
    }

    public static String readFileText(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String a2 = a.a((InputStream) fileInputStream, str2);
                a.a((Closeable) fileInputStream);
                return a2;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    a.a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a.a((Closeable) fileInputStream2);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            a.a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a.a((Closeable) fileInputStream2);
            throw th;
        }
    }

    public static void writeToFile(File file, String str) {
        writeToFile(file, str, false, "utf-8");
    }

    public static void writeToFile(File file, String str, String str2) {
        writeToFile(file, str, false, str2);
    }

    public static void writeToFile(File file, String str, boolean z) {
        writeToFile(file, str, z, "utf-8");
    }

    public static void writeToFile(File file, String str, boolean z, String str2) {
        if (file != null && !TextUtils.isEmpty(str)) {
            ensureParent(file);
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, z), str2);
                try {
                    outputStreamWriter2.write(str);
                    a.a((Closeable) outputStreamWriter2);
                } catch (IOException e2) {
                    e = e2;
                    outputStreamWriter = outputStreamWriter2;
                    try {
                        e.printStackTrace();
                        a.a((Closeable) outputStreamWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        a.a((Closeable) outputStreamWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = outputStreamWriter2;
                    a.a((Closeable) outputStreamWriter);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                a.a((Closeable) outputStreamWriter);
            }
        }
    }

    public static final void writeToFile(File file, byte[] bArr) {
        if (file != null && bArr != null) {
            ensureParent(file);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    a.a((Closeable) fileOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        a.a((Closeable) fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        a.a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    a.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                a.a((Closeable) fileOutputStream);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFileNio(java.io.File r9, byte[] r10) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            java.nio.channels.ReadableByteChannel r1 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            java.nio.channels.FileChannel r0 = r8.getChannel()     // Catch:{ IOException -> 0x002a, all -> 0x0026 }
            r4 = 0
            int r9 = r10.length     // Catch:{ IOException -> 0x002a, all -> 0x0026 }
            long r6 = (long) r9     // Catch:{ IOException -> 0x002a, all -> 0x0026 }
            r2 = r0
            r3 = r1
            r2.transferFrom(r3, r4, r6)     // Catch:{ IOException -> 0x002a, all -> 0x0026 }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r8)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            goto L_0x0047
        L_0x0026:
            r9 = move-exception
            r10 = r0
            r0 = r8
            goto L_0x0049
        L_0x002a:
            r9 = move-exception
            r10 = r0
            r0 = r8
            goto L_0x003b
        L_0x002e:
            r9 = move-exception
            r10 = r0
            goto L_0x0049
        L_0x0031:
            r9 = move-exception
            r10 = r0
            goto L_0x003b
        L_0x0034:
            r9 = move-exception
            r10 = r0
            r1 = r10
            goto L_0x0049
        L_0x0038:
            r9 = move-exception
            r10 = r0
            r1 = r10
        L_0x003b:
            r9.printStackTrace()     // Catch:{ all -> 0x0048 }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r10)
        L_0x0047:
            return
        L_0x0048:
            r9 = move-exception
        L_0x0049:
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.face.platform.utils.FileUtils.writeToFileNio(java.io.File, byte[]):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFileNio(java.io.InputStream r9, java.io.File r10) {
        /*
            r0 = 0
            int r1 = r9.available()     // Catch:{ IOException -> 0x0036, all -> 0x0032 }
            java.nio.channels.ReadableByteChannel r9 = java.nio.channels.Channels.newChannel(r9)     // Catch:{ IOException -> 0x0036, all -> 0x0032 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r8.<init>(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            java.nio.channels.FileChannel r0 = r8.getChannel()     // Catch:{ IOException -> 0x0028, all -> 0x0024 }
            r4 = 0
            long r6 = (long) r1     // Catch:{ IOException -> 0x0028, all -> 0x0024 }
            r2 = r0
            r3 = r9
            r2.transferFrom(r3, r4, r6)     // Catch:{ IOException -> 0x0028, all -> 0x0024 }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r8)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            goto L_0x0045
        L_0x0024:
            r10 = move-exception
            r1 = r0
            r0 = r8
            goto L_0x0047
        L_0x0028:
            r10 = move-exception
            r1 = r0
            r0 = r8
            goto L_0x0039
        L_0x002c:
            r10 = move-exception
            r1 = r0
            goto L_0x0047
        L_0x002f:
            r10 = move-exception
            r1 = r0
            goto L_0x0039
        L_0x0032:
            r10 = move-exception
            r9 = r0
            r1 = r9
            goto L_0x0047
        L_0x0036:
            r10 = move-exception
            r9 = r0
            r1 = r9
        L_0x0039:
            r10.printStackTrace()     // Catch:{ all -> 0x0046 }
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
        L_0x0045:
            return
        L_0x0046:
            r10 = move-exception
        L_0x0047:
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r0)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r9)
            com.baidu.pass.face.platform.utils.a.a((java.io.Closeable) r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.face.platform.utils.FileUtils.writeToFileNio(java.io.InputStream, java.io.File):void");
    }
}
