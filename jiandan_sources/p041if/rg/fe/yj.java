package p041if.rg.fe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import p041if.fe.qw;
import rx.Subscription;

/* renamed from: if.rg.fe.yj  reason: invalid package */
public final class yj implements Subscription {

    /* renamed from: ad  reason: collision with root package name */
    public List<Subscription> f11257ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f11258th;

    public yj() {
    }

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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r3.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(rx.Subscription r3) {
        /*
            r2 = this;
            boolean r0 = r2.f11258th
            if (r0 != 0) goto L_0x001e
            monitor-enter(r2)
            java.util.List<rx.Subscription> r0 = r2.f11257ad     // Catch:{ all -> 0x001b }
            boolean r1 = r2.f11258th     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0019
            if (r0 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r0 = r0.remove(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            r3.unsubscribe()
            goto L_0x001e
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p041if.rg.fe.yj.ad(rx.Subscription):void");
    }

    public boolean isUnsubscribed() {
        return this.f11258th;
    }

    public void qw(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.f11258th) {
                synchronized (this) {
                    if (!this.f11258th) {
                        List list = this.f11257ad;
                        if (list == null) {
                            list = new LinkedList();
                            this.f11257ad = list;
                        }
                        list.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void unsubscribe() {
        if (!this.f11258th) {
            synchronized (this) {
                if (!this.f11258th) {
                    this.f11258th = true;
                    List<Subscription> list = this.f11257ad;
                    this.f11257ad = null;
                    de(list);
                }
            }
        }
    }

    public yj(Subscription... subscriptionArr) {
        this.f11257ad = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public yj(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.f11257ad = linkedList;
        linkedList.add(subscription);
    }
}
