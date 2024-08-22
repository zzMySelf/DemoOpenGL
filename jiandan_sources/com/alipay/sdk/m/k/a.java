package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

public class a {

    /* renamed from: com.alipay.sdk.m.k.a$a  reason: collision with other inner class name */
    public static final class C0005a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            synchronized (C0005a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat append " + str2 + " , " + str);
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C0006a a2 = a(context);
                        if (a2.a.size() > 20) {
                            a2.a.clear();
                        }
                        a2.a.put(str2, str);
                        a(context, a2);
                        return str2;
                    }
                }
                return null;
            }
        }

        public static synchronized String b(Context context) {
            synchronized (C0005a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                C0006a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                try {
                    String str = (String) a2.a.entrySet().iterator().next().getValue();
                    return str;
                } catch (Throwable th2) {
                    com.alipay.sdk.m.u.e.a(th2);
                    return null;
                }
            }
        }

        /* renamed from: com.alipay.sdk.m.k.a$a$a  reason: collision with other inner class name */
        public static final class C0006a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C0006a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(next.getKey()).put(next.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th2) {
                    com.alipay.sdk.m.u.e.a(th2);
                    return new JSONArray().toString();
                }
            }

            public C0006a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th2) {
                    com.alipay.sdk.m.u.e.a(th2);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
            return 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static synchronized int a(android.content.Context r6, java.lang.String r7) {
            /*
                java.lang.Class<com.alipay.sdk.m.k.a$a> r0 = com.alipay.sdk.m.k.a.C0005a.class
                monitor-enter(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
                r1.<init>()     // Catch:{ all -> 0x0093 }
                java.lang.String r2 = "stat remove "
                r1.append(r2)     // Catch:{ all -> 0x0093 }
                r1.append(r7)     // Catch:{ all -> 0x0093 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0093 }
                java.lang.String r2 = "RecordPref"
                com.alipay.sdk.m.u.e.b(r2, r1)     // Catch:{ all -> 0x0093 }
                r1 = 0
                if (r6 == 0) goto L_0x0091
                boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0093 }
                if (r2 == 0) goto L_0x0023
                goto L_0x0091
            L_0x0023:
                com.alipay.sdk.m.k.a$a$a r2 = a(r6)     // Catch:{ all -> 0x0093 }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r2.a     // Catch:{ all -> 0x0093 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0093 }
                if (r3 == 0) goto L_0x0031
                monitor-exit(r0)
                return r1
            L_0x0031:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
                r1.<init>()     // Catch:{ all -> 0x007d }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r2.a     // Catch:{ all -> 0x007d }
                java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x007d }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x007d }
            L_0x0040:
                boolean r4 = r3.hasNext()     // Catch:{ all -> 0x007d }
                if (r4 == 0) goto L_0x005e
                java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x007d }
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x007d }
                java.lang.Object r5 = r4.getValue()     // Catch:{ all -> 0x007d }
                boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x007d }
                if (r5 == 0) goto L_0x0040
                java.lang.Object r4 = r4.getKey()     // Catch:{ all -> 0x007d }
                r1.add(r4)     // Catch:{ all -> 0x007d }
                goto L_0x0040
            L_0x005e:
                java.util.Iterator r7 = r1.iterator()     // Catch:{ all -> 0x007d }
            L_0x0062:
                boolean r3 = r7.hasNext()     // Catch:{ all -> 0x007d }
                if (r3 == 0) goto L_0x0074
                java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x007d }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x007d }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r4 = r2.a     // Catch:{ all -> 0x007d }
                r4.remove(r3)     // Catch:{ all -> 0x007d }
                goto L_0x0062
            L_0x0074:
                a((android.content.Context) r6, (com.alipay.sdk.m.k.a.C0005a.C0006a) r2)     // Catch:{ all -> 0x007d }
                int r6 = r1.size()     // Catch:{ all -> 0x007d }
                monitor-exit(r0)
                return r6
            L_0x007d:
                r7 = move-exception
                com.alipay.sdk.m.u.e.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x0093 }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r2.a     // Catch:{ all -> 0x0093 }
                int r7 = r7.size()     // Catch:{ all -> 0x0093 }
                com.alipay.sdk.m.k.a$a$a r1 = new com.alipay.sdk.m.k.a$a$a     // Catch:{ all -> 0x0093 }
                r1.<init>()     // Catch:{ all -> 0x0093 }
                a((android.content.Context) r6, (com.alipay.sdk.m.k.a.C0005a.C0006a) r1)     // Catch:{ all -> 0x0093 }
                monitor-exit(r0)
                return r7
            L_0x0091:
                monitor-exit(r0)
                return r1
            L_0x0093:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.a.C0005a.a(android.content.Context, java.lang.String):int");
        }

        public static synchronized C0006a a(Context context) {
            synchronized (C0005a.class) {
                try {
                    String a2 = j.a((com.alipay.sdk.m.s.a) null, context, b, (String) null);
                    if (TextUtils.isEmpty(a2)) {
                        C0006a aVar = new C0006a();
                        return aVar;
                    }
                    C0006a aVar2 = new C0006a(a2);
                    return aVar2;
                } catch (Throwable th2) {
                    com.alipay.sdk.m.u.e.a(th2);
                    return new C0006a();
                }
            }
        }

        public static synchronized void a(Context context, C0006a aVar) {
            synchronized (C0005a.class) {
                if (aVar == null) {
                    try {
                        aVar = new C0006a();
                    } catch (Throwable th2) {
                        com.alipay.sdk.m.u.e.a(th2);
                    }
                }
                j.b((com.alipay.sdk.m.s.a) null, context, b, aVar.a());
            }
            return;
        }
    }

    public static final class b {

        /* renamed from: com.alipay.sdk.m.k.a$b$a  reason: collision with other inner class name */
        public static class C0007a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public C0007a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            public void run() {
                if (TextUtils.isEmpty(this.a) || b.b(this.b, this.a)) {
                    int i2 = 0;
                    while (i2 < 4) {
                        String b2 = C0005a.b(this.b);
                        if (!TextUtils.isEmpty(b2) && b.b(this.b, b2)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            synchronized (b.class) {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "stat sub " + str);
                try {
                    if ((com.alipay.sdk.m.m.a.z().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) == null) {
                        return false;
                    }
                    C0005a.a(context, str);
                    return true;
                } catch (Throwable th2) {
                    com.alipay.sdk.m.u.e.a(th2);
                    return false;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static synchronized void a(android.content.Context r1, com.alipay.sdk.m.k.b r2, java.lang.String r3, java.lang.String r4) {
            /*
                java.lang.Class<com.alipay.sdk.m.k.a$b> r0 = com.alipay.sdk.m.k.a.b.class
                monitor-enter(r0)
                if (r1 == 0) goto L_0x0016
                if (r2 == 0) goto L_0x0016
                if (r3 != 0) goto L_0x000a
                goto L_0x0016
            L_0x000a:
                java.lang.String r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0013 }
                a(r1, r2, r4)     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)
                return
            L_0x0013:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x0016:
                monitor-exit(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.a.b.a(android.content.Context, com.alipay.sdk.m.k.b, java.lang.String, java.lang.String):void");
        }

        public static synchronized void a(Context context) {
            synchronized (b.class) {
                a(context, (String) null, (String) null);
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0005a.a(context, str, str2);
                    }
                    new Thread(new C0007a(str, context)).start();
                }
            }
        }
    }

    public static final class c {
        public static final String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (c.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    public static final class d {
        public static synchronized long a(Context context, String str) {
            long j;
            long j2;
            synchronized (d.class) {
                try {
                    String a = j.a((com.alipay.sdk.m.s.a) null, context, str, (String) null);
                    if (!TextUtils.isEmpty(a)) {
                        j = Long.parseLong(a);
                        j2 = j + 1;
                        j.b((com.alipay.sdk.m.s.a) null, context, str, Long.toString(j2));
                    }
                } catch (Throwable unused) {
                }
                j = 0;
                j2 = j + 1;
                try {
                    j.b((com.alipay.sdk.m.s.a) null, context, str, Long.toString(j2));
                } catch (Throwable unused2) {
                }
            }
            return j2;
        }
    }

    public static final class e {
        public static final String a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            long a2;
            synchronized (e.class) {
                a2 = d.a(context, a);
            }
            return a2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r1, com.alipay.sdk.m.s.a r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.alipay.sdk.m.k.a> r0 = com.alipay.sdk.m.k.a.class
            monitor-enter(r0)
            if (r1 == 0) goto L_0x001b
            if (r2 != 0) goto L_0x0008
            goto L_0x001b
        L_0x0008:
            com.alipay.sdk.m.k.b r2 = r2.l     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0012 }
            com.alipay.sdk.m.k.a.C0005a.a(r1, r2, r4)     // Catch:{ all -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r1 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x001b:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.a.a(android.content.Context, com.alipay.sdk.m.s.a, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r1, com.alipay.sdk.m.s.a r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.alipay.sdk.m.k.a> r0 = com.alipay.sdk.m.k.a.class
            monitor-enter(r0)
            if (r1 == 0) goto L_0x0012
            if (r2 != 0) goto L_0x0008
            goto L_0x0012
        L_0x0008:
            com.alipay.sdk.m.k.b r2 = r2.l     // Catch:{ all -> 0x000f }
            com.alipay.sdk.m.k.a.b.a(r1, r2, r3, r4)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)
            return
        L_0x000f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0012:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.k.a.b(android.content.Context, com.alipay.sdk.m.s.a, java.lang.String, java.lang.String):void");
    }

    public static void b(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.l.b(str, str2, str3);
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, Throwable th2) {
        if (aVar != null && th2 != null && th2.getClass() != null) {
            aVar.l.a(str, th2.getClass().getSimpleName(), th2);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th2, String str3) {
        if (aVar != null) {
            aVar.l.a(str, str2, th2, str3);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th2) {
        if (aVar != null) {
            aVar.l.a(str, str2, th2);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.l.a(str, str2, str3);
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (aVar != null) {
            aVar.l.a(str, str2);
        }
    }
}
