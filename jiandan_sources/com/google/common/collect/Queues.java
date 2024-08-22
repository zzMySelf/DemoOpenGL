package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class Queues {
    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static <E> int drain(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i2, long j, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.checkNotNull(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j);
        int i3 = 0;
        while (i3 < i2) {
            i3 += blockingQueue.drainTo(collection, i2 - i3);
            if (i3 < i2) {
                E poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
                i3++;
            }
        }
        return i3;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static <E> int drainUninterruptibly(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i2, long j, TimeUnit timeUnit) {
        E poll;
        Preconditions.checkNotNull(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j);
        int i3 = 0;
        boolean z = false;
        while (i3 < i2) {
            try {
                i3 += blockingQueue.drainTo(collection, i2 - i3);
                if (i3 < i2) {
                    while (true) {
                        try {
                            poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    }
                    if (poll == null) {
                        break;
                    }
                    collection.add(poll);
                    i3++;
                }
            } catch (Throwable th2) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i3;
    }

    @GwtIncompatible
    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int i2) {
        return new ArrayBlockingQueue<>(i2);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque<>();
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque<>();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue<>();
    }

    @GwtIncompatible
    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue<>();
    }

    public static <E> Deque<E> synchronizedDeque(Deque<E> deque) {
        return Synchronized.deque(deque, (Object) null);
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> queue) {
        return Synchronized.queue(queue, (Object) null);
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<>(Collections2.cast(iterable));
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<>(Collections2.cast(iterable));
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int i2) {
        return new LinkedBlockingDeque<>(i2);
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int i2) {
        return new LinkedBlockingQueue<>(i2);
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<>(Collections2.cast(iterable));
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<>(Collections2.cast(iterable));
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<>(Collections2.cast(iterable));
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<>(Collections2.cast(iterable));
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }
}
