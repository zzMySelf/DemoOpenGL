package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.al;
import java.util.HashMap;

public final class fc {

    /* renamed from: a  reason: collision with root package name */
    private static volatile fc f6989a;

    /* renamed from: a  reason: collision with other field name */
    private int f377a;

    /* renamed from: a  reason: collision with other field name */
    private Context f378a;

    /* renamed from: a  reason: collision with other field name */
    private fg f379a;

    /* renamed from: a  reason: collision with other field name */
    private String f380a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<fe, ff> f381a;

    /* renamed from: b  reason: collision with root package name */
    private String f6990b;

    private fc(Context context) {
        HashMap<fe, ff> hashMap = new HashMap<>();
        this.f381a = hashMap;
        this.f378a = context;
        hashMap.put(fe.SERVICE_ACTION, new fi());
        this.f381a.put(fe.SERVICE_COMPONENT, new fj());
        this.f381a.put(fe.ACTIVITY, new fa());
        this.f381a.put(fe.PROVIDER, new fh());
    }

    public static fc a(Context context) {
        if (f6989a == null) {
            synchronized (fc.class) {
                if (f6989a == null) {
                    f6989a = new fc(context);
                }
            }
        }
        return f6989a;
    }

    public void a(String str, String str2, int i2, fg fgVar) {
        a(str);
        b(str2);
        a(i2);
        a(fgVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fg m8505a() {
        return this.f379a;
    }

    public void a(fg fgVar) {
        this.f379a = fgVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8506a() {
        return this.f380a;
    }

    public void a(String str) {
        this.f380a = str;
    }

    public String b() {
        return this.f6990b;
    }

    public void b(String str) {
        this.f6990b = str;
    }

    public int a() {
        return this.f377a;
    }

    public void a(int i2) {
        this.f377a = i2;
    }

    public void a(Context context, String str, int i2, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            ey.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i2);
        ag.a(this.f378a).a((Runnable) new fd(this, str, context, str2, str3));
    }

    public void a(fe feVar, Context context, Intent intent, String str) {
        if (feVar != null) {
            this.f381a.get(feVar).a(context, intent, str);
        } else {
            ey.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    /* access modifiers changed from: private */
    public void a(fe feVar, Context context, fb fbVar) {
        this.f381a.get(feVar).a(context, fbVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8504a(Context context) {
        return al.a(context, context.getPackageName());
    }
}
