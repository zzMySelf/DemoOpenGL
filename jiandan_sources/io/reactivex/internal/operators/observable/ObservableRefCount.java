package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p040switch.qw;
import th.de.rg;
import th.de.th;

public final class ObservableRefCount<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final qw<T> f10176ad;

    /* renamed from: i  reason: collision with root package name */
    public final th f10177i;

    /* renamed from: o  reason: collision with root package name */
    public RefConnection f10178o;

    /* renamed from: th  reason: collision with root package name */
    public final int f10179th;

    /* renamed from: uk  reason: collision with root package name */
    public final TimeUnit f10180uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10181yj;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        public static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final ObservableRefCount<?> parent;
        public long subscriberCount;
        public Disposable timer;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        public void run() {
            this.parent.rg(this);
        }

        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.f10176ad).qw(disposable);
                }
            }
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final Observer<? super T> downstream;
        public final ObservableRefCount<T> parent;
        public Disposable upstream;

        public RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.ad(this.connection);
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.fe(this.connection);
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.parent.fe(this.connection);
                this.downstream.onError(th2);
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(qw<T> qwVar) {
        this(qwVar, 1, 0, TimeUnit.NANOSECONDS, th.de.vvv.qw.fe());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f10178o     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x003f
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f10178o     // Catch:{ all -> 0x0041 }
            if (r0 == r6) goto L_0x000a
            goto L_0x003f
        L_0x000a:
            long r0 = r6.subscriberCount     // Catch:{ all -> 0x0041 }
            r2 = 1
            long r0 = r0 - r2
            r6.subscriberCount = r0     // Catch:{ all -> 0x0041 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003d
            boolean r0 = r6.connected     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x001c
            goto L_0x003d
        L_0x001c:
            long r0 = r5.f10181yj     // Catch:{ all -> 0x0041 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0027
            r5.rg(r6)     // Catch:{ all -> 0x0041 }
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x0027:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x0041 }
            r0.<init>()     // Catch:{ all -> 0x0041 }
            r6.timer = r0     // Catch:{ all -> 0x0041 }
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            th.de.th r1 = r5.f10177i
            long r2 = r5.f10181yj
            java.util.concurrent.TimeUnit r4 = r5.f10180uk
            io.reactivex.disposables.Disposable r6 = r1.fe(r6, r2, r4)
            r0.replace(r6)
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x003f:
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            return
        L_0x0041:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0041 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.ad(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    public void fe(RefConnection refConnection) {
        synchronized (this) {
            if (this.f10178o != null && this.f10178o == refConnection) {
                this.f10178o = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j == 0) {
                if (this.f10176ad instanceof Disposable) {
                    ((Disposable) this.f10176ad).dispose();
                } else if (this.f10176ad instanceof ResettableConnectable) {
                    ((ResettableConnectable) this.f10176ad).qw((Disposable) refConnection.get());
                }
            }
        }
    }

    public void rg(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f10178o) {
                this.f10178o = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (this.f10176ad instanceof Disposable) {
                    ((Disposable) this.f10176ad).dispose();
                } else if (this.f10176ad instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) this.f10176ad).qw(disposable);
                    }
                }
            }
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.f10178o;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f10178o = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != ((long) this.f10179th)) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f10176ad.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.f10176ad.ad(refConnection);
        }
    }

    public ObservableRefCount(qw<T> qwVar, int i2, long j, TimeUnit timeUnit, th thVar) {
        this.f10176ad = qwVar;
        this.f10179th = i2;
        this.f10181yj = j;
        this.f10180uk = timeUnit;
        this.f10177i = thVar;
    }
}
