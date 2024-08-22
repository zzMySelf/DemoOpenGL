package com.baidu.android.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class ZipUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "ZipUtils";

    public static boolean isZipFile(File file) {
        if (!file.exists()) {
            return false;
        }
        byte[] bArr = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                if ("504B0304".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely((Closeable) fileInputStream2);
                    return true;
                }
                Closeables.closeSafely((Closeable) fileInputStream2);
                return false;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            Closeables.closeSafely((Closeable) fileInputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            Closeables.closeSafely((Closeable) fileInputStream);
            throw th;
        }
    }

    public static boolean unzipFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        System.currentTimeMillis();
        if (str == null) {
            return false;
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            FileOutputStream fileOutputStream2 = null;
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.getName().contains("../")) {
                    File file = new File(str2 + "/" + zipEntry.getName());
                    if (!zipEntry.isDirectory()) {
                        if (!file.exists()) {
                            FileUtils.createFileSafely(file);
                        }
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (IOException e) {
                                e = e;
                                bufferedInputStream = bufferedInputStream2;
                                try {
                                    e.printStackTrace();
                                    Closeables.closeSafely((Closeable) bufferedOutputStream);
                                    Closeables.closeSafely((Closeable) bufferedInputStream);
                                    Closeables.closeSafely((Closeable) fileOutputStream2);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    Closeables.closeSafely((Closeable) bufferedOutputStream);
                                    Closeables.closeSafely((Closeable) bufferedInputStream);
                                    Closeables.closeSafely((Closeable) fileOutputStream2);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedInputStream = bufferedInputStream2;
                                Closeables.closeSafely((Closeable) bufferedOutputStream);
                                Closeables.closeSafely((Closeable) bufferedInputStream);
                                Closeables.closeSafely((Closeable) fileOutputStream2);
                                throw th;
                            }
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, FileUtils.getFSBlockSize());
                                try {
                                    byte[] bArr = new byte[FileUtils.getFSBlockSize()];
                                    while (true) {
                                        int read = bufferedInputStream2.read(bArr, 0, FileUtils.getFSBlockSize());
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    }
                                    bufferedOutputStream2.flush();
                                    Closeables.closeSafely((Closeable) bufferedOutputStream2);
                                    Closeables.closeSafely((Closeable) bufferedInputStream2);
                                    Closeables.closeSafely((Closeable) fileOutputStream);
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream2 = fileOutputStream;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                    e.printStackTrace();
                                    Closeables.closeSafely((Closeable) bufferedOutputStream);
                                    Closeables.closeSafely((Closeable) bufferedInputStream);
                                    Closeables.closeSafely((Closeable) fileOutputStream2);
                                    return false;
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileOutputStream2 = fileOutputStream;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                    Closeables.closeSafely((Closeable) bufferedOutputStream);
                                    Closeables.closeSafely((Closeable) bufferedInputStream);
                                    Closeables.closeSafely((Closeable) fileOutputStream2);
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream2 = fileOutputStream;
                                bufferedInputStream = bufferedInputStream2;
                                e.printStackTrace();
                                Closeables.closeSafely((Closeable) bufferedOutputStream);
                                Closeables.closeSafely((Closeable) bufferedInputStream);
                                Closeables.closeSafely((Closeable) fileOutputStream2);
                                return false;
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream2 = fileOutputStream;
                                bufferedInputStream = bufferedInputStream2;
                                Closeables.closeSafely((Closeable) bufferedOutputStream);
                                Closeables.closeSafely((Closeable) bufferedInputStream);
                                Closeables.closeSafely((Closeable) fileOutputStream2);
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            Closeables.closeSafely((Closeable) bufferedOutputStream);
                            Closeables.closeSafely((Closeable) bufferedInputStream);
                            Closeables.closeSafely((Closeable) fileOutputStream2);
                            return false;
                        }
                    } else if (!file.exists()) {
                        file.mkdirs();
                    }
                }
            }
            zipFile.close();
            System.currentTimeMillis();
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        } finally {
            System.currentTimeMillis();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A[SYNTHETIC, Splitter:B:36:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zip(java.lang.String r3, java.lang.String r4) throws java.io.IOException {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            if (r1 != 0) goto L_0x0049
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            if (r1 == 0) goto L_0x000e
            goto L_0x0049
        L_0x000e:
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            java.util.zip.ZipOutputStream r3 = new java.util.zip.ZipOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0056, all -> 0x004a }
            boolean r0 = r4.isFile()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x002e
            zipFileOrDirectory(r3, r4, r1)     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            goto L_0x0040
        L_0x002e:
            java.io.File[] r4 = r4.listFiles()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            if (r4 == 0) goto L_0x0040
            r0 = 0
        L_0x0035:
            int r2 = r4.length     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            if (r0 >= r2) goto L_0x0040
            r2 = r4[r0]     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            zipFileOrDirectory(r3, r2, r1)     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            int r0 = r0 + 1
            goto L_0x0035
        L_0x0040:
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x0044:
            r4 = move-exception
            r0 = r3
            goto L_0x004b
        L_0x0047:
            r0 = r3
            goto L_0x0057
        L_0x0049:
            return
        L_0x004a:
            r4 = move-exception
        L_0x004b:
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0055:
            throw r4
        L_0x0056:
        L_0x0057:
            if (r0 == 0) goto L_0x0061
            r0.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.ZipUtils.zip(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[SYNTHETIC, Splitter:B:28:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f A[SYNTHETIC, Splitter:B:35:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zipFileOrDirectory(java.util.zip.ZipOutputStream r6, java.io.File r7, java.lang.String r8) throws java.io.IOException {
        /*
            r0 = 0
            boolean r1 = r7.isDirectory()     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            r2 = 0
            if (r1 != 0) goto L_0x0041
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            r3.<init>(r7)     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.util.zip.ZipEntry r0 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.<init>()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.append(r8)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            java.lang.String r7 = r7.getName()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.append(r7)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r0.<init>(r7)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r6.putNextEntry(r0)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
        L_0x002c:
            int r7 = r3.read(r1)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r8 = -1
            if (r7 == r8) goto L_0x0037
            r6.write(r1, r2, r7)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            goto L_0x002c
        L_0x0037:
            r6.closeEntry()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r0 = r3
            goto L_0x006a
        L_0x003c:
            r6 = move-exception
            r0 = r3
            goto L_0x0071
        L_0x003f:
            r0 = r3
            goto L_0x007d
        L_0x0041:
            java.io.File[] r1 = r7.listFiles()     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            if (r1 == 0) goto L_0x006a
        L_0x0047:
            int r3 = r1.length     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            if (r2 >= r3) goto L_0x006a
            r3 = r1[r2]     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            r4.<init>()     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            r4.append(r8)     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.lang.String r5 = r7.getName()     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            r4.append(r5)     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            zipFileOrDirectory(r6, r3, r4)     // Catch:{ IOException -> 0x007c, all -> 0x0070 }
            int r2 = r2 + 1
            goto L_0x0047
        L_0x006a:
            if (r0 == 0) goto L_0x0087
            r0.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0070:
            r6 = move-exception
        L_0x0071:
            if (r0 == 0) goto L_0x007b
            r0.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007b:
            throw r6
        L_0x007c:
        L_0x007d:
            if (r0 == 0) goto L_0x0087
            r0.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.ZipUtils.zipFileOrDirectory(java.util.zip.ZipOutputStream, java.io.File, java.lang.String):void");
    }

    @Deprecated
    public static void zip(File file, List<File> list) throws IOException {
        zip(list, file);
    }

    public static void zip(List<File> list, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        if (file != null && file.exists() && list != null && list.size() != 0) {
            FileInputStream fileInputStream = null;
            try {
                byte[] bArr = new byte[4096];
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                try {
                    zipOutputStream.setComment(file.getName());
                    for (File next : list) {
                        if (next.canRead()) {
                            FileInputStream fileInputStream2 = new FileInputStream(next);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(next.getName()));
                                while (true) {
                                    int read = fileInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                fileInputStream2.close();
                                fileInputStream = fileInputStream2;
                            } catch (FileNotFoundException unused) {
                                fileInputStream = fileInputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                Closeables.closeSafely((Closeable) fileInputStream);
                                Closeables.closeSafely((Closeable) zipOutputStream);
                                throw th;
                            }
                        }
                    }
                    zipOutputStream.flush();
                    zipOutputStream.close();
                } catch (FileNotFoundException unused2) {
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) zipOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
                zipOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                zipOutputStream = null;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) zipOutputStream);
                throw th;
            }
            Closeables.closeSafely((Closeable) fileInputStream);
            Closeables.closeSafely((Closeable) zipOutputStream);
        }
    }
}
