package p041if.pf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import p041if.fe.qw;
import rx.Subscription;

/* renamed from: if.pf.ad  reason: invalid package */
public final class ad implements Subscription {

    /* renamed from: ad  reason: collision with root package name */
    public Set<Subscription> f11136ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f11137th;

    public static void de(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            qw.fe(arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(rx.Subscription r2) {
        /*
            r1 = this;
            boolean r0 = r1.f11137th
            if (r0 != 0) goto L_0x0020
            monitor-enter(r1)
            boolean r0 = r1.f11137th     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x001b
            java.util.Set<rx.Subscription> r0 = r1.f11136ad     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000e
            goto L_0x001b
        L_0x000e:
            java.util.Set<rx.Subscription> r0 = r1.f11136ad     // Catch:{ all -> 0x001d }
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            r2.unsubscribe()
            goto L_0x0020
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r2
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p041if.pf.ad.ad(rx.Subscription):void");
    }

    public boolean isUnsubscribed() {
        return this.f11137th;
    }

    public void qw(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.f11137th) {
                synchronized (this) {
                    if (!this.f11137th) {
                        if (this.f11136ad == null) {
                            this.f11136ad = new HashSet(4);
                        }
                        this.f11136ad.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void unsubscribe() {
        if (!this.f11137th) {
            synchronized (this) {
                if (!this.f11137th) {
                    this.f11137th = true;
                    Set<Subscription> set = this.f11136ad;
                    this.f11136ad = null;
                    de(set);
                }
            }
        }
    }
}
