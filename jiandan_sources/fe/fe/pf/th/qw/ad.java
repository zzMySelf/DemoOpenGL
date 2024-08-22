package fe.fe.pf.th.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.baidu.helios.clouds.cuidstore.ICstore;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ad {

    /* renamed from: i  reason: collision with root package name */
    public static ad f2911i;

    /* renamed from: ad  reason: collision with root package name */
    public AtomicInteger f2912ad;

    /* renamed from: de  reason: collision with root package name */
    public ICstore f2913de;

    /* renamed from: fe  reason: collision with root package name */
    public fe.fe.pf.th.qw.o.ad f2914fe;
    public Thread qw;

    /* renamed from: rg  reason: collision with root package name */
    public HashMap<String, String> f2915rg;

    /* renamed from: th  reason: collision with root package name */
    public HashMap<String, String> f2916th;

    /* renamed from: uk  reason: collision with root package name */
    public Context f2917uk;

    /* renamed from: yj  reason: collision with root package name */
    public i f2918yj;

    /* renamed from: fe.fe.pf.th.qw.ad$ad  reason: collision with other inner class name */
    public static class C0140ad {
        public static C0140ad qw;

        public C0140ad(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            } else if (ad.f2911i == null) {
                synchronized (ad.class) {
                    if (ad.f2911i == null) {
                        ad unused = ad.f2911i = new ad(context.getApplicationContext(), (qw) null);
                    }
                }
            }
        }

        public static C0140ad de(Context context) {
            if (qw == null) {
                synchronized (ad.class) {
                    if (qw == null) {
                        qw = new C0140ad(context);
                    }
                }
            }
            return qw;
        }

        public ad ad() {
            if (ad.f2911i.f2914fe == null) {
                qw();
            }
            return ad.f2911i;
        }

        public final void qw() {
            HashMap unused = ad.f2911i.f2915rg = new HashMap();
            ad.f2911i.f2915rg.put("Charset", a.h);
            ad.f2911i.f2915rg.put("Content-type", "application/json");
            fe.fe.pf.th.qw.o.ad unused2 = ad.f2911i.f2914fe = new fe.fe.pf.th.qw.vvv.qw();
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            boolean z;
            ad adVar = ad.this;
            ICstore unused = adVar.f2913de = new th(adVar.f2917uk);
            if (ad.this.f2918yj != null) {
                ad.this.f2918yj.ad(ad.this.f2913de.qw());
                z = ad.this.f2918yj.a();
            } else {
                z = false;
            }
            if (z && ad.this.pf()) {
                ad.this.m202switch();
                ad.this.ppp();
            }
            Thread unused2 = ad.this.qw = null;
        }
    }

    public ad(Context context) {
        this.f2912ad = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f2917uk = context;
        this.f2918yj = new when(context);
    }

    public /* synthetic */ ad(Context context, qw qwVar) {
        this(context);
    }

    public void nn() {
        synchronized (ad.class) {
            if (this.f2912ad.get() == 0) {
                if (this.f2917uk != null) {
                    this.f2912ad.set(1);
                    if (this.qw == null) {
                        this.qw = new Thread(uk());
                    }
                    this.qw.start();
                } else {
                    throw new NullPointerException("context should not be null");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.qw();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean pf() {
        /*
            r5 = this;
            java.lang.String r0 = "https://mbd.baidu.com/store"
            java.lang.String r0 = r5.rg(r0)
            fe.fe.pf.th.qw.o.ad r1 = r5.f2914fe
            if (r1 == 0) goto L_0x001f
            com.baidu.helios.clouds.cuidstore.http.IHttpRequest r1 = r1.qw()
            if (r1 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r5.f2915rg
            com.baidu.helios.clouds.cuidstore.ICstore r3 = r5.f2913de
            org.json.JSONObject r3 = r3.qw()
            java.lang.String r4 = "POST"
            java.lang.String r0 = r1.qw(r0, r4, r2, r3)
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            org.json.JSONObject r0 = fe.fe.pf.th.qw.Cswitch.qw(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0028
            return r1
        L_0x0028:
            r2 = -1
            java.lang.String r3 = "errno"
            int r0 = r0.optInt(r3, r2)
            if (r0 != 0) goto L_0x0032
            r1 = 1
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.th.qw.ad.pf():boolean");
    }

    public final void ppp() {
        AtomicInteger atomicInteger = this.f2912ad;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public final String rg(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, String> hashMap = this.f2916th;
            return hashMap == null ? str : ggg.ad(str, hashMap);
        }
        throw new NullPointerException("url should not be empty");
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m202switch() {
        i iVar = this.f2918yj;
        if (iVar != null) {
            iVar.qw(this.f2913de.qw());
        }
    }

    public final Runnable uk() {
        return new qw();
    }
}
