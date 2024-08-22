package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.baidu.nps.pm.manager.PackageManagerNative;
import com.baidu.nps.utils.FileUtils;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class NativeLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14793a = "NativeLoader";

    /* renamed from: b  reason: collision with root package name */
    private static Context f14794b;

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f14795c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f14796d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static NativeLoader f14797e;

    /* renamed from: f  reason: collision with root package name */
    private static a f14798f = a.ARMEABI;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f14799g = false;

    /* renamed from: h  reason: collision with root package name */
    private static String f14800h = null;

    private enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        

        /* renamed from: g  reason: collision with root package name */
        private String f14807g;

        private a(String str) {
            this.f14807g = str;
        }

        public String a() {
            return this.f14807g;
        }
    }

    private NativeLoader() {
    }

    static void a(boolean z, String str) {
        f14799g = z;
        f14800h = str;
    }

    private boolean b(String str) {
        try {
            Set<String> set = f14795c;
            synchronized (set) {
                if (set.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (set) {
                    set.add(str);
                }
                return true;
            }
        } catch (Throwable th2) {
            return a(str);
        }
    }

    private boolean c(String str, String str2) {
        if (a(str2, a.ARMEABI)) {
            return g(str2, str);
        }
        Log.e(f14793a, "found lib " + a.ARMEABI.a() + "/" + str + ".so error");
        return false;
    }

    private boolean d(String str, String str2) {
        if (!a(str2, a.ARMV7)) {
            return c(str, str2);
        }
        return g(str2, str);
    }

    private boolean e(String str, String str2) {
        if (!a(str2, a.X86_64)) {
            return f(str, str2);
        }
        return g(str2, str);
    }

    private boolean f(String str, String str2) {
        if (!a(str2, a.X86)) {
            return d(str, str2);
        }
        return g(str2, str);
    }

    private boolean g(String str, String str2) {
        try {
            System.load(new File(b(), str).getAbsolutePath());
            Set<String> set = f14795c;
            synchronized (set) {
                set.add(str2);
            }
            a(str, str2);
            return true;
        } catch (Throwable th2) {
            Set<String> set2 = f14796d;
            synchronized (set2) {
                set2.add(str2);
                a(th2);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (f14797e == null) {
                f14797e = new NativeLoader();
                f14798f = c();
            }
            nativeLoader = f14797e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        f14794b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!f14799g) {
            return b(str);
        }
        String str2 = f14800h;
        if (str2 == null || str2.isEmpty()) {
            Log.e(f14793a, "Given custom so file path is null, please check!");
            return false;
        }
        return a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        switch(com.baidu.mapsdkplatform.comapi.e.f14893a[f14798f.ordinal()]) {
            case 1: goto L_0x0034;
            case 2: goto L_0x002f;
            case 3: goto L_0x002a;
            case 4: goto L_0x0025;
            case 5: goto L_0x0020;
            default: goto L_0x001e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r0 = f(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0 = e(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = c(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = d(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        r0 = b(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = java.lang.System.mapLibraryName(r5)
            java.util.Set<java.lang.String> r1 = f14795c
            monitor-enter(r1)
            boolean r2 = r1.contains(r5)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0010
            r5 = 1
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            return r5
        L_0x0010:
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            int[] r2 = com.baidu.mapsdkplatform.comapi.e.f14893a
            com.baidu.mapsdkplatform.comapi.NativeLoader$a r3 = f14798f
            int r3 = r3.ordinal()
            r2 = r2[r3]
            switch(r2) {
                case 1: goto L_0x0034;
                case 2: goto L_0x002f;
                case 3: goto L_0x002a;
                case 4: goto L_0x0025;
                case 5: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r0 = 0
            goto L_0x0038
        L_0x0020:
            boolean r0 = r4.f(r5, r0)
            goto L_0x0038
        L_0x0025:
            boolean r0 = r4.e(r5, r0)
            goto L_0x0038
        L_0x002a:
            boolean r0 = r4.c(r5, r0)
            goto L_0x0038
        L_0x002f:
            boolean r0 = r4.d(r5, r0)
            goto L_0x0038
        L_0x0034:
            boolean r0 = r4.b(r5, r0)
        L_0x0038:
            monitor-enter(r1)
            r1.add(r5)     // Catch:{ all -> 0x003e }
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r0
        L_0x003e:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r5
        L_0x0041:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.NativeLoader.a(java.lang.String):boolean");
    }

    private static a c() {
        String str;
        if (Build.VERSION.SDK_INT < 21) {
            str = Build.CPU_ABI;
        } else {
            str = Build.SUPPORTED_ABIS[0];
        }
        if (str == null) {
            return a.ARMEABI;
        }
        if (str.contains(FileUtils.PATH_ARM) && str.contains("v7")) {
            f14798f = a.ARMV7;
        }
        if (str.contains(FileUtils.PATH_ARM) && str.contains("64") && d()) {
            f14798f = a.ARM64;
        }
        if (str.contains("x86")) {
            if (str.contains("64")) {
                f14798f = a.X86_64;
            } else {
                f14798f = a.X86;
            }
        }
        return f14798f;
    }

    private static boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            return Build.CPU_ABI.equals(Build.SUPPORTED_64_BIT_ABIS[0]);
        }
        return false;
    }

    private boolean b(String str, String str2) {
        if (!a(str2, a.ARM64)) {
            return d(str, str2);
        }
        return g(str2, str);
    }

    private String b() {
        if (f14794b == null) {
            return "";
        }
        File file = new File(f14794b.getFilesDir(), PluginInvokerConstants.LISTENER_CATE_LIBS + File.separator + f14798f.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090 A[SYNTHETIC, Splitter:B:42:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d A[SYNTHETIC, Splitter:B:48:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r7, com.baidu.mapsdkplatform.comapi.NativeLoader.a r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Release file failed"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r6.b()
            r1.<init>(r2, r7)
            boolean r2 = r1.exists()
            r3 = 1
            if (r2 == 0) goto L_0x001d
            long r1 = r1.length()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x001d
            return r3
        L_0x001d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = r6.a((com.baidu.mapsdkplatform.comapi.NativeLoader.a) r8)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.StringBuilder r8 = r8.append(r7)
            java.lang.String r8 = r8.toString()
            r1 = 0
            boolean r2 = f14799g
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r6.a()
            goto L_0x003e
        L_0x003c:
            java.lang.String r2 = f14800h
        L_0x003e:
            r4 = 0
            if (r2 == 0) goto L_0x00a8
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L_0x0048
            goto L_0x00a8
        L_0x0048:
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0086 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0086 }
            java.util.zip.ZipEntry r8 = r5.getEntry(r8)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            if (r8 != 0) goto L_0x005e
            r5.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r7 = move-exception
            java.lang.String r8 = f14793a
            android.util.Log.e(r8, r0, r7)
        L_0x005d:
            return r4
        L_0x005e:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            java.lang.String r2 = r6.b()     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r1.<init>(r2, r7)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            java.io.InputStream r7 = r5.getInputStream(r8)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r6.a((java.io.InputStream) r7, (java.io.FileOutputStream) r8)     // Catch:{ Exception -> 0x0081, all -> 0x007e }
            r5.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007d
        L_0x0077:
            r7 = move-exception
            java.lang.String r8 = f14793a
            android.util.Log.e(r8, r0, r7)
        L_0x007d:
            return r3
        L_0x007e:
            r7 = move-exception
            r1 = r5
            goto L_0x009b
        L_0x0081:
            r7 = move-exception
            r1 = r5
            goto L_0x0087
        L_0x0084:
            r7 = move-exception
            goto L_0x009b
        L_0x0086:
            r7 = move-exception
        L_0x0087:
            java.lang.String r8 = f14793a     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = "Copy library file error"
            android.util.Log.e(r8, r2, r7)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x009a
            r1.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x009a
        L_0x0094:
            r7 = move-exception
            java.lang.String r8 = f14793a
            android.util.Log.e(r8, r0, r7)
        L_0x009a:
            return r4
        L_0x009b:
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a7
        L_0x00a1:
            r8 = move-exception
            java.lang.String r1 = f14793a
            android.util.Log.e(r1, r0, r8)
        L_0x00a7:
            throw r7
        L_0x00a8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.NativeLoader.a(java.lang.String, com.baidu.mapsdkplatform.comapi.NativeLoader$a):boolean");
    }

    private void a(String str, String str2) {
        if (str != null && !str.isEmpty() && str.contains("libBaiduMapSDK_")) {
            try {
                String[] split = str.split("_v");
                if (split.length > 1) {
                    File[] listFiles = new File(b()).listFiles(new d(this, split[1]));
                    if (listFiles != null && listFiles.length != 0) {
                        for (File delete : listFiles) {
                            delete.delete();
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    private String a() {
        if (f14794b != null && 8 <= Build.VERSION.SDK_INT) {
            return f14794b.getPackageCodePath();
        }
        return "";
    }

    private void a(Throwable th2) {
        Log.e(f14793a, "loadException", th2);
        for (String str : f14796d) {
            Log.e(f14793a, str + " Failed to load.");
        }
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e(f14793a, "Close InputStream error", e2);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    Log.e(f14793a, "Close OutputStream error", e3);
                }
            }
        }
        fileOutputStream.flush();
    }

    private String a(a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(PackageManagerNative.APK_LIB_DIR_PREFIX).append(aVar.a()).append("/");
        return sb.toString();
    }
}
