package p041if.pf;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

/* renamed from: if.pf.qw  reason: invalid package */
public final class qw implements Subscription {

    /* renamed from: th  reason: collision with root package name */
    public static final Action0 f11139th = new C0348qw();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Action0> f11140ad;

    /* renamed from: if.pf.qw$qw  reason: collision with other inner class name */
    public static class C0348qw implements Action0 {
        public void call() {
        }
    }

    public qw() {
        this.f11140ad = new AtomicReference<>();
    }

    public static qw qw(Action0 action0) {
        return new qw(action0);
    }

    public boolean isUnsubscribed() {
        return this.f11140ad.get() == f11139th;
    }

    public void unsubscribe() {
        Action0 andSet;
        Action0 action0 = this.f11140ad.get();
        Action0 action02 = f11139th;
        if (action0 != action02 && (andSet = this.f11140ad.getAndSet(action02)) != null && andSet != f11139th) {
            andSet.call();
        }
    }

    public qw(Action0 action0) {
        this.f11140ad = new AtomicReference<>(action0);
    }
}
