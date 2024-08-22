package p041if.rg.fe;

import java.io.PrintStream;
import java.util.Queue;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.i;
import p041if.rg.fe.i.vvv;
import p041if.rg.fe.uk.de;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* renamed from: if.rg.fe.th  reason: invalid package */
public class th implements Subscription {

    /* renamed from: yj  reason: collision with root package name */
    public static final int f11231yj;

    /* renamed from: ad  reason: collision with root package name */
    public Queue<Object> f11232ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile Object f11233th;

    static {
        int i2 = rg.de() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        f11231yj = i2;
    }

    public th(Queue<Object> queue, int i2) {
        this.f11232ad = queue;
    }

    public static th qw() {
        if (e.ad()) {
            return new th(true, f11231yj);
        }
        return new th();
    }

    public Object ad(Object obj) {
        return NotificationLite.rg(obj);
    }

    public boolean de(Object obj) {
        return NotificationLite.th(obj);
    }

    public void fe() {
        if (this.f11233th == null) {
            this.f11233th = NotificationLite.ad();
        }
    }

    public boolean isUnsubscribed() {
        return this.f11232ad == null;
    }

    public void rg(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f11232ad;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(NotificationLite.uk(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (z2) {
            throw new MissingBackpressureException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object th() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Queue<java.lang.Object> r0 = r3.f11232ad     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0008
            r0 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x001b }
            return r0
        L_0x0008:
            java.lang.Object r1 = r0.peek()     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r3.f11233th     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0019
            if (r2 == 0) goto L_0x0019
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1 = r2
        L_0x0019:
            monitor-exit(r3)     // Catch:{ all -> 0x001b }
            return r1
        L_0x001b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041if.rg.fe.th.th():java.lang.Object");
    }

    public synchronized void uk() {
    }

    public void unsubscribe() {
        uk();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object yj() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Queue<java.lang.Object> r0 = r4.f11232ad     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r4)     // Catch:{ all -> 0x001d }
            return r1
        L_0x0008:
            java.lang.Object r2 = r0.poll()     // Catch:{ all -> 0x001d }
            java.lang.Object r3 = r4.f11233th     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x001b
            if (r3 == 0) goto L_0x001b
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x001b
            r4.f11233th = r1     // Catch:{ all -> 0x001d }
            r2 = r3
        L_0x001b:
            monitor-exit(r4)     // Catch:{ all -> 0x001d }
            return r2
        L_0x001d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041if.rg.fe.th.yj():java.lang.Object");
    }

    public th(boolean z, int i2) {
        this.f11232ad = z ? new i<>(i2) : new vvv<>(i2);
    }

    public th() {
        this((Queue<Object>) new de(f11231yj), f11231yj);
    }
}
