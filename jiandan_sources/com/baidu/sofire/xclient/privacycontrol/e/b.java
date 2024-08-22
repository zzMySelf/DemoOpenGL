package com.baidu.sofire.xclient.privacycontrol.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.PCMH;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements com.baidu.sofire.xclient.privacycontrol.a.b, Runnable {
    public static volatile b g;
    public Context a;
    public int b = 5;
    public int c = 0;
    public long d = TimeUnit.MINUTES.toMillis(30);
    public boolean e = false;
    public boolean f = false;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                if (PCMH.isMainProcess(b.this.a)) {
                    PCMH.sendOfflineLog(b.this.a, b.a(this.a, this.b));
                    return;
                }
                Context context = b.this.a;
                String str = this.b;
                String str2 = this.a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (context != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME, "offline_report");
                    bundle.putString("value", str);
                    bundle.putString("logId", str2);
                    PCMH.callProvider(context, "sub_process_call_provacy_control", bundle);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("0", Long.toString(System.currentTimeMillis()));
            jSONObject3.put("1", "");
            jSONObject3.put("2", "");
            jSONObject3.put("3", "");
            jSONObject3.put("4", 0);
            jSONObject3.put(BannerBaseItemInfo.TYPE_LOGIN, 0);
            jSONObject3.put(BannerBaseItemInfo.TYPE_SCHEME, "");
            jSONObject3.put("7", 0);
            jSONObject3.put("8", "sofire");
            jSONObject3.put("9", "1.0.8");
            jSONObject3.put("10", str);
            jSONObject2.put("Common_section", jSONObject3);
            jSONObject2.put("Module_section", new JSONArray().put(jSONObject));
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b c() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
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
    public final synchronized void a() {
        /*
            r17 = this;
            r0 = r17
            monitor-enter(r17)
            android.content.Context r1 = r0.a     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "s_prv_ctl.db"
            java.io.File r1 = r1.getDatabasePath(r2)     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0073
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0075 }
            if (r2 != 0) goto L_0x0014
            goto L_0x0073
        L_0x0014:
            r1.length()     // Catch:{ all -> 0x0075 }
            long r2 = r1.length()     // Catch:{ all -> 0x0075 }
            r4 = 10485760(0xa00000, double:5.180654E-317)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0024
            monitor-exit(r17)
            return
        L_0x0024:
            long r2 = r1.length()     // Catch:{ all -> 0x0075 }
            long r6 = r1.length()     // Catch:{ all -> 0x0075 }
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0032
            monitor-exit(r17)
            return
        L_0x0032:
            android.content.Context r1 = r0.a     // Catch:{ all -> 0x0075 }
            com.baidu.sofire.xclient.privacycontrol.d.a r1 = com.baidu.sofire.xclient.privacycontrol.d.a.a((android.content.Context) r1)     // Catch:{ all -> 0x0075 }
            monitor-enter(r1)     // Catch:{ all -> 0x0075 }
            r6 = 0
            r7 = 0
            android.database.sqlite.SQLiteDatabase r8 = r1.a     // Catch:{ all -> 0x005a }
            java.lang.String r9 = "r"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r6 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x005a }
            if (r6 != 0) goto L_0x0053
            if (r6 == 0) goto L_0x0058
        L_0x004f:
            r6.close()     // Catch:{ all -> 0x0058 }
            goto L_0x0058
        L_0x0053:
            int r7 = r6.getCount()     // Catch:{ all -> 0x005a }
            goto L_0x004f
        L_0x0058:
            monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            goto L_0x005e
        L_0x005a:
            if (r6 == 0) goto L_0x0058
            goto L_0x004f
        L_0x005e:
            long r4 = r2 - r4
            long r6 = (long) r7     // Catch:{ all -> 0x0075 }
            long r6 = r6 * r4
            long r6 = r6 / r2
            int r1 = (int) r6
            if (r1 > 0) goto L_0x0069
            monitor-exit(r17)
            return
        L_0x0069:
            android.content.Context r2 = r0.a     // Catch:{ all -> 0x0075 }
            com.baidu.sofire.xclient.privacycontrol.d.a r2 = com.baidu.sofire.xclient.privacycontrol.d.a.a((android.content.Context) r2)     // Catch:{ all -> 0x0075 }
            r2.a((int) r1)     // Catch:{ all -> 0x0075 }
            goto L_0x0075
        L_0x0073:
            monitor-exit(r17)
            return
        L_0x0075:
            monitor-exit(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.e.b.a():void");
    }

    public final void a(JSONObject jSONObject, JSONArray jSONArray) {
        try {
            jSONObject.put("1", jSONArray);
            jSONObject.put("2", 1);
            jSONObject.put("3", com.baidu.sofire.xclient.privacycontrol.f.a.b(this.a));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0020=Splitter:B:11:0x0020, B:13:0x0030=Splitter:B:13:0x0030} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x0030
            boolean r0 = r3.e     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x000a
            goto L_0x0030
        L_0x000a:
            r0 = 1
            r3.f = r0     // Catch:{ all -> 0x004e }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            int r1 = android.os.Process.myPid()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = com.baidu.sofire.xclient.privacycontrol.b.b.a((int) r1)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "0"
            if (r1 != 0) goto L_0x0020
            java.lang.String r1 = ""
        L_0x0020:
            r0.put(r2, r1)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "1097105"
            r3.b(r0, r1)     // Catch:{ all -> 0x004e }
            goto L_0x004e
        L_0x002d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0030:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "checkAndReportProcessAlive, no report process alive, mIsProcessAliveReported:"
            r0.append(r1)     // Catch:{ all -> 0x004e }
            boolean r1 = r3.f     // Catch:{ all -> 0x004e }
            r0.append(r1)     // Catch:{ all -> 0x004e }
            java.lang.String r1 = ", mIsProcessAliveNeedReport:"
            r0.append(r1)     // Catch:{ all -> 0x004e }
            boolean r1 = r3.e     // Catch:{ all -> 0x004e }
            r0.append(r1)     // Catch:{ all -> 0x004e }
            r0.toString()     // Catch:{ all -> 0x004e }
            monitor-exit(r3)
            return
        L_0x004e:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.e.b.b():void");
    }

    public void b(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", 1);
            jSONObject.put("1", i2);
            b(jSONObject.toString(), "1097103");
        } catch (Throwable unused) {
        }
    }

    public void b(String str, String str2) {
        try {
            com.baidu.sofire.xclient.privacycontrol.h.a.a().post(new a(str2, str));
        } catch (Throwable unused) {
        }
    }

    public final void d() {
        try {
            com.baidu.sofire.xclient.privacycontrol.h.a.a().postDelayed(this, this.d);
        } catch (Throwable unused) {
        }
    }

    public void onConfigUpdate(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                this.b = jSONObject.optInt(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, 5);
                boolean z = false;
                if (jSONObject.optInt("a", 0) != 0) {
                    z = true;
                }
                this.e = z;
                b();
                int optInt = jSONObject.optInt("c_i", 30);
                if (optInt != 0) {
                    long millis = TimeUnit.MINUTES.toMillis((long) optInt);
                    if (millis != this.d) {
                        com.baidu.sofire.xclient.privacycontrol.h.a.a().removeCallbacks(this);
                        this.d = millis;
                        d();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void run() {
        try {
            d();
            Context context = this.a;
            if (context != null) {
                if (!com.baidu.sofire.xclient.privacycontrol.d.a.a(context).a()) {
                    if (F.getInstance().cp(this.a) && com.baidu.sofire.xclient.privacycontrol.b.b.a(this.a)) {
                        PCMH.triggerReportPrvControlLog(this.a);
                    }
                }
                a();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(2:4|(6:6|7|8|9|(2:11|27)(1:26)|24)(2:25|12))|13|14|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.a.endTransaction();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<java.lang.Integer> r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.a
            com.baidu.sofire.xclient.privacycontrol.d.a r0 = com.baidu.sofire.xclient.privacycontrol.d.a.a((android.content.Context) r0)
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r0.a     // Catch:{ all -> 0x004f }
            r1.beginTransaction()     // Catch:{ all -> 0x004f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x004f }
        L_0x0010:
            boolean r1 = r9.hasNext()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r9.next()     // Catch:{ all -> 0x004f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004f }
            android.database.sqlite.SQLiteDatabase r2 = r0.a     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "r"
            java.lang.String r4 = "a=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x004f }
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r7.<init>()     // Catch:{ all -> 0x004f }
            r7.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = ""
            r7.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x004f }
            r5[r6] = r1     // Catch:{ all -> 0x004f }
            int r1 = r2.delete(r3, r4, r5)     // Catch:{ all -> 0x004f }
            if (r1 > 0) goto L_0x0010
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004f }
            goto L_0x0010
        L_0x0047:
            android.database.sqlite.SQLiteDatabase r9 = r0.a     // Catch:{ all -> 0x004f }
            r9.setTransactionSuccessful()     // Catch:{ all -> 0x004f }
        L_0x004c:
            android.database.sqlite.SQLiteDatabase r9 = r0.a     // Catch:{ all -> 0x0057 }
            goto L_0x0053
        L_0x004f:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004c }
            goto L_0x004c
        L_0x0053:
            r9.endTransaction()     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005a }
        L_0x005a:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.e.b.a(java.util.List):void");
    }

    public Map<String, String> a(int i2) {
        JSONArray jSONArray;
        StringBuilder sb;
        try {
            ArrayList arrayList = (ArrayList) com.baidu.sofire.xclient.privacycontrol.d.a.a(this.a).b(i2);
            if (arrayList.size() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator it = arrayList.iterator();
            loop0:
            while (true) {
                jSONArray = null;
                sb = null;
                int i3 = 0;
                do {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    a aVar = (a) it.next();
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    jSONArray.put(new JSONObject(aVar.a));
                    sb.append(aVar.b);
                    sb.append("%");
                    i3++;
                } while (i3 < 5);
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, jSONArray);
                hashMap.put(sb.toString(), a("1097101", jSONObject.toString()));
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject2, jSONArray);
                hashMap.put(sb.toString(), a("1097101", jSONObject2.toString()));
            }
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        Context context;
        try {
            if (TextUtils.isEmpty(str) || (context = this.a) == null) {
                return;
            }
            if (PCMH.isMainProcess(context)) {
                this.c++;
                com.baidu.sofire.xclient.privacycontrol.d.a.a(this.a).a(str);
                if (this.c >= this.b) {
                    if (F.getInstance().cp(this.a) && com.baidu.sofire.xclient.privacycontrol.b.b.a(this.a)) {
                        PCMH.triggerReportPrvControlLog(this.a);
                        this.c = 0;
                        return;
                    }
                    return;
                }
                return;
            }
            Context context2 = PrvControlManager.getInstance().getContext();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (context2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME, "reportLog");
                bundle.putString("value", str);
                PCMH.callProvider(context2, "sub_process_call_provacy_control", bundle);
            }
        } catch (Throwable unused) {
        }
    }
}
