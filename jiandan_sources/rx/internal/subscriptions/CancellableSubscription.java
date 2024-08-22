package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import p041if.fe.qw;
import p041if.uk.de;
import rx.Subscription;
import rx.functions.Cancellable;

public final class CancellableSubscription extends AtomicReference<Cancellable> implements Subscription {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(Cancellable cancellable) {
        super(cancellable);
    }

    public boolean isUnsubscribed() {
        return get() == null;
    }

    public void unsubscribe() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet((Object) null)) != null) {
            try {
                cancellable.cancel();
            } catch (Exception e) {
                qw.rg(e);
                de.i(e);
            }
        }
    }
}
