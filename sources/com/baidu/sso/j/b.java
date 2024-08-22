package com.baidu.sso.j;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sso.g.d;
import com.baidu.sso.n.e;
import com.baidu.sso.n.f;
import com.baidu.sso.n.h;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportEngine */
public class b extends com.baidu.sso.g.a {

    /* renamed from: g  reason: collision with root package name */
    private static volatile b f3608g;

    /* renamed from: c  reason: collision with root package name */
    private d f3609c;

    /* renamed from: d  reason: collision with root package name */
    private c f3610d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f3611e;

    /* renamed from: f  reason: collision with root package name */
    private int f3612f = 0;

    /* compiled from: ReportEngine */
    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                boolean unused = b.this.a(true);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
            }
        }
    }

    /* renamed from: com.baidu.sso.j.b$b  reason: collision with other inner class name */
    /* compiled from: ReportEngine */
    class C0052b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f3614a;

        C0052b(long j2) {
            this.f3614a = j2;
        }

        public void run() {
            try {
                if (b.this.a(false)) {
                    com.baidu.sso.a.a.a(b.this.f3611e).e(this.f3614a);
                }
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
            }
        }
    }

    /* compiled from: ReportEngine */
    class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                boolean unused = b.a(b.this.f3611e).a(true);
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
            }
        }
    }

    private b(Context context, Handler handler) {
        super(context, handler);
        this.f3611e = context;
        this.f3609c = d.a(context);
        this.f3610d = new c();
    }

    public void b() {
        if (com.baidu.sso.a.a.a(this.f3611e).E() && com.baidu.sso.n.c.k(this.f3611e)) {
            a.b().post(new c());
        }
    }

    public static b a(Context context) {
        if (f3608g == null) {
            synchronized (b.class) {
                if (f3608g == null) {
                    f3608g = new b(context, (Handler) null);
                }
            }
        }
        return f3608g;
    }

    public synchronized void a(String str, String str2, int i2) {
        try {
            com.baidu.sso.l.a a2 = this.f3610d.a(this.f3611e, str, str2, i2, 1);
            if (a2 != null) {
                this.f3612f++;
                com.baidu.sso.k.a.a(this.f3611e).b(a2);
                if (this.f3612f >= 2 && com.baidu.sso.a.a.a(this.f3611e).E() && com.baidu.sso.n.c.k(this.f3611e)) {
                    this.f3612f = 0;
                    a.b().post(new a());
                }
            } else {
                return;
            }
        } catch (Throwable th2) {
            com.baidu.sso.n.c.a(th2);
        }
        return;
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z) {
        boolean z2;
        ArrayList<com.baidu.sso.l.a> arrayList;
        try {
            int e2 = com.baidu.sso.n.c.e(this.f3611e);
            if (e2 == 2) {
                z2 = false;
            } else {
                if (e2 == 1) {
                    z2 = true;
                }
                return false;
            }
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                arrayList = com.baidu.sso.k.a.a(this.f3611e).b(valueOf);
                String k = com.baidu.sso.a.a.a(this.f3611e).k();
                String a2 = com.baidu.sso.n.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(k)) {
                    com.baidu.sso.a.a.a(this.f3611e).c(a2);
                    com.baidu.sso.a.a.a(this.f3611e).h(0);
                }
            } else {
                arrayList = com.baidu.sso.k.a.a(this.f3611e).a(valueOf);
            }
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    long w = com.baidu.sso.a.a.a(this.f3611e).w();
                    int size = arrayList.size();
                    long r = ((long) com.baidu.sso.a.a.a(this.f3611e).r()) * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        com.baidu.sso.l.a aVar = arrayList.get(i2);
                        if (aVar != null) {
                            String b2 = aVar.b();
                            if (z2) {
                                if (((long) b2.length()) + w > r) {
                                    break;
                                }
                                w += (long) b2.length();
                            }
                            a(jSONArray, b2);
                            arrayList2.add(aVar);
                        }
                        i2++;
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean a3 = a(jSONArray.toString());
                    if (a3) {
                        com.baidu.sso.k.a.a(this.f3611e).a((ArrayList<com.baidu.sso.l.a>) arrayList2);
                        if (z2) {
                            com.baidu.sso.a.a.a(this.f3611e).h(com.baidu.sso.a.a.a(this.f3611e).w() + ((long) jSONArray.toString().length()));
                        }
                    }
                    return a3;
                }
            }
            return false;
        } catch (Throwable th2) {
            com.baidu.sso.n.c.a(th2);
            return false;
        }
    }

    public void a() {
        long l = com.baidu.sso.a.a.a(this.f3611e).l();
        long t = ((long) com.baidu.sso.a.a.a(this.f3611e).t()) * com.baidu.sso.n.c.f3678b;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - l >= t && com.baidu.sso.n.c.e(this.f3611e) != 0 && com.baidu.sso.a.a.a(this.f3611e).E() && com.baidu.sso.n.c.k(this.f3611e)) {
            a.b().post(new C0052b(currentTimeMillis));
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.baidu.sso.h.a b2 = com.baidu.sso.h.b.b(com.baidu.sso.h.b.a(), f.a(str.getBytes("utf-8")));
            if (b2 == null) {
                return false;
            }
            String a2 = this.f3609c.a("p/1/r", URLEncoder.encode(Base64.encodeToString(e.b(b2.a(), h.a(com.baidu.sso.n.d.a(this.f3611e)).getBytes()), 0), "utf-8"));
            if (b2.b() == null) {
                return false;
            }
            String a3 = a(a2, b2.b());
            if (TextUtils.isEmpty(a3)) {
                return false;
            }
            try {
                if (new JSONObject(a3).getInt("response") == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                com.baidu.sso.n.c.a(th2);
            }
        } catch (Throwable th3) {
            com.baidu.sso.n.c.a(th3);
            return false;
        }
    }

    private JSONArray a(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th2) {
            com.baidu.sso.n.c.a(th2);
        }
        return jSONArray;
    }
}
