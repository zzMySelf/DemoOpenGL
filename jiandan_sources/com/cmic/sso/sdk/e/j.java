package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.a;

public class j {
    @SuppressLint({"StaticFieldLeak"})
    public static j b;
    public final Context a;

    public j(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        b = new j(context);
    }

    public String b() {
        try {
            int a2 = a.a().b().a();
            if (a2 >= 0) {
                return Integer.toString(a2);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String simOperator = telephonyManager.getSimOperator();
        c.b("SIMUtils", "SysOperator= " + simOperator);
        return simOperator;
    }

    public static j a() {
        return b;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        return b(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r3) {
        /*
            r2 = this;
            r3.hashCode()
            int r0 = r3.hashCode()
            r1 = 49679479(0x2f60c77, float:3.6153606E-37)
            if (r0 == r1) goto L_0x007e
            r1 = 49679502(0x2f60c8e, float:3.6153657E-37)
            if (r0 == r1) goto L_0x0072
            switch(r0) {
                case 49679470: goto L_0x0067;
                case 49679471: goto L_0x005c;
                case 49679472: goto L_0x0051;
                case 49679473: goto L_0x0046;
                case 49679474: goto L_0x003b;
                case 49679475: goto L_0x0030;
                case 49679476: goto L_0x0023;
                case 49679477: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0086
        L_0x0016:
            java.lang.String r0 = "46007"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0020
            goto L_0x0086
        L_0x0020:
            r3 = 7
            goto L_0x008a
        L_0x0023:
            java.lang.String r0 = "46006"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x002d
            goto L_0x0086
        L_0x002d:
            r3 = 6
            goto L_0x008a
        L_0x0030:
            java.lang.String r0 = "46005"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0039
            goto L_0x0086
        L_0x0039:
            r3 = 5
            goto L_0x008a
        L_0x003b:
            java.lang.String r0 = "46004"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0044
            goto L_0x0086
        L_0x0044:
            r3 = 4
            goto L_0x008a
        L_0x0046:
            java.lang.String r0 = "46003"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x004f
            goto L_0x0086
        L_0x004f:
            r3 = 3
            goto L_0x008a
        L_0x0051:
            java.lang.String r0 = "46002"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x005a
            goto L_0x0086
        L_0x005a:
            r3 = 2
            goto L_0x008a
        L_0x005c:
            java.lang.String r0 = "46001"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0065
            goto L_0x0086
        L_0x0065:
            r3 = 1
            goto L_0x008a
        L_0x0067:
            java.lang.String r0 = "46000"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0070
            goto L_0x0086
        L_0x0070:
            r3 = 0
            goto L_0x008a
        L_0x0072:
            java.lang.String r0 = "46011"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x007b
            goto L_0x0086
        L_0x007b:
            r3 = 9
            goto L_0x008a
        L_0x007e:
            java.lang.String r0 = "46009"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0088
        L_0x0086:
            r3 = -1
            goto L_0x008a
        L_0x0088:
            r3 = 8
        L_0x008a:
            java.lang.String r0 = "SIMUtils"
            switch(r3) {
                case 0: goto L_0x00a2;
                case 1: goto L_0x009a;
                case 2: goto L_0x00a2;
                case 3: goto L_0x0092;
                case 4: goto L_0x00a2;
                case 5: goto L_0x0092;
                case 6: goto L_0x009a;
                case 7: goto L_0x00a2;
                case 8: goto L_0x009a;
                case 9: goto L_0x0092;
                default: goto L_0x008f;
            }
        L_0x008f:
            java.lang.String r3 = "0"
            return r3
        L_0x0092:
            java.lang.String r3 = "中国电信"
            com.cmic.sso.sdk.e.c.a(r0, r3)
            java.lang.String r3 = "3"
            return r3
        L_0x009a:
            java.lang.String r3 = "中国联通"
            com.cmic.sso.sdk.e.c.a(r0, r3)
            java.lang.String r3 = "2"
            return r3
        L_0x00a2:
            java.lang.String r3 = "中国移动"
            com.cmic.sso.sdk.e.c.a(r0, r3)
            java.lang.String r3 = "1"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.e.j.b(java.lang.String):java.lang.String");
    }
}
