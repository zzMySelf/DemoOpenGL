package p041if.yj;

import rx.Observer;
import rx.internal.operators.NotificationLite;

/* renamed from: if.yj.de  reason: invalid package */
public class de<T> implements Observer<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super T> f11362ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f11363th;

    /* renamed from: uk  reason: collision with root package name */
    public qw f11364uk;

    /* renamed from: yj  reason: collision with root package name */
    public volatile boolean f11365yj;

    /* renamed from: if.yj.de$qw */
    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f11366ad;
        public Object[] qw;

        public void qw(Object obj) {
            int i2 = this.f11366ad;
            Object[] objArr = this.qw;
            if (objArr == null) {
                objArr = new Object[16];
                this.qw = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[((i2 >> 2) + i2)];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.qw = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f11366ad = i2 + 1;
        }
    }

    public de(Observer<? super T> observer) {
        this.f11362ad = observer;
    }

    public void onCompleted() {
        if (!this.f11365yj) {
            synchronized (this) {
                if (!this.f11365yj) {
                    this.f11365yj = true;
                    if (this.f11363th) {
                        qw qwVar = this.f11364uk;
                        if (qwVar == null) {
                            qwVar = new qw();
                            this.f11364uk = qwVar;
                        }
                        qwVar.qw(NotificationLite.ad());
                        return;
                    }
                    this.f11363th = true;
                    this.f11362ad.onCompleted();
                }
            }
        }
    }

    public void onError(Throwable th2) {
        p041if.fe.qw.rg(th2);
        if (!this.f11365yj) {
            synchronized (this) {
                if (!this.f11365yj) {
                    this.f11365yj = true;
                    if (this.f11363th) {
                        qw qwVar = this.f11364uk;
                        if (qwVar == null) {
                            qwVar = new qw();
                            this.f11364uk = qwVar;
                        }
                        qwVar.qw(NotificationLite.de(th2));
                        return;
                    }
                    this.f11363th = true;
                    this.f11362ad.onError(th2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6.f11362ad.onNext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1 = r6.f11364uk;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0031, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
        r6.f11363th = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0037, code lost:
        r6.f11364uk = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003b, code lost:
        r1 = r1.qw;
        r3 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003e, code lost:
        if (r2 >= r3) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0040, code lost:
        r4 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0042, code lost:
        if (r4 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004b, code lost:
        if (rx.internal.operators.NotificationLite.qw(r6.f11362ad, r4) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x004d, code lost:
        r6.f11365yj = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0050, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0053, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0054, code lost:
        r6.f11365yj = true;
        p041if.fe.qw.rg(r1);
        r6.f11362ad.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0062, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0066, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0067, code lost:
        r6.f11365yj = true;
        p041if.fe.qw.yj(r1, r6.f11362ad, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.f11365yj
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r6)
            boolean r0 = r6.f11365yj     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x006f }
            return
        L_0x000c:
            boolean r0 = r6.f11363th     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0024
            if.yj.de$qw r0 = r6.f11364uk     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x001b
            if.yj.de$qw r0 = new if.yj.de$qw     // Catch:{ all -> 0x006f }
            r0.<init>()     // Catch:{ all -> 0x006f }
            r6.f11364uk = r0     // Catch:{ all -> 0x006f }
        L_0x001b:
            java.lang.Object r7 = rx.internal.operators.NotificationLite.uk(r7)     // Catch:{ all -> 0x006f }
            r0.qw(r7)     // Catch:{ all -> 0x006f }
            monitor-exit(r6)     // Catch:{ all -> 0x006f }
            return
        L_0x0024:
            r0 = 1
            r6.f11363th = r0     // Catch:{ all -> 0x006f }
            monitor-exit(r6)     // Catch:{ all -> 0x006f }
            rx.Observer<? super T> r1 = r6.f11362ad     // Catch:{ all -> 0x0066 }
            r1.onNext(r7)     // Catch:{ all -> 0x0066 }
        L_0x002d:
            monitor-enter(r6)
            if.yj.de$qw r1 = r6.f11364uk     // Catch:{ all -> 0x0063 }
            r2 = 0
            if (r1 != 0) goto L_0x0037
            r6.f11363th = r2     // Catch:{ all -> 0x0063 }
            monitor-exit(r6)     // Catch:{ all -> 0x0063 }
            return
        L_0x0037:
            r3 = 0
            r6.f11364uk = r3     // Catch:{ all -> 0x0063 }
            monitor-exit(r6)     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r1 = r1.qw
            int r3 = r1.length
        L_0x003e:
            if (r2 >= r3) goto L_0x002d
            r4 = r1[r2]
            if (r4 != 0) goto L_0x0045
            goto L_0x002d
        L_0x0045:
            rx.Observer<? super T> r5 = r6.f11362ad     // Catch:{ all -> 0x0053 }
            boolean r4 = rx.internal.operators.NotificationLite.qw(r5, r4)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0050
            r6.f11365yj = r0     // Catch:{ all -> 0x0053 }
            return
        L_0x0050:
            int r2 = r2 + 1
            goto L_0x003e
        L_0x0053:
            r1 = move-exception
            r6.f11365yj = r0
            p041if.fe.qw.rg(r1)
            rx.Observer<? super T> r0 = r6.f11362ad
            java.lang.Throwable r7 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7)
            r0.onError(r7)
            return
        L_0x0063:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0063 }
            throw r7
        L_0x0066:
            r1 = move-exception
            r6.f11365yj = r0
            rx.Observer<? super T> r0 = r6.f11362ad
            p041if.fe.qw.yj(r1, r0, r7)
            return
        L_0x006f:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p041if.yj.de.onNext(java.lang.Object):void");
    }
}
