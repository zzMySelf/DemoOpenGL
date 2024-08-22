package com.duxiaoman.dxmpay.statistics.internal;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.List;

public class f {
    public static final List<String> qw = new DataConvertUtils$1();

    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b6 A[Catch:{ JSONException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x023d A[Catch:{ JSONException -> 0x026f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ad(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            java.lang.String r0 = "et"
            java.lang.String r1 = "array"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026f }
            r2.<init>()     // Catch:{ JSONException -> 0x026f }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026f }
            r4 = r18
            r3.<init>(r4)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r4 = "distinct_id"
            r5 = r20
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x026f }
            boolean r4 = android.text.TextUtils.isEmpty(r21)     // Catch:{ JSONException -> 0x026f }
            if (r4 != 0) goto L_0x0024
            java.lang.String r4 = "distinct_id_key"
            r5 = r21
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x026f }
        L_0x0024:
            java.lang.String r4 = "is_login_id"
            r5 = r22
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r4 = "source"
            r5 = 1
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x026f }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026f }
            r4.<init>()     // Catch:{ JSONException -> 0x026f }
            r6 = 0
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x026f }
            r7.<init>()     // Catch:{ JSONException -> 0x026f }
            java.util.Iterator r8 = r3.keys()     // Catch:{ JSONException -> 0x026f }
        L_0x0040:
            boolean r9 = r8.hasNext()     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x005f
            java.lang.Object r9 = r8.next()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x026f }
            boolean r10 = r9.equals(r1)     // Catch:{ JSONException -> 0x026f }
            if (r10 != 0) goto L_0x005a
            java.lang.String r10 = r3.optString(r9)     // Catch:{ JSONException -> 0x026f }
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0040
        L_0x005a:
            org.json.JSONArray r6 = r3.optJSONArray(r1)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0040
        L_0x005f:
            java.lang.String r1 = "product"
            r3 = r23
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "sdk_version"
            r3 = r24
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "channel_id"
            r3 = r25
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$os"
            java.lang.String r3 = "Android"
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$os_version"
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x026f }
            if (r3 != 0) goto L_0x0084
            java.lang.String r3 = "UNKNOWN"
            goto L_0x0086
        L_0x0084:
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x026f }
        L_0x0086:
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$screen_width"
            android.content.Context r3 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()     // Catch:{ JSONException -> 0x026f }
            int r3 = fe.th.qw.qw.qw.o.ad(r3)     // Catch:{ JSONException -> 0x026f }
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$screen_height"
            android.content.Context r3 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()     // Catch:{ JSONException -> 0x026f }
            int r3 = fe.th.qw.qw.qw.o.qw(r3)     // Catch:{ JSONException -> 0x026f }
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x026f }
            r1.<init>()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x026f }
            r1.append(r3)     // Catch:{ JSONException -> 0x026f }
            r3 = 45
            r1.append(r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r8 = android.os.Build.DEVICE     // Catch:{ JSONException -> 0x026f }
            r1.append(r8)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x026f }
            r8 = 32
            java.lang.String r1 = r1.replace(r8, r3)     // Catch:{ JSONException -> 0x026f }
            r8 = 95
            java.lang.String r1 = r1.replace(r8, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r3 = "$manufacturer"
            java.lang.String r8 = qw()     // Catch:{ JSONException -> 0x026f }
            r4.put(r3, r8)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r3 = "$model"
            r4.put(r3, r1)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$app_version"
            r3 = r26
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "app_version_code"
            r3 = r27
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "real_os"
            android.content.Context r3 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r3 = fe.th.qw.qw.qw.i.qw(r3)     // Catch:{ JSONException -> 0x026f }
            r4.put(r1, r3)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "pub"
            r2.put(r1, r4)     // Catch:{ JSONException -> 0x026f }
            if (r6 == 0) goto L_0x0265
            int r1 = r6.length()     // Catch:{ JSONException -> 0x026f }
            if (r1 <= 0) goto L_0x0265
            r3 = 0
        L_0x00fe:
            int r4 = r6.length()     // Catch:{ JSONException -> 0x026f }
            if (r3 >= r4) goto L_0x0265
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026f }
            r4.<init>()     // Catch:{ JSONException -> 0x026f }
            java.lang.Object r8 = r6.opt(r3)     // Catch:{ JSONException -> 0x026f }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = "event"
            r10 = r19
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = "type"
            java.lang.String r11 = "track"
            r4.put(r9, r11)     // Catch:{ JSONException -> 0x026f }
            boolean r9 = r8.has(r0)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x0132
            java.lang.Object r9 = r8.remove(r0)     // Catch:{ JSONException -> 0x026f }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ JSONException -> 0x026f }
            long r11 = r9.longValue()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = "time"
            r4.put(r9, r11)     // Catch:{ JSONException -> 0x026f }
        L_0x0132:
            java.lang.String r9 = "en"
            java.lang.Object r9 = r8.remove(r9)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x026f }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026f }
            r11.<init>()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r12 = "event_key"
            r11.put(r12, r9)     // Catch:{ JSONException -> 0x026f }
            java.util.Iterator r9 = r8.keys()     // Catch:{ JSONException -> 0x026f }
        L_0x0148:
            boolean r12 = r9.hasNext()     // Catch:{ JSONException -> 0x026f }
            if (r12 == 0) goto L_0x0250
            java.lang.Object r12 = r9.next()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x026f }
            int r14 = r12.hashCode()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r13 = "nu"
            java.lang.String r1 = "nt"
            java.lang.String r5 = "lk"
            java.lang.String r15 = "ev"
            r16 = r0
            java.lang.String r0 = "eg"
            r17 = r6
            java.lang.String r6 = "at"
            r26 = r9
            r9 = 3123(0xc33, float:4.376E-42)
            if (r14 == r9) goto L_0x01ab
            r9 = 3234(0xca2, float:4.532E-42)
            if (r14 == r9) goto L_0x01a3
            r9 = 3249(0xcb1, float:4.553E-42)
            if (r14 == r9) goto L_0x019b
            r9 = 3455(0xd7f, float:4.841E-42)
            if (r14 == r9) goto L_0x0193
            r9 = 3526(0xdc6, float:4.941E-42)
            if (r14 == r9) goto L_0x018b
            r9 = 3527(0xdc7, float:4.942E-42)
            if (r14 == r9) goto L_0x0183
            goto L_0x01b3
        L_0x0183:
            boolean r9 = r12.equals(r13)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 1
            goto L_0x01b4
        L_0x018b:
            boolean r9 = r12.equals(r1)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 5
            goto L_0x01b4
        L_0x0193:
            boolean r9 = r12.equals(r5)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 2
            goto L_0x01b4
        L_0x019b:
            boolean r9 = r12.equals(r15)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 4
            goto L_0x01b4
        L_0x01a3:
            boolean r9 = r12.equals(r0)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 0
            goto L_0x01b4
        L_0x01ab:
            boolean r9 = r12.equals(r6)     // Catch:{ JSONException -> 0x026f }
            if (r9 == 0) goto L_0x01b3
            r9 = 3
            goto L_0x01b4
        L_0x01b3:
            r9 = -1
        L_0x01b4:
            if (r9 == 0) goto L_0x023d
            r14 = 1
            if (r9 == r14) goto L_0x0231
            r0 = 2
            if (r9 == r0) goto L_0x0218
            r0 = 3
            if (r9 == r0) goto L_0x020e
            r0 = 4
            if (r9 == r0) goto L_0x01df
            r0 = 5
            if (r9 == r0) goto L_0x01d5
            java.lang.Object r0 = r8.opt(r12)     // Catch:{ JSONException -> 0x026f }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x026f }
        L_0x01cc:
            r9 = r26
            r0 = r16
            r6 = r17
            r5 = 1
            goto L_0x0148
        L_0x01d5:
            int r0 = r8.optInt(r1)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "net_type"
            r11.put(r1, r0)     // Catch:{ JSONException -> 0x026f }
            goto L_0x01cc
        L_0x01df:
            java.lang.String r0 = r8.optString(r15)     // Catch:{ JSONException -> 0x026f }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x026f }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x026f }
            r0 = 0
            r14 = 1
        L_0x01ea:
            int r5 = r1.length()     // Catch:{ JSONException -> 0x026f }
            if (r0 >= r5) goto L_0x01cc
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x026f }
            r5.<init>()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r6 = "value"
            r5.append(r6)     // Catch:{ JSONException -> 0x026f }
            int r6 = r14 + 1
            r5.append(r14)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = r1.optString(r0)     // Catch:{ JSONException -> 0x026f }
            r11.put(r5, r9)     // Catch:{ JSONException -> 0x026f }
            int r0 = r0 + 1
            r14 = r6
            goto L_0x01ea
        L_0x020e:
            java.lang.String r0 = r8.optString(r6)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "abtype"
            r11.put(r1, r0)     // Catch:{ JSONException -> 0x026f }
            goto L_0x01cc
        L_0x0218:
            java.lang.String r0 = r8.optString(r5)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "WIFI"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "$wifi"
            if (r0 == 0) goto L_0x022b
            r5 = 1
            r11.put(r1, r5)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0248
        L_0x022b:
            r5 = 1
            r6 = 0
            r11.put(r1, r6)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0248
        L_0x0231:
            r5 = 1
            r6 = 0
            int r0 = r8.optInt(r13)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "event_number"
            r11.put(r1, r0)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0248
        L_0x023d:
            r5 = 1
            r6 = 0
            java.lang.String r0 = r8.optString(r0)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r1 = "event_tag"
            r11.put(r1, r0)     // Catch:{ JSONException -> 0x026f }
        L_0x0248:
            r9 = r26
            r0 = r16
            r6 = r17
            goto L_0x0148
        L_0x0250:
            r16 = r0
            r17 = r6
            r6 = 0
            java.lang.String r0 = "properties"
            r4.put(r0, r11)     // Catch:{ JSONException -> 0x026f }
            r7.put(r4)     // Catch:{ JSONException -> 0x026f }
            int r3 = r3 + 1
            r0 = r16
            r6 = r17
            goto L_0x00fe
        L_0x0265:
            java.lang.String r0 = "events"
            r2.put(r0, r7)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x026f }
            return r0
        L_0x026f:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.dxmpay.statistics.internal.f.ad(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String qw() {
        String str = Build.MANUFACTURER;
        String trim = str == null ? RomUtils.UNKNOWN : str.trim();
        try {
            if (!TextUtils.isEmpty(trim)) {
                for (String next : qw) {
                    if (next.equalsIgnoreCase(trim)) {
                        return next;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trim;
    }
}
