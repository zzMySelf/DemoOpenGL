package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final LongArrayList EMPTY_LIST;
    public long[] array;
    public int size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    public LongArrayList() {
        this(new long[10], 0);
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i2) {
        return "Index:" + i2 + ", Size:" + this.size;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i2 = longArrayList.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.array;
            if (i4 > jArr.length) {
                this.array = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
            this.size = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j) {
        ensureIsMutable();
        int i2 = this.size;
        long[] jArr = this.array;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        jArr3[i3] = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.array[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public long getLong(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + Internal.hashLong(this.array[i3]);
        }
        return i2;
    }

    public void removeRange(int i2, int i3) {
        ensureIsMutable();
        if (i3 >= i2) {
            long[] jArr = this.array;
            System.arraycopy(jArr, i3, jArr, i2, this.size - i3);
            this.size -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i2, long j) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        long[] jArr = this.array;
        long j2 = jArr[i2];
        jArr[i2] = j;
        return j2;
    }

    public int size() {
        return this.size;
    }

    public LongArrayList(long[] jArr, int i2) {
        this.array = jArr;
        this.size = i2;
    }

    public Long get(int i2) {
        return Long.valueOf(getLong(i2));
    }

    public Internal.LongList mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Long.valueOf(this.array[i2]))) {
                long[] jArr = this.array;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.size - i2) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public Long set(int i2, Long l) {
        return Long.valueOf(setLong(i2, l.longValue()));
    }

    public boolean add(Long l) {
        addLong(l.longValue());
        return true;
    }

    public void add(int i2, Long l) {
        addLong(i2, l.longValue());
    }

    private void addLong(int i2, long j) {
        int i3;
        ensureIsMutable();
        if (i2 < 0 || i2 > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
        long[] jArr = this.array;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.array, i2, jArr2, i2 + 1, this.size - i2);
            this.array = jArr2;
        }
        this.array[i2] = j;
        this.size++;
        this.modCount++;
    }

    public Long remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        long[] jArr = this.array;
        long j = jArr[i2];
        int i3 = this.size;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }
}
