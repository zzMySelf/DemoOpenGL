package fe.fe.pf.fe.ad;

import android.os.Bundle;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.bridge.multiprocess.g;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ad extends BaseBridge {

    /* renamed from: de  reason: collision with root package name */
    public volatile g f2713de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile fe.fe.pf.fe.qw.qw f2714fe;

    /* renamed from: i  reason: collision with root package name */
    public volatile Future<Boolean> f2715i;

    /* renamed from: if  reason: not valid java name */
    public Object f89if = new Object();

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f2716o;

    /* renamed from: pf  reason: collision with root package name */
    public String f2717pf;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f2718rg = true;

    /* renamed from: switch  reason: not valid java name */
    public Object f90switch = new Object();

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f2719th = false;

    /* renamed from: uk  reason: collision with root package name */
    public volatile Future<Boolean> f2720uk;

    /* renamed from: yj  reason: collision with root package name */
    public volatile boolean f2721yj;

    /* renamed from: fe.fe.pf.fe.ad.ad$ad  reason: collision with other inner class name */
    public class C0120ad implements Callable<Boolean> {
        public C0120ad() {
        }

        /* renamed from: qw */
        public Boolean call() {
            ad adVar = ad.this;
            g unused = adVar.f2713de = new g(adVar, adVar.f2717pf);
            ad.this.f2713de.ad(ad.this.qw);
            ad.this.f2713de.de(ad.this.f777ad);
            boolean unused2 = ad.this.f2721yj = true;
            if (ad.this.f2713de.ppp()) {
                boolean unused3 = ad.this.f2716o = true;
                return Boolean.TRUE;
            }
            boolean unused4 = ad.this.f2716o = false;
            boolean unused5 = ad.this.f2718rg = false;
            ad.this.vvv();
            return Boolean.FALSE;
        }
    }

    public class qw implements Callable<Boolean> {
        public qw() {
        }

        /* renamed from: qw */
        public Boolean call() {
            fe.fe.pf.fe.qw.qw unused = ad.this.f2714fe = new fe.fe.pf.fe.qw.qw();
            ad.this.f2714fe.ad(ad.this.qw);
            ad.this.f2714fe.de(ad.this.f777ad);
            boolean unused2 = ad.this.f2719th = true;
            return Boolean.TRUE;
        }
    }

    public ad(String str) {
        this.f2717pf = str;
    }

    public void fe() {
        if (this.f2718rg) {
            nn();
            if (this.f2716o && this.f2713de != null) {
                this.f2713de.fe();
                return;
            }
        }
        when();
        if (this.f2714fe != null) {
            this.f2714fe.fe();
        }
    }

    public final void nn() {
        if (this.f2718rg) {
            if (!this.f2721yj) {
                synchronized (this.f89if) {
                    qqq();
                }
            }
            try {
                this.f2720uk.get();
            } catch (Exception unused) {
            }
        }
    }

    public void pf() {
        this.f2718rg = false;
        vvv();
    }

    public final void qqq() {
        if (!this.f2721yj && this.f2720uk == null) {
            this.f2720uk = this.qw.f782fe.submit(new C0120ad());
        }
    }

    public void qw(String str, Bundle bundle, BaseBridge.OnGetResultCallback<String> onGetResultCallback) {
        if (this.f2718rg) {
            nn();
            if (this.f2716o) {
                this.f2713de.qw(str, bundle, onGetResultCallback);
                return;
            }
        }
        when();
        this.f2714fe.qw(str, bundle, onGetResultCallback);
    }

    public boolean rg(String str) {
        if (this.f2718rg) {
            nn();
            if (this.f2716o) {
                return this.f2713de.rg(str);
            }
        }
        when();
        return this.f2714fe.rg(str);
    }

    public void th(BaseBridge.ad adVar) {
        if (this.f2718rg) {
            synchronized (this.f89if) {
                qqq();
            }
            return;
        }
        synchronized (this.f90switch) {
            vvv();
        }
    }

    public final void vvv() {
        if (!this.f2719th && this.f2715i == null) {
            this.f2715i = this.qw.f782fe.submit(new qw());
        }
    }

    public final void when() {
        if (!this.f2718rg && !this.f2719th) {
            synchronized (this.f90switch) {
                vvv();
            }
            try {
                this.f2715i.get();
            } catch (Exception unused) {
            }
        }
    }

    public BaseBridge.de yj(String str, Bundle bundle) {
        if (this.f2718rg) {
            nn();
            if (this.f2716o) {
                BaseBridge.de yj2 = this.f2713de.yj(str, bundle);
                if (yj2.ad()) {
                    return yj2;
                }
                this.f2718rg = false;
            }
        }
        when();
        return this.f2714fe.yj(str, bundle);
    }
}
