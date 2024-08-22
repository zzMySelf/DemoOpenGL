package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        spProducerNode(new LinkedQueueNode());
        spConsumerNode(this.producerNode);
        this.consumerNode.soNext((LinkedQueueNode) null);
    }

    public boolean offer(E nextValue) {
        if (nextValue != null) {
            LinkedQueueNode<E> nextNode = new LinkedQueueNode<>(nextValue);
            this.producerNode.soNext(nextNode);
            this.producerNode = nextNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        LinkedQueueNode<E> nextNode = this.consumerNode.lvNext();
        if (nextNode == null) {
            return null;
        }
        E nextValue = nextNode.getAndNullValue();
        this.consumerNode = nextNode;
        return nextValue;
    }

    public E peek() {
        LinkedQueueNode<E> nextNode = this.consumerNode.lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        return null;
    }
}
