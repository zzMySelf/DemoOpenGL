package rx.internal.util.unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    protected final long[] sequenceBuffer;

    static {
        Class<long[]> cls = long[].class;
        if (8 == UnsafeAccess.UNSAFE.arrayIndexScale(cls)) {
            int i2 = SPARSE_SHIFT + 3;
            ELEMENT_SHIFT = i2;
            ARRAY_BASE = (long) (UnsafeAccess.UNSAFE.arrayBaseOffset(cls) + (32 << (i2 - SPARSE_SHIFT)));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int capacity) {
        super(capacity);
        int actualCapacity = (int) (this.mask + 1);
        this.sequenceBuffer = new long[((actualCapacity << SPARSE_SHIFT) + 64)];
        for (long i2 = 0; i2 < ((long) actualCapacity); i2++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(i2), i2);
        }
    }

    /* access modifiers changed from: protected */
    public final long calcSequenceOffset(long index) {
        return ARRAY_BASE + ((this.mask & index) << ELEMENT_SHIFT);
    }

    /* access modifiers changed from: protected */
    public final void soSequence(long[] buffer, long offset, long e2) {
        UnsafeAccess.UNSAFE.putOrderedLong(buffer, offset, e2);
    }

    /* access modifiers changed from: protected */
    public final long lvSequence(long[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getLongVolatile(buffer, offset);
    }
}
