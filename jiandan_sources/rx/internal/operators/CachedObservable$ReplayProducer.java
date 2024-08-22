package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.ad;
import rx.Producer;
import rx.Subscription;

public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
    public static final long serialVersionUID = -2557562030197141021L;
    public final de<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final ad<T> state;

    public CachedObservable$ReplayProducer(de<? super T> deVar, ad<T> adVar) {
        this.child = deVar;
        this.state = adVar;
    }

    public boolean isUnsubscribed() {
        return get() < 0;
    }

    public long produced(long j) {
        return addAndGet(-j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x00e3, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = r15.child;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
        r3 = get();
        r7 = (r3 > 0 ? 1 : (r3 == 0 ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        if (r7 >= 0) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        r8 = r15.state.ad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        if (r8 == 0) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        r9 = r15.currentBuffer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        if (r9 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        r9 = r15.state.qw();
        r15.currentBuffer = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r10 = r9.length - 1;
        r11 = r15.index;
        r12 = r15.currentIndexInBuffer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r7 != 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r3 = r9[r12];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        if (rx.internal.operators.NotificationLite.th(r3) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        r2.onCompleted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r1 = r2;
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
        if (rx.internal.operators.NotificationLite.yj(r3) == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        r2.onError(rx.internal.operators.NotificationLite.fe(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
        if (r7 <= 0) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005e, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005f, code lost:
        if (r11 >= r8) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        if (r3 <= 0) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0069, code lost:
        if (r2.isUnsubscribed() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006c, code lost:
        if (r12 != r10) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x006e, code lost:
        r9 = (java.lang.Object[]) r9[r10];
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0073, code lost:
        r13 = r9[r12];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0079, code lost:
        if (rx.internal.operators.NotificationLite.qw(r2, r13) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007f, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0082, code lost:
        r12 = r12 + 1;
        r11 = r11 + 1;
        r3 = r3 - 1;
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x008c, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x008d, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        p041if.fe.qw.rg(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0098, code lost:
        if (rx.internal.operators.NotificationLite.yj(r13) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a0, code lost:
        r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.rg(r13)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ac, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b2, code lost:
        if (r2.isUnsubscribed() == false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b5, code lost:
        r15.index = r11;
        r15.currentIndexInBuffer = r12;
        r15.currentBuffer = r9;
        produced((long) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00bf, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00c2, code lost:
        if (r15.missed != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c4, code lost:
        r15.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00c7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r15.missed = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00ca, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00cd, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00ce, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00d1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d2, code lost:
        r4 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00d5, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x00d7, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00d8, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x00d9, code lost:
        if (r4 == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x00db, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r15.emitting = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a0 A[Catch:{ all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replay() {
        /*
            r15 = this;
            monitor-enter(r15)
            boolean r0 = r15.emitting     // Catch:{ all -> 0x00e4 }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            r15.missed = r1     // Catch:{ all -> 0x00e4 }
            monitor-exit(r15)     // Catch:{ all -> 0x00e4 }
            return
        L_0x000a:
            r15.emitting = r1     // Catch:{ all -> 0x00e4 }
            monitor-exit(r15)     // Catch:{ all -> 0x00e4 }
            r0 = 0
            if.de<? super T> r2 = r15.child     // Catch:{ all -> 0x00d7 }
        L_0x0010:
            long r3 = r15.get()     // Catch:{ all -> 0x00d7 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x001b
            return
        L_0x001b:
            if.rg.qw.ad<T> r8 = r15.state     // Catch:{ all -> 0x00d7 }
            int r8 = r8.ad()     // Catch:{ all -> 0x00d7 }
            if (r8 == 0) goto L_0x00bf
            java.lang.Object[] r9 = r15.currentBuffer     // Catch:{ all -> 0x00d7 }
            if (r9 != 0) goto L_0x002f
            if.rg.qw.ad<T> r9 = r15.state     // Catch:{ all -> 0x00d7 }
            java.lang.Object[] r9 = r9.qw()     // Catch:{ all -> 0x00d7 }
            r15.currentBuffer = r9     // Catch:{ all -> 0x00d7 }
        L_0x002f:
            int r10 = r9.length     // Catch:{ all -> 0x00d7 }
            int r10 = r10 - r1
            int r11 = r15.index     // Catch:{ all -> 0x00d7 }
            int r12 = r15.currentIndexInBuffer     // Catch:{ all -> 0x00d7 }
            if (r7 != 0) goto L_0x005c
            r3 = r9[r12]     // Catch:{ all -> 0x00d7 }
            boolean r4 = rx.internal.operators.NotificationLite.th(r3)     // Catch:{ all -> 0x00d7 }
            if (r4 == 0) goto L_0x004b
            r2.onCompleted()     // Catch:{ all -> 0x00d7 }
            r15.unsubscribe()     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r2 = move-exception
            r1 = r2
            r4 = 1
            goto L_0x00d9
        L_0x004b:
            boolean r4 = rx.internal.operators.NotificationLite.yj(r3)     // Catch:{ all -> 0x00d7 }
            if (r4 == 0) goto L_0x00bf
            java.lang.Throwable r3 = rx.internal.operators.NotificationLite.fe(r3)     // Catch:{ all -> 0x00d7 }
            r2.onError(r3)     // Catch:{ all -> 0x00d7 }
            r15.unsubscribe()     // Catch:{ all -> 0x0046 }
            return
        L_0x005c:
            if (r7 <= 0) goto L_0x00bf
            r7 = 0
        L_0x005f:
            if (r11 >= r8) goto L_0x00ae
            int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ae
            boolean r13 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d7 }
            if (r13 == 0) goto L_0x006c
            return
        L_0x006c:
            if (r12 != r10) goto L_0x0073
            r9 = r9[r10]     // Catch:{ all -> 0x00d7 }
            java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d7 }
            r12 = 0
        L_0x0073:
            r13 = r9[r12]     // Catch:{ all -> 0x00d7 }
            boolean r14 = rx.internal.operators.NotificationLite.qw(r2, r13)     // Catch:{ all -> 0x008c }
            if (r14 == 0) goto L_0x0082
            r15.unsubscribe()     // Catch:{ all -> 0x007f }
            return
        L_0x007f:
            r3 = move-exception
            r4 = 1
            goto L_0x008e
        L_0x0082:
            int r12 = r12 + 1
            int r11 = r11 + 1
            r13 = 1
            long r3 = r3 - r13
            int r7 = r7 + 1
            goto L_0x005f
        L_0x008c:
            r3 = move-exception
            r4 = 0
        L_0x008e:
            p041if.fe.qw.rg(r3)     // Catch:{ all -> 0x00ac }
            r15.unsubscribe()     // Catch:{ all -> 0x0046 }
            boolean r4 = rx.internal.operators.NotificationLite.yj(r13)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ab
            boolean r4 = rx.internal.operators.NotificationLite.th(r13)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ab
            java.lang.Object r4 = rx.internal.operators.NotificationLite.rg(r13)     // Catch:{ all -> 0x0046 }
            java.lang.Throwable r3 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, r4)     // Catch:{ all -> 0x0046 }
            r2.onError(r3)     // Catch:{ all -> 0x0046 }
        L_0x00ab:
            return
        L_0x00ac:
            r1 = move-exception
            goto L_0x00d9
        L_0x00ae:
            boolean r3 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d7 }
            if (r3 == 0) goto L_0x00b5
            return
        L_0x00b5:
            r15.index = r11     // Catch:{ all -> 0x00d7 }
            r15.currentIndexInBuffer = r12     // Catch:{ all -> 0x00d7 }
            r15.currentBuffer = r9     // Catch:{ all -> 0x00d7 }
            long r3 = (long) r7     // Catch:{ all -> 0x00d7 }
            r15.produced(r3)     // Catch:{ all -> 0x00d7 }
        L_0x00bf:
            monitor-enter(r15)     // Catch:{ all -> 0x00d7 }
            boolean r3 = r15.missed     // Catch:{ all -> 0x00cd }
            if (r3 != 0) goto L_0x00c8
            r15.emitting = r0     // Catch:{ all -> 0x00cd }
            monitor-exit(r15)     // Catch:{ all -> 0x00d5 }
            return
        L_0x00c8:
            r15.missed = r0     // Catch:{ all -> 0x00cd }
            monitor-exit(r15)     // Catch:{ all -> 0x00cd }
            goto L_0x0010
        L_0x00cd:
            r2 = move-exception
            r1 = 0
        L_0x00cf:
            monitor-exit(r15)     // Catch:{ all -> 0x00d5 }
            throw r2     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r2 = move-exception
            r4 = r1
            r1 = r2
            goto L_0x00d9
        L_0x00d5:
            r2 = move-exception
            goto L_0x00cf
        L_0x00d7:
            r1 = move-exception
            r4 = 0
        L_0x00d9:
            if (r4 != 0) goto L_0x00e3
            monitor-enter(r15)
            r15.emitting = r0     // Catch:{ all -> 0x00e0 }
            monitor-exit(r15)     // Catch:{ all -> 0x00e0 }
            goto L_0x00e3
        L_0x00e0:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00e0 }
            throw r0
        L_0x00e3:
            throw r1
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00e4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable$ReplayProducer.replay():void");
    }

    public void request(long j) {
        long j2;
        long j3;
        do {
            j2 = get();
            if (j2 >= 0) {
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } else {
                return;
            }
        } while (!compareAndSet(j2, j3));
        replay();
    }

    public void unsubscribe() {
        if (get() >= 0 && getAndSet(-1) >= 0) {
            this.state.rg(this);
        }
    }
}
