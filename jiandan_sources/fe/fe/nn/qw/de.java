package fe.fe.nn.qw;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import fe.fe.nn.rg.fe;
import org.json.JSONArray;
import org.json.JSONObject;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile de f2305ad;
    public Context qw;

    public de(Context context) {
        this.qw = context;
    }

    public static de qw(Context context) {
        if (f2305ad == null) {
            synchronized (de.class) {
                if (f2305ad == null) {
                    f2305ad = new de(context);
                }
            }
        }
        return f2305ad;
    }

    public String ad(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String fe2 = new fe.fe.nn.uk.de(this.qw, (Handler) null).fe(jSONObject, j);
                    if (!TextUtils.isEmpty(fe2)) {
                        return fe2;
                    }
                }
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
        return "";
    }

    public final void de(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("1");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                qw.uk(this.qw).d("k_retry_code_cm", "");
            } else {
                qw.uk(this.qw).d("k_retry_code_cm", optJSONArray.toString());
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("2");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                qw.uk(this.qw).d("k_retry_code_cu", "");
            } else {
                qw.uk(this.qw).d("k_retry_code_cu", optJSONArray2.toString());
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("3");
            if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                qw.uk(this.qw).d("k_retry_code_ct", "");
            } else {
                qw.uk(this.qw).d("k_retry_code_ct", optJSONArray3.toString());
            }
        } else {
            qw.uk(this.qw).d("k_retry_code_cm", "");
            qw.uk(this.qw).d("k_retry_code_cu", "");
            qw.uk(this.qw).d("k_retry_code_ct", "");
        }
    }

    public final boolean fe() {
        try {
            if (System.currentTimeMillis() - qw.uk(this.qw).M() > qw.uk(this.qw).rrr()) {
                return false;
            }
            String R = qw.uk(this.qw).R();
            String l = qw.uk(this.qw).l();
            String I = qw.uk(this.qw).I();
            if (TextUtils.isEmpty(R) && TextUtils.isEmpty(l) && TextUtils.isEmpty(I)) {
                return false;
            }
            if (!TextUtils.isEmpty(R)) {
                JSONObject jSONObject = new JSONObject(R);
                String string = jSONObject.getString(b.D0);
                String string2 = jSONObject.getString(com.alipay.sdk.m.l.b.h);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    fe.pf("cm", string, string2);
                }
            }
            if (!TextUtils.isEmpty(l)) {
                JSONObject jSONObject2 = new JSONObject(l);
                String string3 = jSONObject2.getString(b.D0);
                String string4 = jSONObject2.getString(com.alipay.sdk.m.l.b.h);
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    fe.pf("ct", string3, string4);
                }
            }
            if (TextUtils.isEmpty(I)) {
                return true;
            }
            JSONObject jSONObject3 = new JSONObject(I);
            String optString = jSONObject3.optString(b.D0);
            String optString2 = jSONObject3.optString(com.alipay.sdk.m.l.b.h);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return true;
            }
            fe.pf("cu", optString, optString2);
            return true;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x024a, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC, Splitter:B:15:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean rg(boolean r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x0028
            android.content.Context r10 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r10 = fe.fe.nn.qw.qw.uk(r10)     // Catch:{ all -> 0x0025 }
            long r2 = r10.y()     // Catch:{ all -> 0x0025 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0025 }
            long r4 = r4 - r2
            long r2 = fe.fe.nn.ppp.ad.f2299de     // Catch:{ all -> 0x0025 }
            r6 = 5
            long r2 = r2 * r6
            int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0028
            java.lang.String r10 = "pullConfig->force pull"
            fe.fe.nn.ppp.yj.ad(r10)     // Catch:{ all -> 0x0025 }
            r10 = 1
            goto L_0x0029
        L_0x0025:
            r10 = move-exception
            goto L_0x024b
        L_0x0028:
            r10 = 0
        L_0x0029:
            if (r10 != 0) goto L_0x0033
            boolean r10 = r9.fe()     // Catch:{ all -> 0x0025 }
            if (r10 == 0) goto L_0x0033
            monitor-exit(r9)
            return r1
        L_0x0033:
            fe.fe.nn.uk.de r10 = new fe.fe.nn.uk.de     // Catch:{ all -> 0x0025 }
            android.content.Context r2 = r9.qw     // Catch:{ all -> 0x0025 }
            r3 = 0
            r10.<init>(r2, r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r10.ad()     // Catch:{ all -> 0x0025 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0025 }
            r4 = 3
            if (r3 == 0) goto L_0x0057
            r3 = 0
        L_0x0047:
            if (r3 >= r4) goto L_0x0057
            java.lang.String r2 = r10.ad()     // Catch:{ all -> 0x0025 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0025 }
            if (r5 != 0) goto L_0x0054
            goto L_0x0057
        L_0x0054:
            int r3 = r3 + 1
            goto L_0x0047
        L_0x0057:
            boolean r10 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0025 }
            if (r10 == 0) goto L_0x005f
            monitor-exit(r9)
            return r0
        L_0x005f:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x0025 }
            r10.<init>(r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = "0"
            r3 = -1
            int r2 = r10.optInt(r2, r3)     // Catch:{ all -> 0x0025 }
            r5 = 2
            if (r2 != r5) goto L_0x0078
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.x(r0)     // Catch:{ all -> 0x0025 }
            goto L_0x0081
        L_0x0078:
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.x(r1)     // Catch:{ all -> 0x0025 }
        L_0x0081:
            if (r2 == r1) goto L_0x0249
            if (r2 != r4) goto L_0x0087
            goto L_0x0249
        L_0x0087:
            java.lang.String r2 = "1"
            org.json.JSONObject r2 = r10.optJSONObject(r2)     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0091
            monitor-exit(r9)
            return r0
        L_0x0091:
            java.lang.String r4 = "yd_config"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x00e0
            java.lang.String r6 = "app_id"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ all -> 0x0025 }
            java.lang.String r7 = "app_key"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ all -> 0x0025 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x00b6
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x00b6
            java.lang.String r8 = "cm"
            fe.fe.nn.rg.fe.pf(r8, r6, r7)     // Catch:{ all -> 0x0025 }
        L_0x00b6:
            java.lang.String r6 = "status"
            int r6 = r4.optInt(r6, r3)     // Catch:{ all -> 0x0025 }
            if (r6 != r1) goto L_0x00c8
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.when(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x00d3
        L_0x00c8:
            if (r6 != r5) goto L_0x00d3
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.when(r0)     // Catch:{ all -> 0x0025 }
        L_0x00d3:
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0025 }
            r6.A(r4)     // Catch:{ all -> 0x0025 }
        L_0x00e0:
            java.lang.String r4 = "dx_config"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x012f
            java.lang.String r6 = "app_id"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ all -> 0x0025 }
            java.lang.String r7 = "app_key"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ all -> 0x0025 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x0105
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x0105
            java.lang.String r8 = "ct"
            fe.fe.nn.rg.fe.pf(r8, r6, r7)     // Catch:{ all -> 0x0025 }
        L_0x0105:
            java.lang.String r6 = "status"
            int r6 = r4.optInt(r6, r3)     // Catch:{ all -> 0x0025 }
            if (r6 != r1) goto L_0x0117
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.qqq(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x0122
        L_0x0117:
            if (r6 != r5) goto L_0x0122
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            r6.qqq(r0)     // Catch:{ all -> 0x0025 }
        L_0x0122:
            android.content.Context r6 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r6 = fe.fe.nn.qw.qw.uk(r6)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0025 }
            r6.m152switch(r4)     // Catch:{ all -> 0x0025 }
        L_0x012f:
            java.lang.String r4 = "lt_config"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x017e
            java.lang.String r6 = "app_id"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ all -> 0x0025 }
            java.lang.String r7 = "app_key"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ all -> 0x0025 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x0154
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0025 }
            if (r8 != 0) goto L_0x0154
            java.lang.String r8 = "cu"
            fe.fe.nn.rg.fe.pf(r8, r6, r7)     // Catch:{ all -> 0x0025 }
        L_0x0154:
            java.lang.String r6 = "status"
            int r3 = r4.optInt(r6, r3)     // Catch:{ all -> 0x0025 }
            if (r3 != r1) goto L_0x0166
            android.content.Context r3 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r3 = fe.fe.nn.qw.qw.uk(r3)     // Catch:{ all -> 0x0025 }
            r3.e(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x0171
        L_0x0166:
            if (r3 != r5) goto L_0x0171
            android.content.Context r3 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r3 = fe.fe.nn.qw.qw.uk(r3)     // Catch:{ all -> 0x0025 }
            r3.e(r0)     // Catch:{ all -> 0x0025 }
        L_0x0171:
            android.content.Context r3 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r3 = fe.fe.nn.qw.qw.uk(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0025 }
            r3.h(r4)     // Catch:{ all -> 0x0025 }
        L_0x017e:
            java.lang.String r3 = "auto_config"
            org.json.JSONObject r3 = r2.optJSONObject(r3)     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x01af
            java.lang.String r4 = "app_key"
            java.lang.String r5 = ""
            java.lang.String r4 = r3.optString(r4, r5)     // Catch:{ all -> 0x0025 }
            java.lang.String r5 = "secret_key"
            java.lang.String r6 = ""
            java.lang.String r3 = r3.optString(r5, r6)     // Catch:{ all -> 0x0025 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0025 }
            if (r5 != 0) goto L_0x01af
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0025 }
            if (r5 != 0) goto L_0x01af
            com.baidu.sso.SSOManager.f1098ad = r4     // Catch:{ all -> 0x0025 }
            com.baidu.sso.SSOManager.f1099de = r3     // Catch:{ all -> 0x0025 }
            android.content.Context r5 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r5 = fe.fe.nn.qw.qw.uk(r5)     // Catch:{ all -> 0x0025 }
            r5.j(r4, r3)     // Catch:{ all -> 0x0025 }
        L_0x01af:
            java.lang.String r3 = "encrypt_key"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.optString(r3, r4)     // Catch:{ all -> 0x0025 }
            android.content.Context r3 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r3 = fe.fe.nn.qw.qw.uk(r3)     // Catch:{ all -> 0x0025 }
            r3.s(r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = "a_setting"
            org.json.JSONObject r2 = r10.optJSONObject(r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0225
            java.lang.String r3 = "1"
            java.lang.String r4 = "1"
            java.lang.String r3 = r2.optString(r3, r4)     // Catch:{ all -> 0x0025 }
            android.content.Context r4 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r4 = fe.fe.nn.qw.qw.uk(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r5 = "1"
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x0025 }
            r4.k(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "2"
            int r3 = r2.optInt(r3)     // Catch:{ all -> 0x0025 }
            android.content.Context r4 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r4 = fe.fe.nn.qw.qw.uk(r4)     // Catch:{ all -> 0x0025 }
            r4.tt(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "3"
            java.lang.String r4 = "0"
            java.lang.String r3 = r2.optString(r3, r4)     // Catch:{ all -> 0x0025 }
            android.content.Context r4 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r4 = fe.fe.nn.qw.qw.uk(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r5 = "1"
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x0025 }
            r4.t(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "4"
            org.json.JSONObject r3 = r2.optJSONObject(r3)     // Catch:{ all -> 0x0025 }
            r9.de(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "5"
            java.lang.String r4 = "1"
            java.lang.String r2 = r2.optString(r3, r4)     // Catch:{ all -> 0x0025 }
            android.content.Context r3 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r3 = fe.fe.nn.qw.qw.uk(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = "1"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0025 }
            r3.p(r2)     // Catch:{ all -> 0x0025 }
        L_0x0225:
            java.lang.String r2 = "3"
            r3 = 300(0x12c, double:1.48E-321)
            long r2 = r10.optLong(r2, r3)     // Catch:{ all -> 0x0025 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            android.content.Context r10 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r10 = fe.fe.nn.qw.qw.uk(r10)     // Catch:{ all -> 0x0025 }
            r10.m151if(r2)     // Catch:{ all -> 0x0025 }
            android.content.Context r10 = r9.qw     // Catch:{ all -> 0x0025 }
            fe.fe.nn.qw.qw r10 = fe.fe.nn.qw.qw.uk(r10)     // Catch:{ all -> 0x0025 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0025 }
            r10.v(r2)     // Catch:{ all -> 0x0025 }
            monitor-exit(r9)
            return r1
        L_0x0249:
            monitor-exit(r9)
            return r1
        L_0x024b:
            fe.fe.nn.ppp.de.fe(r10)     // Catch:{ all -> 0x0250 }
            monitor-exit(r9)
            return r0
        L_0x0250:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.qw.de.rg(boolean):boolean");
    }

    public String th(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String i2 = new fe.fe.nn.uk.de(this.qw, (Handler) null).i(jSONObject, j);
                    if (!TextUtils.isEmpty(i2)) {
                        return i2;
                    }
                }
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
        return "";
    }
}
