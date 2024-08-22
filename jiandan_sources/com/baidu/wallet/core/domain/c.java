package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.regex.Pattern;

public class c implements a {
    public static final String A = "rtc_host";
    public static final String B = "record_host";
    public static final String E = "https://www.baifubao.com";
    public static final String F = "https://app.duxiaomanFintec.com";
    public static final String S = "https://bi-sensors.duxiaoman.com";
    public static final String T = "https://jin.baidu.com";
    public static final String U = "https://qianbao.baidu.com";
    public static final Pattern V = Pattern.compile("^https://.*\\.com");
    public static c W = null;

    /* renamed from: o  reason: collision with root package name */
    public static final String f3554o = "life_host";
    public static final String p = "my_host";
    public static final String q = "credit_card_host";
    public static final String r = "app_host";
    public static final String s = "nfc_host";
    public static final String t = "app_pay_host";
    public static final String u = "m_host";
    public static final String v = "co_host";
    public static final String w = "qianbao_host";
    public static final String x = "zhifuhost";
    public static final String y = "comet_host";
    public static final String z = "wallet_web_cache_host";
    public String C = "";
    public String D = "";
    public String G = "https://www.baifubao.com";
    public String H = "https://www.baifubao.com";
    public String I = b.x;
    public String J = "https://www.baifubao.com";
    public String K = b.w;
    public String L = "https://www.dxmpay.com";
    public String M = b.z;
    public String N = "https://www.dxmpay.com";
    public String O = "https://www.dxmpay.com";
    public String P = "https://www.dxmpay.com";
    public String Q = "https://cp01-ocean-1481.epc.baidu.com:8443";
    public String R = b.y;
    public String X;
    public String Y;
    public String Z;
    public String aa;
    public String ab;
    public String ac;

    /* renamed from: ad  reason: collision with root package name */
    public String f3555ad;
    public String ae;
    public String af;
    public String ag;
    public String ah;
    public String ai;
    public String aj;
    public String ak;
    public String al;
    public String am;

    public static c a() {
        if (W == null) {
            W = new c();
        }
        return W;
    }

    public void b(String str) {
        this.Y = str;
    }

    public void c(String str) {
        this.Z = str;
    }

    public void d(String str) {
        this.aa = str;
    }

    public void e(String str) {
        this.ab = str;
    }

    public void f(String str) {
        this.ac = str;
    }

    public void g(String str) {
        this.f3555ad = str;
    }

    public String getAppHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.aa)) {
            return this.aa;
        }
        return this.J;
    }

    public String getAppPayHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ac)) {
            return this.ac;
        }
        return this.L;
    }

    public String getCOHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ae)) {
            return this.ae;
        }
        return this.P;
    }

    public String getCometHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ah)) {
            return this.ah;
        }
        return this.M;
    }

    public String getCreditCardHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.Z)) {
            return this.Z;
        }
        return this.I;
    }

    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.al) ? this.al : "https://www.baifubao.com";
    }

    public String getInitHost(int i2, Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.aa)) {
            return this.aa;
        }
        if (i2 != 2) {
            return i2 != 3 ? "https://www.baifubao.com" : F;
        }
        return this.J;
    }

    public String getLifeHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.X)) {
            return this.X;
        }
        return this.G;
    }

    public String getMHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.f3555ad)) {
            return this.f3555ad;
        }
        return this.N;
    }

    public String getMyHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.Y)) {
            return this.Y;
        }
        return this.H;
    }

    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return null;
    }

    public String getNfcHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ab)) {
            return this.ab;
        }
        return this.K;
    }

    public String getQianbaoHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.af)) {
            return this.af;
        }
        return this.O;
    }

    public String getRecordHost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.D) ? this.D : "";
    }

    public String getRtcHost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.C) ? this.C : "";
    }

    public String getSensorhost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return null;
    }

    public String getWebCacheHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ai)) {
            return this.ai;
        }
        return this.Q;
    }

    public String getZhiFuHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (!TextUtils.isEmpty(this.ag)) {
            return this.ag;
        }
        return this.R;
    }

    public void h(String str) {
        this.ae = str;
    }

    public void i(String str) {
        this.af = str;
    }

    public void j(String str) {
        this.ag = str;
    }

    public void k(String str) {
        this.ah = str;
    }

    public void l(String str) {
        this.ai = str;
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(String str) {
        this.D = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[SYNTHETIC, Splitter:B:32:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ff A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011e A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0121 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013e A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0158 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015b A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0177 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0192 A[Catch:{ JSONException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0195 A[Catch:{ JSONException -> 0x0198 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDomainConfig(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "net_check_host"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x019c
            com.baidu.wallet.core.lollipop.json.JSONObject r1 = new com.baidu.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x0198 }
            r1.<init>((java.lang.String) r6)     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r6 = "life_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r3 = "https://www.baifubao.com"
            if (r2 != 0) goto L_0x002a
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x002a
            r5.G = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x002c
        L_0x002a:
            r5.G = r3     // Catch:{ JSONException -> 0x0198 }
        L_0x002c:
            java.lang.String r6 = "xinyongka_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x0047
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x0047
            r5.I = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x004b
        L_0x0047:
            java.lang.String r6 = "https://xinyongka.baidu.com"
            r5.I = r6     // Catch:{ JSONException -> 0x0198 }
        L_0x004b:
            java.lang.String r6 = "nfc_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x0066
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x0066
            r5.K = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x006a
        L_0x0066:
            java.lang.String r6 = "https://chong.baidu.com"
            r5.K = r6     // Catch:{ JSONException -> 0x0198 }
        L_0x006a:
            java.lang.String r6 = "app_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x008e
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x008e
            r5.J = r6     // Catch:{ JSONException -> 0x0198 }
            com.baidu.apollon.heartbeat.a r6 = com.baidu.apollon.heartbeat.a.c()     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r2 = r5.aa     // Catch:{ JSONException -> 0x0198 }
            r6.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0198 }
            goto L_0x0099
        L_0x008e:
            r5.J = r3     // Catch:{ JSONException -> 0x0198 }
            com.baidu.apollon.heartbeat.a r6 = com.baidu.apollon.heartbeat.a.c()     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r2 = r5.J     // Catch:{ JSONException -> 0x0198 }
            r6.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0198 }
        L_0x0099:
            java.lang.String r6 = "dxm_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r4 = "https://qianbao.baidu.com"
            if (r2 != 0) goto L_0x00bc
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x00bc
            r5.L = r6     // Catch:{ JSONException -> 0x0198 }
            r5.N = r6     // Catch:{ JSONException -> 0x0198 }
            r5.P = r6     // Catch:{ JSONException -> 0x0198 }
            r5.O = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x00c8
        L_0x00bc:
            r5.L = r3     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r6 = "https://m.baifubao.com"
            r5.N = r6     // Catch:{ JSONException -> 0x0198 }
            java.lang.String r6 = "https://co.baifubao.com"
            r5.P = r6     // Catch:{ JSONException -> 0x0198 }
            r5.O = r4     // Catch:{ JSONException -> 0x0198 }
        L_0x00c8:
            java.lang.String r6 = "zhifu_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x00e3
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x00e3
            r5.R = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x00e7
        L_0x00e3:
            java.lang.String r6 = "https://zhifu.baidu.com"
            r5.R = r6     // Catch:{ JSONException -> 0x0198 }
        L_0x00e7:
            java.lang.String r6 = "comet_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x0102
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x0102
            r5.M = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x0106
        L_0x0102:
            java.lang.String r6 = "https://comet.baifubao.com"
            r5.M = r6     // Catch:{ JSONException -> 0x0198 }
        L_0x0106:
            java.lang.String r6 = "my_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x0121
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x0121
            r5.H = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x0123
        L_0x0121:
            r5.H = r3     // Catch:{ JSONException -> 0x0198 }
        L_0x0123:
            java.lang.String r6 = "init_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 != 0) goto L_0x013e
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x013e
            r5.aj = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x0140
        L_0x013e:
            r5.aj = r3     // Catch:{ JSONException -> 0x0198 }
        L_0x0140:
            java.lang.String r6 = "sensors_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x015b
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x015b
            r5.ak = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x015f
        L_0x015b:
            java.lang.String r6 = "https://bi-sensors.duxiaoman.com"
            r5.ak = r6     // Catch:{ JSONException -> 0x0198 }
        L_0x015f:
            java.lang.String r6 = "hawking_host"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x017a
            java.util.regex.Pattern r2 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r2 == 0) goto L_0x017a
            r5.al = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x017c
        L_0x017a:
            r5.al = r4     // Catch:{ JSONException -> 0x0198 }
        L_0x017c:
            java.lang.String r6 = r1.optString(r0)     // Catch:{ JSONException -> 0x0198 }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0198 }
            if (r1 == 0) goto L_0x0195
            java.util.regex.Pattern r1 = V     // Catch:{ JSONException -> 0x0198 }
            java.util.regex.Matcher r1 = r1.matcher(r6)     // Catch:{ JSONException -> 0x0198 }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x0198 }
            if (r1 == 0) goto L_0x0195
            r5.am = r6     // Catch:{ JSONException -> 0x0198 }
            goto L_0x019c
        L_0x0195:
            r5.am = r0     // Catch:{ JSONException -> 0x0198 }
            goto L_0x019c
        L_0x0198:
            r6 = move-exception
            r6.printStackTrace()
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.domain.c.setDomainConfig(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[Catch:{ JSONException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ JSONException -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRtcConfig(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0044
            com.baidu.wallet.core.lollipop.json.JSONObject r0 = new com.baidu.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            r0.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r4 = "rtc_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x0040 }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0024
            java.lang.String r1 = "ws"
            boolean r1 = r4.startsWith(r1)     // Catch:{ JSONException -> 0x0040 }
            if (r1 == 0) goto L_0x0024
            r3.C = r4     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0026
        L_0x0024:
            r3.C = r2     // Catch:{ JSONException -> 0x0040 }
        L_0x0026:
            java.lang.String r4 = "record_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x0040 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0040 }
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "http"
            boolean r0 = r4.startsWith(r0)     // Catch:{ JSONException -> 0x0040 }
            if (r0 == 0) goto L_0x003d
            r3.D = r4     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0044
        L_0x003d:
            r3.D = r2     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.domain.c.setRtcConfig(java.lang.String):void");
    }

    public void a(String str) {
        this.X = str;
    }
}
