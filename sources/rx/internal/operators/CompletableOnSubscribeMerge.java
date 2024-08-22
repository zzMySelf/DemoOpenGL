package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMerge implements Completable.OnSubscribe {
    final boolean delayErrors;
    final int maxConcurrency;
    final Observable<Completable> source;

    public CompletableOnSubscribeMerge(Observable<? extends Completable> source2, int maxConcurrency2, boolean delayErrors2) {
        this.source = source2;
        this.maxConcurrency = maxConcurrency2;
        this.delayErrors = delayErrors2;
    }

    public void call(CompletableSubscriber s) {
        CompletableMergeSubscriber parent = new CompletableMergeSubscriber(s, this.maxConcurrency, this.delayErrors);
        s.onSubscribe(parent);
        this.source.unsafeSubscribe(parent);
    }

    static final class CompletableMergeSubscriber extends Subscriber<Completable> {
        final CompletableSubscriber actual;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Queue<Throwable>> errors = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(1);

        public CompletableMergeSubscriber(CompletableSubscriber actual2, int maxConcurrency, boolean delayErrors2) {
            this.actual = actual2;
            this.delayErrors = delayErrors2;
            if (maxConcurrency == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request((long) maxConcurrency);
            }
        }

        /* access modifiers changed from: package-private */
        public Queue<Throwable> getOrCreateErrors() {
            Queue<Throwable> q = this.errors.get();
            if (q != null) {
                return q;
            }
            Queue<Throwable> q2 = new ConcurrentLinkedQueue<>();
            if (this.errors.compareAndSet((Object) null, q2)) {
                return q2;
            }
            return this.errors.get();
        }

        public void onNext(Completable t) {
            if (!this.done) {
                this.wip.getAndIncrement();
                t.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {

                    /* renamed from: d  reason: collision with root package name */
                    Subscription f7801d;
                    boolean innerDone;

                    public void onSubscribe(Subscription d2) {
                        this.f7801d = d2;
                        CompletableMergeSubscriber.this.set.add(d2);
                    }

                    public void onError(Throwable e2) {
                        if (this.innerDone) {
                            RxJavaHooks.onError(e2);
                            return;
                        }
                        this.innerDone = true;
                        CompletableMergeSubscriber.this.set.remove(this.f7801d);
                        CompletableMergeSubscriber.this.getOrCreateErrors().offer(e2);
                        CompletableMergeSubscriber.this.terminate();
                        if (CompletableMergeSubscriber.this.delayErrors && !CompletableMergeSubscriber.this.done) {
                            CompletableMergeSubscriber.this.request(1);
                        }
                    }

                    public void onCompleted() {
                        if (!this.innerDone) {
                            this.innerDone = true;
                            CompletableMergeSubscriber.this.set.remove(this.f7801d);
                            CompletableMergeSubscriber.this.terminate();
                            if (!CompletableMergeSubscriber.this.done) {
                                CompletableMergeSubscriber.this.request(1);
                            }
                        }
                    }
                });
            }
        }

        public void onError(Throwable t) {
            if (this.done) {
                RxJavaHooks.onError(t);
                return;
            }
            getOrCreateErrors().offer(t);
            this.done = true;
            terminate();
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                terminate();
            }
        }

        /* access modifiers changed from: package-private */
        public void terminate() {
            Queue<Throwable> q;
            if (this.wip.decrementAndGet() == 0) {
                Queue<Throwable> q2 = this.errors.get();
                if (q2 == null || q2.isEmpty()) {
                    this.actual.onCompleted();
                    return;
                }
                Throwable e2 = CompletableOnSubscribeMerge.collectErrors(q2);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(e2);
                } else {
                    RxJavaHooks.onError(e2);
                }
            } else if (!this.delayErrors && (q = this.errors.get()) != null && !q.isEmpty()) {
                Throwable e3 = CompletableOnSubscribeMerge.collectErrors(q);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(e3);
                } else {
                    RxJavaHooks.onError(e3);
                }
            }
        }
    }

    public static Throwable collectErrors(Queue<Throwable> q) {
        List<Throwable> list = new ArrayList<>();
        while (true) {
            Throwable poll = q.poll();
            Throwable t = poll;
            if (poll == null) {
                break;
            }
            list.add(t);
        }
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new CompositeException((Collection<? extends Throwable>) list);
    }
}
