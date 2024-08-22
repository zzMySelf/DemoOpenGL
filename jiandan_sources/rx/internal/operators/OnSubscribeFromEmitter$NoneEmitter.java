package rx.internal.operators;

import p041if.de;

public final class OnSubscribeFromEmitter$NoneEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 3776720187248809713L;

    public OnSubscribeFromEmitter$NoneEmitter(de<? super T> deVar) {
        super(deVar);
    }

    public void onNext(T t) {
        long j;
        if (!this.actual.isUnsubscribed()) {
            this.actual.onNext(t);
            do {
                j = get();
                if (j == 0 || compareAndSet(j, j - 1)) {
                }
                j = get();
                return;
            } while (compareAndSet(j, j - 1));
        }
    }
}
