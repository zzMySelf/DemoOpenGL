package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
    public static final long serialVersionUID = 4262875056400218316L;
    public Action1<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(Action1<? super Resource> action1, Resource resource2) {
        this.dispose = action1;
        this.resource = resource2;
        lazySet(false);
    }

    public void call() {
        if (compareAndSet(false, true)) {
            try {
                this.dispose.call(this.resource);
            } finally {
                this.resource = null;
                this.dispose = null;
            }
        }
    }

    public boolean isUnsubscribed() {
        return get();
    }

    public void unsubscribe() {
        call();
    }
}
