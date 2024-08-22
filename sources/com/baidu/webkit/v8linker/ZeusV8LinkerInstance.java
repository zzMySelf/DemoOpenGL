package com.baidu.webkit.v8linker;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.SwanAppPageFlowEventRecorder;
import com.baidu.webkit.v8linker.ZeusV8Linker;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ZeusV8LinkerInstance {

    /* renamed from: g  reason: collision with root package name */
    private static String f4059g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Set<Integer> f4060h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private static boolean f4061i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f4062j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static String o = null;
    private static String p = null;
    private static boolean q = false;
    private static boolean r = false;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;

    /* renamed from: a  reason: collision with root package name */
    protected final ZeusV8Linker.LibraryLoader f4063a;

    /* renamed from: b  reason: collision with root package name */
    protected final ZeusV8Linker.LibraryInstaller f4064b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f4065c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f4066d;

    /* renamed from: e  reason: collision with root package name */
    protected String f4067e;

    /* renamed from: f  reason: collision with root package name */
    protected ZeusV8Linker.Logger f4068f;

    protected ZeusV8LinkerInstance() {
        this(new SystemLibraryLoader(), new ApkLibraryInstaller());
    }

    private ZeusV8LinkerInstance(ZeusV8Linker.LibraryLoader libraryLoader, ZeusV8Linker.LibraryInstaller libraryInstaller) {
        this.f4065c = false;
        this.f4068f = new ZeusV8Linker.Logger() {
            public void log(String str) {
            }
        };
        this.f4063a = libraryLoader;
        this.f4064b = libraryInstaller;
    }

    public ZeusV8LinkerInstance setV8LibPath(String str) {
        Log.i("ZeusV8Linker", "setV8LibPath path: ".concat(String.valueOf(str)));
        this.f4067e = str;
        return this;
    }

    public ZeusV8LinkerInstance log(ZeusV8Linker.Logger logger) {
        this.f4068f = logger;
        return this;
    }

    public ZeusV8LinkerInstance force() {
        this.f4065c = true;
        return this;
    }

    public ZeusV8LinkerInstance recursively() {
        this.f4066d = true;
        return this;
    }

    public int loadV8Library(ClassLoader classLoader, Context context, int i2) {
        return loadV8Library(classLoader, context, i2, (String) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bb, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bd, code lost:
        if (r2 != false) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010d A[SYNTHETIC, Splitter:B:64:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int loadV8Library(java.lang.ClassLoader r9, android.content.Context r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            r0 = 0
            if (r10 != 0) goto L_0x000b
            java.lang.String r9 = "ZeusV8Linker"
            java.lang.String r10 = "Given context is null."
            android.util.Log.e(r9, r10)
            return r0
        L_0x000b:
            java.lang.String r1 = "zeusv8"
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x001c
            java.lang.String r9 = "ZeusV8Linker"
            java.lang.String r10 = "Given library is either null or empty"
            android.util.Log.e(r9, r10)
            return r0
        L_0x001c:
            java.lang.Class<com.baidu.webkit.v8linker.ZeusV8LinkerInstance> r1 = com.baidu.webkit.v8linker.ZeusV8LinkerInstance.class
            monitor-enter(r1)
            boolean r2 = f4061i     // Catch:{ Exception -> 0x0157 }
            if (r2 != 0) goto L_0x002a
            boolean r2 = a()     // Catch:{ Exception -> 0x0157 }
            f4061i = r2     // Catch:{ Exception -> 0x0157 }
        L_0x002a:
            boolean r2 = f4062j     // Catch:{ Exception -> 0x0157 }
            if (r2 != 0) goto L_0x0034
            boolean r2 = a((android.content.Context) r10, (int) r11)     // Catch:{ Exception -> 0x0157 }
            f4062j = r2     // Catch:{ Exception -> 0x0157 }
        L_0x0034:
            boolean r2 = k     // Catch:{ Exception -> 0x0157 }
            if (r2 != 0) goto L_0x003e
            boolean r2 = b()     // Catch:{ Exception -> 0x0157 }
            k = r2     // Catch:{ Exception -> 0x0157 }
        L_0x003e:
            java.lang.String r2 = "ZeusV8Linker"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = " isEnabledToLoadV8 scenarioId: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = ", sIsBuildIn: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            boolean r4 = m     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = ", sIsOem: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            boolean r4 = l     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = ", v8LibPath: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = r8.f4067e     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0157 }
            android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x0157 }
            boolean r2 = k     // Catch:{ Exception -> 0x0157 }
            r3 = 1
            if (r2 == 0) goto L_0x0103
            if (r2 == 0) goto L_0x00c0
            switch(r11) {
                case 0: goto L_0x00a0;
                case 1: goto L_0x0092;
                case 2: goto L_0x0084;
                default: goto L_0x0081;
            }     // Catch:{ Exception -> 0x0157 }
        L_0x0081:
            java.lang.String r2 = "ZeusV8Linker"
            goto L_0x00ae
        L_0x0084:
            boolean r2 = f4061i     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x00bb
            boolean r2 = l     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x008f
            boolean r2 = v     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x008f:
            boolean r2 = u     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x0092:
            boolean r2 = f4062j     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x00bb
            boolean r2 = m     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x009d
            boolean r2 = s     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x009d:
            boolean r2 = t     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x00a0:
            boolean r2 = f4062j     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x00bb
            boolean r2 = m     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x00ab
            boolean r2 = q     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x00ab:
            boolean r2 = r     // Catch:{ Exception -> 0x0157 }
            goto L_0x00bc
        L_0x00ae:
            java.lang.String r4 = " isAbtestEnabled unknown scenario id: "
            java.lang.String r5 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ Exception -> 0x0157 }
            android.util.Log.i(r2, r4)     // Catch:{ Exception -> 0x0157 }
        L_0x00bb:
            r2 = r0
        L_0x00bc:
            if (r2 != 0) goto L_0x00c0
            goto L_0x0103
        L_0x00c0:
            boolean r2 = f4062j     // Catch:{ Exception -> 0x0157 }
            if (r2 != 0) goto L_0x0101
            com.baidu.webkit.v8linker.ZeusV8LinkerStatics r2 = com.baidu.webkit.v8linker.ZeusV8LinkerStatics.getInstance()     // Catch:{ Exception -> 0x0157 }
            int r2 = r2.getErrorCode()     // Catch:{ Exception -> 0x0157 }
            r4 = 101(0x65, float:1.42E-43)
            if (r2 != r4) goto L_0x00f1
            boolean r2 = f4061i     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x00d9
            boolean r2 = l     // Catch:{ Exception -> 0x0157 }
            if (r2 != 0) goto L_0x00d9
            goto L_0x00f1
        L_0x00d9:
            com.baidu.webkit.v8linker.ZeusV8LinkerStatics r2 = com.baidu.webkit.v8linker.ZeusV8LinkerStatics.getInstance()     // Catch:{ Exception -> 0x0157 }
            r2.reset()     // Catch:{ Exception -> 0x0157 }
            java.lang.String r2 = r8.f4067e     // Catch:{ Exception -> 0x0157 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0157 }
            if (r2 == 0) goto L_0x0101
            java.lang.String r2 = "ZeusV8Linker"
            java.lang.String r4 = "get engine info failed, and v8LibPath is empty."
            android.util.Log.i(r2, r4)     // Catch:{ Exception -> 0x0157 }
            r2 = r0
            goto L_0x010b
        L_0x00f1:
            java.lang.String r2 = "ZeusV8Linker"
            java.lang.String r4 = "get engine info failed, upload error."
            android.util.Log.i(r2, r4)     // Catch:{ Exception -> 0x0157 }
            com.baidu.webkit.v8linker.ZeusV8LinkerStatics r2 = com.baidu.webkit.v8linker.ZeusV8LinkerStatics.getInstance()     // Catch:{ Exception -> 0x0157 }
            r2.upload()     // Catch:{ Exception -> 0x0157 }
            r2 = r0
            goto L_0x010b
        L_0x0101:
            r2 = r3
            goto L_0x010b
        L_0x0103:
            java.lang.String r2 = "ZeusV8Linker"
            java.lang.String r4 = "abtest is not enable"
            android.util.Log.i(r2, r4)     // Catch:{ Exception -> 0x0157 }
            r2 = r0
        L_0x010b:
            if (r2 != 0) goto L_0x010f
            monitor-exit(r1)     // Catch:{ all -> 0x0155 }
            return r0
        L_0x010f:
            java.lang.String r2 = "Beginning load of %s..."
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0157 }
            java.lang.String r5 = "zeusv8"
            r4[r0] = r5     // Catch:{ Exception -> 0x0157 }
            r8.log(r2, r4)     // Catch:{ Exception -> 0x0157 }
            r2 = r0
            r4 = r2
        L_0x011e:
            int r5 = r2 + 1
            r6 = 3
            if (r2 >= r6) goto L_0x014a
            int r4 = r8.a(r9, r10, r11, r12)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r2 = "ZeusV8Linker"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            java.lang.String r7 = "finish loading, times: "
            r6.<init>(r7)     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r6 = r6.append(r5)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r7 = ", result: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ Exception -> 0x0157 }
            java.lang.StringBuilder r6 = r6.append(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0157 }
            android.util.Log.i(r2, r6)     // Catch:{ Exception -> 0x0157 }
            if (r4 != r3) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r2 = r5
            goto L_0x011e
        L_0x014a:
            if (r4 == r3) goto L_0x0153
            com.baidu.webkit.v8linker.ZeusV8LinkerStatics r9 = com.baidu.webkit.v8linker.ZeusV8LinkerStatics.getInstance()     // Catch:{ Exception -> 0x0157 }
            r9.upload()     // Catch:{ Exception -> 0x0157 }
        L_0x0153:
            monitor-exit(r1)     // Catch:{ all -> 0x0155 }
            return r4
        L_0x0155:
            r9 = move-exception
            goto L_0x0161
        L_0x0157:
            r9 = move-exception
            java.lang.String r10 = "ZeusV8Linker"
            java.lang.String r11 = "failed to load v8 library"
            android.util.Log.e(r10, r11, r9)     // Catch:{ all -> 0x0155 }
            monitor-exit(r1)     // Catch:{ all -> 0x0155 }
            return r0
        L_0x0161:
            monitor-exit(r1)     // Catch:{ all -> 0x0155 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.v8linker.ZeusV8LinkerInstance.loadV8Library(java.lang.ClassLoader, android.content.Context, int, java.lang.String):int");
    }

    private int a(ClassLoader classLoader, Context context, int i2, String str) {
        String str2;
        Context context2 = context;
        int i3 = i2;
        if (f4060h.contains(Integer.valueOf(i2))) {
            return 1;
        }
        String a2 = a(str);
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        Log.i("ZeusV8Linker", "start loading");
        String str3 = context.getApplicationContext().getApplicationInfo().nativeLibraryDir + File.separator + "libzeusv8.so";
        if (n && !TextUtils.isEmpty(o) && TextUtils.isEmpty(this.f4067e)) {
            File file = new File(str3);
            if (i3 != 2) {
                str3 = o + File.separator + "libzeusv8.so";
            } else if (i3 == 2 && !file.exists()) {
                str3 = o + File.separator + "libzeusv8.so";
            }
            File file2 = new File(str3);
            if (!file2.exists() || file2.length() <= 0) {
                ZeusV8LinkerStatics.getInstance().set(102, "external zeusV8File is null", i3, n);
                return 2;
            }
        }
        if (((m && Build.VERSION.SDK_INT <= 22) || this.f4065c) && TextUtils.isEmpty(this.f4067e)) {
            File file3 = new File(str3);
            if (!file3.exists() || file3.length() <= 0 || this.f4065c) {
                File a3 = a(context2, a2);
                if (!a3.exists() || a3.length() <= 0) {
                    ZeusV8LinkerStatics.getInstance().set(103, "workaround zeusV8File is null", i3, n);
                    return 2;
                }
                str3 = a3.getAbsolutePath();
            }
        }
        if (TextUtils.isEmpty(this.f4067e)) {
            str2 = str3;
        } else if (!a(context2)) {
            Log.e("ZeusV8Linker", "v8 file is not suitable anymore, check if sdk version or abi is changed. path, " + this.f4067e);
            return 0;
        } else {
            if (!this.f4067e.endsWith(File.separator)) {
                this.f4067e += File.separator;
            }
            str2 = this.f4067e + "libzeusv8.so";
        }
        Log.i("ZeusV8Linker", "realFullPath: ".concat(String.valueOf(str2)));
        try {
            if (n && l && w && Build.VERSION.SDK_INT <= 22) {
                File parentFile = new File(str2).getParentFile();
                File file4 = new File(context2.getDir("zeusv8lib", 0), "install_libraries.lock");
                if (!file4.exists()) {
                    file4.createNewFile();
                }
                FileChannel channel = new RandomAccessFile(file4, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth).getChannel();
                FileLock lock = channel.lock();
                if (lock != null && lock.isValid()) {
                    a(classLoader, parentFile);
                }
                lock.release();
                channel.close();
            }
        } catch (Throwable th2) {
            Log.e("ZeusV8Linker", "add v8 path to nativeLibraryDirectories failed, " + th2.getMessage());
        }
        StringBuilder sb = new StringBuilder(context2.getDir("zeusv8lib", 0).toString());
        String processSuffix = getProcessSuffix(context);
        StringBuilder sb2 = new StringBuilder("/libzeusv8for");
        sb2.append(Integer.toString(i2));
        if (processSuffix == null || processSuffix.length() == 0) {
            sb2.append("main");
        } else {
            sb2.append(processSuffix);
        }
        sb2.append(".so.");
        String sb3 = sb2.toString();
        b(context2, sb3.substring(1, sb3.length() - 1), a2);
        sb.append(sb3);
        sb.append(a2);
        String sb4 = sb.toString();
        Log.i("ZeusV8Linker", "linkFullPath: ".concat(String.valueOf(sb4)));
        try {
            File file5 = new File(sb4);
            if (file5.exists()) {
                file5.delete();
            } else {
                try {
                    File[] listFiles = file5.getParentFile().listFiles();
                    if (listFiles != null && Arrays.asList(listFiles).contains(file5)) {
                        file5.delete();
                    }
                } catch (Throwable th3) {
                    Log.e("ZeusV8Linker", " files delete failed, throwable = " + th3.getMessage() + ", continue");
                }
            }
            Os.symlink(str2, sb4);
            System.currentTimeMillis();
            System.load(sb4);
            System.currentTimeMillis();
            f4060h.add(Integer.valueOf(i2));
            log("%s (%s) was re-linked!", "zeusv8", a2);
            return 1;
        } catch (ErrnoException e2) {
            Log.e("ZeusV8Linker", " create symlic link failed, exception = " + e2.getMessage());
            ZeusV8LinkerStatics.getInstance().set(201, e2.toString(), i3, n);
            return 0;
        } catch (UnsatisfiedLinkError e3) {
            Log.e("ZeusV8Linker", " load symlic link failed, exception = " + e3.getMessage());
            ZeusV8LinkerStatics.getInstance().set(202, e3.toString(), i3, n);
            return 0;
        } catch (NullPointerException e4) {
            Log.e("ZeusV8Linker", " realFullPath is null, exception = " + e4.getMessage());
            ZeusV8LinkerStatics.getInstance().set(203, e4.toString(), i3, n);
            return 2;
        } catch (SecurityException e5) {
            Log.e("ZeusV8Linker", " exception = " + e5.getMessage());
            ZeusV8LinkerStatics.getInstance().set(204, e5.toString(), i3, n);
            return 2;
        } catch (Throwable th4) {
            Log.e("ZeusV8Linker", " throwable = " + th4.getMessage());
            ZeusV8LinkerStatics.getInstance().set(1, th4.toString(), i3, n);
            return 2;
        }
    }

    private File a(Context context, String str, String str2) {
        String mapLibraryName = this.f4063a.mapLibraryName(str);
        if (TextUtils.isEmpty(str2)) {
            return new File(context.getDir("zeusv8lib", 0), mapLibraryName);
        }
        return new File(context.getDir("zeusv8lib", 0), mapLibraryName + "." + str2);
    }

    private void b(Context context, String str, String str2) {
        File dir = context.getDir("zeusv8lib", 0);
        File a2 = a(context, str, str2);
        final String mapLibraryName = this.f4063a.mapLibraryName(str);
        File[] listFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith(mapLibraryName);
            }
        });
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f4065c || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    public void log(String str, Object... objArr) {
        log(String.format(Locale.US, str, objArr));
    }

    public void log(String str) {
        ZeusV8Linker.Logger logger = this.f4068f;
        if (logger != null) {
            logger.log(str);
        }
    }

    public static String getProcessSuffix(Context context) {
        String str = f4059g;
        if (str != null) {
            return str;
        }
        String processName = getProcessName(context, Process.myPid());
        if (processName == null) {
            return null;
        }
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            f4059g = processName.substring(indexOf + 1);
        } else {
            f4059g = "";
        }
        return f4059g;
    }

    private static Object a(Object obj, Class cls, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Field a(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static String getProcessName(Context context) {
        return getProcessName(context, Process.myPid());
    }

    public static String getProcessName(Context context, int i2) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class[]) null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, (Object[]) null);
            if (invoke instanceof String) {
                str = (String) invoke;
            } else {
                str = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == i2) {
                return next.processName;
            }
        }
        return null;
    }

    private static void a(ClassLoader classLoader, File file) throws Throwable {
        if (Build.VERSION.SDK_INT <= 22) {
            Object obj = a((Object) classLoader, SwanAppPageFlowEventRecorder.KEY_PATH_LIST).get(classLoader);
            Field a2 = a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a2.get(obj);
            int length = fileArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (!file.equals(fileArr[i2])) {
                    i2++;
                } else {
                    return;
                }
            }
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (File add : fileArr) {
                arrayList.add(add);
            }
            a2.set(obj, arrayList.toArray(new File[0]));
        }
    }

    private static boolean a() {
        try {
            l = !Class.forName("com.baidu.webkit.internal.GlobalConstants").getField("BUILD_IN_ZEUS_EXISTS").getBoolean((Object) null);
            return true;
        } catch (Exception e2) {
            Log.e("ZeusV8Linker", "Reflect get oem info Error " + Log.getStackTraceString(e2));
            return false;
        }
    }

    private static boolean b() {
        try {
            Class<?> cls = Class.forName("com.baidu.webkit.sdk.abtest.ABTestSDK");
            q = ((Boolean) cls.getDeclaredMethod("isT7ZeusV8LinkerBuildInEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            r = ((Boolean) cls.getDeclaredMethod("isT7ZeusV8LinkerExternalEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            s = ((Boolean) cls.getDeclaredMethod("isSwanZeusV8LinkerBuildInEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            t = ((Boolean) cls.getDeclaredMethod("isSwanZeusV8LinkerExternalEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            u = ((Boolean) cls.getDeclaredMethod("isTalosZeusV8LinkerBuildInEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            v = ((Boolean) cls.getDeclaredMethod("isTalosZeusV8LinkerExternalEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            w = ((Boolean) cls.getDeclaredMethod("isAddInstallPathToNativeLibraryEnabled", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
            return true;
        } catch (Exception e2) {
            Log.e("ZeusV8Linker", "Reflect getAbtest Error " + Log.getStackTraceString(e2));
            return false;
        }
    }

    private static boolean a(Context context, int i2) {
        try {
            Object invoke = Class.forName("com.baidu.webkit.engine.ZeusEngineRetrieval").getDeclaredMethod("getSuitableEngine", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            if (invoke == null) {
                Log.e("ZeusV8Linker", "getSuitableEngine EngineInfo = null, isOem: " + l);
                ZeusV8LinkerStatics.getInstance().set(101, "getSuitableEngine EngineInfo = null", i2);
                return false;
            }
            Class<?> cls = Class.forName("com.baidu.webkit.engine.ZeusEngineInfo");
            m = ((Boolean) cls.getDeclaredMethod("isBuildIn", new Class[0]).invoke(invoke, new Object[0])).booleanValue();
            boolean booleanValue = ((Boolean) cls.getDeclaredMethod("isExternal", new Class[0]).invoke(invoke, new Object[0])).booleanValue();
            n = booleanValue;
            if (booleanValue) {
                o = (String) a(invoke, (Class) cls, "installPath");
            }
            p = (String) Class.forName("com.baidu.webkit.engine.Version").getDeclaredMethod("raw", new Class[0]).invoke(a(invoke, (Class) cls, "zeusVersion"), new Object[0]);
            return true;
        } catch (Exception e2) {
            Log.e("ZeusV8Linker", "Reflect getSuitableEngine  Error " + Log.getStackTraceString(e2));
            ZeusV8LinkerStatics.getInstance().set(101, e2.toString(), i2);
            return false;
        }
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(this.f4067e)) {
            try {
                return new File(this.f4067e).getName();
            } catch (Exception e2) {
                Log.e("ZeusV8Linker", "get version from v8LibPath failed. path: " + this.f4067e + ", error " + Log.getStackTraceString(e2));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return p;
    }

    private boolean a(Context context) {
        try {
            return ((Boolean) Class.forName("com.baidu.webkit.engine.ZeusEngineVerify").getDeclaredMethod("isV8FileSuitable", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, this.f4067e})).booleanValue();
        } catch (Exception e2) {
            Log.e("ZeusV8Linker", "get check v8LibPath failed. path: " + this.f4067e + ", error " + Log.getStackTraceString(e2));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A[SYNTHETIC, Splitter:B:48:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0 A[SYNTHETIC, Splitter:B:52:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab A[SYNTHETIC, Splitter:B:59:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2 A[SYNTHETIC, Splitter:B:63:0x00b2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File a(android.content.Context r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "zeusv8"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            java.lang.String r3 = "zeusv8lib"
            r4 = 0
            java.io.File r3 = r13.getDir(r3, r4)     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            java.lang.String r5 = "zeusv8.lock"
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            if (r3 != 0) goto L_0x0020
            r2.createNewFile()     // Catch:{ IOException -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r3 = move-exception
        L_0x0020:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            java.lang.String r5 = "rw"
            r3.<init>(r2, r5)     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch:{ Exception -> 0x00a6, all -> 0x0095 }
            java.nio.channels.FileLock r3 = r2.lock()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
            if (r3 == 0) goto L_0x0083
            boolean r5 = r3.isValid()     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            if (r5 == 0) goto L_0x0083
            java.io.File r5 = r12.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r14)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            if (r6 == 0) goto L_0x0046
            boolean r6 = r12.f4065c     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            if (r6 == 0) goto L_0x006e
        L_0x0046:
            boolean r6 = r12.f4065c     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            if (r6 == 0) goto L_0x0057
            java.lang.String r6 = "Forcing a re-link of %s (%s)..."
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r7[r4] = r0     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r4 = 1
            r7[r4] = r14     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r12.log(r6, r7)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
        L_0x0057:
            r12.b(r13, r0, r14)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            com.baidu.webkit.v8linker.ZeusV8Linker$LibraryInstaller r6 = r12.f4064b     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            com.baidu.webkit.v8linker.ZeusV8Linker$LibraryLoader r14 = r12.f4063a     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            java.lang.String[] r8 = r14.supportedAbis()     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            com.baidu.webkit.v8linker.ZeusV8Linker$LibraryLoader r14 = r12.f4063a     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            java.lang.String r9 = r14.mapLibraryName(r0)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r7 = r13
            r10 = r5
            r11 = r12
            r6.installLibrary(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
        L_0x006e:
            if (r3 == 0) goto L_0x0076
            r3.release()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0076
        L_0x0075:
            r13 = move-exception
        L_0x0076:
            if (r2 == 0) goto L_0x007d
            r2.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x007d
        L_0x007c:
            r13 = move-exception
        L_0x007d:
            return r5
        L_0x007e:
            r13 = move-exception
            r1 = r3
            goto L_0x0097
        L_0x0081:
            r13 = move-exception
            goto L_0x00a9
        L_0x0083:
            if (r3 == 0) goto L_0x008a
            r3.release()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008a
        L_0x0089:
            r13 = move-exception
        L_0x008a:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00b5
        L_0x0090:
            r13 = move-exception
            goto L_0x0097
        L_0x0092:
            r13 = move-exception
            r3 = r1
            goto L_0x00a9
        L_0x0095:
            r13 = move-exception
            r2 = r1
        L_0x0097:
            if (r1 == 0) goto L_0x009e
            r1.release()     // Catch:{ IOException -> 0x009d }
            goto L_0x009e
        L_0x009d:
            r14 = move-exception
        L_0x009e:
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a5
        L_0x00a4:
            r14 = move-exception
        L_0x00a5:
            throw r13
        L_0x00a6:
            r13 = move-exception
            r2 = r1
            r3 = r2
        L_0x00a9:
            if (r3 == 0) goto L_0x00b0
            r3.release()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b0
        L_0x00af:
            r13 = move-exception
        L_0x00b0:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ Exception -> 0x00b6 }
        L_0x00b5:
            goto L_0x00b8
        L_0x00b6:
            r13 = move-exception
            goto L_0x00b5
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.v8linker.ZeusV8LinkerInstance.a(android.content.Context, java.lang.String):java.io.File");
    }
}
