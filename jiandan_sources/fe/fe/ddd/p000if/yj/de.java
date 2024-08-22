package fe.fe.ddd.p000if.yj;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;

/* renamed from: fe.fe.ddd.if.yj.de  reason: invalid package */
public class de {

    /* renamed from: uk  reason: collision with root package name */
    public static volatile de f1485uk;

    /* renamed from: ad  reason: collision with root package name */
    public Handler f1486ad;

    /* renamed from: de  reason: collision with root package name */
    public qw f1487de;

    /* renamed from: fe  reason: collision with root package name */
    public ad f1488fe;
    public HandlerThread qw;

    /* renamed from: rg  reason: collision with root package name */
    public fe.fe.ddd.p000if.th.ad f1489rg;

    /* renamed from: th  reason: collision with root package name */
    public fe f1490th;

    /* renamed from: yj  reason: collision with root package name */
    public fe.fe.ddd.p000if.uk.ad f1491yj;

    /* renamed from: fe.fe.ddd.if.yj.de$ad */
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f1492ad;

        /* renamed from: de  reason: collision with root package name */
        public int f1493de;
        public Runnable qw;

        public ad(Runnable runnable, String str, int i2) {
            this.qw = runnable;
            this.f1492ad = str;
            this.f1493de = i2;
        }
    }

    /* renamed from: fe.fe.ddd.if.yj.de$qw */
    public class qw extends Handler {
        public qw(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    if (obj instanceof ad) {
                        ad adVar = (ad) obj;
                        de.this.f1489rg.fe(adVar.qw, adVar.f1492ad, adVar.f1493de);
                    }
                    int unused = de.this.rrr();
                    return;
                case 2:
                    int unused2 = de.this.rrr();
                    return;
                case 3:
                    if (de.this.f1488fe.qw() > 0) {
                        int unused3 = de.this.rrr();
                        return;
                    }
                    return;
                case 4:
                    Object obj2 = message.obj;
                    if (obj2 instanceof ad) {
                        ad adVar2 = (ad) obj2;
                        de.this.f1490th.ad(adVar2.qw, adVar2.f1492ad, adVar2.f1493de);
                        boolean unused4 = de.this.a();
                        return;
                    }
                    return;
                case 5:
                    boolean unused5 = de.this.a();
                    return;
                case 6:
                    de.this.f1490th.qw();
                    return;
                case 7:
                    de.this.i();
                    return;
                case 8:
                    de.this.o();
                    return;
                case 9:
                    fe.fe.ddd.p000if.uk.qw.qw().rg();
                    de.this.mmm(fe.fe.ddd.p000if.de.f1469uk);
                    return;
                default:
                    return;
            }
        }
    }

    public de() {
        synchronized (fe.fe.ddd.p000if.de.fe()) {
            ppp();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static de m70switch() {
        if (f1485uk == null) {
            synchronized (de.class) {
                if (f1485uk == null) {
                    f1485uk = new de();
                }
            }
        }
        return f1485uk;
    }

    public final boolean a() {
        return this.f1490th.rg();
    }

    public void aaa(long j) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        this.f1486ad.sendMessageDelayed(obtain, j);
    }

    public void ddd(long j) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        this.f1486ad.sendMessageDelayed(obtain, j);
    }

    public void eee(long j) {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.f1486ad.sendMessageDelayed(obtain, j);
    }

    public void ggg() {
        vvv(0);
    }

    public final void i() {
        if (!fe.fe.ddd.p000if.de.de()) {
            Recordable.RecordStatus ad2 = this.f1491yj.ad();
            Recordable.RecordStatus recordStatus = Recordable.RecordStatus.RECORDING;
            this.f1491yj.th();
            this.f1487de.rg();
            this.f1488fe.yj();
            this.f1489rg.rg();
            this.f1490th.de();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public ad m71if() {
        return this.f1488fe;
    }

    public final void mmm(long j) {
    }

    public void nn(Runnable runnable, String str, int i2, long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = new ad(runnable, str, i2);
        this.f1486ad.sendMessageDelayed(obtain, j);
    }

    public final void o() {
        if (!fe.fe.ddd.p000if.de.de() && this.f1491yj.ad() == Recordable.RecordStatus.RECORDING) {
            this.f1491yj.yj();
            this.f1487de.th();
            this.f1488fe.uk();
            this.f1489rg.th();
            this.f1490th.fe();
            if (this.f1491yj.qw() > 30000) {
                this.f1491yj.uk();
            }
        }
    }

    public qw pf() {
        return this.f1487de;
    }

    public final void ppp() {
        fe.fe.ddd.p000if.de.yj();
        fe.fe.ddd.p000if.de.th(true);
        this.f1487de = new qw();
        this.f1488fe = new ad();
        this.f1489rg = new fe.fe.ddd.p000if.th.ad();
        this.f1490th = new fe();
        this.f1491yj = new fe.fe.ddd.p000if.uk.ad();
        HandlerThread handlerThread = new HandlerThread("ElasticSchedulerThread");
        this.qw = handlerThread;
        handlerThread.start();
        this.f1486ad = new qw(this.qw.getLooper());
        mmm(fe.fe.ddd.p000if.de.f1469uk);
    }

    public void qqq() {
        eee(0);
    }

    public final int rrr() {
        int i2 = 0;
        while (tt()) {
            i2++;
        }
        ggg();
        return i2;
    }

    public final boolean tt() {
        ElasticTask ad2 = this.f1489rg.ad();
        if (ad2 == null) {
            return false;
        }
        if (this.f1487de.qw(ad2)) {
            this.f1489rg.yj(ad2);
            return true;
        } else if (!this.f1488fe.de(ad2)) {
            return false;
        } else {
            this.f1489rg.yj(ad2);
            return true;
        }
    }

    public void vvv(long j) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f1486ad.sendMessageDelayed(obtain, j);
    }

    public fe.fe.ddd.p000if.th.ad when() {
        return this.f1489rg;
    }

    public void xxx() {
        ddd(0);
    }
}
