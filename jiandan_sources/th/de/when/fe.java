package th.de.when;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class fe<T> implements Observer<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super T> f11038ad;

    /* renamed from: i  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f11039i;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f11040o;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f11041th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f11042uk;

    /* renamed from: yj  reason: collision with root package name */
    public Disposable f11043yj;

    public fe(Observer<? super T> observer) {
        this(observer, false);
    }

    public void dispose() {
        this.f11043yj.dispose();
    }

    public boolean isDisposed() {
        return this.f11043yj.isDisposed();
    }

    public void onComplete() {
        if (!this.f11040o) {
            synchronized (this) {
                if (!this.f11040o) {
                    if (this.f11042uk) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f11039i;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f11039i = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.ad(NotificationLite.complete());
                        return;
                    }
                    this.f11040o = true;
                    this.f11042uk = true;
                    this.f11038ad.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        th.de.ppp.qw.ddd(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f11038ad.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f11040o
            if (r0 == 0) goto L_0x0008
            th.de.ppp.qw.ddd(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f11040o     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f11042uk     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f11040o = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f11039i     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f11039i = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f11041th     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.ad(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.fe(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f11040o = r1     // Catch:{ all -> 0x0044 }
            r2.f11042uk = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            th.de.ppp.qw.ddd(r3)
            return
        L_0x003e:
            io.reactivex.Observer<? super T> r0 = r2.f11038ad
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.when.fe.onError(java.lang.Throwable):void");
    }

    public void onNext(T t) {
        if (!this.f11040o) {
            if (t == null) {
                this.f11043yj.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f11040o) {
                    if (this.f11042uk) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f11039i;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f11039i = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.ad(NotificationLite.next(t));
                        return;
                    }
                    this.f11042uk = true;
                    this.f11038ad.onNext(t);
                    qw();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f11043yj, disposable)) {
            this.f11043yj = disposable;
            this.f11038ad.onSubscribe(this);
        }
    }

    public void qw() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f11039i;
                if (appendOnlyLinkedArrayList == null) {
                    this.f11042uk = false;
                    return;
                }
                this.f11039i = null;
            }
        } while (!appendOnlyLinkedArrayList.qw(this.f11038ad));
    }

    public fe(Observer<? super T> observer, boolean z) {
        this.f11038ad = observer;
        this.f11041th = z;
    }
}
