package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.app.OpenAuthTask;
import com.alipay.sdk.m.j.a;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.n;
import com.google.android.material.timepicker.ChipTextInputComboView;
import java.util.Random;

public class b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    public b() {
        String a2 = a.a();
        if (!a.b()) {
            this.b += '_' + a2;
        }
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                g = new b();
            }
            bVar = g;
        }
        return bVar;
    }

    public static String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(OpenAuthTask.OK) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        String str;
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b2).d())) {
            str = c();
        } else {
            str = c.b(b2).b();
        }
        String str2 = str;
        sharedPreferences.edit().putString(e, str2).apply();
        return str2;
    }

    public static String g() {
        String str;
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b2).d())) {
            String c2 = com.alipay.sdk.m.s.b.d().c();
            if (TextUtils.isEmpty(c2) || c2.length() < 18) {
                str = c();
            } else {
                str = c2.substring(3, 18);
            }
        } else {
            str = c.b(b2).c();
        }
        String str2 = str;
        sharedPreferences.edit().putString(f, str2).apply();
        return str2;
    }

    public static String h() {
        return ChipTextInputComboView.TextFormatter.DEFAULT_TEXT;
    }

    public static String i() {
        return "-1";
    }

    public String a() {
        return this.c;
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(str)) {
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.f665i, str).apply();
                com.alipay.sdk.m.l.a.f = str;
            }
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(i.b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) {
        com.alipay.sdk.m.s.a aVar3 = aVar;
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        c b3 = c.b(b2);
        if (TextUtils.isEmpty(this.a)) {
            String f2 = n.f();
            String e2 = n.e();
            String c2 = n.c(b2);
            String e3 = n.e(b2);
            String f3 = n.f(b2);
            String a2 = a(b2);
            this.a = "Msp/15.8.16" + " (" + f2 + i.b + e2 + i.b + c2 + i.b + e3 + i.b + f3 + i.b + a2;
        }
        String b4 = c.d(b2).b();
        String b5 = n.b(b2);
        String e4 = e();
        String c3 = b3.c();
        String b6 = b3.b();
        String g2 = g();
        String f4 = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        String replace = Build.MANUFACTURER.replace(i.b, " ");
        String replace2 = Build.MODEL.replace(i.b, " ");
        boolean e5 = com.alipay.sdk.m.s.b.e();
        String d2 = b3.d();
        String i2 = i();
        String h = h();
        Context context = b2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(i.b);
        sb.append(b4);
        sb.append(i.b);
        sb.append(b5);
        sb.append(i.b);
        sb.append(e4);
        sb.append(i.b);
        sb.append(c3);
        sb.append(i.b);
        sb.append(b6);
        sb.append(i.b);
        sb.append(this.c);
        sb.append(i.b);
        sb.append(replace);
        sb.append(i.b);
        sb.append(replace2);
        sb.append(i.b);
        sb.append(e5);
        sb.append(i.b);
        sb.append(d2);
        sb.append(i.b);
        sb.append(d());
        sb.append(i.b);
        sb.append(this.b);
        sb.append(i.b);
        sb.append(g2);
        sb.append(i.b);
        sb.append(f4);
        sb.append(i.b);
        sb.append(i2);
        sb.append(i.b);
        sb.append(h);
        if (aVar2 != null) {
            com.alipay.sdk.m.s.a aVar4 = aVar;
            Context context2 = context;
            String a3 = com.alipay.sdk.m.w.b.a(aVar4, context2, com.alipay.sdk.m.t.a.a(context2).d(), com.alipay.sdk.m.w.b.c(aVar4, context2));
            if (!TextUtils.isEmpty(a3)) {
                sb.append(";;;");
                sb.append(a3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
