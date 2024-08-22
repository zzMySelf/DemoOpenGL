package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.regex.Pattern;

public class b implements a {
    public static final String A = "https://www.dxmpay.com";
    public static final String B = "https://www.dxmpay.com";
    public static final String C = "https://www.dxmpay.com";
    public static final String D = "https://www.dxmpay.com";
    public static final String E = "https://app.duxiaoman.com";
    public static final String F = "https://app.duxiaomanfintech.com";
    public static final String G = "https://bi-sensors.duxiaoman.com";
    public static final String H = "https://jin.baidu.com";
    public static final String I = "https://qianbao.baidu.com";
    public static final Pattern J = Pattern.compile("^https://.*\\.com");
    public static final String q = "https://app.duxiaoman.com";
    public static final String r = "https://kaquan.duxiaoman.com";
    public static final String s = "https://huafei.duxiaoman.com";
    public static final String t = "https://xindai.duxiaoman.com";
    public static final String u = "https://www.dxmpay.com";
    public static final String v = "https://app.duxiaoman.com";
    public static final String w = "https://chong.baidu.com";
    public static final String x = "https://xinyongka.baidu.com";
    public static final String y = "https://zhifu.duxiaoman.com";
    public static final String z = "https://comet.baifubao.com";
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;

    /* renamed from: o  reason: collision with root package name */
    public String f3553o = "";
    public String p = "";

    public String getAppHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.N) ? this.N : "https://app.duxiaoman.com";
    }

    public String getAppPayHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.O) ? this.O : "https://www.dxmpay.com";
    }

    public String getCOHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.O) ? this.O : "https://www.dxmpay.com";
    }

    public String getCometHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.Q) ? this.Q : z;
    }

    public String getCreditCardHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.L) ? this.L : x;
    }

    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.U) ? this.U : "https://app.duxiaoman.com";
    }

    public String getInitHost(int i2, @NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        if (i2 != 2) {
            return i2 != 3 ? "https://app.duxiaoman.com" : F;
        }
        if (TextUtils.isEmpty(this.S)) {
            return "https://app.duxiaoman.com";
        }
        return this.S;
    }

    public String getLifeHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.K) ? this.K : s;
    }

    public String getMHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.O) ? this.O : "https://www.dxmpay.com";
    }

    public String getMyHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.R) ? this.R : r;
    }

    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.V) ? this.V : t;
    }

    public String getNfcHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.M) ? this.M : w;
    }

    public String getQianbaoHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.O) ? this.O : "https://www.dxmpay.com";
    }

    public String getRecordHost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.p) ? this.p : "";
    }

    public String getRtcHost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.f3553o) ? this.f3553o : "";
    }

    public String getSensorhost(@NonNull Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.T) ? this.T : "https://bi-sensors.duxiaoman.com";
    }

    public String getWebCacheHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.N) ? this.N : "https://app.duxiaoman.com";
    }

    public String getZhiFuHost(Boolean[] boolArr) {
        boolArr[0] = Boolean.TRUE;
        return !TextUtils.isEmpty(this.P) ? this.P : y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cb A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e8 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0105 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011f A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0122 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013c A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013f A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0159 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015c A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0176 A[Catch:{ JSONException -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0179 A[Catch:{ JSONException -> 0x017c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDomainConfig(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0180
            com.baidu.wallet.core.lollipop.json.JSONObject r0 = new com.baidu.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x017c }
            r0.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x017c }
            java.lang.String r4 = "life_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0028
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0028
            r3.K = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x002a
        L_0x0028:
            r3.K = r2     // Catch:{ JSONException -> 0x017c }
        L_0x002a:
            java.lang.String r4 = "xinyongka_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x0045
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0045
            r3.L = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0047
        L_0x0045:
            r3.L = r2     // Catch:{ JSONException -> 0x017c }
        L_0x0047:
            java.lang.String r4 = "nfc_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x0062
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0062
            r3.M = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0064
        L_0x0062:
            r3.M = r2     // Catch:{ JSONException -> 0x017c }
        L_0x0064:
            java.lang.String r4 = "app_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x0088
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0088
            r3.N = r4     // Catch:{ JSONException -> 0x017c }
            com.baidu.apollon.heartbeat.a r4 = com.baidu.apollon.heartbeat.a.c()     // Catch:{ JSONException -> 0x017c }
            java.lang.String r1 = r3.N     // Catch:{ JSONException -> 0x017c }
            r4.b((java.lang.String) r1)     // Catch:{ JSONException -> 0x017c }
            goto L_0x0093
        L_0x0088:
            r3.N = r2     // Catch:{ JSONException -> 0x017c }
            com.baidu.apollon.heartbeat.a r4 = com.baidu.apollon.heartbeat.a.c()     // Catch:{ JSONException -> 0x017c }
            java.lang.String r1 = "https://app.duxiaoman.com"
            r4.b((java.lang.String) r1)     // Catch:{ JSONException -> 0x017c }
        L_0x0093:
            java.lang.String r4 = "dxm_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x00ae
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x00ae
            r3.O = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x00b0
        L_0x00ae:
            r3.O = r2     // Catch:{ JSONException -> 0x017c }
        L_0x00b0:
            java.lang.String r4 = "zhifu_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x00cb
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x00cb
            r3.P = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x00cd
        L_0x00cb:
            r3.P = r2     // Catch:{ JSONException -> 0x017c }
        L_0x00cd:
            java.lang.String r4 = "comet_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x00e8
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x00e8
            r3.Q = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x00ea
        L_0x00e8:
            r3.Q = r2     // Catch:{ JSONException -> 0x017c }
        L_0x00ea:
            java.lang.String r4 = "my_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x0105
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0105
            r3.R = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0107
        L_0x0105:
            r3.R = r2     // Catch:{ JSONException -> 0x017c }
        L_0x0107:
            java.lang.String r4 = "init_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x0122
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x0122
            r3.S = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0124
        L_0x0122:
            r3.S = r2     // Catch:{ JSONException -> 0x017c }
        L_0x0124:
            java.lang.String r4 = "sensors_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x013f
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x013f
            r3.T = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0141
        L_0x013f:
            r3.T = r2     // Catch:{ JSONException -> 0x017c }
        L_0x0141:
            java.lang.String r4 = "hawking_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r1 != 0) goto L_0x015c
            java.util.regex.Pattern r1 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r1 = r1.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r1 = r1.matches()     // Catch:{ JSONException -> 0x017c }
            if (r1 == 0) goto L_0x015c
            r3.U = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x015e
        L_0x015c:
            r3.U = r2     // Catch:{ JSONException -> 0x017c }
        L_0x015e:
            java.lang.String r4 = "net_check_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017c }
            if (r0 != 0) goto L_0x0179
            java.util.regex.Pattern r0 = J     // Catch:{ JSONException -> 0x017c }
            java.util.regex.Matcher r0 = r0.matcher(r4)     // Catch:{ JSONException -> 0x017c }
            boolean r0 = r0.matches()     // Catch:{ JSONException -> 0x017c }
            if (r0 == 0) goto L_0x0179
            r3.V = r4     // Catch:{ JSONException -> 0x017c }
            goto L_0x0180
        L_0x0179:
            r3.V = r2     // Catch:{ JSONException -> 0x017c }
            goto L_0x0180
        L_0x017c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.domain.b.setDomainConfig(java.lang.String):void");
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
            r3.f3553o = r4     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0026
        L_0x0024:
            r3.f3553o = r2     // Catch:{ JSONException -> 0x0040 }
        L_0x0026:
            java.lang.String r4 = "record_host"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x0040 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0040 }
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "http"
            boolean r0 = r4.startsWith(r0)     // Catch:{ JSONException -> 0x0040 }
            if (r0 == 0) goto L_0x003d
            r3.p = r4     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0044
        L_0x003d:
            r3.p = r2     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.domain.b.setRtcConfig(java.lang.String):void");
    }
}
