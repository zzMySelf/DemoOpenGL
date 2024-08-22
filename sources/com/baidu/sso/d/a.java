package com.baidu.sso.d;

import android.content.Context;
import com.baidu.searchbox.reactnative.views.video.RNSearchBoxVideoManager;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: CMInfo */
public class a extends d {
    private AuthnHelper s;
    /* access modifiers changed from: private */
    public long t = 0;
    /* access modifiers changed from: private */
    public long u = 0;
    private boolean v = false;

    /* renamed from: com.baidu.sso.d.a$a  reason: collision with other inner class name */
    /* compiled from: CMInfo */
    class C0047a extends b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3470b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3471c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3472d;

        C0047a(long j2, int i2, int i3, int i4) {
            this.f3470b = i2;
            this.f3471c = i3;
            this.f3472d = i4;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            int i2;
            long currentTimeMillis = System.currentTimeMillis() - a();
            int optInt = jSONObject.optInt("resultCode", -1);
            if (!a.this.b(optInt, this.f3470b) || (i2 = this.f3471c) != 0) {
                a.this.b(jSONObject, this.f3470b);
            } else {
                a.this.a(this.f3470b, this.f3472d, i2 + 1);
            }
            i.a().d();
            a aVar = a.this;
            com.baidu.sso.j.e.a(aVar.f3494a, aVar.f3496c, optInt, currentTimeMillis, this.f3472d, "");
        }
    }

    /* compiled from: CMInfo */
    class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3474a;

        b(int i2) {
            this.f3474a = i2;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            a.this.c(jSONObject, this.f3474a);
        }
    }

    /* compiled from: CMInfo */
    class c extends com.baidu.sso.m.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f3476b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3477c;

        c(JSONObject jSONObject, int i2) {
            this.f3476b = jSONObject;
            this.f3477c = i2;
        }

        public void a() {
            try {
                int optInt = this.f3476b.optInt("resultCode", -1);
                String optString = this.f3476b.optString("authTypeDes", "");
                if (optInt == 103000) {
                    long unused = a.this.u = System.currentTimeMillis();
                    a.this.f3501h = this.f3476b.optString("token", "");
                    a aVar = a.this;
                    aVar.a(this.f3477c, 0, 0, aVar.f3496c, "preVerify success", 3);
                    return;
                }
                if (optInt == 105312) {
                    a aVar2 = a.this;
                    if (aVar2.f3496c != aVar2.f3497d) {
                        a aVar3 = a.this;
                        aVar3.a(this.f3477c, 3, 2002, aVar3.f3496c, "pre verify" + " error, wrong sim operator", 3);
                        return;
                    }
                }
                a aVar4 = a.this;
                aVar4.a(this.f3477c, 2, optInt, aVar4.f3496c, "pre verify" + " error." + optString, 3);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
                a aVar5 = a.this;
                aVar5.a(this.f3477c, 3, 2009, aVar5.f3496c, "cm on handle " + "pre verify" + " unknown error.", 3);
            }
        }
    }

    /* compiled from: CMInfo */
    class d extends com.baidu.sso.m.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f3479b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3480c;

        d(JSONObject jSONObject, int i2) {
            this.f3479b = jSONObject;
            this.f3480c = i2;
        }

        public void a() {
            try {
                int optInt = this.f3479b.optInt("resultCode", -1);
                String optString = this.f3479b.optString("desc", "");
                if (optInt == 103000) {
                    long unused = a.this.t = System.currentTimeMillis();
                    a.this.f3500g = this.f3479b.optString("securityphone", "");
                    JSONObject jSONObject = new JSONObject();
                    a aVar = a.this;
                    jSONObject.put("fakeMobile", aVar.a(aVar.f3500g));
                    a aVar2 = a.this;
                    aVar2.a(this.f3480c, 0, 0, aVar2.f3496c, jSONObject.toString(), 1);
                    return;
                }
                if (optInt == 105312) {
                    a aVar3 = a.this;
                    if (aVar3.f3496c != aVar3.f3497d) {
                        a aVar4 = a.this;
                        aVar4.a(this.f3480c, 3, 2002, aVar4.f3496c, "pre login" + " error, wrong sim operator", 1);
                        return;
                    }
                }
                a aVar5 = a.this;
                aVar5.a(this.f3480c, 2, optInt, aVar5.f3496c, "pre login" + " error." + optString, 1);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
                a aVar6 = a.this;
                aVar6.a(this.f3480c, 3, 2009, aVar6.f3496c, "cm on handle " + "pre login" + " unknown error.", 1);
            }
        }
    }

    /* compiled from: CMInfo */
    class e extends com.baidu.sso.m.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f3482b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3483c;

        e(JSONObject jSONObject, int i2) {
            this.f3482b = jSONObject;
            this.f3483c = i2;
        }

        public void a() {
            int i2;
            try {
                if (this.f3482b.has("resultCode")) {
                    i2 = this.f3482b.optInt("resultCode", -1);
                } else {
                    i2 = -1;
                }
                if (i2 == 103000) {
                    a.this.f3498e = this.f3482b.optString("token");
                    a.this.a(this.f3483c);
                    return;
                }
                String optString = this.f3482b.optString("resultDesc", "");
                a aVar = a.this;
                aVar.a(this.f3483c, 2, i2, aVar.f3496c, "error:" + optString);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
                a aVar2 = a.this;
                aVar2.a(this.f3483c, 3, 2009, aVar2.f3496c, "cm on handle login unknown error.");
            }
        }
    }

    /* compiled from: CMInfo */
    class f extends com.baidu.sso.m.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3485b;

        f(int i2) {
            this.f3485b = i2;
        }

        public void a() {
            try {
                a aVar = a.this;
                aVar.a(this.f3485b, aVar.f3496c, aVar.f3501h);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
                a aVar2 = a.this;
                aVar2.b(this.f3485b, 3, 2009, aVar2.f3496c, "cm on handle verify unknown error.");
            }
        }
    }

    /* compiled from: CMInfo */
    class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3487a;

        g(int i2) {
            this.f3487a = i2;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            a.this.a(jSONObject, this.f3487a);
        }
    }

    a(Context context) {
        super(context);
        this.f3496c = 1;
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f3498e = null;
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f3501h = null;
        this.u = 0;
    }

    /* access modifiers changed from: private */
    public void c(JSONObject jSONObject, int i2) {
        com.baidu.sso.m.e.b().a(new c(jSONObject, i2));
    }

    /* access modifiers changed from: private */
    public boolean b(int i2, int i3) {
        return com.baidu.sso.a.a.a(this.f3494a).C() && com.baidu.sso.a.a.a(this.f3494a).b("k_retry_code_cm", i2) && com.baidu.sso.b.a.a().b(i3);
    }

    private void c(int i2) {
        com.baidu.sso.m.e.b().a(new f(i2));
    }

    public void a(Context context, int i2, int i3) {
        super.a(context, i2, i3);
        if (!com.baidu.sso.a.a.a(this.f3494a).D()) {
            a(i3, 3, RNSearchBoxVideoManager.VIDEO_PLAYER_CONTROL_TYPE, this.f3496c, "pre login error. sdk stop run.", 1);
        } else if (!c()) {
            a(i3, 3, 2006, this.f3496c, "pre login error. cm has not valid config.", 1);
        } else if (com.baidu.sso.a.a.a(this.f3494a).y()) {
            if (!this.v) {
                System.currentTimeMillis();
                AuthnHelper instance = AuthnHelper.getInstance(this.f3494a);
                this.s = instance;
                instance.setOverTime(8000);
                AuthnHelper.setDebugMode(com.baidu.sso.a.a());
                this.v = true;
            }
            a(i3, i2, 0);
        } else {
            a(i3, 3, 994, this.f3496c, "pre login error. cm sdk stop run.", 1);
        }
    }

    public void b(Context context, int i2, long j2) {
        super.b(context, i2, j2);
        a(i2, 4);
        c(i2);
    }

    /* access modifiers changed from: private */
    public void b(JSONObject jSONObject, int i2) {
        com.baidu.sso.m.e.b().a(new d(jSONObject, i2));
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        this.s.getPhoneInfo(d.k, d.l, new C0047a(System.currentTimeMillis(), i2, i4, i3));
    }

    public void a(Context context, int i2) {
        super.a(context, i2);
        if (!com.baidu.sso.a.a.a(this.f3494a).D()) {
            a(i2, 3, RNSearchBoxVideoManager.VIDEO_PLAYER_CONTROL_TYPE, this.f3496c, "pre verify error. sdk stop run.", 3);
        } else if (!c()) {
            a(i2, 3, 2006, this.f3496c, "pre verify error. cm has not valid config.", 3);
        } else if (com.baidu.sso.a.a.a(this.f3494a).y()) {
            if (!this.v) {
                AuthnHelper instance = AuthnHelper.getInstance(this.f3494a);
                this.s = instance;
                instance.setOverTime(8000);
                this.v = true;
            }
            this.s.mobileAuth(d.k, d.l, new b(i2));
        } else {
            a(i2, 3, 994, this.f3496c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, int i2) {
        com.baidu.sso.m.e.b().a(new e(jSONObject, i2));
    }

    public void a(Context context, int i2, long j2) {
        super.a(context, i2, j2);
        a(i2, 2);
        this.s.loginAuth(d.k, d.l, new g(i2));
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        if (this.t != 0 && System.currentTimeMillis() - this.t < TimeUnit.HOURS.toMillis(1)) {
            return false;
        }
        return true;
    }
}
