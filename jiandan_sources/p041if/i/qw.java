package p041if.i;

import java.util.concurrent.atomic.AtomicReference;
import p041if.uk.de;
import p041if.uk.th;
import p041if.uk.yj;
import rx.internal.schedulers.SchedulerLifecycle;

/* renamed from: if.i.qw  reason: invalid package */
public final class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final AtomicReference<qw> f11128fe = new AtomicReference<>();

    /* renamed from: ad  reason: collision with root package name */
    public final p041if.qw f11129ad;

    /* renamed from: de  reason: collision with root package name */
    public final p041if.qw f11130de;
    public final p041if.qw qw;

    public qw() {
        yj th2 = th.de().th();
        p041if.qw yj2 = th2.yj();
        if (yj2 != null) {
            this.qw = yj2;
        } else {
            this.qw = yj.qw();
        }
        p041if.qw i2 = th2.i();
        if (i2 != null) {
            this.f11129ad = i2;
        } else {
            this.f11129ad = yj.de();
        }
        p041if.qw o2 = th2.o();
        if (o2 != null) {
            this.f11130de = o2;
        } else {
            this.f11130de = yj.rg();
        }
    }

    public static qw ad() {
        while (true) {
            qw qwVar = f11128fe.get();
            if (qwVar != null) {
                return qwVar;
            }
            qw qwVar2 = new qw();
            if (f11128fe.compareAndSet((Object) null, qwVar2)) {
                return qwVar2;
            }
            qwVar2.de();
        }
    }

    public static p041if.qw fe() {
        return p041if.rg.de.th.qw;
    }

    public static p041if.qw qw() {
        return de.th(ad().qw);
    }

    public synchronized void de() {
        if (this.qw instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.qw).shutdown();
        }
        if (this.f11129ad instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.f11129ad).shutdown();
        }
        if (this.f11130de instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.f11130de).shutdown();
        }
    }
}
