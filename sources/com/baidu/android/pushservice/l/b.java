package com.baidu.android.pushservice.l;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.n.d;
import com.baidu.android.pushservice.r.f;
import com.baidu.android.pushservice.util.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f8425d;

    /* renamed from: a  reason: collision with root package name */
    public Context f8426a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f8427b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, f> f8428c = new HashMap<>();

    public b(Context context) {
        this.f8426a = context.getApplicationContext();
        String h2 = d.h(context);
        if (!TextUtils.isEmpty(h2)) {
            try {
                ArrayList<e> e2 = e(Utility.c(h2));
                if (e2 != null) {
                    this.f8427b.addAll(e2);
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f8425d == null) {
                f8425d = new b(context);
            }
            bVar = f8425d;
        }
        return bVar;
    }

    public String a(e eVar, boolean z) {
        return a(eVar, z, this.f8427b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r7 == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r8.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002f A[EDGE_INSN: B:25:0x002f->B:14:0x002f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String a(com.baidu.android.pushservice.l.e r6, boolean r7, java.util.ArrayList<com.baidu.android.pushservice.l.e> r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.util.Iterator r1 = r8.iterator()     // Catch:{ all -> 0x0045 }
        L_0x0006:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0045 }
            com.baidu.android.pushservice.l.e r2 = (com.baidu.android.pushservice.l.e) r2     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = r2.f8423b     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r6.f8423b     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = r2.f8422a     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r6.f8422a     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0006
        L_0x0026:
            r8.remove(r2)     // Catch:{ all -> 0x0045 }
            if (r7 == 0) goto L_0x002e
            r8.add(r6)     // Catch:{ all -> 0x0045 }
        L_0x002e:
            r0 = 1
        L_0x002f:
            if (r0 != 0) goto L_0x0036
            if (r7 == 0) goto L_0x0036
            r8.add(r6)     // Catch:{ all -> 0x0045 }
        L_0x0036:
            java.lang.String r6 = r5.a((java.util.List<com.baidu.android.pushservice.l.e>) r8)     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = com.baidu.android.pushservice.util.Utility.d((java.lang.String) r6)     // Catch:{ all -> 0x0045 }
            android.content.Context r7 = r5.f8426a     // Catch:{ all -> 0x0045 }
            com.baidu.android.pushservice.n.d.h(r7, r6)     // Catch:{ all -> 0x0045 }
            monitor-exit(r5)
            return r6
        L_0x0045:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.l.b.a(com.baidu.android.pushservice.l.e, boolean, java.util.ArrayList):java.lang.String");
    }

    public String a(String str) {
        return this.f8428c.get(str) != null ? this.f8428c.get(str).b() : "";
    }

    public final String a(List<e> list) {
        if (!(list == null || list.size() == 0)) {
            StringBuffer stringBuffer = null;
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                int i2 = 0;
                while (i2 < list.size()) {
                    try {
                        e eVar = list.get(i2);
                        if (eVar != null) {
                            stringBuffer2.append(eVar.f8423b);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.f8422a);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.f8434d);
                            stringBuffer2.append(",");
                            stringBuffer2.append(eVar.f8424c);
                            if (i2 != list.size() - 1) {
                                stringBuffer2.append(";");
                            }
                        }
                        i2++;
                    } catch (Exception e2) {
                    }
                }
                stringBuffer = stringBuffer2;
            } catch (Exception e3) {
            }
            if (stringBuffer != null) {
                return stringBuffer.toString();
            }
        }
        return "";
    }

    public void a(String str, f fVar) {
        this.f8428c.put(str, fVar);
    }

    public boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.f8428c.containsKey(str) && str2.equals(this.f8428c.get(str).a());
    }

    public e b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<e> it = this.f8427b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!TextUtils.isEmpty(next.f8422a) && next.f8422a.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public synchronized void b(Context context) {
        ArrayList<e> arrayList = null;
        String h2 = d.h(context);
        if (!TextUtils.isEmpty(h2)) {
            arrayList = e(Utility.c(h2));
        }
        if (!(f8425d == null || arrayList == null)) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().f8423b);
            }
            int i2 = 0;
            while (i2 < f8425d.f8427b.size()) {
                if (arrayList2.contains(f8425d.f8427b.get(i2).f8423b)) {
                    f8425d.f8427b.remove(i2);
                    i2--;
                }
                i2++;
            }
            f8425d.f8427b.addAll(arrayList);
        }
    }

    public synchronized void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            ArrayList<e> e2 = e(Utility.c(str2));
            String str3 = "";
            if (!(f8425d == null || e2 == null)) {
                try {
                    if (str.equals("r_v2")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<e> it = e2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().f8423b);
                        }
                        int i2 = 0;
                        while (i2 < f8425d.f8427b.size()) {
                            if (arrayList.contains(f8425d.f8427b.get(i2).f8423b)) {
                                f8425d.f8427b.remove(i2);
                                i2--;
                            }
                            i2++;
                        }
                        f8425d.f8427b.addAll(e2);
                        str3 = a((List<e>) f8425d.f8427b);
                    }
                    d.h(this.f8426a, Utility.d(str3));
                } catch (Exception e3) {
                }
            }
        }
    }

    public e c(String str) {
        if (this.f8427b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<e> it = this.f8427b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (str.equals(next.f8423b)) {
                return next;
            }
        }
        return null;
    }

    public void d(String str) {
        this.f8428c.remove(str);
    }

    public ArrayList<e> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<e> arrayList = new ArrayList<>();
        try {
            for (String trim : str.trim().split(";")) {
                String[] split = trim.trim().split(",");
                if (split.length >= 3) {
                    e eVar = new e();
                    eVar.f8423b = split[0].trim();
                    eVar.f8422a = split[1].trim();
                    eVar.f8434d = split[2].trim();
                    if (split.length > 3) {
                        eVar.f8424c = Integer.parseInt(split[split.length - 1].trim());
                    }
                    arrayList.add(eVar);
                }
            }
        } catch (Exception e2) {
        }
        return arrayList;
    }
}
