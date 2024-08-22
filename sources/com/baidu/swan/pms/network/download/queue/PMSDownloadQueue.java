package com.baidu.swan.pms.network.download.queue;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PMSDownloadQueue<T> {
    protected final List<T> mQueue = new ArrayList();

    public synchronized void enQueue(T t) {
        this.mQueue.add(t);
        notifyAll();
    }

    public synchronized T deQueue() {
        if (this.mQueue.isEmpty()) {
            return null;
        }
        T obj = this.mQueue.get(0);
        this.mQueue.remove(0);
        return obj;
    }

    public synchronized T get() {
        if (this.mQueue.isEmpty()) {
            return null;
        }
        return this.mQueue.get(0);
    }

    public int size() {
        return this.mQueue.size();
    }

    public synchronized boolean remove(Object obj) {
        return this.mQueue.remove(obj);
    }

    public synchronized void clear() {
        this.mQueue.clear();
        notifyAll();
    }

    public boolean contains(T obj) {
        if (obj == null) {
            return false;
        }
        for (int i2 = this.mQueue.size() - 1; i2 >= 0; i2--) {
            if (obj.equals(this.mQueue.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public T getExists(T obj) {
        if (obj == null) {
            return null;
        }
        for (int i2 = this.mQueue.size() - 1; i2 >= 0; i2--) {
            if (obj.equals(this.mQueue.get(i2))) {
                return this.mQueue.get(i2);
            }
        }
        return null;
    }

    public Iterator<T> getIterator() {
        return this.mQueue.iterator();
    }

    public String toString() {
        StringBuilder b2 = new StringBuilder();
        b2.append(",Queue Size:" + this.mQueue.size());
        int i2 = 0;
        synchronized (this) {
            try {
                for (T t : this.mQueue) {
                    int i3 = i2 + 1;
                    try {
                        b2.append(":[" + i2 + RhetoricalTagUtilKt.TAG_END_SYMBOL + t);
                        i2 = i3;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                return b2.toString();
            } catch (Throwable th3) {
                int i4 = i2;
                th = th3;
                throw th;
            }
        }
    }
}
