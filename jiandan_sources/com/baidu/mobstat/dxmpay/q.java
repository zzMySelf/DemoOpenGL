package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import fe.fe.p007switch.qw.when;

public class q extends when {

    /* renamed from: ad  reason: collision with root package name */
    public static q f906ad = new q();
    public static final String qw = "__Baidu_Stat_SDK_SendRem";

    public static q i() {
        return f906ad;
    }

    public boolean a(Context context) {
        return rg(context, "mtjsdkmactrick", true);
    }

    public String aaa(Context context) {
        return de(context, "mtjsdkmacsstv_2", (String) null);
    }

    public SharedPreferences ad(Context context) {
        return context.getSharedPreferences(qw, 0);
    }

    public String b(Context context) {
        return de(context, "custom_userid", "");
    }

    public String c(Context context) {
        return de(context, "last_custom_userid", "");
    }

    public String d(Context context) {
        return de(context, "user_property", "");
    }

    public boolean ddd(Context context) {
        return rg(context, "setchannelwithcode", false);
    }

    public String e(Context context) {
        return de(context, "out_oaid", "");
    }

    public String eee(Context context) {
        return de(context, "he.ext", (String) null);
    }

    public void ggg(Context context, String str) {
        yj(context, "mtjsdkmacsstv_2", str);
    }

    /* renamed from: if  reason: not valid java name */
    public int m31if(Context context) {
        return qw(context, "sendLogtype", 0);
    }

    public boolean mmm(Context context) {
        return rg(context, "mtjtv", false);
    }

    public void nn(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        yj(context, "custom_userid", str);
    }

    public void o(Context context, int i2) {
        th(context, "sendLogtype", i2);
    }

    public void pf(Context context, boolean z) {
        uk(context, "onlywifi", z);
    }

    public int ppp(Context context) {
        return qw(context, "timeinterval", 1);
    }

    public void qqq(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        yj(context, "last_custom_userid", str);
    }

    public void rrr(Context context, String str) {
        yj(context, "encrypt_device_id", str);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m32switch(Context context, int i2) {
        th(context, "timeinterval", i2);
    }

    public String tt(Context context) {
        return de(context, "he.push", (String) null);
    }

    public boolean vvv(Context context) {
        return rg(context, "onlywifi", false);
    }

    public void when(Context context, String str) {
        if (de(context, "cuid", (String) null) != null) {
            fe(context, "cuid");
        }
        yj(context, "cuidsec_2", str);
        fe(context, "cuidsec_2");
        fe(context, "cuidsec_1");
        fe(context, "cuidsec_2");
    }

    public String xxx(Context context) {
        return de(context, "setchannelwithcodevalue", (String) null);
    }
}
