package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Beta
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    public static final int DEFAULT_CAPACITY = 11;
    public static final int EVEN_POWERS_OF_TWO = 1431655765;
    public static final int ODD_POWERS_OF_TWO = -1431655766;
    public final MinMaxPriorityQueue<E>.Heap maxHeap;
    @VisibleForTesting
    public final int maximumSize;
    public final MinMaxPriorityQueue<E>.Heap minHeap;
    public int modCount;
    public Object[] queue;
    public int size;

    @Beta
    public static final class Builder<B> {
        public static final int UNSET_EXPECTED_SIZE = -1;
        public final Comparator<B> comparator;
        public int expectedSize;
        public int maximumSize;

        /* access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i2) {
            Preconditions.checkArgument(i2 >= 0);
            this.expectedSize = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i2) {
            Preconditions.checkArgument(i2 > 0);
            this.maximumSize = i2;
            return this;
        }

        public Builder(Comparator<B> comparator2) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            for (Object offer : iterable) {
                minMaxPriorityQueue.offer(offer);
            }
            return minMaxPriorityQueue;
        }
    }

    public class Heap {
        public final Ordering<E> ordering;
        @MonotonicNonNullDecl
        @Weak
        public MinMaxPriorityQueue<E>.Heap otherHeap;

        public Heap(Ordering<E> ordering2) {
            this.ordering = ordering2;
        }

        private int getGrandparentIndex(int i2) {
            return getParentIndex(getParentIndex(i2));
        }

        private int getLeftChildIndex(int i2) {
            return (i2 * 2) + 1;
        }

        private int getParentIndex(int i2) {
            return (i2 - 1) / 2;
        }

        private int getRightChildIndex(int i2) {
            return (i2 * 2) + 2;
        }

        /* access modifiers changed from: private */
        public boolean verifyIndex(int i2) {
            if (getLeftChildIndex(i2) < MinMaxPriorityQueue.this.size && compareElements(i2, getLeftChildIndex(i2)) > 0) {
                return false;
            }
            if (getRightChildIndex(i2) < MinMaxPriorityQueue.this.size && compareElements(i2, getRightChildIndex(i2)) > 0) {
                return false;
            }
            if (i2 > 0 && compareElements(i2, getParentIndex(i2)) > 0) {
                return false;
            }
            if (i2 <= 2 || compareElements(getGrandparentIndex(i2), i2) <= 0) {
                return true;
            }
            return false;
        }

        public void bubbleUp(int i2, E e) {
            Heap heap;
            int crossOverUp = crossOverUp(i2, e);
            if (crossOverUp == i2) {
                crossOverUp = i2;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(crossOverUp, e);
        }

        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int i2, E e) {
            while (i2 > 2) {
                int grandparentIndex = getGrandparentIndex(i2);
                Object elementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare(elementData, e) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i2] = elementData;
                i2 = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i2] = e;
            return i2;
        }

        public int compareElements(int i2, int i3) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(i2), MinMaxPriorityQueue.this.elementData(i3));
        }

        public int crossOver(int i2, E e) {
            int findMinChild = findMinChild(i2);
            if (findMinChild <= 0 || this.ordering.compare(MinMaxPriorityQueue.this.elementData(findMinChild), e) >= 0) {
                return crossOverUp(i2, e);
            }
            MinMaxPriorityQueue.this.queue[i2] = MinMaxPriorityQueue.this.elementData(findMinChild);
            MinMaxPriorityQueue.this.queue[findMinChild] = e;
            return findMinChild;
        }

        public int crossOverUp(int i2, E e) {
            int rightChildIndex;
            if (i2 == 0) {
                MinMaxPriorityQueue.this.queue[0] = e;
                return 0;
            }
            int parentIndex = getParentIndex(i2);
            Object elementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
            if (this.ordering.compare(elementData, e) < 0) {
                MinMaxPriorityQueue.this.queue[i2] = elementData;
                MinMaxPriorityQueue.this.queue[parentIndex] = e;
                return parentIndex;
            }
            MinMaxPriorityQueue.this.queue[i2] = e;
            return i2;
        }

        public int fillHoleAt(int i2) {
            while (true) {
                int findMinGrandChild = findMinGrandChild(i2);
                if (findMinGrandChild <= 0) {
                    return i2;
                }
                MinMaxPriorityQueue.this.queue[i2] = MinMaxPriorityQueue.this.elementData(findMinGrandChild);
                i2 = findMinGrandChild;
            }
        }

        public int findMin(int i2, int i3) {
            if (i2 >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i2 > 0);
            int min = Math.min(i2, MinMaxPriorityQueue.this.size - i3) + i3;
            for (int i4 = i2 + 1; i4 < min; i4++) {
                if (compareElements(i4, i2) < 0) {
                    i2 = i4;
                }
            }
            return i2;
        }

        public int findMinChild(int i2) {
            return findMin(getLeftChildIndex(i2), 2);
        }

        public int findMinGrandChild(int i2) {
            int leftChildIndex = getLeftChildIndex(i2);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        public int swapWithConceptuallyLastElement(E e) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, e) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = elementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        public MoveDesc<E> tryCrossOverAndBubbleUp(int i2, int i3, E e) {
            Object obj;
            int crossOver = crossOver(i3, e);
            if (crossOver == i3) {
                return null;
            }
            if (crossOver < i2) {
                obj = MinMaxPriorityQueue.this.elementData(i2);
            } else {
                obj = MinMaxPriorityQueue.this.elementData(getParentIndex(i2));
            }
            if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, e) < i2) {
                return new MoveDesc<>(e, obj);
            }
            return null;
        }
    }

    public static class MoveDesc<E> {
        public final E replaced;
        public final E toTrickle;

        public MoveDesc(E e, E e2) {
            this.toTrickle = e;
            this.replaced = e2;
        }
    }

    public class QueueIterator implements Iterator<E> {
        public boolean canRemove;
        public int cursor;
        public int expectedModCount;
        @MonotonicNonNullDecl
        public Queue<E> forgetMeNot;
        @NullableDecl
        public E lastFromForgetMeNot;
        public int nextCursor;
        @MonotonicNonNullDecl
        public List<E> skipMe;

        public QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        private void nextNotInSkipMe(int i2) {
            if (this.nextCursor < i2) {
                if (this.skipMe != null) {
                    while (i2 < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i2))) {
                        i2++;
                    }
                }
                this.nextCursor = i2;
            }
        }

        private boolean removeExact(Object obj) {
            for (int i2 = 0; i2 < MinMaxPriorityQueue.this.size; i2++) {
                if (MinMaxPriorityQueue.this.queue[i2] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i2);
                    return true;
                }
            }
            return false;
        }

        public boolean hasNext() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.forgetMeNot;
            if (queue == null || queue.isEmpty()) {
                return false;
            }
            return true;
        }

        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                int i2 = this.nextCursor;
                this.cursor = i2;
                this.canRemove = true;
                return MinMaxPriorityQueue.this.elementData(i2);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                E poll = this.forgetMeNot.poll();
                this.lastFromForgetMeNot = poll;
                if (poll != null) {
                    this.canRemove = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor < MinMaxPriorityQueue.this.size()) {
                MoveDesc removeAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
                if (removeAt != null) {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque();
                        this.skipMe = new ArrayList(3);
                    }
                    if (!foundAndRemovedExactReference(this.skipMe, removeAt.toTrickle)) {
                        this.forgetMeNot.add(removeAt.toTrickle);
                    }
                    if (!foundAndRemovedExactReference(this.forgetMeNot, removeAt.replaced)) {
                        this.skipMe.add(removeAt.replaced);
                    }
                }
                this.cursor--;
                this.nextCursor--;
                return;
            }
            Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }
    }

    private int calculateNewCapacity() {
        int i2;
        int length = this.queue.length;
        if (length < 64) {
            i2 = (length + 1) * 2;
        } else {
            i2 = IntMath.checkedMultiply(length / 2, 3);
        }
        return capAtMaximumSize(i2, this.maximumSize);
    }

    public static int capAtMaximumSize(int i2, int i3) {
        return Math.min(i2 - 1, i3) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i2) {
        return new Builder(Ordering.natural()).expectedSize(i2);
    }

    private MoveDesc<E> fillHole(int i2, E e) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i2);
        int fillHoleAt = heapForIndex.fillHoleAt(i2);
        int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHoleAt, e);
        if (bubbleUpAlternatingLevels == fillHoleAt) {
            return heapForIndex.tryCrossOverAndBubbleUp(i2, fillHoleAt, e);
        }
        if (bubbleUpAlternatingLevels < i2) {
            return new MoveDesc<>(e, elementData(i2));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i2 = this.size;
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2 || this.maxHeap.compareElements(1, 2) <= 0) {
            return 1;
        }
        return 2;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i2) {
        return isEvenLevel(i2) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int i2, int i3, Iterable<?> iterable) {
        if (i2 == -1) {
            i2 = 11;
        }
        if (iterable instanceof Collection) {
            i2 = Math.max(i2, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i2, i3);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int i2) {
        int i3 = ~(~(i2 + 1));
        Preconditions.checkState(i3 > 0, "negative index");
        return (1431655765 & i3) > (i3 & ODD_POWERS_OF_TWO);
    }

    public static Builder<Comparable> maximumSize(int i2) {
        return new Builder(Ordering.natural()).maximumSize(i2);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i2) {
        E elementData = elementData(i2);
        removeAt(i2);
        return elementData;
    }

    @CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object offer : collection) {
            offer(offer);
            z = true;
        }
        return z;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    public void clear() {
        for (int i2 = 0; i2 < this.size; i2++) {
            this.queue[i2] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    public E elementData(int i2) {
        return this.queue[i2];
    }

    @VisibleForTesting
    public boolean isIntact() {
        for (int i2 = 1; i2 < this.size; i2++) {
            if (!heapForIndex(i2).verifyIndex(i2)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @CanIgnoreReturnValue
    public boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.modCount++;
        int i2 = this.size;
        this.size = i2 + 1;
        growIfNeeded();
        heapForIndex(i2).bubbleUp(i2, e);
        if (this.size <= this.maximumSize || pollLast() != e) {
            return true;
        }
        return false;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    public MoveDesc<E> removeAt(int i2) {
        Preconditions.checkPositionIndex(i2, this.size);
        this.modCount++;
        int i3 = this.size - 1;
        this.size = i3;
        if (i3 == i2) {
            this.queue[i3] = null;
            return null;
        }
        Object elementData = elementData(i3);
        int swapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(elementData);
        if (swapWithConceptuallyLastElement == i2) {
            this.queue[this.size] = null;
            return null;
        }
        Object elementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i2, elementData2);
        if (swapWithConceptuallyLastElement >= i2) {
            return fillHole;
        }
        if (fillHole == null) {
            return new MoveDesc<>(elementData, elementData2);
        }
        return new MoveDesc<>(elementData, fillHole.replaced);
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return removeAndGet(getMaxElementIndex());
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        int i2 = this.size;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.queue, 0, objArr, 0, i2);
        return objArr;
    }

    public MinMaxPriorityQueue(Builder<? super E> builder, int i2) {
        Ordering access$200 = builder.ordering();
        this.minHeap = new Heap(access$200);
        MinMaxPriorityQueue<E>.Heap heap = new Heap(access$200.reverse());
        this.maxHeap = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = this.minHeap;
        heap2.otherHeap = heap;
        heap.otherHeap = heap2;
        this.maximumSize = builder.maximumSize;
        this.queue = new Object[i2];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
