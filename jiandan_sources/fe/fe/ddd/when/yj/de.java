package fe.fe.ddd.when.yj;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.alipay.sdk.m.n.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.android.util.soloader.SoUtils;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class de {
    public static final void aaa(@NonNull File file, @NonNull String str, boolean z) {
        if (file.exists() && file.isFile() && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.flush();
                    Closeables.closeSafely((Closeable) fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    Closeables.closeSafely((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileOutputStream);
            }
        }
    }

    public static String ad(long j) {
        if (j <= 0) {
            return String.valueOf(j);
        }
        long j2 = (long) 86400000;
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        long j5 = (long) 3600000;
        long j6 = j4 / j5;
        long j7 = j4 - (j5 * j6);
        long j8 = (long) CometHttpRequestInterceptor.a;
        long j9 = j7 / j8;
        long j10 = j7 - (j8 * j9);
        long j11 = (long) 1000;
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        return j3 + " " + j6 + ":" + j9 + ":" + j12 + ":" + j13;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.util.Pair<java.lang.String, java.lang.Boolean> ddd(@androidx.annotation.NonNull java.io.File r8, int r9) {
        /*
            r0 = 0
            if (r9 > 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0054, all -> 0x0051 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0054, all -> 0x0051 }
            r2.<init>(r8)     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0054, all -> 0x0051 }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x004b, all -> 0x0048 }
            java.lang.Boolean r3 = new java.lang.Boolean     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            r5 = 0
        L_0x0019:
            int r6 = r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            r7 = -1
            if (r6 == r7) goto L_0x0032
            int r7 = r9 - r5
            if (r7 < r6) goto L_0x0029
            r8.write(r1, r4, r6)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            int r5 = r5 + r6
            goto L_0x0019
        L_0x0029:
            r8.write(r1, r4, r6)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            java.lang.Boolean r3 = new java.lang.Boolean     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            r9 = 1
            r3.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
        L_0x0032:
            android.util.Pair r9 = new android.util.Pair     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            java.lang.String r1 = "utf-8"
            java.lang.String r1 = r8.toString(r1)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            r9.<init>(r1, r3)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044 }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r2)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r8)
            return r9
        L_0x0044:
            r9 = move-exception
            goto L_0x0057
        L_0x0046:
            r9 = move-exception
            goto L_0x005e
        L_0x0048:
            r9 = move-exception
            r8 = r0
            goto L_0x0069
        L_0x004b:
            r9 = move-exception
            r8 = r0
            goto L_0x0057
        L_0x004e:
            r9 = move-exception
            r8 = r0
            goto L_0x005e
        L_0x0051:
            r9 = move-exception
            r8 = r0
            goto L_0x006a
        L_0x0054:
            r9 = move-exception
            r8 = r0
            r2 = r8
        L_0x0057:
            r9.printStackTrace()     // Catch:{ all -> 0x0068 }
            goto L_0x0061
        L_0x005b:
            r9 = move-exception
            r8 = r0
            r2 = r8
        L_0x005e:
            r9.printStackTrace()     // Catch:{ all -> 0x0068 }
        L_0x0061:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r2)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r8)
            return r0
        L_0x0068:
            r9 = move-exception
        L_0x0069:
            r0 = r2
        L_0x006a:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.yj.de.ddd(java.io.File, int):android.util.Pair");
    }

    @TargetApi(23)
    public static String de(@NonNull Debug.MemoryInfo memoryInfo) {
        Iterator<Map.Entry<String, String>> it = memoryInfo.getMemoryStats().entrySet().iterator();
        if (!it.hasNext()) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ExtendedMessageFormat.START_FE);
        while (true) {
            Map.Entry next = it.next();
            sb.append((String) next.getKey());
            sb.append(a.h);
            sb.append((String) next.getValue());
            if (!it.hasNext()) {
                sb.append(ExtendedMessageFormat.END_FE);
                return sb.toString();
            }
            sb.append(',');
            sb.append(Ascii.CASE_MASK);
        }
    }

    @TargetApi(24)
    public static long fe() {
        return Process.getStartElapsedRealtime();
    }

    public static final void ggg(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            int myPid = Process.myPid();
            File file2 = new File("/proc/" + myPid + "/status");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void i(@NonNull Context context, @NonNull File file) {
        File parentFile;
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write("data/app/{package_name-x} start\n");
                    File file2 = new File(context.getApplicationInfo().sourceDir);
                    if (file2.exists()) {
                        File parentFile2 = file2.getParentFile();
                        if (parentFile2 != null && parentFile2.exists()) {
                            fileWriter2.write(parentFile2.getAbsolutePath());
                            if (ad.qw) {
                                parentFile2.getAbsolutePath() + StringUtils.LF;
                            }
                            xxx(fileWriter2, parentFile2, "");
                        }
                    }
                    fileWriter2.write("data/app/{package_name-x} end\n\n\n");
                    fileWriter2.write("/data/data/{package_name}/lib start\n");
                    File filesDir = context.getFilesDir();
                    if (filesDir != null && filesDir.exists() && (parentFile = filesDir.getParentFile()) != null && parentFile.exists()) {
                        File file3 = new File(parentFile, SoUtils.PRE);
                        if (file3.exists()) {
                            fileWriter2.write(file3.getAbsolutePath());
                            if (ad.qw) {
                                file3.getAbsolutePath() + StringUtils.LF;
                            }
                            xxx(fileWriter2, file3, "");
                        }
                    }
                    fileWriter2.write("/data/data/{package_name}/lib end\n\n\n");
                    fileWriter2.write("/data/data/{package_name}/files/{released_so_directory} start\n");
                    File releaseSoFilePath = SoLoader.getReleaseSoFilePath(context);
                    if (releaseSoFilePath != null && releaseSoFilePath.exists()) {
                        fileWriter2.write(releaseSoFilePath.getAbsolutePath());
                        if (ad.qw) {
                            releaseSoFilePath.getAbsolutePath() + StringUtils.LF;
                        }
                        xxx(fileWriter2, releaseSoFilePath, "");
                    }
                    fileWriter2.write("/data/data/{package_name}/files/{released_so_directory} end\n\n\n");
                    Closeables.closeSafely((Closeable) fileWriter2);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileWriter);
                } catch (IOException e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileWriter);
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileWriter);
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    Closeables.closeSafely((Closeable) fileWriter);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileWriter);
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileWriter);
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileWriter);
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely((Closeable) fileWriter);
                throw th;
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static final void m90if(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            InputStream inputStream = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                inputStream = runtime.exec("ls -l " + ("/proc/" + Process.myPid() + "/fd")).getInputStream();
                FileUtils.saveToFile(inputStream, file);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th2) {
                Closeables.closeSafely((Closeable) inputStream);
                throw th2;
            }
            Closeables.closeSafely((Closeable) inputStream);
        }
    }

    public static final void mmm(@NonNull File file, @NonNull String str) {
        aaa(file, str, true);
    }

    public static void nn(@NonNull FileWriter fileWriter, @NonNull File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        nn(fileWriter, file2);
                    }
                }
                return;
            }
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".db")) {
            try {
                fileWriter.write(StringUtils.LF + absolutePath + "=" + file.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final void o(@NonNull File file) {
        FileOutputStream fileOutputStream;
        if (file.exists() && file.isFile()) {
            BufferedReader bufferedReader = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time -t 1000").getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            fileOutputStream.write(readLine.getBytes());
                            fileOutputStream.write(StringUtils.LF.getBytes());
                        } catch (Exception e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            try {
                                e.printStackTrace();
                                Closeables.closeSafely((Closeable) bufferedReader);
                                Closeables.closeSafely((Closeable) fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                Closeables.closeSafely((Closeable) bufferedReader);
                                Closeables.closeSafely((Closeable) fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            Closeables.closeSafely((Closeable) bufferedReader);
                            Closeables.closeSafely((Closeable) fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    Closeables.closeSafely((Closeable) bufferedReader2);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) bufferedReader);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) bufferedReader);
                Closeables.closeSafely((Closeable) fileOutputStream);
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                Closeables.closeSafely((Closeable) bufferedReader);
                Closeables.closeSafely((Closeable) fileOutputStream);
                throw th;
            }
            Closeables.closeSafely((Closeable) fileOutputStream);
        }
    }

    public static final void pf(@NonNull Context context, @NonNull File file) {
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write("Runtime.getRuntime() memory info:");
                    fileWriter2.write("\nRuntime.getRuntime().maxMemory() = " + Runtime.getRuntime().maxMemory());
                    fileWriter2.write("\nRuntime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory());
                    fileWriter2.write("\nRuntime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory());
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    fileWriter2.write("\n\nActivityManager.MemoryInfo");
                    if (DeviceUtil.OSInfo.hasKitKat()) {
                        fileWriter2.write("\nisLowRamDevice = " + activityManager.isLowRamDevice());
                    }
                    fileWriter2.write("\nMemoryInfo.availMem = " + memoryInfo.availMem);
                    fileWriter2.write("\nMemoryInfo.lowMemory = " + memoryInfo.lowMemory);
                    fileWriter2.write("\nMemoryInfo.totalMem = " + memoryInfo.totalMem);
                    fileWriter2.write("\nMemoryInfo.threshold = " + memoryInfo.threshold);
                    Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
                    Debug.getMemoryInfo(memoryInfo2);
                    fileWriter2.write("\n\nDebug.MemoryInfo");
                    fileWriter2.write("\nMemoryInfo.dalvikPss = " + memoryInfo2.dalvikPss);
                    fileWriter2.write("\nMemoryInfo.dalvikPrivateDirty = " + memoryInfo2.dalvikPrivateDirty);
                    fileWriter2.write("\nMemoryInfo.dalvikSharedDirty = " + memoryInfo2.dalvikSharedDirty);
                    fileWriter2.write("\nMemoryInfo.nativePss = " + memoryInfo2.nativePss);
                    fileWriter2.write("\nMemoryInfo.nativePrivateDirty = " + memoryInfo2.nativePrivateDirty);
                    fileWriter2.write("\nMemoryInfo.nativeSharedDirty = " + memoryInfo2.nativeSharedDirty);
                    fileWriter2.write("\nMemoryInfo.otherPss = " + memoryInfo2.otherPss);
                    fileWriter2.write("\nMemoryInfo.otherPrivateDirty = " + memoryInfo2.otherPrivateDirty);
                    fileWriter2.write("\nMemoryInfo.otherSharedDirty = " + memoryInfo2.otherSharedDirty);
                    fileWriter2.write("\nMemoryInfo.getTotalPss() = " + memoryInfo2.getTotalPss());
                    if (DeviceUtil.OSInfo.hasKitKat()) {
                        fileWriter2.write("\nMemoryInfo.getTotalPrivateClean() = " + memoryInfo2.getTotalPrivateClean());
                    }
                    fileWriter2.write("\nMemoryInfo.getTotalPrivateDirty() = " + memoryInfo2.getTotalPrivateDirty());
                    if (DeviceUtil.OSInfo.hasKitKat()) {
                        fileWriter2.write("\nMemoryInfo.getTotalSharedClean() = " + memoryInfo2.getTotalSharedClean());
                    }
                    fileWriter2.write("\nMemoryInfo.getTotalSharedDirty() = " + memoryInfo2.getTotalSharedDirty());
                    if (DeviceUtil.OSInfo.hasKitKat()) {
                        fileWriter2.write("\nMemoryInfo.getTotalSwappablePss() = " + memoryInfo2.getTotalSwappablePss());
                    }
                    if (DeviceUtil.OSInfo.hasMarshMallow()) {
                        fileWriter2.write("MemoryInfo.getMemoryStats() = " + de(memoryInfo2));
                    }
                    fileWriter2.flush();
                    Closeables.closeSafely((Closeable) fileWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    try {
                        Log.getStackTraceString(th);
                    } finally {
                        Closeables.closeSafely((Closeable) fileWriter);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                Log.getStackTraceString(th);
            }
        }
    }

    public static final void ppp(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            File file2 = new File("/proc/self/smaps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final boolean qw(@NonNull File file) {
        boolean z;
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        try {
            z = file.createNewFile();
        } catch (IOException e) {
            if (ad.qw) {
                e.printStackTrace();
            }
            z = false;
        }
        if (ad.qw) {
            "createNewEmptyFile() = " + z + ", file = " + file.getAbsolutePath();
        }
        return z;
    }

    public static void rg() {
    }

    /* renamed from: switch  reason: not valid java name */
    public static final void m91switch(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            int myPid = Process.myPid();
            File file2 = new File("/proc/" + myPid + "/maps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final boolean th(@NonNull Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static final void uk(@NonNull Context context, @NonNull File file) {
        String str;
        String str2;
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = null;
            try {
                String str3 = Build.MODEL;
                String str4 = "NUL";
                if (TextUtils.isEmpty(str3)) {
                    str = str4;
                } else {
                    str = str3.replace("_", "-");
                }
                String str5 = Build.VERSION.RELEASE;
                if (TextUtils.isEmpty(str5)) {
                    str2 = "0.0";
                } else {
                    str2 = str5.replace("_", "-");
                }
                String valueOf = String.valueOf(Build.VERSION.SDK_INT);
                String str6 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str6)) {
                    str4 = str6.replace("_", "-");
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                float f = displayMetrics.density;
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Devices info = ");
                    sb.append(str + "_" + str2 + "_" + valueOf + "_" + str4 + "_" + i2 + "*" + i3 + "*" + f);
                    fileWriter2.write(sb.toString());
                    fileWriter2.write("\nRuntime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
                    fileWriter2.write("\nRomName = " + RomUtils.getName() + ", RomVersion = " + RomUtils.getVersion());
                    fileWriter2.flush();
                    Closeables.closeSafely((Closeable) fileWriter2);
                } catch (Throwable th2) {
                    fileWriter = fileWriter2;
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        Closeables.closeSafely((Closeable) fileWriter);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
            }
        }
    }

    public static final void vvv(@NonNull File file) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        Set<Thread> keySet;
        if (file.exists() && file.isFile() && (allStackTraces = Thread.getAllStackTraces()) != null && (keySet = allStackTraces.keySet()) != null) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write("threads count:" + keySet.size() + StringUtils.LF);
                    int i2 = 0;
                    for (Thread next : keySet) {
                        if (next != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(i2);
                            sb.append(":");
                            sb.append(next.getName());
                            sb.append(StringUtils.LF);
                            StackTraceElement[] stackTrace = next.getStackTrace();
                            if (stackTrace != null) {
                                for (StackTraceElement stackTraceElement : stackTrace) {
                                    if (stackTraceElement != null) {
                                        sb.append(stackTraceElement.toString());
                                        sb.append(StringUtils.LF);
                                    }
                                }
                            }
                            sb.append(StringUtils.LF);
                            fileWriter2.write(sb.toString());
                            i2++;
                        }
                    }
                    fileWriter2.flush();
                    Closeables.closeSafely((Closeable) fileWriter2);
                } catch (IOException e) {
                    e = e;
                    fileWriter = fileWriter2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) fileWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) fileWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    Closeables.closeSafely((Closeable) fileWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileWriter);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r14.write("\nProcess is64bit = unknown");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x015c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void when(@androidx.annotation.Nullable android.content.Context r16, @androidx.annotation.NonNull java.io.File r17, @androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.NonNull com.baidu.searchbox.logsystem.logsys.LogExtra r19) {
        /*
            r1 = r19
            java.lang.String r2 = "\nProcess is64bit = unknown"
            boolean r0 = r17.exists()
            if (r0 == 0) goto L_0x01e4
            boolean r0 = r17.isFile()
            if (r0 != 0) goto L_0x0012
            goto L_0x01e4
        L_0x0012:
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = android.os.Process.getElapsedCpuTime()
            long r7 = android.os.SystemClock.elapsedRealtime()
            boolean r0 = com.baidu.android.util.devices.DeviceUtil.OSInfo.hasNougat()
            r9 = -1
            if (r0 == 0) goto L_0x002b
            long r11 = fe()
            goto L_0x002c
        L_0x002b:
            r11 = r9
        L_0x002c:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x01d5 }
            java.lang.String r14 = "yyyy-MM-dd kk:mm:ss:SSS"
            r0.<init>(r14)     // Catch:{ all -> 0x01d5 }
            java.io.FileWriter r14 = new java.io.FileWriter     // Catch:{ all -> 0x01d5 }
            r15 = 1
            r13 = r17
            r14.<init>(r13, r15)     // Catch:{ all -> 0x01d5 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r13.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r15 = "When crash happens:"
            r13.append(r15)     // Catch:{ all -> 0x01d2 }
            java.util.Date r15 = new java.util.Date     // Catch:{ all -> 0x01d2 }
            r15.<init>(r3)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.format(r15)     // Catch:{ all -> 0x01d2 }
            r13.append(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r3 = "\nprocess name = "
            r0.append(r3)     // Catch:{ all -> 0x01d2 }
            r3 = r18
            r0.append(r3)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            r3 = 0
            java.lang.String r0 = r16.getPackageName()     // Catch:{ NameNotFoundException -> 0x009c }
            android.content.pm.PackageManager r4 = r16.getPackageManager()     // Catch:{ NameNotFoundException -> 0x009c }
            android.content.pm.PackageInfo r0 = r4.getPackageInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x009c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x009c }
            r4.<init>()     // Catch:{ NameNotFoundException -> 0x009c }
            java.lang.String r13 = "\nPackageInfo: "
            r4.append(r13)     // Catch:{ NameNotFoundException -> 0x009c }
            int r13 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x009c }
            r4.append(r13)     // Catch:{ NameNotFoundException -> 0x009c }
            java.lang.String r13 = "_"
            r4.append(r13)     // Catch:{ NameNotFoundException -> 0x009c }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x009c }
            r4.append(r0)     // Catch:{ NameNotFoundException -> 0x009c }
            java.lang.String r0 = r4.toString()     // Catch:{ NameNotFoundException -> 0x009c }
            r14.write(r0)     // Catch:{ NameNotFoundException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x01d2 }
        L_0x00a0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r4 = "\nSystemClock.elapsedRealTime()="
            r0.append(r4)     // Catch:{ all -> 0x01d2 }
            r0.append(r7)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r4 = "\nandroid.os.Process.getStartElapsedRealTime()="
            r0.append(r4)     // Catch:{ all -> 0x01d2 }
            r0.append(r11)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r4 = "\nSystemClock.elapsedRealTime() - android.os.Process.getStartElapsedRealTime()="
            r0.append(r4)     // Catch:{ all -> 0x01d2 }
            long r7 = r7 - r11
            java.lang.String r4 = ad(r7)     // Catch:{ all -> 0x01d2 }
            r0.append(r4)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
        L_0x00e5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r4 = "\nandroid.os.Process.getElapsedCpuTime()="
            r0.append(r4)     // Catch:{ all -> 0x01d2 }
            r0.append(r5)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d2 }
            r4 = 23
            java.lang.String r5 = "\nProcess is64bit = "
            if (r0 < r4) goto L_0x0118
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            r0.append(r5)     // Catch:{ all -> 0x01d2 }
            boolean r2 = android.os.Process.is64Bit()     // Catch:{ all -> 0x01d2 }
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            goto L_0x0165
        L_0x0118:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d2 }
            r4 = 21
            if (r0 < r4) goto L_0x0160
            java.lang.ClassLoader r0 = r16.getClassLoader()     // Catch:{ Exception -> 0x015c }
            java.lang.Class<java.lang.ClassLoader> r4 = java.lang.ClassLoader.class
            java.lang.String r6 = "findLibrary"
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x015c }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r3] = r9     // Catch:{ Exception -> 0x015c }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r8)     // Catch:{ Exception -> 0x015c }
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = "art"
            r6[r3] = r7     // Catch:{ Exception -> 0x015c }
            java.lang.Object r0 = r4.invoke(r0, r6)     // Catch:{ Exception -> 0x015c }
            if (r0 == 0) goto L_0x0158
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = "lib64"
            boolean r0 = r0.contains(r3)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r3.<init>()     // Catch:{ Exception -> 0x015c }
            r3.append(r5)     // Catch:{ Exception -> 0x015c }
            r3.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x015c }
            r14.write(r0)     // Catch:{ Exception -> 0x015c }
            goto L_0x0165
        L_0x0158:
            r14.write(r2)     // Catch:{ Exception -> 0x015c }
            goto L_0x0165
        L_0x015c:
            r14.write(r2)     // Catch:{ all -> 0x01d2 }
            goto L_0x0165
        L_0x0160:
            java.lang.String r0 = "\nProcess is64bit = false"
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
        L_0x0165:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = "\nCrash thread name = "
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = r1.mCrashThreadName     // Catch:{ all -> 0x01d2 }
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = ", priority = "
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = r1.mCrashThreadPriority     // Catch:{ all -> 0x01d2 }
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = "\ntraceid = "
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = fe.fe.ddd.fe.de.qw.qw()     // Catch:{ all -> 0x01d2 }
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r2 = "\nlog mJSONAttach = "
            r0.append(r2)     // Catch:{ all -> 0x01d2 }
            java.lang.String r1 = r1.mJSONAttach     // Catch:{ all -> 0x01d2 }
            r0.append(r1)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r0.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r1 = "\nprocessid = "
            r0.append(r1)     // Catch:{ all -> 0x01d2 }
            int r1 = android.os.Process.myPid()     // Catch:{ all -> 0x01d2 }
            r0.append(r1)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d2 }
            r14.write(r0)     // Catch:{ all -> 0x01d2 }
            r14.flush()     // Catch:{ all -> 0x01d2 }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r14)
            goto L_0x01dd
        L_0x01d2:
            r0 = move-exception
            r13 = r14
            goto L_0x01d7
        L_0x01d5:
            r0 = move-exception
            r13 = 0
        L_0x01d7:
            android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x01de }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r13)
        L_0x01dd:
            return
        L_0x01de:
            r0 = move-exception
            r1 = r0
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r13)
            throw r1
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.yj.de.when(android.content.Context, java.io.File, java.lang.String, com.baidu.searchbox.logsystem.logsys.LogExtra):void");
    }

    public static final void xxx(@NonNull FileWriter fileWriter, @NonNull File file, @NonNull String str) {
        if (file.exists()) {
            try {
                fileWriter.write(str + file.getAbsolutePath());
                if (file.isFile()) {
                    fileWriter.write("\tlength=" + file.length() + ",lastModified=" + file.lastModified());
                }
                fileWriter.write(StringUtils.LF);
                if (ad.qw) {
                    str + file.getAbsolutePath() + StringUtils.LF;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                String str2 = str + " ";
                if (listFiles != null && listFiles.length > 0) {
                    for (File xxx : listFiles) {
                        xxx(fileWriter, xxx, str2);
                    }
                }
            }
        }
    }

    public static void yj(@NonNull Context context, @NonNull File file) {
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    File parentFile = context.getFilesDir().getParentFile();
                    fileWriter2.write("DataBase list:");
                    if (parentFile != null && parentFile.exists()) {
                        nn(fileWriter2, parentFile);
                    }
                    fileWriter2.flush();
                    Closeables.closeSafely((Closeable) fileWriter2);
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) fileWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) fileWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    Closeables.closeSafely((Closeable) fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileWriter);
            }
        }
    }
}
