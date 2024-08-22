package rx.internal.operators;

import p041if.de;
import p041if.rg.qw.qw;

public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(de<? super T> deVar) {
        super(deVar);
    }

    public void onNext(T t) {
        if (!this.actual.isUnsubscribed()) {
            if (get() != 0) {
                this.actual.onNext(t);
                qw.yj(this, 1);
                return;
            }
            onOverflow();
        }
    }

    public abstract void onOverflow();
}
