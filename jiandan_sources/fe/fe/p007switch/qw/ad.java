package fe.fe.p007switch.qw;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobstat.dxmpay.SessionAnalysis;

/* renamed from: fe.fe.switch.qw.ad  reason: invalid package */
public class ad {

    /* renamed from: rg  reason: collision with root package name */
    public static ad f3004rg;

    /* renamed from: ad  reason: collision with root package name */
    public volatile boolean f3005ad = false;

    /* renamed from: de  reason: collision with root package name */
    public SessionAnalysis f3006de;

    /* renamed from: fe  reason: collision with root package name */
    public Runnable f3007fe;
    public Handler qw;

    /* renamed from: fe.fe.switch.qw.ad$ad  reason: collision with other inner class name */
    public class C0144ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3008ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f3009th;

        public C0144ad(Context context, long j) {
            this.f3008ad = context;
            this.f3009th = j;
        }

        public void run() {
            ad.this.f3006de.fe(this.f3008ad, this.f3009th);
        }
    }

    /* renamed from: fe.fe.switch.qw.ad$de */
    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3011ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f3012th;

        public de(Context context, long j) {
            this.f3011ad = context;
            this.f3012th = j;
        }

        public void run() {
            ad.this.f3006de.de(this.f3011ad, this.f3012th);
        }
    }

    /* renamed from: fe.fe.switch.qw.ad$fe */
    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3014ad;

        public fe(Context context) {
            this.f3014ad = context;
        }

        public void run() {
            ad.this.f3006de.th(this.f3014ad, System.currentTimeMillis());
        }
    }

    /* renamed from: fe.fe.switch.qw.ad$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3016ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f3017th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ boolean f3019yj;

        public qw(Context context, long j, boolean z) {
            this.f3016ad = context;
            this.f3017th = j;
            this.f3019yj = z;
        }

        public void run() {
            ad.this.f3006de.i(this.f3016ad, this.f3017th, this.f3019yj);
        }
    }

    /* renamed from: fe.fe.switch.qw.ad$rg */
    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3020ad;

        public rg(Context context) {
            this.f3020ad = context;
        }

        public void run() {
            if (!ad.this.f3005ad) {
                uk.qw(this.f3020ad);
                boolean unused = ad.this.f3005ad = true;
            }
        }
    }

    public ad() {
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.qw = new Handler(handlerThread.getLooper());
        this.f3006de = new SessionAnalysis();
        new fe();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        new Handler(handlerThread2.getLooper());
    }

    /* renamed from: if  reason: not valid java name */
    public static ad m207if() {
        if (f3004rg == null) {
            synchronized (ad.class) {
                if (f3004rg == null) {
                    f3004rg = new ad();
                }
            }
        }
        return f3004rg;
    }

    public void fe(Context context) {
        if (context != null) {
            pf(context);
            this.qw.post(new de(context, System.currentTimeMillis()));
        }
    }

    public void i(Context context) {
        if (context != null) {
            int uk2 = this.f3006de.uk();
            fe feVar = new fe(context);
            this.f3007fe = feVar;
            this.qw.postDelayed(feVar, (long) uk2);
        }
    }

    public int o() {
        return this.f3006de.yj();
    }

    public void pf(Context context) {
        qw(context);
        if (!this.f3005ad) {
            qw.ad(context);
            this.qw.post(new rg(context));
        }
    }

    public final void qw(Context context) {
    }

    public void rg(Context context) {
        if (context != null) {
            pf(context);
            this.qw.post(new C0144ad(context, System.currentTimeMillis()));
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m208switch(Context context, boolean z) {
        if (context != null) {
            pf(context);
            yj(context);
            this.qw.post(new qw(context, System.currentTimeMillis(), z));
        }
    }

    public void uk() {
        Runnable runnable = this.f3007fe;
        if (runnable != null) {
            this.qw.removeCallbacks(runnable);
        }
        this.f3007fe = null;
    }

    public final void yj(Context context) {
    }
}
