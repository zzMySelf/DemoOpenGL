package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class TopKSelector<T> {
    public final T[] buffer;
    public int bufferSize;
    public final Comparator<? super T> comparator;
    public final int k;
    @NullableDecl
    public T threshold;

    public TopKSelector(Comparator<? super T> comparator2, int i2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2, "comparator");
        this.k = i2;
        Preconditions.checkArgument(i2 >= 0, "k must be nonnegative, was %s", i2);
        this.buffer = new Object[(i2 * 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i2) {
        return greatest(i2, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i2) {
        return least(i2, Ordering.natural());
    }

    private int partition(int i2, int i3, int i4) {
        T[] tArr = this.buffer;
        T t = tArr[i4];
        tArr[i4] = tArr[i3];
        int i5 = i2;
        while (i2 < i3) {
            if (this.comparator.compare(this.buffer[i2], t) < 0) {
                swap(i5, i2);
                i5++;
            }
            i2++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i3] = tArr2[i5];
        tArr2[i5] = t;
        return i5;
    }

    private void swap(int i2, int i3) {
        T[] tArr = this.buffer;
        T t = tArr[i2];
        tArr[i2] = tArr[i3];
        tArr[i3] = t;
    }

    private void trim() {
        int i2 = (this.k * 2) - 1;
        int log2 = IntMath.log2(i2 + 0, RoundingMode.CEILING) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 < i2) {
                int partition = partition(i3, i2, ((i3 + i2) + 1) >>> 1);
                int i6 = this.k;
                if (partition <= i6) {
                    if (partition >= i6) {
                        break;
                    }
                    i3 = Math.max(partition, i3 + 1);
                    i5 = partition;
                } else {
                    i2 = partition - 1;
                }
                i4++;
                if (i4 >= log2) {
                    Arrays.sort(this.buffer, i3, i2, this.comparator);
                    break;
                }
            } else {
                break;
            }
        }
        this.bufferSize = this.k;
        this.threshold = this.buffer[i5];
        while (true) {
            i5++;
            if (i5 >= this.k) {
                return;
            }
            if (this.comparator.compare(this.buffer[i5], this.threshold) > 0) {
                this.threshold = this.buffer[i5];
            }
        }
    }

    public void offer(@NullableDecl T t) {
        int i2 = this.k;
        if (i2 != 0) {
            int i3 = this.bufferSize;
            if (i3 == 0) {
                this.buffer[0] = t;
                this.threshold = t;
                this.bufferSize = 1;
            } else if (i3 < i2) {
                T[] tArr = this.buffer;
                this.bufferSize = i3 + 1;
                tArr[i3] = t;
                if (this.comparator.compare(t, this.threshold) > 0) {
                    this.threshold = t;
                }
            } else if (this.comparator.compare(t, this.threshold) < 0) {
                T[] tArr2 = this.buffer;
                int i4 = this.bufferSize;
                int i5 = i4 + 1;
                this.bufferSize = i5;
                tArr2[i4] = t;
                if (i5 == this.k * 2) {
                    trim();
                }
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int i2 = this.bufferSize;
        int i3 = this.k;
        if (i2 > i3) {
            T[] tArr = this.buffer;
            Arrays.fill(tArr, i3, tArr.length, (Object) null);
            int i4 = this.k;
            this.bufferSize = i4;
            this.threshold = this.buffer[i4 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int i2, Comparator<? super T> comparator2) {
        return new TopKSelector<>(Ordering.from(comparator2).reverse(), i2);
    }

    public static <T> TopKSelector<T> least(int i2, Comparator<? super T> comparator2) {
        return new TopKSelector<>(comparator2, i2);
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }
}
