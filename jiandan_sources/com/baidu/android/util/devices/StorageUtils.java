package com.baidu.android.util.devices;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.baidu.android.common.others.java.ReflectionUtils;
import fe.fe.ddd.i.qw.qw;
import java.io.File;
import java.util.Locale;

public final class StorageUtils {
    public static boolean DEBUG = false;
    public static final int DIVIDER = 1024;
    public static final int ERROR = -1;
    public static final String TAG = "StorageUtils";

    public static class StorageInfo {
        public final int mDisplayNumber;
        public final boolean mInternal;
        public final String mPath;
        public final boolean mReadonly;

        public StorageInfo(String str, boolean z, boolean z2, int i2) {
            this.mPath = str;
            this.mInternal = z;
            this.mReadonly = z2;
            this.mDisplayNumber = i2;
        }

        public String getDisplayName() {
            StringBuilder sb = new StringBuilder();
            if (this.mInternal) {
                sb.append("Internal SD card");
            } else if (this.mDisplayNumber > 1) {
                sb.append("SD card " + this.mDisplayNumber);
            } else {
                sb.append("SD card" + this.mDisplayNumber);
            }
            if (this.mReadonly) {
                sb.append(" (Read only)");
            }
            return sb.toString();
        }
    }

    public static boolean externalMemoryAvailable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            if (DEBUG) {
                e.getMessage();
            }
            return false;
        }
    }

    public static String formatSize(long j) {
        double d;
        double d2 = (double) j;
        String str = "KB";
        if (d2 >= 1024.0d) {
            d = d2 / 1024.0d;
            if (d >= 1024.0d) {
                d /= 1024.0d;
                if (d >= 1024.0d) {
                    d /= 1024.0d;
                    str = "GB";
                } else {
                    str = "MB";
                }
            }
        } else {
            d = 0.0d;
        }
        return String.format(Locale.CHINESE, "%.2f%s", new Object[]{Double.valueOf(d), str});
    }

    public static long getAvailableExternalMemorySize() {
        long j;
        long j2;
        if (externalMemoryAvailable()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    j2 = statFs.getBlockSizeLong();
                    j = statFs.getAvailableBlocksLong();
                } else {
                    j2 = (long) statFs.getBlockSize();
                    j = (long) statFs.getAvailableBlocks();
                }
                return j * j2;
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.getMessage();
                }
            }
        }
        return -1;
    }

    public static long getAvailableInternalMemorySize() {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j = statFs.getBlockSizeLong();
                j2 = statFs.getAvailableBlocksLong();
            } else {
                j = (long) statFs.getBlockSize();
                j2 = (long) statFs.getAvailableBlocks();
            }
            return j2 * j;
        } catch (IllegalArgumentException e) {
            if (!DEBUG) {
                return -1;
            }
            e.getMessage();
            return -1;
        }
    }

    public static long getAvailaleMemorySize(String str) {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getBlockSizeLong();
                j = statFs.getAvailableBlocksLong();
            } else {
                j2 = (long) statFs.getBlockSize();
                j = (long) statFs.getAvailableBlocks();
            }
            return j * j2;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0190 A[SYNTHETIC, Splitter:B:83:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b A[SYNTHETIC, Splitter:B:90:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a9 A[SYNTHETIC, Splitter:B:97:0x01a9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:87:0x0196=Splitter:B:87:0x0196, B:80:0x018b=Splitter:B:80:0x018b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.baidu.android.util.devices.StorageUtils.StorageInfo> getStorageList() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            boolean r3 = android.os.Environment.isExternalStorageRemovable()
            r4 = 1
            r3 = r3 ^ r4
            java.lang.String r5 = android.os.Environment.getExternalStorageState()
            java.lang.String r6 = "mounted"
            boolean r6 = r5.equals(r6)
            java.lang.String r7 = "mounted_ro"
            r8 = 0
            if (r6 != 0) goto L_0x0030
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r5 = 0
            goto L_0x0031
        L_0x0030:
            r5 = 1
        L_0x0031:
            java.lang.String r6 = android.os.Environment.getExternalStorageState()
            boolean r6 = r6.equals(r7)
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            java.io.FileReader r11 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            java.lang.String r12 = "/proc/mounts"
            r11.<init>(r12)     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            r10.<init>(r11)     // Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x0189, all -> 0x0185 }
            boolean r11 = DEBUG     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
        L_0x004c:
            java.lang.String r11 = r10.readLine()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r12 = -1
            if (r11 == 0) goto L_0x0147
            boolean r13 = DEBUG     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.util.StringTokenizer r13 = new java.util.StringTokenizer     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r14 = " "
            r13.<init>(r11, r14)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r14 = r13.nextToken()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r15 = r13.nextToken()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r16 = r9.contains(r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r16 == 0) goto L_0x006b
            goto L_0x004c
        L_0x006b:
            r13.nextToken()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r13 = r13.nextToken()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r7 = ","
            java.lang.String[] r7 = r13.split(r7)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r13 = "ro"
            boolean r7 = r7.contains(r13)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r13 = "vfat"
            boolean r13 = r11.contains(r13)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r13 != 0) goto L_0x00ae
            java.lang.String r13 = "/mnt"
            boolean r13 = r11.contains(r13)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r13 == 0) goto L_0x0093
            goto L_0x00ae
        L_0x0093:
            boolean r11 = isFuseStorage(r14, r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 == 0) goto L_0x004c
            r9.add(r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r11 = isPathAccessable(r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 == 0) goto L_0x004c
            com.baidu.android.util.devices.StorageUtils$StorageInfo r11 = new com.baidu.android.util.devices.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            int r12 = r4 + 1
            r11.<init>(r15, r8, r7, r4)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r1.add(r11)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            goto L_0x0144
        L_0x00ae:
            boolean r13 = r15.equals(r2)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r13 == 0) goto L_0x00c0
            r9.add(r2)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            com.baidu.android.util.devices.StorageUtils$StorageInfo r11 = new com.baidu.android.util.devices.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r11.<init>(r2, r3, r7, r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r0.put(r14, r11)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            goto L_0x004c
        L_0x00c0:
            java.lang.String r12 = "/dev/block/vold"
            boolean r12 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 == 0) goto L_0x0104
            java.lang.String r12 = "/mnt/secure"
            boolean r12 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = "/mnt/asec"
            boolean r12 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = "/mnt/obb"
            boolean r12 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = "/dev/mapper"
            boolean r12 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = "tmpfs"
            boolean r11 = r11.contains(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 != 0) goto L_0x004c
            r9.add(r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r11 = r0.containsKey(r14)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 != 0) goto L_0x004c
            com.baidu.android.util.devices.StorageUtils$StorageInfo r11 = new com.baidu.android.util.devices.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            int r12 = r4 + 1
            r11.<init>(r15, r8, r7, r4)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r0.put(r14, r11)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            goto L_0x0144
        L_0x0104:
            boolean r11 = r9.contains(r14)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 == 0) goto L_0x004c
            java.util.Set r11 = r0.keySet()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
        L_0x0112:
            boolean r12 = r11.hasNext()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r12 == 0) goto L_0x012d
            java.lang.Object r12 = r11.next()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.Object r13 = r0.get(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            com.baidu.android.util.devices.StorageUtils$StorageInfo r13 = (com.baidu.android.util.devices.StorageUtils.StorageInfo) r13     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r13 = r13.mPath     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r13 = android.text.TextUtils.equals(r13, r14)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r13 == 0) goto L_0x0112
            goto L_0x012e
        L_0x012d:
            r12 = 0
        L_0x012e:
            r0.remove(r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r9.add(r15)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r11 = r0.containsKey(r14)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r11 != 0) goto L_0x004c
            com.baidu.android.util.devices.StorageUtils$StorageInfo r11 = new com.baidu.android.util.devices.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            int r12 = r4 + 1
            r11.<init>(r15, r8, r7, r4)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r0.put(r14, r11)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
        L_0x0144:
            r4 = r12
            goto L_0x004c
        L_0x0147:
            java.util.Collection r0 = r0.values()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
        L_0x014f:
            boolean r4 = r0.hasNext()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r4 == 0) goto L_0x0167
            java.lang.Object r4 = r0.next()     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            com.baidu.android.util.devices.StorageUtils$StorageInfo r4 = (com.baidu.android.util.devices.StorageUtils.StorageInfo) r4     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            java.lang.String r7 = r4.mPath     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            boolean r7 = isPathAccessable(r7)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r7 == 0) goto L_0x014f
            r1.add(r4)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            goto L_0x014f
        L_0x0167:
            boolean r0 = r9.contains(r2)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            if (r0 != 0) goto L_0x0177
            if (r5 == 0) goto L_0x0177
            com.baidu.android.util.devices.StorageUtils$StorageInfo r0 = new com.baidu.android.util.devices.StorageUtils$StorageInfo     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r0.<init>(r2, r3, r6, r12)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
            r1.add(r8, r0)     // Catch:{ FileNotFoundException -> 0x0182, IOException -> 0x017f, all -> 0x017b }
        L_0x0177:
            r10.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a4
        L_0x017b:
            r0 = move-exception
            r1 = r0
            r7 = r10
            goto L_0x01a7
        L_0x017f:
            r0 = move-exception
            r7 = r10
            goto L_0x018b
        L_0x0182:
            r0 = move-exception
            r7 = r10
            goto L_0x0196
        L_0x0185:
            r0 = move-exception
            r7 = 0
        L_0x0187:
            r1 = r0
            goto L_0x01a7
        L_0x0189:
            r0 = move-exception
            r7 = 0
        L_0x018b:
            r0.printStackTrace()     // Catch:{ all -> 0x01a5 }
            if (r7 == 0) goto L_0x01a4
            r7.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a4
        L_0x0194:
            r0 = move-exception
            r7 = 0
        L_0x0196:
            r0.printStackTrace()     // Catch:{ all -> 0x01a5 }
            if (r7 == 0) goto L_0x01a4
            r7.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a4
        L_0x019f:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01a4:
            return r1
        L_0x01a5:
            r0 = move-exception
            goto L_0x0187
        L_0x01a7:
            if (r7 == 0) goto L_0x01b2
            r7.close()     // Catch:{ IOException -> 0x01ad }
            goto L_0x01b2
        L_0x01ad:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01b2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.devices.StorageUtils.getStorageList():java.util.List");
    }

    public static long getTotalExternalMemorySize() {
        long j;
        long j2;
        if (externalMemoryAvailable()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    j2 = statFs.getBlockSizeLong();
                    j = statFs.getBlockCountLong();
                } else {
                    j2 = (long) statFs.getBlockSize();
                    j = (long) statFs.getBlockCount();
                }
                return j * j2;
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.getMessage();
                }
            }
        }
        return -1;
    }

    public static long getTotalInternalMemorySize() {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j = statFs.getBlockSizeLong();
                j2 = statFs.getBlockCountLong();
            } else {
                j = (long) statFs.getBlockSize();
                j2 = (long) statFs.getBlockCount();
            }
            return j2 * j;
        } catch (IllegalArgumentException e) {
            if (!DEBUG) {
                return -1;
            }
            e.getMessage();
            return -1;
        }
    }

    public static long getTotalMemorySize(String str) {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(str);
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    j = statFs.getBlockSizeLong();
                    j2 = statFs.getBlockCountLong();
                } else {
                    j = (long) statFs.getBlockSize();
                    j2 = (long) statFs.getBlockCount();
                }
                return j2 * j;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return 0;
            }
        } catch (IllegalArgumentException e2) {
            if (DEBUG) {
                e2.getMessage();
            }
            return 0;
        }
    }

    @Deprecated
    public static Object[] getVolumeList() {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) qw.qw().getSystemService("storage"), "getVolumeList", (Class<?>[]) null, (Object[]) null);
        if (invokeHideMethodForObject != null) {
            return (Object[]) invokeHideMethodForObject;
        }
        return null;
    }

    @Deprecated
    public static String getVolumePath(Object obj) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject(obj, "getPath", (Class<?>[]) null, (Object[]) null);
        return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
    }

    @Deprecated
    public static String getVolumeState(String str) {
        Object invokeHideMethodForObject = ReflectionUtils.invokeHideMethodForObject((StorageManager) qw.qw().getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str});
        return invokeHideMethodForObject != null ? (String) invokeHideMethodForObject : "";
    }

    public static boolean isEnoughSpace(File file, long j) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = (long) statFs.getBlockSize();
            long availableBlocks = (long) statFs.getAvailableBlocks();
            if (DEBUG) {
                "Available size:" + (blockSize * availableBlocks);
            }
            if (blockSize * availableBlocks > j) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            if (DEBUG) {
                e.getMessage();
            }
            return false;
        }
    }

    public static boolean isFuseStorage(String str, String str2) {
        if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
            return false;
        }
        if (str2.startsWith("/storage/")) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 19 || str2.startsWith("/mnt/") || str2.startsWith("/data/")) {
            return false;
        }
        return true;
    }

    public static boolean isPathAccessable(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).canRead();
        }
        return false;
    }
}
