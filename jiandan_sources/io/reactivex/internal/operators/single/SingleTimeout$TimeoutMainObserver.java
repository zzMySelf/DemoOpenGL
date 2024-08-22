package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

public final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
    public static final long serialVersionUID = 37497744973048446L;
    public final SingleObserver<? super T> downstream;
    public final TimeoutFallbackObserver<T> fallback;
    public SingleSource<? extends T> other;
    public final AtomicReference<Disposable> task = new AtomicReference<>();
    public final long timeout;
    public final TimeUnit unit;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        public static final long serialVersionUID = 2071387740092105509L;
        public final SingleObserver<? super T> downstream;

        public TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleTimeout$TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit) {
        this.downstream = singleObserver;
        this.other = singleSource;
        this.timeout = j;
        this.unit = timeUnit;
        if (singleSource != null) {
            this.fallback = new TimeoutFallbackObserver<>(singleObserver);
        } else {
            this.fallback = null;
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
        if (timeoutFallbackObserver != null) {
            DisposableHelper.dispose(timeoutFallbackObserver);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onError(Throwable th2) {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
            qw.ddd(th2);
            return;
        }
        DisposableHelper.dispose(this.task);
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t) {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t);
        }
    }

    public void run() {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
            if (disposable != null) {
                disposable.dispose();
            }
            SingleSource<? extends T> singleSource = this.other;
            if (singleSource == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.de(this.timeout, this.unit)));
                return;
            }
            this.other = null;
            singleSource.qw(this.fallback);
        }
    }
}
