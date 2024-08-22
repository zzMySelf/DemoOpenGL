package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
    public static final long serialVersionUID = 7326289992464377023L;
    public final Subscriber<? super T> downstream;
    public final SequentialDisposable serial = new SequentialDisposable();

    public FlowableCreate$BaseEmitter(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public void complete() {
        if (!isCancelled()) {
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean error(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isCancelled()) {
            return false;
        }
        try {
            this.downstream.onError(th2);
            this.serial.dispose();
            return true;
        } catch (Throwable th3) {
            this.serial.dispose();
            throw th3;
        }
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    public void onComplete() {
        complete();
    }

    public final void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            qw.ddd(th2);
        }
    }

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this, j);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final FlowableEmitter<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(Cancellable cancellable) {
        setDisposable(new CancellableDisposable(cancellable));
    }

    public final void setDisposable(Disposable disposable) {
        this.serial.update(disposable);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable th2) {
        return error(th2);
    }
}
