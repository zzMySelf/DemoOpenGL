package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.ad;
import p041if.uk.de;
import rx.SingleEmitter;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
    public static final long serialVersionUID = 8082834163465882809L;
    public final ad<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(ad<? super T> adVar) {
        this.actual = adVar;
    }

    public boolean isUnsubscribed() {
        return get();
    }

    public void onError(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        if (compareAndSet(false, true)) {
            try {
                this.actual.qw(th2);
            } finally {
                this.resource.unsubscribe();
            }
        } else {
            de.i(th2);
        }
    }

    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.ad(t);
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    public void setCancellation(Cancellable cancellable) {
        setSubscription(new CancellableSubscription(cancellable));
    }

    public void setSubscription(Subscription subscription) {
        this.resource.update(subscription);
    }

    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
