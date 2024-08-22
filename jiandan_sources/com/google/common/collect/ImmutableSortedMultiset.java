package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @LazyInit
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        public final Comparator<? super E> comparator;
        public int[] counts = new int[4];
        @VisibleForTesting
        public E[] elements = new Object[4];
        public boolean forceCopyElements;
        public int length;

        public Builder(Comparator<? super E> comparator2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        private void dedupAndCoalesce(boolean z) {
            int i2 = this.length;
            if (i2 != 0) {
                E[] copyOf = Arrays.copyOf(this.elements, i2);
                Arrays.sort(copyOf, this.comparator);
                int i3 = 1;
                for (int i4 = 1; i4 < copyOf.length; i4++) {
                    if (this.comparator.compare(copyOf[i3 - 1], copyOf[i4]) < 0) {
                        copyOf[i3] = copyOf[i4];
                        i3++;
                    }
                }
                Arrays.fill(copyOf, i3, this.length, (Object) null);
                if (z) {
                    int i5 = i3 * 4;
                    int i6 = this.length;
                    if (i5 > i6 * 3) {
                        copyOf = Arrays.copyOf(copyOf, IntMath.saturatedAdd(i6, (i6 / 2) + 1));
                    }
                }
                int[] iArr = new int[copyOf.length];
                for (int i7 = 0; i7 < this.length; i7++) {
                    int binarySearch = Arrays.binarySearch(copyOf, 0, i3, this.elements[i7], this.comparator);
                    int[] iArr2 = this.counts;
                    if (iArr2[i7] >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + iArr2[i7];
                    } else {
                        iArr[binarySearch] = ~iArr2[i7];
                    }
                }
                this.elements = copyOf;
                this.counts = iArr;
                this.length = i3;
            }
        }

        private void dedupAndCoalesceAndDeleteEmpty() {
            dedupAndCoalesce(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.length;
                if (i2 < i4) {
                    int[] iArr = this.counts;
                    if (iArr[i2] > 0) {
                        E[] eArr = this.elements;
                        eArr[i3] = eArr[i2];
                        iArr[i3] = iArr[i2];
                        i3++;
                    }
                    i2++;
                } else {
                    Arrays.fill(this.elements, i3, i4, (Object) null);
                    Arrays.fill(this.counts, i3, this.length, 0);
                    this.length = i3;
                    return;
                }
            }
        }

        private void maintenance() {
            int i2 = this.length;
            E[] eArr = this.elements;
            if (i2 == eArr.length) {
                dedupAndCoalesce(true);
            } else if (this.forceCopyElements) {
                this.elements = Arrays.copyOf(eArr, eArr.length);
            }
            this.forceCopyElements = false;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i2) {
            Preconditions.checkNotNull(e);
            CollectPreconditions.checkNonnegative(i2, "occurrences");
            if (i2 == 0) {
                return this;
            }
            maintenance();
            E[] eArr = this.elements;
            int i3 = this.length;
            eArr[i3] = e;
            this.counts[i3] = i2;
            this.length = i3 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i2) {
            Preconditions.checkNotNull(e);
            CollectPreconditions.checkNonnegative(i2, "count");
            maintenance();
            E[] eArr = this.elements;
            int i3 = this.length;
            eArr[i3] = e;
            this.counts[i3] = ~i2;
            this.length = i3 + 1;
            return this;
        }

        public ImmutableSortedMultiset<E> build() {
            dedupAndCoalesceAndDeleteEmpty();
            int i2 = this.length;
            if (i2 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.comparator);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.comparator, i2, this.elements);
            long[] jArr = new long[(this.length + 1)];
            int i3 = 0;
            while (i3 < this.length) {
                int i4 = i3 + 1;
                jArr[i4] = jArr[i3] + ((long) this.counts[i3]);
                i3 = i4;
            }
            this.forceCopyElements = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.length);
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            return addCopies((Object) e, 1);
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry entry : ((Multiset) iterable).entrySet()) {
                    addCopies(entry.getElement(), entry.getCount());
                }
            } else {
                for (Object add : iterable) {
                    add((Object) add);
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E add : eArr) {
                add((Object) add);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Object) it.next());
            }
            return this;
        }
    }

    public static final class SerializedForm<E> implements Serializable {
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i2 = 0;
            for (Multiset.Entry next : sortedMultiset.entrySet()) {
                this.elements[i2] = next.getElement();
                this.counts[i2] = next.getCount();
                i2++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            Builder builder = new Builder(this.comparator);
            for (int i2 = 0; i2 < length; i2++) {
                builder.addCopies((Object) this.elements[i2], this.counts[i2]);
            }
            return builder.build();
        }
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i2 = 0;
        for (Multiset.Entry next : collection) {
            builder.add(next.getElement());
            int i3 = i2 + 1;
            jArr[i3] = jArr[i2] + ((long) next.getCount());
            i2 = i3;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.build(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(e), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", (Object) e, (Object) e2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e, e2}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e, e2, e3}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e, e2, e3, e4}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) iterable).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e, e2, e3, e4, e5}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(eArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, new Comparable[]{e, e2, e3, e4, e5, e6});
        Collections.addAll(newArrayListWithCapacity, eArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }
}
