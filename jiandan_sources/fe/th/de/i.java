package fe.th.de;

import fe.th.de.rrr.fe;
import fe.th.de.xxx;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class i {

    /* renamed from: ad  reason: collision with root package name */
    public int f5175ad = 5;

    /* renamed from: de  reason: collision with root package name */
    public Runnable f5176de;

    /* renamed from: fe  reason: collision with root package name */
    public ExecutorService f5177fe;
    public int qw = 64;

    /* renamed from: rg  reason: collision with root package name */
    public final Deque<xxx.ad> f5178rg = new ArrayDeque();

    /* renamed from: th  reason: collision with root package name */
    public final Deque<xxx.ad> f5179th = new ArrayDeque();

    /* renamed from: yj  reason: collision with root package name */
    public final Deque<xxx> f5180yj = new ArrayDeque();

    public i(ExecutorService executorService) {
        this.f5177fe = executorService;
    }

    public synchronized void ad(xxx xxx) {
        this.f5180yj.add(xxx);
    }

    public synchronized ExecutorService de() {
        if (this.f5177fe == null) {
            this.f5177fe = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), fe.g("OkHttp Dispatcher", false));
        }
        return this.f5177fe;
    }

    public void fe(xxx.ad adVar) {
        th(this.f5179th, adVar);
    }

    public final int i(xxx.ad adVar) {
        int i2 = 0;
        for (xxx.ad next : this.f5179th) {
            if (!next.th().f5564o && next.yj().equals(adVar.yj())) {
                i2++;
            }
        }
        return i2;
    }

    public void qw(xxx.ad adVar) {
        synchronized (this) {
            this.f5178rg.add(adVar);
        }
        yj();
    }

    public void rg(xxx xxx) {
        th(this.f5180yj, xxx);
    }

    public final <T> void th(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f5176de;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!yj() && runnable != null) {
            runnable.run();
        }
    }

    public synchronized int uk() {
        return this.f5179th.size() + this.f5180yj.size();
    }

    public final boolean yj() {
        int i2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<xxx.ad> it = this.f5178rg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xxx.ad next = it.next();
                if (this.f5179th.size() >= this.qw) {
                    break;
                } else if (i(next) < this.f5175ad) {
                    it.remove();
                    arrayList.add(next);
                    this.f5179th.add(next);
                }
            }
            z = uk() > 0;
        }
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((xxx.ad) arrayList.get(i2)).rg(de());
        }
        return z;
    }

    public i() {
    }
}
