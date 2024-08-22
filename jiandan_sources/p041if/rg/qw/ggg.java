package p041if.rg.qw;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.functions.Action0;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;

/* renamed from: if.rg.qw.ggg  reason: invalid package */
public class ggg<T> implements Observable.Operator<T, T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Long f11265ad = null;

    /* renamed from: th  reason: collision with root package name */
    public final Action0 f11266th = null;

    /* renamed from: yj  reason: collision with root package name */
    public final BackpressureOverflow.Strategy f11267yj = BackpressureOverflow.f11375ad;

    /* renamed from: if.rg.qw.ggg$ad */
    public static final class ad {
        public static final ggg<?> qw = new ggg<>();
    }

    /* renamed from: if.rg.qw.ggg$qw */
    public static final class qw<T> extends de<T> implements BackpressureDrainManager.BackpressureQueueCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f11268ad = new ConcurrentLinkedQueue<>();

        /* renamed from: i  reason: collision with root package name */
        public final BackpressureDrainManager f11269i;

        /* renamed from: o  reason: collision with root package name */
        public final Action0 f11270o;

        /* renamed from: pf  reason: collision with root package name */
        public final BackpressureOverflow.Strategy f11271pf;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicLong f11272th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicBoolean f11273uk = new AtomicBoolean(false);

        /* renamed from: yj  reason: collision with root package name */
        public final de<? super T> f11274yj;

        public qw(de<? super T> deVar, Long l, Action0 action0, BackpressureOverflow.Strategy strategy) {
            this.f11274yj = deVar;
            this.f11272th = l != null ? new AtomicLong(l.longValue()) : null;
            this.f11270o = action0;
            this.f11269i = new BackpressureDrainManager(this);
            this.f11271pf = strategy;
        }

        public boolean accept(Object obj) {
            return NotificationLite.qw(this.f11274yj, obj);
        }

        public void ad(Throwable th2) {
            if (th2 != null) {
                this.f11274yj.onError(th2);
            } else {
                this.f11274yj.onCompleted();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[SYNTHETIC, Splitter:B:19:0x0039] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0049 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean de() {
            /*
                r6 = this;
                java.util.concurrent.atomic.AtomicLong r0 = r6.f11272th
                r1 = 1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f11272th
                long r2 = r0.get()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x004a
                r0 = 0
                rx.BackpressureOverflow$Strategy r4 = r6.f11271pf     // Catch:{ MissingBackpressureException -> 0x0023 }
                boolean r4 = r4.qw()     // Catch:{ MissingBackpressureException -> 0x0023 }
                if (r4 == 0) goto L_0x0034
                java.lang.Object r4 = r6.poll()     // Catch:{ MissingBackpressureException -> 0x0023 }
                if (r4 == 0) goto L_0x0034
                r4 = 1
                goto L_0x0035
            L_0x0023:
                r4 = move-exception
                java.util.concurrent.atomic.AtomicBoolean r5 = r6.f11273uk
                boolean r5 = r5.compareAndSet(r0, r1)
                if (r5 == 0) goto L_0x0034
                r6.unsubscribe()
                if.de<? super T> r5 = r6.f11274yj
                r5.onError(r4)
            L_0x0034:
                r4 = 0
            L_0x0035:
                rx.functions.Action0 r5 = r6.f11270o
                if (r5 == 0) goto L_0x0047
                r5.call()     // Catch:{ all -> 0x003d }
                goto L_0x0047
            L_0x003d:
                r1 = move-exception
                p041if.fe.qw.rg(r1)
                rx.internal.util.BackpressureDrainManager r2 = r6.f11269i
                r2.terminateAndDrain(r1)
                return r0
            L_0x0047:
                if (r4 != 0) goto L_0x004a
                return r0
            L_0x004a:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f11272th
                r4 = 1
                long r4 = r2 - r4
                boolean r0 = r0.compareAndSet(r2, r4)
                if (r0 == 0) goto L_0x0006
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p041if.rg.qw.ggg.qw.de():boolean");
        }

        public Producer fe() {
            return this.f11269i;
        }

        public void onCompleted() {
            if (!this.f11273uk.get()) {
                this.f11269i.terminateAndDrain();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f11273uk.get()) {
                this.f11269i.terminateAndDrain(th2);
            }
        }

        public void onNext(T t) {
            if (de()) {
                this.f11268ad.offer(NotificationLite.uk(t));
                this.f11269i.drain();
            }
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public Object peek() {
            return this.f11268ad.peek();
        }

        public Object poll() {
            Object poll = this.f11268ad.poll();
            AtomicLong atomicLong = this.f11272th;
            if (!(atomicLong == null || poll == null)) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    public static <T> ggg<T> de() {
        return ad.qw;
    }

    /* renamed from: ad */
    public de<? super T> call(de<? super T> deVar) {
        qw qwVar = new qw(deVar, this.f11265ad, this.f11266th, this.f11267yj);
        deVar.add(qwVar);
        deVar.setProducer(qwVar.fe());
        return qwVar;
    }
}
