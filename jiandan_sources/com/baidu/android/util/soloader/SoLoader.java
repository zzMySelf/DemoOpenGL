package com.baidu.android.util.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.util.soloader.SoUtils;
import com.baidu.searchbox.NoProGuard;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class SoLoader implements NoProGuard {
    public static final boolean DEBUG = false;
    public static final String TAG = "SoLoader";
    public static Map<String, WeakReference<Lock>> releaseSoLockMap = new ConcurrentHashMap();
    public static final Set<String> sLoadedLibraries = Collections.synchronizedSet(new HashSet());
    public static final List<File> soSources = new ArrayList();
    public StringBuilder sb = new StringBuilder();

    private void addLocalSoLibraryDirectory(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(getNativeLibraryDir(context)));
        arrayList.add(new File(context.getFilesDir(), SoUtils.PRE));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (!soSources.contains(arrayList.get(i2))) {
                soSources.add(arrayList.get(i2));
            }
        }
    }

    private void addSysSoLibraryDirectory() {
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str == null) {
            str = "/vendor/lib:/system/lib";
        }
        String[] split = str.split(":");
        for (String file : split) {
            File file2 = new File(file);
            if (!soSources.contains(file2)) {
                soSources.add(file2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A[SYNTHETIC, Splitter:B:39:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0089 A[SYNTHETIC, Splitter:B:51:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0093 A[SYNTHETIC, Splitter:B:56:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009a A[SYNTHETIC, Splitter:B:61:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00a4 A[SYNTHETIC, Splitter:B:66:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean executeRelease(android.content.Context r7, java.util.zip.ZipFile r8, java.lang.String r9, java.lang.String r10, long r11) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r7 = getReleaseSoFilePath(r7)
            boolean r1 = r7.exists()
            if (r1 != 0) goto L_0x0011
            r7.mkdirs()
        L_0x0011:
            java.io.File r1 = new java.io.File
            r1.<init>(r7, r9)
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            r4.<init>()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            r4.append(r9)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            java.lang.String r5 = ".lock"
            r4.append(r5)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            r3.<init>(r7, r4)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            if (r4 != 0) goto L_0x003b
            r3.createNewFile()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
        L_0x003b:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0052 }
            java.lang.String r5 = "rw"
            r4.<init>(r3, r5)     // Catch:{ FileNotFoundException -> 0x0052 }
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch:{ FileNotFoundException -> 0x0052 }
            java.nio.channels.FileLock r2 = r3.lock()     // Catch:{ IOException -> 0x004b }
            goto L_0x0057
        L_0x004b:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0050 }
            goto L_0x0057
        L_0x0050:
            r4 = move-exception
            goto L_0x0054
        L_0x0052:
            r4 = move-exception
            r3 = r2
        L_0x0054:
            r4.printStackTrace()     // Catch:{ Exception -> 0x007d }
        L_0x0057:
            if (r2 == 0) goto L_0x0068
            boolean r4 = r2.isValid()     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x0068
            boolean r0 = r6.releaseFileFromApk(r8, r1, r10)     // Catch:{ Exception -> 0x007d }
            if (r0 == 0) goto L_0x0068
            r6.saveCrc(r11, r9, r7)     // Catch:{ Exception -> 0x007d }
        L_0x0068:
            if (r2 == 0) goto L_0x0072
            r2.release()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0072:
            if (r3 == 0) goto L_0x0096
            r3.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0096
        L_0x0078:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0096
        L_0x007d:
            r7 = move-exception
            goto L_0x0084
        L_0x007f:
            r7 = move-exception
            r3 = r2
            goto L_0x0098
        L_0x0082:
            r7 = move-exception
            r3 = r2
        L_0x0084:
            r7.printStackTrace()     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0091
            r2.release()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0091:
            if (r3 == 0) goto L_0x0096
            r3.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0096:
            return r0
        L_0x0097:
            r7 = move-exception
        L_0x0098:
            if (r2 == 0) goto L_0x00a2
            r2.release()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a2:
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ac:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoLoader.executeRelease(android.content.Context, java.util.zip.ZipFile, java.lang.String, java.lang.String, long):boolean");
    }

    private String getCrcFileName(String str) {
        int lastIndexOf = str.lastIndexOf(IStringUtil.CURRENT_PATH);
        if (lastIndexOf != -1) {
            str = str.substring(0, lastIndexOf);
        }
        return str + "_crc";
    }

    public static synchronized Lock getLock(String str) {
        Lock lock;
        synchronized (SoLoader.class) {
            WeakReference weakReference = releaseSoLockMap.get(str);
            if (weakReference == null || (lock = (Lock) weakReference.get()) == null) {
                lock = new ReentrantLock();
                releaseSoLockMap.put(str, new WeakReference(lock));
            }
        }
        return lock;
    }

    private String getNativeLibraryDir(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.nativeLibraryDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static File getReleaseSoFilePath(Context context) {
        return new File(context.getFilesDir(), SoUtils.PRE);
    }

    private long getSoCrc(ZipFile zipFile, String str) {
        if (zipFile == null) {
            return 0;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                return entry.getCrc();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private long getSoSize(ZipFile zipFile, String str) {
        if (zipFile == null) {
            return 0;
        }
        try {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                return entry.getSize();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private void initSoSource(Context context) {
        addSysSoLibraryDirectory();
        addLocalSoLibraryDirectory(context);
    }

    public static boolean isSoLoadedSucc(String str) {
        return sLoadedLibraries.contains(str);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC, Splitter:B:24:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[SYNTHETIC, Splitter:B:36:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isValidFile(java.lang.String r6, long r7, long r9) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            if (r6 == 0) goto L_0x0076
            java.lang.String r6 = r0.getName()
            java.lang.String r6 = r5.getCrcFileName(r6)
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.io.File r3 = r0.getParentFile()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            boolean r6 = r2.exists()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            if (r6 == 0) goto L_0x0037
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.lang.String r1 = r6.readLine()     // Catch:{ Exception -> 0x0035 }
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x0038
        L_0x0035:
            r2 = move-exception
            goto L_0x0048
        L_0x0037:
            r6 = r1
        L_0x0038:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0042:
            r1 = r6
            goto L_0x0055
        L_0x0044:
            r7 = move-exception
            goto L_0x006b
        L_0x0046:
            r2 = move-exception
            r6 = r1
        L_0x0048:
            r2.printStackTrace()     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0055
            r6.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0055:
            java.lang.String r6 = java.lang.String.valueOf(r7)
            boolean r6 = android.text.TextUtils.equals(r6, r1)
            if (r6 == 0) goto L_0x0076
            long r6 = r0.length()
            int r8 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0076
            r6 = 1
            return r6
        L_0x0069:
            r7 = move-exception
            r1 = r6
        L_0x006b:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0075:
            throw r7
        L_0x0076:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoLoader.isValidFile(java.lang.String, long, long):boolean");
    }

    public static void load(Context context, String str) {
        if (!sLoadedLibraries.contains(str)) {
            load(context, str, (ICallingSoLoader) null);
        }
    }

    private boolean loadFromNativeLibDir(Context context, ICallingSoLoader iCallingSoLoader, String str, long j, String str2) {
        File file = new File(getNativeLibraryDir(context), str);
        return file.exists() && file.length() == j && load(iCallingSoLoader, file.getAbsolutePath(), SoUtils.SOLOG.SO_NATIVE_LIB_LOAD);
    }

    private boolean loadFromReleaseApk(Context context, ICallingSoLoader iCallingSoLoader, String str, ZipFile zipFile, String str2, long j) {
        String absolutePath = new File(getReleaseSoFilePath(context), str).getAbsolutePath();
        Lock lock = getLock(str);
        lock.lock();
        try {
            long soCrc = getSoCrc(zipFile, str2);
            if (loadFromReleaseCache(iCallingSoLoader, absolutePath, soCrc, j)) {
                lock.unlock();
                return true;
            }
            if (executeRelease(context, zipFile, str, str2, soCrc) && loadFromReleaseCache(iCallingSoLoader, absolutePath, soCrc, j)) {
                lock.unlock();
                return true;
            }
            lock.unlock();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    private boolean loadFromReleaseCache(ICallingSoLoader iCallingSoLoader, String str, long j, long j2) {
        return isValidFile(str, j, j2) && load(iCallingSoLoader, str, SoUtils.SOLOG.SO_RELEASE_LIB_LOAD);
    }

    private boolean loadInternal(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        } else if (loadLibrary(iCallingSoLoader, str, SoUtils.SOLOG.SO_LOAD_LIBRARY)) {
            return true;
        } else {
            return loadInternalFromLocal(context, str, iCallingSoLoader);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[SYNTHETIC, Splitter:B:14:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[SYNTHETIC, Splitter:B:22:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0 A[SYNTHETIC, Splitter:B:54:0x00c0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean loadInternalFromLocal(android.content.Context r16, java.lang.String r17, com.baidu.android.util.soloader.ICallingSoLoader r18) {
        /*
            r15 = this;
            r9 = r15
            java.lang.String r8 = com.baidu.android.util.soloader.SoUtils.getFullName(r17)
            r1 = 0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00bc }
            android.content.pm.ApplicationInfo r2 = r16.getApplicationInfo()     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = r2.sourceDir     // Catch:{ all -> 0x00bc }
            r0.<init>(r2)     // Catch:{ all -> 0x00bc }
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x0026, IOException -> 0x0018 }
            r2.<init>(r0)     // Catch:{ ZipException -> 0x0026, IOException -> 0x0018 }
            r10 = r2
            goto L_0x0034
        L_0x0018:
            r0 = move-exception
            java.lang.StringBuilder r2 = r9.sb     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x00bc }
            r2.append(r3)     // Catch:{ all -> 0x00bc }
            r0.printStackTrace()     // Catch:{ all -> 0x00bc }
            goto L_0x0033
        L_0x0026:
            r0 = move-exception
            java.lang.StringBuilder r2 = r9.sb     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x00bc }
            r2.append(r3)     // Catch:{ all -> 0x00bc }
            r0.printStackTrace()     // Catch:{ all -> 0x00bc }
        L_0x0033:
            r10 = r1
        L_0x0034:
            r11 = 0
            if (r10 != 0) goto L_0x004c
            java.lang.StringBuilder r0 = r9.sb     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b8 }
            com.baidu.android.util.soloader.SoUtils.sendLog(r0)     // Catch:{ all -> 0x00b8 }
            if (r10 == 0) goto L_0x004b
            r10.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004b
        L_0x0046:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x004b:
            return r11
        L_0x004c:
            boolean r0 = com.baidu.android.util.soloader.SoUtils.is64Bit()     // Catch:{ all -> 0x00b8 }
            r12 = 1
            r0 = r0 ^ r12
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String[] r2 = com.baidu.android.util.soloader.SoUtils.uris     // Catch:{ all -> 0x00b8 }
            r0 = r2[r0]     // Catch:{ all -> 0x00b8 }
            r1.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = java.io.File.separator     // Catch:{ all -> 0x00b8 }
            r1.append(r0)     // Catch:{ all -> 0x00b8 }
            r1.append(r8)     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00b8 }
            long r13 = r15.getSoSize(r10, r0)     // Catch:{ all -> 0x00b8 }
            r1 = r15
            r2 = r16
            r3 = r18
            r4 = r8
            r5 = r13
            r7 = r0
            boolean r1 = r1.loadFromNativeLibDir(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x0088
            if (r10 == 0) goto L_0x0087
            r10.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0087
        L_0x0082:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0087:
            return r12
        L_0x0088:
            r1 = r15
            r2 = r16
            r3 = r18
            r4 = r8
            r5 = r10
            r6 = r0
            r7 = r13
            boolean r0 = r1.loadFromReleaseApk(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a3
            if (r10 == 0) goto L_0x00a2
            r10.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a2
        L_0x009d:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.StringBuilder r0 = r9.sb     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b8 }
            com.baidu.android.util.soloader.SoUtils.sendLog(r0)     // Catch:{ all -> 0x00b8 }
            if (r10 == 0) goto L_0x00b7
            r10.close()     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00b7
        L_0x00b2:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00b7:
            return r11
        L_0x00b8:
            r0 = move-exception
            r2 = r0
            r1 = r10
            goto L_0x00be
        L_0x00bc:
            r0 = move-exception
            r2 = r0
        L_0x00be:
            if (r1 == 0) goto L_0x00c9
            r1.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c9
        L_0x00c4:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00c9:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoLoader.loadInternalFromLocal(android.content.Context, java.lang.String, com.baidu.android.util.soloader.ICallingSoLoader):boolean");
    }

    private boolean loadLibrary(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        String simpleName = SoUtils.getSimpleName(str);
        try {
            iCallingSoLoader.loadLibrary(simpleName);
            return true;
        } catch (Throwable th2) {
            StringBuilder sb2 = this.sb;
            sb2.append(str2 + ":::" + simpleName + ":" + Log.getStackTraceString(th2));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A[SYNTHETIC, Splitter:B:33:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[SYNTHETIC, Splitter:B:38:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0072 A[SYNTHETIC, Splitter:B:46:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007c A[SYNTHETIC, Splitter:B:51:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean releaseFileFromApk(java.util.zip.ZipFile r7, java.io.File r8, java.lang.String r9) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r8.getAbsoluteFile()
            r1.append(r2)
            java.lang.String r2 = ".tmp"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            if (r7 == 0) goto L_0x0080
            java.util.zip.ZipEntry r9 = r7.getEntry(r9)     // Catch:{ Exception -> 0x006f, all -> 0x0058 }
            java.io.InputStream r7 = r7.getInputStream(r9)     // Catch:{ Exception -> 0x006f, all -> 0x0058 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            r1 = 256(0x100, float:3.59E-43)
            long r1 = com.baidu.android.util.soloader.SoUtils.copyStream(r7, r9, r1)     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            boolean r8 = r0.renameTo(r8)     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            if (r7 == 0) goto L_0x0044
            r7.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0044:
            r9.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r7 = move-exception
            r7.printStackTrace()
        L_0x004c:
            return r8
        L_0x004d:
            r1 = r7
            goto L_0x0081
        L_0x004f:
            r8 = move-exception
            goto L_0x0053
        L_0x0051:
            r8 = move-exception
            r9 = r1
        L_0x0053:
            r1 = r7
            goto L_0x005a
        L_0x0055:
            r9 = r1
        L_0x0056:
            r1 = r7
            goto L_0x0070
        L_0x0058:
            r8 = move-exception
            r9 = r1
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0064:
            if (r9 == 0) goto L_0x006e
            r9.close()     // Catch:{ Exception -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x006e:
            throw r8
        L_0x006f:
            r9 = r1
        L_0x0070:
            if (r1 == 0) goto L_0x007a
            r1.close()     // Catch:{ Exception -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007a:
            if (r9 == 0) goto L_0x0095
            r9.close()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0095
        L_0x0080:
            r9 = r1
        L_0x0081:
            if (r1 == 0) goto L_0x008b
            r1.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008b:
            if (r9 == 0) goto L_0x0095
            r9.close()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0095:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoLoader.releaseFileFromApk(java.util.zip.ZipFile, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[SYNTHETIC, Splitter:B:19:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f A[SYNTHETIC, Splitter:B:25:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean saveCrc(long r5, java.lang.String r7, java.io.File r8) {
        /*
            r4 = this;
            java.lang.String r7 = r4.getCrcFileName(r7)
            r0 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x002d }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ Exception -> 0x002d }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x002d }
            r3.<init>(r8, r7)     // Catch:{ Exception -> 0x002d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r1.write(r5)     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r1.close()     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0023:
            r5 = 1
            return r5
        L_0x0025:
            r5 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x0028:
            r5 = move-exception
            r0 = r1
            goto L_0x002e
        L_0x002b:
            r5 = move-exception
            goto L_0x003d
        L_0x002d:
            r5 = move-exception
        L_0x002e:
            r5.printStackTrace()     // Catch:{ all -> 0x002b }
            r5 = 0
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003c:
            return r5
        L_0x003d:
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0047:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoLoader.saveCrc(long, java.lang.String, java.io.File):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) {
        String fullName = SoUtils.getFullName(str);
        try {
            if (soSources.size() == 0 || 0 >= soSources.size()) {
                return null;
            }
            return new File(soSources.get(0), fullName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void load(Context context, String str, boolean z) {
        if (!sLoadedLibraries.contains(str)) {
            DefaultSoLoader defaultSoLoader = DefaultSoLoader.getDefaultSoLoader();
            if (z) {
                load(context, str, (ICallingSoLoader) defaultSoLoader);
            } else if (new SoLoader().loadInternalFromLocal(context, str, defaultSoLoader)) {
                sLoadedLibraries.add(str);
            }
        }
    }

    public static void load(Context context, String str, ICallingSoLoader iCallingSoLoader) {
        if (iCallingSoLoader == null) {
            iCallingSoLoader = DefaultSoLoader.getDefaultSoLoader();
        }
        SoLoader soLoader = new SoLoader();
        if (soSources.size() == 0) {
            soLoader.initSoSource(context);
        }
        if (soLoader.loadInternal(context, str, iCallingSoLoader)) {
            sLoadedLibraries.add(str);
        }
    }

    private boolean load(ICallingSoLoader iCallingSoLoader, String str, String str2) {
        try {
            iCallingSoLoader.load(str);
            return true;
        } catch (Throwable th2) {
            StringBuilder sb2 = this.sb;
            sb2.append(str2 + ":::" + str + ":" + Log.getStackTraceString(th2));
            return false;
        }
    }
}
