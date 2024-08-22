package com.baidu.sofire.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.w;
import com.baidu.sofire.l.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class c implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static c d;
    public static Context e;
    public static int f;
    public static List<Integer> g = new ArrayList();
    public volatile boolean a = false;
    public com.baidu.sofire.j.a b;
    public com.baidu.sofire.c.a c;

    public class a implements Comparator<ApkInfo> {
        public final /* synthetic */ List a;

        public a(c cVar, List list) {
            this.a = list;
        }

        public int compare(Object obj, Object obj2) {
            int i2;
            ApkInfo apkInfo = (ApkInfo) obj;
            ApkInfo apkInfo2 = (ApkInfo) obj2;
            int i3 = apkInfo.priority;
            if (i3 != -1 || apkInfo2.priority == -1) {
                if ((i3 != -1 && apkInfo2.priority == -1) || i3 < (i2 = apkInfo2.priority)) {
                    return -1;
                }
                if (i3 <= i2) {
                    List list = this.a;
                    int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo.key))) ? -1 : this.a.indexOf(Integer.valueOf(apkInfo.key));
                    List list2 = this.a;
                    int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo2.key))) ? -1 : this.a.indexOf(Integer.valueOf(apkInfo2.key));
                    if (indexOf != -1 && indexOf2 == -1) {
                        return -1;
                    }
                    if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                        if (indexOf < indexOf2) {
                            return -1;
                        }
                        return 0;
                    }
                }
            }
            return 1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public class a extends TimerTask {
            public final /* synthetic */ j a;
            public final /* synthetic */ ApkInfo b;
            public final /* synthetic */ File c;

            public a(j jVar, ApkInfo apkInfo, File file) {
                this.a = jVar;
                this.b = apkInfo;
                this.c = file;
            }

            public void run() {
                String str;
                ApkInfo b2 = this.a.b(b.this.a);
                if (b2 != null && (str = b2.versionName) != null && str.equals(this.b.versionName)) {
                    this.a.d(b.this.a);
                    b bVar = b.this;
                    c.this.c.a(bVar.a);
                    com.baidu.sofire.l.c.q(c.e);
                    File file = new File(this.b.pkgPath);
                    if (file.exists()) {
                        com.baidu.sofire.a.b.a(file);
                        file.delete();
                    }
                    if (this.c.exists()) {
                        File file2 = this.c;
                        File file3 = new File(file2, this.b.key + IStringUtil.CURRENT_PATH + this.b.versionName + ".b");
                        if (com.baidu.sofire.l.c.a(file3)) {
                            file3.delete();
                        }
                    }
                    if (file.getParentFile() != null) {
                        com.baidu.sofire.l.c.e(file.getParentFile().getAbsolutePath());
                    }
                }
            }
        }

        public b(String str) {
            this.a = str;
        }

        public void run() {
            j a2;
            try {
                if (!TextUtils.isEmpty(this.a) && (a2 = j.a(c.e.getApplicationContext())) != null) {
                    ApkInfo b2 = a2.b(this.a);
                    if (b2 == null) {
                        ApkInfo b3 = c.this.c.b(this.a);
                        if (b3 != null) {
                            File parentFile = new File(b3.pkgPath).getParentFile();
                            if (parentFile.exists()) {
                                File file = new File(parentFile, b3.key + IStringUtil.CURRENT_PATH + b3.versionName + ".b");
                                if (com.baidu.sofire.l.c.a(file)) {
                                    file.delete();
                                }
                            }
                            c.this.a(this.a, b3.pkgPath);
                            String canonicalPath = new File(com.baidu.sofire.l.c.f(c.e), "sofire_tmp").getCanonicalPath();
                            com.baidu.sofire.l.c.e(canonicalPath + "/." + b3.key);
                            com.baidu.sofire.l.c.e(c.e.getFileStreamPath(b3.packageName).getAbsolutePath());
                            return;
                        }
                        return;
                    }
                    File parentFile2 = new File(b2.pkgPath).getParentFile();
                    Class<?> a3 = ((i) b2.classLoader).a(com.baidu.sofire.l.c.c(b2.es));
                    Object invoke = a3.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a3, new Object[]{c.e});
                    if (invoke != null) {
                        new Timer().schedule(new a(a2, b2, parentFile2), 600000);
                        com.baidu.sofire.l.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                        a2.d(this.a);
                        c.this.c.a(this.a);
                        com.baidu.sofire.l.c.q(c.e);
                        File file2 = new File(b2.pkgPath);
                        if (file2.exists()) {
                            com.baidu.sofire.a.b.a(file2);
                            file2.delete();
                        }
                        if (parentFile2.exists()) {
                            File file3 = new File(parentFile2, b2.key + IStringUtil.CURRENT_PATH + b2.versionName + ".b");
                            if (com.baidu.sofire.l.c.a(file3)) {
                                file3.delete();
                            }
                        }
                        if (file2.getParentFile() != null) {
                            com.baidu.sofire.l.c.e(file2.getParentFile().getAbsolutePath());
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        e = applicationContext;
        this.c = com.baidu.sofire.c.a.a(applicationContext);
        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(e);
        this.b = a2;
        SharedPreferences g2 = a2.g();
        if (g2 != null) {
            g2.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c(context.getApplicationContext());
            }
            cVar = d;
        }
        return cVar;
    }

    public void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if ("3".equals(str)) {
                    if ("925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                        return;
                    }
                }
                com.baidu.sofire.l.c.c = str;
                com.baidu.sofire.l.c.d = str2;
                com.baidu.sofire.j.a aVar = this.b;
                SharedPreferences.Editor editor = aVar.b;
                editor.putString("svi_n", str + "-" + str2);
                aVar.b.commit();
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public void c(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if ("3".equals(str)) {
                    if ("925fc15df8a49bed0b3eca8d2b44cb7b".equals(str2)) {
                        return;
                    }
                }
                com.baidu.sofire.j.a aVar = this.b;
                SharedPreferences.Editor editor = aVar.b;
                editor.putString("svi", str + "-" + str2);
                aVar.b.commit();
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            try {
                if (str.equals("xytk")) {
                    d.a = this.b.c.getString("xytk", "");
                    if (com.baidu.sofire.k.a.b()) {
                        x a2 = x.a(e);
                        String str2 = d.a;
                        a2.getClass();
                        synchronized (x.k) {
                            if (a2.b(false)) {
                                if (a2.c != null) {
                                    a2.a(str2, a2.e, true);
                                    a2.b();
                                }
                            }
                        }
                    }
                }
                if (str.equals("xyus")) {
                    this.b.a();
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:5|(2:7|(4:9|10|11|12))|13|(1:15)|16|17|18|19|(3:21|22|23)|24|25|26|27|28|29|30|31|32|(2:33|(5:35|36|37|(2:41|61)(2:42|62)|59)(4:60|43|(1:45)(5:46|47|48|49|50)|51))) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:38|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:52|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|48|49|50) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x009b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x010d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0120 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083 A[Catch:{ all -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cf A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.a     // Catch:{ all -> 0x0120 }
            if (r0 == 0) goto L_0x0007
            goto L_0x0122
        L_0x0007:
            r0 = 1
            r10.a = r0     // Catch:{ all -> 0x0120 }
            android.content.Context r1 = e     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.l.r.e(r1)     // Catch:{ all -> 0x0120 }
            android.content.Context r1 = e     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.l.c.n(r1)     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.j.a r1 = r10.b     // Catch:{ all -> 0x0120 }
            r1.a((boolean) r0)     // Catch:{ all -> 0x0120 }
            boolean r1 = com.baidu.sofire.k.a.b()     // Catch:{ all -> 0x0120 }
            if (r1 == 0) goto L_0x0032
            android.content.Context r1 = e     // Catch:{ all -> 0x0120 }
            boolean r2 = com.baidu.sofire.k.a.a()     // Catch:{ all -> 0x0120 }
            if (r2 != 0) goto L_0x0028
            goto L_0x0032
        L_0x0028:
            com.baidu.sofire.xclient.frd.FDM r1 = com.baidu.sofire.xclient.frd.FDM.getInstance(r1)     // Catch:{ all -> 0x0030 }
            r1.detect()     // Catch:{ all -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0120 }
        L_0x0032:
            android.content.Context r1 = e     // Catch:{ all -> 0x0120 }
            org.json.JSONObject r1 = com.baidu.sofire.l.c.o(r1)     // Catch:{ all -> 0x0120 }
            if (r1 != 0) goto L_0x0046
            com.baidu.sofire.j.a r2 = r10.b     // Catch:{ all -> 0x0120 }
            android.content.SharedPreferences r2 = r2.a     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = "s_n_m_c_s"
            boolean r2 = r2.getBoolean(r3, r0)     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.l.l.a = r2     // Catch:{ all -> 0x0120 }
        L_0x0046:
            android.content.Context r3 = e     // Catch:{ all -> 0x0120 }
            java.lang.String r6 = "3.6.7.0"
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x0051
            goto L_0x0060
        L_0x0051:
            java.lang.String r5 = "com.baidu.sofire"
            com.baidu.sofire.l.c.q(r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "sofire"
            java.lang.String r7 = "1003003"
            java.lang.String r8 = "1003002"
            r9 = 1
            com.baidu.sofire.l.c.a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0060 }
        L_0x0060:
            com.baidu.sofire.j.a r2 = r10.b     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = "3.6.7.0"
            android.content.SharedPreferences$Editor r4 = r2.b     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = "ssv"
            r4.putString(r5, r3)     // Catch:{ all -> 0x0120 }
            android.content.SharedPreferences$Editor r2 = r2.b     // Catch:{ all -> 0x0120 }
            r2.commit()     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.c.a r2 = r10.c     // Catch:{ all -> 0x0120 }
            java.util.List r2 = r2.b()     // Catch:{ all -> 0x0120 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0124 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0120 }
        L_0x007c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0120 }
            r4 = 0
            if (r3 == 0) goto L_0x00cf
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.core.ApkInfo r3 = (com.baidu.sofire.core.ApkInfo) r3     // Catch:{ all -> 0x0120 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x009b }
            android.content.Context r6 = e     // Catch:{ IOException -> 0x009b }
            java.io.File r6 = com.baidu.sofire.l.c.f((android.content.Context) r6)     // Catch:{ IOException -> 0x009b }
            java.lang.String r7 = "sofire_tmp"
            r5.<init>(r6, r7)     // Catch:{ IOException -> 0x009b }
            java.lang.String r4 = r5.getCanonicalPath()     // Catch:{ IOException -> 0x009b }
            goto L_0x009d
        L_0x009b:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0120 }
        L_0x009d:
            if (r4 != 0) goto L_0x00a0
            goto L_0x007c
        L_0x00a0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0120 }
            r5.<init>()     // Catch:{ all -> 0x0120 }
            r5.append(r4)     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "/."
            r5.append(r4)     // Catch:{ all -> 0x0120 }
            int r4 = r3.key     // Catch:{ all -> 0x0120 }
            r5.append(r4)     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0120 }
            r3.dataDir = r4     // Catch:{ all -> 0x0120 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0120 }
            r4.<init>()     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r3.dataDir     // Catch:{ all -> 0x0120 }
            r4.append(r3)     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = "/lib"
            r4.append(r3)     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.l.c.e((java.lang.String) r3)     // Catch:{ all -> 0x0120 }
            goto L_0x007c
        L_0x00cf:
            com.baidu.sofire.c.a r2 = r10.c     // Catch:{ all -> 0x0120 }
            r2.a()     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.j.a r2 = r10.b     // Catch:{ all -> 0x0120 }
            android.content.SharedPreferences r2 = r2.a     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = "iio"
            r5 = 0
            boolean r2 = r2.getBoolean(r3, r5)     // Catch:{ all -> 0x0120 }
            if (r2 != 0) goto L_0x00f0
            com.baidu.sofire.j.a r2 = r10.b     // Catch:{ all -> 0x0120 }
            android.content.SharedPreferences$Editor r3 = r2.b     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "iio"
            r3.putBoolean(r4, r0)     // Catch:{ all -> 0x0120 }
            android.content.SharedPreferences$Editor r2 = r2.b     // Catch:{ all -> 0x0120 }
            r2.commit()     // Catch:{ all -> 0x0120 }
            goto L_0x010f
        L_0x00f0:
            com.baidu.sofire.c.a r2 = r10.c     // Catch:{ all -> 0x0120 }
            r2.getClass()     // Catch:{ all -> 0x0120 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x0120 }
            r3.<init>()     // Catch:{ all -> 0x0120 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0120 }
            java.lang.String r7 = "n"
            r3.put(r7, r6)     // Catch:{ all -> 0x0120 }
            android.database.sqlite.SQLiteDatabase r2 = r2.b     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "pgn"
            java.lang.String r7 = "n=-1"
            r2.update(r6, r3, r7, r4)     // Catch:{ all -> 0x010d }
            goto L_0x010f
        L_0x010d:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0120 }
        L_0x010f:
            android.content.Context r2 = e     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.l.w r2 = com.baidu.sofire.l.w.a((android.content.Context) r2)     // Catch:{ all -> 0x0120 }
            com.baidu.sofire.ac.U r3 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x0120 }
            android.content.Context r4 = e     // Catch:{ all -> 0x0120 }
            r3.<init>(r4, r0, r5, r1)     // Catch:{ all -> 0x0120 }
            r2.b(r3)     // Catch:{ all -> 0x0120 }
            goto L_0x0122
        L_0x0120:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0124 }
        L_0x0122:
            monitor-exit(r10)
            return
        L_0x0124:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a():void");
    }

    public void c(String str) {
        j jVar;
        ApkInfo b2;
        try {
            if (!TextUtils.isEmpty(str) && (jVar = j.g) != null && (b2 = jVar.b(str)) != null) {
                Class<?> a2 = ((i) b2.classLoader).a(com.baidu.sofire.l.c.c(b2.es));
                Object invoke = a2.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a2, new Object[]{e});
                if (invoke != null) {
                    com.baidu.sofire.l.c.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                    jVar.d(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r9 = this;
            com.baidu.sofire.c.a r0 = r9.c     // Catch:{ all -> 0x0101 }
            java.util.List r0 = r0.b()     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.j.a r1 = r9.b     // Catch:{ all -> 0x0101 }
            java.util.List r1 = r1.f()     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.j.a r2 = r9.b     // Catch:{ all -> 0x0101 }
            java.util.List r2 = r2.e()     // Catch:{ all -> 0x0101 }
            r3 = 0
            r4 = 0
        L_0x0014:
            r5 = r2
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()     // Catch:{ all -> 0x0101 }
            if (r4 >= r6) goto L_0x0034
            java.lang.Object r6 = r5.get(r4)     // Catch:{ all -> 0x0101 }
            r7 = r1
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            boolean r6 = r7.contains(r6)     // Catch:{ all -> 0x0101 }
            if (r6 != 0) goto L_0x0031
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x0101 }
            r7.add(r5)     // Catch:{ all -> 0x0101 }
        L_0x0031:
            int r4 = r4 + 1
            goto L_0x0014
        L_0x0034:
            com.baidu.sofire.b.c$a r2 = new com.baidu.sofire.b.c$a     // Catch:{ all -> 0x0101 }
            r2.<init>(r9, r1)     // Catch:{ all -> 0x0101 }
            java.util.Collections.sort(r0, r2)     // Catch:{ all -> 0x0101 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0101 }
        L_0x0042:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0101 }
            if (r1 == 0) goto L_0x0103
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.core.ApkInfo r1 = (com.baidu.sofire.core.ApkInfo) r1     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.b.j r2 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x0101 }
            r4 = 0
            if (r2 == 0) goto L_0x005a
            java.lang.String r5 = r1.packageName     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.core.ApkInfo r2 = r2.b((java.lang.String) r5)     // Catch:{ all -> 0x0101 }
            goto L_0x005b
        L_0x005a:
            r2 = r4
        L_0x005b:
            if (r2 == 0) goto L_0x005e
            goto L_0x0042
        L_0x005e:
            com.baidu.sofire.c.a r2 = r9.c     // Catch:{ all -> 0x0101 }
            int r5 = r1.key     // Catch:{ all -> 0x0101 }
            int r2 = r2.c(r5)     // Catch:{ all -> 0x0101 }
            r5 = 3
            if (r2 != r5) goto L_0x006b
            r2 = 0
            goto L_0x006c
        L_0x006b:
            r2 = 1
        L_0x006c:
            com.baidu.sofire.j.a r5 = r9.b     // Catch:{ all -> 0x0101 }
            boolean r5 = r5.n()     // Catch:{ all -> 0x0101 }
            if (r5 == 0) goto L_0x00b4
            if (r2 == 0) goto L_0x00b4
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0101 }
            java.lang.String r5 = r1.pkgPath     // Catch:{ all -> 0x0101 }
            r2.<init>(r5)     // Catch:{ all -> 0x0101 }
            java.io.File r5 = r2.getParentFile()     // Catch:{ all -> 0x0101 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0101 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r7.<init>()     // Catch:{ all -> 0x0101 }
            int r8 = r1.key     // Catch:{ all -> 0x0101 }
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = "."
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = r1.versionName     // Catch:{ all -> 0x0101 }
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = ".b"
            r7.append(r8)     // Catch:{ all -> 0x0101 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0101 }
            r6.<init>(r5, r7)     // Catch:{ all -> 0x0101 }
            boolean r5 = com.baidu.sofire.l.c.a((java.io.File) r6)     // Catch:{ all -> 0x0101 }
            if (r5 != 0) goto L_0x00ac
            com.baidu.sofire.b.l.a((java.io.File) r2, (java.io.File) r6)     // Catch:{ all -> 0x0101 }
        L_0x00ac:
            android.content.Context r5 = e     // Catch:{ all -> 0x0101 }
            int r7 = r1.key     // Catch:{ all -> 0x0101 }
            com.baidu.sofire.a.b.a(r5, r7, r2, r6)     // Catch:{ all -> 0x0101 }
            goto L_0x00f3
        L_0x00b4:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0101 }
            java.lang.String r5 = r1.pkgPath     // Catch:{ all -> 0x0101 }
            r2.<init>(r5)     // Catch:{ all -> 0x0101 }
            java.io.File r2 = r2.getParentFile()     // Catch:{ all -> 0x0101 }
            boolean r5 = r2.exists()     // Catch:{ all -> 0x0101 }
            if (r5 == 0) goto L_0x00f3
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0101 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r6.<init>()     // Catch:{ all -> 0x0101 }
            int r7 = r1.key     // Catch:{ all -> 0x0101 }
            r6.append(r7)     // Catch:{ all -> 0x0101 }
            java.lang.String r7 = "."
            r6.append(r7)     // Catch:{ all -> 0x0101 }
            java.lang.String r7 = r1.versionName     // Catch:{ all -> 0x0101 }
            r6.append(r7)     // Catch:{ all -> 0x0101 }
            java.lang.String r7 = ".b"
            r6.append(r7)     // Catch:{ all -> 0x0101 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0101 }
            r5.<init>(r2, r6)     // Catch:{ all -> 0x0101 }
            boolean r2 = com.baidu.sofire.l.c.a((java.io.File) r5)     // Catch:{ all -> 0x0101 }
            if (r2 == 0) goto L_0x00f3
            com.baidu.sofire.a.b.a(r5)     // Catch:{ all -> 0x0101 }
            r5.delete()     // Catch:{ all -> 0x0101 }
        L_0x00f3:
            int r2 = r1.key     // Catch:{ all -> 0x0101 }
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x0101 }
            monitor-enter(r9)     // Catch:{ all -> 0x0101 }
            r9.a((int) r2, (java.lang.String) r1, (boolean) r3, (android.content.pm.PackageInfo) r4)     // Catch:{ all -> 0x00fe }
            monitor-exit(r9)     // Catch:{ all -> 0x0101 }
            goto L_0x0042
        L_0x00fe:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0101 }
            throw r0     // Catch:{ all -> 0x0101 }
        L_0x0101:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.b():void");
    }

    public void b(String str) {
        try {
            w.a(e).a((Runnable) new b(str));
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:52|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:43|44|76) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
        r14 = r8;
        r15 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ef */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "t"
            java.lang.String r2 = "n"
            java.lang.String r3 = "l"
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r4 = "6"
            org.json.JSONArray r0 = r0.optJSONArray(r4)     // Catch:{ all -> 0x0145 }
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            r5 = 0
        L_0x0015:
            int r6 = r0.length()     // Catch:{ all -> 0x0145 }
            if (r5 >= r6) goto L_0x013a
            org.json.JSONObject r6 = r0.optJSONObject(r5)     // Catch:{ all -> 0x0145 }
            java.lang.String r8 = "errno"
            int r8 = r6.optInt(r8)     // Catch:{ all -> 0x0145 }
            int r9 = r6.optInt(r3)     // Catch:{ all -> 0x0145 }
            r10 = 1
            if (r8 != r10) goto L_0x0136
            java.lang.String r8 = "detail"
            org.json.JSONObject r6 = r6.optJSONObject(r8)     // Catch:{ all -> 0x010b }
            java.lang.String r8 = "es"
            java.lang.String r8 = r6.optString(r8)     // Catch:{ all -> 0x010b }
            android.content.pm.PackageInfo r10 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x010d }
            r10.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r11 = "p"
            java.lang.String r11 = r6.optString(r11)     // Catch:{ all -> 0x010d }
            r10.packageName = r11     // Catch:{ all -> 0x010d }
            java.lang.String r11 = "v"
            java.lang.String r11 = r6.optString(r11)     // Catch:{ all -> 0x010d }
            r10.versionName = r11     // Catch:{ all -> 0x010d }
            android.content.pm.ApplicationInfo r11 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x010d }
            r11.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r12 = r6.optString(r2)     // Catch:{ all -> 0x010d }
            r11.className = r12     // Catch:{ all -> 0x010d }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x010d }
            java.lang.String r13 = "."
            if (r12 != 0) goto L_0x007d
            java.lang.String r12 = r11.className     // Catch:{ all -> 0x010d }
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x010d }
            if (r12 == 0) goto L_0x007d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x010d }
            r12.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r14 = r10.packageName     // Catch:{ all -> 0x010d }
            r12.append(r14)     // Catch:{ all -> 0x010d }
            java.lang.String r14 = r11.className     // Catch:{ all -> 0x010d }
            r12.append(r14)     // Catch:{ all -> 0x010d }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x010d }
            r11.className = r12     // Catch:{ all -> 0x010d }
        L_0x007d:
            int r12 = r6.optInt(r1)     // Catch:{ all -> 0x010d }
            r11.theme = r12     // Catch:{ all -> 0x010d }
            r10.applicationInfo = r11     // Catch:{ all -> 0x010d }
            java.lang.String r11 = "a"
            org.json.JSONArray r6 = r6.optJSONArray(r11)     // Catch:{ all -> 0x010d }
            if (r6 == 0) goto L_0x0108
            int r11 = r6.length()     // Catch:{ all -> 0x010d }
            if (r11 <= 0) goto L_0x0108
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x010d }
            r11.<init>()     // Catch:{ all -> 0x010d }
            r12 = 0
        L_0x0099:
            int r14 = r6.length()     // Catch:{ all -> 0x010d }
            if (r12 >= r14) goto L_0x00f4
            org.json.JSONObject r14 = r6.getJSONObject(r12)     // Catch:{ all -> 0x00ef }
            if (r14 == 0) goto L_0x00f1
            android.content.pm.ActivityInfo r15 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x00ef }
            r15.<init>()     // Catch:{ all -> 0x00ef }
            java.lang.String r4 = r14.optString(r2)     // Catch:{ all -> 0x00ef }
            r15.name = r4     // Catch:{ all -> 0x00ef }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00ef }
            if (r4 != 0) goto L_0x00d3
            java.lang.String r4 = r15.name     // Catch:{ all -> 0x00ef }
            boolean r4 = r4.startsWith(r13)     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x00d3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ef }
            r4.<init>()     // Catch:{ all -> 0x00ef }
            java.lang.String r7 = r10.packageName     // Catch:{ all -> 0x00ef }
            r4.append(r7)     // Catch:{ all -> 0x00ef }
            java.lang.String r7 = r15.name     // Catch:{ all -> 0x00ef }
            r4.append(r7)     // Catch:{ all -> 0x00ef }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00ef }
            r15.name = r4     // Catch:{ all -> 0x00ef }
        L_0x00d3:
            java.lang.String r4 = r10.packageName     // Catch:{ all -> 0x00ef }
            r15.packageName = r4     // Catch:{ all -> 0x00ef }
            int r4 = r14.optInt(r1)     // Catch:{ all -> 0x00ef }
            r15.theme = r4     // Catch:{ all -> 0x00ef }
            int r4 = r14.optInt(r3)     // Catch:{ all -> 0x00ef }
            r15.labelRes = r4     // Catch:{ all -> 0x00ef }
            java.lang.String r4 = r15.name     // Catch:{ all -> 0x00ef }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00ef }
            if (r4 != 0) goto L_0x00f1
            r11.add(r15)     // Catch:{ all -> 0x00ef }
            goto L_0x00f1
        L_0x00ef:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x010d }
        L_0x00f1:
            int r12 = r12 + 1
            goto L_0x0099
        L_0x00f4:
            int r4 = r11.size()     // Catch:{ all -> 0x010d }
            if (r4 <= 0) goto L_0x0108
            int r4 = r11.size()     // Catch:{ all -> 0x010d }
            android.content.pm.ActivityInfo[] r4 = new android.content.pm.ActivityInfo[r4]     // Catch:{ all -> 0x010d }
            java.lang.Object[] r4 = r11.toArray(r4)     // Catch:{ all -> 0x010d }
            android.content.pm.ActivityInfo[] r4 = (android.content.pm.ActivityInfo[]) r4     // Catch:{ all -> 0x010d }
            r10.activities = r4     // Catch:{ all -> 0x010d }
        L_0x0108:
            r14 = r8
            r15 = r10
            goto L_0x0111
        L_0x010b:
            java.lang.String r8 = ""
        L_0x010d:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0145 }
            r14 = r8
            r15 = 0
        L_0x0111:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r4 = com.baidu.sofire.l.c.f1092o     // Catch:{ all -> 0x0145 }
            if (r4 == 0) goto L_0x0136
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0145 }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ all -> 0x0145 }
            com.baidu.sofire.core.ApkInfo r4 = (com.baidu.sofire.core.ApkInfo) r4     // Catch:{ all -> 0x0145 }
            if (r4 == 0) goto L_0x0136
            if (r15 == 0) goto L_0x0136
            java.lang.String r6 = r15.packageName     // Catch:{ all -> 0x0145 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0145 }
            if (r6 != 0) goto L_0x0136
            int r11 = r4.key     // Catch:{ all -> 0x0145 }
            java.lang.String r12 = r4.versionName     // Catch:{ all -> 0x0145 }
            java.lang.String r13 = r4.apkMD5     // Catch:{ all -> 0x0145 }
            r10 = r16
            r10.a((int) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (android.content.pm.PackageInfo) r15)     // Catch:{ all -> 0x0145 }
        L_0x0136:
            int r5 = r5 + 1
            goto L_0x0015
        L_0x013a:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r0 = com.baidu.sofire.l.c.f1092o     // Catch:{ all -> 0x0145 }
            if (r0 == 0) goto L_0x0147
            r0.clear()     // Catch:{ all -> 0x0145 }
            r0 = 0
            com.baidu.sofire.l.c.f1092o = r0     // Catch:{ all -> 0x0145 }
            goto L_0x0147
        L_0x0145:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(org.json.JSONObject):void");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:13|(1:15)|16|(1:18)|19|20|21|22|23|(2:24|(1:26)(1:141))|27|(2:29|(1:31)(4:32|(1:34)|35|(2:42|(2:44|(1:46)))(3:38|(1:40)|41)))|47|(1:49)|50|51|52|53|142) */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x014c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f1 A[Catch:{ all -> 0x0227 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x021a  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            r7 = this;
            com.baidu.sofire.c.a r0 = r7.c     // Catch:{ all -> 0x0015 }
            com.baidu.sofire.core.ApkInfo r0 = r0.b((int) r8)     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.versionName     // Catch:{ all -> 0x0015 }
            boolean r0 = com.baidu.sofire.l.c.b((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ all -> 0x0015 }
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            r7.a((int) r8)     // Catch:{ all -> 0x0015 }
            goto L_0x0017
        L_0x0015:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0017:
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x01e5 }
            r2 = 0
            if (r1 != 0) goto L_0x0154
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01e5 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x01e5 }
            android.content.Context r4 = e     // Catch:{ all -> 0x01e5 }
            java.io.File r4 = com.baidu.sofire.l.c.f((android.content.Context) r4)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "sofire_tmp"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x01e5 }
            java.lang.String r4 = ".tmp"
            r1.<init>(r3, r4)     // Catch:{ all -> 0x01e5 }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x01e5 }
            if (r3 != 0) goto L_0x003c
            r1.mkdirs()     // Catch:{ all -> 0x01e5 }
        L_0x003c:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x01e5 }
            java.lang.String r4 = com.baidu.sofire.l.v.a()     // Catch:{ all -> 0x01e5 }
            r3.<init>(r1, r4)     // Catch:{ all -> 0x01e5 }
            boolean r1 = r3.exists()     // Catch:{ all -> 0x01e5 }
            if (r1 != 0) goto L_0x004e
            r3.mkdirs()     // Catch:{ all -> 0x01e5 }
        L_0x004e:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01e5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r4.<init>()     // Catch:{ all -> 0x01e5 }
            r4.append(r8)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "."
            r4.append(r5)     // Catch:{ all -> 0x01e5 }
            r4.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = ".p"
            r4.append(r5)     // Catch:{ all -> 0x01e5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01e5 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x01e5 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0150 }
            r3.<init>(r1)     // Catch:{ all -> 0x0150 }
            android.content.Context r4 = e     // Catch:{ all -> 0x01e2 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01e2 }
            java.io.InputStream r0 = r4.open(r5)     // Catch:{ all -> 0x01e2 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x01e2 }
        L_0x0083:
            int r5 = r0.read(r4)     // Catch:{ all -> 0x01e2 }
            r6 = -1
            if (r5 == r6) goto L_0x008e
            r3.write(r4, r2, r5)     // Catch:{ all -> 0x01e2 }
            goto L_0x0083
        L_0x008e:
            r3.flush()     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = r1.getAbsolutePath()     // Catch:{ all -> 0x01e2 }
            r5 = 1
            com.baidu.sofire.l.c.a((java.lang.String) r4, (boolean) r5)     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = com.baidu.sofire.l.k.a((java.io.File) r1)     // Catch:{ all -> 0x01e2 }
            if (r4 == 0) goto L_0x0135
            boolean r10 = r4.equalsIgnoreCase(r10)     // Catch:{ all -> 0x01e2 }
            if (r10 != 0) goto L_0x00a7
            goto L_0x0135
        L_0x00a7:
            com.baidu.sofire.core.ApkInfo r10 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x01e2 }
            java.lang.String r6 = r1.getAbsolutePath()     // Catch:{ all -> 0x01e2 }
            r10.<init>(r8, r9, r6)     // Catch:{ all -> 0x01e2 }
            r10.apkMD5 = r4     // Catch:{ all -> 0x01e2 }
            r10.priority = r5     // Catch:{ all -> 0x01e2 }
            r10.es = r11     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.c.a r11 = r7.c     // Catch:{ all -> 0x01e2 }
            r11.a((com.baidu.sofire.core.ApkInfo) r10)     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.c.a r10 = r7.c     // Catch:{ all -> 0x01e2 }
            int r10 = r10.c(r8)     // Catch:{ all -> 0x01e2 }
            r11 = 3
            if (r10 != r11) goto L_0x00c5
            r5 = 0
        L_0x00c5:
            com.baidu.sofire.j.a r10 = r7.b     // Catch:{ all -> 0x01e2 }
            boolean r10 = r10.n()     // Catch:{ all -> 0x01e2 }
            if (r10 == 0) goto L_0x0100
            if (r5 == 0) goto L_0x0100
            java.io.File r10 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r4.<init>()     // Catch:{ all -> 0x01e2 }
            r4.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = "."
            r4.append(r5)     // Catch:{ all -> 0x01e2 }
            r4.append(r9)     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = ".b"
            r4.append(r5)     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01e2 }
            r11.<init>(r10, r4)     // Catch:{ all -> 0x01e2 }
            boolean r10 = com.baidu.sofire.l.c.a((java.io.File) r11)     // Catch:{ all -> 0x01e2 }
            if (r10 != 0) goto L_0x00fa
            com.baidu.sofire.b.l.a((java.io.File) r1, (java.io.File) r11)     // Catch:{ all -> 0x01e2 }
        L_0x00fa:
            android.content.Context r10 = e     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.a.b.a(r10, r8, r1, r11)     // Catch:{ all -> 0x01e2 }
            goto L_0x0156
        L_0x0100:
            java.io.File r10 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            boolean r11 = r10.exists()     // Catch:{ all -> 0x01e2 }
            if (r11 == 0) goto L_0x0156
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r4.<init>()     // Catch:{ all -> 0x01e2 }
            r4.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = "."
            r4.append(r5)     // Catch:{ all -> 0x01e2 }
            r4.append(r9)     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = ".b"
            r4.append(r5)     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01e2 }
            r11.<init>(r10, r4)     // Catch:{ all -> 0x01e2 }
            boolean r10 = com.baidu.sofire.l.c.a((java.io.File) r11)     // Catch:{ all -> 0x01e2 }
            if (r10 == 0) goto L_0x0156
            com.baidu.sofire.a.b.a(r11)     // Catch:{ all -> 0x01e2 }
            r11.delete()     // Catch:{ all -> 0x01e2 }
            goto L_0x0156
        L_0x0135:
            r1.delete()     // Catch:{ all -> 0x01e2 }
            java.io.File r9 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            if (r9 == 0) goto L_0x0149
            java.io.File r9 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.l.c.e((java.lang.String) r9)     // Catch:{ all -> 0x01e2 }
        L_0x0149:
            r0.close()     // Catch:{ IOException -> 0x014c }
        L_0x014c:
            r3.close()     // Catch:{ IOException -> 0x014f }
        L_0x014f:
            return
        L_0x0150:
            r9 = r0
            r3 = r9
            goto L_0x01e3
        L_0x0154:
            r1 = r0
            r3 = r1
        L_0x0156:
            com.baidu.sofire.c.a r10 = r7.c     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.core.ApkInfo r10 = r10.b((int) r8)     // Catch:{ all -> 0x01e2 }
            if (r10 == 0) goto L_0x01d5
            java.lang.String r10 = r10.pkgPath     // Catch:{ all -> 0x01e2 }
            boolean r10 = com.baidu.sofire.l.c.f((java.lang.String) r10)     // Catch:{ all -> 0x01e2 }
            if (r10 != 0) goto L_0x0168
            goto L_0x01d5
        L_0x0168:
            monitor-enter(r7)     // Catch:{ all -> 0x01e2 }
            boolean r10 = r7.a((int) r8, (java.lang.String) r9, (boolean) r2, (android.content.pm.PackageInfo) r12)     // Catch:{ all -> 0x01d2 }
            monitor-exit(r7)     // Catch:{ all -> 0x01e2 }
            if (r10 == 0) goto L_0x0197
            java.util.List<java.lang.Integer> r10 = g     // Catch:{ all -> 0x01e2 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01e2 }
            r10.add(r11)     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.j.a r10 = r7.b     // Catch:{ all -> 0x01e2 }
            android.content.SharedPreferences$Editor r11 = r10.b     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r12.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r2 = "g_l_l_p_v_"
            r12.append(r2)     // Catch:{ all -> 0x01e2 }
            r12.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01e2 }
            r11.putString(r12, r9)     // Catch:{ all -> 0x01e2 }
            android.content.SharedPreferences$Editor r9 = r10.b     // Catch:{ all -> 0x01e2 }
            r9.commit()     // Catch:{ all -> 0x01e2 }
            goto L_0x01c8
        L_0x0197:
            if (r1 == 0) goto L_0x01c8
            boolean r9 = r1.exists()     // Catch:{ all -> 0x01e2 }
            if (r9 == 0) goto L_0x01c8
            com.baidu.sofire.a.b.a(r1)     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.c.a r9 = r7.c     // Catch:{ all -> 0x01e2 }
            r9.a((int) r8)     // Catch:{ all -> 0x01e2 }
            r1.delete()     // Catch:{ all -> 0x01e2 }
            java.io.File r9 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            if (r9 == 0) goto L_0x01bb
            java.io.File r9 = r1.getParentFile()     // Catch:{ all -> 0x01e2 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x01e2 }
            com.baidu.sofire.l.c.e((java.lang.String) r9)     // Catch:{ all -> 0x01e2 }
        L_0x01bb:
            if (r0 == 0) goto L_0x01c2
            r0.close()     // Catch:{ IOException -> 0x01c1 }
            goto L_0x01c2
        L_0x01c1:
        L_0x01c2:
            if (r3 == 0) goto L_0x01c7
            r3.close()     // Catch:{ IOException -> 0x01c7 }
        L_0x01c7:
            return
        L_0x01c8:
            if (r0 == 0) goto L_0x01cf
            r0.close()     // Catch:{ IOException -> 0x01ce }
            goto L_0x01cf
        L_0x01ce:
        L_0x01cf:
            if (r3 == 0) goto L_0x0226
            goto L_0x0223
        L_0x01d2:
            r9 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01e2 }
            throw r9     // Catch:{ all -> 0x01e2 }
        L_0x01d5:
            if (r0 == 0) goto L_0x01dc
            r0.close()     // Catch:{ IOException -> 0x01db }
            goto L_0x01dc
        L_0x01db:
        L_0x01dc:
            if (r3 == 0) goto L_0x01e1
            r3.close()     // Catch:{ IOException -> 0x01e1 }
        L_0x01e1:
            return
        L_0x01e2:
            r9 = r0
        L_0x01e3:
            r0 = r1
            goto L_0x01e7
        L_0x01e5:
            r9 = r0
            r3 = r9
        L_0x01e7:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0227 }
            if (r0 == 0) goto L_0x021a
            boolean r10 = r0.exists()     // Catch:{ all -> 0x0227 }
            if (r10 == 0) goto L_0x021a
            com.baidu.sofire.a.b.a(r0)     // Catch:{ all -> 0x0227 }
            com.baidu.sofire.c.a r10 = r7.c     // Catch:{ all -> 0x0227 }
            r10.a((int) r8)     // Catch:{ all -> 0x0227 }
            r0.delete()     // Catch:{ all -> 0x0227 }
            java.io.File r8 = r0.getParentFile()     // Catch:{ all -> 0x0227 }
            if (r8 == 0) goto L_0x020d
            java.io.File r8 = r0.getParentFile()     // Catch:{ all -> 0x0227 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x0227 }
            com.baidu.sofire.l.c.e((java.lang.String) r8)     // Catch:{ all -> 0x0227 }
        L_0x020d:
            if (r9 == 0) goto L_0x0214
            r9.close()     // Catch:{ IOException -> 0x0213 }
            goto L_0x0214
        L_0x0213:
        L_0x0214:
            if (r3 == 0) goto L_0x0219
            r3.close()     // Catch:{ IOException -> 0x0219 }
        L_0x0219:
            return
        L_0x021a:
            if (r9 == 0) goto L_0x0221
            r9.close()     // Catch:{ IOException -> 0x0220 }
            goto L_0x0221
        L_0x0220:
        L_0x0221:
            if (r3 == 0) goto L_0x0226
        L_0x0223:
            r3.close()     // Catch:{ IOException -> 0x0226 }
        L_0x0226:
            return
        L_0x0227:
            r8 = move-exception
            if (r9 == 0) goto L_0x022f
            r9.close()     // Catch:{ IOException -> 0x022e }
            goto L_0x022f
        L_0x022e:
        L_0x022f:
            if (r3 == 0) goto L_0x0234
            r3.close()     // Catch:{ IOException -> 0x0234 }
        L_0x0234:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(int, java.lang.String, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        return a(i2, str, false, (PackageInfo) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
        r7 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x021b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:144:0x0316 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:148:0x031a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0168 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(int r18, java.lang.String r19, boolean r20, android.content.pm.PackageInfo r21) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r0 = r21
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            monitor-enter(r17)
            r5 = 1
            r6 = 0
            if (r20 == 0) goto L_0x0019
            com.baidu.sofire.c.a r7 = r1.c     // Catch:{ all -> 0x031a }
            int r7 = r7.d(r2)     // Catch:{ all -> 0x031a }
            if (r7 == r5) goto L_0x0019
            monitor-exit(r17)
            return r6
        L_0x0019:
            com.baidu.sofire.c.a r7 = r1.c     // Catch:{ all -> 0x031a }
            com.baidu.sofire.core.ApkInfo r7 = r7.b((int) r2)     // Catch:{ all -> 0x031a }
            if (r7 != 0) goto L_0x0055
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x031a }
            r0.<init>()     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "0"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x031a }
            r0.put(r4, r5)     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "1"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x031a }
            r5.<init>()     // Catch:{ all -> 0x031a }
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = ""
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x031a }
            r0.put(r4, r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x031a }
            if (r20 != 0) goto L_0x0053
            android.content.Context r2 = e     // Catch:{ all -> 0x031a }
            java.lang.String r3 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r2, (java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r6)     // Catch:{ all -> 0x031a }
        L_0x0053:
            monitor-exit(r17)
            return r6
        L_0x0055:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x031a }
            java.lang.String r9 = r7.pkgPath     // Catch:{ all -> 0x031a }
            r8.<init>(r9)     // Catch:{ all -> 0x031a }
            boolean r8 = com.baidu.sofire.l.c.a((java.io.File) r8)     // Catch:{ all -> 0x031a }
            r9 = 3
            r10 = -1
            if (r8 != 0) goto L_0x009d
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x031a }
            r0.c(r2, r10)     // Catch:{ all -> 0x031a }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x031a }
            r0.<init>()     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "0"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x031a }
            r0.put(r4, r5)     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "1"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x031a }
            r5.<init>()     // Catch:{ all -> 0x031a }
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = ""
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x031a }
            r0.put(r4, r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x031a }
            if (r20 != 0) goto L_0x009b
            android.content.Context r2 = e     // Catch:{ all -> 0x031a }
            java.lang.String r3 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r2, (java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r6)     // Catch:{ all -> 0x031a }
        L_0x009b:
            monitor-exit(r17)
            return r6
        L_0x009d:
            if (r0 == 0) goto L_0x00a1
            r7.cloudPkgInfo = r0     // Catch:{ all -> 0x031a }
        L_0x00a1:
            android.content.Context r0 = e     // Catch:{ all -> 0x031a }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x031a }
            com.baidu.sofire.b.j r8 = com.baidu.sofire.b.j.a((android.content.Context) r0)     // Catch:{ all -> 0x031a }
            boolean r0 = r8.a((com.baidu.sofire.core.ApkInfo) r7, (boolean) r6)     // Catch:{ all -> 0x031a }
            r11 = 4
            if (r0 != 0) goto L_0x00f0
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x031a }
            r0.c(r2, r10)     // Catch:{ all -> 0x031a }
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x031a }
            r8.c(r0)     // Catch:{ all -> 0x031a }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x031a }
            r0.<init>()     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "0"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x031a }
            r0.put(r4, r5)     // Catch:{ all -> 0x031a }
            java.lang.String r4 = "1"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x031a }
            r5.<init>()     // Catch:{ all -> 0x031a }
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = ""
            r5.append(r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x031a }
            r0.put(r4, r2)     // Catch:{ all -> 0x031a }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x031a }
            if (r20 != 0) goto L_0x00ee
            android.content.Context r2 = e     // Catch:{ all -> 0x031a }
            java.lang.String r3 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r2, (java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r6)     // Catch:{ all -> 0x031a }
        L_0x00ee:
            monitor-exit(r17)
            return r6
        L_0x00f0:
            java.lang.String r0 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.String r12 = "setSecurityVerifyInfo"
            java.lang.String r13 = "init"
            java.lang.String r14 = r7.es     // Catch:{ all -> 0x02a5 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x02a5 }
            r15 = 2
            if (r14 != 0) goto L_0x013a
            java.lang.String r14 = r7.es     // Catch:{ all -> 0x02a5 }
            java.lang.String r10 = "#"
            java.lang.String[] r10 = r14.split(r10)     // Catch:{ all -> 0x02a5 }
            int r14 = r10.length     // Catch:{ all -> 0x02a5 }
            if (r14 < r11) goto L_0x013a
            r11 = r10[r5]     // Catch:{ all -> 0x02a5 }
            java.lang.String r14 = "c"
            boolean r11 = r11.startsWith(r14)     // Catch:{ all -> 0x02a5 }
            if (r11 == 0) goto L_0x011a
            r0 = r10[r5]     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = r0.substring(r5)     // Catch:{ all -> 0x02a5 }
        L_0x011a:
            r11 = r10[r15]     // Catch:{ all -> 0x02a5 }
            java.lang.String r14 = "m"
            boolean r11 = r11.startsWith(r14)     // Catch:{ all -> 0x02a5 }
            if (r11 == 0) goto L_0x012a
            r11 = r10[r15]     // Catch:{ all -> 0x02a5 }
            java.lang.String r12 = r11.substring(r5)     // Catch:{ all -> 0x02a5 }
        L_0x012a:
            r11 = r10[r9]     // Catch:{ all -> 0x02a5 }
            java.lang.String r14 = "m"
            boolean r11 = r11.startsWith(r14)     // Catch:{ all -> 0x02a5 }
            if (r11 == 0) goto L_0x013a
            r10 = r10[r9]     // Catch:{ all -> 0x02a5 }
            java.lang.String r13 = r10.substring(r5)     // Catch:{ all -> 0x02a5 }
        L_0x013a:
            android.content.Context r10 = e     // Catch:{ all -> 0x02a5 }
            java.lang.String[] r10 = com.baidu.sofire.l.c.p(r10)     // Catch:{ all -> 0x02a5 }
            int r11 = r10.length     // Catch:{ all -> 0x02a5 }
            if (r11 != r15) goto L_0x0158
            r11 = r10[r6]     // Catch:{ all -> 0x02a5 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02a5 }
            if (r11 != 0) goto L_0x0158
            r11 = r10[r5]     // Catch:{ all -> 0x02a5 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02a5 }
            if (r11 != 0) goto L_0x0158
            r11 = r10[r6]     // Catch:{ all -> 0x02a5 }
            r10 = r10[r5]     // Catch:{ all -> 0x02a5 }
            goto L_0x015c
        L_0x0158:
            java.lang.String r11 = "3"
            java.lang.String r10 = "925fc15df8a49bed0b3eca8d2b44cb7b"
        L_0x015c:
            java.lang.String r14 = r7.pkgPath     // Catch:{ all -> 0x02a5 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r9 = r8.c     // Catch:{ all -> 0x0168 }
            java.lang.Object r9 = r9.get(r14)     // Catch:{ all -> 0x0168 }
            com.baidu.sofire.core.ApkInfo r9 = (com.baidu.sofire.core.ApkInfo) r9     // Catch:{ all -> 0x0168 }
            r7 = r9
            goto L_0x016b
        L_0x0168:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x02a5 }
            r7 = 0
        L_0x016b:
            java.lang.ClassLoader r9 = r7.classLoader     // Catch:{ all -> 0x02a5 }
            com.baidu.sofire.b.i r9 = (com.baidu.sofire.b.i) r9     // Catch:{ all -> 0x02a5 }
            java.lang.Class r0 = r9.a(r0)     // Catch:{ all -> 0x02a5 }
            if (r0 != 0) goto L_0x01f5
            java.lang.String r0 = "java.lang.String"
            java.lang.Class r0 = r9.a(r0)     // Catch:{ all -> 0x02a5 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x02a5 }
            r4.<init>()     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "0"
            r10 = 9
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x02a5 }
            r4.put(r5, r10)     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "1"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a5 }
            r10.<init>()     // Catch:{ all -> 0x02a5 }
            r10.append(r2)     // Catch:{ all -> 0x02a5 }
            java.lang.String r11 = ""
            r10.append(r11)     // Catch:{ all -> 0x02a5 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x02a5 }
            r4.put(r5, r10)     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "2"
            r4.put(r5, r3)     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "3"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a5 }
            r10.<init>()     // Catch:{ all -> 0x02a5 }
            java.lang.String r11 = "classloader="
            r10.append(r11)     // Catch:{ all -> 0x02a5 }
            r10.append(r9)     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = ",StringClass="
            r10.append(r9)     // Catch:{ all -> 0x02a5 }
            r10.append(r0)     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x02a5 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = "\n"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = "\t"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = "\r"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x02a5 }
            r4.put(r5, r0)     // Catch:{ all -> 0x02a5 }
            if (r20 != 0) goto L_0x01ed
            android.content.Context r0 = e     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r4, (boolean) r6)     // Catch:{ all -> 0x02a5 }
        L_0x01ed:
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x02a5 }
            r4 = -1
            r0.c(r2, r4)     // Catch:{ all -> 0x02a5 }
            monitor-exit(r17)
            return r6
        L_0x01f5:
            java.lang.String r9 = "getInstance"
            java.lang.Class[] r14 = new java.lang.Class[r5]     // Catch:{ all -> 0x02a5 }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r14[r6] = r16     // Catch:{ all -> 0x02a5 }
            java.lang.reflect.Method r9 = r0.getDeclaredMethod(r9, r14)     // Catch:{ all -> 0x02a5 }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ all -> 0x02a5 }
            android.content.Context r16 = e     // Catch:{ all -> 0x02a5 }
            r14[r6] = r16     // Catch:{ all -> 0x02a5 }
            java.lang.Object r0 = r9.invoke(r0, r14)     // Catch:{ all -> 0x02a5 }
            java.lang.Class[] r9 = new java.lang.Class[r15]     // Catch:{ all -> 0x021b }
            r9[r6] = r4     // Catch:{ all -> 0x021b }
            r9[r5] = r4     // Catch:{ all -> 0x021b }
            java.lang.Object[] r4 = new java.lang.Object[r15]     // Catch:{ all -> 0x021b }
            r4[r6] = r11     // Catch:{ all -> 0x021b }
            r4[r5] = r10     // Catch:{ all -> 0x021b }
            com.baidu.sofire.l.c.a((java.lang.Object) r0, (java.lang.String) r12, (java.lang.Class<?>[]) r9, (java.lang.Object[]) r4)     // Catch:{ all -> 0x021b }
            goto L_0x021d
        L_0x021b:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x02a5 }
        L_0x021d:
            java.lang.Class[] r4 = new java.lang.Class[r15]     // Catch:{ all -> 0x02a5 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x02a5 }
            r4[r6] = r9     // Catch:{ all -> 0x02a5 }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x02a5 }
            r4[r5] = r9     // Catch:{ all -> 0x02a5 }
            java.lang.Object[] r9 = new java.lang.Object[r15]     // Catch:{ all -> 0x02a5 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02a5 }
            r9[r6] = r10     // Catch:{ all -> 0x02a5 }
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x02a5 }
            r9[r5] = r10     // Catch:{ all -> 0x02a5 }
            java.lang.Object r0 = com.baidu.sofire.l.c.a((java.lang.Object) r0, (java.lang.String) r13, (java.lang.Class<?>[]) r4, (java.lang.Object[]) r9)     // Catch:{ all -> 0x02a5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x02a5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x02a5 }
            if (r0 != 0) goto L_0x027f
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02a5 }
            r0.<init>()     // Catch:{ all -> 0x02a5 }
            java.lang.String r4 = "0"
            r5 = 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02a5 }
            r0.put(r4, r5)     // Catch:{ all -> 0x02a5 }
            java.lang.String r4 = "1"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a5 }
            r5.<init>()     // Catch:{ all -> 0x02a5 }
            r5.append(r2)     // Catch:{ all -> 0x02a5 }
            java.lang.String r9 = ""
            r5.append(r9)     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x02a5 }
            r0.put(r4, r5)     // Catch:{ all -> 0x02a5 }
            java.lang.String r4 = "2"
            r0.put(r4, r3)     // Catch:{ all -> 0x02a5 }
            if (r20 != 0) goto L_0x0272
            android.content.Context r4 = e     // Catch:{ all -> 0x02a5 }
            java.lang.String r5 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r4, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r6)     // Catch:{ all -> 0x02a5 }
        L_0x0272:
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x02a5 }
            r4 = -1
            r0.c(r2, r4)     // Catch:{ all -> 0x02a5 }
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x02a5 }
            r8.c(r0)     // Catch:{ all -> 0x02a5 }
            monitor-exit(r17)
            return r6
        L_0x027f:
            r7.initStatus = r5     // Catch:{ all -> 0x031a }
            r7.apkParseSuc = r5     // Catch:{ all -> 0x031a }
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x031a }
            r0.a((com.baidu.sofire.core.ApkInfo) r7)     // Catch:{ all -> 0x031a }
            com.baidu.sofire.c.a r0 = r1.c     // Catch:{ all -> 0x031a }
            int r2 = r7.key     // Catch:{ all -> 0x031a }
            int r0 = r0.c(r2)     // Catch:{ all -> 0x031a }
            r2 = 3
            if (r0 >= r2) goto L_0x029e
            r2 = -1
            if (r0 == r2) goto L_0x029e
            com.baidu.sofire.c.a r2 = r1.c     // Catch:{ all -> 0x031a }
            int r3 = r7.key     // Catch:{ all -> 0x031a }
            int r0 = r0 + r5
            r2.b(r3, r0)     // Catch:{ all -> 0x031a }
        L_0x029e:
            android.content.Context r0 = e     // Catch:{ all -> 0x031a }
            com.baidu.sofire.l.c.q(r0)     // Catch:{ all -> 0x031a }
            monitor-exit(r17)
            return r5
        L_0x02a5:
            r0 = move-exception
            com.baidu.sofire.c.a r4 = r1.c     // Catch:{ all -> 0x0316 }
            r5 = -1
            r4.c(r2, r5)     // Catch:{ all -> 0x0316 }
            java.lang.String r0 = com.baidu.sofire.a.a.a(r0)     // Catch:{ all -> 0x0316 }
            android.content.Context r4 = e     // Catch:{ all -> 0x0316 }
            java.lang.String r5 = r7.packageName     // Catch:{ all -> 0x0316 }
            java.lang.String r0 = com.baidu.sofire.l.h.a(r4, r0, r5)     // Catch:{ all -> 0x0316 }
            java.lang.String r4 = r7.pkgPath     // Catch:{ all -> 0x0316 }
            r8.c(r4)     // Catch:{ all -> 0x0316 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0316 }
            r4.<init>()     // Catch:{ all -> 0x0316 }
            java.lang.String r5 = "0"
            r7 = 7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0316 }
            r4.put(r5, r7)     // Catch:{ all -> 0x0316 }
            java.lang.String r5 = "1"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0316 }
            r7.<init>()     // Catch:{ all -> 0x0316 }
            r7.append(r2)     // Catch:{ all -> 0x0316 }
            java.lang.String r2 = ""
            r7.append(r2)     // Catch:{ all -> 0x0316 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0316 }
            r4.put(r5, r2)     // Catch:{ all -> 0x0316 }
            java.lang.String r2 = "2"
            r4.put(r2, r3)     // Catch:{ all -> 0x0316 }
            java.lang.String r2 = "3"
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0316 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch:{ all -> 0x0316 }
            java.lang.String r3 = "\n"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.replace(r3, r5)     // Catch:{ all -> 0x0316 }
            java.lang.String r3 = "\t"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.replace(r3, r5)     // Catch:{ all -> 0x0316 }
            java.lang.String r3 = "\r"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.replace(r3, r5)     // Catch:{ all -> 0x0316 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0316 }
            if (r20 != 0) goto L_0x0318
            android.content.Context r0 = e     // Catch:{ all -> 0x0316 }
            java.lang.String r2 = "1003105"
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r4, (boolean) r6)     // Catch:{ all -> 0x0316 }
            goto L_0x0318
        L_0x0316:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x031a }
        L_0x0318:
            monitor-exit(r17)
            return r6
        L_0x031a:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x031e }
            monitor-exit(r17)
            return r6
        L_0x031e:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(int, java.lang.String, boolean, android.content.pm.PackageInfo):boolean");
    }

    public void a(int i2) {
        try {
            ApkInfo b2 = this.c.b(i2);
            if (b2 != null) {
                this.c.a(i2);
                File file = new File(b2.pkgPath);
                if (file.exists()) {
                    com.baidu.sofire.a.b.a(file);
                    file.delete();
                    if (file.getParentFile() != null) {
                        com.baidu.sofire.l.c.e(file.getParentFile().getAbsolutePath());
                    }
                }
            }
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
        }
    }

    public void a(String str, String str2) {
        try {
            this.c.a(str);
            File file = new File(str2);
            if (file.exists()) {
                com.baidu.sofire.a.b.a(file);
                file.delete();
                if (file.getParentFile() != null) {
                    com.baidu.sofire.l.c.e(file.getParentFile().getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        r0 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:134:0x0204 */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a7 A[SYNTHETIC, Splitter:B:107:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01c7 A[SYNTHETIC, Splitter:B:117:0x01c7] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01e7 A[SYNTHETIC, Splitter:B:127:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0166 A[SYNTHETIC, Splitter:B:88:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0186 A[SYNTHETIC, Splitter:B:97:0x0186] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x0175=Splitter:B:91:0x0175, B:136:0x0205=Splitter:B:136:0x0205, B:101:0x0196=Splitter:B:101:0x0196, B:111:0x01b7=Splitter:B:111:0x01b7, B:121:0x01d7=Splitter:B:121:0x01d7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r19, java.lang.String r20, com.baidu.sofire.ac.Callback r21, java.lang.Class<?>[] r22, java.lang.Object... r23) {
        /*
            r18 = this;
            r0 = r19
            r1 = r21
            java.lang.String r2 = "0"
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0212 }
            r3.<init>()     // Catch:{ all -> 0x0212 }
            java.lang.String r4 = java.lang.Integer.toString(r19)     // Catch:{ all -> 0x0212 }
            r3.put(r2, r4)     // Catch:{ all -> 0x0212 }
            java.lang.String r4 = "1"
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ all -> 0x0212 }
            if (r5 != 0) goto L_0x001d
            r5 = r20
            goto L_0x001f
        L_0x001d:
            java.lang.String r5 = " "
        L_0x001f:
            r3.put(r4, r5)     // Catch:{ all -> 0x0212 }
            java.lang.String r4 = "2"
            r3.put(r4, r2)     // Catch:{ all -> 0x0212 }
            double r4 = java.lang.Math.random()     // Catch:{ all -> 0x0212 }
            r6 = 4607137382803743703(0x3fefd70a3d70a3d7, double:0.995)
            r2 = 1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x003c
            android.content.Context r4 = e     // Catch:{ all -> 0x0212 }
            java.lang.String r5 = "1003136"
            com.baidu.sofire.l.c.a((android.content.Context) r4, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r2)     // Catch:{ all -> 0x0212 }
        L_0x003c:
            boolean r4 = android.text.TextUtils.isEmpty(r20)     // Catch:{ all -> 0x0212 }
            java.lang.String r5 = "1003141"
            java.lang.String r6 = "3"
            r7 = 0
            if (r4 == 0) goto L_0x005f
            if (r1 == 0) goto L_0x0054
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0212 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0212 }
            r0[r7] = r2     // Catch:{ all -> 0x0212 }
            r1.onError(r0)     // Catch:{ all -> 0x0212 }
        L_0x0054:
            java.lang.String r0 = "11"
            r3.put(r6, r0)     // Catch:{ all -> 0x0212 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0212 }
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r7)     // Catch:{ all -> 0x0212 }
            return
        L_0x005f:
            r4 = 3
            r8 = 2
            if (r1 == 0) goto L_0x0068
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            r1.onBegin(r9)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
        L_0x0068:
            android.content.Context r9 = e     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            com.baidu.sofire.b.j r9 = com.baidu.sofire.b.j.a((android.content.Context) r9)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            boolean r10 = r9.b((int) r0)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            if (r10 == 0) goto L_0x0093
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
        L_0x007c:
            boolean r12 = r9.b((int) r0)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            if (r12 == 0) goto L_0x0093
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            long r12 = r12 - r10
            r14 = 10000(0x2710, double:4.9407E-320)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0093
            r12 = 300(0x12c, double:1.48E-321)
            android.os.SystemClock.sleep(r12)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            goto L_0x007c
        L_0x0093:
            boolean r10 = r9.b((int) r0)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            if (r10 == 0) goto L_0x00b5
            r0 = 12
            if (r1 == 0) goto L_0x00a8
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            r9[r7] = r10     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            r1.onError(r9)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
        L_0x00a8:
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x00b4 }
            r3.put(r6, r0)     // Catch:{ all -> 0x00b4 }
            android.content.Context r0 = e     // Catch:{ all -> 0x00b4 }
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r7)     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            return
        L_0x00b5:
            r10 = 0
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
        L_0x00ba:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            long r13 = r13 - r11
            r15 = 15000(0x3a98, double:7.411E-320)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x00f3
            com.baidu.sofire.core.ApkInfo r10 = r9.a((int) r0)     // Catch:{ NoSuchMethodException -> 0x01e1, InvocationTargetException -> 0x01c1, IllegalAccessException -> 0x01a1, IllegalArgumentException -> 0x0180, all -> 0x0160 }
            if (r10 == 0) goto L_0x00ce
            r13 = r18
            goto L_0x00e0
        L_0x00ce:
            r13 = r18
            com.baidu.sofire.c.a r10 = r13.c     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            com.baidu.sofire.core.ApkInfo r10 = r10.b((int) r0)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            if (r10 == 0) goto L_0x00e8
            java.lang.String r14 = r10.packageName     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            com.baidu.sofire.core.ApkInfo r14 = r9.b((java.lang.String) r14)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            if (r14 == 0) goto L_0x00e2
        L_0x00e0:
            r0 = 1
            goto L_0x00f6
        L_0x00e2:
            int r14 = r10.initStatus     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r15 = -1
            if (r14 != r15) goto L_0x00e8
            goto L_0x00ec
        L_0x00e8:
            boolean r14 = com.baidu.sofire.b.a.x     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            if (r14 == 0) goto L_0x00ed
        L_0x00ec:
            goto L_0x00f5
        L_0x00ed:
            r14 = 1000(0x3e8, double:4.94E-321)
            android.os.SystemClock.sleep(r14)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            goto L_0x00ba
        L_0x00f3:
            r13 = r18
        L_0x00f5:
            r0 = 0
        L_0x00f6:
            if (r0 != 0) goto L_0x0115
            r0 = 13
            if (r1 == 0) goto L_0x0108
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r10 = 4
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r9[r7] = r10     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r1.onError(r9)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
        L_0x0108:
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x0114 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0114 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0114 }
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r7)     // Catch:{ all -> 0x0114 }
        L_0x0114:
            return
        L_0x0115:
            java.lang.String r0 = r10.packageName     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            com.baidu.sofire.core.ApkInfo r0 = r9.b((java.lang.String) r0)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.ClassLoader r9 = r0.classLoader     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            com.baidu.sofire.b.i r9 = (com.baidu.sofire.b.i) r9     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.String r0 = r0.es     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.String r0 = com.baidu.sofire.l.c.c((java.lang.String) r0)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.Class r0 = r9.a(r0)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.String r9 = "getInstance"
            java.lang.Class[] r10 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r7] = r11     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.reflect.Method r9 = r0.getDeclaredMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            android.content.Context r11 = e     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r10[r7] = r11     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            java.lang.Object r0 = r9.invoke(r0, r10)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r9 = r20
            r10 = r22
            r11 = r23
            java.lang.Object r0 = com.baidu.sofire.l.c.a((java.lang.Object) r0, (java.lang.String) r9, (java.lang.Class<?>[]) r10, (java.lang.Object[]) r11)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            if (r1 == 0) goto L_0x0216
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r9[r7] = r0     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            r1.onEnd(r9)     // Catch:{ NoSuchMethodException -> 0x015d, InvocationTargetException -> 0x015a, IllegalAccessException -> 0x0158, IllegalArgumentException -> 0x0156, all -> 0x0154 }
            goto L_0x0216
        L_0x0154:
            goto L_0x0162
        L_0x0156:
            goto L_0x0182
        L_0x0158:
            goto L_0x01a3
        L_0x015a:
            goto L_0x01c3
        L_0x015d:
            goto L_0x01e3
        L_0x0160:
            r13 = r18
        L_0x0162:
            r8 = 18
            if (r1 == 0) goto L_0x0175
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0172 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0172 }
            r0[r7] = r2     // Catch:{ all -> 0x0172 }
            r1.onError(r0)     // Catch:{ all -> 0x0172 }
            goto L_0x0175
        L_0x0172:
            r0 = move-exception
            goto L_0x01f6
        L_0x0175:
            java.lang.String r0 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0216 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0216 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0216 }
            goto L_0x020e
        L_0x0180:
            r13 = r18
        L_0x0182:
            r4 = 17
            if (r1 == 0) goto L_0x0196
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0192 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0192 }
            r0[r7] = r2     // Catch:{ all -> 0x0192 }
            r1.onError(r0)     // Catch:{ all -> 0x0192 }
            goto L_0x0196
        L_0x0192:
            r0 = move-exception
            r8 = 17
            goto L_0x01f6
        L_0x0196:
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0216 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0216 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0216 }
            goto L_0x020e
        L_0x01a1:
            r13 = r18
        L_0x01a3:
            r4 = 16
            if (r1 == 0) goto L_0x01b7
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x01b3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01b3 }
            r0[r7] = r2     // Catch:{ all -> 0x01b3 }
            r1.onError(r0)     // Catch:{ all -> 0x01b3 }
            goto L_0x01b7
        L_0x01b3:
            r0 = move-exception
            r8 = 16
            goto L_0x01f6
        L_0x01b7:
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0216 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0216 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0216 }
            goto L_0x020e
        L_0x01c1:
            r13 = r18
        L_0x01c3:
            r4 = 15
            if (r1 == 0) goto L_0x01d7
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x01d3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01d3 }
            r0[r7] = r2     // Catch:{ all -> 0x01d3 }
            r1.onError(r0)     // Catch:{ all -> 0x01d3 }
            goto L_0x01d7
        L_0x01d3:
            r0 = move-exception
            r8 = 15
            goto L_0x01f6
        L_0x01d7:
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0216 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0216 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0216 }
            goto L_0x020e
        L_0x01e1:
            r13 = r18
        L_0x01e3:
            r4 = 14
            if (r1 == 0) goto L_0x0205
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x01f3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01f3 }
            r0[r7] = r2     // Catch:{ all -> 0x01f3 }
            r1.onError(r0)     // Catch:{ all -> 0x01f3 }
            goto L_0x0205
        L_0x01f3:
            r0 = move-exception
            r8 = 14
        L_0x01f6:
            if (r8 == 0) goto L_0x0204
            java.lang.String r1 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0204 }
            r3.put(r6, r1)     // Catch:{ all -> 0x0204 }
            android.content.Context r1 = e     // Catch:{ all -> 0x0204 }
            com.baidu.sofire.l.c.a((android.content.Context) r1, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r7)     // Catch:{ all -> 0x0204 }
        L_0x0204:
            throw r0     // Catch:{ all -> 0x0214 }
        L_0x0205:
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0216 }
            r3.put(r6, r0)     // Catch:{ all -> 0x0216 }
            android.content.Context r0 = e     // Catch:{ all -> 0x0216 }
        L_0x020e:
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r3, (boolean) r7)     // Catch:{ all -> 0x0216 }
            goto L_0x0216
        L_0x0212:
            r13 = r18
        L_0x0214:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0216:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(int, java.lang.String, com.baidu.sofire.ac.Callback, java.lang.Class[], java.lang.Object[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A[Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113, all -> 0x0189, all -> 0x012a, all -> 0x0142, all -> 0x015a, all -> 0x0171, all -> 0x0188 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00db A[SYNTHETIC, Splitter:B:52:0x00db] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.Integer, java.lang.Object> a(int r12, java.lang.String r13, java.lang.Class<?>[] r14, java.lang.Object... r15) {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = java.lang.Integer.toString(r12)
            java.lang.String r2 = "0"
            r0.put(r2, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto L_0x0016
            r1 = r13
            goto L_0x0018
        L_0x0016:
            java.lang.String r1 = " "
        L_0x0018:
            java.lang.String r2 = "1"
            r0.put(r2, r1)
            java.lang.String r1 = "2"
            r0.put(r1, r2)
            double r3 = java.lang.Math.random()
            r5 = 4607137382803743703(0x3fefd70a3d70a3d7, double:0.995)
            r1 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0037
            android.content.Context r3 = e
            java.lang.String r4 = "1003136"
            com.baidu.sofire.l.c.a((android.content.Context) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)
        L_0x0037:
            boolean r3 = android.text.TextUtils.isEmpty(r13)
            r4 = 0
            java.lang.String r5 = "1003141"
            java.lang.String r6 = "3"
            if (r3 == 0) goto L_0x0054
            r0.put(r6, r2)
            android.content.Context r12 = e
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)
            android.util.Pair r12 = new android.util.Pair
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r12.<init>(r13, r4)
            return r12
        L_0x0054:
            r2 = 3
            r3 = 2
            com.baidu.sofire.b.j r7 = com.baidu.sofire.b.j.g     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r8 = 4
            if (r7 != 0) goto L_0x0071
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r12.<init>(r13, r4)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r13 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0070 }
            r0.put(r6, r13)     // Catch:{ all -> 0x0070 }
            android.content.Context r13 = e     // Catch:{ all -> 0x0070 }
            com.baidu.sofire.l.c.a((android.content.Context) r13, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0070 }
        L_0x0070:
            return r12
        L_0x0071:
            boolean r9 = r7.b((int) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            if (r9 == 0) goto L_0x008d
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r12.<init>(r13, r4)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r13 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x008c }
            r0.put(r6, r13)     // Catch:{ all -> 0x008c }
            android.content.Context r13 = e     // Catch:{ all -> 0x008c }
            com.baidu.sofire.l.c.a((android.content.Context) r13, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x008c }
        L_0x008c:
            return r12
        L_0x008d:
            boolean r9 = r11.a     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            if (r9 != 0) goto L_0x00a7
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r12.<init>(r13, r4)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r13 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x00a6 }
            r0.put(r6, r13)     // Catch:{ all -> 0x00a6 }
            android.content.Context r13 = e     // Catch:{ all -> 0x00a6 }
            com.baidu.sofire.l.c.a((android.content.Context) r13, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            return r12
        L_0x00a7:
            com.baidu.sofire.core.ApkInfo r9 = r7.a((int) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r10 = 0
            if (r9 == 0) goto L_0x00af
            goto L_0x00bf
        L_0x00af:
            com.baidu.sofire.c.a r9 = r11.c     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            com.baidu.sofire.core.ApkInfo r9 = r9.b((int) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            if (r9 == 0) goto L_0x00c1
            java.lang.String r12 = r9.packageName     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            com.baidu.sofire.core.ApkInfo r12 = r7.b((java.lang.String) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            if (r12 == 0) goto L_0x00c1
        L_0x00bf:
            r12 = 1
            goto L_0x00c2
        L_0x00c1:
            r12 = 0
        L_0x00c2:
            if (r12 != 0) goto L_0x00db
            r12 = 5
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r13.<init>(r14, r4)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x00da }
            r0.put(r6, r12)     // Catch:{ all -> 0x00da }
            android.content.Context r12 = e     // Catch:{ all -> 0x00da }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x00da }
        L_0x00da:
            return r13
        L_0x00db:
            java.lang.String r12 = r9.packageName     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            com.baidu.sofire.core.ApkInfo r12 = r7.b((java.lang.String) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.ClassLoader r7 = r12.classLoader     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            com.baidu.sofire.b.i r7 = (com.baidu.sofire.b.i) r7     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r12 = r12.es     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r12 = com.baidu.sofire.l.c.c((java.lang.String) r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Class r12 = r7.a(r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.String r7 = "getInstance"
            java.lang.Class[] r8 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Class<android.content.Context> r9 = android.content.Context.class
            r8[r10] = r9     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.reflect.Method r7 = r12.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            android.content.Context r9 = e     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r8[r10] = r9     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Object r12 = r7.invoke(r12, r8)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Object r12 = com.baidu.sofire.l.c.a((java.lang.Object) r12, (java.lang.String) r13, (java.lang.Class<?>[]) r14, (java.lang.Object[]) r15)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            r13.<init>(r14, r12)     // Catch:{ NoSuchMethodException -> 0x0172, InvocationTargetException -> 0x015b, IllegalAccessException -> 0x0143, IllegalArgumentException -> 0x012b, all -> 0x0113 }
            return r13
        L_0x0113:
            r12 = 10
            android.util.Pair r13 = new android.util.Pair     // Catch:{ all -> 0x0189 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0189 }
            r13.<init>(r14, r4)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x012a }
            r0.put(r6, r12)     // Catch:{ all -> 0x012a }
            android.content.Context r12 = e     // Catch:{ all -> 0x012a }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x012a }
        L_0x012a:
            return r13
        L_0x012b:
            r12 = 9
            android.util.Pair r13 = new android.util.Pair     // Catch:{ all -> 0x0189 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0189 }
            r13.<init>(r14, r4)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x0142 }
            r0.put(r6, r12)     // Catch:{ all -> 0x0142 }
            android.content.Context r12 = e     // Catch:{ all -> 0x0142 }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0142 }
        L_0x0142:
            return r13
        L_0x0143:
            r12 = 8
            android.util.Pair r13 = new android.util.Pair     // Catch:{ all -> 0x0189 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0189 }
            r13.<init>(r14, r4)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x015a }
            r0.put(r6, r12)     // Catch:{ all -> 0x015a }
            android.content.Context r12 = e     // Catch:{ all -> 0x015a }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x015a }
        L_0x015a:
            return r13
        L_0x015b:
            r12 = 7
            android.util.Pair r13 = new android.util.Pair     // Catch:{ all -> 0x0189 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0189 }
            r13.<init>(r14, r4)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x0171 }
            r0.put(r6, r12)     // Catch:{ all -> 0x0171 }
            android.content.Context r12 = e     // Catch:{ all -> 0x0171 }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0171 }
        L_0x0171:
            return r13
        L_0x0172:
            r12 = 6
            android.util.Pair r13 = new android.util.Pair     // Catch:{ all -> 0x0189 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0189 }
            r13.<init>(r14, r4)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x0188 }
            r0.put(r6, r12)     // Catch:{ all -> 0x0188 }
            android.content.Context r12 = e     // Catch:{ all -> 0x0188 }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0188 }
        L_0x0188:
            return r13
        L_0x0189:
            r13 = move-exception
            if (r12 == 0) goto L_0x0198
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x0198 }
            r0.put(r6, r12)     // Catch:{ all -> 0x0198 }
            android.content.Context r12 = e     // Catch:{ all -> 0x0198 }
            com.baidu.sofire.l.c.a((android.content.Context) r12, (java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0198 }
        L_0x0198:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r10) {
        /*
            r9 = this;
            com.baidu.sofire.c.a r0 = r9.c
            r0.a()
            r0 = 1
            r9.a = r0
            r1 = 0
            android.content.Context r2 = e     // Catch:{ all -> 0x008c }
            com.baidu.sofire.b.j r2 = com.baidu.sofire.b.j.a((android.content.Context) r2)     // Catch:{ all -> 0x008c }
            if (r2 != 0) goto L_0x0013
            goto L_0x008b
        L_0x0013:
            com.baidu.sofire.core.ApkInfo r3 = r2.b((java.lang.String) r10)     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x001b
            goto L_0x008f
        L_0x001b:
            com.baidu.sofire.c.a r3 = r9.c     // Catch:{ all -> 0x008c }
            if (r3 != 0) goto L_0x0027
            android.content.Context r3 = e     // Catch:{ all -> 0x008c }
            com.baidu.sofire.c.a r3 = com.baidu.sofire.c.a.a((android.content.Context) r3)     // Catch:{ all -> 0x008c }
            r9.c = r3     // Catch:{ all -> 0x008c }
        L_0x0027:
            com.baidu.sofire.c.a r3 = r9.c     // Catch:{ all -> 0x008c }
            com.baidu.sofire.core.ApkInfo r3 = r3.b((java.lang.String) r10)     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0085
            com.baidu.sofire.j.a r4 = r9.b     // Catch:{ all -> 0x008c }
            boolean r4 = r4.n()     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0074
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x008c }
            java.lang.String r5 = r3.pkgPath     // Catch:{ all -> 0x008c }
            r4.<init>(r5)     // Catch:{ all -> 0x008c }
            java.io.File r5 = r4.getParentFile()     // Catch:{ all -> 0x008c }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            int r8 = r3.key     // Catch:{ all -> 0x008c }
            r7.append(r8)     // Catch:{ all -> 0x008c }
            java.lang.String r8 = "."
            r7.append(r8)     // Catch:{ all -> 0x008c }
            java.lang.String r8 = r3.versionName     // Catch:{ all -> 0x008c }
            r7.append(r8)     // Catch:{ all -> 0x008c }
            java.lang.String r8 = ".b"
            r7.append(r8)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008c }
            r6.<init>(r5, r7)     // Catch:{ all -> 0x008c }
            boolean r5 = com.baidu.sofire.l.c.a((java.io.File) r6)     // Catch:{ all -> 0x008c }
            if (r5 != 0) goto L_0x006d
            com.baidu.sofire.b.l.a((java.io.File) r4, (java.io.File) r6)     // Catch:{ all -> 0x008c }
        L_0x006d:
            android.content.Context r5 = e     // Catch:{ all -> 0x008c }
            int r7 = r3.key     // Catch:{ all -> 0x008c }
            com.baidu.sofire.a.b.a(r5, r7, r4, r6)     // Catch:{ all -> 0x008c }
        L_0x0074:
            int r4 = r3.key     // Catch:{ all -> 0x008c }
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x008c }
            r5 = 0
            monitor-enter(r9)     // Catch:{ all -> 0x008c }
            boolean r3 = r9.a((int) r4, (java.lang.String) r3, (boolean) r1, (android.content.pm.PackageInfo) r5)     // Catch:{ all -> 0x0082 }
            monitor-exit(r9)     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0085
            goto L_0x008f
        L_0x0082:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x008c }
            throw r10     // Catch:{ all -> 0x008c }
        L_0x0085:
            com.baidu.sofire.core.ApkInfo r10 = r2.b((java.lang.String) r10)     // Catch:{ all -> 0x008c }
            if (r10 != 0) goto L_0x008f
        L_0x008b:
            goto L_0x008e
        L_0x008c:
            int r10 = com.baidu.sofire.a.a.a
        L_0x008e:
            r0 = 0
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.c.a(java.lang.String):boolean");
    }
}
