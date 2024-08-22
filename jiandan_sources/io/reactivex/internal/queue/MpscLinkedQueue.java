package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f10313ad = new AtomicReference<>();

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f10314th = new AtomicReference<>();

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        public static final long serialVersionUID = 2404266111789071508L;
        public E value;

        public LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue((Object) null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e) {
            this.value = e;
        }

        public LinkedQueueNode(E e) {
            spValue(e);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        fe(linkedQueueNode);
        rg(linkedQueueNode);
    }

    public LinkedQueueNode<T> ad() {
        return this.f10314th.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    public LinkedQueueNode<T> de() {
        return this.f10313ad.get();
    }

    public void fe(LinkedQueueNode<T> linkedQueueNode) {
        this.f10314th.lazySet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return ad() == de();
    }

    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
            rg(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode qw = qw();
        LinkedQueueNode lvNext2 = qw.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            fe(lvNext2);
            return andNullValue;
        } else if (qw == de()) {
            return null;
        } else {
            do {
                lvNext = qw.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            fe(lvNext);
            return andNullValue2;
        }
    }

    public LinkedQueueNode<T> qw() {
        return this.f10314th.get();
    }

    public LinkedQueueNode<T> rg(LinkedQueueNode<T> linkedQueueNode) {
        return this.f10313ad.getAndSet(linkedQueueNode);
    }
}
