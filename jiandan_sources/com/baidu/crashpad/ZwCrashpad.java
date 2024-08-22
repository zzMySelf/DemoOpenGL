package com.baidu.crashpad;

import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;

public class ZwCrashpad {
    public static boolean aaa = false;

    /* renamed from: ad  reason: collision with root package name */
    public static String f767ad = "0";
    public static String ddd = "0";

    /* renamed from: de  reason: collision with root package name */
    public static String f768de = "";
    public static final Object eee = new Object();

    /* renamed from: fe  reason: collision with root package name */
    public static String f769fe = "0";
    public static String ggg = "-1";

    /* renamed from: i  reason: collision with root package name */
    public static String f770i = "0";

    /* renamed from: if  reason: not valid java name */
    public static String f9if = "0";
    public static boolean mmm = false;
    public static String nn = "0";

    /* renamed from: o  reason: collision with root package name */
    public static String f771o = "0";

    /* renamed from: pf  reason: collision with root package name */
    public static String f772pf = "0";
    public static String ppp = "0";
    public static boolean qqq = false;
    public static String qw = "0";

    /* renamed from: rg  reason: collision with root package name */
    public static String f773rg = "";
    public static CrashCallbackExtra rrr = null;

    /* renamed from: switch  reason: not valid java name */
    public static String f10switch = "0";

    /* renamed from: th  reason: collision with root package name */
    public static String f774th = "0";
    public static boolean tt = true;

    /* renamed from: uk  reason: collision with root package name */
    public static int f775uk = -1;
    public static String vvv = "true";
    public static String when = "0";
    public static String xxx = "0";

    /* renamed from: yj  reason: collision with root package name */
    public static String f776yj = "0";

    public static void NotifyCrashStart() {
        CrashCallbackExtra crashCallbackExtra;
        if (tt && (crashCallbackExtra = rrr) != null) {
            crashCallbackExtra.qw();
        }
    }

    public static synchronized void RecordUrl(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && aaa) {
                nativeRecordUrl(str);
            }
        }
    }

    public static synchronized boolean ShouldIgnoreCrash() {
        synchronized (ZwCrashpad.class) {
            if (!tt || !aaa) {
                return false;
            }
            boolean nativeShouldIgnoreCrash = nativeShouldIgnoreCrash();
            return nativeShouldIgnoreCrash;
        }
    }

    public static void clearCrashKey(String str) {
        if (tt && aaa && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        if (i2 == 1) {
            if (aaa) {
                nativeCrashIntentionally(i2);
            }
        } else if (i2 == 2) {
            setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0163  */
    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void doInit(android.content.Context r7, java.lang.String[] r8) {
        /*
            java.lang.Class<com.baidu.crashpad.ZwCrashpad> r0 = com.baidu.crashpad.ZwCrashpad.class
            boolean r1 = tt
            if (r1 == 0) goto L_0x01c6
            if (r7 == 0) goto L_0x01c6
            boolean r1 = mmm
            if (r1 == 0) goto L_0x000e
            goto L_0x01c6
        L_0x000e:
            r1 = 10
            r1 = r8[r1]
            ddd = r1
            java.lang.String r2 = "0"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x004b
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = ddd     // Catch:{ all -> 0x007d }
            java.lang.String r5 = "0"
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x004b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r5 = ddd     // Catch:{ all -> 0x007d }
            r1.append(r5)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = "/libcrashpad_client.so"
            r1.append(r5)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007d }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x007d }
            r5.<init>(r1)     // Catch:{ all -> 0x007d }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x004b
            r2 = r1
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            if (r2 == 0) goto L_0x007f
            java.lang.String r5 = "0"
            boolean r5 = r2.equals(r5)     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x007f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r5.<init>()     // Catch:{ all -> 0x007d }
            java.io.File r6 = r7.getFilesDir()     // Catch:{ all -> 0x007d }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x007d }
            r5.append(r6)     // Catch:{ all -> 0x007d }
            java.lang.String r6 = "/zeus/libs/libcrashpad_client.so"
            r5.append(r6)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007d }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x007d }
            r6.<init>(r5)     // Catch:{ all -> 0x007d }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x007d }
            if (r6 == 0) goto L_0x007f
            r2 = r5
            r1 = 1
            goto L_0x007f
        L_0x007d:
            goto L_0x0098
        L_0x007f:
            if (r1 == 0) goto L_0x0091
            if (r2 == 0) goto L_0x0091
            java.lang.String r1 = "0"
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0091
            java.lang.System.load(r2)     // Catch:{ all -> 0x007d }
            aaa = r4     // Catch:{ all -> 0x007d }
            goto L_0x0098
        L_0x0091:
            java.lang.String r1 = "crashpad_client"
            java.lang.System.loadLibrary(r1)     // Catch:{ all -> 0x007d }
            aaa = r4     // Catch:{ all -> 0x007d }
        L_0x0098:
            com.baidu.crashpad.ZwDebugExtra.init(r7)
            r1 = r8[r3]
            setCyberVersion(r1)
            r1 = r8[r4]
            f769fe = r1
            r1 = 2
            r1 = r8[r1]
            f767ad = r1
            r1 = 3
            r1 = r8[r1]
            qw = r1
            r1 = 4
            r1 = r8[r1]
            f768de = r1
            r1 = 5
            r1 = r8[r1]
            f9if = r1
            r1 = 6
            r2 = r8[r1]
            if (r2 == 0) goto L_0x00d3
            r2 = r8[r1]
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00d3
            r2 = r8[r1]
            java.lang.String r5 = "-1"
            boolean r2 = android.text.TextUtils.equals(r2, r5)
            if (r2 != 0) goto L_0x00d3
            r1 = r8[r1]
            ppp = r1
        L_0x00d3:
            r1 = 7
            r2 = r8[r1]
            vvv = r2
            r2 = 9
            r2 = r8[r2]
            f770i = r2
            r2 = 11
            r2 = r8[r2]
            xxx = r2
            if (r2 == 0) goto L_0x00f6
            java.lang.String r5 = "0"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00f6
            java.lang.String r2 = xxx
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00fe
        L_0x00f6:
            android.content.pm.ApplicationInfo r2 = r7.getApplicationInfo()
            java.lang.String r2 = r2.nativeLibraryDir
            xxx = r2
        L_0x00fe:
            r2 = 12
            r2 = r8[r2]
            nn = r2
            android.content.pm.PackageManager r2 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0118 }
            java.lang.String r5 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0118 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r5, r3)     // Catch:{ NameNotFoundException -> 0x0118 }
            java.lang.String r5 = r2.versionName     // Catch:{ NameNotFoundException -> 0x0118 }
            f776yj = r5     // Catch:{ NameNotFoundException -> 0x0118 }
            int r2 = r2.versionCode     // Catch:{ NameNotFoundException -> 0x0118 }
            f775uk = r2     // Catch:{ NameNotFoundException -> 0x0118 }
        L_0x0118:
            java.lang.String r2 = r7.getPackageName()     // Catch:{ Exception -> 0x011f }
            f774th = r2     // Catch:{ Exception -> 0x011f }
            goto L_0x0120
        L_0x011f:
        L_0x0120:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r5 = r7.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            r2.append(r5)
            java.lang.String r5 = "/zeuslogs/"
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            when = r2
            java.io.File r2 = new java.io.File
            java.lang.String r5 = when
            r2.<init>(r5)
            boolean r5 = r2.exists()
            if (r5 != 0) goto L_0x0159
            boolean r2 = r2.mkdirs()
            if (r2 != 0) goto L_0x0159
            java.io.File r2 = r7.getFilesDir()
            java.lang.String r2 = r2.getAbsolutePath()
            when = r2
            goto L_0x015b
        L_0x0159:
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
        L_0x015b:
            java.lang.String r2 = android.os.Build.getRadioVersion()
            f10switch = r2
            if (r2 != 0) goto L_0x0167
            java.lang.String r2 = "no message"
            f10switch = r2
        L_0x0167:
            java.lang.String[] r2 = qw()
            monitor-enter(r0)
            boolean r5 = aaa     // Catch:{ all -> 0x01c0 }
            if (r5 == 0) goto L_0x0175
            nativeInit(r2)     // Catch:{ all -> 0x01c0 }
            mmm = r4     // Catch:{ all -> 0x01c0 }
        L_0x0175:
            monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
            java.lang.String r0 = "USER"
            java.lang.String r2 = android.os.Build.USER
            setCrashKeyValue(r0, r2)
            r0 = 8
            r0 = r8[r0]
            com.baidu.crashpad.ZeusLogUploader.o(r0)
            r0 = r8[r1]
            if (r0 == 0) goto L_0x0195
            r8 = r8[r1]
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0195
            goto L_0x0196
        L_0x0195:
            r3 = 1
        L_0x0196:
            com.baidu.crashpad.ZeusLogUploader.m13switch(r3)
            java.lang.String r8 = getEncryptKey()
            com.baidu.crashpad.ZeusLogUploader.m12if(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.io.File r7 = r7.getFilesDir()
            java.lang.String r7 = r7.getAbsolutePath()
            r8.append(r7)
            java.lang.String r7 = "/zeuslogs/"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "crashlog"
            r0 = 0
            com.baidu.crashpad.ZeusLogUploader.qw(r7, r8, r4, r0)
            return
        L_0x01c0:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
            throw r7
        L_0x01c3:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            throw r7
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZwCrashpad.doInit(android.content.Context, java.lang.String[]):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7 A[Catch:{ all -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0174  */
    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void doInitGeneric(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.baidu.crashpad.ZwCrashpad> r0 = com.baidu.crashpad.ZwCrashpad.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "zwCrashpad.doInitGeneric  mIsEnabled="
            r1.append(r2)
            boolean r2 = tt
            r1.append(r2)
            java.lang.String r2 = ", mIsInitialized="
            r1.append(r2)
            boolean r2 = mmm
            r1.append(r2)
            java.lang.String r2 = ", mNativeIsInitialized="
            r1.append(r2)
            boolean r2 = aaa
            r1.append(r2)
            r1.toString()
            boolean r1 = tt
            if (r1 == 0) goto L_0x01db
            if (r6 == 0) goto L_0x01db
            boolean r1 = mmm
            if (r1 == 0) goto L_0x0034
            goto L_0x01db
        L_0x0034:
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L_0x003b
            return
        L_0x003b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0089 }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r7 = "clientDir"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ JSONException -> 0x0089 }
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0089 }
            if (r2 != 0) goto L_0x004e
            ddd = r7     // Catch:{ JSONException -> 0x0089 }
        L_0x004e:
            java.lang.String r7 = "handlerDir"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ JSONException -> 0x0089 }
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0089 }
            if (r2 != 0) goto L_0x005c
            xxx = r7     // Catch:{ JSONException -> 0x0089 }
        L_0x005c:
            java.lang.String r7 = xxx     // Catch:{ JSONException -> 0x0089 }
            if (r7 == 0) goto L_0x0072
            java.lang.String r7 = xxx     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r2 = "0"
            boolean r7 = r7.equals(r2)     // Catch:{ JSONException -> 0x0089 }
            if (r7 != 0) goto L_0x0072
            java.lang.String r7 = xxx     // Catch:{ JSONException -> 0x0089 }
            boolean r7 = r7.isEmpty()     // Catch:{ JSONException -> 0x0089 }
            if (r7 == 0) goto L_0x007a
        L_0x0072:
            android.content.pm.ApplicationInfo r7 = r6.getApplicationInfo()     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r7 = r7.nativeLibraryDir     // Catch:{ JSONException -> 0x0089 }
            xxx = r7     // Catch:{ JSONException -> 0x0089 }
        L_0x007a:
            java.lang.String r7 = "dumpCopyDir"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ JSONException -> 0x0089 }
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0089 }
            if (r1 != 0) goto L_0x008d
            nn = r7     // Catch:{ JSONException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008d:
            java.lang.String r7 = "0"
            r1 = 0
            r2 = 1
            java.lang.String r3 = ddd     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x00c8
            java.lang.String r3 = ddd     // Catch:{ all -> 0x0112 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x00c8
            java.lang.String r3 = ddd     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "0"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x00c8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r3.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = ddd     // Catch:{ all -> 0x0112 }
            r3.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = "/libcrashpad_client.so"
            r3.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0112 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0112 }
            r4.<init>(r3)     // Catch:{ all -> 0x0112 }
            boolean r4 = r4.exists()     // Catch:{ all -> 0x0112 }
            if (r4 == 0) goto L_0x00c8
            r7 = r3
            r3 = 1
            goto L_0x00c9
        L_0x00c8:
            r3 = 0
        L_0x00c9:
            if (r7 == 0) goto L_0x00f9
            java.lang.String r4 = "0"
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0112 }
            if (r4 == 0) goto L_0x00f9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r4.<init>()     // Catch:{ all -> 0x0112 }
            java.io.File r5 = r6.getFilesDir()     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0112 }
            r4.append(r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = "/zeus/libs/libcrashpad_client.so"
            r4.append(r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0112 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0112 }
            r5.<init>(r4)     // Catch:{ all -> 0x0112 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f9
            r7 = r4
            r3 = 1
        L_0x00f9:
            if (r3 == 0) goto L_0x010b
            if (r7 == 0) goto L_0x010b
            java.lang.String r3 = "0"
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0112 }
            if (r3 != 0) goto L_0x010b
            java.lang.System.load(r7)     // Catch:{ all -> 0x0112 }
            aaa = r2     // Catch:{ all -> 0x0112 }
            goto L_0x0112
        L_0x010b:
            java.lang.String r7 = "crashpad_client"
            java.lang.System.loadLibrary(r7)     // Catch:{ all -> 0x0112 }
            aaa = r2     // Catch:{ all -> 0x0112 }
        L_0x0112:
            com.baidu.crashpad.ZwDebugExtra.init(r6)
            android.content.pm.PackageManager r7 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0129 }
            java.lang.String r3 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0129 }
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0129 }
            java.lang.String r1 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0129 }
            f776yj = r1     // Catch:{ NameNotFoundException -> 0x0129 }
            int r7 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0129 }
            f775uk = r7     // Catch:{ NameNotFoundException -> 0x0129 }
        L_0x0129:
            java.lang.String r7 = r6.getPackageName()     // Catch:{ Exception -> 0x0130 }
            f774th = r7     // Catch:{ Exception -> 0x0130 }
            goto L_0x0131
        L_0x0130:
        L_0x0131:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r1 = r6.getFilesDir()
            java.lang.String r1 = r1.getAbsolutePath()
            r7.append(r1)
            java.lang.String r1 = "/zeuslogs/"
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            when = r7
            java.io.File r7 = new java.io.File
            java.lang.String r1 = when
            r7.<init>(r1)
            boolean r1 = r7.exists()
            if (r1 != 0) goto L_0x016a
            boolean r7 = r7.mkdirs()
            if (r7 != 0) goto L_0x016a
            java.io.File r7 = r6.getFilesDir()
            java.lang.String r7 = r7.getAbsolutePath()
            when = r7
            goto L_0x016c
        L_0x016a:
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x01d8 }
        L_0x016c:
            java.lang.String r7 = android.os.Build.getRadioVersion()
            f10switch = r7
            if (r7 != 0) goto L_0x0178
            java.lang.String r7 = "no message"
            f10switch = r7
        L_0x0178:
            java.lang.String[] r7 = qw()
            monitor-enter(r0)
            boolean r1 = aaa     // Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x0186
            nativeInit(r7)     // Catch:{ all -> 0x01d5 }
            mmm = r2     // Catch:{ all -> 0x01d5 }
        L_0x0186:
            monitor-exit(r0)     // Catch:{ all -> 0x01d5 }
            java.lang.String r7 = "USER"
            java.lang.String r0 = android.os.Build.USER
            setCrashKeyValue(r7, r0)
            java.lang.String r7 = ""
            java.io.File r7 = r6.getExternalFilesDir(r7)
            if (r7 == 0) goto L_0x01a3
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x01a3
            java.lang.String r7 = r7.getAbsolutePath()
            com.baidu.crashpad.ZeusLogUploader.o(r7)
        L_0x01a3:
            com.baidu.crashpad.ZeusLogUploader.m13switch(r2)
            java.lang.String r7 = getEncryptKey()
            com.baidu.crashpad.ZeusLogUploader.m12if(r7)
            java.io.File r6 = r6.getFilesDir()
            if (r6 == 0) goto L_0x01d4
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x01d4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r6 = r6.getAbsolutePath()
            r7.append(r6)
            java.lang.String r6 = "/zeuslogs/"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "crashlog"
            r0 = 0
            com.baidu.crashpad.ZeusLogUploader.qw(r6, r7, r2, r0)
        L_0x01d4:
            return
        L_0x01d5:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01d5 }
            throw r6
        L_0x01d8:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01d8 }
            throw r6
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZwCrashpad.doInitGeneric(android.content.Context, java.lang.String):void");
    }

    public static synchronized String getEncryptKey() {
        synchronized (ZwCrashpad.class) {
            if (!tt || !aaa) {
                return "";
            }
            String nativeGetEncryptKey = nativeGetEncryptKey();
            return nativeGetEncryptKey;
        }
    }

    public static String[] getInfos() {
        String[] qw2 = qw();
        synchronized (ZwCrashpad.class) {
            aaa = true;
        }
        return qw2;
    }

    public static boolean isCyberVersionReady() {
        boolean z;
        synchronized (eee) {
            z = qqq;
        }
        return z;
    }

    public static native void nativeClearCrashKey(String str);

    public static native void nativeCrashIntentionally(int i2);

    public static native String nativeGetEncryptKey();

    public static native void nativeInit(String[] strArr);

    public static native void nativeRecordUrl(String str);

    public static native void nativeSetCallback(String str);

    public static native void nativeSetCpu(String str);

    public static native void nativeSetCrashKeyValue(String str, String str2);

    public static native void nativeSetCuid(String str);

    public static native void nativeSetCyberVersion(String str);

    public static native void nativeSetDumpCopyDir(String str);

    public static native void nativeSetEmulator(String str);

    public static native void nativeSetHandlerSoDir(String str);

    public static native void nativeSetHasCallbackListener();

    public static native void nativeSetJavaException(String str);

    public static native void nativeSetKernelInfoToDuliCrashpad(String[] strArr);

    public static native void nativeSetProcessType(String str);

    public static native void nativeSetStatisticParam(String str);

    public static native void nativeSetUploadCrashLogFailedEncrypt(boolean z);

    public static native void nativeSetWebviewNumber(String str);

    public static native void nativeSetZeusVersion(String str);

    public static native boolean nativeShouldIgnoreCrash();

    public static String[] qw() {
        try {
            return new String[]{f774th, f776yj, Integer.toString(f775uk), f770i, f771o, when, f772pf, Build.MODEL.replace(Ascii.CASE_MASK, '_').replace('-', '_'), Build.VERSION.RELEASE, f769fe, f767ad, f773rg, qw, f768de, "", "", f9if, f10switch, Build.DISPLAY, ppp, ggg, vvv, xxx, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128)), nn};
        } catch (Exception unused) {
            return new String[0];
        }
    }

    public static synchronized void setCallback(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, f768de)) {
                f768de = str;
                if (aaa) {
                    nativeSetCallback(str);
                }
            }
        }
    }

    public static synchronized void setClientSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, ddd)) {
                ddd = str;
            }
        }
    }

    public static synchronized void setCpu(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, f769fe)) {
                f769fe = str;
                if (aaa) {
                    nativeSetCpu(str);
                }
            }
        }
    }

    public static synchronized void setCrashCallbackListener(CrashCallbackExtra crashCallbackExtra) {
        synchronized (ZwCrashpad.class) {
            if (tt) {
                rrr = crashCallbackExtra;
                if (aaa) {
                    nativeSetHasCallbackListener();
                }
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        if (tt && aaa && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static synchronized void setCuid(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, f767ad)) {
                f767ad = str;
                if (aaa) {
                    nativeSetCuid(str);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean setCyberVersion(java.lang.String r3) {
        /*
            boolean r0 = tt
            if (r0 == 0) goto L_0x0031
            if (r3 == 0) goto L_0x0031
            java.lang.String r0 = "0"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0031
            java.lang.Object r0 = eee
            monitor-enter(r0)
            java.lang.String r1 = f771o     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = f771o     // Catch:{ all -> 0x002e }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            goto L_0x0031
        L_0x0020:
            f771o = r3     // Catch:{ all -> 0x002e }
            r1 = 1
            qqq = r1     // Catch:{ all -> 0x002e }
            boolean r2 = aaa     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x002c
            nativeSetCyberVersion(r3)     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return r1
        L_0x002e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r3
        L_0x0031:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZwCrashpad.setCyberVersion(java.lang.String):boolean");
    }

    public static synchronized void setDumpCopyDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, nn)) {
                nn = str;
                if (aaa) {
                    nativeSetDumpCopyDir(str);
                }
            }
        }
    }

    public static synchronized void setEmulator(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, qw)) {
                qw = str;
                if (aaa) {
                    nativeSetEmulator(str);
                }
            }
        }
    }

    public static void setEnabled(boolean z) {
        tt = z;
        ZeusLogUploader.pf(z);
    }

    public static synchronized void setHandlerSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, xxx)) {
                xxx = str;
                if (aaa) {
                    nativeSetHandlerSoDir(str);
                }
            }
        }
    }

    public static synchronized void setKernelInfoToDuliCrashpad(String[] strArr) {
        synchronized (ZwCrashpad.class) {
            if (tt && aaa) {
                nativeSetKernelInfoToDuliCrashpad(strArr);
            }
        }
    }

    public static synchronized void setProcessType(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, ppp)) {
                ppp = str;
                if (aaa) {
                    nativeSetProcessType(str);
                }
            }
        }
    }

    public static synchronized void setStatisticParam(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, f773rg)) {
                f773rg = str;
                if (aaa) {
                    nativeSetStatisticParam(str);
                }
            }
        }
    }

    public static synchronized void setUploadCrashLogFailedEncrypt(boolean z) {
        synchronized (ZwCrashpad.class) {
            if (tt) {
                vvv = z ? "true" : "false";
                if (aaa) {
                    nativeSetUploadCrashLogFailedEncrypt(z);
                }
            }
        }
    }

    public static synchronized void setWebviewNumber(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, ggg)) {
                ggg = str;
                if (aaa) {
                    nativeSetWebviewNumber(str);
                }
            }
        }
    }

    public static synchronized void setZeusVersion(String str) {
        synchronized (ZwCrashpad.class) {
            if (tt && !TextUtils.equals(str, f770i)) {
                f770i = str;
                if (aaa) {
                    nativeSetZeusVersion(str);
                }
            }
        }
    }
}
