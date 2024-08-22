package fe.p013if.ad.qw;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* renamed from: fe.if.ad.qw.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final PriorityQueue<fe.p013if.ad.qw.pf.ad> f4509ad = new PriorityQueue<>(120, this.f4512rg);

    /* renamed from: de  reason: collision with root package name */
    public final List<fe.p013if.ad.qw.pf.ad> f4510de = new ArrayList();

    /* renamed from: fe  reason: collision with root package name */
    public final Object f4511fe = new Object();
    public final PriorityQueue<fe.p013if.ad.qw.pf.ad> qw = new PriorityQueue<>(120, this.f4512rg);

    /* renamed from: rg  reason: collision with root package name */
    public final qw f4512rg = new qw(this);

    /* renamed from: fe.if.ad.qw.ad$qw */
    public class qw implements Comparator<fe.p013if.ad.qw.pf.ad> {
        public qw(ad adVar) {
        }

        /* renamed from: qw */
        public int compare(fe.p013if.ad.qw.pf.ad adVar, fe.p013if.ad.qw.pf.ad adVar2) {
            if (adVar.qw() == adVar2.qw()) {
                return 0;
            }
            return adVar.qw() > adVar2.qw() ? 1 : -1;
        }
    }

    public static fe.p013if.ad.qw.pf.ad rg(PriorityQueue<fe.p013if.ad.qw.pf.ad> priorityQueue, fe.p013if.ad.qw.pf.ad adVar) {
        Iterator<fe.p013if.ad.qw.pf.ad> it = priorityQueue.iterator();
        while (it.hasNext()) {
            fe.p013if.ad.qw.pf.ad next = it.next();
            if (next.equals(adVar)) {
                return next;
            }
        }
        return null;
    }

    public void ad(fe.p013if.ad.qw.pf.ad adVar) {
        synchronized (this.f4511fe) {
            uk();
            this.f4509ad.offer(adVar);
        }
    }

    public void de(fe.p013if.ad.qw.pf.ad adVar) {
        synchronized (this.f4510de) {
            while (this.f4510de.size() >= 8) {
                this.f4510de.remove(0).fe().recycle();
            }
            qw(this.f4510de, adVar);
        }
    }

    public boolean fe(int i2, RectF rectF) {
        fe.p013if.ad.qw.pf.ad adVar = new fe.p013if.ad.qw.pf.ad(i2, (Bitmap) null, rectF, true, 0);
        synchronized (this.f4510de) {
            for (fe.p013if.ad.qw.pf.ad equals : this.f4510de) {
                if (equals.equals(adVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void i() {
        synchronized (this.f4511fe) {
            this.qw.addAll(this.f4509ad);
            this.f4509ad.clear();
        }
    }

    public void o() {
        synchronized (this.f4511fe) {
            Iterator<fe.p013if.ad.qw.pf.ad> it = this.qw.iterator();
            while (it.hasNext()) {
                it.next().fe().recycle();
            }
            this.qw.clear();
            Iterator<fe.p013if.ad.qw.pf.ad> it2 = this.f4509ad.iterator();
            while (it2.hasNext()) {
                it2.next().fe().recycle();
            }
            this.f4509ad.clear();
        }
        synchronized (this.f4510de) {
            for (fe.p013if.ad.qw.pf.ad fe2 : this.f4510de) {
                fe2.fe().recycle();
            }
            this.f4510de.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean pf(int r8, android.graphics.RectF r9, int r10) {
        /*
            r7 = this;
            fe.if.ad.qw.pf.ad r6 = new fe.if.ad.qw.pf.ad
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Object r8 = r7.f4511fe
            monitor-enter(r8)
            java.util.PriorityQueue<fe.if.ad.qw.pf.ad> r9 = r7.qw     // Catch:{ all -> 0x0032 }
            fe.if.ad.qw.pf.ad r9 = rg(r9, r6)     // Catch:{ all -> 0x0032 }
            r0 = 1
            if (r9 == 0) goto L_0x0026
            java.util.PriorityQueue<fe.if.ad.qw.pf.ad> r1 = r7.qw     // Catch:{ all -> 0x0032 }
            r1.remove(r9)     // Catch:{ all -> 0x0032 }
            r9.th(r10)     // Catch:{ all -> 0x0032 }
            java.util.PriorityQueue<fe.if.ad.qw.pf.ad> r10 = r7.f4509ad     // Catch:{ all -> 0x0032 }
            r10.offer(r9)     // Catch:{ all -> 0x0032 }
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0026:
            java.util.PriorityQueue<fe.if.ad.qw.pf.ad> r9 = r7.f4509ad     // Catch:{ all -> 0x0032 }
            fe.if.ad.qw.pf.ad r9 = rg(r9, r6)     // Catch:{ all -> 0x0032 }
            if (r9 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0032:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.p013if.ad.qw.ad.pf(int, android.graphics.RectF, int):boolean");
    }

    public final void qw(Collection<fe.p013if.ad.qw.pf.ad> collection, fe.p013if.ad.qw.pf.ad adVar) {
        for (fe.p013if.ad.qw.pf.ad equals : collection) {
            if (equals.equals(adVar)) {
                adVar.fe().recycle();
                return;
            }
        }
        collection.add(adVar);
    }

    public List<fe.p013if.ad.qw.pf.ad> th() {
        ArrayList arrayList;
        synchronized (this.f4511fe) {
            arrayList = new ArrayList(this.qw);
            arrayList.addAll(this.f4509ad);
        }
        return arrayList;
    }

    public final void uk() {
        synchronized (this.f4511fe) {
            while (this.f4509ad.size() + this.qw.size() >= 120 && !this.qw.isEmpty()) {
                this.qw.poll().fe().recycle();
            }
            while (this.f4509ad.size() + this.qw.size() >= 120 && !this.f4509ad.isEmpty()) {
                this.f4509ad.poll().fe().recycle();
            }
        }
    }

    public List<fe.p013if.ad.qw.pf.ad> yj() {
        List<fe.p013if.ad.qw.pf.ad> list;
        synchronized (this.f4510de) {
            list = this.f4510de;
        }
        return list;
    }
}
