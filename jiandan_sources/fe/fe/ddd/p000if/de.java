package fe.fe.ddd.p000if;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alipay.sdk.m.k.b;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.if.de  reason: invalid package */
public final class de {
    public static AtomicBoolean a = new AtomicBoolean(false);
    public static double aaa = 999.0d;

    /* renamed from: ad  reason: collision with root package name */
    public static int f1461ad = 9;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static final Object d = new Object();
    public static double ddd = 2.0d;

    /* renamed from: de  reason: collision with root package name */
    public static int f1462de = 7;
    public static double eee = 3.0d;

    /* renamed from: fe  reason: collision with root package name */
    public static int f1463fe = 5;
    public static int ggg = 30;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f1464i = true;

    /* renamed from: if  reason: not valid java name */
    public static int f26if = 2;
    public static long mmm = 3000;
    public static long nn = 500;

    /* renamed from: o  reason: collision with root package name */
    public static long f1465o = ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS;

    /* renamed from: pf  reason: collision with root package name */
    public static int f1466pf = 2;
    public static int ppp = 6;
    public static double qqq = 8.0d;
    public static final int[] qw = {0, 1, 2, 3};

    /* renamed from: rg  reason: collision with root package name */
    public static int f1467rg = 3;
    public static double rrr = 1.0d;

    /* renamed from: switch  reason: not valid java name */
    public static int f27switch = 6;

    /* renamed from: th  reason: collision with root package name */
    public static int f1468th = 7;
    public static double[] tt = {999.0d, 8.0d, 3.0d, 1.0d};

    /* renamed from: uk  reason: collision with root package name */
    public static long f1469uk = 1000;
    public static double vvv = 10.0d;
    public static int when = 4;
    public static double xxx = 30.0d;

    /* renamed from: yj  reason: collision with root package name */
    public static long f1470yj = 1000;

    public static void ad(Context context) {
        new File(context.getFilesDir().getAbsolutePath() + File.separator + "elastic_config" + File.separator + "config_data").delete();
    }

    public static boolean de() {
        return a.get();
    }

    public static Object fe() {
        return d;
    }

    public static void i(Context context, JSONObject jSONObject) {
        if (!qw(context, jSONObject)) {
            ad(context);
            return;
        }
        uk(TextUtils.equals(jSONObject.optString("disable_elastic"), "1"));
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_pool_size");
        if (optJSONObject != null) {
            f1466pf = optJSONObject.optInt("first_artery", f1466pf);
            f26if = optJSONObject.optInt("second_artery", f26if);
            f27switch = optJSONObject.optInt("third_artery", f27switch);
            when = optJSONObject.optInt("first_dredge", when);
            ppp = optJSONObject.optInt("second_dredge", ppp);
            ggg = optJSONObject.optInt("third_dredge", ggg);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("dredge_config");
        if (optJSONObject2 != null) {
            ddd = optJSONObject2.optDouble("downgrade_threshold", ddd);
            vvv = optJSONObject2.optDouble("upgrade_threshold", vvv);
            xxx = optJSONObject2.optDouble("upgrade_ra_threshold", xxx);
            mmm = optJSONObject2.optLong("downgrade_protect_time", mmm);
            nn = optJSONObject2.optLong("upgrade_protect_time", nn);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("block_weight");
        if (optJSONObject3 != null) {
            qqq = optJSONObject3.optDouble("first", qqq);
            eee = optJSONObject3.optDouble(TypeAdapters.AnonymousClass27.SECOND, eee);
            double optDouble = optJSONObject3.optDouble(b.f661o, rrr);
            rrr = optDouble;
            tt = new double[]{aaa, qqq, eee, optDouble};
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("serial_config");
        if (optJSONObject4 != null) {
            f1464i = optJSONObject4.optBoolean("enable_dredge", f1464i);
            f1465o = optJSONObject4.optLong("block_threshold", f1465o);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[SYNTHETIC, Splitter:B:21:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d A[SYNTHETIC, Splitter:B:27:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void o(android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r5.getFilesDir()
            java.lang.String r1 = r1.getAbsolutePath()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "elastic_config"
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "config_data"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x0034
            return
        L_0x0034:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006a, all -> 0x0063 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x006a, all -> 0x0063 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x006a, all -> 0x0063 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x006a, all -> 0x0063 }
        L_0x0044:
            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            if (r1 == 0) goto L_0x004e
            r0.append(r1)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            goto L_0x0044
        L_0x004e:
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005d }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x005d }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x005d }
            i(r5, r1)     // Catch:{ JSONException -> 0x005d }
        L_0x005d:
            return
        L_0x005e:
            r5 = move-exception
            r2 = r3
            goto L_0x0064
        L_0x0061:
            r2 = r3
            goto L_0x006b
        L_0x0063:
            r5 = move-exception
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            throw r5
        L_0x006a:
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.p000if.de.o(android.content.Context):void");
    }

    public static boolean qw(Context context, JSONObject jSONObject) {
        int rg2 = rg(context);
        long optInt = (long) jSONObject.optInt("max_version", Integer.MAX_VALUE);
        long j = (long) rg2;
        if (j < ((long) jSONObject.optInt("min_version", 0)) || j > optInt) {
            return false;
        }
        return true;
    }

    public static int rg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static void th(boolean z) {
        synchronized (d) {
            b = z;
        }
    }

    public static void uk(boolean z) {
        a.set(z);
    }

    public static void yj() {
        Context qw2 = qw.qw();
        if (qw2 != null) {
            synchronized (d) {
                if (!b) {
                    if (!c) {
                        o(qw2);
                        c = true;
                    }
                }
            }
        }
    }
}
