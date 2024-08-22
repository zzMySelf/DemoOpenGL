package rx.internal.operators;

import p041if.de;
import rx.exceptions.MissingBackpressureException;

public final class OnSubscribeFromEmitter$ErrorEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;
    public boolean done;

    public OnSubscribeFromEmitter$ErrorEmitter(de<? super T> deVar) {
        super(deVar);
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            super.onCompleted();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            p041if.uk.de.i(th2);
            return;
        }
        this.done = true;
        super.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            super.onNext(t);
        }
    }

    public void onOverflow() {
        onError(new MissingBackpressureException("fromEmitter: could not emit value due to lack of requests"));
    }
}
