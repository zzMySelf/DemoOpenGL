package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class MaybeConcatArray$ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
    public static final long serialVersionUID = 3520831347801429610L;
    public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
    public final SequentialDisposable disposables = new SequentialDisposable();
    public final Subscriber<? super T> downstream;
    public int index;
    public long produced;
    public final AtomicLong requested = new AtomicLong();
    public final MaybeSource<? extends T>[] sources;

    public MaybeConcatArray$ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
        this.downstream = subscriber;
        this.sources = maybeSourceArr;
    }

    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<Object> atomicReference = this.current;
            Subscriber<? super T> subscriber = this.downstream;
            SequentialDisposable sequentialDisposable = this.disposables;
            while (!sequentialDisposable.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != NotificationLite.COMPLETE) {
                        long j = this.produced;
                        if (j != this.requested.get()) {
                            this.produced = j + 1;
                            atomicReference.lazySet((Object) null);
                            subscriber.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                    }
                    if (z && !sequentialDisposable.isDisposed()) {
                        int i2 = this.index;
                        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
                        if (i2 == maybeSourceArr.length) {
                            subscriber.onComplete();
                            return;
                        } else {
                            this.index = i2 + 1;
                            maybeSourceArr[i2].qw(this);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet((Object) null);
        }
    }

    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        this.disposables.replace(disposable);
    }

    public void onSuccess(T t) {
        this.current.lazySet(t);
        drain();
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
            drain();
        }
    }
}
