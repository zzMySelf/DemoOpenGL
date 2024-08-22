package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Emitter;
import rx.Producer;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;

public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
    public static final long serialVersionUID = 7326289992464377023L;
    public final de<? super T> actual;
    public final p041if.pf.de serial = new p041if.pf.de();

    public OnSubscribeFromEmitter$BaseEmitter(de<? super T> deVar) {
        this.actual = deVar;
    }

    public final boolean isUnsubscribed() {
        return this.serial.isUnsubscribed();
    }

    public void onCompleted() {
        if (!this.actual.isUnsubscribed()) {
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }
    }

    public void onError(Throwable th2) {
        if (!this.actual.isUnsubscribed()) {
            try {
                this.actual.onError(th2);
            } finally {
                this.serial.unsubscribe();
            }
        }
    }

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public final void request(long j) {
        if (qw.uk(j)) {
            qw.ad(this, j);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final void setCancellation(Cancellable cancellable) {
        setSubscription(new CancellableSubscription(cancellable));
    }

    public final void setSubscription(Subscription subscription) {
        this.serial.qw(subscription);
    }

    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
