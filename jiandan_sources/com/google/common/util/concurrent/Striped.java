package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@GwtIncompatible
@Beta
public abstract class Striped<L> {
    public static final int ALL_SET = -1;
    public static final int LARGE_LAZY_CUTOFF = 1024;
    public static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() {
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    };
    public static final Supplier<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() {
        public ReadWriteLock get() {
            return new WeakSafeReadWriteLock();
        }
    };

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        public final Object[] array;

        public L getAt(int i2) {
            return this.array[i2];
        }

        public int size() {
            return this.array.length;
        }

        public CompactStriped(int i2, Supplier<L> supplier) {
            super(i2);
            int i3 = 0;
            Preconditions.checkArgument(i2 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[(this.mask + 1)];
            while (true) {
                Object[] objArr = this.array;
                if (i3 < objArr.length) {
                    objArr[i3] = supplier.get();
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final ConcurrentMap<Integer, L> locks;
        public final int size;
        public final Supplier<L> supplier;

        public LargeLazyStriped(int i2, Supplier<L> supplier2) {
            super(i2);
            int i3 = this.mask;
            this.size = i3 == -1 ? Integer.MAX_VALUE : i3 + 1;
            this.supplier = supplier2;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        public L getAt(int i2) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i2, size());
            }
            L l = this.locks.get(Integer.valueOf(i2));
            if (l != null) {
                return l;
            }
            L l2 = this.supplier.get();
            return MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i2), l2), l2);
        }

        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedSemaphore(int i2) {
            super(i2, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        public final int mask;

        public PowerOfTwoStriped(int i2) {
            super();
            int i3;
            Preconditions.checkArgument(i2 > 0, "Stripes must be positive");
            if (i2 > 1073741824) {
                i3 = -1;
            } else {
                i3 = Striped.ceilToPowerOfTwo(i2) - 1;
            }
            this.mask = i3;
        }

        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        public final ReferenceQueue<L> queue = new ReferenceQueue<>();
        public final int size;
        public final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            public final int index;

            public ArrayReference(L l, int i2, ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                this.index = i2;
            }
        }

        public SmallLazyStriped(int i2, Supplier<L> supplier2) {
            super(i2);
            int i3 = this.mask;
            this.size = i3 == -1 ? Integer.MAX_VALUE : i3 + 1;
            this.locks = new AtomicReferenceArray<>(this.size);
            this.supplier = supplier2;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    this.locks.compareAndSet(arrayReference.index, arrayReference, (Object) null);
                } else {
                    return;
                }
            }
        }

        public L getAt(int i2) {
            L l;
            L l2;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i2, size());
            }
            ArrayReference arrayReference = this.locks.get(i2);
            if (arrayReference == null) {
                l = null;
            } else {
                l = arrayReference.get();
            }
            if (l != null) {
                return l;
            }
            L l3 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l3, i2, this.queue);
            while (!this.locks.compareAndSet(i2, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i2);
                if (arrayReference == null) {
                    l2 = null;
                    continue;
                } else {
                    l2 = arrayReference.get();
                    continue;
                }
                if (l2 != null) {
                    return l2;
                }
            }
            drainQueue();
            return l3;
        }

        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        public final Condition delegate;
        public final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        public final Lock delegate;
        public final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Lock delegate() {
            return this.delegate;
        }

        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        public final ReadWriteLock delegate = new ReentrantReadWriteLock();

        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    public static int ceilToPowerOfTwo(int i2) {
        return 1 << IntMath.log2(i2, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i2, Supplier<L> supplier) {
        return new CompactStriped(i2, supplier);
    }

    public static <L> Striped<L> lazy(int i2, Supplier<L> supplier) {
        return i2 < 1024 ? new SmallLazyStriped(i2, supplier) : new LargeLazyStriped(i2, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i2) {
        return lazy(i2, new Supplier<Lock>() {
            public Lock get() {
                return new ReentrantLock(false);
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i2) {
        return lazy(i2, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i2, final int i3) {
        return lazy(i2, new Supplier<Semaphore>() {
            public Semaphore get() {
                return new Semaphore(i3, false);
            }
        });
    }

    public static Striped<Lock> lock(int i2) {
        return custom(i2, new Supplier<Lock>() {
            public Lock get() {
                return new PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i2) {
        return custom(i2, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> semaphore(int i2, final int i3) {
        return custom(i2, new Supplier<Semaphore>() {
            public Semaphore get() {
                return new PaddedSemaphore(i3);
            }
        });
    }

    public static int smear(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i2 = 0; i2 < array.length; i2++) {
            iArr[i2] = indexFor(array[i2]);
        }
        Arrays.sort(iArr);
        int i3 = iArr[0];
        array[0] = getAt(i3);
        for (int i4 = 1; i4 < array.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3) {
                array[i4] = array[i4 - 1];
            } else {
                array[i4] = getAt(i5);
                i3 = i5;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(array));
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i2);

    public abstract int indexFor(Object obj);

    public abstract int size();

    public Striped() {
    }
}
