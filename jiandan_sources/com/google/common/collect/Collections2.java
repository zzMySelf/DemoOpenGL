package com.google.common.collect;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class Collections2 {

    public static class FilteredCollection<E> extends AbstractCollection<E> {
        public final Predicate<? super E> predicate;
        public final Collection<E> unfiltered;

        public FilteredCollection(Collection<E> collection, Predicate<? super E> predicate2) {
            this.unfiltered = collection;
            this.predicate = predicate2;
        }

        public boolean add(E e) {
            Preconditions.checkArgument(this.predicate.apply(e));
            return this.unfiltered.add(e);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (Object apply : collection) {
                Preconditions.checkArgument(this.predicate.apply(apply));
            }
            return this.unfiltered.addAll(collection);
        }

        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (Collections2.safeContains(this.unfiltered, obj)) {
                return this.predicate.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        public FilteredCollection<E> createCombined(Predicate<? super E> predicate2) {
            return new FilteredCollection<>(this.unfiltered, Predicates.and(this.predicate, predicate2));
        }

        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        public boolean remove(Object obj) {
            return contains(obj) && this.unfiltered.remove(obj);
        }

        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.unfiltered.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.predicate.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.unfiltered.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.predicate.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public int size() {
            int i2 = 0;
            for (E apply : this.unfiltered) {
                if (this.predicate.apply(apply)) {
                    i2++;
                }
            }
            return i2;
        }

        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        public final Comparator<? super E> comparator;
        public final ImmutableList<E> inputList;
        public final int size;

        public OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator2) {
            ImmutableList<E> sortedCopyOf = ImmutableList.sortedCopyOf(comparator2, iterable);
            this.inputList = sortedCopyOf;
            this.comparator = comparator2;
            this.size = calculateSize(sortedCopyOf, comparator2);
        }

        public static <E> int calculateSize(List<E> list, Comparator<? super E> comparator2) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            while (i2 < list.size()) {
                if (comparator2.compare(list.get(i2 - 1), list.get(i2)) < 0) {
                    i3 = IntMath.saturatedMultiply(i3, IntMath.binomial(i2, i4));
                    i4 = 0;
                    if (i3 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                i2++;
                i4++;
            }
            return IntMath.saturatedMultiply(i3, IntMath.binomial(i2, i4));
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        public int size() {
            return this.size;
        }

        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    public static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        public final Comparator<? super E> comparator;
        @NullableDecl
        public List<E> nextPermutation;

        public OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator2) {
            this.nextPermutation = Lists.newArrayList(list);
            this.comparator = comparator2;
        }

        public void calculateNextPermutation() {
            int findNextJ = findNextJ();
            if (findNextJ == -1) {
                this.nextPermutation = null;
                return;
            }
            Collections.swap(this.nextPermutation, findNextJ, findNextL(findNextJ));
            Collections.reverse(this.nextPermutation.subList(findNextJ + 1, this.nextPermutation.size()));
        }

        public int findNextJ() {
            for (int size = this.nextPermutation.size() - 2; size >= 0; size--) {
                if (this.comparator.compare(this.nextPermutation.get(size), this.nextPermutation.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int findNextL(int i2) {
            E e = this.nextPermutation.get(i2);
            for (int size = this.nextPermutation.size() - 1; size > i2; size--) {
                if (this.comparator.compare(e, this.nextPermutation.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }

        public List<E> computeNext() {
            List<E> list = this.nextPermutation;
            if (list == null) {
                return (List) endOfData();
            }
            ImmutableList<E> copyOf = ImmutableList.copyOf(list);
            calculateNextPermutation();
            return copyOf;
        }
    }

    public static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        public final ImmutableList<E> inputList;

        public PermutationCollection(ImmutableList<E> immutableList) {
            this.inputList = immutableList;
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    public static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        public final int[] c;
        public int j = Integer.MAX_VALUE;
        public final List<E> list;

        /* renamed from: o  reason: collision with root package name */
        public final int[] f4421o;

        public PermutationIterator(List<E> list2) {
            this.list = new ArrayList(list2);
            int size = list2.size();
            int[] iArr = new int[size];
            this.c = iArr;
            this.f4421o = new int[size];
            Arrays.fill(iArr, 0);
            Arrays.fill(this.f4421o, 1);
        }

        public void calculateNextPermutation() {
            int size = this.list.size() - 1;
            this.j = size;
            if (size != -1) {
                int i2 = 0;
                while (true) {
                    int[] iArr = this.c;
                    int i3 = this.j;
                    int i4 = iArr[i3] + this.f4421o[i3];
                    if (i4 < 0) {
                        switchDirection();
                    } else if (i4 != i3 + 1) {
                        Collections.swap(this.list, (i3 - iArr[i3]) + i2, (i3 - i4) + i2);
                        this.c[this.j] = i4;
                        return;
                    } else if (i3 != 0) {
                        i2++;
                        switchDirection();
                    } else {
                        return;
                    }
                }
            }
        }

        public void switchDirection() {
            int[] iArr = this.f4421o;
            int i2 = this.j;
            iArr[i2] = -iArr[i2];
            this.j = i2 - 1;
        }

        public List<E> computeNext() {
            if (this.j <= 0) {
                return (List) endOfData();
            }
            ImmutableList<E> copyOf = ImmutableList.copyOf(this.list);
            calculateNextPermutation();
            return copyOf;
        }
    }

    public static class TransformedCollection<F, T> extends AbstractCollection<T> {
        public final Collection<F> fromCollection;
        public final Function<? super F, ? extends T> function;

        public TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function2) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(collection);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromCollection.clear();
        }

        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        public int size() {
            return this.fromCollection.size();
        }
    }

    public static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static boolean containsAllImpl(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static <E> ObjectCountHashMap<E> counts(Collection<E> collection) {
        ObjectCountHashMap<E> objectCountHashMap = new ObjectCountHashMap<>();
        for (E next : collection) {
            objectCountHashMap.put(next, objectCountHashMap.get(next) + 1);
        }
        return objectCountHashMap;
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof FilteredCollection) {
            return ((FilteredCollection) collection).createCombined(predicate);
        }
        return new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    public static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap<?> counts = counts(list);
        ObjectCountHashMap<?> counts2 = counts(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (counts.getValue(i2) != counts2.get(counts.getKey(i2))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder newStringBuilderForCollection(int i2) {
        CollectPreconditions.checkNonnegative(i2, "size");
        return new StringBuilder((int) Math.min(((long) i2) * 8, 1073741824));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.copyOf(collection));
    }

    public static boolean safeContains(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean safeRemove(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String toStringImpl(Collection<?> collection) {
        StringBuilder newStringBuilderForCollection = newStringBuilderForCollection(collection.size());
        newStringBuilderForCollection.append('[');
        boolean z = true;
        for (Object next : collection) {
            if (!z) {
                newStringBuilderForCollection.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            z = false;
            if (next == collection) {
                newStringBuilderForCollection.append("(this Collection)");
            } else {
                newStringBuilderForCollection.append(next);
            }
        }
        newStringBuilderForCollection.append(']');
        return newStringBuilderForCollection.toString();
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }
}
