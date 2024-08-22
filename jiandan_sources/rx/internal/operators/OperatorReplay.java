package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func0;

public final class OperatorReplay<T> extends p041if.th.qw<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final Func0 f11421i = new qw();

    /* renamed from: th  reason: collision with root package name */
    public final Observable<? extends T> f11422th;

    /* renamed from: uk  reason: collision with root package name */
    public final Func0<? extends rg<T>> f11423uk;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<th<T>> f11424yj;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements rg<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null, 0);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = (Node) initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.th(leaveTransform) && !NotificationLite.yj(leaveTransform)) {
                        collection.add(NotificationLite.rg(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.ad());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        public final void error(Throwable th2) {
            Object enterTransform = enterTransform(NotificationLite.de(th2));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Node getInitialHead() {
            return (Node) get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.th(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.yj(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.uk(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void removeSome(int i2) {
            Node node = (Node) get();
            while (i2 > 0) {
                node = (Node) node.get();
                i2--;
                this.size--;
            }
            setFirst(node);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = (rx.internal.operators.OperatorReplay.Node) r12.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r0 != null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
            r0 = getInitialHead();
            r12.index = r0;
            r12.addTotalRequested(r0.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            r1 = r12.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            if (r1 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            r2 = r12.get();
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
            if (r6 == r2) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
            r8 = (rx.internal.operators.OperatorReplay.Node) r0.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            if (r8 == null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
            r0 = leaveTransform(r8.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
            if (rx.internal.operators.NotificationLite.qw(r1, r0) == false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
            r12.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
            r0 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            r12.index = null;
            p041if.fe.qw.rg(r2);
            r12.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
            if (rx.internal.operators.NotificationLite.yj(r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
            r1.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, rx.internal.operators.NotificationLite.rg(r0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0085, code lost:
            if (r6 == 0) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0087, code lost:
            r12.index = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0090, code lost:
            if (r2 == Long.MAX_VALUE) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0092, code lost:
            r12.produced(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0095, code lost:
            monitor-enter(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
            if (r12.missed != false) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009b, code lost:
            r12.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
            r12.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a1, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r12) {
            /*
                r11 = this;
                monitor-enter(r12)
                boolean r0 = r12.emitting     // Catch:{ all -> 0x00a7 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r12.missed = r1     // Catch:{ all -> 0x00a7 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a7 }
                return
            L_0x000a:
                r12.emitting = r1     // Catch:{ all -> 0x00a7 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a7 }
            L_0x000d:
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x0014
                return
            L_0x0014:
                java.lang.Object r0 = r12.index()
                rx.internal.operators.OperatorReplay$Node r0 = (rx.internal.operators.OperatorReplay.Node) r0
                if (r0 != 0) goto L_0x0027
                rx.internal.operators.OperatorReplay$Node r0 = r11.getInitialHead()
                r12.index = r0
                long r1 = r0.index
                r12.addTotalRequested(r1)
            L_0x0027:
                boolean r1 = r12.isUnsubscribed()
                if (r1 == 0) goto L_0x002e
                return
            L_0x002e:
                if.de<? super T> r1 = r12.child
                if (r1 != 0) goto L_0x0033
                return
            L_0x0033:
                long r2 = r12.get()
                r4 = 0
                r6 = r4
            L_0x003a:
                int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r8 == 0) goto L_0x0083
                java.lang.Object r8 = r0.get()
                rx.internal.operators.OperatorReplay$Node r8 = (rx.internal.operators.OperatorReplay.Node) r8
                if (r8 == 0) goto L_0x0083
                java.lang.Object r0 = r8.value
                java.lang.Object r0 = r11.leaveTransform(r0)
                r9 = 0
                boolean r10 = rx.internal.operators.NotificationLite.qw(r1, r0)     // Catch:{ all -> 0x0062 }
                if (r10 == 0) goto L_0x0056
                r12.index = r9     // Catch:{ all -> 0x0062 }
                return
            L_0x0056:
                r9 = 1
                long r6 = r6 + r9
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x0060
                return
            L_0x0060:
                r0 = r8
                goto L_0x003a
            L_0x0062:
                r2 = move-exception
                r12.index = r9
                p041if.fe.qw.rg(r2)
                r12.unsubscribe()
                boolean r12 = rx.internal.operators.NotificationLite.yj(r0)
                if (r12 != 0) goto L_0x0082
                boolean r12 = rx.internal.operators.NotificationLite.th(r0)
                if (r12 != 0) goto L_0x0082
                java.lang.Object r12 = rx.internal.operators.NotificationLite.rg(r0)
                java.lang.Throwable r12 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, r12)
                r1.onError(r12)
            L_0x0082:
                return
            L_0x0083:
                int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r1 == 0) goto L_0x0095
                r12.index = r0
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 == 0) goto L_0x0095
                r12.produced(r6)
            L_0x0095:
                monitor-enter(r12)
                boolean r0 = r12.missed     // Catch:{ all -> 0x00a4 }
                r1 = 0
                if (r0 != 0) goto L_0x009f
                r12.emitting = r1     // Catch:{ all -> 0x00a4 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a4 }
                return
            L_0x009f:
                r12.missed = r1     // Catch:{ all -> 0x00a4 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a4 }
                goto L_0x000d
            L_0x00a4:
                r0 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x00a4 }
                throw r0
            L_0x00a7:
                r0 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x00a7 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.BoundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }
    }

    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public p041if.de<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final th<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(th<T> thVar, p041if.de<? super T> deVar) {
            this.parent = thVar;
            this.child = deVar;
        }

        public void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public <U> U index() {
            return this.index;
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        public void request(long j) {
            long j2;
            long j3;
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || i2 != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                addTotalRequested(j);
                this.parent.yj(this);
                this.parent.f11431ad.replay(this);
            }
        }

        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.uk(this);
                this.parent.yj(this);
                this.child = null;
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAgeInMillis;
        public final p041if.qw scheduler;

        public SizeAndTimeBoundReplayBuffer(int i2, long j, p041if.qw qwVar) {
            this.scheduler = qwVar;
            this.limit = i2;
            this.maxAgeInMillis = j;
        }

        public Object enterTransform(Object obj) {
            return new p041if.i.ad(this.scheduler.ad(), obj);
        }

        public Node getInitialHead() {
            Node node;
            long ad2 = this.scheduler.ad() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 == null || ((p041if.i.ad) node2.value).qw() > ad2) {
                    return node;
                }
                obj = node2.get();
            }
            return node;
        }

        public Object leaveTransform(Object obj) {
            return ((p041if.i.ad) obj).ad();
        }

        public void truncate() {
            Node node;
            long ad2 = this.scheduler.ad() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i3 = this.size;
                    if (i3 <= this.limit) {
                        if (((p041if.i.ad) node2.value).qw() > ad2) {
                            break;
                        }
                        i2++;
                        this.size--;
                        node3 = (Node) node2.get();
                    } else {
                        i2++;
                        this.size = i3 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void truncateFinal() {
            /*
                r10 = this;
                if.qw r0 = r10.scheduler
                long r0 = r0.ad()
                long r2 = r10.maxAgeInMillis
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                rx.internal.operators.OperatorReplay$Node r2 = (rx.internal.operators.OperatorReplay.Node) r2
                java.lang.Object r3 = r2.get()
                rx.internal.operators.OperatorReplay$Node r3 = (rx.internal.operators.OperatorReplay.Node) r3
                r4 = 0
            L_0x0016:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003a
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.value
                if.i.ad r5 = (p041if.i.ad) r5
                long r7 = r5.qw()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                rx.internal.operators.OperatorReplay$Node r3 = (rx.internal.operators.OperatorReplay.Node) r3
                goto L_0x0016
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.setFirst(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i2) {
            this.limit = i2;
        }

        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements rg<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        public void complete() {
            add(NotificationLite.ad());
            this.size++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.de(th2));
            this.size++;
        }

        public void next(T t) {
            add(NotificationLite.uk(t));
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = r12.size;
            r1 = (java.lang.Integer) r13.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1 = r1.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r3 = r13.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r3 != null) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r4 = r13.get();
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r8 == r4) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            if (r1 >= r0) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
            r10 = get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
            if (rx.internal.operators.NotificationLite.qw(r3, r10) == false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
            r1 = r1 + 1;
            r8 = r8 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
            p041if.fe.qw.rg(r0);
            r13.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
            if (rx.internal.operators.NotificationLite.yj(r10) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, rx.internal.operators.NotificationLite.rg(r10)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0070, code lost:
            if (r8 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
            r13.index = java.lang.Integer.valueOf(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0081, code lost:
            r13.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
            monitor-enter(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
            if (r13.missed != false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0089, code lost:
            r13.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x008b, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008d, code lost:
            r13.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008f, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r13) {
            /*
                r12 = this;
                monitor-enter(r13)
                boolean r0 = r13.emitting     // Catch:{ all -> 0x0095 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r13.missed = r1     // Catch:{ all -> 0x0095 }
                monitor-exit(r13)     // Catch:{ all -> 0x0095 }
                return
            L_0x000a:
                r13.emitting = r1     // Catch:{ all -> 0x0095 }
                monitor-exit(r13)     // Catch:{ all -> 0x0095 }
            L_0x000d:
                boolean r0 = r13.isUnsubscribed()
                if (r0 == 0) goto L_0x0014
                return
            L_0x0014:
                int r0 = r12.size
                java.lang.Object r1 = r13.index()
                java.lang.Integer r1 = (java.lang.Integer) r1
                r2 = 0
                if (r1 == 0) goto L_0x0024
                int r1 = r1.intValue()
                goto L_0x0025
            L_0x0024:
                r1 = 0
            L_0x0025:
                if.de<? super T> r3 = r13.child
                if (r3 != 0) goto L_0x002a
                return
            L_0x002a:
                long r4 = r13.get()
                r6 = 0
                r8 = r6
            L_0x0031:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x006e
                if (r1 >= r0) goto L_0x006e
                java.lang.Object r10 = r12.get(r1)
                boolean r10 = rx.internal.operators.NotificationLite.qw(r3, r10)     // Catch:{ all -> 0x004f }
                if (r10 == 0) goto L_0x0042
                return
            L_0x0042:
                boolean r10 = r13.isUnsubscribed()
                if (r10 == 0) goto L_0x0049
                return
            L_0x0049:
                int r1 = r1 + 1
                r10 = 1
                long r8 = r8 + r10
                goto L_0x0031
            L_0x004f:
                r0 = move-exception
                p041if.fe.qw.rg(r0)
                r13.unsubscribe()
                boolean r13 = rx.internal.operators.NotificationLite.yj(r10)
                if (r13 != 0) goto L_0x006d
                boolean r13 = rx.internal.operators.NotificationLite.th(r10)
                if (r13 != 0) goto L_0x006d
                java.lang.Object r13 = rx.internal.operators.NotificationLite.rg(r10)
                java.lang.Throwable r13 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, r13)
                r3.onError(r13)
            L_0x006d:
                return
            L_0x006e:
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0084
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                r13.index = r0
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x0084
                r13.produced(r8)
            L_0x0084:
                monitor-enter(r13)
                boolean r0 = r13.missed     // Catch:{ all -> 0x0092 }
                if (r0 != 0) goto L_0x008d
                r13.emitting = r2     // Catch:{ all -> 0x0092 }
                monitor-exit(r13)     // Catch:{ all -> 0x0092 }
                return
            L_0x008d:
                r13.missed = r2     // Catch:{ all -> 0x0092 }
                monitor-exit(r13)     // Catch:{ all -> 0x0092 }
                goto L_0x000d
            L_0x0092:
                r0 = move-exception
                monitor-exit(r13)     // Catch:{ all -> 0x0092 }
                throw r0
            L_0x0095:
                r0 = move-exception
                monitor-exit(r13)     // Catch:{ all -> 0x0095 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.UnboundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }
    }

    public static class ad implements Func0<rg<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f11425ad;

        public ad(int i2) {
            this.f11425ad = i2;
        }

        /* renamed from: ad */
        public rg<T> call() {
            return new SizeBoundReplayBuffer(this.f11425ad);
        }
    }

    public static class de implements Func0<rg<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f11426ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f11427th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ p041if.qw f11428yj;

        public de(int i2, long j, p041if.qw qwVar) {
            this.f11426ad = i2;
            this.f11427th = j;
            this.f11428yj = qwVar;
        }

        /* renamed from: ad */
        public rg<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f11426ad, this.f11427th, this.f11428yj);
        }
    }

    public static class fe implements Observable.OnSubscribe<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f11429ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Func0 f11430th;

        public fe(AtomicReference atomicReference, Func0 func0) {
            this.f11429ad = atomicReference;
            this.f11430th = func0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* renamed from: ad */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void call(p041if.de<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r3.f11429ad
                java.lang.Object r0 = r0.get()
                rx.internal.operators.OperatorReplay$th r0 = (rx.internal.operators.OperatorReplay.th) r0
                if (r0 != 0) goto L_0x0024
                rx.internal.operators.OperatorReplay$th r1 = new rx.internal.operators.OperatorReplay$th
                rx.functions.Func0 r2 = r3.f11430th
                java.lang.Object r2 = r2.call()
                rx.internal.operators.OperatorReplay$rg r2 = (rx.internal.operators.OperatorReplay.rg) r2
                r1.<init>(r2)
                r1.rg()
                java.util.concurrent.atomic.AtomicReference r2 = r3.f11429ad
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 != 0) goto L_0x0023
                goto L_0x0000
            L_0x0023:
                r0 = r1
            L_0x0024:
                rx.internal.operators.OperatorReplay$InnerProducer r1 = new rx.internal.operators.OperatorReplay$InnerProducer
                r1.<init>(r0, r4)
                r0.de(r1)
                r4.add(r1)
                rx.internal.operators.OperatorReplay$rg<T> r0 = r0.f11431ad
                r0.replay(r1)
                r4.setProducer(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.fe.call(if.de):void");
        }
    }

    public static class qw implements Func0 {
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public interface rg<T> {
        void complete();

        void error(Throwable th2);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static final class th<T> extends p041if.de<T> implements Subscription {
        public static final InnerProducer[] nn = new InnerProducer[0];

        /* renamed from: ad  reason: collision with root package name */
        public final rg<T> f11431ad;
        public boolean ddd;
        public long ggg;

        /* renamed from: i  reason: collision with root package name */
        public InnerProducer<T>[] f11432i = nn;

        /* renamed from: if  reason: not valid java name */
        public final AtomicBoolean f540if = new AtomicBoolean();

        /* renamed from: o  reason: collision with root package name */
        public volatile long f11433o;

        /* renamed from: pf  reason: collision with root package name */
        public long f11434pf;
        public long ppp;

        /* renamed from: switch  reason: not valid java name */
        public boolean f541switch;

        /* renamed from: th  reason: collision with root package name */
        public boolean f11435th;

        /* renamed from: uk  reason: collision with root package name */
        public final p041if.rg.fe.fe<InnerProducer<T>> f11436uk = new p041if.rg.fe.fe<>();
        public volatile Producer vvv;
        public boolean when;
        public List<InnerProducer<T>> xxx;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f11437yj;

        public class qw implements Action0 {
            public qw() {
            }

            public void call() {
                if (!th.this.f11437yj) {
                    synchronized (th.this.f11436uk) {
                        if (!th.this.f11437yj) {
                            th.this.f11436uk.yj();
                            th.this.f11433o++;
                            th.this.f11437yj = true;
                        }
                    }
                }
            }
        }

        public th(rg<T> rgVar) {
            this.f11431ad = rgVar;
            request(0);
        }

        public boolean de(InnerProducer<T> innerProducer) {
            if (innerProducer == null) {
                throw null;
            } else if (this.f11437yj) {
                return false;
            } else {
                synchronized (this.f11436uk) {
                    if (this.f11437yj) {
                        return false;
                    }
                    this.f11436uk.qw(innerProducer);
                    this.f11433o++;
                    return true;
                }
            }
        }

        public InnerProducer<T>[] fe() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.f11436uk) {
                Object[] uk2 = this.f11436uk.uk();
                int length = uk2.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(uk2, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        public void i() {
            InnerProducer<T>[] innerProducerArr = this.f11432i;
            if (this.f11434pf != this.f11433o) {
                synchronized (this.f11436uk) {
                    innerProducerArr = this.f11432i;
                    Object[] uk2 = this.f11436uk.uk();
                    int length = uk2.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.f11432i = innerProducerArr;
                    }
                    System.arraycopy(uk2, 0, innerProducerArr, 0, length);
                    this.f11434pf = this.f11433o;
                }
            }
            rg<T> rgVar = this.f11431ad;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    rgVar.replay(innerProducer);
                }
            }
        }

        public void onCompleted() {
            if (!this.f11435th) {
                this.f11435th = true;
                try {
                    this.f11431ad.complete();
                    i();
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f11435th) {
                this.f11435th = true;
                try {
                    this.f11431ad.error(th2);
                    i();
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onNext(T t) {
            if (!this.f11435th) {
                this.f11431ad.next(t);
                i();
            }
        }

        public void rg() {
            add(p041if.pf.fe.qw(new qw()));
        }

        public void setProducer(Producer producer) {
            if (this.vvv == null) {
                this.vvv = producer;
                yj((InnerProducer) null);
                i();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        public void th(long j, long j2) {
            long j3 = this.ggg;
            Producer producer = this.vvv;
            long j4 = j - j2;
            if (j4 != 0) {
                this.ppp = j;
                if (producer == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.ggg = j5;
                } else if (j3 != 0) {
                    this.ggg = 0;
                    producer.request(j3 + j4);
                } else {
                    producer.request(j4);
                }
            } else if (j3 != 0 && producer != null) {
                this.ggg = 0;
                producer.request(j3);
            }
        }

        public void uk(InnerProducer<T> innerProducer) {
            if (!this.f11437yj) {
                synchronized (this.f11436uk) {
                    if (!this.f11437yj) {
                        this.f11436uk.rg(innerProducer);
                        if (this.f11436uk.ad()) {
                            this.f11432i = nn;
                        }
                        this.f11433o++;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            r0 = r9.ppp;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            if (r10 == null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
            r3 = java.lang.Math.max(r0, r10.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            r10 = fe();
            r3 = r10.length;
            r4 = r0;
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
            if (r6 >= r3) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
            r7 = r10[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            if (r7 == null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            r4 = java.lang.Math.max(r4, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
            th(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            if (isUnsubscribed() == false) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (r9.when != false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
            r9.f541switch = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0065, code lost:
            r9.when = false;
            r10 = r9.xxx;
            r9.xxx = null;
            r0 = r9.ddd;
            r9.ddd = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
            r3 = r9.ppp;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
            if (r10 == null) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0075, code lost:
            r10 = r10.iterator();
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
            if (r10.hasNext() == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0080, code lost:
            r5 = java.lang.Math.max(r5, r10.next().totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0092, code lost:
            if (r0 == false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0094, code lost:
            r10 = fe();
            r0 = r10.length;
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009a, code lost:
            if (r1 >= r0) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
            r7 = r10[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009e, code lost:
            if (r7 == null) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
            r5 = java.lang.Math.max(r5, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00aa, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ad, code lost:
            th(r5, r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void yj(rx.internal.operators.OperatorReplay.InnerProducer<T> r10) {
            /*
                r9 = this;
                boolean r0 = r9.isUnsubscribed()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                monitor-enter(r9)
                boolean r0 = r9.f541switch     // Catch:{ all -> 0x00b4 }
                r1 = 1
                if (r0 == 0) goto L_0x0024
                if (r10 == 0) goto L_0x001e
                java.util.List<rx.internal.operators.OperatorReplay$InnerProducer<T>> r0 = r9.xxx     // Catch:{ all -> 0x00b4 }
                if (r0 != 0) goto L_0x001a
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00b4 }
                r0.<init>()     // Catch:{ all -> 0x00b4 }
                r9.xxx = r0     // Catch:{ all -> 0x00b4 }
            L_0x001a:
                r0.add(r10)     // Catch:{ all -> 0x00b4 }
                goto L_0x0020
            L_0x001e:
                r9.ddd = r1     // Catch:{ all -> 0x00b4 }
            L_0x0020:
                r9.when = r1     // Catch:{ all -> 0x00b4 }
                monitor-exit(r9)     // Catch:{ all -> 0x00b4 }
                return
            L_0x0024:
                r9.f541switch = r1     // Catch:{ all -> 0x00b4 }
                monitor-exit(r9)     // Catch:{ all -> 0x00b4 }
                long r0 = r9.ppp
                r2 = 0
                if (r10 == 0) goto L_0x0037
                java.util.concurrent.atomic.AtomicLong r10 = r10.totalRequested
                long r3 = r10.get()
                long r3 = java.lang.Math.max(r0, r3)
                goto L_0x0052
            L_0x0037:
                rx.internal.operators.OperatorReplay$InnerProducer[] r10 = r9.fe()
                int r3 = r10.length
                r4 = r0
                r6 = 0
            L_0x003e:
                if (r6 >= r3) goto L_0x0051
                r7 = r10[r6]
                if (r7 == 0) goto L_0x004e
                java.util.concurrent.atomic.AtomicLong r7 = r7.totalRequested
                long r7 = r7.get()
                long r4 = java.lang.Math.max(r4, r7)
            L_0x004e:
                int r6 = r6 + 1
                goto L_0x003e
            L_0x0051:
                r3 = r4
            L_0x0052:
                r9.th(r3, r0)
            L_0x0055:
                boolean r10 = r9.isUnsubscribed()
                if (r10 == 0) goto L_0x005c
                return
            L_0x005c:
                monitor-enter(r9)
                boolean r10 = r9.when     // Catch:{ all -> 0x00b1 }
                if (r10 != 0) goto L_0x0065
                r9.f541switch = r2     // Catch:{ all -> 0x00b1 }
                monitor-exit(r9)     // Catch:{ all -> 0x00b1 }
                return
            L_0x0065:
                r9.when = r2     // Catch:{ all -> 0x00b1 }
                java.util.List<rx.internal.operators.OperatorReplay$InnerProducer<T>> r10 = r9.xxx     // Catch:{ all -> 0x00b1 }
                r0 = 0
                r9.xxx = r0     // Catch:{ all -> 0x00b1 }
                boolean r0 = r9.ddd     // Catch:{ all -> 0x00b1 }
                r9.ddd = r2     // Catch:{ all -> 0x00b1 }
                monitor-exit(r9)     // Catch:{ all -> 0x00b1 }
                long r3 = r9.ppp
                if (r10 == 0) goto L_0x0091
                java.util.Iterator r10 = r10.iterator()
                r5 = r3
            L_0x007a:
                boolean r1 = r10.hasNext()
                if (r1 == 0) goto L_0x0092
                java.lang.Object r1 = r10.next()
                rx.internal.operators.OperatorReplay$InnerProducer r1 = (rx.internal.operators.OperatorReplay.InnerProducer) r1
                java.util.concurrent.atomic.AtomicLong r1 = r1.totalRequested
                long r7 = r1.get()
                long r5 = java.lang.Math.max(r5, r7)
                goto L_0x007a
            L_0x0091:
                r5 = r3
            L_0x0092:
                if (r0 == 0) goto L_0x00ad
                rx.internal.operators.OperatorReplay$InnerProducer[] r10 = r9.fe()
                int r0 = r10.length
                r1 = 0
            L_0x009a:
                if (r1 >= r0) goto L_0x00ad
                r7 = r10[r1]
                if (r7 == 0) goto L_0x00aa
                java.util.concurrent.atomic.AtomicLong r7 = r7.totalRequested
                long r7 = r7.get()
                long r5 = java.lang.Math.max(r5, r7)
            L_0x00aa:
                int r1 = r1 + 1
                goto L_0x009a
            L_0x00ad:
                r9.th(r5, r3)
                goto L_0x0055
            L_0x00b1:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x00b1 }
                throw r10
            L_0x00b4:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x00b4 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.th.yj(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }
    }

    public OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<th<T>> atomicReference, Func0<? extends rg<T>> func0) {
        super(onSubscribe);
        this.f11422th = observable;
        this.f11424yj = atomicReference;
        this.f11423uk = func0;
    }

    public static <T> p041if.th.qw<T> a(Observable<? extends T> observable, long j, TimeUnit timeUnit, p041if.qw qwVar, int i2) {
        return b(observable, new de(i2, timeUnit.toMillis(j), qwVar));
    }

    public static <T> p041if.th.qw<T> b(Observable<? extends T> observable, Func0<? extends rg<T>> func0) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new fe(atomicReference, func0), observable, atomicReference, func0);
    }

    public static <T> p041if.th.qw<T> eee(Observable<? extends T> observable) {
        return b(observable, f11421i);
    }

    public static <T> p041if.th.qw<T> rrr(Observable<? extends T> observable, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return eee(observable);
        }
        return b(observable, new ad(i2));
    }

    public static <T> p041if.th.qw<T> tt(Observable<? extends T> observable, long j, TimeUnit timeUnit, p041if.qw qwVar) {
        return a(observable, j, timeUnit, qwVar, Integer.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void qqq(rx.functions.Action1<? super rx.Subscription> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorReplay$th<T>> r0 = r4.f11424yj
            java.lang.Object r0 = r0.get()
            rx.internal.operators.OperatorReplay$th r0 = (rx.internal.operators.OperatorReplay.th) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isUnsubscribed()
            if (r1 == 0) goto L_0x002a
        L_0x0010:
            rx.internal.operators.OperatorReplay$th r1 = new rx.internal.operators.OperatorReplay$th
            rx.functions.Func0<? extends rx.internal.operators.OperatorReplay$rg<T>> r2 = r4.f11423uk
            java.lang.Object r2 = r2.call()
            rx.internal.operators.OperatorReplay$rg r2 = (rx.internal.operators.OperatorReplay.rg) r2
            r1.<init>(r2)
            r1.rg()
            java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorReplay$th<T>> r2 = r4.f11424yj
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 != 0) goto L_0x0029
            goto L_0x0000
        L_0x0029:
            r0 = r1
        L_0x002a:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f540if
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f540if
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            r5.call(r0)
            if (r2 == 0) goto L_0x0048
            rx.Observable<? extends T> r5 = r4.f11422th
            r5.aaa(r0)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.qqq(rx.functions.Action1):void");
    }
}
