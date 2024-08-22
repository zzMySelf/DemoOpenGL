package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.fe;
import rx.Subscription;

public final class RefCountSubscription implements Subscription {

    /* renamed from: yj  reason: collision with root package name */
    public static final qw f11490yj = new qw(false, 0);

    /* renamed from: ad  reason: collision with root package name */
    public final Subscription f11491ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<qw> f11492th = new AtomicReference<>(f11490yj);

    public static final class InnerSubscription extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = 7005765588239987643L;
        public final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        public boolean isUnsubscribed() {
            return get() != 0;
        }

        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.ad();
            }
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final int f11493ad;
        public final boolean qw;

        public qw(boolean z, int i2) {
            this.qw = z;
            this.f11493ad = i2;
        }

        public qw ad() {
            return new qw(this.qw, this.f11493ad - 1);
        }

        public qw de() {
            return new qw(true, this.f11493ad);
        }

        public qw qw() {
            return new qw(this.qw, this.f11493ad + 1);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.f11491ad = subscription;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    public void ad() {
        qw qwVar;
        qw ad2;
        AtomicReference<qw> atomicReference = this.f11492th;
        do {
            qwVar = atomicReference.get();
            ad2 = qwVar.ad();
        } while (!atomicReference.compareAndSet(qwVar, ad2));
        de(ad2);
    }

    public final void de(qw qwVar) {
        if (qwVar.qw && qwVar.f11493ad == 0) {
            this.f11491ad.unsubscribe();
        }
    }

    public boolean isUnsubscribed() {
        return this.f11492th.get().qw;
    }

    public Subscription qw() {
        qw qwVar;
        AtomicReference<qw> atomicReference = this.f11492th;
        do {
            qwVar = atomicReference.get();
            if (qwVar.qw) {
                return fe.ad();
            }
        } while (!atomicReference.compareAndSet(qwVar, qwVar.qw()));
        return new InnerSubscription(this);
    }

    public void unsubscribe() {
        qw qwVar;
        qw de2;
        AtomicReference<qw> atomicReference = this.f11492th;
        do {
            qwVar = atomicReference.get();
            if (!qwVar.qw) {
                de2 = qwVar.de();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(qwVar, de2));
        de(de2);
    }
}
