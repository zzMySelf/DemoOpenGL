package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import th.de.de;

public final class MaybeCache<T> extends de<T> implements MaybeObserver<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final CacheDisposable[] f9995i = new CacheDisposable[0];

    /* renamed from: o  reason: collision with root package name */
    public static final CacheDisposable[] f9996o = new CacheDisposable[0];

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<MaybeSource<T>> f9997ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f9998th;

    /* renamed from: uk  reason: collision with root package name */
    public Throwable f9999uk;

    /* renamed from: yj  reason: collision with root package name */
    public T f10000yj;

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        public static final long serialVersionUID = -5791853038359966195L;
        public final MaybeObserver<? super T> downstream;

        public CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = maybeObserver;
        }

        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.th(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (rg(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                th(cacheDisposable);
                return;
            }
            MaybeSource andSet = this.f9997ad.getAndSet((Object) null);
            if (andSet != null) {
                andSet.qw(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th2 = this.f9999uk;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t = this.f10000yj;
            if (t != null) {
                maybeObserver.onSuccess(t);
            } else {
                maybeObserver.onComplete();
            }
        }
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f9998th.getAndSet(f9996o)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        this.f9999uk = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f9998th.getAndSet(f9996o)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t) {
        this.f10000yj = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f9998th.getAndSet(f9996o)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public boolean rg(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f9998th.get();
            if (cacheDisposableArr == f9996o) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f9998th.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void th(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f9998th.get();
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
                        cacheDisposableArr2 = f9995i;
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
        } while (!this.f9998th.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }
}
