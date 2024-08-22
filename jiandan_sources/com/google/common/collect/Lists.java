package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Lists {

    public static class AbstractListWrapper<E> extends AbstractList<E> {
        public final List<E> backingList;

        public AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }

        public void add(int i2, E e) {
            this.backingList.add(i2, e);
        }

        public boolean addAll(int i2, Collection<? extends E> collection) {
            return this.backingList.addAll(i2, collection);
        }

        public boolean contains(Object obj) {
            return this.backingList.contains(obj);
        }

        public E get(int i2) {
            return this.backingList.get(i2);
        }

        public E remove(int i2) {
            return this.backingList.remove(i2);
        }

        public E set(int i2, E e) {
            return this.backingList.set(i2, e);
        }

        public int size() {
            return this.backingList.size();
        }
    }

    public static final class CharSequenceAsList extends AbstractList<Character> {
        public final CharSequence sequence;

        public CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        public int size() {
            return this.sequence.length();
        }

        public Character get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Character.valueOf(this.sequence.charAt(i2));
        }
    }

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static final long serialVersionUID = 0;
        @NullableDecl
        public final E first;
        public final E[] rest;

        public OnePlusArrayList(@NullableDecl E e, E[] eArr) {
            this.first = e;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public E get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return i2 == 0 ? this.first : this.rest[i2 - 1];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    public static class Partition<T> extends AbstractList<List<T>> {
        public final List<T> list;
        public final int size;

        public Partition(List<T> list2, int i2) {
            this.list = list2;
            this.size = i2;
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        public List<T> get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            int i3 = this.size;
            int i4 = i2 * i3;
            return this.list.subList(i4, Math.min(i3 + i4, this.list.size()));
        }
    }

    public static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        public RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    public static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        public RandomAccessPartition(List<T> list, int i2) {
            super(list, i2);
        }
    }

    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        public RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    public static class ReverseList<T> extends AbstractList<T> {
        public final List<T> forwardList;

        public ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        private int reverseIndex(int i2) {
            int size = size();
            Preconditions.checkElementIndex(i2, size);
            return (size - 1) - i2;
        }

        /* access modifiers changed from: private */
        public int reversePosition(int i2) {
            int size = size();
            Preconditions.checkPositionIndex(i2, size);
            return size - i2;
        }

        public void add(int i2, @NullableDecl T t) {
            this.forwardList.add(reversePosition(i2), t);
        }

        public void clear() {
            this.forwardList.clear();
        }

        public T get(int i2) {
            return this.forwardList.get(reverseIndex(i2));
        }

        public List<T> getForwardList() {
            return this.forwardList;
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i2));
            return new ListIterator<T>() {
                public boolean canRemoveOrSet;

                public void add(T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.canRemoveOrSet = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.canRemoveOrSet = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                public void set(T t) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t);
                }
            };
        }

        public T remove(int i2) {
            return this.forwardList.remove(reverseIndex(i2));
        }

        public void removeRange(int i2, int i3) {
            subList(i2, i3).clear();
        }

        public T set(int i2, @NullableDecl T t) {
            return this.forwardList.set(reverseIndex(i2), t);
        }

        public int size() {
            return this.forwardList.size();
        }

        public List<T> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i3), reversePosition(i2)));
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        public final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        public int indexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public boolean isPartialView() {
            return false;
        }

        public int lastIndexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public int size() {
            return this.string.length();
        }

        public Character get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Character.valueOf(this.string.charAt(i2));
        }

        public ImmutableList<Character> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            return Lists.charactersOf(this.string.substring(i2, i3));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final Function<? super F, ? extends T> function;

        public TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i2) {
            return this.function.apply(this.fromList.get(i2));
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i2)) {
                public T transform(F f) {
                    return TransformingRandomAccessList.this.function.apply(f);
                }
            };
        }

        public T remove(int i2) {
            return this.function.apply(this.fromList.remove(i2));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        public static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final Function<? super F, ? extends T> function;

        public TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i2)) {
                public T transform(F f) {
                    return TransformingSequentialList.this.function.apply(f);
                }
            };
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        public static final long serialVersionUID = 0;
        @NullableDecl
        public final E first;
        public final E[] rest;
        @NullableDecl
        public final E second;

        public TwoPlusArrayList(@NullableDecl E e, @NullableDecl E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public E get(int i2) {
            if (i2 == 0) {
                return this.first;
            }
            if (i2 == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i2, size());
            return this.rest[i2 - 2];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    public static <E> boolean addAllImpl(List<E> list, int i2, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i2);
        boolean z = false;
        for (Object add : iterable) {
            listIterator.add(add);
            z = true;
        }
        return z;
    }

    public static <E> List<E> asList(@NullableDecl E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    public static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    @VisibleForTesting
    public static int computeArrayListCapacity(int i2) {
        CollectPreconditions.checkNonnegative(i2, "arraySize");
        return Ints.saturatedCast(((long) i2) + 5 + ((long) (i2 / 10)));
    }

    public static boolean equalsImpl(List<?> list, @NullableDecl Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.equal(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeImpl(List<?> list) {
        int i2;
        int i3 = 1;
        for (Object next : list) {
            int i4 = i3 * 31;
            if (next == null) {
                i2 = 0;
            } else {
                i2 = next.hashCode();
            }
            i3 = ~(~(i4 + i2));
        }
        return i3;
    }

    public static int indexOfImpl(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int indexOfRandomAccess(List<?> list, @NullableDecl Object obj) {
        int size = list.size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (list.get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < size) {
            if (obj.equals(list.get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOfImpl(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int lastIndexOfRandomAccess(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> listIteratorImpl(List<E> list, int i2) {
        return new AbstractListWrapper(list).listIterator(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i2) {
        CollectPreconditions.checkNonnegative(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i2) {
        return new ArrayList<>(computeArrayListCapacity(i2));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i2) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i2 > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i2) : new Partition(list, i2);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).getForwardList();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    public static <E> List<E> subListImpl(List<E> list, int i2, int i3) {
        List list2;
        if (list instanceof RandomAccess) {
            list2 = new RandomAccessListWrapper<E>(list) {
                public static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i2) {
                    return this.backingList.listIterator(i2);
                }
            };
        } else {
            list2 = new AbstractListWrapper<E>(list) {
                public static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i2) {
                    return this.backingList.listIterator(i2);
                }
            };
        }
        return list2.subList(i2, i3);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    public static <E> List<E> asList(@NullableDecl E e, @NullableDecl E e2, E[] eArr) {
        return new TwoPlusArrayList(e, e2, eArr);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @GwtCompatible(serializable = true)
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> newCopyOnWriteArrayList(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0009
            java.util.Collection r1 = com.google.common.collect.Collections2.cast(r1)
            goto L_0x000d
        L_0x0009:
            java.util.ArrayList r1 = newArrayList(r1)
        L_0x000d:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Lists.newCopyOnWriteArrayList(java.lang.Iterable):java.util.concurrent.CopyOnWriteArrayList");
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.cast(iterable));
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
