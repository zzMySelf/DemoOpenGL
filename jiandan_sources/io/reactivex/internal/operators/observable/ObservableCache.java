package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;

public final class ObservableCache<T> extends th.de.p039if.fe.rg.qw<T, T> implements Observer<T> {
    public static final CacheDisposable[] ggg = new CacheDisposable[0];
    public static final CacheDisposable[] ppp = new CacheDisposable[0];

    /* renamed from: i  reason: collision with root package name */
    public volatile long f10057i;

    /* renamed from: if  reason: not valid java name */
    public int f480if;

    /* renamed from: o  reason: collision with root package name */
    public final qw<T> f10058o;

    /* renamed from: pf  reason: collision with root package name */
    public qw<T> f10059pf;

    /* renamed from: switch  reason: not valid java name */
    public Throwable f481switch;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicBoolean f10060th = new AtomicBoolean();

    /* renamed from: uk  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f10061uk;
    public volatile boolean when;

    /* renamed from: yj  reason: collision with root package name */
    public final int f10062yj;

    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = 6770240836423125754L;
        public volatile boolean disposed;
        public final Observer<? super T> downstream;
        public long index;
        public qw<T> node;
        public int offset;
        public final ObservableCache<T> parent;

        public CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.f10058o;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.fe(this);
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public volatile qw<T> f10063ad;
        public final T[] qw;

        public qw(int i2) {
            this.qw = new Object[i2];
        }
    }

    public ObservableCache(rg<T> rgVar, int i2) {
        super(rgVar);
        this.f10062yj = i2;
        qw<T> qwVar = new qw<>(i2);
        this.f10058o = qwVar;
        this.f10059pf = qwVar;
        this.f10061uk = new AtomicReference<>(ppp);
    }

    public void ad(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f10061uk.get();
            if (cacheDisposableArr != ggg) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!this.f10061uk.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void fe(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f10061uk.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (cacheDisposableArr[i3] == cacheDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = ppp;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i2);
                        System.arraycopy(cacheDisposableArr, i2 + 1, cacheDisposableArr3, i2, (length - i2) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f10061uk.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void onComplete() {
        this.when = true;
        for (CacheDisposable rg2 : (CacheDisposable[]) this.f10061uk.getAndSet(ggg)) {
            rg(rg2);
        }
    }

    public void onError(Throwable th2) {
        this.f481switch = th2;
        this.when = true;
        for (CacheDisposable rg2 : (CacheDisposable[]) this.f10061uk.getAndSet(ggg)) {
            rg(rg2);
        }
    }

    public void onNext(T t) {
        int i2 = this.f480if;
        if (i2 == this.f10062yj) {
            qw<T> qwVar = new qw<>(i2);
            qwVar.qw[0] = t;
            this.f480if = 1;
            this.f10059pf.f10063ad = qwVar;
            this.f10059pf = qwVar;
        } else {
            this.f10059pf.qw[i2] = t;
            this.f480if = i2 + 1;
        }
        this.f10057i++;
        for (CacheDisposable rg2 : (CacheDisposable[]) this.f10061uk.get()) {
            rg(rg2);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void rg(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() == 0) {
            long j = cacheDisposable.index;
            int i2 = cacheDisposable.offset;
            qw<T> qwVar = cacheDisposable.node;
            Observer<? super T> observer = cacheDisposable.downstream;
            int i3 = this.f10062yj;
            int i4 = 1;
            while (!cacheDisposable.disposed) {
                boolean z = this.when;
                boolean z2 = this.f10057i == j;
                if (z && z2) {
                    cacheDisposable.node = null;
                    Throwable th2 = this.f481switch;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i2 == i3) {
                        qwVar = qwVar.f10063ad;
                        i2 = 0;
                    }
                    observer.onNext(qwVar.qw[i2]);
                    i2++;
                    j++;
                } else {
                    cacheDisposable.index = j;
                    cacheDisposable.offset = i2;
                    cacheDisposable.node = qwVar;
                    i4 = cacheDisposable.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.node = null;
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        ad(cacheDisposable);
        if (this.f10060th.get() || !this.f10060th.compareAndSet(false, true)) {
            rg(cacheDisposable);
        } else {
            this.f10756ad.subscribe(this);
        }
    }
}
