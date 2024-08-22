package com.sdk.d;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class i<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static final long serialVersionUID = -6903933977591709194L;
    public final int a;
    public final AtomicInteger b = new AtomicInteger();
    public transient a<E> c;
    public transient a<E> d;
    public final ReentrantLock e;
    public final Condition f;
    public final ReentrantLock g;
    public final Condition h;

    public class a implements Iterator<E> {
        public a<E> a;
        public a<E> b;
        public E c;

        public a() {
            i.this.a();
            try {
                a aVar = i.this.c.c;
                this.a = aVar;
                if (aVar != null) {
                    this.c = aVar.b();
                }
            } finally {
                i.this.b();
            }
        }

        public boolean hasNext() {
            return this.a != null;
        }

        public E next() {
            a aVar;
            i.this.a();
            try {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    E e = this.c;
                    this.b = aVar2;
                    while (true) {
                        aVar = aVar2.c;
                        if (aVar == aVar2) {
                            aVar = i.this.c.c;
                            break;
                        } else if (aVar == null) {
                            break;
                        } else if (aVar.b() != null) {
                            break;
                        } else {
                            aVar2 = aVar;
                        }
                    }
                    this.a = aVar;
                    this.c = aVar == null ? null : aVar.b();
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                i.this.b();
            }
        }

        public void remove() {
            if (this.b != null) {
                i.this.a();
                try {
                    a<E> aVar = this.b;
                    this.b = null;
                    a<E> aVar2 = i.this.c;
                    while (true) {
                        a<E> aVar3 = aVar2;
                        aVar2 = aVar2.c;
                        if (aVar2 != null) {
                            if (aVar2 == aVar) {
                                i.this.a(aVar2, aVar3);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } finally {
                    i.this.b();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public i() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.g = reentrantLock2;
        this.h = reentrantLock2.newCondition();
        this.a = Integer.MAX_VALUE;
        a<E> aVar = new a<>(null);
        this.c = aVar;
        this.d = aVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b.set(0);
        a<E> aVar = new a<>(null);
        this.c = aVar;
        this.d = aVar;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        a();
        try {
            objectOutputStream.defaultWriteObject();
            a aVar = this.c;
            while (true) {
                aVar = aVar.c;
                if (aVar != null) {
                    objectOutputStream.writeObject(aVar.b());
                } else {
                    objectOutputStream.writeObject((Object) null);
                    return;
                }
            }
        } finally {
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized E a(com.sdk.d.a<E> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            if (r7 != 0) goto L_0x0015
            com.sdk.d.a<E> r7 = r6.c     // Catch:{ all -> 0x0041 }
            com.sdk.d.a<T> r1 = r7.c     // Catch:{ all -> 0x0041 }
            r7.c = r7     // Catch:{ all -> 0x0041 }
            r6.c = r1     // Catch:{ all -> 0x0041 }
            java.lang.Object r7 = r1.b()     // Catch:{ all -> 0x0041 }
            r1.a(r0)     // Catch:{ all -> 0x0041 }
            monitor-exit(r6)
            return r7
        L_0x0015:
            r1 = 0
            com.sdk.d.a<E> r2 = r6.c     // Catch:{ all -> 0x0041 }
        L_0x0018:
            com.sdk.d.a<T> r3 = r2.c     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0037
            com.sdk.d.b r4 = r3.a()     // Catch:{ all -> 0x0041 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x0041 }
            com.sdk.d.b r5 = r7.a()     // Catch:{ all -> 0x0041 }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x0041 }
            if (r4 <= r5) goto L_0x0034
            r2.c = r7     // Catch:{ all -> 0x0041 }
            r7.c = r3     // Catch:{ all -> 0x0041 }
            r1 = 1
            goto L_0x0037
        L_0x0034:
            com.sdk.d.a<T> r2 = r2.c     // Catch:{ all -> 0x0041 }
            goto L_0x0018
        L_0x0037:
            if (r1 != 0) goto L_0x003f
            com.sdk.d.a<E> r1 = r6.d     // Catch:{ all -> 0x0041 }
            r1.c = r7     // Catch:{ all -> 0x0041 }
            r6.d = r7     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r6)
            return r0
        L_0x0041:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.d.i.a(com.sdk.d.a):java.lang.Object");
    }

    public void a() {
        this.g.lock();
        this.e.lock();
    }

    public void a(a<E> aVar, a<E> aVar2) {
        aVar.a(null);
        aVar2.c = aVar.c;
        if (this.d == aVar) {
            this.d = aVar2;
        }
        if (this.b.getAndDecrement() == this.a) {
            this.h.signal();
        }
    }

    public void b() {
        this.e.unlock();
        this.g.unlock();
    }

    public final void c() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            this.f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        a();
        try {
            a<E> aVar = this.c;
            while (true) {
                a<T> aVar2 = aVar.c;
                if (aVar2 == null) {
                    break;
                }
                aVar.c = aVar;
                aVar2.a(null);
                aVar = aVar2;
            }
            this.c = this.d;
            if (this.b.getAndSet(0) == this.a) {
                this.h.signal();
            }
        } finally {
            b();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        a();
        try {
            a aVar = this.c;
            do {
                aVar = aVar.c;
                if (aVar == null) {
                    b();
                    return false;
                }
            } while (!obj.equals(aVar.b()));
            b();
            return true;
        } catch (Throwable th2) {
            b();
            throw th2;
        }
    }

    public final void d() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i2) {
        a<E> aVar;
        int i3;
        collection.getClass();
        if (collection != this) {
            boolean z = false;
            if (i2 <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                int min = Math.min(i2, this.b.get());
                aVar = this.c;
                i3 = 0;
                while (i3 < min) {
                    a<T> aVar2 = aVar.c;
                    collection.add(aVar2.b());
                    aVar2.a(null);
                    aVar.c = aVar;
                    i3++;
                    aVar = aVar2;
                }
                if (i3 > 0) {
                    this.c = aVar;
                    if (this.b.getAndAdd(-i3) == this.a) {
                        z = true;
                    }
                }
                reentrantLock.unlock();
                if (z) {
                    d();
                }
                return min;
            } catch (Throwable th2) {
                reentrantLock.unlock();
                if (0 != 0) {
                    d();
                }
                throw th2;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterator<E> iterator() {
        return new a();
    }

    public boolean offer(E e2) {
        e2.getClass();
        AtomicInteger atomicInteger = this.b;
        if (atomicInteger.get() == this.a) {
            return false;
        }
        int i2 = -1;
        a aVar = new a(e2);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.a) {
                a(aVar);
                i2 = atomicInteger.getAndIncrement();
                if (i2 + 1 < this.a) {
                    this.h.signal();
                }
            }
            if (i2 == 0) {
                c();
            }
            return i2 >= 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean offer(E e2, long j, TimeUnit timeUnit) {
        e2.getClass();
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.b;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.a) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.h.awaitNanos(nanos);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        a(new a(e2));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.a) {
            this.h.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        c();
        return true;
    }

    public E peek() {
        if (this.b.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            a aVar = this.c.c;
            if (aVar == null) {
                return null;
            }
            E b2 = aVar.b();
            reentrantLock.unlock();
            return b2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public E poll() {
        AtomicInteger atomicInteger = this.b;
        E e2 = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i2 = -1;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e2 = a((a) null);
                i2 = atomicInteger.getAndDecrement();
                if (i2 > 1) {
                    this.f.signal();
                }
            }
            reentrantLock.unlock();
            if (i2 == this.a) {
                d();
            }
            return e2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public E poll(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.b;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E a2 = a((a) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.a) {
            d();
        }
        return a2;
    }

    public void put(E e2) {
        e2.getClass();
        a aVar = new a(e2);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.b;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.a) {
            try {
                this.h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.a) {
            this.h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    public int remainingCapacity() {
        return this.a - this.b.get();
    }

    /* JADX INFO: finally extract failed */
    public boolean remove(Object obj) {
        a<E> aVar;
        if (obj == null) {
            return false;
        }
        a();
        try {
            a<E> aVar2 = this.c;
            do {
                aVar = aVar2;
                aVar2 = aVar2.c;
                if (aVar2 == null) {
                    b();
                    return false;
                }
            } while (!obj.equals(aVar2.b()));
            a(aVar2, aVar);
            b();
            return true;
        } catch (Throwable th2) {
            b();
            throw th2;
        }
    }

    public int size() {
        return this.b.get();
    }

    /* JADX INFO: finally extract failed */
    public E take() {
        AtomicInteger atomicInteger = this.b;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f.await();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        E a2 = a((a) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.a) {
            d();
        }
        return a2;
    }

    public Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.b.get()];
            int i2 = 0;
            a aVar = this.c;
            while (true) {
                aVar = aVar.c;
                if (aVar == null) {
                    return objArr;
                }
                int i3 = i2 + 1;
                objArr[i2] = aVar.b();
                i2 = i3;
            }
        } finally {
            b();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        a();
        try {
            int i2 = this.b.get();
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            int i3 = 0;
            a aVar = this.c;
            while (true) {
                aVar = aVar.c;
                if (aVar == null) {
                    break;
                }
                tArr[i3] = aVar.b();
                i3++;
            }
            if (tArr.length > i3) {
                tArr[i3] = null;
            }
            return tArr;
        } finally {
            b();
        }
    }
}
