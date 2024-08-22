package p041if.rg.fe.i;

import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.i.rg  reason: invalid package */
public abstract class rg<E> extends de<E> {

    /* renamed from: ad  reason: collision with root package name */
    public static final long f11217ad = e.qw(rg.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final void ad(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    public final LinkedQueueNode<E> qw() {
        return (LinkedQueueNode) e.qw.getObjectVolatile(this, f11217ad);
    }
}
