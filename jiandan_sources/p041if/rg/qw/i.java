package p041if.rg.qw;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p041if.qw;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.functions.Action0;
import rx.functions.Func1;

/* renamed from: if.rg.qw.i  reason: invalid package */
public final class i<T> implements Observable.OnSubscribe<T> {

    /* renamed from: o  reason: collision with root package name */
    public static final Func1<Observable<? extends Notification<?>>, Observable<?>> f11275o = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final Observable<T> f11276ad;

    /* renamed from: i  reason: collision with root package name */
    public final p041if.qw f11277i;

    /* renamed from: th  reason: collision with root package name */
    public final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> f11278th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f11279uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f11280yj;

    /* renamed from: if.rg.qw.i$ad */
    public class ad implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ p041if.de f11281ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ p041if.pf.de f11282i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ p041if.o.fe f11284th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f11285uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ p041if.rg.ad.qw f11286yj;

        /* renamed from: if.rg.qw.i$ad$qw */
        public class qw extends p041if.de<T> {

            /* renamed from: ad  reason: collision with root package name */
            public boolean f11287ad;

            public qw() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void de() {
                /*
                    r5 = this;
                L_0x0000:
                    if.rg.qw.i$ad r0 = p041if.rg.qw.i.ad.this
                    java.util.concurrent.atomic.AtomicLong r0 = r0.f11285uk
                    long r0 = r0.get()
                    r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 == 0) goto L_0x001f
                    if.rg.qw.i$ad r2 = p041if.rg.qw.i.ad.this
                    java.util.concurrent.atomic.AtomicLong r2 = r2.f11285uk
                    r3 = 1
                    long r3 = r0 - r3
                    boolean r0 = r2.compareAndSet(r0, r3)
                    if (r0 == 0) goto L_0x0000
                L_0x001f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p041if.rg.qw.i.ad.qw.de():void");
            }

            public void onCompleted() {
                if (!this.f11287ad) {
                    this.f11287ad = true;
                    unsubscribe();
                    ad.this.f11284th.onNext(Notification.qw());
                }
            }

            public void onError(Throwable th2) {
                if (!this.f11287ad) {
                    this.f11287ad = true;
                    unsubscribe();
                    ad.this.f11284th.onNext(Notification.ad(th2));
                }
            }

            public void onNext(T t) {
                if (!this.f11287ad) {
                    ad.this.f11281ad.onNext(t);
                    de();
                    ad.this.f11286yj.ad(1);
                }
            }

            public void setProducer(Producer producer) {
                ad.this.f11286yj.de(producer);
            }
        }

        public ad(p041if.de deVar, p041if.o.fe feVar, p041if.rg.ad.qw qwVar, AtomicLong atomicLong, p041if.pf.de deVar2) {
            this.f11281ad = deVar;
            this.f11284th = feVar;
            this.f11286yj = qwVar;
            this.f11285uk = atomicLong;
            this.f11282i = deVar2;
        }

        public void call() {
            if (!this.f11281ad.isUnsubscribed()) {
                qw qwVar = new qw();
                this.f11282i.qw(qwVar);
                i.this.f11276ad.aaa(qwVar);
            }
        }
    }

    /* renamed from: if.rg.qw.i$de */
    public class de implements Observable.Operator<Notification<?>, Notification<?>> {

        /* renamed from: if.rg.qw.i$de$qw */
        public class qw extends p041if.de<Notification<?>> {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ p041if.de f11290ad;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public qw(p041if.de deVar, p041if.de deVar2) {
                super(deVar);
                this.f11290ad = deVar2;
            }

            /* renamed from: de */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f11280yj) {
                    this.f11290ad.onCompleted();
                } else if (!notification.o() || !i.this.f11279uk) {
                    this.f11290ad.onNext(notification);
                } else {
                    this.f11290ad.onError(notification.rg());
                }
            }

            public void onCompleted() {
                this.f11290ad.onCompleted();
            }

            public void onError(Throwable th2) {
                this.f11290ad.onError(th2);
            }

            public void setProducer(Producer producer) {
                producer.request(Long.MAX_VALUE);
            }
        }

        public de() {
        }

        /* renamed from: ad */
        public p041if.de<? super Notification<?>> call(p041if.de<? super Notification<?>> deVar) {
            return new qw(deVar, deVar);
        }
    }

    /* renamed from: if.rg.qw.i$fe */
    public class fe implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Observable f11292ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Action0 f11293i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f11294o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ p041if.de f11295th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ qw.C0349qw f11296uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f11297yj;

        /* renamed from: if.rg.qw.i$fe$qw */
        public class qw extends p041if.de<Object> {
            public qw(p041if.de deVar) {
                super(deVar);
            }

            public void onCompleted() {
                fe.this.f11295th.onCompleted();
            }

            public void onError(Throwable th2) {
                fe.this.f11295th.onError(th2);
            }

            public void onNext(Object obj) {
                if (fe.this.f11295th.isUnsubscribed()) {
                    return;
                }
                if (fe.this.f11297yj.get() > 0) {
                    fe feVar = fe.this;
                    feVar.f11296uk.de(feVar.f11293i);
                    return;
                }
                fe.this.f11294o.compareAndSet(false, true);
            }

            public void setProducer(Producer producer) {
                producer.request(Long.MAX_VALUE);
            }
        }

        public fe(i iVar, Observable observable, p041if.de deVar, AtomicLong atomicLong, qw.C0349qw qwVar, Action0 action0, AtomicBoolean atomicBoolean) {
            this.f11292ad = observable;
            this.f11295th = deVar;
            this.f11297yj = atomicLong;
            this.f11296uk = qwVar;
            this.f11293i = action0;
            this.f11294o = atomicBoolean;
        }

        public void call() {
            this.f11292ad.aaa(new qw(this.f11295th));
        }
    }

    /* renamed from: if.rg.qw.i$qw */
    public static class qw implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: if.rg.qw.i$qw$qw  reason: collision with other inner class name */
        public class C0358qw implements Func1<Notification<?>, Notification<?>> {
            public C0358qw(qw qwVar) {
            }

            /* renamed from: ad */
            public Notification<?> call(Notification<?> notification) {
                return Notification.de(null);
            }
        }

        /* renamed from: ad */
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.yj(new C0358qw(this));
        }
    }

    /* renamed from: if.rg.qw.i$rg */
    public class rg implements Producer {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f11299ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Action0 f11300i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ p041if.rg.ad.qw f11301th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ qw.C0349qw f11302uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f11303yj;

        public rg(i iVar, AtomicLong atomicLong, p041if.rg.ad.qw qwVar, AtomicBoolean atomicBoolean, qw.C0349qw qwVar2, Action0 action0) {
            this.f11299ad = atomicLong;
            this.f11301th = qwVar;
            this.f11303yj = atomicBoolean;
            this.f11302uk = qwVar2;
            this.f11300i = action0;
        }

        public void request(long j) {
            if (j > 0) {
                qw.ad(this.f11299ad, j);
                this.f11301th.request(j);
                if (this.f11303yj.compareAndSet(true, false)) {
                    this.f11302uk.de(this.f11300i);
                }
            }
        }
    }

    public i(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z, boolean z2, p041if.qw qwVar) {
        this.f11276ad = observable;
        this.f11278th = func1;
        this.f11280yj = z;
        this.f11279uk = z2;
        this.f11277i = qwVar;
    }

    public static <T> Observable<T> de(Observable<T> observable) {
        return fe(observable, f11275o);
    }

    public static <T> Observable<T> fe(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.ad(new i(observable, func1, true, false, p041if.i.qw.fe()));
    }

    /* renamed from: ad */
    public void call(p041if.de<? super T> deVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        qw.C0349qw qw2 = this.f11277i.qw();
        deVar.add(qw2);
        p041if.pf.de deVar2 = new p041if.pf.de();
        deVar.add(deVar2);
        p041if.o.de qqq = p041if.o.qw.eee().qqq();
        qqq.nn(p041if.yj.fe.qw());
        p041if.rg.ad.qw qwVar = new p041if.rg.ad.qw();
        p041if.de<? super T> deVar3 = deVar;
        qw.C0349qw qwVar2 = qw2;
        ad adVar = new ad(deVar3, qqq, qwVar, atomicLong, deVar2);
        qw2.de(new fe(this, (Observable) this.f11278th.call(qqq.th(new de())), deVar3, atomicLong, qwVar2, adVar, atomicBoolean));
        deVar.setProducer(new rg(this, atomicLong, qwVar, atomicBoolean, qwVar2, adVar));
    }
}
