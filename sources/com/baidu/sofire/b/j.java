package com.baidu.sofire.b;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.message.push.IAchPluginInvoker;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.d.b;
import com.baidu.sofire.m.c;
import com.baidu.sofire.m.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PluginloaderHub */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static j f3090g;

    /* renamed from: h  reason: collision with root package name */
    public static Application f3091h;

    /* renamed from: i  reason: collision with root package name */
    public static List<Integer> f3092i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public static List<Integer> f3093j = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public String f3094a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3095b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ApkInfo> f3096c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ApkInfo> f3097d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, ApkInfo> f3098e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, MyReceiver> f3099f = new HashMap();

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (f3090g == null) {
                f3091h = (Application) context.getApplicationContext();
                f3090g = new j();
            }
            jVar = f3090g;
        }
        return jVar;
    }

    public synchronized void b(k kVar) {
        try {
            if (kVar.f3103d != null) {
                ApkInfo apkInfo = this.f3097d.get(kVar.f3100a);
                if (!(apkInfo == null || apkInfo.intentFilters == null)) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                        if (kVar.a(apkInfo.intentFilters.get(i2))) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        List<k> list = apkInfo.intentFilters;
                        if (list != null) {
                            list.remove(intValue);
                        }
                    }
                    List<k> list2 = apkInfo.intentFilters;
                    if (list2 != null && list2.size() == 0) {
                        apkInfo.intentFilters = null;
                    }
                }
                String a2 = a(kVar.f3103d);
                if (!TextUtils.isEmpty(a2)) {
                    for (ApkInfo next : b()) {
                        List<k> list3 = next.intentFilters;
                        if (list3 != null && list3.size() > 0) {
                            for (k kVar2 : next.intentFilters) {
                                String a3 = a(kVar2.f3103d);
                                if (!TextUtils.isEmpty(a3)) {
                                    if (a3.equals(a2)) {
                                        return;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    f3091h.unregisterReceiver(this.f3099f.get(a2));
                    this.f3099f.remove(a2);
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable th2) {
            int i3 = a.f3011a;
        }
        return;
    }

    public boolean c(String str) {
        ApkInfo apkInfo = this.f3096c.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f3096c.remove(str);
        this.f3097d.remove(apkInfo.packageName);
        this.f3098e.remove(Integer.valueOf(apkInfo.key));
        b.a(apkInfo.packageName);
        c.e(apkInfo.dataDir);
        Application application = f3091h;
        if (application == null) {
            return true;
        }
        c.e(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        return true;
    }

    public boolean d(String str) {
        ApkInfo apkInfo = this.f3097d.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f3096c.remove(apkInfo.pkgPath);
        this.f3097d.remove(str);
        this.f3098e.remove(Integer.valueOf(apkInfo.key));
        b.a(str);
        c.e(apkInfo.dataDir);
        Application application = f3091h;
        if (application == null) {
            return true;
        }
        c.e(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        return true;
    }

    public boolean e(String str) {
        try {
            ApkInfo apkInfo = this.f3097d.get(str);
            if (apkInfo == null) {
                return false;
            }
            Class<?> a2 = ((i) apkInfo.classLoader).a(c.c(apkInfo.es));
            Object invoke = a2.getDeclaredMethod(IAchPluginInvoker.INSTANCE_METHOD, new Class[]{Context.class}).invoke(a2, new Object[]{f3091h});
            if (invoke != null) {
                l.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
            }
            this.f3096c.remove(apkInfo.pkgPath);
            this.f3097d.remove(str);
            this.f3098e.remove(Integer.valueOf(apkInfo.key));
            return true;
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.baidu.sofire.b.k r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.IntentFilter r0 = r5.f3103d     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r4.f3097d     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r5.f3100a     // Catch:{ all -> 0x0089 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0089 }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x008c
            java.util.List<com.baidu.sofire.b.k> r1 = r0.intentFilters     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0089 }
            r1.<init>()     // Catch:{ all -> 0x0089 }
            r0.intentFilters = r1     // Catch:{ all -> 0x0089 }
        L_0x001e:
            r1 = 0
        L_0x001f:
            java.util.List<com.baidu.sofire.b.k> r2 = r0.intentFilters     // Catch:{ all -> 0x0089 }
            int r2 = r2.size()     // Catch:{ all -> 0x0089 }
            if (r1 >= r2) goto L_0x003a
            java.util.List<com.baidu.sofire.b.k> r2 = r0.intentFilters     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0089 }
            com.baidu.sofire.b.k r2 = (com.baidu.sofire.b.k) r2     // Catch:{ all -> 0x0089 }
            boolean r2 = r5.a(r2)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0037
            monitor-exit(r4)
            return
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x001f
        L_0x003a:
            java.util.List<com.baidu.sofire.b.k> r0 = r0.intentFilters     // Catch:{ all -> 0x0089 }
            r0.add(r5)     // Catch:{ all -> 0x0089 }
            android.content.IntentFilter r0 = r5.f3103d     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = a((android.content.IntentFilter) r0)     // Catch:{ all -> 0x0089 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0087
            java.lang.String r1 = "____"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0054
            goto L_0x0087
        L_0x0054:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r1 = r4.f3099f     // Catch:{ all -> 0x0089 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0089 }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x008c
            com.baidu.sofire.MyReceiver r1 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0089 }
            r1.<init>()     // Catch:{ all -> 0x0089 }
            android.app.Application r2 = f3091h     // Catch:{ all -> 0x0089 }
            android.content.IntentFilter r3 = r5.f3103d     // Catch:{ all -> 0x0089 }
            boolean r2 = com.baidu.sofire.m.c.a((android.content.Context) r2, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r3)     // Catch:{ all -> 0x0089 }
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0081
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0077 }
            goto L_0x007a
        L_0x0077:
            r2 = move-exception
            int r2 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x0089 }
        L_0x007a:
            android.app.Application r2 = f3091h     // Catch:{ all -> 0x0089 }
            android.content.IntentFilter r5 = r5.f3103d     // Catch:{ all -> 0x0089 }
            com.baidu.sofire.m.c.a((android.content.Context) r2, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r5)     // Catch:{ all -> 0x0089 }
        L_0x0081:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r5 = r4.f3099f     // Catch:{ all -> 0x0089 }
            r5.put(r0, r1)     // Catch:{ all -> 0x0089 }
            goto L_0x008c
        L_0x0087:
            monitor-exit(r4)
            return
        L_0x0089:
            r5 = move-exception
            int r5 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r4)
            return
        L_0x008e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.b.k):void");
    }

    public static String a(IntentFilter intentFilter) {
        if (intentFilter == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < countActions; i2++) {
                    String action = intentFilter.getAction(i2);
                    if (!TextUtils.isEmpty(action)) {
                        arrayList.add(action);
                    }
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < countCategories; i3++) {
                    try {
                        String category = intentFilter.getCategory(i3);
                        if (!TextUtils.isEmpty(category)) {
                            arrayList2.add(category);
                        }
                    } catch (Throwable th2) {
                        int i4 = a.f3011a;
                    }
                }
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        sb.append((String) it2.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            if (intentFilter.countDataTypes() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i5 = 0; i5 < countCategories; i5++) {
                    try {
                        String dataType = intentFilter.getDataType(i5);
                        if (!TextUtils.isEmpty(dataType)) {
                            arrayList3.add(dataType);
                        }
                    } catch (Throwable th3) {
                        int i6 = a.f3011a;
                    }
                }
                if (arrayList3.size() > 0) {
                    Collections.sort(arrayList3);
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        sb.append((String) it3.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countDataSchemes = intentFilter.countDataSchemes();
            if (countDataSchemes > 0) {
                ArrayList arrayList4 = new ArrayList();
                for (int i7 = 0; i7 < countDataSchemes; i7++) {
                    try {
                        String dataScheme = intentFilter.getDataScheme(i7);
                        if (!TextUtils.isEmpty(dataScheme)) {
                            arrayList4.add(dataScheme);
                        }
                    } catch (Throwable th4) {
                        int i8 = a.f3011a;
                    }
                }
                if (arrayList4.size() > 0) {
                    Collections.sort(arrayList4);
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        sb.append((String) it4.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            return sb.toString();
        } catch (Throwable th5) {
            return "";
        }
    }

    public List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f3097d.keySet()) {
                arrayList.add(this.f3097d.get(str));
            }
            return arrayList;
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return null;
        }
    }

    public Pair<Boolean, String> b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!c.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String a2 = l.a(file);
        if (TextUtils.isEmpty(a2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (!a2.equalsIgnoreCase(str)) {
            return new Pair<>(Boolean.FALSE, a2);
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    public ApkInfo b(String str) {
        try {
            return this.f3097d.get(str);
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return null;
        }
    }

    public boolean b(int i2) {
        List<Integer> list = f3092i;
        return list != null && list.contains(Integer.valueOf(i2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.baidu.sofire.core.ApkInfo r7, boolean r8) {
        /*
            r6 = this;
            java.lang.System.currentTimeMillis()
            r6.f3095b = r8
            java.lang.String r8 = r7.versionName
            r6.f3094a = r8
            monitor-enter(r6)
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x0308 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0308 }
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0016
            goto L_0x0305
        L_0x0016:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.f3096c     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x0308 }
            java.lang.Object r8 = r8.get(r2)     // Catch:{ all -> 0x0308 }
            com.baidu.sofire.core.ApkInfo r8 = (com.baidu.sofire.core.ApkInfo) r8     // Catch:{ all -> 0x0308 }
            if (r8 == 0) goto L_0x0033
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = r7.versionName     // Catch:{ all -> 0x0308 }
            boolean r8 = r8.equals(r2)     // Catch:{ all -> 0x0308 }
            if (r8 == 0) goto L_0x002e
            goto L_0x0267
        L_0x002e:
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x0308 }
            r6.c(r8)     // Catch:{ all -> 0x0308 }
        L_0x0033:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x0308 }
            r8.<init>(r2)     // Catch:{ all -> 0x0308 }
            boolean r8 = com.baidu.sofire.m.c.a((java.io.File) r8)     // Catch:{ all -> 0x0308 }
            if (r8 != 0) goto L_0x006f
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0308 }
            r8.<init>()     // Catch:{ all -> 0x0308 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = "0"
            r8.put(r2, r0)     // Catch:{ all -> 0x0308 }
            int r0 = r7.key     // Catch:{ all -> 0x0308 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = "1"
            r8.put(r2, r0)     // Catch:{ all -> 0x0308 }
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = "2"
            r8.put(r0, r7)     // Catch:{ all -> 0x0308 }
            android.app.Application r7 = f3091h     // Catch:{ all -> 0x0308 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = "1003117"
            com.baidu.sofire.m.c.a((android.content.Context) r7, (java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r8, (boolean) r1)     // Catch:{ all -> 0x0308 }
            monitor-exit(r6)
            r0 = r1
            goto L_0x0307
        L_0x006f:
            android.app.Application r8 = f3091h     // Catch:{ all -> 0x027c }
            r7.hostContext = r8     // Catch:{ all -> 0x027c }
            int r8 = r7.apkParseSuc     // Catch:{ all -> 0x027c }
            if (r8 != r0) goto L_0x0145
            java.lang.String r8 = r7.packageName     // Catch:{ all -> 0x013b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x013b }
            if (r8 != 0) goto L_0x0132
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x013b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x013b }
            if (r8 != 0) goto L_0x0132
            int r8 = r7.key     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r7.versionName     // Catch:{ all -> 0x013b }
            java.lang.String r3 = r7.apkMD5     // Catch:{ all -> 0x013b }
            java.lang.String r4 = r7.pkgPath     // Catch:{ all -> 0x013b }
            boolean r8 = r6.a(r8, r2, r3, r4)     // Catch:{ all -> 0x013b }
            if (r8 != 0) goto L_0x0097
            goto L_0x0305
        L_0x0097:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x013b }
            android.app.Application r2 = f3091h     // Catch:{ all -> 0x013b }
            java.io.File r2 = com.baidu.sofire.m.c.e((android.content.Context) r2)     // Catch:{ all -> 0x013b }
            java.lang.String r3 = "sofire_tmp"
            r8.<init>(r2, r3)     // Catch:{ all -> 0x013b }
            java.lang.String r8 = r8.getCanonicalPath()     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
            r2.<init>()     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch:{ all -> 0x013b }
            java.lang.String r2 = "/."
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x013b }
            int r2 = r7.key     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x013b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x013b }
            r7.dataDir = r8     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
            r8.<init>()     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r7.dataDir     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x013b }
            java.lang.String r2 = "/dex"
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x013b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
            r2.<init>()     // Catch:{ all -> 0x013b }
            java.lang.String r3 = r7.dataDir     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x013b }
            java.lang.String r3 = "/lib/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x013b }
            java.lang.String r3 = r6.f3094a     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x013b }
            java.lang.String r3 = com.baidu.sofire.m.w.a()     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
            r4.<init>()     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x013b }
            java.lang.String r4 = "/"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x013b }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x013b }
            a((java.lang.String) r8)     // Catch:{ all -> 0x013b }
            a((java.lang.String) r2)     // Catch:{ all -> 0x013b }
            r6.a((com.baidu.sofire.core.ApkInfo) r7, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x013b }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.f3096c     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x013b }
            r8.put(r2, r7)     // Catch:{ all -> 0x013b }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.f3097d     // Catch:{ all -> 0x013b }
            java.lang.String r2 = r7.packageName     // Catch:{ all -> 0x013b }
            r8.put(r2, r7)     // Catch:{ all -> 0x013b }
            java.util.Map<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r8 = r6.f3098e     // Catch:{ all -> 0x013b }
            int r2 = r7.key     // Catch:{ all -> 0x013b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013b }
            r8.put(r2, r7)     // Catch:{ all -> 0x013b }
            goto L_0x0145
        L_0x0132:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x013b }
            java.lang.String r2 = "packageName or pkgPath miss"
            r8.<init>(r2)     // Catch:{ all -> 0x013b }
            throw r8     // Catch:{ all -> 0x013b }
        L_0x013b:
            r8 = move-exception
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x027c }
            r6.c(r8)     // Catch:{ all -> 0x027c }
            int r8 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x027c }
            r8 = r0
            goto L_0x0146
        L_0x0145:
            r8 = r1
        L_0x0146:
            int r2 = r7.apkParseSuc     // Catch:{ all -> 0x027c }
            if (r2 != r0) goto L_0x014c
            if (r8 == 0) goto L_0x0267
        L_0x014c:
            android.content.pm.PackageInfo r8 = r7.cloudPkgInfo     // Catch:{ all -> 0x027c }
            if (r8 == 0) goto L_0x0161
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x0161
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x0161
            goto L_0x0199
        L_0x0161:
            android.app.Application r8 = f3091h     // Catch:{ all -> 0x027c }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x027c }
            android.content.pm.PackageInfo r8 = r8.getPackageArchiveInfo(r2, r0)     // Catch:{ all -> 0x027c }
            if (r8 == 0) goto L_0x017f
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x017f
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 == 0) goto L_0x0199
        L_0x017f:
            java.lang.String r8 = r7.packageName     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r7.apkMD5     // Catch:{ all -> 0x027c }
            android.content.pm.PackageInfo r8 = r6.a((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ all -> 0x027c }
            if (r8 == 0) goto L_0x0273
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x0273
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x0273
        L_0x0199:
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x026a
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            java.lang.String r3 = "com.baidu.sofire"
            boolean r2 = r2.startsWith(r3)     // Catch:{ all -> 0x027c }
            if (r2 == 0) goto L_0x026a
            int r2 = r7.key     // Catch:{ all -> 0x027c }
            java.lang.String r3 = r8.versionName     // Catch:{ all -> 0x027c }
            java.lang.String r4 = r7.apkMD5     // Catch:{ all -> 0x027c }
            java.lang.String r5 = r7.pkgPath     // Catch:{ all -> 0x027c }
            boolean r2 = r6.a(r2, r3, r4, r5)     // Catch:{ all -> 0x027c }
            if (r2 != 0) goto L_0x01bb
            goto L_0x0305
        L_0x01bb:
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x027c }
            r7.packageName = r2     // Catch:{ all -> 0x027c }
            android.content.pm.ApplicationInfo r2 = r8.applicationInfo     // Catch:{ all -> 0x027c }
            java.lang.String r3 = r2.className     // Catch:{ all -> 0x027c }
            r7.className = r3     // Catch:{ all -> 0x027c }
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x027c }
            r7.versionName = r8     // Catch:{ all -> 0x027c }
            int r8 = r2.theme     // Catch:{ all -> 0x027c }
            r7.applicationTheme = r8     // Catch:{ all -> 0x027c }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x027c }
            android.app.Application r2 = f3091h     // Catch:{ all -> 0x027c }
            java.io.File r2 = com.baidu.sofire.m.c.e((android.content.Context) r2)     // Catch:{ all -> 0x027c }
            java.lang.String r3 = "sofire_tmp"
            r8.<init>(r2, r3)     // Catch:{ all -> 0x027c }
            java.lang.String r8 = r8.getCanonicalPath()     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            r2.<init>()     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch:{ all -> 0x027c }
            java.lang.String r2 = "/."
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x027c }
            int r2 = r7.key     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x027c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x027c }
            r7.dataDir = r8     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            r8.<init>()     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r7.dataDir     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x027c }
            java.lang.String r2 = "/dex"
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x027c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            r2.<init>()     // Catch:{ all -> 0x027c }
            java.lang.String r3 = r7.dataDir     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x027c }
            java.lang.String r3 = "/lib/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x027c }
            java.lang.String r3 = r6.f3094a     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x027c }
            java.lang.String r3 = com.baidu.sofire.m.w.a()     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            r4.<init>()     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x027c }
            java.lang.String r4 = "/"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x027c }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x027c }
            a((java.lang.String) r8)     // Catch:{ all -> 0x027c }
            a((java.lang.String) r2)     // Catch:{ all -> 0x027c }
            r6.a((com.baidu.sofire.core.ApkInfo) r7, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x027c }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.f3096c     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x027c }
            r8.put(r2, r7)     // Catch:{ all -> 0x027c }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.f3097d     // Catch:{ all -> 0x027c }
            java.lang.String r2 = r7.packageName     // Catch:{ all -> 0x027c }
            r8.put(r2, r7)     // Catch:{ all -> 0x027c }
            java.util.Map<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r8 = r6.f3098e     // Catch:{ all -> 0x027c }
            int r2 = r7.key     // Catch:{ all -> 0x027c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x027c }
            r8.put(r2, r7)     // Catch:{ all -> 0x027c }
        L_0x0267:
            monitor-exit(r6)
            goto L_0x0307
        L_0x026a:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x027c }
            java.lang.String r0 = "package name check failed"
            r8.<init>(r0)     // Catch:{ all -> 0x027c }
            throw r8     // Catch:{ all -> 0x027c }
        L_0x0273:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x027c }
            java.lang.String r0 = "requestCloudPackageInfo failed"
            r8.<init>(r0)     // Catch:{ all -> 0x027c }
            throw r8     // Catch:{ all -> 0x027c }
        L_0x027c:
            r8 = move-exception
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x0302 }
            r6.c(r0)     // Catch:{ all -> 0x0302 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0302 }
            r0.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.String r8 = com.baidu.sofire.a.a.a(r8)     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0302 }
            r2.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "\r\n isUpgrade="
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x0302 }
            boolean r2 = r6.f3095b     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ all -> 0x0302 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "space left"
            boolean r2 = r8.contains(r2)     // Catch:{ all -> 0x0302 }
            if (r2 == 0) goto L_0x02b5
            android.app.Application r2 = f3091h     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = r7.packageName     // Catch:{ all -> 0x0302 }
            java.lang.String r8 = com.baidu.sofire.m.h.a(r2, r8, r3)     // Catch:{ all -> 0x0302 }
        L_0x02b5:
            java.lang.String r2 = "0"
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0302 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "1"
            int r3 = r7.key     // Catch:{ all -> 0x0302 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0302 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "2"
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x0302 }
            r0.put(r2, r7)     // Catch:{ all -> 0x0302 }
            java.lang.String r7 = "3"
            byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x0302 }
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r1)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "\t"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "\r"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x0302 }
            r0.put(r7, r8)     // Catch:{ all -> 0x0302 }
            android.app.Application r7 = f3091h     // Catch:{ all -> 0x0302 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x0302 }
            java.lang.String r8 = "1003117"
            com.baidu.sofire.m.c.a((android.content.Context) r7, (java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x0302 }
            goto L_0x0305
        L_0x0302:
            r7 = move-exception
            int r7 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x0308 }
        L_0x0305:
            monitor-exit(r6)
            r0 = r1
        L_0x0307:
            return r0
        L_0x0308:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, boolean):boolean");
    }

    public final PackageInfo a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", str);
            jSONObject.put(Config.MODEL, str2);
            jSONArray.put(jSONObject);
            JSONArray jSONArray2 = new JSONArray(l.a(f3091h, c.b() + "p/1/pdl", jSONArray.toString(), false, true));
            if (jSONArray2.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray2.optJSONObject(0);
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = optJSONObject.optString("p");
            packageInfo.versionName = optJSONObject.optString("v");
            ApplicationInfo applicationInfo = new ApplicationInfo();
            String optString = optJSONObject.optString("n");
            applicationInfo.className = optString;
            if (!TextUtils.isEmpty(optString)) {
                if (applicationInfo.className.startsWith(".")) {
                    applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                }
            }
            applicationInfo.theme = optJSONObject.optInt("t");
            packageInfo.applicationInfo = applicationInfo;
            JSONArray optJSONArray = optJSONObject.optJSONArray("a");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        String optString2 = jSONObject2.optString("n");
                        activityInfo.name = optString2;
                        if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                            activityInfo.name = packageInfo.packageName + activityInfo.name;
                        }
                        activityInfo.packageName = packageInfo.packageName;
                        activityInfo.theme = jSONObject2.optInt("t");
                        activityInfo.labelRes = jSONObject2.optInt("l");
                        if (!TextUtils.isEmpty(activityInfo.name)) {
                            arrayList.add(activityInfo);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
            return packageInfo;
        } catch (Throwable th2) {
            int i3 = a.f3011a;
            return null;
        }
    }

    public final boolean a(int i2, String str, String str2, String str3) {
        String str4 = i2 + str;
        Map<String, String> map = a.x;
        if (map != null) {
            String str5 = map.get(str4);
            if (!TextUtils.isEmpty(str5)) {
                str2 = str5;
            }
        }
        Pair<Boolean, String> b2 = b(str2, str3);
        if (((Boolean) b2.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", 3);
        hashMap.put("1", Integer.valueOf(i2));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) b2.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
        c.a(f3091h.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[Catch:{ all -> 0x00fa, all -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f4 A[Catch:{ all -> 0x00fa, all -> 0x016f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.baidu.sofire.core.ApkInfo r19, java.lang.String r20, java.lang.String r21) throws java.lang.Throwable {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            java.lang.String r5 = "class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null"
            java.lang.String r6 = "apkDex"
            r0 = 1
            java.lang.String r0 = r1.a((com.baidu.sofire.core.ApkInfo) r2, (java.lang.String) r3, (boolean) r0)
            java.lang.String r7 = "java.library.path"
            java.lang.String r7 = java.lang.System.getProperty(r7)
            int r8 = android.os.Build.VERSION.SDK_INT
            java.lang.String r9 = ""
            r10 = 25
            if (r8 >= r10) goto L_0x0026
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 == 0) goto L_0x0027
        L_0x0026:
            r7 = r9
        L_0x0027:
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            if (r10 != 0) goto L_0x004d
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 != 0) goto L_0x004b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r0 = r10.append(r0)
            java.lang.String r10 = ":"
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            r7 = r0
        L_0x004d:
            r2.libPath = r7
            java.lang.Class<com.baidu.sofire.b.j> r0 = com.baidu.sofire.b.j.class
            java.lang.ClassLoader r10 = r0.getClassLoader()
            r11 = 34
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00fa }
            r0.<init>(r4, r6)     // Catch:{ all -> 0x00fa }
            java.lang.String r12 = r0.getAbsolutePath()     // Catch:{ all -> 0x00fa }
            com.baidu.sofire.m.c.e((java.lang.String) r12)     // Catch:{ all -> 0x00fa }
            java.io.File r13 = new java.io.File     // Catch:{ all -> 0x00fa }
            java.lang.String r14 = r2.pkgPath     // Catch:{ all -> 0x00fa }
            r13.<init>(r14)     // Catch:{ all -> 0x00fa }
            if (r8 < r11) goto L_0x0081
            boolean r14 = r13.exists()     // Catch:{ all -> 0x00fa }
            if (r14 == 0) goto L_0x0081
            boolean r14 = r13.isFile()     // Catch:{ all -> 0x00fa }
            if (r14 == 0) goto L_0x0081
            boolean r14 = r13.canWrite()     // Catch:{ all -> 0x00fa }
            if (r14 == 0) goto L_0x0081
            r13.setReadOnly()     // Catch:{ all -> 0x00fa }
        L_0x0081:
            a((java.lang.String) r12)     // Catch:{ all -> 0x00fa }
            r14 = 21
            if (r8 == r14) goto L_0x008f
            r14 = 22
            if (r8 != r14) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r0 = r12
            goto L_0x00d4
        L_0x008f:
            long r14 = r0.getFreeSpace()     // Catch:{ all -> 0x00fa }
            boolean r0 = r13.exists()     // Catch:{ all -> 0x00fa }
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r13.isFile()     // Catch:{ all -> 0x00fa }
            if (r0 == 0) goto L_0x00d3
            r0 = r12
            long r11 = r13.length()     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r13.<init>()     // Catch:{ all -> 0x00fa }
            java.lang.String r8 = "V5 freeSpace="
            java.lang.StringBuilder r8 = r13.append(r8)     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r8 = r8.append(r14)     // Catch:{ all -> 0x00fa }
            java.lang.String r13 = ",fileSize="
            java.lang.StringBuilder r8 = r8.append(r13)     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ all -> 0x00fa }
            r8.toString()     // Catch:{ all -> 0x00fa }
            int r8 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x00fa }
            r16 = 2
            long r11 = r11 * r16
            int r8 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x00cb
            goto L_0x00d4
        L_0x00cb:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x00fa }
            java.lang.String r8 = "Have no space to load plugin."
            r0.<init>(r8)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x00d3:
            r0 = r12
        L_0x00d4:
            com.baidu.sofire.b.i r8 = new com.baidu.sofire.b.i     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r2.pkgPath     // Catch:{ all -> 0x00fa }
            r8.<init>(r11, r0, r7, r10)     // Catch:{ all -> 0x00fa }
            r2.classLoader = r8     // Catch:{ all -> 0x00fa }
            java.lang.String r0 = r2.es     // Catch:{ all -> 0x00fa }
            java.lang.String r0 = com.baidu.sofire.m.c.c((java.lang.String) r0)     // Catch:{ all -> 0x00fa }
            java.lang.Class r0 = r8.loadClass(r0)     // Catch:{ all -> 0x00fa }
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00fa }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00fa }
            if (r0 != 0) goto L_0x00f4
            goto L_0x0168
        L_0x00f4:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x00fa }
            r0.<init>(r5)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x00fa:
            r0 = move-exception
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x016f }
            r0.<init>(r4, r6)     // Catch:{ all -> 0x016f }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x016f }
            com.baidu.sofire.m.c.e((java.lang.String) r0)     // Catch:{ all -> 0x016f }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x016f }
            java.lang.String r6 = "dexDex"
            r0.<init>(r4, r6)     // Catch:{ all -> 0x016f }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x016f }
            com.baidu.sofire.m.c.e((java.lang.String) r0)     // Catch:{ all -> 0x016f }
            a((java.lang.String) r0)     // Catch:{ all -> 0x016f }
            r4 = 0
            java.lang.String r9 = r1.a((com.baidu.sofire.core.ApkInfo) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ all -> 0x016f }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x016f }
            r1.<init>(r9)     // Catch:{ all -> 0x016f }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x016f }
            r4 = 34
            if (r3 < r4) goto L_0x013d
            boolean r3 = r1.exists()     // Catch:{ all -> 0x016f }
            if (r3 == 0) goto L_0x013d
            boolean r3 = r1.isFile()     // Catch:{ all -> 0x016f }
            if (r3 == 0) goto L_0x013d
            boolean r3 = r1.canWrite()     // Catch:{ all -> 0x016f }
            if (r3 == 0) goto L_0x013d
            r1.setReadOnly()     // Catch:{ all -> 0x016f }
        L_0x013d:
            com.baidu.sofire.b.i r1 = new com.baidu.sofire.b.i     // Catch:{ all -> 0x016f }
            r1.<init>(r9, r0, r7, r10)     // Catch:{ all -> 0x016f }
            r2.classLoader = r1     // Catch:{ all -> 0x016f }
            java.lang.String r0 = r2.es     // Catch:{ all -> 0x016f }
            java.lang.String r0 = com.baidu.sofire.m.c.c((java.lang.String) r0)     // Catch:{ all -> 0x016f }
            java.lang.Class r0 = r1.loadClass(r0)     // Catch:{ all -> 0x016f }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x016f }
            r1.<init>(r9)     // Catch:{ all -> 0x016f }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x016f }
            if (r3 == 0) goto L_0x015c
            r1.delete()     // Catch:{ all -> 0x016f }
        L_0x015c:
            if (r0 == 0) goto L_0x0169
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x016f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x016f }
            if (r0 != 0) goto L_0x0169
        L_0x0168:
            return
        L_0x0169:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x016f }
            r0.<init>(r5)     // Catch:{ all -> 0x016f }
            throw r0     // Catch:{ all -> 0x016f }
        L_0x016f:
            r0 = move-exception
            java.lang.String r0 = r2.dataDir     // Catch:{ all -> 0x0187 }
            com.baidu.sofire.m.c.e((java.lang.String) r0)     // Catch:{ all -> 0x0187 }
            android.app.Application r0 = f3091h     // Catch:{ all -> 0x0187 }
            if (r0 == 0) goto L_0x018a
            java.lang.String r1 = r2.packageName     // Catch:{ all -> 0x0187 }
            java.io.File r0 = r0.getFileStreamPath(r1)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0187 }
            com.baidu.sofire.m.c.e((java.lang.String) r0)     // Catch:{ all -> 0x0187 }
            goto L_0x018a
        L_0x0187:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x018a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "can't load EngineImpl by both dexFile:"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r3 = " and ZipFile:"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r2 = r2.pkgPath
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.lang.String):void");
    }

    public ApkInfo a(int i2) {
        try {
            return this.f3098e.get(Integer.valueOf(i2));
        } catch (Throwable th2) {
            int i3 = a.f3011a;
            return null;
        }
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0230, code lost:
        r20 = r4;
        r18 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0234, code lost:
        r19 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x023b, code lost:
        r20 = r4;
        r18 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x023f, code lost:
        r19 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0245, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0246, code lost:
        r1 = r0;
        r14 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x024b, code lost:
        r20 = r4;
        r18 = r9;
        r15 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0254, code lost:
        r20 = r4;
        r18 = r9;
        r15 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02dd, code lost:
        r1 = r0;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02df, code lost:
        if (r14 != null) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02e6, code lost:
        r0 = com.baidu.sofire.a.a.f3011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0120, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0125, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[ExcHandler: all (r0v85 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:18:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0245 A[ExcHandler: all (r0v34 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:28:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e1 A[SYNTHETIC, Splitter:B:154:0x02e1] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ee A[SYNTHETIC, Splitter:B:161:0x02ee] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02f7 A[Catch:{ all -> 0x02fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03cb A[SYNTHETIC, Splitter:B:217:0x03cb] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x04cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0187 A[SYNTHETIC, Splitter:B:93:0x0187] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.baidu.sofire.core.ApkInfo r22, java.lang.String r23, boolean r24) throws java.lang.Throwable {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "lib/"
            java.lang.String r5 = ".."
            java.lang.String r6 = ".dex"
            java.lang.String r7 = ".so"
            java.lang.String r8 = "/"
            java.lang.String r9 = ""
            if (r2 != 0) goto L_0x0016
            return r9
        L_0x0016:
            java.lang.String r11 = "."
            if (r24 == 0) goto L_0x002a
            java.lang.String r0 = r2.versionName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = r2.versionName
            java.lang.String r0 = r0.replace(r11, r9)
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r9
        L_0x002b:
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ FileNotFoundException -> 0x0046 }
            java.lang.String r10 = r2.pkgPath     // Catch:{ FileNotFoundException -> 0x0046 }
            r0.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0046 }
            r10 = r0
            goto L_0x00a8
        L_0x0035:
            r0 = move-exception
            goto L_0x02dd
        L_0x0038:
            r0 = move-exception
            r20 = r4
            r18 = r9
            goto L_0x02e9
        L_0x003f:
            r0 = move-exception
            r20 = r4
            r18 = r9
            goto L_0x02f2
        L_0x0046:
            r0 = move-exception
            java.lang.String r10 = r0.getMessage()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.String r14 = r2.pkgPath     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            r0.<init>(r14)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.io.File r0 = r0.getParentFile()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            boolean r14 = r0.exists()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            if (r14 == 0) goto L_0x02bc
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            r15.<init>()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            int r13 = r2.key     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.StringBuilder r13 = r15.append(r13)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.StringBuilder r13 = r13.append(r11)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.String r15 = r2.versionName     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.String r15 = ".b"
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.String r13 = r13.toString()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            r14.<init>(r0, r13)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            boolean r0 = r14.exists()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            if (r0 == 0) goto L_0x029f
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            java.lang.String r13 = r2.pkgPath     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            r0.<init>(r13)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            com.baidu.sofire.b.l.a((java.io.File) r14, (java.io.File) r0)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            com.baidu.sofire.a.b.a(r0)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            android.content.Context r13 = r2.hostContext     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            int r15 = r2.key     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            com.baidu.sofire.a.b.a(r13, r15, r0, r14)     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            boolean r0 = r0.exists()     // Catch:{ ZipException -> 0x003f, EOFException -> 0x0038, all -> 0x0035 }
            if (r0 == 0) goto L_0x0282
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ all -> 0x025c }
            java.lang.String r13 = r2.pkgPath     // Catch:{ all -> 0x025c }
            r0.<init>(r13)     // Catch:{ all -> 0x025c }
            r10 = r0
        L_0x00a8:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ ZipException -> 0x0253, EOFException -> 0x024a, all -> 0x0245 }
            r13.<init>()     // Catch:{ ZipException -> 0x0253, EOFException -> 0x024a, all -> 0x0245 }
            java.util.Enumeration r14 = r10.entries()     // Catch:{ ZipException -> 0x0253, EOFException -> 0x024a, all -> 0x0245 }
            r15 = r9
        L_0x00b2:
            boolean r0 = r14.hasMoreElements()     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            if (r0 == 0) goto L_0x019b
            java.lang.Object r0 = r14.nextElement()     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            r17 = r14
            java.lang.String r14 = r0.getName()     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            boolean r18 = r14.contains(r5)     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            if (r18 == 0) goto L_0x00d2
            r10.close()     // Catch:{ all -> 0x00ce }
            goto L_0x00d1
        L_0x00ce:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x00d1:
            return r9
        L_0x00d2:
            boolean r18 = android.text.TextUtils.isEmpty(r14)     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            if (r18 != 0) goto L_0x0129
            boolean r18 = r14.startsWith(r4)     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            if (r18 == 0) goto L_0x0129
            boolean r18 = r0.isDirectory()     // Catch:{ ZipException -> 0x023a, EOFException -> 0x022f, all -> 0x0245 }
            if (r18 != 0) goto L_0x0129
            if (r24 == 0) goto L_0x0129
            r18 = r9
            java.lang.String[] r9 = r14.split(r8)     // Catch:{ ZipException -> 0x0124, EOFException -> 0x011f, all -> 0x0245 }
            r19 = r15
            int r15 = r9.length     // Catch:{ ZipException -> 0x011a, EOFException -> 0x0115, all -> 0x0245 }
            r20 = r4
            r4 = 3
            if (r15 == r4) goto L_0x00f6
            goto L_0x0191
        L_0x00f6:
            r4 = 1
            r9 = r9[r4]     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r4 == 0) goto L_0x0101
            goto L_0x0191
        L_0x0101:
            java.lang.Object r4 = r13.get(r9)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r4 != 0) goto L_0x0111
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r4.<init>()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r13.put(r9, r4)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
        L_0x0111:
            r4.add(r0)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            goto L_0x012f
        L_0x0115:
            r0 = move-exception
            r20 = r4
            goto L_0x0236
        L_0x011a:
            r0 = move-exception
            r20 = r4
            goto L_0x0241
        L_0x011f:
            r0 = move-exception
            r20 = r4
            goto L_0x0234
        L_0x0124:
            r0 = move-exception
            r20 = r4
            goto L_0x023f
        L_0x0129:
            r20 = r4
            r18 = r9
            r19 = r15
        L_0x012f:
            boolean r4 = r14.endsWith(r6)     // Catch:{ all -> 0x0183 }
            if (r4 == 0) goto L_0x0191
            boolean r4 = r0.isDirectory()     // Catch:{ all -> 0x0183 }
            if (r4 != 0) goto L_0x0191
            if (r24 != 0) goto L_0x0191
            java.lang.String r4 = r2.dataDir     // Catch:{ all -> 0x0183 }
            a((java.lang.String) r4)     // Catch:{ all -> 0x0183 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0183 }
            r14.<init>()     // Catch:{ all -> 0x0183 }
            int r15 = r2.key     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r14 = r14.append(r11)     // Catch:{ all -> 0x0183 }
            java.lang.String r15 = r2.versionName     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r14 = r14.append(r6)     // Catch:{ all -> 0x0183 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0183 }
            r9.<init>(r4, r14)     // Catch:{ all -> 0x0183 }
            boolean r0 = r1.a((java.util.zip.ZipFile) r10, (java.util.zip.ZipEntry) r0, (java.io.File) r9)     // Catch:{ all -> 0x0181 }
            if (r0 == 0) goto L_0x0177
            java.lang.String r15 = r9.getAbsolutePath()     // Catch:{ all -> 0x0181 }
            r14 = r17
            r9 = r18
            r4 = r20
            goto L_0x00b2
        L_0x0177:
            boolean r0 = r9.exists()     // Catch:{ all -> 0x0181 }
            if (r0 == 0) goto L_0x0191
            r9.delete()     // Catch:{ all -> 0x0181 }
            goto L_0x0190
        L_0x0181:
            r0 = move-exception
            goto L_0x0185
        L_0x0183:
            r0 = move-exception
            r9 = 0
        L_0x0185:
            if (r9 == 0) goto L_0x0190
            boolean r0 = r9.exists()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r0 == 0) goto L_0x0191
            r9.delete()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
        L_0x0190:
        L_0x0191:
            r14 = r17
            r9 = r18
            r15 = r19
            r4 = r20
            goto L_0x00b2
        L_0x019b:
            r20 = r4
            r18 = r9
            r19 = r15
            if (r24 == 0) goto L_0x0223
            int r0 = r13.size()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r0 <= 0) goto L_0x0223
            java.util.Set r0 = r13.keySet()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            android.content.Context r4 = r2.hostContext     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r0 = com.baidu.sofire.m.a.a(r4, r0)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r4 != 0) goto L_0x0223
            java.io.File r4 = new java.io.File     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r4.<init>(r3, r0)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r9 = r4.getAbsolutePath()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            a((java.lang.String) r9)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.Object r0 = r13.get(r0)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r0 == 0) goto L_0x021a
            int r9 = r0.size()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r9 <= 0) goto L_0x021a
            java.util.Iterator r0 = r0.iterator()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
        L_0x01d7:
            boolean r9 = r0.hasNext()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r9 == 0) goto L_0x021a
            java.lang.Object r9 = r0.next()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.util.zip.ZipEntry r9 = (java.util.zip.ZipEntry) r9     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r13 = r9.getName()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            int r14 = r13.lastIndexOf(r8)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r15 = 1
            int r14 = r14 + r15
            java.lang.String r13 = r13.substring(r14)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r14.<init>()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.StringBuilder r14 = r14.append(r12)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.StringBuilder r14 = r14.append(r7)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r14 = r14.toString()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r13 = r13.replace(r7, r14)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            r14.<init>(r4, r13)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            boolean r9 = r1.a((java.util.zip.ZipFile) r10, (java.util.zip.ZipEntry) r9, (java.io.File) r14)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            if (r9 == 0) goto L_0x0212
            goto L_0x01d7
        L_0x0212:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            java.lang.String r4 = "UnZip so failed.Report space left."
            r0.<init>(r4)     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            throw r0     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
        L_0x021a:
            java.lang.String r15 = r4.getAbsolutePath()     // Catch:{ ZipException -> 0x0221, EOFException -> 0x021f, all -> 0x0245 }
            goto L_0x0225
        L_0x021f:
            r0 = move-exception
            goto L_0x0236
        L_0x0221:
            r0 = move-exception
            goto L_0x0241
        L_0x0223:
            r15 = r19
        L_0x0225:
            r10.close()     // Catch:{ all -> 0x022b }
            r10 = 0
            goto L_0x0301
        L_0x022b:
            r0 = move-exception
            r10 = 0
            goto L_0x02fd
        L_0x022f:
            r0 = move-exception
            r20 = r4
            r18 = r9
        L_0x0234:
            r19 = r15
        L_0x0236:
            r15 = r19
            goto L_0x02ec
        L_0x023a:
            r0 = move-exception
            r20 = r4
            r18 = r9
        L_0x023f:
            r19 = r15
        L_0x0241:
            r15 = r19
            goto L_0x02f5
        L_0x0245:
            r0 = move-exception
            r1 = r0
            r14 = r10
            goto L_0x02df
        L_0x024a:
            r0 = move-exception
            r20 = r4
            r18 = r9
            r15 = r18
            goto L_0x02ec
        L_0x0253:
            r0 = move-exception
            r20 = r4
            r18 = r9
            r15 = r18
            goto L_0x02f5
        L_0x025c:
            r0 = move-exception
            r20 = r4
            r18 = r9
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r9.<init>()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r10 = "--"
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r0 = r9.append(r0)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            throw r4     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
        L_0x0282:
            r20 = r4
            r18 = r9
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r4.<init>()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r9 = "--file not exists after copy"
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r4 = r4.toString()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r0.<init>(r4)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            throw r0     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
        L_0x029f:
            r20 = r4
            r18 = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r0.<init>()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r4 = "--backupFile not exists"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            throw r4     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
        L_0x02bc:
            r20 = r4
            r18 = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r0.<init>()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r4 = "--backupDir not exists"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
            throw r4     // Catch:{ ZipException -> 0x02db, EOFException -> 0x02d9, all -> 0x0035 }
        L_0x02d9:
            r0 = move-exception
            goto L_0x02e9
        L_0x02db:
            r0 = move-exception
            goto L_0x02f2
        L_0x02dd:
            r1 = r0
            r14 = 0
        L_0x02df:
            if (r14 == 0) goto L_0x02e8
            r14.close()     // Catch:{ all -> 0x02e5 }
            goto L_0x02e8
        L_0x02e5:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x02e8:
            throw r1
        L_0x02e9:
            r15 = r18
            r10 = 0
        L_0x02ec:
            if (r10 == 0) goto L_0x0300
            r10.close()     // Catch:{ all -> 0x02fb }
            goto L_0x0300
        L_0x02f2:
            r15 = r18
            r10 = 0
        L_0x02f5:
            if (r10 == 0) goto L_0x0300
            r10.close()     // Catch:{ all -> 0x02fb }
            goto L_0x0300
        L_0x02fb:
            r0 = move-exception
            r10 = 1
        L_0x02fd:
            int r0 = com.baidu.sofire.a.a.f3011a
            goto L_0x0301
        L_0x0300:
            r10 = 1
        L_0x0301:
            if (r10 == 0) goto L_0x04cf
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.zip.ZipInputStream r9 = new java.util.zip.ZipInputStream
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.lang.String r10 = r2.pkgPath
            r0.<init>(r10)
            r9.<init>(r0)
            r10 = r18
        L_0x0316:
            java.util.zip.ZipEntry r0 = r9.getNextEntry()     // Catch:{ all -> 0x04c5 }
            if (r0 == 0) goto L_0x03e0
            java.lang.String r13 = r0.getName()     // Catch:{ all -> 0x04c5 }
            boolean r14 = r13.contains(r5)     // Catch:{ all -> 0x04c5 }
            if (r14 == 0) goto L_0x0330
            r9.close()     // Catch:{ all -> 0x032b }
            goto L_0x0430
        L_0x032b:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
            goto L_0x0430
        L_0x0330:
            r14 = r20
            boolean r15 = r13.startsWith(r14)     // Catch:{ all -> 0x04c5 }
            if (r15 == 0) goto L_0x036f
            boolean r15 = r0.isDirectory()     // Catch:{ all -> 0x04c5 }
            if (r15 != 0) goto L_0x036f
            if (r24 == 0) goto L_0x036f
            java.lang.String[] r15 = r13.split(r8)     // Catch:{ all -> 0x04c5 }
            r16 = r10
            int r10 = r15.length     // Catch:{ all -> 0x04c5 }
            r17 = r12
            r12 = 3
            if (r10 == r12) goto L_0x0351
            r9.closeEntry()     // Catch:{ all -> 0x04c5 }
            goto L_0x035e
        L_0x0351:
            r10 = 1
            r12 = r15[r10]     // Catch:{ all -> 0x04c5 }
            boolean r10 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x04c5 }
            if (r10 == 0) goto L_0x0365
            r9.closeEntry()     // Catch:{ all -> 0x04c5 }
        L_0x035e:
            r20 = r14
            r10 = r16
            r12 = r17
            goto L_0x0316
        L_0x0365:
            boolean r10 = r4.contains(r12)     // Catch:{ all -> 0x04c5 }
            if (r10 != 0) goto L_0x0373
            r4.add(r12)     // Catch:{ all -> 0x04c5 }
            goto L_0x0373
        L_0x036f:
            r16 = r10
            r17 = r12
        L_0x0373:
            boolean r10 = r13.endsWith(r6)     // Catch:{ all -> 0x03c7 }
            if (r10 == 0) goto L_0x03d5
            boolean r0 = r0.isDirectory()     // Catch:{ all -> 0x03c7 }
            if (r0 != 0) goto L_0x03d5
            if (r24 != 0) goto L_0x03d5
            java.lang.String r0 = r2.dataDir     // Catch:{ all -> 0x03c7 }
            a((java.lang.String) r0)     // Catch:{ all -> 0x03c7 }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x03c7 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c7 }
            r12.<init>()     // Catch:{ all -> 0x03c7 }
            int r13 = r2.key     // Catch:{ all -> 0x03c7 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x03c7 }
            java.lang.StringBuilder r12 = r12.append(r11)     // Catch:{ all -> 0x03c7 }
            java.lang.String r13 = r2.versionName     // Catch:{ all -> 0x03c7 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x03c7 }
            java.lang.StringBuilder r12 = r12.append(r6)     // Catch:{ all -> 0x03c7 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x03c7 }
            r10.<init>(r0, r12)     // Catch:{ all -> 0x03c7 }
            r10.delete()     // Catch:{ all -> 0x03c5 }
            r10.createNewFile()     // Catch:{ all -> 0x03c5 }
            boolean r0 = r1.a((java.io.File) r10, (java.util.zip.ZipInputStream) r9)     // Catch:{ all -> 0x03c5 }
            if (r0 == 0) goto L_0x03bb
            java.lang.String r0 = r10.getAbsolutePath()     // Catch:{ all -> 0x03c5 }
            r10 = r0
            goto L_0x03d7
        L_0x03bb:
            boolean r0 = r10.exists()     // Catch:{ all -> 0x03c5 }
            if (r0 == 0) goto L_0x03d5
            r10.delete()     // Catch:{ all -> 0x03c5 }
            goto L_0x03d4
        L_0x03c5:
            r0 = move-exception
            goto L_0x03c9
        L_0x03c7:
            r0 = move-exception
            r10 = 0
        L_0x03c9:
            if (r10 == 0) goto L_0x03d4
            boolean r0 = r10.exists()     // Catch:{ all -> 0x04c5 }
            if (r0 == 0) goto L_0x03d5
            r10.delete()     // Catch:{ all -> 0x04c5 }
        L_0x03d4:
        L_0x03d5:
            r10 = r16
        L_0x03d7:
            r9.closeEntry()     // Catch:{ all -> 0x04c5 }
            r20 = r14
            r12 = r17
            goto L_0x0316
        L_0x03e0:
            r16 = r10
            r17 = r12
            r14 = r20
            r9.close()     // Catch:{ all -> 0x03ea }
            goto L_0x03ed
        L_0x03ea:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x03ed:
            if (r24 == 0) goto L_0x04c2
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x04c2
            android.content.Context r0 = r2.hostContext
            java.lang.String r0 = com.baidu.sofire.m.a.a(r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x04c2
            java.io.File r4 = new java.io.File
            r4.<init>(r3, r0)
            java.lang.String r3 = r4.getAbsolutePath()
            a((java.lang.String) r3)
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream
            java.io.FileInputStream r6 = new java.io.FileInputStream
            java.lang.String r2 = r2.pkgPath
            r6.<init>(r2)
            r3.<init>(r6)
        L_0x0419:
            java.util.zip.ZipEntry r2 = r3.getNextEntry()     // Catch:{ all -> 0x04b8 }
            if (r2 == 0) goto L_0x04ac
            java.lang.String r6 = r2.getName()     // Catch:{ all -> 0x04b8 }
            boolean r9 = r6.contains(r5)     // Catch:{ all -> 0x04b8 }
            if (r9 == 0) goto L_0x0434
            r3.close()     // Catch:{ all -> 0x042d }
            goto L_0x0430
        L_0x042d:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x0430:
            r9 = r18
            goto L_0x04c4
        L_0x0434:
            boolean r9 = r6.startsWith(r14)     // Catch:{ all -> 0x04b8 }
            if (r9 == 0) goto L_0x04a1
            boolean r9 = r6.endsWith(r7)     // Catch:{ all -> 0x04b8 }
            if (r9 == 0) goto L_0x04a1
            boolean r2 = r2.isDirectory()     // Catch:{ all -> 0x04b8 }
            if (r2 != 0) goto L_0x049c
            java.lang.String[] r2 = r6.split(r8)     // Catch:{ all -> 0x04b8 }
            int r9 = r2.length     // Catch:{ all -> 0x04b8 }
            r10 = 3
            if (r9 == r10) goto L_0x0453
            r3.closeEntry()     // Catch:{ all -> 0x04b8 }
            goto L_0x0419
        L_0x0453:
            r9 = 1
            r2 = r2[r9]     // Catch:{ all -> 0x04b8 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x04b8 }
            if (r2 == 0) goto L_0x0498
            int r2 = r6.lastIndexOf(r8)     // Catch:{ all -> 0x04b8 }
            r9 = 1
            int r2 = r2 + r9
            java.lang.String r2 = r6.substring(r2)     // Catch:{ all -> 0x04b8 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b8 }
            r6.<init>()     // Catch:{ all -> 0x04b8 }
            r11 = r17
            java.lang.StringBuilder r6 = r6.append(r11)     // Catch:{ all -> 0x04b8 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x04b8 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x04b8 }
            java.lang.String r2 = r2.replace(r7, r6)     // Catch:{ all -> 0x04b8 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x04b8 }
            r6.<init>(r4, r2)     // Catch:{ all -> 0x04b8 }
            r6.delete()     // Catch:{ all -> 0x04b8 }
            r6.createNewFile()     // Catch:{ all -> 0x04b8 }
            boolean r2 = r1.a((java.io.File) r6, (java.util.zip.ZipInputStream) r3)     // Catch:{ all -> 0x04b8 }
            if (r2 == 0) goto L_0x0490
            goto L_0x04a5
        L_0x0490:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x04b8 }
            java.lang.String r1 = "Stream UnZip so failed.Report space left."
            r0.<init>(r1)     // Catch:{ all -> 0x04b8 }
            throw r0     // Catch:{ all -> 0x04b8 }
        L_0x0498:
            r11 = r17
            r9 = 1
            goto L_0x04a5
        L_0x049c:
            r11 = r17
            r9 = 1
            r10 = 3
            goto L_0x04a5
        L_0x04a1:
            r11 = r17
            r9 = 1
            r10 = 3
        L_0x04a5:
            r3.closeEntry()     // Catch:{ all -> 0x04b8 }
            r17 = r11
            goto L_0x0419
        L_0x04ac:
            java.lang.String r9 = r4.getAbsolutePath()     // Catch:{ all -> 0x04b8 }
            r3.close()     // Catch:{ all -> 0x04b4 }
            goto L_0x04c4
        L_0x04b4:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
            goto L_0x04c4
        L_0x04b8:
            r0 = move-exception
            r1 = r0
            r3.close()     // Catch:{ all -> 0x04be }
            goto L_0x04c1
        L_0x04be:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x04c1:
            throw r1
        L_0x04c2:
            r9 = r16
        L_0x04c4:
            return r9
        L_0x04c5:
            r0 = move-exception
            r1 = r0
            r9.close()     // Catch:{ all -> 0x04cb }
            goto L_0x04ce
        L_0x04cb:
            r0 = move-exception
            int r0 = com.baidu.sofire.a.a.f3011a
        L_0x04ce:
            throw r1
        L_0x04cf:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0037 A[SYNTHETIC, Splitter:B:30:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0040 A[SYNTHETIC, Splitter:B:35:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.zip.ZipFile r3, java.util.zip.ZipEntry r4, java.io.File r5) {
        /*
            r2 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x0031 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x002f }
            r4.<init>(r5)     // Catch:{ all -> 0x002f }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x002c }
        L_0x000f:
            int r1 = r3.read(r5)     // Catch:{ all -> 0x002c }
            if (r1 <= 0) goto L_0x0019
            r4.write(r5, r0, r1)     // Catch:{ all -> 0x002c }
            goto L_0x000f
        L_0x0019:
            r4.flush()     // Catch:{ all -> 0x002c }
            r5 = 1
            r3.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0024
        L_0x0021:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x0024:
            r4.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x002b:
            return r5
        L_0x002c:
            r5 = move-exception
            r1 = r4
            goto L_0x0033
        L_0x002f:
            r4 = move-exception
            goto L_0x0033
        L_0x0031:
            r3 = move-exception
            r3 = r1
        L_0x0033:
            int r4 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x003e
            r3.close()     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x003e:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0047
        L_0x0044:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x0047:
            return r0
        L_0x0048:
            r4 = move-exception
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ all -> 0x004f }
            goto L_0x0052
        L_0x004f:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x0052:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ all -> 0x0058 }
            goto L_0x005b
        L_0x0058:
            r3 = move-exception
            int r3 = com.baidu.sofire.a.a.f3011a
        L_0x005b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[SYNTHETIC, Splitter:B:22:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.File r4, java.util.zip.ZipInputStream r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0022 }
            r1.<init>(r4)     // Catch:{ all -> 0x0022 }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0020 }
        L_0x000a:
            int r2 = r5.read(r4)     // Catch:{ all -> 0x0020 }
            if (r2 <= 0) goto L_0x0014
            r1.write(r4, r0, r2)     // Catch:{ all -> 0x0020 }
            goto L_0x000a
        L_0x0014:
            r1.flush()     // Catch:{ all -> 0x0020 }
            r4 = 1
            r1.close()     // Catch:{ all -> 0x001c }
            goto L_0x001f
        L_0x001c:
            r5 = move-exception
            int r5 = com.baidu.sofire.a.a.f3011a
        L_0x001f:
            return r4
        L_0x0020:
            r4 = move-exception
            goto L_0x0024
        L_0x0022:
            r4 = move-exception
            r1 = 0
        L_0x0024:
            int r4 = com.baidu.sofire.a.a.f3011a     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x002c }
            goto L_0x002f
        L_0x002c:
            r4 = move-exception
            int r4 = com.baidu.sofire.a.a.f3011a
        L_0x002f:
            return r0
        L_0x0030:
            r4 = move-exception
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003a
        L_0x0037:
            r5 = move-exception
            int r5 = com.baidu.sofire.a.a.f3011a
        L_0x003a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(java.io.File, java.util.zip.ZipInputStream):boolean");
    }

    public synchronized void a(int i2, boolean z) {
        if (z) {
            List<Integer> list = f3092i;
            if (list != null && !list.contains(Integer.valueOf(i2))) {
                f3092i.add(Integer.valueOf(i2));
            }
        } else {
            List<Integer> list2 = f3092i;
            if (list2 != null && list2.contains(Integer.valueOf(i2))) {
                f3092i.remove(Integer.valueOf(i2));
            }
        }
    }

    public boolean a() {
        try {
            String a2 = a.a(new Throwable());
            for (ApkInfo next : b()) {
                if (TextUtils.isEmpty(next.es)) {
                    if (a2.contains("com.baidu.sofire.engine.EngineImpl")) {
                        return true;
                    }
                } else if (a2.contains(c.c(next.es))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return false;
        }
    }
}
