package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.uk.de;
import rx.CompletableEmitter;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements CompletableEmitter, Subscription {
    public static final long serialVersionUID = 5539301318568668881L;
    public final CompletableSubscriber actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(CompletableSubscriber completableSubscriber) {
        this.actual = completableSubscriber;
    }

    public boolean isUnsubscribed() {
        return get();
    }

    public void onCompleted() {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onCompleted();
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    public void onError(Throwable th2) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onError(th2);
            } finally {
                this.resource.unsubscribe();
            }
        } else {
            de.i(th2);
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
