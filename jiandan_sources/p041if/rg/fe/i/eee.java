package p041if.rg.fe.i;

import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.i.eee  reason: invalid package */
public final class eee<E> extends qw<E> {
    public eee() {
        ad(new LinkedQueueNode());
        fe(this.producerNode);
        this.consumerNode.soNext((LinkedQueueNode) null);
    }

    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
            this.producerNode.soNext(linkedQueueNode);
            this.producerNode = linkedQueueNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E peek() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        this.consumerNode = lvNext;
        return andNullValue;
    }
}
