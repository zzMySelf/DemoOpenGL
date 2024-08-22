package com.baidu.searchbox.aperf.param;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.alipay.sdk.m.u.i;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.MemoryUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.devices.StorageUtils;
import fe.fe.ddd.fe.ad.rg.qw;
import fe.fe.yj.de.th;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CommonUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static final HashSet<String> f992ad = new HashSet<String>() {
        {
            add(MemoryUtils.VMPEAK);
            add(MemoryUtils.VMSIZE);
            add("VmHWM");
            add("VmRSS");
        }
    };

    /* renamed from: de  reason: collision with root package name */
    public static String f993de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static String f994fe = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f995i = null;

    /* renamed from: o  reason: collision with root package name */
    public static String f996o = null;

    /* renamed from: pf  reason: collision with root package name */
    public static String f997pf = null;
    public static final ConcurrentHashMap<String, String> qw = new ConcurrentHashMap<>();

    /* renamed from: rg  reason: collision with root package name */
    public static String f998rg = null;

    /* renamed from: th  reason: collision with root package name */
    public static String f999th = null;

    /* renamed from: uk  reason: collision with root package name */
    public static String f1000uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public static String f1001yj = null;

    public static boolean aaa() {
        String prop = RomUtils.getProp("ro.product.model");
        if (!TextUtils.isEmpty(prop) && !prop.toLowerCase().contains("sdk") && !prop.toLowerCase().contains("google_sdk") && !prop.contains("Emulator")) {
            String prop2 = RomUtils.getProp("ro.product.manufacturer");
            if (!TextUtils.isEmpty(prop2) && !prop2.toLowerCase().contains("unknown") && !prop2.contains("Genymotion")) {
                String prop3 = RomUtils.getProp("ro.product.device");
                if (!TextUtils.isEmpty(prop3) && !prop3.toLowerCase().contains("generic")) {
                    return "1".equals(RomUtils.getProp("ro.kernel.qemu"));
                }
            }
        }
        return true;
    }

    public static String ad() {
        if (f998rg == null) {
            String str = Build.HARDWARE;
            String num = Integer.toString(qw.de());
            String f = Float.toString(((float) Math.round(qw.ad() * 10.0f)) / 10.0f);
            String arrays = Arrays.toString(DeviceUtils.CPUInfo.getSupportedABIs());
            if (!TextUtils.isEmpty(arrays)) {
                arrays = arrays.replace("[", "").replace("]", "");
            }
            f998rg = str + i.b + num + i.b + f + i.b + arrays;
        }
        return f998rg;
    }

    public static boolean ddd() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 < 21) {
            return false;
        }
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr.length > 0) {
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return false;
    }

    public static String de() {
        if (f995i == null) {
            if (aaa()) {
                f995i = "1";
            } else {
                f995i = "-1";
            }
        }
        return f995i;
    }

    public static String fe() {
        long availableExternalMemorySize = StorageUtils.getAvailableExternalMemorySize();
        long totalExternalMemorySize = StorageUtils.getTotalExternalMemorySize();
        if (availableExternalMemorySize > 0) {
            availableExternalMemorySize = (long) Math.round(((float) availableExternalMemorySize) / 1024.0f);
        }
        if (totalExternalMemorySize > 0) {
            totalExternalMemorySize = (long) Math.round(((float) totalExternalMemorySize) / 1024.0f);
        }
        StringBuilder sb = new StringBuilder();
        Object obj = "-1";
        sb.append(availableExternalMemorySize >= 0 ? Long.valueOf(availableExternalMemorySize) : obj);
        sb.append(i.b);
        if (totalExternalMemorySize >= 0) {
            obj = Long.valueOf(totalExternalMemorySize);
        }
        sb.append(obj);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[SYNTHETIC, Splitter:B:22:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[SYNTHETIC, Splitter:B:29:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ggg(java.lang.String r5) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = qw
            java.lang.Object r0 = r0.get(r5)
            if (r0 != 0) goto L_0x0069
            r0 = 0
            android.content.Context r1 = fe.fe.ddd.i.qw.qw.qw()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2 = 3
            java.io.InputStream r1 = r1.open(r5, r2)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            android.util.JsonReader r2 = new android.util.JsonReader     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2.beginObject()     // Catch:{ Exception -> 0x0047 }
        L_0x0025:
            boolean r0 = r2.hasNext()     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = r2.nextName()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = "sdkversion"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x0025
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = qw     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = r2.nextString()     // Catch:{ Exception -> 0x0047 }
            r0.put(r5, r1)     // Catch:{ Exception -> 0x0047 }
        L_0x0040:
            r2.endObject()     // Catch:{ Exception -> 0x0047 }
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0069
        L_0x0047:
            r0 = move-exception
            goto L_0x004e
        L_0x0049:
            r5 = move-exception
            goto L_0x005e
        L_0x004b:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x004e:
            r0.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0069
        L_0x0057:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0069
        L_0x005c:
            r5 = move-exception
            r0 = r2
        L_0x005e:
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0068:
            throw r5
        L_0x0069:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = qw
            java.lang.Object r5 = r0.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aperf.param.CommonUtils.ggg(java.lang.String):java.lang.String");
    }

    public static String i() {
        return new th().qw();
    }

    /* renamed from: if  reason: not valid java name */
    public static String m35if() {
        if (f997pf == null) {
            String packageName = fe.fe.ddd.i.qw.qw.qw().getPackageName();
            f997pf = packageName;
            if (packageName == null) {
                f997pf = "";
            }
        }
        return f997pf;
    }

    public static boolean mmm() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i2 = 0; i2 < 8; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean nn() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) fe.fe.ddd.i.qw.qw.qw().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static String o() {
        if (f993de == null) {
            f993de = DeviceUtil.OSInfo.getOsVersion();
        }
        return f993de;
    }

    public static String pf() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        long j = (long) memoryInfo.dalvikPss;
        return ((long) memoryInfo.nativePss) + i.b + j;
    }

    public static String ppp() {
        if (f1001yj == null) {
            String prop = RomUtils.getProp("ro.secure");
            boolean z = true;
            if (prop != null && "0".equals(prop)) {
                z = false;
            }
            String str = "1";
            if (!z) {
                f1001yj = str;
            } else {
                if (!mmm()) {
                    str = "-1";
                }
                f1001yj = str;
            }
        }
        return f1001yj;
    }

    public static String qw() {
        if (f999th == null) {
            String appVersion = fe.fe.ddd.fe.ad.qw.qw().getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                f999th = appVersion;
                return appVersion;
            }
            try {
                Context qw2 = fe.fe.ddd.i.qw.qw.qw();
                f999th = qw2.getPackageManager().getPackageInfo(qw2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (f999th == null) {
                f999th = "";
            }
        }
        return f999th;
    }

    public static String rg() {
        long j = Runtime.getRuntime().totalMemory() / 1024;
        long freeMemory = j - (Runtime.getRuntime().freeMemory() / 1024);
        return (Debug.getNativeHeapAllocatedSize() / 1024) + i.b + freeMemory + i.b + (Debug.getNativeHeapSize() / 1024) + i.b + j + i.b + (Runtime.getRuntime().maxMemory() / 1024);
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m36switch() {
        if (f1000uk == null) {
            f1000uk = ddd() ? "1" : "0";
        }
        return f1000uk;
    }

    public static String th() {
        long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize();
        long totalInternalMemorySize = StorageUtils.getTotalInternalMemorySize();
        if (availableInternalMemorySize > 0) {
            availableInternalMemorySize = (long) Math.round(((float) availableInternalMemorySize) / 1024.0f);
        }
        if (totalInternalMemorySize > 0) {
            totalInternalMemorySize = (long) Math.round(((float) totalInternalMemorySize) / 1024.0f);
        }
        StringBuilder sb = new StringBuilder();
        Object obj = "-1";
        sb.append(availableInternalMemorySize >= 0 ? Long.valueOf(availableInternalMemorySize) : obj);
        sb.append(i.b);
        if (totalInternalMemorySize >= 0) {
            obj = Long.valueOf(totalInternalMemorySize);
        }
        sb.append(obj);
        return sb.toString();
    }

    public static String uk() {
        if (f994fe == null) {
            String prop = RomUtils.getProp("dalvik.vm.heapstartsize");
            String prop2 = RomUtils.getProp("dalvik.vm.heapgrowthlimit");
            String prop3 = RomUtils.getProp("dalvik.vm.heapsize");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) fe.fe.ddd.i.qw.qw.qw().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            if (j > 0) {
                j = (j / 1024) / 1024;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(prop);
            sb.append(i.b);
            sb.append(prop2);
            sb.append(i.b);
            sb.append(prop3);
            sb.append(i.b);
            sb.append(j >= 0 ? Long.valueOf(j) : "-1");
            f994fe = sb.toString().replace("m", "");
        }
        return f994fe;
    }

    public static String vvv() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) fe.fe.ddd.i.qw.qw.qw().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        StringBuilder sb = new StringBuilder();
        sb.append(memoryInfo.availMem / 1024);
        return sb.toString();
    }

    public static String when() {
        if (f996o == null) {
            f996o = RomUtils.getName() + i.b + RomUtils.getVersion();
        }
        return f996o;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c4, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c8, code lost:
        r2 = null;
        r5 = null;
        r6 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00cf, code lost:
        r2 = null;
        r5 = null;
        r6 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0130, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0131, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f0 A[SYNTHETIC, Splitter:B:74:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0100 A[SYNTHETIC, Splitter:B:82:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012c A[SYNTHETIC, Splitter:B:90:0x012c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:71:0x00eb=Splitter:B:71:0x00eb, B:79:0x00fb=Splitter:B:79:0x00fb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String xxx() {
        /*
            java.lang.String r0 = " KB"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            java.lang.String r3 = "/proc/self/status"
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            boolean r3 = r2.exists()     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            if (r3 == 0) goto L_0x00d5
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00f6, IOException -> 0x00e6 }
            java.util.HashSet<java.lang.String> r2 = f992ad     // Catch:{ FileNotFoundException -> 0x00ce, IOException -> 0x00c7, all -> 0x00c3 }
            int r2 = r2.size()     // Catch:{ FileNotFoundException -> 0x00ce, IOException -> 0x00c7, all -> 0x00c3 }
            r4 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = 0
        L_0x0025:
            if (r8 >= r2) goto L_0x00c0
            java.lang.String r9 = r3.readLine()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r9 == 0) goto L_0x00c0
            java.lang.String r10 = ":"
            java.lang.String[] r9 = r9.split(r10)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            int r10 = r9.length     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            r11 = 2
            if (r10 != r11) goto L_0x0025
            r10 = r9[r4]     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            r12 = 1
            r9 = r9[r12]     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            boolean r13 = android.text.TextUtils.isEmpty(r10)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r13 != 0) goto L_0x0025
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r13 == 0) goto L_0x0049
            goto L_0x0025
        L_0x0049:
            java.lang.String r10 = r10.trim()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            java.lang.String r9 = r9.trim()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            java.lang.String r9 = r9.toUpperCase()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            java.util.HashSet<java.lang.String> r13 = f992ad     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            boolean r13 = r13.contains(r10)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r13 == 0) goto L_0x0025
            int r8 = r8 + 1
            boolean r13 = r9.endsWith(r0)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r13 == 0) goto L_0x006d
            int r13 = r9.lastIndexOf(r0)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            java.lang.String r9 = r9.substring(r4, r13)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
        L_0x006d:
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r13 != 0) goto L_0x0025
            r13 = -1
            int r14 = r10.hashCode()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            r15 = 3
            switch(r14) {
                case -1729713066: goto L_0x009b;
                case -1729619080: goto L_0x0091;
                case 82741991: goto L_0x0087;
                case 82751483: goto L_0x007d;
                default: goto L_0x007c;
            }     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
        L_0x007c:
            goto L_0x00a4
        L_0x007d:
            java.lang.String r14 = "VmRSS"
            boolean r10 = r10.equals(r14)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r10 == 0) goto L_0x00a4
            r13 = 2
            goto L_0x00a4
        L_0x0087:
            java.lang.String r14 = "VmHWM"
            boolean r10 = r10.equals(r14)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r10 == 0) goto L_0x00a4
            r13 = 0
            goto L_0x00a4
        L_0x0091:
            java.lang.String r14 = "VmSize"
            boolean r10 = r10.equals(r14)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r10 == 0) goto L_0x00a4
            r13 = 3
            goto L_0x00a4
        L_0x009b:
            java.lang.String r14 = "VmPeak"
            boolean r10 = r10.equals(r14)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00ba, all -> 0x00c3 }
            if (r10 == 0) goto L_0x00a4
            r13 = 1
        L_0x00a4:
            if (r13 == 0) goto L_0x00b7
            if (r13 == r12) goto L_0x00b4
            if (r13 == r11) goto L_0x00b1
            if (r13 == r15) goto L_0x00ae
            goto L_0x0025
        L_0x00ae:
            r1 = r9
            goto L_0x0025
        L_0x00b1:
            r7 = r9
            goto L_0x0025
        L_0x00b4:
            r5 = r9
            goto L_0x0025
        L_0x00b7:
            r6 = r9
            goto L_0x0025
        L_0x00ba:
            r0 = move-exception
            r2 = r1
            goto L_0x00cc
        L_0x00bd:
            r0 = move-exception
            r2 = r1
            goto L_0x00d3
        L_0x00c0:
            r0 = r1
            r1 = r3
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            r1 = r3
            goto L_0x012a
        L_0x00c7:
            r0 = move-exception
            r2 = r1
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x00cc:
            r1 = r3
            goto L_0x00eb
        L_0x00ce:
            r0 = move-exception
            r2 = r1
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x00d3:
            r1 = r3
            goto L_0x00fb
        L_0x00d5:
            r0 = r1
            r5 = r0
            r6 = r5
            r7 = r6
        L_0x00d9:
            if (r1 == 0) goto L_0x0109
            r1.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x0109
        L_0x00df:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0109
        L_0x00e4:
            r0 = move-exception
            goto L_0x012a
        L_0x00e6:
            r0 = move-exception
            r2 = r1
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x00eb:
            r0.printStackTrace()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x0108
            r1.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x0108
        L_0x00f4:
            r0 = move-exception
            goto L_0x0105
        L_0x00f6:
            r0 = move-exception
            r2 = r1
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x00fb:
            r0.printStackTrace()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x0108
            r1.close()     // Catch:{ IOException -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
        L_0x0105:
            r0.printStackTrace()
        L_0x0108:
            r0 = r2
        L_0x0109:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ";"
            r1.append(r0)
            r1.append(r5)
            r1.append(r0)
            r1.append(r7)
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x012a:
            if (r1 == 0) goto L_0x0134
            r1.close()     // Catch:{ IOException -> 0x0130 }
            goto L_0x0134
        L_0x0130:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0134:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aperf.param.CommonUtils.xxx():java.lang.String");
    }

    public static String yj() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
