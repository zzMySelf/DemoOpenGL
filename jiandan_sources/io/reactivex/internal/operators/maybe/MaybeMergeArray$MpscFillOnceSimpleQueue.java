package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import th.de.p039if.ad.qw;
import th.de.p039if.fe.de.fe;

public final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements fe<T> {
    public static final long serialVersionUID = -7969063454040569579L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int i2) {
        super(i2);
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.maybe.MaybeMergeArray$MpscFillOnceSimpleQueue.clear():void");
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        int i2 = this.consumerIndex;
        lazySet(i2, (Object) null);
        this.consumerIndex = i2 + 1;
    }

    public boolean isEmpty() {
        return this.consumerIndex == producerIndex();
    }

    public boolean offer(T t) {
        qw.rg(t, "value is null");
        int andIncrement = this.producerIndex.getAndIncrement();
        if (andIncrement >= length()) {
            return false;
        }
        lazySet(andIncrement, t);
        return true;
    }

    public T peek() {
        int i2 = this.consumerIndex;
        if (i2 == length()) {
            return null;
        }
        return get(i2);
    }

    public T poll() {
        int i2 = this.consumerIndex;
        if (i2 == length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            T t = get(i2);
            if (t != null) {
                this.consumerIndex = i2 + 1;
                lazySet(i2, (Object) null);
                return t;
            }
        } while (atomicInteger.get() != i2);
        return null;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }
}
