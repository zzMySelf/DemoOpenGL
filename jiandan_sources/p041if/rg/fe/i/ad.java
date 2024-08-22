package p041if.rg.fe.i;

import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.i.ad  reason: invalid package */
public abstract class ad<E> extends fe<E> {

    /* renamed from: th  reason: collision with root package name */
    public static final long f11208th = e.qw(ad.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> de() {
        return (LinkedQueueNode) e.qw.getObjectVolatile(this, f11208th);
    }

    public final void fe(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
