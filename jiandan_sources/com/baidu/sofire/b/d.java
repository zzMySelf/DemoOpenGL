package com.baidu.sofire.b;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.ac.BDModuleLoadCallback;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.GzfiCallback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.e;
import com.baidu.sofire.l.s;
import com.baidu.sofire.l.w;
import com.baidu.sofire.l.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class d {
    public static String a = "";
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static long e;
    public static int[] f;
    public static Timer g;
    public static Object h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static List<GzfiCallback> f1086i = new ArrayList();

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BDModuleLoadCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public a(Context context, int i2, BDModuleLoadCallback bDModuleLoadCallback, String str, String str2, int i3) {
            this.a = context;
            this.b = i2;
            this.c = bDModuleLoadCallback;
            this.d = str;
            this.e = str2;
            this.f = i3;
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
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01c7  */
        public void run() {
            /*
                r9 = this;
                android.content.Context r0 = r9.a
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.io.File r2 = com.baidu.sofire.l.c.f((android.content.Context) r0)     // Catch:{ IOException -> 0x013d }
                java.lang.String r3 = "sofire_tmp"
                r1.<init>(r2, r3)     // Catch:{ IOException -> 0x013d }
                java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r3 = ".tmp"
                r2.<init>(r1, r3)     // Catch:{ IOException -> 0x013d }
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r3 = "fldr"
                r1.<init>(r2, r3)     // Catch:{ IOException -> 0x013d }
                boolean r3 = r1.exists()     // Catch:{ IOException -> 0x013d }
                if (r3 == 0) goto L_0x0029
                boolean r3 = r1.isDirectory()     // Catch:{ IOException -> 0x013d }
                if (r3 == 0) goto L_0x0029
                goto L_0x013f
            L_0x0029:
                boolean r3 = r1.exists()     // Catch:{ IOException -> 0x013d }
                if (r3 != 0) goto L_0x0032
                r1.mkdirs()     // Catch:{ IOException -> 0x013d }
            L_0x0032:
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.io.File r3 = com.baidu.sofire.l.c.f((android.content.Context) r0)     // Catch:{ IOException -> 0x013d }
                java.lang.String r4 = ".b"
                r1.<init>(r3, r4)     // Catch:{ IOException -> 0x013d }
                boolean r3 = r1.exists()     // Catch:{ IOException -> 0x013d }
                if (r3 == 0) goto L_0x0050
                boolean r3 = r1.isDirectory()     // Catch:{ IOException -> 0x013d }
                if (r3 == 0) goto L_0x0050
                java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x013d }
                com.baidu.sofire.l.c.e((java.lang.String) r1)     // Catch:{ IOException -> 0x013d }
            L_0x0050:
                com.baidu.sofire.c.a r1 = com.baidu.sofire.c.a.a((android.content.Context) r0)     // Catch:{ IOException -> 0x013d }
                java.util.List r3 = r1.b()     // Catch:{ IOException -> 0x013d }
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x013d }
            L_0x005e:
                boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x013d }
                if (r4 == 0) goto L_0x0107
                java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x013d }
                com.baidu.sofire.core.ApkInfo r4 = (com.baidu.sofire.core.ApkInfo) r4     // Catch:{ IOException -> 0x013d }
                java.lang.String r5 = r4.pkgPath     // Catch:{ IOException -> 0x013d }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x013d }
                if (r5 != 0) goto L_0x00cf
                java.lang.String r5 = r4.pkgPath     // Catch:{ IOException -> 0x013d }
                java.lang.String r6 = "sofire_tmp"
                boolean r5 = r5.contains(r6)     // Catch:{ IOException -> 0x013d }
                if (r5 != 0) goto L_0x00cf
                java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r6 = r4.pkgPath     // Catch:{ IOException -> 0x013d }
                r5.<init>(r6)     // Catch:{ IOException -> 0x013d }
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r7 = com.baidu.sofire.l.v.a()     // Catch:{ IOException -> 0x013d }
                r6.<init>(r2, r7)     // Catch:{ IOException -> 0x013d }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x013d }
                r7.<init>()     // Catch:{ IOException -> 0x013d }
                int r8 = r4.key     // Catch:{ IOException -> 0x013d }
                r7.append(r8)     // Catch:{ IOException -> 0x013d }
                java.lang.String r8 = "."
                r7.append(r8)     // Catch:{ IOException -> 0x013d }
                java.lang.String r8 = r4.versionName     // Catch:{ IOException -> 0x013d }
                r7.append(r8)     // Catch:{ IOException -> 0x013d }
                java.lang.String r8 = ".p"
                r7.append(r8)     // Catch:{ IOException -> 0x013d }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x013d }
                java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x013d }
                r8.<init>(r6, r7)     // Catch:{ IOException -> 0x013d }
                boolean r7 = r5.exists()     // Catch:{ IOException -> 0x013d }
                if (r7 == 0) goto L_0x00cf
                boolean r7 = r6.exists()     // Catch:{ IOException -> 0x013d }
                if (r7 != 0) goto L_0x00bd
                r6.mkdirs()     // Catch:{ IOException -> 0x013d }
            L_0x00bd:
                r5.renameTo(r8)     // Catch:{ IOException -> 0x013d }
                boolean r5 = r8.exists()     // Catch:{ IOException -> 0x013d }
                if (r5 == 0) goto L_0x00cf
                java.lang.String r5 = r8.getAbsolutePath()     // Catch:{ IOException -> 0x013d }
                r4.pkgPath = r5     // Catch:{ IOException -> 0x013d }
                r1.a((com.baidu.sofire.core.ApkInfo) r4)     // Catch:{ IOException -> 0x013d }
            L_0x00cf:
                java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x013d }
                r6.<init>()     // Catch:{ IOException -> 0x013d }
                java.io.File r7 = com.baidu.sofire.l.c.f((android.content.Context) r0)     // Catch:{ IOException -> 0x013d }
                java.lang.String r7 = r7.getCanonicalPath()     // Catch:{ IOException -> 0x013d }
                r6.append(r7)     // Catch:{ IOException -> 0x013d }
                java.lang.String r7 = "/."
                r6.append(r7)     // Catch:{ IOException -> 0x013d }
                int r4 = r4.key     // Catch:{ IOException -> 0x013d }
                r6.append(r4)     // Catch:{ IOException -> 0x013d }
                java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x013d }
                r5.<init>(r4)     // Catch:{ IOException -> 0x013d }
                boolean r4 = r5.exists()     // Catch:{ IOException -> 0x013d }
                if (r4 == 0) goto L_0x005e
                boolean r4 = r5.isDirectory()     // Catch:{ IOException -> 0x013d }
                if (r4 == 0) goto L_0x005e
                java.lang.String r4 = r5.getAbsolutePath()     // Catch:{ IOException -> 0x013d }
                com.baidu.sofire.l.c.e((java.lang.String) r4)     // Catch:{ IOException -> 0x013d }
                goto L_0x005e
            L_0x0107:
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.io.File r0 = com.baidu.sofire.l.c.f((android.content.Context) r0)     // Catch:{ IOException -> 0x013d }
                java.lang.String r3 = ".tmp"
                r1.<init>(r0, r3)     // Catch:{ IOException -> 0x013d }
                java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r3 = ".ffnpp"
                r0.<init>(r1, r3)     // Catch:{ IOException -> 0x013d }
                boolean r3 = r0.exists()     // Catch:{ IOException -> 0x013d }
                if (r3 == 0) goto L_0x0129
                java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x013d }
                java.lang.String r4 = ".ffnpp"
                r3.<init>(r2, r4)     // Catch:{ IOException -> 0x013d }
                r0.renameTo(r3)     // Catch:{ IOException -> 0x013d }
            L_0x0129:
                boolean r0 = r1.exists()     // Catch:{ IOException -> 0x013d }
                if (r0 == 0) goto L_0x013f
                boolean r0 = r1.isDirectory()     // Catch:{ IOException -> 0x013d }
                if (r0 == 0) goto L_0x013f
                java.lang.String r0 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x013d }
                com.baidu.sofire.l.c.e((java.lang.String) r0)     // Catch:{ IOException -> 0x013d }
                goto L_0x013f
            L_0x013d:
                int r0 = com.baidu.sofire.a.a.a
            L_0x013f:
                android.content.Context r0 = r9.a
                int r1 = r9.b
                com.baidu.sofire.ac.BDModuleLoadCallback r2 = r9.c
                r3 = 0
                com.baidu.sofire.b.d.a((android.content.Context) r0, (int) r1, (com.baidu.sofire.ac.BDModuleLoadCallback) r2, (boolean) r3)
                android.content.Context r0 = r9.a
                boolean r1 = com.baidu.sofire.l.c.j(r0)
                if (r1 == 0) goto L_0x01d1
                java.lang.String r1 = r0.getPackageName()
                java.lang.String r2 = "com.baidu.input"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x01d1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "SDK Self Check: "
                r1.<init>(r2)
                int r2 = r1.length()
                java.lang.String r4 = "fire"
                java.lang.System.loadLibrary(r4)     // Catch:{ all -> 0x016e }
                goto L_0x0173
            L_0x016e:
                java.lang.String r4 = "LoadLibrary Error,"
                r1.append(r4)
            L_0x0173:
                java.lang.String r4 = "com.baidu.sofire.ac.F"
                java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x0181 }
                java.lang.String r5 = "getInstance"
                java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0181 }
                r4.getDeclaredMethod(r5, r6)     // Catch:{ Exception -> 0x0181 }
                goto L_0x0186
            L_0x0181:
                java.lang.String r4 = "Proguard Error,"
                r1.append(r4)
            L_0x0186:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
                r4.<init>()     // Catch:{ all -> 0x01b0 }
                java.lang.String r5 = r0.getPackageName()     // Catch:{ all -> 0x01b0 }
                r4.append(r5)     // Catch:{ all -> 0x01b0 }
                java.lang.String r5 = "."
                r4.append(r5)     // Catch:{ all -> 0x01b0 }
                java.lang.String r5 = "sofire"
                r4.append(r5)     // Catch:{ all -> 0x01b0 }
                java.lang.String r5 = ".ac.provider"
                r4.append(r5)     // Catch:{ all -> 0x01b0 }
                android.content.pm.PackageManager r5 = r0.getPackageManager()     // Catch:{ all -> 0x01b0 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01b0 }
                android.content.pm.ProviderInfo r4 = r5.resolveContentProvider(r4, r3)     // Catch:{ all -> 0x01b0 }
                boolean r4 = r4.multiprocess     // Catch:{ all -> 0x01b0 }
                goto L_0x01b5
            L_0x01b0:
                java.lang.String r4 = "Provider Error,"
                r1.append(r4)
            L_0x01b5:
                boolean r0 = com.baidu.sofire.l.c.a((android.content.Context) r0, (boolean) r3)
                if (r0 != 0) goto L_0x01c0
                java.lang.String r0 = "Service or Receiver Error."
                r1.append(r0)
            L_0x01c0:
                int r0 = r1.length()
                if (r0 > r2) goto L_0x01c7
                goto L_0x01d1
            L_0x01c7:
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x01d1:
                android.content.Context r0 = r9.a
                java.lang.Class<com.baidu.sofire.l.b> r1 = com.baidu.sofire.l.b.class
                monitor-enter(r1)
                if (r0 != 0) goto L_0x01db
                com.baidu.sofire.l.b r0 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0391 }
                goto L_0x01e8
            L_0x01db:
                com.baidu.sofire.l.b r2 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0391 }
                if (r2 != 0) goto L_0x01e6
                com.baidu.sofire.l.b r2 = new com.baidu.sofire.l.b     // Catch:{ all -> 0x0391 }
                r2.<init>(r0)     // Catch:{ all -> 0x0391 }
                com.baidu.sofire.l.b.h = r2     // Catch:{ all -> 0x0391 }
            L_0x01e6:
                com.baidu.sofire.l.b r0 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0391 }
            L_0x01e8:
                monitor-exit(r1)
                monitor-enter(r0)
                com.baidu.sofire.l.b$a r1 = r0.b     // Catch:{ all -> 0x038e }
                if (r1 == 0) goto L_0x01f0
                monitor-exit(r0)
                goto L_0x0203
            L_0x01f0:
                android.content.Context r1 = r0.a     // Catch:{ all -> 0x038e }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x038e }
                android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x038e }
                com.baidu.sofire.l.b$a r2 = new com.baidu.sofire.l.b$a     // Catch:{ all -> 0x038e }
                r2.<init>(r0)     // Catch:{ all -> 0x038e }
                r0.b = r2     // Catch:{ all -> 0x038e }
                r1.registerActivityLifecycleCallbacks(r2)     // Catch:{ all -> 0x038e }
                monitor-exit(r0)
            L_0x0203:
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                int r0 = com.baidu.sofire.l.c.k(r0)     // Catch:{ all -> 0x038b }
                r1 = 1
                if (r0 == r1) goto L_0x0272
                android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x038b }
                java.lang.String r2 = "com.baidu.action.SOFIRE.VIEW"
                r0.<init>(r2)     // Catch:{ all -> 0x038b }
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                java.lang.Class<com.baidu.sofire.MyService> r4 = com.baidu.sofire.MyService.class
                r0.setClass(r2, r4)     // Catch:{ all -> 0x038b }
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x038b }
                r0.setPackage(r2)     // Catch:{ all -> 0x038b }
                java.lang.String r2 = "com.baidu.category.SOFIRE"
                r0.addCategory(r2)     // Catch:{ all -> 0x038b }
                java.lang.String r2 = "android.intent.category.DEFAULT"
                r0.addCategory(r2)     // Catch:{ all -> 0x038b }
                android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x038b }
                r2.<init>()     // Catch:{ all -> 0x038b }
                java.lang.String r4 = "appkey"
                r5 = 2
                java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x038b }
                java.lang.String r6 = r9.d     // Catch:{ all -> 0x038b }
                r5[r3] = r6     // Catch:{ all -> 0x038b }
                java.lang.String r3 = r9.e     // Catch:{ all -> 0x038b }
                r5[r1] = r3     // Catch:{ all -> 0x038b }
                r2.putStringArray(r4, r5)     // Catch:{ all -> 0x038b }
                java.lang.String r1 = "key"
                int r3 = r9.b     // Catch:{ all -> 0x038b }
                r2.putInt(r1, r3)     // Catch:{ all -> 0x038b }
                java.lang.String r1 = "delay"
                int r3 = r9.f     // Catch:{ all -> 0x038b }
                r2.putInt(r1, r3)     // Catch:{ all -> 0x038b }
                java.lang.String r1 = "bundle"
                r0.putExtra(r1, r2)     // Catch:{ all -> 0x038b }
                android.content.Context r1 = r9.a     // Catch:{ all -> 0x038b }
                r1.startService(r0)     // Catch:{ all -> 0x038b }
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.d.b.a((android.content.Context) r0)     // Catch:{ all -> 0x038b }
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                boolean r1 = com.baidu.sofire.k.b.b()     // Catch:{ all -> 0x038b }
                if (r1 == 0) goto L_0x0271
                com.baidu.sofire.xclient.privacycontrol.PrvControlManager r1 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x026f }
                r1.init(r0)     // Catch:{ all -> 0x026f }
                goto L_0x0271
            L_0x026f:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x0271:
                return
            L_0x0272:
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.l.r.e(r0)     // Catch:{ all -> 0x038b }
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                boolean r0 = com.baidu.sofire.l.c.a((android.content.Context) r0, (boolean) r1)     // Catch:{ all -> 0x038b }
                if (r0 != 0) goto L_0x0280
                return
            L_0x0280:
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.b.d.c(r0)     // Catch:{ all -> 0x038b }
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.b.c r0 = com.baidu.sofire.b.c.a((android.content.Context) r0)     // Catch:{ all -> 0x038b }
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                byte[] r4 = com.baidu.sofire.l.e.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.j.a r2 = com.baidu.sofire.j.a.a((android.content.Context) r2)     // Catch:{ all -> 0x02c0 }
                java.lang.String r4 = r2.d()     // Catch:{ all -> 0x02c0 }
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x02c0 }
                if (r5 == 0) goto L_0x029e
                goto L_0x02c2
            L_0x029e:
                java.lang.String r4 = com.baidu.sofire.l.c.d((java.lang.String) r4)     // Catch:{ all -> 0x02c0 }
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x02c0 }
                if (r5 == 0) goto L_0x02a9
                goto L_0x02c2
            L_0x02a9:
                java.lang.String r5 = r2.a()     // Catch:{ all -> 0x02c0 }
                boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x02c0 }
                if (r5 != 0) goto L_0x02c2
                android.content.SharedPreferences$Editor r5 = r2.d     // Catch:{ all -> 0x02c0 }
                java.lang.String r6 = "xyus"
                r5.putString(r6, r4)     // Catch:{ all -> 0x02c0 }
                android.content.SharedPreferences$Editor r2 = r2.d     // Catch:{ all -> 0x02c0 }
                r2.commit()     // Catch:{ all -> 0x02c0 }
                goto L_0x02c2
            L_0x02c0:
                int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x02c2:
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.l.e.a(r2)     // Catch:{ all -> 0x038b }
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.j.a r4 = com.baidu.sofire.j.a.a((android.content.Context) r2)     // Catch:{ all -> 0x02ea }
                android.content.SharedPreferences r5 = r4.a     // Catch:{ all -> 0x02ea }
                java.lang.String r6 = "s_r_d_l_f"
                boolean r5 = r5.getBoolean(r6, r3)     // Catch:{ all -> 0x02ea }
                if (r5 != 0) goto L_0x02ec
                com.baidu.sofire.l.f.a(r2)     // Catch:{ all -> 0x02ea }
                com.baidu.sofire.l.e.b(r2)     // Catch:{ all -> 0x02ea }
                android.content.SharedPreferences$Editor r2 = r4.b     // Catch:{ all -> 0x02ea }
                java.lang.String r5 = "s_r_d_l_f"
                r2.putBoolean(r5, r1)     // Catch:{ all -> 0x02ea }
                android.content.SharedPreferences$Editor r2 = r4.b     // Catch:{ all -> 0x02ea }
                r2.commit()     // Catch:{ all -> 0x02ea }
                goto L_0x02ec
            L_0x02ea:
                int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x02ec:
                java.lang.String r2 = r9.d     // Catch:{ all -> 0x038b }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x038b }
                if (r2 != 0) goto L_0x0303
                java.lang.String r2 = r9.e     // Catch:{ all -> 0x038b }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x038b }
                if (r2 != 0) goto L_0x0303
                java.lang.String r2 = r9.d     // Catch:{ all -> 0x038b }
                java.lang.String r4 = r9.e     // Catch:{ all -> 0x038b }
                r0.c(r2, r4)     // Catch:{ all -> 0x038b }
            L_0x0303:
                int r2 = r9.f     // Catch:{ all -> 0x030e }
                if (r2 <= 0) goto L_0x0310
                int r2 = r2 * 1000
                long r4 = (long) r2     // Catch:{ all -> 0x030e }
                java.lang.Thread.sleep(r4)     // Catch:{ all -> 0x030e }
                goto L_0x0310
            L_0x030e:
                int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x0310:
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                com.baidu.sofire.j.a r2 = com.baidu.sofire.j.a.a((android.content.Context) r2)     // Catch:{ all -> 0x038b }
                int r4 = r9.b     // Catch:{ all -> 0x038b }
                if (r4 <= 0) goto L_0x0322
                int[] r5 = new int[r1]     // Catch:{ all -> 0x038b }
                r5[r3] = r4     // Catch:{ all -> 0x038b }
                r2.a((int[]) r5)     // Catch:{ all -> 0x038b }
                goto L_0x032c
            L_0x0322:
                int[] r4 = com.baidu.sofire.b.d.f     // Catch:{ all -> 0x038b }
                if (r4 == 0) goto L_0x032c
                int r5 = r4.length     // Catch:{ all -> 0x038b }
                if (r5 <= 0) goto L_0x032c
                r2.a((int[]) r4)     // Catch:{ all -> 0x038b }
            L_0x032c:
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                boolean r4 = com.baidu.sofire.k.b.b()     // Catch:{ all -> 0x038b }
                if (r4 == 0) goto L_0x033e
                com.baidu.sofire.xclient.privacycontrol.PrvControlManager r4 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x033c }
                r4.init(r2)     // Catch:{ all -> 0x033c }
                goto L_0x033e
            L_0x033c:
                int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x033e:
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x038b }
                boolean r2 = com.baidu.sofire.l.s.a(r2)     // Catch:{ all -> 0x038b }
                if (r2 != 0) goto L_0x0381
                boolean unused = com.baidu.sofire.b.d.c = r1     // Catch:{ all -> 0x038b }
                android.content.Context r0 = r9.a     // Catch:{ all -> 0x038b }
                boolean r2 = com.baidu.sofire.k.b.b()     // Catch:{ all -> 0x037e }
                if (r2 != 0) goto L_0x0352
                goto L_0x0380
            L_0x0352:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x037e }
                r2.<init>()     // Catch:{ all -> 0x037e }
                java.lang.String r4 = com.baidu.sofire.l.c.b()     // Catch:{ all -> 0x037e }
                r2.append(r4)     // Catch:{ all -> 0x037e }
                java.lang.String r4 = "pr/2/prc"
                r2.append(r4)     // Catch:{ all -> 0x037e }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x037e }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x037e }
                r4.<init>()     // Catch:{ all -> 0x037e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x037e }
                java.lang.String r0 = com.baidu.sofire.b.l.a((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r4, (boolean) r3, (boolean) r1)     // Catch:{ all -> 0x037e }
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x037e }
                if (r1 != 0) goto L_0x0380
                com.baidu.sofire.k.b.a((java.lang.String) r0)     // Catch:{ all -> 0x037e }
                goto L_0x0380
            L_0x037e:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x038b }
            L_0x0380:
                return
            L_0x0381:
                int r2 = com.baidu.sofire.b.c.f     // Catch:{ all -> 0x038b }
                if (r2 != 0) goto L_0x0387
                com.baidu.sofire.b.c.f = r1     // Catch:{ all -> 0x038b }
            L_0x0387:
                r0.a()     // Catch:{ all -> 0x038b }
                goto L_0x038d
            L_0x038b:
                int r0 = com.baidu.sofire.a.a.a
            L_0x038d:
                return
            L_0x038e:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x0391:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a.run():void");
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Callback a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Class[] d;
        public final /* synthetic */ Object[] e;

        public b(Callback callback, int i2, String str, Class[] clsArr, Object[] objArr) {
            this.a = callback;
            this.b = i2;
            this.c = str;
            this.d = clsArr;
            this.e = objArr;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0112 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r14 = this;
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                r1 = 50
                r3 = 20
                r4 = 1
                r5 = 0
                if (r0 != 0) goto L_0x002e
                r6 = 0
            L_0x000b:
                if (r6 >= r3) goto L_0x001b
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0013
            L_0x0011:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x013d }
            L_0x0013:
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                int r6 = r6 + 1
                goto L_0x000b
            L_0x001b:
                if (r0 != 0) goto L_0x002e
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x002d
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                r2 = 4
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
            L_0x002d:
                return
            L_0x002e:
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                boolean r0 = com.baidu.sofire.l.s.a(r0)     // Catch:{ all -> 0x013d }
                if (r0 != 0) goto L_0x0046
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                r2 = 12
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
                return
            L_0x0046:
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                boolean r0 = com.baidu.sofire.l.c.a((android.content.Context) r0, (boolean) r5)     // Catch:{ all -> 0x013d }
                r6 = 11
                if (r0 != 0) goto L_0x0060
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x005f
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
            L_0x005f:
                return
            L_0x0060:
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                java.lang.String r0 = com.baidu.sofire.l.c.h((android.content.Context) r0)     // Catch:{ all -> 0x013d }
                boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x013d }
                if (r7 == 0) goto L_0x00c0
                android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x013d }
                boolean r0 = com.baidu.sofire.l.c.g((java.lang.String) r0)     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x0089
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x0088
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                r2 = 5
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
            L_0x0088:
                return
            L_0x0089:
                com.baidu.sofire.b.c r0 = com.baidu.sofire.b.c.d     // Catch:{ all -> 0x013d }
                if (r0 != 0) goto L_0x00b0
                r7 = 0
            L_0x008e:
                if (r7 >= r3) goto L_0x009e
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0094 }
                goto L_0x0096
            L_0x0094:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x013d }
            L_0x0096:
                com.baidu.sofire.b.c r0 = com.baidu.sofire.b.c.d     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x009b
                goto L_0x009e
            L_0x009b:
                int r7 = r7 + 1
                goto L_0x008e
            L_0x009e:
                if (r0 != 0) goto L_0x00b0
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x00af
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
            L_0x00af:
                return
            L_0x00b0:
                r6 = r0
                int r7 = r14.b     // Catch:{ all -> 0x013d }
                java.lang.String r8 = r14.c     // Catch:{ all -> 0x013d }
                com.baidu.sofire.ac.Callback r9 = r14.a     // Catch:{ all -> 0x013d }
                java.lang.Class[] r10 = r14.d     // Catch:{ all -> 0x013d }
                java.lang.Object[] r11 = r14.e     // Catch:{ all -> 0x013d }
                r6.a((int) r7, (java.lang.String) r8, (com.baidu.sofire.ac.Callback) r9, (java.lang.Class<?>[]) r10, (java.lang.Object[]) r11)     // Catch:{ all -> 0x013d }
                goto L_0x013f
            L_0x00c0:
                boolean r0 = com.baidu.sofire.l.c.g((java.lang.String) r0)     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x0107
                android.content.Context r9 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x013d }
                int r10 = r14.b     // Catch:{ all -> 0x013d }
                java.lang.String r11 = r14.c     // Catch:{ all -> 0x013d }
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                java.lang.Class[] r12 = r14.d     // Catch:{ all -> 0x013d }
                java.lang.Object[] r13 = r14.e     // Catch:{ all -> 0x013d }
                boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00f5 }
                if (r1 == 0) goto L_0x00e6
                if (r0 == 0) goto L_0x013f
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x00f5 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00f5 }
                r1[r5] = r2     // Catch:{ all -> 0x00f5 }
                r0.onError(r1)     // Catch:{ all -> 0x00f5 }
                goto L_0x013f
            L_0x00e6:
                com.baidu.sofire.l.w r1 = com.baidu.sofire.l.w.a((android.content.Context) r9)     // Catch:{ all -> 0x00f5 }
                com.baidu.sofire.b.h r2 = new com.baidu.sofire.b.h     // Catch:{ all -> 0x00f5 }
                r7 = r2
                r8 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00f5 }
                r1.a((java.lang.Runnable) r2)     // Catch:{ all -> 0x00f5 }
                goto L_0x013f
            L_0x00f5:
                if (r0 == 0) goto L_0x0104
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0104 }
                r2 = 3
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0104 }
                r1[r5] = r2     // Catch:{ all -> 0x0104 }
                r0.onError(r1)     // Catch:{ all -> 0x0104 }
            L_0x0104:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x013d }
                goto L_0x013f
            L_0x0107:
                com.baidu.sofire.b.c r0 = com.baidu.sofire.b.c.d     // Catch:{ all -> 0x013d }
                if (r0 != 0) goto L_0x012e
                r7 = 0
            L_0x010c:
                if (r7 >= r3) goto L_0x011c
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0112 }
                goto L_0x0114
            L_0x0112:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x013d }
            L_0x0114:
                com.baidu.sofire.b.c r0 = com.baidu.sofire.b.c.d     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x0119
                goto L_0x011c
            L_0x0119:
                int r7 = r7 + 1
                goto L_0x010c
            L_0x011c:
                if (r0 != 0) goto L_0x012e
                com.baidu.sofire.ac.Callback r0 = r14.a     // Catch:{ all -> 0x013d }
                if (r0 == 0) goto L_0x012d
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x013d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x013d }
                r1[r5] = r2     // Catch:{ all -> 0x013d }
                r0.onError(r1)     // Catch:{ all -> 0x013d }
            L_0x012d:
                return
            L_0x012e:
                r6 = r0
                int r7 = r14.b     // Catch:{ all -> 0x013d }
                java.lang.String r8 = r14.c     // Catch:{ all -> 0x013d }
                com.baidu.sofire.ac.Callback r9 = r14.a     // Catch:{ all -> 0x013d }
                java.lang.Class[] r10 = r14.d     // Catch:{ all -> 0x013d }
                java.lang.Object[] r11 = r14.e     // Catch:{ all -> 0x013d }
                r6.a((int) r7, (java.lang.String) r8, (com.baidu.sofire.ac.Callback) r9, (java.lang.Class<?>[]) r10, (java.lang.Object[]) r11)     // Catch:{ all -> 0x013d }
                goto L_0x013f
            L_0x013d:
                int r0 = com.baidu.sofire.a.a.a
            L_0x013f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.b.run():void");
        }
    }

    public class c implements GzfiCallback {
        public final /* synthetic */ com.baidu.sofire.d.a a;

        public c(com.baidu.sofire.d.a aVar) {
            this.a = aVar;
        }

        public void onComplete(int i2, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putInt("resultCode", i2);
            bundle.putString("ztoken", str);
            bundle.putString("errorMsg", str2);
            try {
                this.a.a(bundle);
            } catch (RemoteException unused) {
                int i3 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public static Pair<Integer, Object> b(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.e;
            if (context == null) {
                return new Pair<>(4, (Object) null);
            }
            if (!com.baidu.sofire.l.c.a(context, false)) {
                return new Pair<>(11, (Object) null);
            }
            String h2 = com.baidu.sofire.l.c.h(c.e);
            if (TextUtils.isEmpty(h2)) {
                if (com.baidu.sofire.l.c.g(c.e.getPackageName())) {
                    return new Pair<>(5, (Object) null);
                }
                c.a(context);
                return a(str, (Class[]) clsArr, objArr);
            } else if (com.baidu.sofire.l.c.g(h2)) {
                return a(c.e, i2, 1, str, clsArr, objArr);
            } else {
                c.a(context);
                return a(str, (Class[]) clsArr, objArr);
            }
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
            return new Pair<>(3, (Object) null);
        }
    }

    public static String c(Context context) {
        try {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            if (context == null) {
                return "";
            }
            if (com.baidu.sofire.k.a.b()) {
                return x.a(context).a(true);
            }
            if (!com.baidu.sofire.l.c.a(context, false)) {
                return "";
            }
            String h2 = com.baidu.sofire.l.c.h(context);
            if (TextUtils.isEmpty(h2)) {
                if (com.baidu.sofire.l.c.g(context.getPackageName())) {
                    return "";
                }
                return d(context);
            } else if (!com.baidu.sofire.l.c.g(h2)) {
                return d(context);
            } else {
                Pair<Integer, Object> a2 = a(context, 0, 1, "gz", (Class<?>[]) null, new Object[0]);
                if (a2 != null) {
                    if (((Integer) a2.first).intValue() == 0) {
                        return (String) a2.second;
                    }
                    return "";
                }
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static String d(Context context) {
        try {
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
            String string = a2.c.getString("xytk", "");
            if (!TextUtils.isEmpty(string)) {
                a = string;
                return string;
            }
            String string2 = a2.c.getString("xytk_m", "");
            if (!TextUtils.isEmpty(string2)) {
                a = string2;
                return string2;
            }
            String a3 = x.a(e.a(context));
            if (!"74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03".equals(a3)) {
                a2.d(a3);
            }
            a = a3;
            return a3;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
    }

    public static String a(Context context, String str, int i2, String str2) {
        int i3 = i2;
        String str3 = str2;
        Class<String> cls = String.class;
        if (context == null) {
            try {
                b.b = 1001;
                return "";
            } catch (Throwable th2) {
                b.c = com.baidu.sofire.a.a.a(th2);
                int i4 = com.baidu.sofire.a.a.a;
            }
        } else {
            if (i3 != 99999) {
                if (TextUtils.isEmpty(str2) || !str3.contains("enoketnco")) {
                    if (com.baidu.sofire.k.a.b()) {
                        String a2 = x.a(context).a(true);
                        if (i3 != 0 && s.a(context)) {
                            if (TextUtils.isEmpty(str2)) {
                                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE}, str, Integer.valueOf(i2));
                            } else {
                                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE, cls}, str, Integer.valueOf(i2), str3);
                            }
                        }
                        return a2;
                    } else if (!TextUtils.isEmpty(a)) {
                        if (i3 != 0 && s.a(context)) {
                            if (TextUtils.isEmpty(str2)) {
                                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE}, str, Integer.valueOf(i2));
                            } else {
                                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE, cls}, str, Integer.valueOf(i2), str3);
                            }
                        }
                        return a;
                    } else if (!com.baidu.sofire.l.c.a(context, false)) {
                        b.b = 1002;
                        b.a = com.baidu.sofire.l.c.a();
                        return "";
                    } else {
                        String h2 = com.baidu.sofire.l.c.h(context);
                        if (TextUtils.isEmpty(h2)) {
                            if (!com.baidu.sofire.l.c.g(context.getPackageName())) {
                                return b(context, str, i2, str2);
                            }
                            b.b = 1003;
                            b.a = com.baidu.sofire.l.c.a();
                            return "";
                        } else if (!com.baidu.sofire.l.c.g(h2)) {
                            return b(context, str, i2, str2);
                        } else {
                            Pair<Integer, Object> a3 = a(context, 0, 1, "gzfi", (Class<?>[]) null, str, Integer.valueOf(i2), str3);
                            if (a3 == null) {
                                b.b = 1004;
                                b.a(-1001);
                                b.b = 1005;
                                b.a(-1002);
                                return "";
                            } else if (((Integer) a3.first).intValue() == 0) {
                                return (String) a3.second;
                            } else {
                                b.b = 1004;
                                b.a(((Integer) a3.first).intValue());
                                return "";
                            }
                        }
                    }
                }
            }
            return b(context);
        }
    }

    public static String b(Context context, String str, int i2, String str2) {
        Class<String> cls = String.class;
        if (context == null) {
            return "";
        }
        if (i2 != 0) {
            if (!TextUtils.isEmpty(str2) || !s.a(context)) {
                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE, cls}, str, Integer.valueOf(i2), str2);
            } else {
                a(1, "ice", (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE}, str, Integer.valueOf(i2));
            }
        }
        return d(context);
    }

    public static String b(Context context) {
        try {
            Pair<Integer, Object> a2 = a(1, "got", (Class<?>[]) null, new Object[0]);
            if (a2 != null && ((Integer) a2.first).intValue() == 0) {
                String str = (String) a2.second;
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
        try {
            com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context);
            String string = a3.c.getString("xytk_m", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String a4 = x.a(e.a(context));
            a3.d(a4);
            return a4;
        } catch (Throwable unused2) {
            int i3 = com.baidu.sofire.a.a.a;
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
    }

    public static synchronized void a(Context context, int i2, String str, String str2, int... iArr) {
        int i3;
        synchronized (d.class) {
            if (iArr != null) {
                try {
                    if (iArr.length > 1) {
                        f = iArr;
                        i3 = 0;
                        a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (iArr != null && iArr.length == 1) {
                i3 = iArr[0];
                a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
            }
            i3 = 0;
            a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r10, int r11, java.lang.String r12, java.lang.String r13, com.baidu.sofire.ac.BDModuleLoadCallback r14, int r15) {
        /*
            java.lang.Class<com.baidu.sofire.b.d> r0 = com.baidu.sofire.b.d.class
            monitor-enter(r0)
            com.baidu.sofire.l.l.b()     // Catch:{ all -> 0x0029 }
            if (r10 != 0) goto L_0x000a
            monitor-exit(r0)
            return
        L_0x000a:
            boolean r1 = b     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            r1 = 1
            b = r1     // Catch:{ all -> 0x0029 }
            com.baidu.sofire.b.c.e = r10     // Catch:{ all -> 0x0029 }
            com.baidu.sofire.l.w r1 = com.baidu.sofire.l.w.a((android.content.Context) r10)     // Catch:{ all -> 0x0029 }
            com.baidu.sofire.b.d$a r9 = new com.baidu.sofire.b.d$a     // Catch:{ all -> 0x0029 }
            r2 = r9
            r3 = r10
            r4 = r15
            r5 = r14
            r6 = r12
            r7 = r13
            r8 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0029 }
            r1.b(r9)     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)
            return
        L_0x002d:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(android.content.Context, int, java.lang.String, java.lang.String, com.baidu.sofire.ac.BDModuleLoadCallback, int):void");
    }

    public static Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.e;
            if (context == null) {
                return new Pair<>(4, (Object) null);
            }
            if (!s.a(context)) {
                return new Pair<>(12, (Object) null);
            }
            if (!com.baidu.sofire.l.c.a(c.e, false)) {
                return new Pair<>(11, (Object) null);
            }
            String h2 = com.baidu.sofire.l.c.h(c.e);
            if (TextUtils.isEmpty(h2)) {
                if (com.baidu.sofire.l.c.g(c.e.getPackageName())) {
                    return new Pair<>(5, (Object) null);
                }
                return c.a(context).a(i2, str, clsArr, objArr);
            } else if (com.baidu.sofire.l.c.g(h2)) {
                return a(c.e, i2, 1, str, clsArr, objArr);
            } else {
                return c.a(context).a(i2, str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
            return new Pair<>(3, (Object) null);
        }
    }

    public static Pair a(String str, Class[] clsArr, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return new Pair(1, (Object) null);
        }
        try {
            j jVar = j.g;
            if (jVar == null) {
                return new Pair(3, (Object) null);
            }
            ApkInfo b2 = jVar.b("com.baidu.sofire.x0");
            if (b2 != null) {
                Class<?> a2 = ((i) b2.classLoader).a(com.baidu.sofire.l.c.c(b2.es));
                return new Pair(0, com.baidu.sofire.l.c.a(a2.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a2, new Object[]{c.e}), str, (Class<?>[]) clsArr, objArr));
            }
            return new Pair(3, (Object) null);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static boolean a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            if (w.a(c.e).a((Runnable) new b(callback, i2, str, clsArr, objArr)) == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
            return false;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized void a(android.content.Context r17, android.os.Bundle r18) {
        /*
            r0 = r18
            java.lang.Class<com.baidu.sofire.b.d> r1 = com.baidu.sofire.b.d.class
            monitor-enter(r1)
            java.lang.ClassLoader r2 = r1.getClassLoader()     // Catch:{ all -> 0x00bb }
            r0.setClassLoader(r2)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "accountId"
            java.lang.String r3 = ""
            java.lang.String r6 = r0.getString(r2, r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "scene"
            r3 = 0
            int r7 = r0.getInt(r2, r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "para"
            java.lang.String r3 = ""
            java.lang.String r8 = r0.getString(r2, r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "timeout"
            r3 = 20
            int r2 = r0.getInt(r2, r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "binderHolder"
            android.os.Parcelable r0 = r0.getParcelable(r4)     // Catch:{ all -> 0x00bb }
            com.baidu.sofire.mutiprocess.BinderHolder r0 = (com.baidu.sofire.mutiprocess.BinderHolder) r0     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x00b9
            android.os.IBinder r0 = r0.a     // Catch:{ all -> 0x00bb }
            if (r0 != 0) goto L_0x003b
            goto L_0x00b9
        L_0x003b:
            com.baidu.sofire.d.a r0 = com.baidu.sofire.d.a.C0051a.a(r0)     // Catch:{ all -> 0x00bb }
            com.baidu.sofire.b.d$c r4 = new com.baidu.sofire.b.d$c     // Catch:{ all -> 0x00bb }
            r4.<init>(r0)     // Catch:{ all -> 0x00bb }
            monitor-enter(r1)     // Catch:{ all -> 0x00bb }
            android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x004f
            android.content.Context r0 = r17.getApplicationContext()     // Catch:{ all -> 0x00b0 }
            com.baidu.sofire.b.c.e = r0     // Catch:{ all -> 0x00b0 }
        L_0x004f:
            android.util.Pair r0 = a((android.content.Context) r17)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0074
            java.lang.Object r5 = r0.first     // Catch:{ all -> 0x00b0 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x00b0 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x00b0 }
            r9 = 1
            if (r5 != r9) goto L_0x0074
            r5 = r17
            java.lang.String r2 = a((android.content.Context) r5, (java.lang.String) r6, (int) r7, (java.lang.String) r8)     // Catch:{ all -> 0x00b0 }
            java.lang.Object r0 = r0.first     // Catch:{ all -> 0x00b0 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00b0 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = ""
            r4.onComplete(r0, r2, r3)     // Catch:{ all -> 0x00b0 }
            goto L_0x00b2
        L_0x0074:
            r5 = r17
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r9 = f1086i     // Catch:{ all -> 0x00b0 }
            monitor-enter(r9)     // Catch:{ all -> 0x00b0 }
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r0 = f1086i     // Catch:{ all -> 0x00ad }
            r0.add(r4)     // Catch:{ all -> 0x00ad }
            monitor-exit(r9)     // Catch:{ all -> 0x00ad }
            if (r2 > 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r3 = r2
        L_0x0083:
            java.lang.Object r2 = h     // Catch:{ all -> 0x00b0 }
            monitor-enter(r2)     // Catch:{ all -> 0x00b0 }
            java.util.Timer r0 = g     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x00a8
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00aa }
            int r3 = r3 * 1000
            long r3 = (long) r3     // Catch:{ all -> 0x00aa }
            long r9 = r9 + r3
            java.util.Timer r11 = new java.util.Timer     // Catch:{ all -> 0x00aa }
            r11.<init>()     // Catch:{ all -> 0x00aa }
            g = r11     // Catch:{ all -> 0x00aa }
            com.baidu.sofire.b.f r12 = new com.baidu.sofire.b.f     // Catch:{ all -> 0x00aa }
            r4 = r12
            r5 = r17
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00aa }
            r13 = 100
            r15 = 100
            r11.schedule(r12, r13, r15)     // Catch:{ all -> 0x00aa }
        L_0x00a8:
            monitor-exit(r2)     // Catch:{ all -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00aa }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00b5 }
        L_0x00b2:
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)
            return
        L_0x00b5:
            r0 = move-exception
            r2 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00b9:
            monitor-exit(r1)
            return
        L_0x00bb:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(android.content.Context, android.os.Bundle):void");
    }

    public static Pair<Integer, String> a(Context context) {
        try {
            if (!com.baidu.sofire.l.c.b(1)) {
                return new Pair<>(-1, "");
            }
            if (com.baidu.sofire.l.c.k(context) == 0) {
                return new Pair<>(-2, "");
            }
            Pair<Integer, Object> a2 = a(1, "gcfs", (Class<?>[]) null, new Object[0]);
            if (a2 != null && ((Integer) a2.first).intValue() == 0) {
                return (Pair) a2.second;
            }
            return new Pair<>(-1, "");
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r4 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4 = f1086i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r4 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r4.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r0 = f1086i
            monitor-enter(r0)
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r1 = f1086i     // Catch:{ all -> 0x0022 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0022 }
        L_0x0009:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x001d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0022 }
            com.baidu.sofire.ac.GzfiCallback r2 = (com.baidu.sofire.ac.GzfiCallback) r2     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0009
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0022 }
            r2.onComplete(r4, r5, r6)     // Catch:{ all -> 0x0022 }
            goto L_0x0009
        L_0x001d:
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r4 = f1086i     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x002e
            goto L_0x0028
        L_0x0022:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0032 }
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r4 = f1086i     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x002e
        L_0x0028:
            r4.clear()     // Catch:{ all -> 0x002c }
            goto L_0x002e
        L_0x002c:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r4 = move-exception
            goto L_0x003e
        L_0x0032:
            r4 = move-exception
            java.util.List<com.baidu.sofire.ac.GzfiCallback> r5 = f1086i     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x003d
            r5.clear()     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0030 }
        L_0x003d:
            throw r4     // Catch:{ all -> 0x0030 }
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(int, java.lang.String, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.Class[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:72|73|74) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:64|65|66|67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
        r3.putInt("status", 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
        r3.putParcelable("result", r0);
        r3.putInt("status", 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0144, code lost:
        return r3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x0133 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x013c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x013c=Splitter:B:72:0x013c, B:10:0x002d=Splitter:B:10:0x002d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle a(android.content.Context r17, java.lang.String r18, android.os.Bundle r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "status"
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "gzfi"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0170 }
            r5 = 3
            r6 = 7
            r7 = 8
            java.lang.String r8 = "args"
            r9 = 2
            java.lang.String r10 = "handle_flag"
            java.lang.String r11 = "result"
            r12 = 0
            r13 = 0
            r14 = 1
            if (r4 == 0) goto L_0x008f
            r3.putBoolean(r10, r14)     // Catch:{ all -> 0x0170 }
            if (r1 == 0) goto L_0x0172
            com.baidu.sofire.core.CallArgs r0 = new com.baidu.sofire.core.CallArgs     // Catch:{ all -> 0x0170 }
            r0.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.Class<com.baidu.sofire.MyProvider> r4 = com.baidu.sofire.MyProvider.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x0089 }
            r1.setClassLoader(r4)     // Catch:{ all -> 0x0089 }
            android.os.Parcelable r1 = r1.getParcelable(r8)     // Catch:{ all -> 0x0089 }
            com.baidu.sofire.core.CallArgs r1 = (com.baidu.sofire.core.CallArgs) r1     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0065
            java.lang.Object[] r1 = r1.e     // Catch:{ all -> 0x0089 }
            int r4 = r1.length     // Catch:{ all -> 0x0089 }
            if (r4 != r9) goto L_0x004f
            r4 = r1[r13]     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0089 }
            r1 = r1[r14]     // Catch:{ all -> 0x0089 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0089 }
            r16 = r12
            r12 = r1
            r1 = r16
            goto L_0x0067
        L_0x004f:
            int r4 = r1.length     // Catch:{ all -> 0x0089 }
            if (r4 != r5) goto L_0x0065
            r4 = r1[r13]     // Catch:{ all -> 0x0089 }
            r12 = r4
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0089 }
            r4 = r1[r14]     // Catch:{ all -> 0x0089 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0089 }
            r1 = r1[r9]     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0089 }
            r16 = r12
            r12 = r4
            r4 = r16
            goto L_0x0067
        L_0x0065:
            r1 = r12
            r4 = r1
        L_0x0067:
            if (r12 != 0) goto L_0x006d
            r5 = 0
        L_0x006a:
            r15 = r17
            goto L_0x0072
        L_0x006d:
            int r5 = r12.intValue()     // Catch:{ all -> 0x0089 }
            goto L_0x006a
        L_0x0072:
            java.lang.String r1 = b((android.content.Context) r15, (java.lang.String) r4, (int) r5, (java.lang.String) r1)     // Catch:{ all -> 0x0089 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0080
            r3.putInt(r2, r7)     // Catch:{ all -> 0x0089 }
            goto L_0x0088
        L_0x0080:
            r0.f = r1     // Catch:{ all -> 0x0089 }
            r3.putParcelable(r11, r0)     // Catch:{ all -> 0x0089 }
            r3.putInt(r2, r13)     // Catch:{ all -> 0x0089 }
        L_0x0088:
            return r3
        L_0x0089:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0170 }
            r3.putInt(r2, r6)     // Catch:{ all -> 0x0170 }
            return r3
        L_0x008f:
            r15 = r17
            java.lang.String r4 = "invokeMethod"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0170 }
            if (r4 == 0) goto L_0x0145
            r3.putBoolean(r10, r14)     // Catch:{ all -> 0x0170 }
            if (r1 == 0) goto L_0x0172
            com.baidu.sofire.core.CallArgs r0 = new com.baidu.sofire.core.CallArgs     // Catch:{ all -> 0x0170 }
            r0.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.Class<com.baidu.sofire.MyProvider> r4 = com.baidu.sofire.MyProvider.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x013c }
            r1.setClassLoader(r4)     // Catch:{ all -> 0x013c }
            android.os.Parcelable r1 = r1.getParcelable(r8)     // Catch:{ all -> 0x013c }
            com.baidu.sofire.core.CallArgs r1 = (com.baidu.sofire.core.CallArgs) r1     // Catch:{ all -> 0x013c }
            int r4 = r1.a     // Catch:{ all -> 0x013c }
            int r7 = r1.b     // Catch:{ all -> 0x013c }
            java.lang.String r8 = r1.c     // Catch:{ all -> 0x013c }
            java.lang.Object[] r9 = r1.d     // Catch:{ all -> 0x013c }
            if (r9 == 0) goto L_0x00ea
            int r10 = r9.length     // Catch:{ all -> 0x013c }
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ all -> 0x013c }
        L_0x00bf:
            int r10 = r9.length     // Catch:{ all -> 0x013c }
            if (r13 >= r10) goto L_0x00ea
            r10 = r9[r13]     // Catch:{ all -> 0x013c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x013c }
            boolean r15 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x013c }
            if (r15 != 0) goto L_0x00dd
            java.lang.String r15 = "@@"
            boolean r15 = r10.contains(r15)     // Catch:{ all -> 0x013c }
            if (r15 == 0) goto L_0x00dd
            java.lang.Class r10 = com.baidu.sofire.l.c.a((java.lang.String) r10)     // Catch:{ all -> 0x013c }
            if (r10 == 0) goto L_0x00e7
            r12[r13] = r10     // Catch:{ all -> 0x013c }
            goto L_0x00e7
        L_0x00dd:
            r10 = r9[r13]     // Catch:{ all -> 0x013c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x013c }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x013c }
            r12[r13] = r10     // Catch:{ all -> 0x013c }
        L_0x00e7:
            int r13 = r13 + 1
            goto L_0x00bf
        L_0x00ea:
            java.lang.Object[] r1 = r1.e     // Catch:{ all -> 0x013c }
            if (r7 != r14) goto L_0x011b
            if (r4 != r14) goto L_0x00fd
            java.lang.String r5 = "xgz"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x013c }
            if (r5 == 0) goto L_0x00fd
            android.util.Pair r1 = a((java.lang.String) r8, (java.lang.Class[]) r12, (java.lang.Object[]) r1)     // Catch:{ all -> 0x013c }
            goto L_0x0101
        L_0x00fd:
            android.util.Pair r1 = a((int) r4, (java.lang.String) r8, (java.lang.Class<?>[]) r12, (java.lang.Object[]) r1)     // Catch:{ all -> 0x013c }
        L_0x0101:
            java.lang.Object r4 = r1.first     // Catch:{ all -> 0x013c }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x013c }
            int r4 = r4.intValue()     // Catch:{ all -> 0x013c }
            r3.putInt(r2, r4)     // Catch:{ all -> 0x013c }
            java.lang.Object r4 = r1.first     // Catch:{ all -> 0x013c }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x013c }
            int r4 = r4.intValue()     // Catch:{ all -> 0x013c }
            if (r4 != 0) goto L_0x0138
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x013c }
            r0.f = r1     // Catch:{ all -> 0x013c }
            goto L_0x0138
        L_0x011b:
            if (r7 != 0) goto L_0x0138
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x013c }
            r7.<init>(r14)     // Catch:{ all -> 0x013c }
            com.baidu.sofire.b.g r9 = new com.baidu.sofire.b.g     // Catch:{ all -> 0x013c }
            r9.<init>(r3, r0, r7, r8)     // Catch:{ all -> 0x013c }
            a((int) r4, (java.lang.String) r8, (com.baidu.sofire.ac.Callback) r9, (java.lang.Class<?>[]) r12, (java.lang.Object[]) r1)     // Catch:{ all -> 0x013c }
            r8 = 180000(0x2bf20, double:8.8932E-319)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0133 }
            r7.await(r8, r1)     // Catch:{ all -> 0x0133 }
            goto L_0x0138
        L_0x0133:
            r3.putInt(r2, r5)     // Catch:{ all -> 0x013c }
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x013c }
        L_0x0138:
            r3.putParcelable(r11, r0)     // Catch:{ all -> 0x013c }
            return r3
        L_0x013c:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0170 }
            r3.putParcelable(r11, r0)     // Catch:{ all -> 0x0170 }
            r3.putInt(r2, r6)     // Catch:{ all -> 0x0170 }
            return r3
        L_0x0145:
            java.lang.String r1 = "gz"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0170 }
            if (r0 == 0) goto L_0x016c
            r3.putBoolean(r10, r14)     // Catch:{ all -> 0x0170 }
            java.lang.String r0 = d(r17)     // Catch:{ all -> 0x0170 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0170 }
            if (r1 == 0) goto L_0x015e
            r3.putInt(r2, r7)     // Catch:{ all -> 0x0170 }
            goto L_0x016b
        L_0x015e:
            com.baidu.sofire.core.CallArgs r1 = new com.baidu.sofire.core.CallArgs     // Catch:{ all -> 0x0170 }
            r1.<init>()     // Catch:{ all -> 0x0170 }
            r1.f = r0     // Catch:{ all -> 0x0170 }
            r3.putParcelable(r11, r1)     // Catch:{ all -> 0x0170 }
            r3.putInt(r2, r13)     // Catch:{ all -> 0x0170 }
        L_0x016b:
            return r3
        L_0x016c:
            r3.putInt(r2, r9)     // Catch:{ all -> 0x0170 }
            return r3
        L_0x0170:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0172:
            r0 = 10
            r3.putInt(r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(android.content.Context, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Object> a(android.content.Context r6, int r7, int r8, java.lang.String r9, java.lang.Class<?>[] r10, java.lang.Object... r11) {
        /*
            r0 = 3
            r1 = 0
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00bb }
            r4 = 1
            if (r3 == 0) goto L_0x0013
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00bb }
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch:{ all -> 0x00bb }
            return r6
        L_0x0013:
            java.lang.String r3 = "gzfi"
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "gz"
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x0024
            goto L_0x0028
        L_0x0024:
            java.lang.String r3 = "invokeMethod"
            r4 = 0
            goto L_0x0029
        L_0x0028:
            r3 = r9
        L_0x0029:
            com.baidu.sofire.core.CallArgs r5 = new com.baidu.sofire.core.CallArgs     // Catch:{ all -> 0x00b8 }
            r5.<init>()     // Catch:{ all -> 0x00b8 }
            r5.a = r7     // Catch:{ all -> 0x00b8 }
            r5.c = r9     // Catch:{ all -> 0x00b8 }
            r5.b = r8     // Catch:{ all -> 0x00b8 }
            if (r10 == 0) goto L_0x0071
            int r7 = r10.length     // Catch:{ all -> 0x00b8 }
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00b8 }
        L_0x0039:
            int r8 = r10.length     // Catch:{ all -> 0x00b8 }
            if (r1 >= r8) goto L_0x006f
            r8 = r10[r1]     // Catch:{ all -> 0x00b8 }
            boolean r8 = r8.isPrimitive()     // Catch:{ all -> 0x00b8 }
            if (r8 == 0) goto L_0x0064
            r8 = r10[r1]     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = com.baidu.sofire.l.c.a((java.lang.Class<?>) r8)     // Catch:{ all -> 0x00b8 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00b8 }
            if (r9 != 0) goto L_0x006c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r9.<init>()     // Catch:{ all -> 0x00b8 }
            r9.append(r8)     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = "@@"
            r9.append(r8)     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x00b8 }
            r7[r1] = r8     // Catch:{ all -> 0x00b8 }
            goto L_0x006c
        L_0x0064:
            r8 = r10[r1]     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x00b8 }
            r7[r1] = r8     // Catch:{ all -> 0x00b8 }
        L_0x006c:
            int r1 = r1 + 1
            goto L_0x0039
        L_0x006f:
            r5.d = r7     // Catch:{ all -> 0x00b8 }
        L_0x0071:
            r5.e = r11     // Catch:{ all -> 0x00b8 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x00b8 }
            r7.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = "args"
            r7.putParcelable(r8, r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r8 = "sofire"
            android.os.Bundle r6 = com.baidu.sofire.l.t.a((android.content.Context) r6, (java.lang.String) r3, (android.os.Bundle) r7, (java.lang.String) r8)     // Catch:{ all -> 0x00b8 }
            if (r6 != 0) goto L_0x008e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00b8 }
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch:{ all -> 0x00b8 }
            return r6
        L_0x008e:
            java.lang.Class<com.baidu.sofire.core.CallArgs> r7 = com.baidu.sofire.core.CallArgs.class
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch:{ all -> 0x00b8 }
            r6.setClassLoader(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = "status"
            int r7 = r6.getInt(r7)     // Catch:{ all -> 0x00b8 }
            if (r7 != 0) goto L_0x00a8
            java.lang.String r8 = "result"
            android.os.Parcelable r6 = r6.getParcelable(r8)     // Catch:{ all -> 0x00b8 }
            com.baidu.sofire.core.CallArgs r6 = (com.baidu.sofire.core.CallArgs) r6     // Catch:{ all -> 0x00b8 }
            goto L_0x00a9
        L_0x00a8:
            r6 = r2
        L_0x00a9:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00b8 }
            if (r6 != 0) goto L_0x00b1
            r6 = r2
            goto L_0x00b3
        L_0x00b1:
            java.lang.Object r6 = r6.f     // Catch:{ all -> 0x00b8 }
        L_0x00b3:
            android.util.Pair r6 = android.util.Pair.create(r7, r6)     // Catch:{ all -> 0x00b8 }
            return r6
        L_0x00b8:
            r6 = move-exception
            r1 = r4
            goto L_0x00bc
        L_0x00bb:
            r6 = move-exception
        L_0x00bc:
            if (r1 == 0) goto L_0x00c4
            java.lang.String r6 = com.baidu.sofire.a.a.a(r6)
            com.baidu.sofire.b.b.c = r6
        L_0x00c4:
            int r6 = com.baidu.sofire.a.a.a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            android.util.Pair r6 = android.util.Pair.create(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(android.content.Context, int, int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized void a(android.content.Context r5, boolean r6) {
        /*
            java.lang.Class<com.baidu.sofire.b.d> r0 = com.baidu.sofire.b.d.class
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            int r1 = com.baidu.sofire.l.c.k(r5)     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x001f
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "_agree_policy"
            r1.putBoolean(r2, r6)     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = "setAgreePolicy"
            java.lang.String r2 = "sofire"
            com.baidu.sofire.l.t.a((android.content.Context) r5, (java.lang.String) r6, (android.os.Bundle) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x001f:
            r2 = 1
            if (r1 != r2) goto L_0x0072
            if (r6 == 0) goto L_0x0026
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 2
        L_0x0027:
            com.baidu.sofire.l.s.a = r1     // Catch:{ all -> 0x0070 }
            r1 = r6 ^ 1
            java.lang.String r3 = ".ffnpp"
            com.baidu.sofire.l.c.a((android.content.Context) r5, (java.lang.String) r3, (int) r1)     // Catch:{ all -> 0x0070 }
            com.baidu.sofire.j.a r1 = com.baidu.sofire.j.a.a((android.content.Context) r5)     // Catch:{ all -> 0x0070 }
            android.content.SharedPreferences$Editor r3 = r1.d     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "s_a_pl"
            r3.putBoolean(r4, r6)     // Catch:{ all -> 0x0070 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0070 }
            r4 = 9
            if (r3 < r4) goto L_0x0047
            android.content.SharedPreferences$Editor r1 = r1.d     // Catch:{ all -> 0x0070 }
            r1.apply()     // Catch:{ all -> 0x0070 }
            goto L_0x004c
        L_0x0047:
            android.content.SharedPreferences$Editor r1 = r1.d     // Catch:{ all -> 0x0070 }
            r1.commit()     // Catch:{ all -> 0x0070 }
        L_0x004c:
            if (r6 == 0) goto L_0x0072
            boolean r6 = d     // Catch:{ all -> 0x0070 }
            if (r6 != 0) goto L_0x0072
            d = r2     // Catch:{ all -> 0x0070 }
            monitor-enter(r0)     // Catch:{ all -> 0x0070 }
            boolean r6 = c     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x006b
            r6 = 0
            c = r6     // Catch:{ all -> 0x0069 }
            com.baidu.sofire.l.w r6 = com.baidu.sofire.l.w.a((android.content.Context) r5)     // Catch:{ all -> 0x0069 }
            com.baidu.sofire.b.e r1 = new com.baidu.sofire.b.e     // Catch:{ all -> 0x0069 }
            r1.<init>(r5)     // Catch:{ all -> 0x0069 }
            r6.b(r1)     // Catch:{ all -> 0x0069 }
            goto L_0x006b
        L_0x0069:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x006d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r0)
            return
        L_0x0074:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(android.content.Context, boolean):void");
    }

    public static void a(Context context, int i2, BDModuleLoadCallback bDModuleLoadCallback, boolean z) {
        if (i2 > 0 && bDModuleLoadCallback != null) {
            if (com.baidu.sofire.l.c.b(i2)) {
                bDModuleLoadCallback.onSuccess(i2);
            } else if (System.currentTimeMillis() - e < 10000) {
                bDModuleLoadCallback.onFailure(i2, 8);
            } else {
                e = System.currentTimeMillis();
                if (com.baidu.sofire.l.c.k(context.getApplicationContext()) != 1) {
                    bDModuleLoadCallback.onFailure(i2, 9);
                } else if (!s.a(context.getApplicationContext())) {
                    bDModuleLoadCallback.onFailure(i2, 10);
                } else {
                    synchronized (a.class) {
                        List list = a.p.get(Integer.valueOf(i2));
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(bDModuleLoadCallback);
                        a.p.put(Integer.valueOf(i2), list);
                    }
                    if (z) {
                        Map<Integer, List<BDModuleLoadCallback>> map = a.p;
                        w.a(context).b(new U(context.getApplicationContext(), 7, true));
                    }
                }
            }
        }
    }
}
