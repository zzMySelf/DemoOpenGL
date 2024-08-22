package p041if.rg.fe.i;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

/* renamed from: if.rg.fe.i.qw  reason: invalid package */
public abstract class qw<E> extends ad<E> {
    public final boolean isEmpty() {
        return de() == qw();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        LinkedQueueNode lvNext;
        LinkedQueueNode de2 = de();
        LinkedQueueNode qw = qw();
        int i2 = 0;
        while (de2 != qw && i2 < Integer.MAX_VALUE) {
            do {
                lvNext = de2.lvNext();
            } while (lvNext == null);
            i2++;
            de2 = lvNext;
        }
        return i2;
    }
}
