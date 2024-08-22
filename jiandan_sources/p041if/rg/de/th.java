package p041if.rg.de;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p041if.pf.fe;
import p041if.qw;
import rx.Subscription;
import rx.functions.Action0;

/* renamed from: if.rg.de.th  reason: invalid package */
public final class th extends p041if.qw {
    public static final th qw = new th();

    /* renamed from: if.rg.de.th$ad */
    public static final class ad implements Comparable<ad> {

        /* renamed from: ad  reason: collision with root package name */
        public final Action0 f11192ad;

        /* renamed from: th  reason: collision with root package name */
        public final Long f11193th;

        /* renamed from: yj  reason: collision with root package name */
        public final int f11194yj;

        public ad(Action0 action0, Long l, int i2) {
            this.f11192ad = action0;
            this.f11193th = l;
            this.f11194yj = i2;
        }

        /* renamed from: qw */
        public int compareTo(ad adVar) {
            int compareTo = this.f11193th.compareTo(adVar.f11193th);
            return compareTo == 0 ? th.de(this.f11194yj, adVar.f11194yj) : compareTo;
        }
    }

    /* renamed from: if.rg.de.th$qw */
    public static final class qw extends qw.C0349qw implements Subscription {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicInteger f11195ad = new AtomicInteger();

        /* renamed from: th  reason: collision with root package name */
        public final PriorityBlockingQueue<ad> f11196th = new PriorityBlockingQueue<>();

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicInteger f11197uk = new AtomicInteger();

        /* renamed from: yj  reason: collision with root package name */
        public final p041if.pf.qw f11198yj = new p041if.pf.qw();

        /* renamed from: if.rg.de.th$qw$qw  reason: collision with other inner class name */
        public class C0357qw implements Action0 {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ ad f11199ad;

            public C0357qw(ad adVar) {
                this.f11199ad = adVar;
            }

            public void call() {
                qw.this.f11196th.remove(this.f11199ad);
            }
        }

        public Subscription de(Action0 action0) {
            return rg(action0, ad());
        }

        public Subscription fe(Action0 action0, long j, TimeUnit timeUnit) {
            long ad2 = ad() + timeUnit.toMillis(j);
            return rg(new rg(action0, this, ad2), ad2);
        }

        public boolean isUnsubscribed() {
            return this.f11198yj.isUnsubscribed();
        }

        public final Subscription rg(Action0 action0, long j) {
            if (this.f11198yj.isUnsubscribed()) {
                return fe.ad();
            }
            ad adVar = new ad(action0, Long.valueOf(j), this.f11195ad.incrementAndGet());
            this.f11196th.add(adVar);
            if (this.f11197uk.getAndIncrement() != 0) {
                return fe.qw(new C0357qw(adVar));
            }
            do {
                ad poll = this.f11196th.poll();
                if (poll != null) {
                    poll.f11192ad.call();
                }
            } while (this.f11197uk.decrementAndGet() > 0);
            return fe.ad();
        }

        public void unsubscribe() {
            this.f11198yj.unsubscribe();
        }
    }

    public static int de(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public qw.C0349qw qw() {
        return new qw();
    }
}
