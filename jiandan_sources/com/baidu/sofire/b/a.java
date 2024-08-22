package com.baidu.sofire.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.BDModuleLoadCallback;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.j;
import com.baidu.sofire.l.q;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public class a {
    public static Map<Integer, List<BDModuleLoadCallback>> p = new HashMap();
    public static long q = 0;
    public static volatile boolean r = false;
    public static boolean s = false;
    public static int t = 0;
    public static int u = 0;
    public static boolean v = false;
    public static Map<String, String> w;
    public static boolean x = false;
    public static Map<String, String> y;
    public Context a;
    public c b;
    public com.baidu.sofire.c.a c;
    public File d;
    public com.baidu.sofire.j.a e;
    public int f = 0;
    public int g = 0;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, String> f1084i;
    public Map<Integer, String> j = new HashMap();
    public List<Integer> k = new ArrayList();
    public List<Integer> l = new ArrayList();
    public Map<Integer, c> m = new HashMap();
    public int n = -2;

    /* renamed from: o  reason: collision with root package name */
    public JSONObject f1085o;

    /* renamed from: com.baidu.sofire.b.a$a  reason: collision with other inner class name */
    public class C0049a implements Comparator<ApkInfo> {
        public final /* synthetic */ List a;

        public C0049a(a aVar, List list) {
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

    public class b extends TimerTask {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        public void run() {
            List<ApkInfo> list = this.a;
            if (list != null) {
                for (ApkInfo a2 : list) {
                    a.this.a(a2);
                }
            }
        }
    }

    public class c {
        public int a;
        public int b;

        public c(a aVar, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    public a(Context context, int i2, boolean z) {
        this.a = context;
        this.c = com.baidu.sofire.c.a.a(context);
        this.e = com.baidu.sofire.j.a.a(context);
        this.b = c.a(context);
        this.d = new File(new File(com.baidu.sofire.l.c.f(context), "sofire_tmp"), ".tmp");
        this.f = i2;
        this.h = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019c, code lost:
        if (r4.keySet().contains(java.lang.Integer.valueOf(r2)) == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019e, code lost:
        r4 = 5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011c A[Catch:{ all -> 0x01c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0109 }
            r2.<init>()     // Catch:{ all -> 0x0109 }
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r14.f1084i     // Catch:{ all -> 0x0109 }
            java.lang.String r4 = "1"
            if (r3 == 0) goto L_0x0020
            java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x0109 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = "2"
            java.util.Map<java.lang.Integer, java.lang.String> r5 = r14.f1084i     // Catch:{ all -> 0x0109 }
            java.util.Collection r5 = r5.values()     // Catch:{ all -> 0x0109 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0109 }
        L_0x0020:
            java.lang.String r3 = "3"
            int r5 = r14.f     // Catch:{ all -> 0x0109 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0109 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0109 }
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r14.j     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r5 = "4"
            java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x0109 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = "5"
            java.util.Map<java.lang.Integer, java.lang.String> r5 = r14.j     // Catch:{ all -> 0x0109 }
            java.util.Collection r5 = r5.values()     // Catch:{ all -> 0x0109 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0109 }
        L_0x0043:
            java.util.List<java.lang.Integer> r3 = r14.k     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x004c
            java.lang.String r5 = "6"
            r2.put(r5, r3)     // Catch:{ all -> 0x0109 }
        L_0x004c:
            java.util.List<java.lang.Integer> r3 = r14.l     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x0055
            java.lang.String r5 = "7"
            r2.put(r5, r3)     // Catch:{ all -> 0x0109 }
        L_0x0055:
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r3 = r14.m     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x00a4
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0109 }
            r3.<init>()     // Catch:{ all -> 0x0109 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r5 = r14.m     // Catch:{ all -> 0x0109 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x0109 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0109 }
        L_0x0068:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0109 }
            if (r6 == 0) goto L_0x009f
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0109 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0109 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0109 }
            r7.<init>()     // Catch:{ all -> 0x0109 }
            java.lang.Object r8 = r6.getKey()     // Catch:{ all -> 0x0109 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0109 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0109 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x0109 }
            com.baidu.sofire.b.a$c r6 = (com.baidu.sofire.b.a.c) r6     // Catch:{ all -> 0x0109 }
            if (r6 == 0) goto L_0x0097
            int r9 = r6.a     // Catch:{ all -> 0x0109 }
            r7.put(r4, r9)     // Catch:{ all -> 0x0109 }
            java.lang.String r9 = "0"
            int r6 = r6.b     // Catch:{ all -> 0x0109 }
            r7.put(r9, r6)     // Catch:{ all -> 0x0109 }
        L_0x0097:
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0109 }
            r3.put(r6, r7)     // Catch:{ all -> 0x0109 }
            goto L_0x0068
        L_0x009f:
            java.lang.String r4 = "8"
            r2.put(r4, r3)     // Catch:{ all -> 0x0109 }
        L_0x00a4:
            com.baidu.sofire.c.a r3 = r14.c     // Catch:{ all -> 0x0109 }
            java.util.Map r3 = r3.c()     // Catch:{ all -> 0x0109 }
            java.lang.String r4 = "9"
            r5 = r3
            java.util.HashMap r5 = (java.util.HashMap) r5
            java.util.Set r6 = r5.keySet()     // Catch:{ all -> 0x010a }
            r2.put(r4, r6)     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "10"
            java.util.Collection r5 = r5.values()     // Catch:{ all -> 0x010a }
            r2.put(r4, r5)     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "11"
            int r5 = r14.g     // Catch:{ all -> 0x010a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x010a }
            r2.put(r4, r5)     // Catch:{ all -> 0x010a }
            boolean r4 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x010a }
            if (r4 != 0) goto L_0x00e7
            java.lang.String r4 = "12"
            java.lang.String r5 = "\n"
            java.lang.String r15 = r15.replace(r5, r0)     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "\t"
            java.lang.String r15 = r15.replace(r5, r0)     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "\r"
            java.lang.String r15 = r15.replace(r5, r0)     // Catch:{ all -> 0x010a }
            r2.put(r4, r15)     // Catch:{ all -> 0x010a }
        L_0x00e7:
            java.lang.String r15 = "13"
            int r0 = r14.n     // Catch:{ all -> 0x010a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x010a }
            r2.put(r15, r0)     // Catch:{ all -> 0x010a }
            java.lang.String r15 = "14"
            android.content.Context r0 = r14.a     // Catch:{ all -> 0x010a }
            int r0 = com.baidu.sofire.l.c.d((android.content.Context) r0)     // Catch:{ all -> 0x010a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x010a }
            r2.put(r15, r0)     // Catch:{ all -> 0x010a }
            android.content.Context r15 = r14.a     // Catch:{ all -> 0x010a }
            java.lang.String r0 = "1003129"
            com.baidu.sofire.l.c.a((android.content.Context) r15, (java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r2, (boolean) r1)     // Catch:{ all -> 0x010a }
            goto L_0x010c
        L_0x0109:
            r3 = 0
        L_0x010a:
            int r15 = com.baidu.sofire.a.a.a
        L_0x010c:
            java.util.Map<java.lang.Integer, java.util.List<com.baidu.sofire.ac.BDModuleLoadCallback>> r15 = p     // Catch:{ all -> 0x01c3 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ all -> 0x01c3 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x01c3 }
        L_0x0116:
            boolean r0 = r15.hasNext()     // Catch:{ all -> 0x01c3 }
            if (r0 == 0) goto L_0x01bd
            java.lang.Object r0 = r15.next()     // Catch:{ all -> 0x01c3 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x01c3 }
            java.lang.Object r2 = r0.getKey()     // Catch:{ all -> 0x01c3 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x01c3 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x01c3 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x01c3 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x01c3 }
            r4 = 4
            r5 = 2
            r6 = 7
            r7 = 8
            r8 = 5
            r9 = 3
            r10 = 1
            r11 = 11
            if (r3 == 0) goto L_0x014b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01c3 }
            boolean r12 = r3.containsKey(r12)     // Catch:{ all -> 0x01c3 }
            if (r12 == 0) goto L_0x014b
            r4 = 11
            goto L_0x01a3
        L_0x014b:
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r12 = r14.m     // Catch:{ all -> 0x01c3 }
            if (r12 == 0) goto L_0x017a
            java.util.Set r12 = r12.keySet()     // Catch:{ all -> 0x01c3 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01c3 }
            boolean r12 = r12.contains(r13)     // Catch:{ all -> 0x01c3 }
            if (r12 == 0) goto L_0x017a
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r12 = r14.m     // Catch:{ all -> 0x01c3 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01c3 }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x01c3 }
            com.baidu.sofire.b.a$c r12 = (com.baidu.sofire.b.a.c) r12     // Catch:{ all -> 0x01c3 }
            int r12 = r12.b     // Catch:{ all -> 0x01c3 }
            if (r12 == r5) goto L_0x0180
            if (r12 == r9) goto L_0x0186
            if (r12 == r4) goto L_0x0186
            if (r12 == r8) goto L_0x0178
            if (r12 == r6) goto L_0x0182
            if (r12 == r7) goto L_0x0187
            goto L_0x01a0
        L_0x0178:
            r4 = 2
            goto L_0x0187
        L_0x017a:
            int r4 = r14.g     // Catch:{ all -> 0x01c3 }
            switch(r4) {
                case 1: goto L_0x018c;
                case 2: goto L_0x0189;
                case 3: goto L_0x0186;
                case 4: goto L_0x0186;
                case 5: goto L_0x017f;
                case 6: goto L_0x0184;
                case 7: goto L_0x0186;
                case 8: goto L_0x0182;
                case 9: goto L_0x019e;
                case 10: goto L_0x019e;
                case 11: goto L_0x0180;
                default: goto L_0x017f;
            }     // Catch:{ all -> 0x01c3 }
        L_0x017f:
            goto L_0x01a0
        L_0x0180:
            r4 = 6
            goto L_0x0187
        L_0x0182:
            r4 = 3
            goto L_0x0187
        L_0x0184:
            r4 = 7
            goto L_0x0187
        L_0x0186:
            r4 = 1
        L_0x0187:
            r10 = 0
            goto L_0x01a3
        L_0x0189:
            r4 = 8
            goto L_0x0187
        L_0x018c:
            java.util.Map<java.lang.Integer, java.lang.String> r4 = r14.j     // Catch:{ all -> 0x01c3 }
            if (r4 == 0) goto L_0x01a0
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x01c3 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01c3 }
            boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x01c3 }
            if (r4 != 0) goto L_0x01a0
        L_0x019e:
            r4 = 5
            goto L_0x0187
        L_0x01a0:
            r4 = 11
            goto L_0x0187
        L_0x01a3:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01c3 }
        L_0x01a7:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x01c3 }
            if (r5 == 0) goto L_0x0116
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x01c3 }
            com.baidu.sofire.ac.BDModuleLoadCallback r5 = (com.baidu.sofire.ac.BDModuleLoadCallback) r5     // Catch:{ all -> 0x01c3 }
            if (r10 == 0) goto L_0x01b9
            r5.onSuccess(r2)     // Catch:{ all -> 0x01c3 }
            goto L_0x01a7
        L_0x01b9:
            r5.onFailure(r2, r4)     // Catch:{ all -> 0x01c3 }
            goto L_0x01a7
        L_0x01bd:
            java.util.Map<java.lang.Integer, java.util.List<com.baidu.sofire.ac.BDModuleLoadCallback>> r15 = p     // Catch:{ all -> 0x01c3 }
            r15.clear()     // Catch:{ all -> 0x01c3 }
            goto L_0x01c5
        L_0x01c3:
            int r15 = com.baidu.sofire.a.a.a
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(java.lang.String):void");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void b() {
        /*
            r34 = this;
            r1 = r34
            monitor-enter(r34)
            r2 = 1
            boolean r3 = r1.h     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x000e
            monitor-exit(r34)
            return
        L_0x000e:
            r = r2     // Catch:{ all -> 0x0011 }
            goto L_0x0016
        L_0x0011:
            r0 = move-exception
            r3 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x07c7 }
        L_0x0016:
            r3 = 0
            java.lang.Class<com.baidu.sofire.b.a> r4 = com.baidu.sofire.b.a.class
            monitor-enter(r4)     // Catch:{ all -> 0x0746 }
            r34.a()     // Catch:{ all -> 0x0742 }
            int r5 = r1.f     // Catch:{ all -> 0x0742 }
            r6 = 0
            r7 = 2
            r8 = 3
            if (r5 == r2) goto L_0x0056
            if (r5 == r7) goto L_0x0056
            if (r5 == r8) goto L_0x0056
            boolean r5 = r1.h     // Catch:{ all -> 0x0742 }
            if (r5 != 0) goto L_0x0056
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0742 }
            long r11 = q     // Catch:{ all -> 0x0742 }
            long r9 = r9 - r11
            r11 = 600000(0x927c0, double:2.964394E-318)
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0056
            int r2 = r1.g     // Catch:{ all -> 0x0742 }
            if (r2 != 0) goto L_0x0043
            r1.g = r7     // Catch:{ all -> 0x0742 }
            r1.a((java.lang.String) r6)     // Catch:{ all -> 0x0742 }
        L_0x0043:
            monitor-exit(r4)     // Catch:{ all -> 0x0742 }
            boolean r2 = r1.h     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0054
            boolean r2 = r     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0054
            r = r3     // Catch:{ all -> 0x004f }
            goto L_0x0054
        L_0x004f:
            r0 = move-exception
            r2 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x07c7 }
        L_0x0054:
            monitor-exit(r34)
            return
        L_0x0056:
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            boolean r5 = com.baidu.sofire.l.c.l(r5)     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x0064
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0742 }
            q = r9     // Catch:{ all -> 0x0742 }
        L_0x0064:
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.l.a((android.content.Context) r5, (boolean) r3)     // Catch:{ all -> 0x0742 }
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.l.a(r5)     // Catch:{ all -> 0x0742 }
            int r5 = r1.f     // Catch:{ all -> 0x0742 }
            if (r5 == r2) goto L_0x0074
            if (r5 != r8) goto L_0x007f
        L_0x0074:
            t = r3     // Catch:{ all -> 0x0742 }
            u = r3     // Catch:{ all -> 0x0742 }
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.l.a((android.content.Context) r5, (int) r3, (boolean) r2)     // Catch:{ all -> 0x0742 }
            v = r3     // Catch:{ all -> 0x0742 }
        L_0x007f:
            int r5 = r1.f     // Catch:{ all -> 0x0742 }
            if (r5 != r7) goto L_0x0085
            v = r3     // Catch:{ all -> 0x0742 }
        L_0x0085:
            java.lang.String r5 = "com.baidu.input_huawei"
            android.content.Context r9 = r1.a     // Catch:{ all -> 0x0742 }
            java.lang.String r9 = r9.getPackageName()     // Catch:{ all -> 0x0742 }
            boolean r5 = r5.equals(r9)     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x009b
            com.baidu.sofire.j.a r5 = r1.e     // Catch:{ all -> 0x0742 }
            boolean r5 = r5.b()     // Catch:{ all -> 0x0742 }
            r5 = r5 ^ r2
            goto L_0x009c
        L_0x009b:
            r5 = 0
        L_0x009c:
            android.content.Context r9 = r1.a     // Catch:{ all -> 0x0742 }
            boolean r9 = com.baidu.sofire.l.c.l(r9)     // Catch:{ all -> 0x0742 }
            if (r9 == 0) goto L_0x0700
            if (r5 == 0) goto L_0x00a8
            goto L_0x0700
        L_0x00a8:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0742 }
            q = r9     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r5 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x00cb
            boolean r5 = s     // Catch:{ all -> 0x0742 }
            if (r5 != 0) goto L_0x00ba
            boolean r5 = com.baidu.sofire.l.c.b     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x00cb
        L_0x00ba:
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x00c6 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x00c6 }
            com.baidu.sofire.MyReceiver r9 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x00c6 }
            r5.unregisterReceiver(r9)     // Catch:{ all -> 0x00c6 }
            goto L_0x00cb
        L_0x00c6:
            r0 = move-exception
            r5 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0742 }
        L_0x00cb:
            s = r3     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.b = r3     // Catch:{ all -> 0x0742 }
            int r5 = r1.f     // Catch:{ all -> 0x0742 }
            if (r5 == r2) goto L_0x00db
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            org.json.JSONObject r5 = com.baidu.sofire.l.c.o(r5)     // Catch:{ all -> 0x0742 }
            r1.f1085o = r5     // Catch:{ all -> 0x0742 }
        L_0x00db:
            org.json.JSONObject r5 = r1.f1085o     // Catch:{ all -> 0x0742 }
            if (r5 != 0) goto L_0x0140
            int r5 = r1.f     // Catch:{ all -> 0x0742 }
            if (r5 == r2) goto L_0x00eb
            if (r5 == r7) goto L_0x00eb
            if (r5 != r8) goto L_0x0107
            boolean r5 = v     // Catch:{ all -> 0x0742 }
            if (r5 != 0) goto L_0x0107
        L_0x00eb:
            com.baidu.sofire.j.a r5 = r1.e     // Catch:{ all -> 0x0742 }
            java.util.List r5 = r5.e()     // Catch:{ all -> 0x0742 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x07c7 }
            int r5 = r5.size()     // Catch:{ all -> 0x0742 }
            if (r5 <= 0) goto L_0x0107
            v = r2     // Catch:{ all -> 0x0742 }
            android.content.Context r5 = r1.a     // Catch:{ all -> 0x0742 }
            int r6 = t     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.l.a((android.content.Context) r5, (int) r6, (boolean) r3)     // Catch:{ all -> 0x0742 }
            int r5 = t     // Catch:{ all -> 0x0742 }
            int r5 = r5 + r2
            t = r5     // Catch:{ all -> 0x0742 }
        L_0x0107:
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x0742 }
            java.lang.String r6 = "android.net.conn.CONNECTIVITY_CHANGE"
            r5.<init>(r6)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r6 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0742 }
            if (r6 != 0) goto L_0x011e
            com.baidu.sofire.MyReceiver r6 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0742 }
            r6.<init>()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r6 = r6.a()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.g = r6     // Catch:{ all -> 0x0742 }
            goto L_0x0121
        L_0x011e:
            r6.a()     // Catch:{ all -> 0x0742 }
        L_0x0121:
            android.content.Context r6 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r7 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.a((android.content.Context) r6, (android.content.BroadcastReceiver) r7, (android.content.IntentFilter) r5)     // Catch:{ all -> 0x0742 }
            s = r2     // Catch:{ all -> 0x0742 }
            int r2 = r1.g     // Catch:{ all -> 0x0742 }
            if (r2 != 0) goto L_0x0138
            int r2 = com.baidu.sofire.l.c.e     // Catch:{ all -> 0x0742 }
            if (r2 == 0) goto L_0x0135
            r1.g = r2     // Catch:{ all -> 0x0742 }
            goto L_0x0138
        L_0x0135:
            r2 = 4
            r1.g = r2     // Catch:{ all -> 0x0742 }
        L_0x0138:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0742 }
            java.lang.String r5 = "ping faild"
            r2.<init>(r5)     // Catch:{ all -> 0x0742 }
            throw r2     // Catch:{ all -> 0x0742 }
        L_0x0140:
            t = r3     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.c r7 = r1.b     // Catch:{ all -> 0x0742 }
            r7.a((org.json.JSONObject) r5)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.c.a r5 = r1.c     // Catch:{ all -> 0x0742 }
            r5.a()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.j.a r5 = r1.e     // Catch:{ all -> 0x0742 }
            int r7 = r5.m()     // Catch:{ all -> 0x0742 }
            int r7 = r7 + r2
            r5.d((int) r7)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.c.a r5 = r1.c     // Catch:{ all -> 0x0742 }
            java.util.List r5 = r5.b()     // Catch:{ all -> 0x0742 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0742 }
            r7.<init>()     // Catch:{ all -> 0x0742 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0742 }
            r9.<init>()     // Catch:{ all -> 0x0742 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0742 }
            r10.<init>()     // Catch:{ all -> 0x0742 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0742 }
            r11.<init>()     // Catch:{ all -> 0x0742 }
            org.json.JSONObject r12 = r1.f1085o     // Catch:{ all -> 0x0742 }
            java.lang.String r13 = "5"
            org.json.JSONObject r12 = r12.optJSONObject(r13)     // Catch:{ all -> 0x0742 }
            if (r12 != 0) goto L_0x018a
            int r2 = r1.g     // Catch:{ all -> 0x0742 }
            if (r2 != 0) goto L_0x0182
            r2 = 10
            r1.g = r2     // Catch:{ all -> 0x0742 }
        L_0x0182:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0742 }
            java.lang.String r5 = "plugin json is null"
            r2.<init>(r5)     // Catch:{ all -> 0x0742 }
            throw r2     // Catch:{ all -> 0x0742 }
        L_0x018a:
            android.content.Context r13 = r1.a     // Catch:{ all -> 0x0742 }
            android.content.Context r13 = r13.getApplicationContext()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.j r13 = com.baidu.sofire.b.j.a((android.content.Context) r13)     // Catch:{ all -> 0x0742 }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ all -> 0x0742 }
            r14.<init>()     // Catch:{ all -> 0x0742 }
            java.util.Iterator r15 = r12.keys()     // Catch:{ all -> 0x0742 }
        L_0x019d:
            boolean r16 = r15.hasNext()     // Catch:{ all -> 0x0742 }
            if (r16 == 0) goto L_0x0566
            java.lang.Object r16 = r15.next()     // Catch:{ all -> 0x0742 }
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0742 }
            org.json.JSONObject r8 = r12.optJSONObject(r6)     // Catch:{ all -> 0x0742 }
            java.lang.String r3 = "l"
            int r3 = r8.optInt(r3)     // Catch:{ all -> 0x0742 }
            java.lang.String r2 = "v"
            java.lang.String r2 = r8.optString(r2)     // Catch:{ all -> 0x0742 }
            r23 = r12
            java.util.Map<java.lang.Integer, java.lang.String> r12 = r1.j     // Catch:{ all -> 0x0742 }
            if (r12 == 0) goto L_0x01cb
            r24 = r15
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0742 }
            r12.put(r15, r2)     // Catch:{ all -> 0x0742 }
            goto L_0x01cd
        L_0x01cb:
            r24 = r15
        L_0x01cd:
            java.lang.String r12 = "u"
            java.lang.String r21 = r8.optString(r12)     // Catch:{ all -> 0x0742 }
            java.lang.String r12 = "m"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ all -> 0x0742 }
            java.lang.String r15 = "sm"
            java.lang.String r15 = r8.optString(r15)     // Catch:{ all -> 0x0742 }
            if (r12 == 0) goto L_0x01e5
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x0742 }
        L_0x01e5:
            r25 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0742 }
            r7.<init>()     // Catch:{ all -> 0x0742 }
            r7.append(r3)     // Catch:{ all -> 0x0742 }
            r7.append(r2)     // Catch:{ all -> 0x0742 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0742 }
            java.util.Map<java.lang.String, java.lang.String> r17 = w     // Catch:{ all -> 0x0742 }
            if (r17 != 0) goto L_0x0201
            java.util.HashMap r17 = new java.util.HashMap     // Catch:{ all -> 0x0742 }
            r17.<init>()     // Catch:{ all -> 0x0742 }
            w = r17     // Catch:{ all -> 0x0742 }
        L_0x0201:
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0742 }
            if (r17 != 0) goto L_0x0215
            boolean r17 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0742 }
            if (r17 != 0) goto L_0x0215
            r26 = r13
            java.util.Map<java.lang.String, java.lang.String> r13 = w     // Catch:{ all -> 0x0742 }
            r13.put(r7, r12)     // Catch:{ all -> 0x0742 }
            goto L_0x0217
        L_0x0215:
            r26 = r13
        L_0x0217:
            if (r15 == 0) goto L_0x021d
            java.lang.String r15 = r15.toLowerCase()     // Catch:{ all -> 0x0742 }
        L_0x021d:
            java.lang.String r7 = "o"
            int r7 = r8.optInt(r7)     // Catch:{ all -> 0x0742 }
            r13 = 1
            if (r7 != r13) goto L_0x0228
            r7 = 1
            goto L_0x0229
        L_0x0228:
            r7 = 0
        L_0x0229:
            java.lang.String r13 = "d"
            int r13 = r8.optInt(r13)     // Catch:{ all -> 0x0742 }
            r27 = r9
            r9 = 1
            if (r13 != r9) goto L_0x0236
            r9 = 1
            goto L_0x0237
        L_0x0236:
            r9 = 0
        L_0x0237:
            java.lang.String r13 = "r"
            int r13 = r8.optInt(r13)     // Catch:{ all -> 0x0742 }
            if (r13 <= 0) goto L_0x0253
            if (r7 == 0) goto L_0x0249
            r28 = r11
            com.baidu.sofire.j.a r11 = r1.e     // Catch:{ all -> 0x0742 }
            r11.a((int) r13)     // Catch:{ all -> 0x0742 }
            goto L_0x024b
        L_0x0249:
            r28 = r11
        L_0x024b:
            java.lang.String r11 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0742 }
            r14.put(r6, r11)     // Catch:{ all -> 0x0742 }
            goto L_0x0255
        L_0x0253:
            r28 = r11
        L_0x0255:
            if (r7 == 0) goto L_0x026c
            if (r9 == 0) goto L_0x026c
            r10.add(r6)     // Catch:{ all -> 0x0742 }
            r31 = r5
            r29 = r10
            r30 = r14
        L_0x0262:
            r9 = r25
            r10 = r26
            r6 = r27
            r3 = r28
            goto L_0x0552
        L_0x026c:
            java.lang.String r9 = "es"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x0742 }
            android.content.pm.PackageInfo r11 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x0396 }
            r11.<init>()     // Catch:{ all -> 0x0396 }
            java.lang.String r13 = "p"
            java.lang.String r13 = r8.optString(r13)     // Catch:{ all -> 0x0396 }
            r11.packageName = r13     // Catch:{ all -> 0x0396 }
            r11.versionName = r2     // Catch:{ all -> 0x0396 }
            android.content.pm.ApplicationInfo r13 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x0396 }
            r13.<init>()     // Catch:{ all -> 0x0396 }
            r29 = r10
            java.lang.String r10 = "n"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ all -> 0x0390 }
            r13.className = r10     // Catch:{ all -> 0x0390 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0390 }
            if (r10 != 0) goto L_0x02bb
            java.lang.String r10 = r13.className     // Catch:{ all -> 0x02b6 }
            r30 = r14
            java.lang.String r14 = "."
            boolean r10 = r10.startsWith(r14)     // Catch:{ all -> 0x038a }
            if (r10 == 0) goto L_0x02bd
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r10.<init>()     // Catch:{ all -> 0x038a }
            r10.append(r6)     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r13.className     // Catch:{ all -> 0x038a }
            r10.append(r14)     // Catch:{ all -> 0x038a }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x038a }
            r13.className = r10     // Catch:{ all -> 0x038a }
            goto L_0x02bd
        L_0x02b6:
            r0 = move-exception
            r30 = r14
            goto L_0x038b
        L_0x02bb:
            r30 = r14
        L_0x02bd:
            java.lang.String r10 = "t"
            int r10 = r8.optInt(r10)     // Catch:{ all -> 0x038a }
            r13.theme = r10     // Catch:{ all -> 0x038a }
            r11.applicationInfo = r13     // Catch:{ all -> 0x038a }
            java.lang.String r10 = "a"
            org.json.JSONArray r10 = r8.optJSONArray(r10)     // Catch:{ all -> 0x038a }
            if (r10 == 0) goto L_0x0383
            int r13 = r10.length()     // Catch:{ all -> 0x038a }
            if (r13 <= 0) goto L_0x0383
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x038a }
            r13.<init>()     // Catch:{ all -> 0x038a }
            r31 = r5
            r14 = 0
        L_0x02dd:
            int r5 = r10.length()     // Catch:{ all -> 0x0381 }
            if (r14 >= r5) goto L_0x0366
            org.json.JSONObject r5 = r10.getJSONObject(r14)     // Catch:{ all -> 0x0351 }
            if (r5 == 0) goto L_0x034a
            r17 = r10
            android.content.pm.ActivityInfo r10 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x0346 }
            r10.<init>()     // Catch:{ all -> 0x0346 }
            r32 = r15
            java.lang.String r15 = "n"
            java.lang.String r15 = r5.optString(r15)     // Catch:{ all -> 0x0342 }
            r10.name = r15     // Catch:{ all -> 0x0342 }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0342 }
            if (r15 != 0) goto L_0x0320
            java.lang.String r15 = r10.name     // Catch:{ all -> 0x0342 }
            r33 = r8
            java.lang.String r8 = "."
            boolean r8 = r15.startsWith(r8)     // Catch:{ all -> 0x0340 }
            if (r8 == 0) goto L_0x0322
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0340 }
            r8.<init>()     // Catch:{ all -> 0x0340 }
            r8.append(r6)     // Catch:{ all -> 0x0340 }
            java.lang.String r15 = r10.name     // Catch:{ all -> 0x0340 }
            r8.append(r15)     // Catch:{ all -> 0x0340 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0340 }
            r10.name = r8     // Catch:{ all -> 0x0340 }
            goto L_0x0322
        L_0x0320:
            r33 = r8
        L_0x0322:
            r10.packageName = r6     // Catch:{ all -> 0x0340 }
            java.lang.String r8 = "t"
            int r8 = r5.optInt(r8)     // Catch:{ all -> 0x0340 }
            r10.theme = r8     // Catch:{ all -> 0x0340 }
            java.lang.String r8 = "l"
            int r5 = r5.optInt(r8)     // Catch:{ all -> 0x0340 }
            r10.labelRes = r5     // Catch:{ all -> 0x0340 }
            java.lang.String r5 = r10.name     // Catch:{ all -> 0x0340 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0340 }
            if (r5 != 0) goto L_0x035c
            r13.add(r10)     // Catch:{ all -> 0x0340 }
            goto L_0x035c
        L_0x0340:
            r0 = move-exception
            goto L_0x0358
        L_0x0342:
            r0 = move-exception
            r33 = r8
            goto L_0x0358
        L_0x0346:
            r0 = move-exception
            r33 = r8
            goto L_0x0356
        L_0x034a:
            r33 = r8
            r17 = r10
            r32 = r15
            goto L_0x035c
        L_0x0351:
            r0 = move-exception
            r33 = r8
            r17 = r10
        L_0x0356:
            r32 = r15
        L_0x0358:
            r5 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x037f }
        L_0x035c:
            int r14 = r14 + 1
            r10 = r17
            r15 = r32
            r8 = r33
            goto L_0x02dd
        L_0x0366:
            r33 = r8
            r32 = r15
            int r5 = r13.size()     // Catch:{ all -> 0x037f }
            if (r5 <= 0) goto L_0x03a6
            int r5 = r13.size()     // Catch:{ all -> 0x037f }
            android.content.pm.ActivityInfo[] r5 = new android.content.pm.ActivityInfo[r5]     // Catch:{ all -> 0x037f }
            java.lang.Object[] r5 = r13.toArray(r5)     // Catch:{ all -> 0x037f }
            android.content.pm.ActivityInfo[] r5 = (android.content.pm.ActivityInfo[]) r5     // Catch:{ all -> 0x037f }
            r11.activities = r5     // Catch:{ all -> 0x037f }
            goto L_0x03a6
        L_0x037f:
            r0 = move-exception
            goto L_0x03a1
        L_0x0381:
            r0 = move-exception
            goto L_0x038d
        L_0x0383:
            r31 = r5
            r33 = r8
            r32 = r15
            goto L_0x03a6
        L_0x038a:
            r0 = move-exception
        L_0x038b:
            r31 = r5
        L_0x038d:
            r33 = r8
            goto L_0x039f
        L_0x0390:
            r0 = move-exception
            r31 = r5
            r33 = r8
            goto L_0x039d
        L_0x0396:
            r0 = move-exception
            r31 = r5
            r33 = r8
            r29 = r10
        L_0x039d:
            r30 = r14
        L_0x039f:
            r32 = r15
        L_0x03a1:
            r5 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0742 }
            r11 = 0
        L_0x03a6:
            com.baidu.sofire.core.ApkInfo r5 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x0742 }
            r17 = r5
            r18 = r3
            r19 = r6
            r20 = r2
            r22 = r12
            r17.<init>(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0742 }
            r5.isOnce = r7     // Catch:{ all -> 0x0742 }
            r5.es = r9     // Catch:{ all -> 0x0742 }
            java.lang.String r2 = "pr"
            r6 = r33
            int r2 = r6.getInt(r2)     // Catch:{ all -> 0x03c6 }
            r5.priority = r2     // Catch:{ all -> 0x03c6 }
            goto L_0x03c9
        L_0x03c4:
            r6 = r33
        L_0x03c6:
            r2 = -1
            r5.priority = r2     // Catch:{ all -> 0x0742 }
        L_0x03c9:
            java.lang.String r2 = "mem"
            int r2 = r6.optInt(r2)     // Catch:{ all -> 0x0742 }
            r7 = 1
            if (r2 != r7) goto L_0x03d4
            r2 = 1
            goto L_0x03d5
        L_0x03d4:
            r2 = 0
        L_0x03d5:
            r5.isMem = r2     // Catch:{ all -> 0x0742 }
            if (r11 == 0) goto L_0x03db
            r5.cloudPkgInfo = r11     // Catch:{ all -> 0x0742 }
        L_0x03db:
            java.lang.String r2 = "e"
            org.json.JSONObject r2 = r6.optJSONObject(r2)     // Catch:{ all -> 0x0742 }
            if (r2 == 0) goto L_0x03f3
            java.lang.String r7 = "d"
            int r7 = r2.optInt(r7)     // Catch:{ all -> 0x0742 }
            java.lang.String r8 = "n"
            int r2 = r2.optInt(r8)     // Catch:{ all -> 0x0742 }
            r5.duration = r7     // Catch:{ all -> 0x0742 }
            r5.network = r2     // Catch:{ all -> 0x0742 }
        L_0x03f3:
            java.lang.String r2 = "ext"
            org.json.JSONObject r2 = r6.optJSONObject(r2)     // Catch:{ all -> 0x0742 }
            if (r2 == 0) goto L_0x0452
            java.lang.String r6 = "nl"
            r7 = 0
            r2.optInt(r6, r7)     // Catch:{ all -> 0x0742 }
            java.lang.String r6 = "oc"
            int r6 = r2.optInt(r6, r7)     // Catch:{ all -> 0x0742 }
            r7 = 1
            if (r6 != r7) goto L_0x040c
            r6 = 1
            goto L_0x040d
        L_0x040c:
            r6 = 0
        L_0x040d:
            java.lang.String r8 = "a"
            int r2 = r2.optInt(r8)     // Catch:{ all -> 0x0742 }
            if (r2 != r7) goto L_0x044f
            com.baidu.sofire.j.a r2 = r1.e     // Catch:{ all -> 0x0742 }
            java.util.List r2 = r2.e()     // Catch:{ all -> 0x0742 }
            if (r3 <= 0) goto L_0x044f
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0742 }
            boolean r7 = r2.contains(r7)     // Catch:{ all -> 0x0742 }
            if (r7 != 0) goto L_0x044f
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0742 }
            r2.add(r7)     // Catch:{ all -> 0x0742 }
            int r7 = r2.size()     // Catch:{ all -> 0x0742 }
            int[] r7 = new int[r7]     // Catch:{ all -> 0x0742 }
            r8 = 0
        L_0x0435:
            int r9 = r2.size()     // Catch:{ all -> 0x0742 }
            if (r8 >= r9) goto L_0x044a
            java.lang.Object r9 = r2.get(r8)     // Catch:{ all -> 0x0742 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0742 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0742 }
            r7[r8] = r9     // Catch:{ all -> 0x0742 }
            int r8 = r8 + 1
            goto L_0x0435
        L_0x044a:
            com.baidu.sofire.j.a r2 = r1.e     // Catch:{ all -> 0x0742 }
            r2.a((int[]) r7)     // Catch:{ all -> 0x0742 }
        L_0x044f:
            r15 = r32
            goto L_0x0455
        L_0x0452:
            r15 = r32
            r6 = 0
        L_0x0455:
            r5.signMD5 = r15     // Catch:{ all -> 0x0742 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0742 }
            r5.startTime = r7     // Catch:{ all -> 0x0742 }
            r2 = r31
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x07c7 }
            int r7 = r2.indexOf(r5)     // Catch:{ all -> 0x0742 }
            if (r7 < 0) goto L_0x053a
            java.lang.Object r8 = r2.get(r7)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.core.ApkInfo r8 = (com.baidu.sofire.core.ApkInfo) r8     // Catch:{ all -> 0x0742 }
            java.lang.String r9 = r5.versionName     // Catch:{ all -> 0x0742 }
            java.lang.String r10 = r8.versionName     // Catch:{ all -> 0x0742 }
            boolean r9 = com.baidu.sofire.l.c.b((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0742 }
            if (r9 == 0) goto L_0x04d1
            if (r6 == 0) goto L_0x0484
            boolean r3 = com.baidu.sofire.l.c.b((int) r3)     // Catch:{ all -> 0x0742 }
            if (r3 == 0) goto L_0x0484
            r2.remove(r7)     // Catch:{ all -> 0x0742 }
            goto L_0x0262
        L_0x0484:
            int r3 = r8.priority     // Catch:{ all -> 0x0742 }
            int r6 = r5.priority     // Catch:{ all -> 0x0742 }
            if (r3 == r6) goto L_0x0491
            com.baidu.sofire.c.a r3 = r1.c     // Catch:{ all -> 0x0742 }
            int r9 = r5.key     // Catch:{ all -> 0x0742 }
            r3.d(r9, r6)     // Catch:{ all -> 0x0742 }
        L_0x0491:
            com.baidu.sofire.c.a r3 = r1.c     // Catch:{ all -> 0x0742 }
            int r6 = r8.key     // Catch:{ all -> 0x0742 }
            boolean r3 = r3.e(r6)     // Catch:{ all -> 0x0742 }
            if (r3 != 0) goto L_0x04c8
            java.util.List<java.lang.Integer> r3 = com.baidu.sofire.b.c.g     // Catch:{ all -> 0x0742 }
            if (r3 == 0) goto L_0x04b3
            int r6 = r5.key     // Catch:{ all -> 0x0742 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0742 }
            boolean r3 = r3.contains(r6)     // Catch:{ all -> 0x0742 }
            if (r3 == 0) goto L_0x04b3
            r3 = r28
            r3.add(r5)     // Catch:{ all -> 0x0742 }
            r6 = r27
            goto L_0x04ba
        L_0x04b3:
            r3 = r28
            r6 = r27
            r6.add(r5)     // Catch:{ all -> 0x0742 }
        L_0x04ba:
            java.util.List<java.lang.Integer> r8 = r1.l     // Catch:{ all -> 0x0742 }
            if (r8 == 0) goto L_0x04cc
            int r5 = r5.key     // Catch:{ all -> 0x0742 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0742 }
            r8.add(r5)     // Catch:{ all -> 0x0742 }
            goto L_0x04cc
        L_0x04c8:
            r6 = r27
            r3 = r28
        L_0x04cc:
            r9 = r25
            r10 = r26
            goto L_0x0536
        L_0x04d1:
            r6 = r27
            r3 = r28
            int r9 = r1.f     // Catch:{ all -> 0x0742 }
            r10 = 1
            if (r9 == r10) goto L_0x04e6
            java.lang.String r9 = r8.packageName     // Catch:{ all -> 0x0742 }
            r10 = r26
            com.baidu.sofire.core.ApkInfo r9 = r10.b((java.lang.String) r9)     // Catch:{ all -> 0x0742 }
            if (r9 == 0) goto L_0x04e8
            r9 = 1
            goto L_0x0502
        L_0x04e6:
            r10 = r26
        L_0x04e8:
            java.lang.String r9 = r8.pkgPath     // Catch:{ all -> 0x0742 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0742 }
            if (r9 != 0) goto L_0x0501
            java.lang.String r9 = r5.apkMD5     // Catch:{ all -> 0x0742 }
            java.lang.String r11 = r8.pkgPath     // Catch:{ all -> 0x0742 }
            android.util.Pair r9 = r10.b(r9, r11)     // Catch:{ all -> 0x0742 }
            java.lang.Object r9 = r9.first     // Catch:{ all -> 0x0742 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0742 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0742 }
            goto L_0x0502
        L_0x0501:
            r9 = 0
        L_0x0502:
            if (r9 == 0) goto L_0x051b
            int r9 = r8.priority     // Catch:{ all -> 0x0742 }
            int r11 = r5.priority     // Catch:{ all -> 0x0742 }
            if (r9 == r11) goto L_0x0515
            r8.priority = r11     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.c.a r9 = r1.c     // Catch:{ all -> 0x0742 }
            int r11 = r5.key     // Catch:{ all -> 0x0742 }
            int r5 = r5.priority     // Catch:{ all -> 0x0742 }
            r9.d(r11, r5)     // Catch:{ all -> 0x0742 }
        L_0x0515:
            r9 = r25
            r9.add(r8)     // Catch:{ all -> 0x0742 }
            goto L_0x0536
        L_0x051b:
            r9 = r25
            com.baidu.sofire.b.c r11 = r1.b     // Catch:{ all -> 0x0742 }
            java.lang.String r12 = r8.packageName     // Catch:{ all -> 0x0742 }
            java.lang.String r8 = r8.pkgPath     // Catch:{ all -> 0x0742 }
            r11.a(r12, r8)     // Catch:{ all -> 0x0742 }
            r6.add(r5)     // Catch:{ all -> 0x0742 }
            java.util.List<java.lang.Integer> r8 = r1.l     // Catch:{ all -> 0x0742 }
            if (r8 == 0) goto L_0x0536
            int r5 = r5.key     // Catch:{ all -> 0x0742 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0742 }
            r8.add(r5)     // Catch:{ all -> 0x0742 }
        L_0x0536:
            r2.remove(r7)     // Catch:{ all -> 0x0742 }
            goto L_0x0552
        L_0x053a:
            r9 = r25
            r10 = r26
            r6 = r27
            r3 = r28
            r6.add(r5)     // Catch:{ all -> 0x0742 }
            java.util.List<java.lang.Integer> r2 = r1.l     // Catch:{ all -> 0x0742 }
            if (r2 == 0) goto L_0x0552
            int r5 = r5.key     // Catch:{ all -> 0x0742 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0742 }
            r2.add(r5)     // Catch:{ all -> 0x0742 }
        L_0x0552:
            r11 = r3
            r7 = r9
            r13 = r10
            r12 = r23
            r15 = r24
            r10 = r29
            r14 = r30
            r5 = r31
            r2 = 1
            r3 = 0
            r8 = 3
            r9 = r6
            r6 = 0
            goto L_0x019d
        L_0x0566:
            r31 = r5
            r6 = r9
            r29 = r10
            r3 = r11
            r10 = r13
            r30 = r14
            r9 = r7
            int r2 = r30.size()     // Catch:{ all -> 0x0742 }
            if (r2 <= 0) goto L_0x0578
            y = r30     // Catch:{ all -> 0x0742 }
        L_0x0578:
            java.util.List<java.lang.Integer> r2 = com.baidu.sofire.b.c.g     // Catch:{ all -> 0x0742 }
            if (r2 == 0) goto L_0x057f
            r2.clear()     // Catch:{ all -> 0x0742 }
        L_0x057f:
            r5 = r31
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x07c7 }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0742 }
        L_0x0587:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x05b5
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.core.ApkInfo r5 = (com.baidu.sofire.core.ApkInfo) r5     // Catch:{ all -> 0x0742 }
            java.lang.String r7 = r5.packageName     // Catch:{ all -> 0x0742 }
            r8 = r29
            boolean r7 = r8.contains(r7)     // Catch:{ all -> 0x0742 }
            if (r7 == 0) goto L_0x05a0
        L_0x059d:
            r29 = r8
            goto L_0x0587
        L_0x05a0:
            java.util.List<java.lang.Integer> r7 = r1.k     // Catch:{ all -> 0x0742 }
            if (r7 == 0) goto L_0x05ad
            int r11 = r5.key     // Catch:{ all -> 0x0742 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0742 }
            r7.add(r11)     // Catch:{ all -> 0x0742 }
        L_0x05ad:
            com.baidu.sofire.b.c r7 = r1.b     // Catch:{ all -> 0x0742 }
            java.lang.String r5 = r5.packageName     // Catch:{ all -> 0x0742 }
            r7.b(r5)     // Catch:{ all -> 0x0742 }
            goto L_0x059d
        L_0x05b5:
            android.content.Context r2 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.q(r2)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.j.a r2 = r1.e     // Catch:{ all -> 0x0742 }
            java.util.List r2 = r2.f()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.j.a r5 = r1.e     // Catch:{ all -> 0x0742 }
            java.util.List r5 = r5.e()     // Catch:{ all -> 0x0742 }
            r7 = 0
        L_0x05c7:
            r8 = r5
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x07c7 }
            int r11 = r8.size()     // Catch:{ all -> 0x0742 }
            if (r7 >= r11) goto L_0x05e7
            java.lang.Object r11 = r8.get(r7)     // Catch:{ all -> 0x0742 }
            r12 = r2
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x07c7 }
            boolean r11 = r12.contains(r11)     // Catch:{ all -> 0x0742 }
            if (r11 != 0) goto L_0x05e4
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x0742 }
            r12.add(r8)     // Catch:{ all -> 0x0742 }
        L_0x05e4:
            int r7 = r7 + 1
            goto L_0x05c7
        L_0x05e7:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0742 }
            r5.<init>()     // Catch:{ all -> 0x0742 }
            r5.addAll(r9)     // Catch:{ all -> 0x0742 }
            r5.addAll(r6)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.a$a r7 = new com.baidu.sofire.b.a$a     // Catch:{ all -> 0x0742 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0742 }
            java.util.Collections.sort(r5, r7)     // Catch:{ all -> 0x0742 }
            r2 = 0
        L_0x05fb:
            int r7 = r5.size()     // Catch:{ all -> 0x0742 }
            if (r2 >= r7) goto L_0x06cc
            java.lang.Object r7 = r5.get(r2)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.core.ApkInfo r7 = (com.baidu.sofire.core.ApkInfo) r7     // Catch:{ all -> 0x0742 }
            boolean r8 = r9.contains(r7)     // Catch:{ all -> 0x0742 }
            if (r8 == 0) goto L_0x06b5
            java.lang.String r8 = r7.packageName     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.core.ApkInfo r8 = r10.b((java.lang.String) r8)     // Catch:{ all -> 0x0742 }
            if (r8 != 0) goto L_0x06c8
            com.baidu.sofire.c.a r8 = r1.c     // Catch:{ all -> 0x0742 }
            int r11 = r7.key     // Catch:{ all -> 0x0742 }
            int r8 = r8.c(r11)     // Catch:{ all -> 0x0742 }
            r11 = 3
            if (r8 != r11) goto L_0x0622
            r8 = 0
            goto L_0x0623
        L_0x0622:
            r8 = 1
        L_0x0623:
            com.baidu.sofire.j.a r11 = r1.e     // Catch:{ all -> 0x0742 }
            boolean r11 = r11.n()     // Catch:{ all -> 0x0742 }
            if (r11 == 0) goto L_0x066b
            if (r8 == 0) goto L_0x066b
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0742 }
            java.lang.String r11 = r7.pkgPath     // Catch:{ all -> 0x0742 }
            r8.<init>(r11)     // Catch:{ all -> 0x0742 }
            java.io.File r11 = r8.getParentFile()     // Catch:{ all -> 0x0742 }
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x0742 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0742 }
            r13.<init>()     // Catch:{ all -> 0x0742 }
            int r14 = r7.key     // Catch:{ all -> 0x0742 }
            r13.append(r14)     // Catch:{ all -> 0x0742 }
            java.lang.String r14 = "."
            r13.append(r14)     // Catch:{ all -> 0x0742 }
            java.lang.String r14 = r7.versionName     // Catch:{ all -> 0x0742 }
            r13.append(r14)     // Catch:{ all -> 0x0742 }
            java.lang.String r14 = ".b"
            r13.append(r14)     // Catch:{ all -> 0x0742 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0742 }
            r12.<init>(r11, r13)     // Catch:{ all -> 0x0742 }
            boolean r11 = com.baidu.sofire.l.c.a((java.io.File) r12)     // Catch:{ all -> 0x0742 }
            if (r11 != 0) goto L_0x0663
            com.baidu.sofire.b.l.a((java.io.File) r8, (java.io.File) r12)     // Catch:{ all -> 0x0742 }
        L_0x0663:
            android.content.Context r11 = r1.a     // Catch:{ all -> 0x0742 }
            int r13 = r7.key     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.a.b.a(r11, r13, r8, r12)     // Catch:{ all -> 0x0742 }
            goto L_0x06aa
        L_0x066b:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0742 }
            java.lang.String r11 = r7.pkgPath     // Catch:{ all -> 0x0742 }
            r8.<init>(r11)     // Catch:{ all -> 0x0742 }
            java.io.File r8 = r8.getParentFile()     // Catch:{ all -> 0x0742 }
            boolean r11 = r8.exists()     // Catch:{ all -> 0x0742 }
            if (r11 == 0) goto L_0x06aa
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x0742 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0742 }
            r12.<init>()     // Catch:{ all -> 0x0742 }
            int r13 = r7.key     // Catch:{ all -> 0x0742 }
            r12.append(r13)     // Catch:{ all -> 0x0742 }
            java.lang.String r13 = "."
            r12.append(r13)     // Catch:{ all -> 0x0742 }
            java.lang.String r13 = r7.versionName     // Catch:{ all -> 0x0742 }
            r12.append(r13)     // Catch:{ all -> 0x0742 }
            java.lang.String r13 = ".b"
            r12.append(r13)     // Catch:{ all -> 0x0742 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0742 }
            r11.<init>(r8, r12)     // Catch:{ all -> 0x0742 }
            boolean r8 = com.baidu.sofire.l.c.a((java.io.File) r11)     // Catch:{ all -> 0x0742 }
            if (r8 == 0) goto L_0x06aa
            com.baidu.sofire.a.b.a(r11)     // Catch:{ all -> 0x0742 }
            r11.delete()     // Catch:{ all -> 0x0742 }
        L_0x06aa:
            com.baidu.sofire.b.c r8 = r1.b     // Catch:{ all -> 0x0742 }
            int r11 = r7.key     // Catch:{ all -> 0x0742 }
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x0742 }
            r12 = 0
            r8.a(r11, r7, r12)     // Catch:{ all -> 0x0742 }
            goto L_0x06c8
        L_0x06b5:
            boolean r8 = r6.contains(r7)     // Catch:{ all -> 0x0742 }
            if (r8 == 0) goto L_0x06c8
            com.baidu.sofire.c.a r8 = r1.c     // Catch:{ all -> 0x0742 }
            int r11 = r7.key     // Catch:{ all -> 0x0742 }
            boolean r8 = r8.e(r11)     // Catch:{ all -> 0x0742 }
            if (r8 != 0) goto L_0x06c8
            r1.a((com.baidu.sofire.core.ApkInfo) r7)     // Catch:{ all -> 0x0742 }
        L_0x06c8:
            int r2 = r2 + 1
            goto L_0x05fb
        L_0x06cc:
            java.util.Timer r2 = new java.util.Timer     // Catch:{ all -> 0x0742 }
            r2.<init>()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.b.a$b r5 = new com.baidu.sofire.b.a$b     // Catch:{ all -> 0x0742 }
            r5.<init>(r3)     // Catch:{ all -> 0x0742 }
            r6 = 120000(0x1d4c0, double:5.9288E-319)
            r2.schedule(r5, r6)     // Catch:{ all -> 0x0742 }
            monitor-exit(r4)     // Catch:{ all -> 0x0742 }
            int r2 = r1.g     // Catch:{ all -> 0x0746 }
            if (r2 != 0) goto L_0x06e5
            r2 = 1
            r1.g = r2     // Catch:{ all -> 0x0746 }
            goto L_0x06e6
        L_0x06e5:
            r2 = 1
        L_0x06e6:
            x = r2     // Catch:{ all -> 0x0746 }
            r2 = 0
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x0746 }
            boolean r2 = r1.h     // Catch:{ all -> 0x06f9 }
            if (r2 == 0) goto L_0x07b1
            boolean r2 = r     // Catch:{ all -> 0x06f9 }
            if (r2 == 0) goto L_0x07b1
            r2 = 0
            r = r2     // Catch:{ all -> 0x06f9 }
            goto L_0x07b1
        L_0x06f9:
            r0 = move-exception
            r2 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x07c7 }
            goto L_0x07b1
        L_0x0700:
            int r2 = r1.f     // Catch:{ all -> 0x0742 }
            r3 = 1
            if (r2 == r3) goto L_0x070a
            if (r2 == r7) goto L_0x070a
            r6 = 3
            if (r2 != r6) goto L_0x0729
        L_0x070a:
            s = r3     // Catch:{ all -> 0x0742 }
            android.content.IntentFilter r2 = new android.content.IntentFilter     // Catch:{ all -> 0x0742 }
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            r2.<init>(r3)     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r3 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0742 }
            if (r3 != 0) goto L_0x0722
            com.baidu.sofire.MyReceiver r3 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0742 }
            r3.<init>()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r3 = r3.a()     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.g = r3     // Catch:{ all -> 0x0742 }
        L_0x0722:
            android.content.Context r3 = r1.a     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.MyReceiver r6 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0742 }
            com.baidu.sofire.l.c.a((android.content.Context) r3, (android.content.BroadcastReceiver) r6, (android.content.IntentFilter) r2)     // Catch:{ all -> 0x0742 }
        L_0x0729:
            int r2 = r1.g     // Catch:{ all -> 0x0742 }
            if (r2 != 0) goto L_0x0730
            r2 = 3
            r1.g = r2     // Catch:{ all -> 0x0742 }
        L_0x0730:
            if (r5 == 0) goto L_0x073a
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0742 }
            java.lang.String r3 = "blocked by Huawei Input"
            r2.<init>(r3)     // Catch:{ all -> 0x0742 }
            throw r2     // Catch:{ all -> 0x0742 }
        L_0x073a:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x0742 }
            java.lang.String r3 = "no internet"
            r2.<init>(r3)     // Catch:{ all -> 0x0742 }
            throw r2     // Catch:{ all -> 0x0742 }
        L_0x0742:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ all -> 0x0742 }
            throw r2     // Catch:{ all -> 0x0746 }
        L_0x0746:
            r0 = move-exception
            r2 = r0
            android.content.Context r3 = r1.a     // Catch:{ all -> 0x07b3 }
            boolean r3 = com.baidu.sofire.l.c.j(r3)     // Catch:{ all -> 0x07b3 }
            if (r3 == 0) goto L_0x075f
            boolean r3 = r2 instanceof java.lang.UnsupportedOperationException     // Catch:{ all -> 0x07b3 }
            if (r3 != 0) goto L_0x0755
            goto L_0x075f
        L_0x0755:
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x07b3 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x07b3 }
            r3.<init>(r2)     // Catch:{ all -> 0x07b3 }
            throw r3     // Catch:{ all -> 0x07b3 }
        L_0x075f:
            com.baidu.sofire.b.c r3 = r1.b     // Catch:{ all -> 0x0765 }
            r3.b()     // Catch:{ all -> 0x0765 }
            goto L_0x076a
        L_0x0765:
            r0 = move-exception
            r3 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x07b3 }
        L_0x076a:
            int r3 = r1.g     // Catch:{ all -> 0x079b }
            if (r3 != 0) goto L_0x0793
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x079b }
            java.lang.String r4 = "response is empty"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x079b }
            if (r3 == 0) goto L_0x077e
            r3 = 7
            r1.g = r3     // Catch:{ all -> 0x079b }
            goto L_0x0793
        L_0x077e:
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x079b }
            java.lang.String r4 = "aes is fail"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x079b }
            if (r3 == 0) goto L_0x078f
            r3 = 8
            r1.g = r3     // Catch:{ all -> 0x079b }
            goto L_0x0793
        L_0x078f:
            r3 = 11
            r1.g = r3     // Catch:{ all -> 0x079b }
        L_0x0793:
            java.lang.String r2 = com.baidu.sofire.a.a.a(r2)     // Catch:{ all -> 0x079b }
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x079b }
            goto L_0x07a0
        L_0x079b:
            r0 = move-exception
            r2 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x07b3 }
        L_0x07a0:
            boolean r2 = r1.h     // Catch:{ all -> 0x07ac }
            if (r2 == 0) goto L_0x07b1
            boolean r2 = r     // Catch:{ all -> 0x07ac }
            if (r2 == 0) goto L_0x07b1
            r2 = 0
            r = r2     // Catch:{ all -> 0x07ac }
            goto L_0x07b1
        L_0x07ac:
            r0 = move-exception
            r2 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x07c7 }
        L_0x07b1:
            monitor-exit(r34)
            return
        L_0x07b3:
            r0 = move-exception
            r2 = r0
            boolean r3 = r1.h     // Catch:{ all -> 0x07c1 }
            if (r3 == 0) goto L_0x07c6
            boolean r3 = r     // Catch:{ all -> 0x07c1 }
            if (r3 == 0) goto L_0x07c6
            r3 = 0
            r = r3     // Catch:{ all -> 0x07c1 }
            goto L_0x07c6
        L_0x07c1:
            r0 = move-exception
            r3 = r0
            com.baidu.sofire.l.c.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x07c7 }
        L_0x07c6:
            throw r2     // Catch:{ all -> 0x07c7 }
        L_0x07c7:
            r0 = move-exception
            r2 = r0
            monitor-exit(r34)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.b():void");
    }

    public a(Context context, int i2, boolean z, JSONObject jSONObject) {
        this.a = context;
        this.c = com.baidu.sofire.c.a.a(context);
        this.e = com.baidu.sofire.j.a.a(context);
        this.b = c.a(context);
        this.d = new File(new File(com.baidu.sofire.l.c.f(context), "sofire_tmp"), ".tmp");
        this.f = i2;
        this.h = z;
        this.f1085o = jSONObject;
    }

    public a() {
    }

    public final void a() {
        try {
            this.f1084i = this.c.c();
            this.n = com.baidu.sofire.l.c.d(this.a);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: com.baidu.sofire.b.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v34, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:113|114|115|116|117|118|119|120|(6:122|123|124|125|(1:127)|128)(12:129|(2:131|(1:133))|134|135|(1:140)(1:139)|141|(2:146|(1:148))|149|(1:151)|152|155|(2:187|(2:189|(2:191|204)(1:203))(1:202))(4:192|(1:197)(1:196)|198|(2:200|201)(1:205)))) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r11 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0357, code lost:
        r15 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x0355 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x041c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x058c A[Catch:{ all -> 0x05f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05a4 A[Catch:{ all -> 0x05f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0627  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.io.File r27, com.baidu.sofire.core.ApkInfo r28, int r29) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "m"
            java.lang.String r5 = "\r"
            java.lang.String r6 = "\t"
            java.lang.String r7 = "\n"
            java.lang.String r8 = "3"
            java.lang.String r9 = "1003106"
            java.lang.String r10 = "2"
            java.lang.String r11 = "1"
            java.lang.String r12 = "0"
            java.lang.String r13 = ""
            java.lang.String r14 = r27.getAbsolutePath()
            r15 = 1
            com.baidu.sofire.l.c.a((java.lang.String) r14, (boolean) r15)
            com.baidu.sofire.j.a r14 = r1.e
            boolean r14 = r14.n()
            if (r14 == 0) goto L_0x0068
            java.io.File r14 = r27.getParentFile()
            boolean r16 = r14.exists()
            if (r16 != 0) goto L_0x0039
            r14.mkdirs()
        L_0x0039:
            java.io.File r15 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r17 = r4
            int r4 = r2.key
            r3.append(r4)
            java.lang.String r4 = "."
            r3.append(r4)
            java.lang.String r4 = r2.versionName
            r3.append(r4)
            java.lang.String r4 = ".b"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r15.<init>(r14, r3)
            com.baidu.sofire.b.l.a((java.io.File) r0, (java.io.File) r15)
            android.content.Context r3 = r1.a
            int r4 = r2.key
            com.baidu.sofire.a.b.a(r3, r4, r0, r15)
            goto L_0x006a
        L_0x0068:
            r17 = r4
        L_0x006a:
            java.lang.String r3 = r27.getAbsolutePath()
            r2.pkgPath = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "before update, time="
            r3.append(r4)
            long r14 = java.lang.System.currentTimeMillis()
            r3.append(r14)
            java.lang.String r14 = ", downloadAPK path:"
            r3.append(r14)
            java.lang.String r14 = r27.getAbsolutePath()
            r3.append(r14)
            java.lang.String r14 = ", exists="
            r3.append(r14)
            boolean r15 = r27.exists()
            r3.append(r15)
            java.lang.String r15 = ", canRead="
            r3.append(r15)
            boolean r0 = r27.canRead()
            r3.append(r0)
            java.lang.String r0 = ", isFile="
            r3.append(r0)
            r18 = r9
            boolean r9 = r27.isFile()
            r3.append(r9)
            java.lang.String r9 = ",length"
            r3.append(r9)
            r19 = r5
            r20 = r6
            long r5 = r27.length()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r4 = r7
            r21 = r8
            long r7 = java.lang.System.currentTimeMillis()
            r6.append(r7)
            java.lang.String r7 = ", "
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            com.baidu.sofire.c.a r6 = r1.c
            int r7 = r2.key
            com.baidu.sofire.core.ApkInfo r6 = r6.b((int) r7)
            if (r6 != 0) goto L_0x00f7
            java.lang.String r6 = "apkInDB == null"
            r5.append(r6)
            goto L_0x013e
        L_0x00f7:
            java.io.File r7 = new java.io.File
            java.lang.String r6 = r6.pkgPath
            r7.<init>(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "origAPK path:"
            r6.append(r8)
            java.lang.String r8 = r7.getAbsolutePath()
            r6.append(r8)
            r6.append(r14)
            boolean r8 = r7.exists()
            r6.append(r8)
            r6.append(r15)
            boolean r8 = r7.canRead()
            r6.append(r8)
            r6.append(r0)
            boolean r8 = r7.isFile()
            r6.append(r8)
            r6.append(r9)
            long r7 = r7.length()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.append(r6)
        L_0x013e:
            com.baidu.sofire.b.c r6 = r1.b
            r5.toString()
            r6.getClass()
            java.io.File r5 = new java.io.File
            java.lang.String r7 = r2.pkgPath
            r5.<init>(r7)
            boolean r22 = com.baidu.sofire.l.c.a((java.io.File) r5)     // Catch:{ all -> 0x056b }
            if (r22 != 0) goto L_0x0223
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0213 }
            r7.<init>()     // Catch:{ all -> 0x0213 }
            r16 = 1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0213 }
            r7.put(r12, r8)     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            r8.<init>()     // Catch:{ all -> 0x0213 }
            int r1 = r2.key     // Catch:{ all -> 0x0213 }
            r8.append(r1)     // Catch:{ all -> 0x0213 }
            r8.append(r13)     // Catch:{ all -> 0x0213 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0213 }
            r7.put(r11, r1)     // Catch:{ all -> 0x0213 }
            java.lang.String r1 = r2.versionName     // Catch:{ all -> 0x0213 }
            r7.put(r10, r1)     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            r1.<init>()     // Catch:{ all -> 0x0213 }
            java.lang.String r8 = "nowTime:"
            r1.append(r8)     // Catch:{ all -> 0x0213 }
            r8 = r10
            r24 = r11
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0205 }
            r1.append(r10)     // Catch:{ all -> 0x0205 }
            java.lang.String r10 = ", nowFileInfo: path="
            r1.append(r10)     // Catch:{ all -> 0x0205 }
            java.lang.String r10 = r5.getAbsolutePath()     // Catch:{ all -> 0x0205 }
            r1.append(r10)     // Catch:{ all -> 0x0205 }
            r1.append(r14)     // Catch:{ all -> 0x0205 }
            boolean r10 = r5.exists()     // Catch:{ all -> 0x0205 }
            r1.append(r10)     // Catch:{ all -> 0x0205 }
            r1.append(r15)     // Catch:{ all -> 0x0205 }
            boolean r10 = r5.canRead()     // Catch:{ all -> 0x0205 }
            r1.append(r10)     // Catch:{ all -> 0x0205 }
            r1.append(r0)     // Catch:{ all -> 0x0205 }
            boolean r0 = r5.isFile()     // Catch:{ all -> 0x0205 }
            r1.append(r0)     // Catch:{ all -> 0x0205 }
            r1.append(r9)     // Catch:{ all -> 0x0205 }
            long r9 = r5.length()     // Catch:{ all -> 0x0205 }
            r1.append(r9)     // Catch:{ all -> 0x0205 }
            java.lang.String r0 = " - "
            r1.append(r0)     // Catch:{ all -> 0x0205 }
            r1.append(r3)     // Catch:{ all -> 0x0205 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0205 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0205 }
            r1 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x0205 }
            java.lang.String r0 = r0.replace(r4, r13)     // Catch:{ all -> 0x0205 }
            r1 = r20
            java.lang.String r0 = r0.replace(r1, r13)     // Catch:{ all -> 0x01ff }
            r3 = r19
            java.lang.String r0 = r0.replace(r3, r13)     // Catch:{ all -> 0x01fb }
            r9 = r21
            r7.put(r9, r0)     // Catch:{ all -> 0x01f6 }
            android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x01f6 }
            r10 = r18
            r11 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r7, (boolean) r11)     // Catch:{ all -> 0x0562 }
            goto L_0x035a
        L_0x01f6:
            r0 = move-exception
            r10 = r18
            goto L_0x0563
        L_0x01fb:
            r0 = move-exception
            r10 = r18
            goto L_0x020c
        L_0x01ff:
            r0 = move-exception
            r10 = r18
            r3 = r19
            goto L_0x020c
        L_0x0205:
            r0 = move-exception
            r10 = r18
            r3 = r19
            r1 = r20
        L_0x020c:
            r18 = r5
            r5 = r6
            r25 = r21
            goto L_0x0568
        L_0x0213:
            r0 = move-exception
            r8 = r10
            r10 = r18
            r3 = r19
            r1 = r20
            r18 = r5
            r5 = r6
            r14 = r11
            r25 = r21
            goto L_0x0579
        L_0x0223:
            r8 = r10
            r24 = r11
            r10 = r18
            r3 = r19
            r1 = r20
            r9 = r21
            com.baidu.sofire.c.a r0 = r6.c     // Catch:{ all -> 0x0562 }
            int r7 = r2.key     // Catch:{ all -> 0x0562 }
            boolean r0 = r0.f(r7)     // Catch:{ all -> 0x0562 }
            if (r0 != 0) goto L_0x023d
            com.baidu.sofire.c.a r0 = r6.c     // Catch:{ all -> 0x0562 }
            r0.a((com.baidu.sofire.core.ApkInfo) r2)     // Catch:{ all -> 0x0562 }
        L_0x023d:
            android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x0562 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0562 }
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.a((android.content.Context) r0)     // Catch:{ all -> 0x0562 }
            int r7 = r2.key     // Catch:{ all -> 0x0562 }
            r11 = 1
            r0.a((int) r7, (boolean) r11)     // Catch:{ all -> 0x0562 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x0562 }
            r6.c(r7)     // Catch:{ all -> 0x0562 }
            boolean r7 = r0.a((com.baidu.sofire.core.ApkInfo) r2, (boolean) r11)     // Catch:{ all -> 0x0562 }
            r11 = 2
            if (r7 != 0) goto L_0x02be
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x02b4 }
            r7.<init>()     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x02b4 }
            r7.put(r12, r11)     // Catch:{ all -> 0x02b4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b4 }
            r11.<init>()     // Catch:{ all -> 0x02b4 }
            int r14 = r2.key     // Catch:{ all -> 0x02b4 }
            r11.append(r14)     // Catch:{ all -> 0x02b4 }
            r11.append(r13)     // Catch:{ all -> 0x02b4 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x02b4 }
            r14 = r24
            r7.put(r14, r11)     // Catch:{ all -> 0x02b0 }
            java.lang.String r11 = r2.versionName     // Catch:{ all -> 0x02b0 }
            r7.put(r8, r11)     // Catch:{ all -> 0x02b0 }
            android.content.Context r11 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x02b0 }
            r15 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r11, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r7, (boolean) r15)     // Catch:{ all -> 0x02b0 }
            com.baidu.sofire.a.b.a(r5)     // Catch:{ all -> 0x02b0 }
            r5.delete()     // Catch:{ all -> 0x02b0 }
            java.io.File r7 = r5.getParentFile()     // Catch:{ all -> 0x02b0 }
            if (r7 == 0) goto L_0x029d
            java.io.File r7 = r5.getParentFile()     // Catch:{ all -> 0x02b0 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x02b0 }
            com.baidu.sofire.l.c.e((java.lang.String) r7)     // Catch:{ all -> 0x02b0 }
        L_0x029d:
            int r7 = r2.key     // Catch:{ all -> 0x02b0 }
            java.lang.String r11 = r2.versionName     // Catch:{ all -> 0x02b0 }
            r18 = r5
            r5 = 1
            r15 = 0
            r6.a((int) r7, (java.lang.String) r11, (boolean) r5, (android.content.pm.PackageInfo) r15)     // Catch:{ all -> 0x055f }
            int r5 = r2.key     // Catch:{ all -> 0x055f }
            r7 = 0
            r0.a((int) r5, (boolean) r7)     // Catch:{ all -> 0x055f }
            goto L_0x035a
        L_0x02b0:
            r0 = move-exception
            r18 = r5
            goto L_0x02b9
        L_0x02b4:
            r0 = move-exception
            r18 = r5
            r14 = r24
        L_0x02b9:
            r5 = r6
            r25 = r9
            goto L_0x0579
        L_0x02be:
            r18 = r5
            r14 = r24
            java.lang.String r5 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.String r7 = "setSecurityVerifyInfo"
            java.lang.String r15 = r2.es     // Catch:{ all -> 0x055f }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x055f }
            java.lang.String r20 = "init"
            if (r15 != 0) goto L_0x031a
            java.lang.String r15 = r2.es     // Catch:{ all -> 0x055f }
            java.lang.String r11 = "#"
            java.lang.String[] r11 = r15.split(r11)     // Catch:{ all -> 0x055f }
            int r15 = r11.length     // Catch:{ all -> 0x055f }
            r24 = r5
            r5 = 4
            if (r15 < r5) goto L_0x031c
            r5 = 1
            r15 = r11[r5]     // Catch:{ all -> 0x055f }
            java.lang.String r5 = "c"
            boolean r5 = r15.startsWith(r5)     // Catch:{ all -> 0x055f }
            if (r5 == 0) goto L_0x02f2
            r5 = 1
            r15 = r11[r5]     // Catch:{ all -> 0x055f }
            java.lang.String r15 = r15.substring(r5)     // Catch:{ all -> 0x055f }
            r24 = r15
        L_0x02f2:
            r15 = 2
            r5 = r11[r15]     // Catch:{ all -> 0x055f }
            r15 = r17
            boolean r5 = r5.startsWith(r15)     // Catch:{ all -> 0x055f }
            if (r5 == 0) goto L_0x0305
            r5 = 2
            r7 = r11[r5]     // Catch:{ all -> 0x055f }
            r5 = 1
            java.lang.String r7 = r7.substring(r5)     // Catch:{ all -> 0x055f }
        L_0x0305:
            r17 = r7
            r5 = 3
            r7 = r11[r5]     // Catch:{ all -> 0x055f }
            boolean r7 = r7.startsWith(r15)     // Catch:{ all -> 0x055f }
            if (r7 == 0) goto L_0x0317
            r7 = r11[r5]     // Catch:{ all -> 0x055f }
            r5 = 1
            java.lang.String r20 = r7.substring(r5)     // Catch:{ all -> 0x055f }
        L_0x0317:
            r7 = r17
            goto L_0x031c
        L_0x031a:
            r24 = r5
        L_0x031c:
            r11 = r20
            r5 = r24
            android.content.Context r15 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x055f }
            java.lang.String[] r15 = com.baidu.sofire.l.c.p(r15)     // Catch:{ all -> 0x055f }
            r17 = r6
            int r6 = r15.length     // Catch:{ all -> 0x0559 }
            r20 = r11
            r11 = 2
            if (r6 != r11) goto L_0x0345
            r6 = 0
            r11 = r15[r6]     // Catch:{ all -> 0x0559 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0559 }
            if (r11 != 0) goto L_0x0345
            r11 = 1
            r16 = r15[r11]     // Catch:{ all -> 0x0559 }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x0559 }
            if (r16 != 0) goto L_0x0345
            r24 = r15[r6]     // Catch:{ all -> 0x0559 }
            r6 = r15[r11]     // Catch:{ all -> 0x0559 }
            goto L_0x0349
        L_0x0345:
            java.lang.String r6 = "925fc15df8a49bed0b3eca8d2b44cb7b"
            r24 = r9
        L_0x0349:
            java.lang.String r11 = r2.pkgPath     // Catch:{ all -> 0x0559 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r15 = r0.c     // Catch:{ all -> 0x0355 }
            java.lang.Object r11 = r15.get(r11)     // Catch:{ all -> 0x0355 }
            com.baidu.sofire.core.ApkInfo r11 = (com.baidu.sofire.core.ApkInfo) r11     // Catch:{ all -> 0x0355 }
            r15 = r11
            goto L_0x0358
        L_0x0355:
            int r11 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0559 }
            r15 = 0
        L_0x0358:
            if (r15 != 0) goto L_0x035d
        L_0x035a:
            r1 = 0
            goto L_0x05f8
        L_0x035d:
            java.lang.ClassLoader r11 = r15.classLoader     // Catch:{ all -> 0x0553 }
            com.baidu.sofire.b.i r11 = (com.baidu.sofire.b.i) r11     // Catch:{ all -> 0x0553 }
            java.lang.Class r5 = r11.a(r5)     // Catch:{ all -> 0x0553 }
            if (r5 != 0) goto L_0x03e9
            java.lang.String r5 = "java.lang.String"
            java.lang.Class r5 = r11.a(r5)     // Catch:{ all -> 0x0553 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0553 }
            r6.<init>()     // Catch:{ all -> 0x0553 }
            r7 = 6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0553 }
            r6.put(r12, r7)     // Catch:{ all -> 0x0553 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0553 }
            r7.<init>()     // Catch:{ all -> 0x0553 }
            int r2 = r15.key     // Catch:{ all -> 0x0553 }
            r7.append(r2)     // Catch:{ all -> 0x0553 }
            r7.append(r13)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0553 }
            r6.put(r14, r2)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r15.versionName     // Catch:{ all -> 0x0553 }
            r6.put(r8, r2)     // Catch:{ all -> 0x0553 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0553 }
            r2.<init>()     // Catch:{ all -> 0x0553 }
            java.lang.String r7 = "classloader="
            r2.append(r7)     // Catch:{ all -> 0x0553 }
            r2.append(r11)     // Catch:{ all -> 0x0553 }
            java.lang.String r7 = ",StringClass="
            r2.append(r7)     // Catch:{ all -> 0x0553 }
            r2.append(r5)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0553 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0553 }
            r5 = 0
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r5)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r2.replace(r4, r13)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r2.replace(r1, r13)     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r2.replace(r3, r13)     // Catch:{ all -> 0x0553 }
            r6.put(r9, r2)     // Catch:{ all -> 0x0553 }
            android.content.Context r2 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x0553 }
            r5 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r6, (boolean) r5)     // Catch:{ all -> 0x0553 }
            com.baidu.sofire.a.b.a(r18)     // Catch:{ all -> 0x0553 }
            r18.delete()     // Catch:{ all -> 0x0553 }
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x0553 }
            if (r2 == 0) goto L_0x03e1
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x0553 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0553 }
            com.baidu.sofire.l.c.e((java.lang.String) r2)     // Catch:{ all -> 0x0553 }
        L_0x03e1:
            int r2 = r15.key     // Catch:{ all -> 0x0553 }
            r5 = 0
            r0.a((int) r2, (boolean) r5)     // Catch:{ all -> 0x0553 }
            goto L_0x035a
        L_0x03e9:
            java.lang.String r2 = "getInstance"
            r25 = r9
            r11 = 1
            java.lang.Class[] r9 = new java.lang.Class[r11]     // Catch:{ all -> 0x0551 }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r23 = 0
            r9[r23] = r16     // Catch:{ all -> 0x0551 }
            java.lang.reflect.Method r2 = r5.getDeclaredMethod(r2, r9)     // Catch:{ all -> 0x0551 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x0551 }
            android.content.Context r11 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x0551 }
            r9[r23] = r11     // Catch:{ all -> 0x0551 }
            java.lang.Object r2 = r2.invoke(r5, r9)     // Catch:{ all -> 0x0551 }
            r5 = 2
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ all -> 0x041c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r9[r23] = r5     // Catch:{ all -> 0x041c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r11 = 1
            r9[r11] = r5     // Catch:{ all -> 0x041c }
            r5 = 2
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x041c }
            r11[r23] = r24     // Catch:{ all -> 0x041c }
            r5 = 1
            r11[r5] = r6     // Catch:{ all -> 0x041c }
            com.baidu.sofire.l.c.a((java.lang.Object) r2, (java.lang.String) r7, (java.lang.Class<?>[]) r9, (java.lang.Object[]) r11)     // Catch:{ all -> 0x041c }
            goto L_0x041e
        L_0x041c:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0551 }
        L_0x041e:
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0551 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0551 }
            r7 = 0
            r6[r7] = r5     // Catch:{ all -> 0x0551 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0551 }
            r9 = 1
            r6[r9] = r5     // Catch:{ all -> 0x0551 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0551 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0551 }
            r5[r7] = r9     // Catch:{ all -> 0x0551 }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0551 }
            r9 = 1
            r5[r9] = r7     // Catch:{ all -> 0x0551 }
            r7 = r20
            java.lang.Object r2 = com.baidu.sofire.l.c.a((java.lang.Object) r2, (java.lang.String) r7, (java.lang.Class<?>[]) r6, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0551 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0551 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0551 }
            if (r2 != 0) goto L_0x04a2
            com.baidu.sofire.a.b.a(r18)     // Catch:{ all -> 0x0551 }
            java.lang.String r2 = r15.packageName     // Catch:{ all -> 0x0551 }
            r5 = r17
            r5.c(r2)     // Catch:{ all -> 0x054f }
            r18.delete()     // Catch:{ all -> 0x054f }
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x054f }
            if (r2 == 0) goto L_0x0465
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x054f }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x054f }
            com.baidu.sofire.l.c.e((java.lang.String) r2)     // Catch:{ all -> 0x054f }
        L_0x0465:
            int r2 = r15.key     // Catch:{ all -> 0x054f }
            java.lang.String r6 = r15.versionName     // Catch:{ all -> 0x054f }
            r7 = 0
            r9 = 1
            r5.a((int) r2, (java.lang.String) r6, (boolean) r9, (android.content.pm.PackageInfo) r7)     // Catch:{ all -> 0x054f }
            int r2 = r15.key     // Catch:{ all -> 0x054f }
            r6 = 0
            r0.a((int) r2, (boolean) r6)     // Catch:{ all -> 0x054f }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x054f }
            r0.<init>()     // Catch:{ all -> 0x054f }
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x054f }
            r0.put(r12, r2)     // Catch:{ all -> 0x054f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x054f }
            r2.<init>()     // Catch:{ all -> 0x054f }
            int r6 = r15.key     // Catch:{ all -> 0x054f }
            r2.append(r6)     // Catch:{ all -> 0x054f }
            r2.append(r13)     // Catch:{ all -> 0x054f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x054f }
            r0.put(r14, r2)     // Catch:{ all -> 0x054f }
            java.lang.String r2 = r15.versionName     // Catch:{ all -> 0x054f }
            r0.put(r8, r2)     // Catch:{ all -> 0x054f }
            android.content.Context r2 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x054f }
            r6 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r6)     // Catch:{ all -> 0x054f }
            goto L_0x035a
        L_0x04a2:
            r5 = r17
            boolean r0 = r15.isMem     // Catch:{ all -> 0x054f }
            if (r0 == 0) goto L_0x04c0
            com.baidu.sofire.a.b.a(r18)     // Catch:{ all -> 0x054f }
            r18.delete()     // Catch:{ all -> 0x054f }
            java.lang.String r0 = r15.dataDir     // Catch:{ all -> 0x054f }
            com.baidu.sofire.l.c.e((java.lang.String) r0)     // Catch:{ all -> 0x054f }
            java.util.List<java.lang.Integer> r0 = com.baidu.sofire.b.j.j     // Catch:{ all -> 0x054f }
            if (r0 == 0) goto L_0x04c0
            int r2 = r15.key     // Catch:{ all -> 0x054f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x054f }
            r0.add(r2)     // Catch:{ all -> 0x054f }
        L_0x04c0:
            com.baidu.sofire.c.a r0 = r5.c     // Catch:{ all -> 0x054a }
            int r1 = r15.key     // Catch:{ all -> 0x054a }
            com.baidu.sofire.core.ApkInfo r0 = r0.b((int) r1)     // Catch:{ all -> 0x054a }
            if (r0 == 0) goto L_0x04dd
            java.lang.String r1 = r0.versionName     // Catch:{ all -> 0x054a }
            java.lang.String r2 = r15.versionName     // Catch:{ all -> 0x054a }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x054a }
            if (r1 != 0) goto L_0x04dd
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x054a }
            java.lang.String r0 = r0.pkgPath     // Catch:{ all -> 0x054a }
            r7.<init>(r0)     // Catch:{ all -> 0x054a }
            r1 = 1
            goto L_0x04df
        L_0x04dd:
            r1 = 1
            r7 = 0
        L_0x04df:
            r15.initStatus = r1     // Catch:{ all -> 0x054a }
            r15.apkParseSuc = r1     // Catch:{ all -> 0x054a }
            com.baidu.sofire.c.a r0 = r5.c     // Catch:{ all -> 0x054a }
            long r0 = r0.a((com.baidu.sofire.core.ApkInfo) r15)     // Catch:{ all -> 0x054a }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x050e
            if (r7 == 0) goto L_0x050e
            boolean r0 = r7.exists()     // Catch:{ all -> 0x054a }
            if (r0 == 0) goto L_0x050e
            com.baidu.sofire.a.b.a(r7)     // Catch:{ all -> 0x054a }
            r7.delete()     // Catch:{ all -> 0x054a }
            java.io.File r0 = r7.getParentFile()     // Catch:{ all -> 0x054a }
            if (r0 == 0) goto L_0x050e
            java.io.File r0 = r7.getParentFile()     // Catch:{ all -> 0x054a }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x054a }
            com.baidu.sofire.l.c.e((java.lang.String) r0)     // Catch:{ all -> 0x054a }
        L_0x050e:
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x054a }
            if (r0 == 0) goto L_0x0518
            int r1 = r15.key     // Catch:{ all -> 0x054a }
            r2 = 0
            r0.a((int) r1, (boolean) r2)     // Catch:{ all -> 0x054a }
        L_0x0518:
            android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x054a }
            com.baidu.sofire.l.c.q(r0)     // Catch:{ all -> 0x054a }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x054a }
            r0.<init>()     // Catch:{ all -> 0x054a }
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x054a }
            r0.put(r12, r2)     // Catch:{ all -> 0x054a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x054a }
            r1.<init>()     // Catch:{ all -> 0x054a }
            int r2 = r15.key     // Catch:{ all -> 0x054a }
            r1.append(r2)     // Catch:{ all -> 0x054a }
            r1.append(r13)     // Catch:{ all -> 0x054a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x054a }
            r0.put(r14, r1)     // Catch:{ all -> 0x054a }
            java.lang.String r1 = r15.versionName     // Catch:{ all -> 0x054a }
            r0.put(r8, r1)     // Catch:{ all -> 0x054a }
            android.content.Context r1 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x054a }
            r2 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r1, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r2)     // Catch:{ all -> 0x054a }
            goto L_0x054c
        L_0x054a:
            int r0 = com.baidu.sofire.a.a.a
        L_0x054c:
            r8 = 1
            goto L_0x05f9
        L_0x054f:
            r0 = move-exception
            goto L_0x057b
        L_0x0551:
            r0 = move-exception
            goto L_0x0556
        L_0x0553:
            r0 = move-exception
            r25 = r9
        L_0x0556:
            r5 = r17
            goto L_0x057b
        L_0x0559:
            r0 = move-exception
            r25 = r9
            r5 = r17
            goto L_0x0579
        L_0x055f:
            r0 = move-exception
            goto L_0x02b9
        L_0x0562:
            r0 = move-exception
        L_0x0563:
            r18 = r5
            r5 = r6
            r25 = r9
        L_0x0568:
            r14 = r24
            goto L_0x0579
        L_0x056b:
            r0 = move-exception
            r8 = r10
            r14 = r11
            r10 = r18
            r3 = r19
            r1 = r20
            r25 = r21
            r18 = r5
            r5 = r6
        L_0x0579:
            r15 = r28
        L_0x057b:
            com.baidu.sofire.a.b.a(r18)     // Catch:{ all -> 0x05f5 }
            java.lang.String r2 = r15.packageName     // Catch:{ all -> 0x05f5 }
            r5.c(r2)     // Catch:{ all -> 0x05f5 }
            r18.delete()     // Catch:{ all -> 0x05f5 }
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x05f5 }
            if (r2 == 0) goto L_0x0597
            java.io.File r2 = r18.getParentFile()     // Catch:{ all -> 0x05f5 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x05f5 }
            com.baidu.sofire.l.c.e((java.lang.String) r2)     // Catch:{ all -> 0x05f5 }
        L_0x0597:
            int r2 = r15.key     // Catch:{ all -> 0x05f5 }
            java.lang.String r6 = r15.versionName     // Catch:{ all -> 0x05f5 }
            r7 = 0
            r9 = 1
            r5.a((int) r2, (java.lang.String) r6, (boolean) r9, (android.content.pm.PackageInfo) r7)     // Catch:{ all -> 0x05f5 }
            com.baidu.sofire.b.j r2 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x05f5 }
            if (r2 == 0) goto L_0x05aa
            int r5 = r15.key     // Catch:{ all -> 0x05f5 }
            r6 = 0
            r2.a((int) r5, (boolean) r6)     // Catch:{ all -> 0x05f5 }
        L_0x05aa:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x05f5 }
            r2.<init>()     // Catch:{ all -> 0x05f5 }
            r5 = 5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x05f5 }
            r2.put(r12, r6)     // Catch:{ all -> 0x05f5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x05f5 }
            r5.<init>()     // Catch:{ all -> 0x05f5 }
            int r6 = r15.key     // Catch:{ all -> 0x05f5 }
            r5.append(r6)     // Catch:{ all -> 0x05f5 }
            r5.append(r13)     // Catch:{ all -> 0x05f5 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x05f5 }
            r2.put(r14, r5)     // Catch:{ all -> 0x05f5 }
            java.lang.String r5 = r15.versionName     // Catch:{ all -> 0x05f5 }
            r2.put(r8, r5)     // Catch:{ all -> 0x05f5 }
            java.lang.String r0 = com.baidu.sofire.a.a.a(r0)     // Catch:{ all -> 0x05f5 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x05f5 }
            r5 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ all -> 0x05f5 }
            java.lang.String r0 = r0.replace(r4, r13)     // Catch:{ all -> 0x05f5 }
            java.lang.String r0 = r0.replace(r1, r13)     // Catch:{ all -> 0x05f5 }
            java.lang.String r0 = r0.replace(r3, r13)     // Catch:{ all -> 0x05f5 }
            r1 = r25
            r2.put(r1, r0)     // Catch:{ all -> 0x05f5 }
            android.content.Context r0 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x05f5 }
            r1 = 0
            com.baidu.sofire.l.c.a((android.content.Context) r0, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r2, (boolean) r1)     // Catch:{ all -> 0x05f6 }
            goto L_0x05f8
        L_0x05f5:
            r1 = 0
        L_0x05f6:
            int r0 = com.baidu.sofire.a.a.a
        L_0x05f8:
            r8 = 0
        L_0x05f9:
            if (r8 != 0) goto L_0x0627
            r1 = r26
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r0 = r1.m
            if (r0 == 0) goto L_0x0658
            java.util.Set r0 = r0.keySet()
            r2 = r28
            int r3 = r2.key
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0658
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r0 = r1.m
            int r2 = r2.key
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.baidu.sofire.b.a$c r3 = new com.baidu.sofire.b.a$c
            r4 = r29
            r5 = 5
            r3.<init>(r1, r4, r5)
            r0.put(r2, r3)
            goto L_0x0658
        L_0x0627:
            r1 = r26
            r2 = r28
            r4 = r29
            com.baidu.sofire.c.a r0 = r1.c
            int r3 = r2.key
            int r0 = r0.c(r3)
            r3 = 3
            if (r0 >= r3) goto L_0x0645
            r3 = -1
            if (r0 == r3) goto L_0x0645
            com.baidu.sofire.c.a r3 = r1.c
            int r5 = r2.key
            r6 = 1
            int r0 = r0 + r6
            r3.b(r5, r0)
            goto L_0x0646
        L_0x0645:
            r6 = 1
        L_0x0646:
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r0 = r1.m
            if (r0 == 0) goto L_0x0658
            int r2 = r2.key
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.baidu.sofire.b.a$c r3 = new com.baidu.sofire.b.a$c
            r3.<init>(r1, r4, r6)
            r0.put(r2, r3)
        L_0x0658:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(java.io.File, com.baidu.sofire.core.ApkInfo, int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065 A[Catch:{ all -> 0x00c4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.baidu.sofire.core.ApkInfo r7, java.io.File r8, java.io.File r9, int r10) {
        /*
            r6 = this;
            r0 = 0
            boolean r1 = r8.exists()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x000a
            r8.delete()     // Catch:{ all -> 0x00c4 }
        L_0x000a:
            java.lang.String r1 = "com.baidu.input_huawei"
            android.content.Context r2 = r6.a     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x00c4 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x0021
            com.baidu.sofire.j.a r1 = r6.e     // Catch:{ all -> 0x00c4 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.String r1 = r7.downloadURL     // Catch:{ all -> 0x00c4 }
            boolean r1 = r6.a(r1, r8)     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x008c
            boolean r2 = r9.exists()     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x0032
            r9.delete()     // Catch:{ all -> 0x00c4 }
        L_0x0032:
            com.baidu.sofire.jni.Asc r2 = new com.baidu.sofire.jni.Asc     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = r7.signMD5     // Catch:{ all -> 0x00c4 }
            int r2 = r2.length()     // Catch:{ all -> 0x00c4 }
            java.lang.String r3 = r7.signMD5     // Catch:{ all -> 0x00c4 }
            int r2 = r2 / 2
            java.lang.String r2 = r3.substring(r0, r2)     // Catch:{ all -> 0x00c4 }
            java.lang.String r3 = "utf-8"
            byte[] r2 = r2.getBytes(r3)     // Catch:{ all -> 0x00c4 }
            com.baidu.sofire.jni.Asc r3 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x0062
            int r3 = r2.length     // Catch:{ all -> 0x0060 }
            if (r3 <= 0) goto L_0x0062
            com.baidu.sofire.jni.Asc r3 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0062
            java.lang.String r4 = r8.getAbsolutePath()     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = r9.getAbsolutePath()     // Catch:{ all -> 0x0060 }
            int r2 = r3.df(r4, r5, r2)     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00c4 }
        L_0x0062:
            r2 = -1
        L_0x0063:
            if (r2 == 0) goto L_0x00b1
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r1 = r6.m     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x008a
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x00c4 }
            int r2 = r7.key     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c4 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x008a
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r1 = r6.m     // Catch:{ all -> 0x00c4 }
            int r2 = r7.key     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c4 }
            com.baidu.sofire.b.a$c r3 = new com.baidu.sofire.b.a$c     // Catch:{ all -> 0x00c4 }
            r4 = 7
            r3.<init>(r6, r10, r4)     // Catch:{ all -> 0x00c4 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00c4 }
        L_0x008a:
            r1 = 0
            goto L_0x00b1
        L_0x008c:
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r2 = r6.m     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00b1
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x00c4 }
            int r3 = r7.key     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c4 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x00c4 }
            if (r2 != 0) goto L_0x00b1
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r2 = r6.m     // Catch:{ all -> 0x00c4 }
            int r3 = r7.key     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c4 }
            com.baidu.sofire.b.a$c r4 = new com.baidu.sofire.b.a$c     // Catch:{ all -> 0x00c4 }
            r5 = 4
            r4.<init>(r6, r10, r5)     // Catch:{ all -> 0x00c4 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00c4 }
        L_0x00b1:
            java.lang.String r9 = com.baidu.sofire.l.k.a((java.io.File) r9)     // Catch:{ all -> 0x00c4 }
            r8.delete()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00c6
            java.lang.String r7 = r7.apkMD5     // Catch:{ all -> 0x00c4 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00c4 }
            if (r7 == 0) goto L_0x00c6
            r7 = 1
            return r7
        L_0x00c4:
            int r7 = com.baidu.sofire.a.a.a
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(com.baidu.sofire.core.ApkInfo, java.io.File, java.io.File, int):boolean");
    }

    public final void a(ApkInfo apkInfo, File file, int i2, List<Integer> list) {
        Map<Integer, c> map = this.m;
        if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
            this.m.put(Integer.valueOf(apkInfo.key), new c(this, i2, 4));
        }
        int i3 = this.f;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            if (list.contains(Integer.valueOf(apkInfo.key)) && !v) {
                v = true;
                l.a(this.a, u, false);
                u++;
            }
            if (!s) {
                IntentFilter intentFilter = new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                MyReceiver myReceiver = com.baidu.sofire.l.c.g;
                if (myReceiver == null) {
                    com.baidu.sofire.l.c.g = new MyReceiver().a();
                } else {
                    myReceiver.a();
                }
                com.baidu.sofire.l.c.a(this.a, (BroadcastReceiver) com.baidu.sofire.l.c.g, intentFilter);
                s = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.j.a aVar = this.e;
        long j2 = aVar.a.getLong("pu_ap_fd", 0);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            aVar.b.putLong("pu_ap_fd", System.currentTimeMillis());
            aVar.b.commit();
        }
        if (currentTimeMillis - j2 > 86400000) {
            HashMap hashMap = new HashMap();
            if (com.baidu.sofire.l.c.m(this.a)) {
                hashMap.put("0", Integer.valueOf(this.e.i() + 1));
                hashMap.put("1", Integer.valueOf(this.e.h()));
            } else {
                hashMap.put("0", Integer.valueOf(this.e.i()));
                hashMap.put("1", Integer.valueOf(this.e.h() + 1));
            }
            this.e.c(0);
            this.e.b(0);
            com.baidu.sofire.j.a aVar2 = this.e;
            aVar2.b.putLong("pu_ap_fd", System.currentTimeMillis());
            aVar2.b.commit();
            com.baidu.sofire.l.c.a(this.a, "1003116", (Map<String, Object>) hashMap, false);
        } else if (com.baidu.sofire.l.c.m(this.a)) {
            com.baidu.sofire.j.a aVar3 = this.e;
            aVar3.c(aVar3.i() + 1);
        } else {
            com.baidu.sofire.j.a aVar4 = this.e;
            aVar4.b(aVar4.h() + 1);
        }
        file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0138, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r4 = r10.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014f, code lost:
        r10.m.put(java.lang.Integer.valueOf(r11.key), new com.baidu.sofire.b.a.c(r10, com.baidu.sofire.l.c.d(r10.a), 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0166, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r4 = r10.e.e();
        r5 = r10.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0170, code lost:
        if (r5 == 1) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0188, code lost:
        v = true;
        com.baidu.sofire.b.l.a(r10.a, u, false);
        u++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0198, code lost:
        if (s == false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019a, code lost:
        r11 = new android.content.IntentFilter(io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        r0 = com.baidu.sofire.l.c.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a3, code lost:
        if (r0 == null) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a5, code lost:
        com.baidu.sofire.l.c.g = new com.baidu.sofire.MyReceiver().a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b1, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b4, code lost:
        com.baidu.sofire.l.c.a(r10.a, (android.content.BroadcastReceiver) com.baidu.sofire.l.c.g, r11);
        s = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01be, code lost:
        r11 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ef A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5 A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa A[Catch:{ all -> 0x0138 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.baidu.sofire.core.ApkInfo r11) {
        /*
            r10 = this;
            r0 = 3
            r1 = 0
            r2 = 1
            android.content.Context r3 = r10.a     // Catch:{ all -> 0x0138 }
            int r3 = com.baidu.sofire.l.c.d((android.content.Context) r3)     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.j.a r4 = r10.e     // Catch:{ all -> 0x0138 }
            java.util.List r4 = r4.e()     // Catch:{ all -> 0x0138 }
            int r5 = r11.key     // Catch:{ all -> 0x0138 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0138 }
            r6 = r4
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            boolean r5 = r6.contains(r5)     // Catch:{ all -> 0x0138 }
            if (r5 != 0) goto L_0x0071
            android.content.Context r5 = r10.a     // Catch:{ all -> 0x0138 }
            int r6 = r11.network     // Catch:{ all -> 0x0138 }
            if (r6 != r2) goto L_0x0049
            boolean r6 = com.baidu.sofire.l.c.m(r5)     // Catch:{ all -> 0x0138 }
            if (r6 != 0) goto L_0x0049
            android.content.IntentFilter r6 = new android.content.IntentFilter     // Catch:{ all -> 0x0138 }
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.<init>(r7)     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.MyReceiver r7 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0138 }
            if (r7 != 0) goto L_0x0040
            com.baidu.sofire.MyReceiver r7 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0138 }
            r7.<init>()     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.MyReceiver r7 = r7.a()     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.l.c.g = r7     // Catch:{ all -> 0x0138 }
        L_0x0040:
            com.baidu.sofire.MyReceiver r7 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.l.c.a((android.content.Context) r5, (android.content.BroadcastReceiver) r7, (android.content.IntentFilter) r6)     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.l.c.b = r2     // Catch:{ all -> 0x0138 }
            r5 = 0
            goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            if (r5 != 0) goto L_0x0071
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r4 = r10.m     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x0070
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0138 }
            int r5 = r11.key     // Catch:{ all -> 0x0138 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0138 }
            boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0138 }
            if (r4 != 0) goto L_0x0070
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r4 = r10.m     // Catch:{ all -> 0x0138 }
            int r5 = r11.key     // Catch:{ all -> 0x0138 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.b.a$c r6 = new com.baidu.sofire.b.a$c     // Catch:{ all -> 0x0138 }
            r6.<init>(r10, r3, r0)     // Catch:{ all -> 0x0138 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0138 }
        L_0x0070:
            return
        L_0x0071:
            java.io.File r5 = r10.d     // Catch:{ all -> 0x0138 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x0138 }
            if (r5 != 0) goto L_0x007e
            java.io.File r5 = r10.d     // Catch:{ all -> 0x0138 }
            r5.mkdirs()     // Catch:{ all -> 0x0138 }
        L_0x007e:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0138 }
            java.io.File r6 = r10.d     // Catch:{ all -> 0x0138 }
            java.lang.String r7 = com.baidu.sofire.l.v.a()     // Catch:{ all -> 0x0138 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0138 }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x0138 }
            if (r6 != 0) goto L_0x0092
            r5.mkdirs()     // Catch:{ all -> 0x0138 }
        L_0x0092:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0138 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            r7.<init>()     // Catch:{ all -> 0x0138 }
            int r8 = r11.key     // Catch:{ all -> 0x0138 }
            r7.append(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = "."
            r7.append(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = r11.versionName     // Catch:{ all -> 0x0138 }
            r7.append(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = ".t"
            r7.append(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0138 }
            r6.<init>(r5, r7)     // Catch:{ all -> 0x0138 }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0138 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            r8.<init>()     // Catch:{ all -> 0x0138 }
            int r9 = r11.key     // Catch:{ all -> 0x0138 }
            r8.append(r9)     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = "."
            r8.append(r9)     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = r11.versionName     // Catch:{ all -> 0x0138 }
            r8.append(r9)     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = ".p"
            r8.append(r9)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0138 }
            r7.<init>(r5, r8)     // Catch:{ all -> 0x0138 }
            boolean r8 = r7.exists()     // Catch:{ all -> 0x0138 }
            if (r8 == 0) goto L_0x00eb
            java.lang.String r8 = com.baidu.sofire.l.k.a((java.io.File) r7)     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = r11.apkMD5     // Catch:{ all -> 0x0138 }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0138 }
            if (r8 == 0) goto L_0x00eb
            r8 = 0
            r9 = 1
            goto L_0x00ed
        L_0x00eb:
            r8 = 1
            r9 = 0
        L_0x00ed:
            if (r8 == 0) goto L_0x00f3
            boolean r9 = r10.a((com.baidu.sofire.core.ApkInfo) r11, (java.io.File) r6, (java.io.File) r7, (int) r3)     // Catch:{ all -> 0x0138 }
        L_0x00f3:
            if (r9 == 0) goto L_0x00fa
            r10.a(r7, r11, r3)     // Catch:{ all -> 0x0138 }
            goto L_0x01c0
        L_0x00fa:
            boolean r6 = r5.isDirectory()     // Catch:{ all -> 0x0138 }
            if (r6 == 0) goto L_0x0107
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.l.c.e((java.lang.String) r5)     // Catch:{ all -> 0x0138 }
        L_0x0107:
            android.content.Context r5 = r10.a     // Catch:{ all -> 0x0138 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.b.j r5 = com.baidu.sofire.b.j.a((android.content.Context) r5)     // Catch:{ all -> 0x0138 }
            java.lang.String r6 = r11.packageName     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.core.ApkInfo r5 = r5.b((java.lang.String) r6)     // Catch:{ all -> 0x0138 }
            if (r5 != 0) goto L_0x0133
            com.baidu.sofire.c.a r5 = r10.c     // Catch:{ all -> 0x0138 }
            int r6 = r11.key     // Catch:{ all -> 0x0138 }
            com.baidu.sofire.core.ApkInfo r5 = r5.b((int) r6)     // Catch:{ all -> 0x0138 }
            if (r5 == 0) goto L_0x0133
            com.baidu.sofire.b.c r6 = r10.b     // Catch:{ all -> 0x0138 }
            int r8 = r5.key     // Catch:{ all -> 0x0138 }
            java.lang.String r5 = r5.versionName     // Catch:{ all -> 0x0138 }
            r9 = 0
            monitor-enter(r6)     // Catch:{ all -> 0x0138 }
            r6.a((int) r8, (java.lang.String) r5, (boolean) r1, (android.content.pm.PackageInfo) r9)     // Catch:{ all -> 0x0130 }
            monitor-exit(r6)     // Catch:{ all -> 0x0138 }
            goto L_0x0133
        L_0x0130:
            r3 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0138 }
            throw r3     // Catch:{ all -> 0x0138 }
        L_0x0133:
            r10.a((com.baidu.sofire.core.ApkInfo) r11, (java.io.File) r7, (int) r3, (java.util.List<java.lang.Integer>) r4)     // Catch:{ all -> 0x0138 }
            goto L_0x01c0
        L_0x0138:
            int r3 = com.baidu.sofire.a.a.a
            r3 = 2
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r4 = r10.m     // Catch:{ all -> 0x0166 }
            if (r4 == 0) goto L_0x0168
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0166 }
            int r5 = r11.key     // Catch:{ all -> 0x0166 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0166 }
            boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0166 }
            if (r4 != 0) goto L_0x0168
            android.content.Context r4 = r10.a     // Catch:{ all -> 0x0166 }
            int r4 = com.baidu.sofire.l.c.d((android.content.Context) r4)     // Catch:{ all -> 0x0166 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.b.a$c> r5 = r10.m     // Catch:{ all -> 0x0166 }
            int r6 = r11.key     // Catch:{ all -> 0x0166 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0166 }
            com.baidu.sofire.b.a$c r7 = new com.baidu.sofire.b.a$c     // Catch:{ all -> 0x0166 }
            r7.<init>(r10, r4, r3)     // Catch:{ all -> 0x0166 }
            r5.put(r6, r7)     // Catch:{ all -> 0x0166 }
            goto L_0x0168
        L_0x0166:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0168:
            com.baidu.sofire.j.a r4 = r10.e     // Catch:{ all -> 0x01be }
            java.util.List r4 = r4.e()     // Catch:{ all -> 0x01be }
            int r5 = r10.f     // Catch:{ all -> 0x01be }
            if (r5 == r2) goto L_0x0176
            if (r5 == r3) goto L_0x0176
            if (r5 != r0) goto L_0x01c0
        L_0x0176:
            int r11 = r11.key     // Catch:{ all -> 0x01be }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01be }
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            boolean r11 = r4.contains(r11)     // Catch:{ all -> 0x01be }
            if (r11 == 0) goto L_0x0196
            boolean r11 = v     // Catch:{ all -> 0x01be }
            if (r11 != 0) goto L_0x0196
            v = r2     // Catch:{ all -> 0x01be }
            android.content.Context r11 = r10.a     // Catch:{ all -> 0x01be }
            int r0 = u     // Catch:{ all -> 0x01be }
            com.baidu.sofire.b.l.a((android.content.Context) r11, (int) r0, (boolean) r1)     // Catch:{ all -> 0x01be }
            int r11 = u     // Catch:{ all -> 0x01be }
            int r11 = r11 + r2
            u = r11     // Catch:{ all -> 0x01be }
        L_0x0196:
            boolean r11 = s     // Catch:{ all -> 0x01be }
            if (r11 != 0) goto L_0x01c0
            android.content.IntentFilter r11 = new android.content.IntentFilter     // Catch:{ all -> 0x01be }
            java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
            r11.<init>(r0)     // Catch:{ all -> 0x01be }
            com.baidu.sofire.MyReceiver r0 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x01be }
            if (r0 != 0) goto L_0x01b1
            com.baidu.sofire.MyReceiver r0 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x01be }
            r0.<init>()     // Catch:{ all -> 0x01be }
            com.baidu.sofire.MyReceiver r0 = r0.a()     // Catch:{ all -> 0x01be }
            com.baidu.sofire.l.c.g = r0     // Catch:{ all -> 0x01be }
            goto L_0x01b4
        L_0x01b1:
            r0.a()     // Catch:{ all -> 0x01be }
        L_0x01b4:
            android.content.Context r0 = r10.a     // Catch:{ all -> 0x01be }
            com.baidu.sofire.MyReceiver r1 = com.baidu.sofire.l.c.g     // Catch:{ all -> 0x01be }
            com.baidu.sofire.l.c.a((android.content.Context) r0, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r11)     // Catch:{ all -> 0x01be }
            s = r2     // Catch:{ all -> 0x01be }
            goto L_0x01c0
        L_0x01be:
            int r11 = com.baidu.sofire.a.a.a
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(com.baidu.sofire.core.ApkInfo):void");
    }

    public final boolean a(String str, File file) {
        try {
            if (q.a(this.a)) {
                return new q(this.a).a(str, file);
            }
            return new j(this.a).a(str, file);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return false;
        }
    }
}
