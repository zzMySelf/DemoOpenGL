package fe.uk.qw.pf.fe.aaa;

import fe.uk.qw.vvv.i;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final C0231ad f5719ad = new C0231ad();
    public final Map<String, qw> qw = new HashMap();

    /* renamed from: fe.uk.qw.pf.fe.aaa.ad$ad  reason: collision with other inner class name */
    public static class C0231ad {
        public final Queue<qw> qw = new ArrayDeque();

        public void ad(qw qwVar) {
            synchronized (this.qw) {
                if (this.qw.size() < 10) {
                    this.qw.offer(qwVar);
                }
            }
        }

        public qw qw() {
            qw poll;
            synchronized (this.qw) {
                poll = this.qw.poll();
            }
            return poll == null ? new qw() : poll;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f5720ad;
        public final Lock qw = new ReentrantLock();
    }

    public void ad(String str) {
        qw qwVar;
        synchronized (this) {
            qw qwVar2 = this.qw.get(str);
            i.fe(qwVar2);
            qwVar = qwVar2;
            if (qwVar.f5720ad >= 1) {
                int i2 = qwVar.f5720ad - 1;
                qwVar.f5720ad = i2;
                if (i2 == 0) {
                    qw remove = this.qw.remove(str);
                    if (remove.equals(qwVar)) {
                        this.f5719ad.ad(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + qwVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + qwVar.f5720ad);
            }
        }
        qwVar.qw.unlock();
    }

    public void qw(String str) {
        qw qwVar;
        synchronized (this) {
            qwVar = this.qw.get(str);
            if (qwVar == null) {
                qwVar = this.f5719ad.qw();
                this.qw.put(str, qwVar);
            }
            qwVar.f5720ad++;
        }
        qwVar.qw.lock();
    }
}
