package rx.internal.operators;

import p041if.de;

public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    public OnSubscribeFromEmitter$DropEmitter(de<? super T> deVar) {
        super(deVar);
    }

    public void onOverflow() {
    }
}
