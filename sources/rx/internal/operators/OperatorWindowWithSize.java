package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.subjects.Subject;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithSize<T> implements Observable.Operator<Observable<T>, T> {
    final int size;
    final int skip;

    public OperatorWindowWithSize(int size2, int skip2) {
        this.size = size2;
        this.skip = skip2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        int i2 = this.skip;
        int i3 = this.size;
        if (i2 == i3) {
            WindowExact<T> parent = new WindowExact<>(child, this.size);
            child.add(parent.cancel);
            child.setProducer(parent.createProducer());
            return parent;
        } else if (i2 > i3) {
            WindowSkip<T> parent2 = new WindowSkip<>(child, this.size, this.skip);
            child.add(parent2.cancel);
            child.setProducer(parent2.createProducer());
            return parent2;
        } else {
            WindowOverlap<T> parent3 = new WindowOverlap<>(child, this.size, this.skip);
            child.add(parent3.cancel);
            child.setProducer(parent3.createProducer());
            return parent3;
        }
    }

    static final class WindowExact<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        int index;
        final int size;
        Subject<T, T> window;
        final AtomicInteger wip = new AtomicInteger(1);

        public WindowExact(Subscriber<? super Observable<T>> actual2, int size2) {
            this.actual = actual2;
            this.size = size2;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0);
        }

        public void onNext(T t) {
            int i2 = this.index;
            Subject<T, T> w = this.window;
            if (i2 == 0) {
                this.wip.getAndIncrement();
                w = UnicastSubject.create(this.size, this);
                this.window = w;
                this.actual.onNext(w);
            }
            int i3 = i2 + 1;
            w.onNext(t);
            if (i3 == this.size) {
                this.index = 0;
                this.window = null;
                w.onCompleted();
                return;
            }
            this.index = i3;
        }

        public void onError(Throwable e2) {
            Subject<T, T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onError(e2);
            }
            this.actual.onError(e2);
        }

        public void onCompleted() {
            Subject<T, T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onCompleted();
            }
            this.actual.onCompleted();
        }

        /* access modifiers changed from: package-private */
        public Producer createProducer() {
            return new Producer() {
                public void request(long n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("n >= 0 required but it was " + n);
                    } else if (n != 0) {
                        WindowExact.this.request(BackpressureUtils.multiplyCap((long) WindowExact.this.size, n));
                    }
                }
            };
        }

        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }
    }

    static final class WindowSkip<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        int index;
        final int size;
        final int skip;
        Subject<T, T> window;
        final AtomicInteger wip = new AtomicInteger(1);

        public WindowSkip(Subscriber<? super Observable<T>> actual2, int size2, int skip2) {
            this.actual = actual2;
            this.size = size2;
            this.skip = skip2;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0);
        }

        public void onNext(T t) {
            int i2 = this.index;
            Subject<T, T> w = this.window;
            if (i2 == 0) {
                this.wip.getAndIncrement();
                w = UnicastSubject.create(this.size, this);
                this.window = w;
                this.actual.onNext(w);
            }
            int i3 = i2 + 1;
            if (w != null) {
                w.onNext(t);
            }
            if (i3 == this.size) {
                this.index = i3;
                this.window = null;
                w.onCompleted();
            } else if (i3 == this.skip) {
                this.index = 0;
            } else {
                this.index = i3;
            }
        }

        public void onError(Throwable e2) {
            Subject<T, T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onError(e2);
            }
            this.actual.onError(e2);
        }

        public void onCompleted() {
            Subject<T, T> w = this.window;
            if (w != null) {
                this.window = null;
                w.onCompleted();
            }
            this.actual.onCompleted();
        }

        /* access modifiers changed from: package-private */
        public Producer createProducer() {
            return new WindowSkipProducer();
        }

        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        final class WindowSkipProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowSkipProducer() {
            }

            public void request(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + n);
                } else if (n != 0) {
                    WindowSkip<T> parent = WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        parent.request(BackpressureUtils.multiplyCap(n, (long) parent.skip));
                    } else {
                        parent.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(n, (long) parent.size), BackpressureUtils.multiplyCap((long) (parent.skip - parent.size), n - 1)));
                    }
                }
            }
        }
    }

    static final class WindowOverlap<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        volatile boolean done;
        final AtomicInteger drainWip = new AtomicInteger();
        Throwable error;
        int index;
        int produced;
        final Queue<Subject<T, T>> queue;
        final AtomicLong requested = new AtomicLong();
        final int size;
        final int skip;
        final ArrayDeque<Subject<T, T>> windows = new ArrayDeque<>();
        final AtomicInteger wip = new AtomicInteger(1);

        public WindowOverlap(Subscriber<? super Observable<T>> actual2, int size2, int skip2) {
            this.actual = actual2;
            this.size = size2;
            this.skip = skip2;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0);
            this.queue = new SpscLinkedArrayQueue(((skip2 - 1) + size2) / skip2);
        }

        public void onNext(T t) {
            int i2 = this.index;
            ArrayDeque<Subject<T, T>> q = this.windows;
            if (i2 == 0 && !this.actual.isUnsubscribed()) {
                this.wip.getAndIncrement();
                Subject<T, T> w = UnicastSubject.create(16, this);
                q.offer(w);
                this.queue.offer(w);
                drain();
            }
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int p = this.produced + 1;
            if (p == this.size) {
                this.produced = p - this.skip;
                Subject<T, T> w2 = q.poll();
                if (w2 != null) {
                    w2.onCompleted();
                }
            } else {
                this.produced = p;
            }
            int i3 = i2 + 1;
            if (i3 == this.skip) {
                this.index = 0;
            } else {
                this.index = i3;
            }
        }

        public void onError(Throwable e2) {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(e2);
            }
            this.windows.clear();
            this.error = e2;
            this.done = true;
            drain();
        }

        public void onCompleted() {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public Producer createProducer() {
            return new WindowOverlapProducer();
        }

        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            AtomicInteger dw = this.drainWip;
            if (dw.getAndIncrement() == 0) {
                Subscriber<? super Observable<T>> subscriber = this.actual;
                Queue<Subject<T, T>> q = this.queue;
                int missed = 1;
                do {
                    long r = this.requested.get();
                    long e2 = 0;
                    while (e2 != r) {
                        boolean d2 = this.done;
                        Subject<T, T> v = q.poll();
                        boolean empty = v == null;
                        if (!checkTerminated(d2, empty, subscriber, q)) {
                            if (empty) {
                                break;
                            }
                            subscriber.onNext(v);
                            e2++;
                        } else {
                            return;
                        }
                    }
                    if (e2 != r || !checkTerminated(this.done, q.isEmpty(), subscriber, q)) {
                        if (!(e2 == 0 || r == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-e2);
                        }
                        missed = dw.addAndGet(-missed);
                    } else {
                        return;
                    }
                } while (missed != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean d2, boolean empty, Subscriber<? super Subject<T, T>> a2, Queue<Subject<T, T>> q) {
            if (a2.isUnsubscribed()) {
                q.clear();
                return true;
            } else if (!d2) {
                return false;
            } else {
                Throwable e2 = this.error;
                if (e2 != null) {
                    q.clear();
                    a2.onError(e2);
                    return true;
                } else if (!empty) {
                    return false;
                } else {
                    a2.onCompleted();
                    return true;
                }
            }
        }

        final class WindowOverlapProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowOverlapProducer() {
            }

            public void request(long n) {
                if (n < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + n);
                } else if (n != 0) {
                    WindowOverlap<T> parent = WindowOverlap.this;
                    if (get() || !compareAndSet(false, true)) {
                        WindowOverlap.this.request(BackpressureUtils.multiplyCap((long) parent.skip, n));
                    } else {
                        parent.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap((long) parent.skip, n - 1), (long) parent.size));
                    }
                    BackpressureUtils.getAndAddRequest(parent.requested, n);
                    parent.drain();
                }
            }
        }
    }
}
