package fe.mmm.qw.c;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.tera.scan.startup.StartupTaskListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class th {

    /* renamed from: ad  reason: collision with root package name */
    public int f7674ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public volatile int f7675de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public List<th> f7676fe;
    public Executor qw;

    /* renamed from: rg  reason: collision with root package name */
    public StartupTaskListener f7677rg;

    /* renamed from: th  reason: collision with root package name */
    public qw f7678th;

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f7679ad;

        public qw(long j) {
            this.f7679ad = j;
        }

        public void run() {
            th.this.qqq(1);
            long uptimeMillis = SystemClock.uptimeMillis() - this.f7679ad;
            if (th.this.f7677rg != null) {
                th.this.f7677rg.ad(th.this);
            }
            try {
                th.this.xxx();
            } catch (Throwable th2) {
                if (!th.this.f7678th.f325if.qw()) {
                    fe.mmm.qw.i.qw.th("NetdiskAppStartup", "task Throwable " + th2.getMessage(), th2);
                } else {
                    throw th2;
                }
            }
            th.this.qqq(2);
            long uptimeMillis2 = (SystemClock.uptimeMillis() - this.f7679ad) - uptimeMillis;
            if (th.this.f7677rg != null) {
                th.this.f7677rg.qw(th.this, uptimeMillis, uptimeMillis2);
            }
            th.this.ggg();
        }
    }

    public void aaa() {
        if (this.f7675de == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            qqq(3);
            StartupTaskListener startupTaskListener = this.f7677rg;
            if (startupTaskListener != null) {
                startupTaskListener.de(this);
            }
            this.qw.execute(new qw(uptimeMillis));
            return;
        }
        throw new RuntimeException("You try to run task " + o() + " twice，currentState=" + this.f7675de + " is there a circular dependency?");
    }

    public void ddd(Executor executor) {
        this.qw = executor;
    }

    public boolean equals(@Nullable Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    public final void ggg() {
        List<th> list = this.f7676fe;
        if (list != null && !list.isEmpty()) {
            yj.qw(this.f7676fe);
            for (th vvv : this.f7676fe) {
                vvv.vvv();
            }
        }
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public abstract int i();

    /* renamed from: if  reason: not valid java name */
    public boolean m962if() {
        return this.f7675de == 2;
    }

    public void mmm(StartupTaskListener startupTaskListener) {
        this.f7677rg = startupTaskListener;
    }

    public void nn(qw qwVar) {
        this.f7678th = qwVar;
    }

    public abstract String o();

    public boolean pf() {
        return i() == 2;
    }

    public boolean ppp() {
        return i() == 1;
    }

    public final void qqq(int i2) {
        this.f7675de = i2;
    }

    public final void rg(th thVar) {
        if (thVar != this) {
            if (this.f7676fe == null) {
                this.f7676fe = new ArrayList();
            }
            this.f7676fe.add(thVar);
            return;
        }
        throw new RuntimeException("A task should not after itself.");
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m963switch() {
        return true;
    }

    public void th(th thVar) {
        if (this.f7675de == 0) {
            this.f7674ad++;
            thVar.rg(this);
            return;
        }
        throw new RuntimeException("task " + o() + " running");
    }

    public int uk() {
        return 1;
    }

    public final void vvv() {
        int i2;
        synchronized (this) {
            i2 = this.f7674ad - 1;
            this.f7674ad = i2;
        }
        if (i2 == 0) {
            aaa();
        }
    }

    public boolean when() {
        return i() == 0;
    }

    public abstract void xxx();

    public abstract List<Class<? extends th>> yj();
}
