package com.baidu.android.util.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import fe.fe.ddd.i.qw.qw;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class FileUtils {
    public static final int BUFFER_SIZE = 1024;
    public static final boolean DEBUG = false;
    public static final String EXTERNAL_STORAGE_DIRECTORY = "/baidu";
    public static final String FILE_SCHEMA = "file://";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static int FS_BLOCK_SIZE = 0;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;
    public static final String SEARCHBOX_FOLDER = "searchbox";
    public static final String TAG = "FileUtils";
    public static final String UNKNOW = "未知";
    public static final int UNZIP_BUFFER = 2048;
    public static String sCacheDir;

    public static boolean cache(Context context, String str, String str2, int i2) {
        return cache(context, str, str2.getBytes(), i2);
    }

    public static long copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        long j = 0;
        if (file == null || file2 == null || !file.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) fileOutputStream);
                throw th;
            }
            try {
                j = copyStream(fileInputStream2, fileOutputStream);
                Closeables.closeSafely((Closeable) fileInputStream2);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) fileOutputStream);
                return j;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            e.printStackTrace();
            Closeables.closeSafely((Closeable) fileInputStream);
            Closeables.closeSafely((Closeable) fileOutputStream);
            return j;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            Closeables.closeSafely((Closeable) fileInputStream);
            Closeables.closeSafely((Closeable) fileOutputStream);
            throw th;
        }
        Closeables.closeSafely((Closeable) fileOutputStream);
        return j;
    }

    @Deprecated
    public static long copyFile(File file, File file2) {
        return copy(file, file2);
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream);
    }

    public static boolean createFileSafely(File file) {
        if (file != null && !file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                return file.createNewFile();
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Deprecated
    public static boolean createNewFileSafely(File file) {
        return createFileSafely(file);
    }

    public static boolean deleteCache(Context context, String str) {
        try {
            return context.deleteFile(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return deleteFile(file);
        }
        return false;
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.mkdirs();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean exists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String generateFileSizeText(long j) {
        String str;
        Float f;
        if (j <= 0) {
            return UNKNOW;
        }
        if (j < 1024) {
            return j + "B";
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            f = Float.valueOf(((float) j) / 1024.0f);
            str = "KB";
        } else if (j < 1073741824) {
            f = Float.valueOf(((float) j) / 1048576.0f);
            str = "MB";
        } else {
            f = Float.valueOf(((float) j) / 1.07374182E9f);
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        return decimalFormat.format(f) + str;
    }

    @TargetApi(8)
    public static String getCacheDir(@NonNull Context context) {
        if (TextUtils.isEmpty(sCacheDir)) {
            sCacheDir = getDeviceCacheDir(context.getApplicationContext());
        }
        return sCacheDir;
    }

    public static String getDeviceCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getFilesDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return null;
    }

    public static long getDirectorySize(File file) throws IOException {
        long j;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        int length = listFiles.length;
        long j2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (listFiles[i2].isDirectory()) {
                j = getDirectorySize(listFiles[i2]);
            } else {
                j = listFiles[i2].length();
            }
            j2 += j;
        }
        return j2;
    }

    public static int getFSBlockSize() {
        if (FS_BLOCK_SIZE == 0) {
            int blockSize = new StatFs("/data").getBlockSize();
            FS_BLOCK_SIZE = blockSize;
            if (blockSize <= 0) {
                FS_BLOCK_SIZE = 8192;
            }
        }
        return FS_BLOCK_SIZE;
    }

    public static String getFileNameFromPath(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        return (lastIndexOf == INVALID_INDEX || length <= lastIndexOf) ? str : str.substring(lastIndexOf + ONE_INCREAMENT, length);
    }

    public static String getFileNameFromUrl(String str) {
        int lastIndexOf;
        String decode = Uri.decode(str);
        if (decode != null) {
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                return decode.substring(lastIndexOf);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileNameNoExt(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001a
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x001a
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x001a
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x001a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.FileUtils.getFileNameNoExt(java.lang.String):java.lang.String");
    }

    public static File getPublicExternalDiretory(String str, String str2) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, EXTERNAL_STORAGE_DIRECTORY + File.separator + str2);
        if (ensureDirectoryExist(file)) {
            return new File(file, str);
        }
        return null;
    }

    @Deprecated
    public static Drawable getSkinDrawableFromBaiduFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() && file.isDirectory()) {
            return null;
        }
        try {
            System.currentTimeMillis();
            Drawable createFromPath = Drawable.createFromPath(str);
            System.currentTimeMillis();
            return createFromPath;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String insertTagInFileName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        StringBuilder sb = new StringBuilder();
        if (lastIndexOf <= -1 || lastIndexOf >= str.length()) {
            return str;
        }
        sb.append(str.substring(0, lastIndexOf));
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append(str.substring(lastIndexOf));
        return sb.toString();
    }

    @Deprecated
    public static boolean isExistFile(String str) {
        return exists(str);
    }

    @Deprecated
    public static boolean isGzipFile(String str) {
        return GZIP.isGzipFile(str);
    }

    @Deprecated
    public static boolean isZipFile(File file) {
        return ZipUtils.isZipFile(file);
    }

    @Deprecated
    public static String readAssetData(Context context, String str) {
        return AssetUtils.readAsset(context, str);
    }

    public static String readCacheData(Context context, String str) {
        try {
            return readInputStream(context.openFileInput(str));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static String readFileData(File file) {
        try {
            return readInputStream(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static String readInputStream(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb2;
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return "";
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    public static boolean safeDeleteFile(File file) {
        if (file == null) {
            return true;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            String absolutePath = file.getAbsolutePath();
            File file2 = new File(absolutePath);
            long currentTimeMillis = System.currentTimeMillis();
            File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
            file2.renameTo(file3);
            return file3.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File saveCacheFile(Context context, byte[] bArr, String str) {
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getCacheDir(), str);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        Closeables.closeSafely((Closeable) byteArrayInputStream);
        return file;
    }

    public static boolean saveFile(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        saveFileCommon(str.getBytes(), file);
        return true;
    }

    public static void saveFileCommon(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        Closeables.closeSafely((Closeable) byteArrayInputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x001b A[SYNTHETIC, Splitter:B:16:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0026 A[SYNTHETIC, Splitter:B:21:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveToFile(java.io.InputStream r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0015 }
            r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0015 }
            copyStream(r2, r1)     // Catch:{ FileNotFoundException -> 0x0010, all -> 0x000d }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x000d:
            r2 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0010:
            r2 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0013:
            r2 = move-exception
            goto L_0x0024
        L_0x0015:
            r2 = move-exception
        L_0x0016:
            r2.printStackTrace()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0023:
            return
        L_0x0024:
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.FileUtils.saveToFile(java.io.InputStream, java.io.File):void");
    }

    public static boolean saveToFileWithReturn(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return saveToFileWithReturn((InputStream) new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static void saveToGzip(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && bArr.length > 0 && file != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file, false));
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    while (true) {
                        try {
                            int read = byteArrayInputStream.read(bArr2, 0, 1024);
                            if (read <= 0) {
                                break;
                            }
                            gZIPOutputStream2.write(bArr2, 0, read);
                        } catch (IOException e) {
                            e = e;
                            gZIPOutputStream = gZIPOutputStream2;
                            try {
                                e.printStackTrace();
                                Closeables.closeSafely((Closeable) gZIPOutputStream);
                                Closeables.closeSafely((Closeable) byteArrayInputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                Closeables.closeSafely((Closeable) gZIPOutputStream);
                                Closeables.closeSafely((Closeable) byteArrayInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPOutputStream = gZIPOutputStream2;
                            Closeables.closeSafely((Closeable) gZIPOutputStream);
                            Closeables.closeSafely((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    }
                    gZIPOutputStream2.finish();
                    Closeables.closeSafely((Closeable) gZIPOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    byteArrayInputStream = null;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) gZIPOutputStream);
                    Closeables.closeSafely((Closeable) byteArrayInputStream);
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayInputStream = null;
                    gZIPOutputStream = gZIPOutputStream2;
                    Closeables.closeSafely((Closeable) gZIPOutputStream);
                    Closeables.closeSafely((Closeable) byteArrayInputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayInputStream = null;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) gZIPOutputStream);
                Closeables.closeSafely((Closeable) byteArrayInputStream);
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
                Closeables.closeSafely((Closeable) gZIPOutputStream);
                Closeables.closeSafely((Closeable) byteArrayInputStream);
                throw th;
            }
            Closeables.closeSafely((Closeable) byteArrayInputStream);
        }
    }

    @Deprecated
    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase(Locale.getDefault());
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    @Deprecated
    public static boolean unGzipFile(File file, File file2) {
        GZIPInputStream gZIPInputStream;
        FileOutputStream fileOutputStream;
        if (file == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                gZIPInputStream = new GZIPInputStream(fileInputStream2);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception unused) {
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) gZIPInputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) gZIPInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = gZIPInputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            Closeables.closeSafely((Closeable) fileInputStream2);
                            Closeables.closeSafely((Closeable) fileOutputStream);
                            Closeables.closeSafely((Closeable) gZIPInputStream);
                            return true;
                        }
                    }
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) gZIPInputStream);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    Closeables.closeSafely((Closeable) gZIPInputStream);
                    throw th;
                }
            } catch (Exception unused3) {
                gZIPInputStream = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) fileOutputStream);
                Closeables.closeSafely((Closeable) gZIPInputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) fileOutputStream);
                Closeables.closeSafely((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Exception unused4) {
            gZIPInputStream = null;
            fileOutputStream = null;
            Closeables.closeSafely((Closeable) fileInputStream);
            Closeables.closeSafely((Closeable) fileOutputStream);
            Closeables.closeSafely((Closeable) gZIPInputStream);
            return false;
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
            fileOutputStream = null;
            Closeables.closeSafely((Closeable) fileInputStream);
            Closeables.closeSafely((Closeable) fileOutputStream);
            Closeables.closeSafely((Closeable) gZIPInputStream);
            throw th;
        }
    }

    @Deprecated
    public static boolean unzipFile(String str, String str2) {
        return ZipUtils.unzipFile(str, str2);
    }

    @Deprecated
    public static boolean unzipFileFromAsset(String str, String str2, Context context) {
        return AssetUtils.unzipFileFromAsset(str, str2, context);
    }

    public static boolean cache(Context context, String str, byte[] bArr, int i2) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, i2);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            z = true;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th2;
        }
        return z;
    }

    @TargetApi(8)
    @Deprecated
    public static String getCacheDir() {
        return getCacheDir(qw.qw());
    }

    public static File getPublicExternalDiretory(String str) {
        return getPublicExternalDiretory(str, SEARCHBOX_FOLDER);
    }

    public static boolean saveFile(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (file.exists() && !z) {
            return false;
        }
        saveFileCommon(str.getBytes(), file);
        return true;
    }

    public static boolean saveToFileWithReturn(InputStream inputStream, File file, boolean z) {
        boolean z2 = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                if (copyStream(inputStream, fileOutputStream2) != 0) {
                    z2 = true;
                }
                Closeables.closeSafely((Closeable) fileOutputStream2);
                return z2;
            } catch (FileNotFoundException unused) {
                fileOutputStream = fileOutputStream2;
                Closeables.closeSafely((Closeable) fileOutputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                Closeables.closeSafely((Closeable) fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            Closeables.closeSafely((Closeable) fileOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            Closeables.closeSafely((Closeable) fileOutputStream);
            throw th;
        }
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return true & file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File deleteFile : listFiles) {
                z &= deleteFile(deleteFile);
            }
        }
        return z & file.delete();
    }

    public static long getDirectorySize(String str) throws IOException {
        long j;
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        int length = listFiles.length;
        long j2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (listFiles[i2].isDirectory()) {
                j = getDirectorySize(listFiles[i2]);
            } else {
                j = listFiles[i2].length();
            }
            j2 += j;
        }
        return j2;
    }

    public static boolean saveFile(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return saveFile(str, new File(str2), z);
    }

    public static File saveFile(Context context, byte[] bArr, String str, String str2) {
        if (context == null || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null && !externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, str2);
        saveFileCommon(bArr, file);
        return file;
    }

    @Deprecated
    public static void saveToFile(String str, File file, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            saveToFile((InputStream) new ByteArrayInputStream(str.getBytes()), file, z);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        if (!(inputStream == null || outputStream == null)) {
            try {
                byte[] bArr = new byte[3072];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += (long) read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x001b A[SYNTHETIC, Splitter:B:16:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0026 A[SYNTHETIC, Splitter:B:21:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveToFile(java.io.InputStream r2, java.io.File r3, boolean r4) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0015 }
            r1.<init>(r3, r4)     // Catch:{ FileNotFoundException -> 0x0015 }
            copyStream(r2, r1)     // Catch:{ FileNotFoundException -> 0x0010, all -> 0x000d }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x000d:
            r2 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0010:
            r2 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0013:
            r2 = move-exception
            goto L_0x0024
        L_0x0015:
            r2 = move-exception
        L_0x0016:
            r2.printStackTrace()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0023:
            return
        L_0x0024:
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.FileUtils.saveToFile(java.io.InputStream, java.io.File, boolean):void");
    }
}
