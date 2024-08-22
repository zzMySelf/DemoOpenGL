package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends th.de.p040switch.qw<T> implements HasUpstreamObservableSource<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10159ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<qw<T>> f10160th;

    /* renamed from: yj  reason: collision with root package name */
    public final ObservableSource<T> f10161yj;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        public static final long serialVersionUID = -1100270633763673112L;
        public final Observer<? super T> child;

        public InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((qw) andSet).ad(this);
            }
        }

        public boolean isDisposed() {
            return get() == this;
        }

        public void setParent(qw<T> qwVar) {
            if (!compareAndSet((Object) null, qwVar)) {
                qwVar.ad(this);
            }
        }
    }

    public static final class ad<T> implements ObservableSource<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicReference<qw<T>> f10162ad;

        public ad(AtomicReference<qw<T>> atomicReference) {
            this.f10162ad = atomicReference;
        }

        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                qw qwVar = this.f10162ad.get();
                if (qwVar == null || qwVar.isDisposed()) {
                    qw qwVar2 = new qw(this.f10162ad);
                    if (!this.f10162ad.compareAndSet(qwVar, qwVar2)) {
                        continue;
                    } else {
                        qwVar = qwVar2;
                    }
                }
                if (qwVar.qw(innerDisposable)) {
                    innerDisposable.setParent(qwVar);
                    return;
                }
            }
        }
    }

    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final InnerDisposable[] f10163i = new InnerDisposable[0];

        /* renamed from: o  reason: collision with root package name */
        public static final InnerDisposable[] f10164o = new InnerDisposable[0];

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicReference<qw<T>> f10165ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<InnerDisposable<T>[]> f10166th = new AtomicReference<>(f10163i);

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicReference<Disposable> f10167uk = new AtomicReference<>();

        /* renamed from: yj  reason: collision with root package name */
        public final AtomicBoolean f10168yj;

        public qw(AtomicReference<qw<T>> atomicReference) {
            this.f10165ad = atomicReference;
            this.f10168yj = new AtomicBoolean();
        }

        public void ad(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f10166th.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f10163i;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f10166th.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public void dispose() {
            if (((InnerDisposable[]) this.f10166th.getAndSet(f10164o)) != f10164o) {
                this.f10165ad.compareAndSet(this, (Object) null);
                DisposableHelper.dispose(this.f10167uk);
            }
        }

        public boolean isDisposed() {
            return this.f10166th.get() == f10164o;
        }

        public void onComplete() {
            this.f10165ad.compareAndSet(this, (Object) null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f10166th.getAndSet(f10164o)) {
                innerDisposable.child.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f10165ad.compareAndSet(this, (Object) null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.f10166th.getAndSet(f10164o);
            if (innerDisposableArr.length != 0) {
                for (InnerDisposable innerDisposable : innerDisposableArr) {
                    innerDisposable.child.onError(th2);
                }
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f10166th.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10167uk, disposable);
        }

        public boolean qw(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f10166th.get();
                if (innerDisposableArr == f10164o) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.f10166th.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<qw<T>> atomicReference) {
        this.f10161yj = observableSource;
        this.f10159ad = observableSource2;
        this.f10160th = atomicReference;
    }

    public static <T> th.de.p040switch.qw<T> rg(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return th.de.ppp.qw.ggg(new ObservablePublish(new ad(atomicReference), observableSource, atomicReference));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$qw<T>> r0 = r4.f10160th
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservablePublish$qw r0 = (io.reactivex.internal.operators.observable.ObservablePublish.qw) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservablePublish$qw r1 = new io.reactivex.internal.operators.observable.ObservablePublish$qw
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$qw<T>> r2 = r4.f10160th
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$qw<T>> r2 = r4.f10160th
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f10168yj
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f10168yj
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            r5.accept(r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            io.reactivex.ObservableSource<T> r5 = r4.f10159ad
            r5.subscribe(r0)
        L_0x003f:
            return
        L_0x0040:
            r5 = move-exception
            th.de.o.qw.ad(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.fe(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.ad(io.reactivex.functions.Consumer):void");
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10161yj.subscribe(observer);
    }
}
