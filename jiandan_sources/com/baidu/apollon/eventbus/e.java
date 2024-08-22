package com.baidu.apollon.eventbus;

import java.util.LinkedList;

public final class e {
    public final LinkedList<d> a = new LinkedList<>();

    public synchronized void a(d dVar) {
        if (dVar != null) {
            this.a.offer(dVar);
            notifyAll();
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized d a() {
        return this.a.poll();
    }

    public synchronized d a(int i2) throws InterruptedException {
        d a2;
        a2 = a();
        if (a2 == null) {
            wait((long) i2);
            a2 = a();
        }
        return a2;
    }
}
