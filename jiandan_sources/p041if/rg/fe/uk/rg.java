package p041if.rg.fe.uk;

import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.uk.rg  reason: invalid package */
public final class rg<E> extends ad<E> {
    public rg() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        th(linkedQueueNode);
        rg(linkedQueueNode);
        linkedQueueNode.soNext((LinkedQueueNode) null);
    }

    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e);
            ad().soNext(linkedQueueNode);
            th(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E peek() {
        LinkedQueueNode lvNext = qw().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode lvNext = qw().lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        rg(lvNext);
        return andNullValue;
    }
}
