package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.fe.qw;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.eee;
import p041if.rg.fe.i.rrr;
import p041if.rg.fe.uk.rg;
import p041if.rg.fe.uk.th;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.NotificationLite;

public final class UnicastSubject$State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
    public static final long serialVersionUID = -9044104859202255786L;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<de<? super T>> subscriber = new AtomicReference<>();
    public final AtomicReference<Action0> terminateOnce;

    public UnicastSubject$State(int i2, Action0 action0) {
        Queue<Object> queue2;
        this.terminateOnce = action0 != null ? new AtomicReference<>(action0) : null;
        if (i2 > 1) {
            queue2 = e.ad() ? new rrr<>(i2) : new th<>(i2);
        } else {
            queue2 = e.ad() ? new eee<>() : new rg<>();
        }
        this.queue = queue2;
    }

    public boolean checkTerminated(boolean z, boolean z2, de<? super T> deVar) {
        if (deVar.isUnsubscribed()) {
            this.queue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                deVar.onError(th2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                deVar.onCompleted();
                return true;
            }
        }
    }

    public void doTerminate() {
        Action0 action0;
        AtomicReference<Action0> atomicReference = this.terminateOnce;
        if (atomicReference != null && (action0 = atomicReference.get()) != null && atomicReference.compareAndSet(action0, (Object) null)) {
            action0.call();
        }
    }

    public boolean isUnsubscribed() {
        return this.done;
    }

    public void onCompleted() {
        if (!this.done) {
            doTerminate();
            boolean z = true;
            this.done = true;
            if (!this.caughtUp) {
                synchronized (this) {
                    if (this.caughtUp) {
                        z = false;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            this.subscriber.get().onCompleted();
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            doTerminate();
            this.error = th2;
            boolean z = true;
            this.done = true;
            if (!this.caughtUp) {
                synchronized (this) {
                    if (this.caughtUp) {
                        z = false;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            this.subscriber.get().onError(th2);
        }
    }

    public void onNext(T t) {
        if (!this.done) {
            if (!this.caughtUp) {
                boolean z = false;
                synchronized (this) {
                    if (!this.caughtUp) {
                        this.queue.offer(NotificationLite.uk(t));
                        z = true;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            de deVar = this.subscriber.get();
            try {
                deVar.onNext(t);
            } catch (Throwable th2) {
                qw.yj(th2, deVar, t);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r2 = r14.subscriber.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r2 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (checkTerminated(r14.done, r0.isEmpty(), r2) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r4 = get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r4 != Long.MAX_VALUE) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r4 == 0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        r11 = r14.done;
        r12 = r0.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r12 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (checkTerminated(r11, r13, r2) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        if (r13 == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r11 = rx.internal.operators.NotificationLite.rg(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r2.onNext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        r4 = r4 - 1;
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        r0.clear();
        p041if.fe.qw.rg(r1);
        r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006e, code lost:
        if (r6 != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0072, code lost:
        if (r9 == 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0074, code lost:
        addAndGet(-r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0079, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007a, code lost:
        monitor-enter(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007d, code lost:
        if (r14.missed != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007f, code lost:
        if (r6 == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (r0.isEmpty() == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0087, code lost:
        r14.caughtUp = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0089, code lost:
        r14.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x008c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
        r14.missed = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r0 = r14.queue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replay() {
        /*
            r14 = this;
            monitor-enter(r14)
            boolean r0 = r14.emitting     // Catch:{ all -> 0x0095 }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            r14.missed = r1     // Catch:{ all -> 0x0095 }
            monitor-exit(r14)     // Catch:{ all -> 0x0095 }
            return
        L_0x000a:
            r14.emitting = r1     // Catch:{ all -> 0x0095 }
            monitor-exit(r14)     // Catch:{ all -> 0x0095 }
            java.util.Queue<java.lang.Object> r0 = r14.queue
        L_0x000f:
            java.util.concurrent.atomic.AtomicReference<if.de<? super T>> r2 = r14.subscriber
            java.lang.Object r2 = r2.get()
            if.de r2 = (p041if.de) r2
            r3 = 0
            if (r2 == 0) goto L_0x0079
            boolean r4 = r14.done
            boolean r5 = r0.isEmpty()
            boolean r4 = r14.checkTerminated(r4, r5, r2)
            if (r4 == 0) goto L_0x0027
            return
        L_0x0027:
            long r4 = r14.get()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0036
            r6 = 1
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            r7 = 0
            r9 = r7
        L_0x003a:
            int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x006e
            boolean r11 = r14.done
            java.lang.Object r12 = r0.poll()
            if (r12 != 0) goto L_0x0048
            r13 = 1
            goto L_0x0049
        L_0x0048:
            r13 = 0
        L_0x0049:
            boolean r11 = r14.checkTerminated(r11, r13, r2)
            if (r11 == 0) goto L_0x0050
            return
        L_0x0050:
            if (r13 == 0) goto L_0x0053
            goto L_0x006e
        L_0x0053:
            java.lang.Object r11 = rx.internal.operators.NotificationLite.rg(r12)
            r2.onNext(r11)     // Catch:{ all -> 0x005f }
            r11 = 1
            long r4 = r4 - r11
            long r9 = r9 + r11
            goto L_0x003a
        L_0x005f:
            r1 = move-exception
            r0.clear()
            p041if.fe.qw.rg(r1)
            java.lang.Throwable r0 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r11)
            r2.onError(r0)
            return
        L_0x006e:
            if (r6 != 0) goto L_0x007a
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x007a
            long r4 = -r9
            r14.addAndGet(r4)
            goto L_0x007a
        L_0x0079:
            r6 = 0
        L_0x007a:
            monitor-enter(r14)
            boolean r2 = r14.missed     // Catch:{ all -> 0x0092 }
            if (r2 != 0) goto L_0x008d
            if (r6 == 0) goto L_0x0089
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0089
            r14.caughtUp = r1     // Catch:{ all -> 0x0092 }
        L_0x0089:
            r14.emitting = r3     // Catch:{ all -> 0x0092 }
            monitor-exit(r14)     // Catch:{ all -> 0x0092 }
            return
        L_0x008d:
            r14.missed = r3     // Catch:{ all -> 0x0092 }
            monitor-exit(r14)     // Catch:{ all -> 0x0092 }
            goto L_0x000f
        L_0x0092:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0092 }
            throw r0
        L_0x0095:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0095 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subjects.UnicastSubject$State.replay():void");
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i2 > 0) {
            p041if.rg.qw.qw.ad(this, j);
            replay();
        } else if (this.done) {
            replay();
        }
    }

    public void unsubscribe() {
        doTerminate();
        this.done = true;
        synchronized (this) {
            if (!this.emitting) {
                this.emitting = true;
                this.queue.clear();
            }
        }
    }

    public void call(de<? super T> deVar) {
        if (this.subscriber.compareAndSet((Object) null, deVar)) {
            deVar.add(this);
            deVar.setProducer(this);
            return;
        }
        deVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }
}
