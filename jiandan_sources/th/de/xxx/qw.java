package th.de.xxx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class qw<T> extends ad<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final ad<T> f11045ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f11046th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile boolean f11047uk;

    /* renamed from: yj  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f11048yj;

    public qw(ad<T> adVar) {
        this.f11045ad = adVar;
    }

    public void fe() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f11048yj;
                if (appendOnlyLinkedArrayList == null) {
                    this.f11046th = false;
                    return;
                }
                this.f11048yj = null;
            }
            appendOnlyLinkedArrayList.de(this);
        }
        while (true) {
        }
    }

    public void onComplete() {
        if (!this.f11047uk) {
            synchronized (this) {
                if (!this.f11047uk) {
                    this.f11047uk = true;
                    if (this.f11046th) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f11048yj;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f11048yj = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.ad(NotificationLite.complete());
                        return;
                    }
                    this.f11046th = true;
                    this.f11045ad.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        th.de.ppp.qw.ddd(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f11045ad.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f11047uk
            if (r0 == 0) goto L_0x0008
            th.de.ppp.qw.ddd(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f11047uk     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f11047uk = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f11046th     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f11048yj     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f11048yj = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003b }
            r0.fe(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f11046th = r1     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            th.de.ppp.qw.ddd(r3)
            return
        L_0x0035:
            th.de.xxx.ad<T> r0 = r2.f11045ad
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.xxx.qw.onError(java.lang.Throwable):void");
    }

    public void onNext(T t) {
        if (!this.f11047uk) {
            synchronized (this) {
                if (!this.f11047uk) {
                    if (this.f11046th) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f11048yj;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f11048yj = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.ad(NotificationLite.next(t));
                        return;
                    }
                    this.f11046th = true;
                    this.f11045ad.onNext(t);
                    fe();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.f11047uk) {
            synchronized (this) {
                if (!this.f11047uk) {
                    if (this.f11046th) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f11048yj;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f11048yj = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.ad(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.f11046th = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
            return;
        }
        this.f11045ad.onSubscribe(disposable);
        fe();
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f11045ad.subscribe(observer);
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f11045ad);
    }
}
