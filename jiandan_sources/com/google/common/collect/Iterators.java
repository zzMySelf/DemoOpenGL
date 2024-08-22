package com.google.common.collect;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Iterators {

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        public static final UnmodifiableListIterator<Object> EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        public final T[] array;
        public final int offset;

        public ArrayItr(T[] tArr, int i2, int i3, int i4) {
            super(i3, i4);
            this.array = tArr;
            this.offset = i2;
        }

        public T get(int i2) {
            return this.array[this.offset + i2];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T> {
        public Iterator<? extends T> iterator = Iterators.emptyIterator();
        @NullableDecl
        public Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;
        @NullableDecl
        public Iterator<? extends T> toRemove;
        public Iterator<? extends Iterator<? extends T>> topMetaIterator;

        public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it) {
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(it);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.topMetaIterator;
                if (it != null && it.hasNext()) {
                    return this.topMetaIterator;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.metaIterators;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.topMetaIterator = this.metaIterators.removeFirst();
            }
        }

        public boolean hasNext() {
            while (!((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> topMetaIterator2 = getTopMetaIterator();
                this.topMetaIterator = topMetaIterator2;
                if (topMetaIterator2 == null) {
                    return false;
                }
                Iterator<? extends T> it = (Iterator) topMetaIterator2.next();
                this.iterator = it;
                if (it instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it;
                    this.iterator = concatenatedIterator.iterator;
                    if (this.metaIterators == null) {
                        this.metaIterators = new ArrayDeque();
                    }
                    this.metaIterators.addFirst(this.topMetaIterator);
                    if (concatenatedIterator.metaIterators != null) {
                        while (!concatenatedIterator.metaIterators.isEmpty()) {
                            this.metaIterators.addFirst(concatenatedIterator.metaIterators.removeLast());
                        }
                    }
                    this.topMetaIterator = concatenatedIterator.topMetaIterator;
                }
            }
            return true;
        }

        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.iterator;
                this.toRemove = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove != null);
            this.toRemove.remove();
            this.toRemove = null;
        }
    }

    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        public final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.queue = new PriorityQueue(2, new Comparator<PeekingIterator<T>>() {
                public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                    return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
                }
            });
            for (Iterator it : iterable) {
                if (it.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(it));
                }
            }
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        public T next() {
            PeekingIterator remove = this.queue.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.queue.add(remove);
            }
            return next;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E> {
        public boolean hasPeeked;
        public final Iterator<? extends E> iterator;
        @NullableDecl
        public E peekedElement;

        public PeekingImpl(Iterator<? extends E> it) {
            this.iterator = (Iterator) Preconditions.checkNotNull(it);
        }

        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E e = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return e;
        }

        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }

        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it, int i2) {
        Preconditions.checkNotNull(it);
        int i3 = 0;
        Preconditions.checkArgument(i2 >= 0, "numberToAdvance must be nonnegative");
        while (i3 < i2 && it.hasNext()) {
            it.next();
            i3++;
        }
        return i3;
    }

    public static <T> boolean all(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it, Predicate<? super T> predicate) {
        return indexOf(it, predicate) != -1;
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new Enumeration<T>() {
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            public T nextElement() {
                return it.next();
            }
        };
    }

    public static <T> ListIterator<T> cast(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void checkNonnegative(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("position (" + i2 + ") must not be negative");
        }
    }

    public static void clear(Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        return concat(consumingForArray(it, it2));
    }

    public static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... itArr) {
        for (Iterator checkNotNull : (Iterator[]) Preconditions.checkNotNull(itArr)) {
            Preconditions.checkNotNull(checkNotNull);
        }
        return concat(consumingForArray(itArr));
    }

    public static <T> Iterator<T> consumingForArray(final T... tArr) {
        return new UnmodifiableIterator<T>() {
            public int index = 0;

            public boolean hasNext() {
                return this.index < tArr.length;
            }

            public T next() {
                if (hasNext()) {
                    T[] tArr = tArr;
                    int i2 = this.index;
                    T t = tArr[i2];
                    tArr[i2] = null;
                    this.index = i2 + 1;
                    return t;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                T next = it.next();
                it.remove();
                return next;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean contains(Iterator<?> it, @NullableDecl Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>() {
            public Iterator<T> iterator = Iterators.emptyModifiableIterator();

            public boolean hasNext() {
                return this.iterator.hasNext() || iterable.iterator().hasNext();
            }

            public T next() {
                if (!this.iterator.hasNext()) {
                    Iterator<T> it = iterable.iterator();
                    this.iterator = it;
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.iterator.next();
            }

            public void remove() {
                this.iterator.remove();
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.equal(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    public static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return ArrayItr.EMPTY;
    }

    public static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> it, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() {
            public T computeNext() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        };
    }

    public static <T> T find(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        return forArray(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static int frequency(Iterator<?> it, @NullableDecl Object obj) {
        int i2 = 0;
        while (contains(it, obj)) {
            i2++;
        }
        return i2;
    }

    public static <T> T get(Iterator<T> it, int i2) {
        checkNonnegative(i2);
        int advance = advance(it, i2);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i2 + ") must be less than the number of elements that remained (" + advance + ")");
    }

    public static <T> T getLast(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @NullableDecl
    public static <T> T getNext(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T getOnlyElement(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(Typography.greater);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int indexOf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> Iterator<T> limit(final Iterator<T> it, final int i2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i2 >= 0, "limit is negative");
        return new Iterator<T>() {
            public int count;

            public boolean hasNext() {
                return this.count < i2 && it.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    this.count++;
                    return it.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                it.remove();
            }
        };
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it, int i2) {
        return partitionImpl(it, i2, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it, int i2) {
        return partitionImpl(it, i2, false);
    }

    public static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> it, final int i2, final boolean z) {
        Preconditions.checkNotNull(it);
        Preconditions.checkArgument(i2 > 0);
        return new UnmodifiableIterator<List<T>>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public List<T> next() {
                if (hasNext()) {
                    Object[] objArr = new Object[i2];
                    int i2 = 0;
                    while (i2 < i2 && it.hasNext()) {
                        objArr[i2] = it.next();
                        i2++;
                    }
                    for (int i3 = i2; i3 < i2; i3++) {
                        objArr[i3] = null;
                    }
                    List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                    return (z || i2 == i2) ? unmodifiableList : unmodifiableList.subList(0, i2);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it) {
        if (it instanceof PeekingImpl) {
            return (PeekingImpl) it;
        }
        return new PeekingImpl(it);
    }

    @NullableDecl
    public static <T> T pollNext(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@NullableDecl final T t) {
        return new UnmodifiableIterator<T>() {
            public boolean done;

            public boolean hasNext() {
                return !this.done;
            }

            public T next() {
                if (!this.done) {
                    this.done = true;
                    return t;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static int size(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.saturatedCast(j);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it, Class<T> cls) {
        return Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static String toString(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            z = false;
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(it) {
            public T transform(F f) {
                return function.apply(f);
            }
        };
    }

    public static <T> Optional<T> tryFind(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static <T> UnmodifiableListIterator<T> forArray(T[] tArr, int i2, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkPositionIndexes(i2, i2 + i3, tArr.length);
        Preconditions.checkPositionIndex(i4, i3);
        if (i3 == 0) {
            return emptyListIterator();
        }
        return new ArrayItr(tArr, i2, i3, i4);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList((E[]) tArr));
    }

    @NullableDecl
    public static <T> T getLast(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? getLast(it) : t;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(consumingForArray(it, it2, it3));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it, Class<T> cls) {
        return filter(it, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    @NullableDecl
    public static <T> T get(Iterator<? extends T> it, int i2, @NullableDecl T t) {
        checkNonnegative(i2);
        advance(it, i2);
        return getNext(it, t);
    }

    @NullableDecl
    public static <T> T find(Iterator<? extends T> it, Predicate<? super T> predicate, @NullableDecl T t) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(consumingForArray(it, it2, it3, it4));
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterator<? extends T> it, @NullableDecl T t) {
        return it.hasNext() ? getOnlyElement(it) : t;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it) {
        return new ConcatenatedIterator(it);
    }
}
