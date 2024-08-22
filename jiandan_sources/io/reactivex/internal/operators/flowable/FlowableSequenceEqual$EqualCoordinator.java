package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import th.de.o.qw;
import th.de.p039if.fe.ad.Cif;

public final class FlowableSequenceEqual$EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements Cif {
    public static final long serialVersionUID = -6178010334400373240L;
    public final BiPredicate<? super T, ? super T> comparer;
    public final AtomicThrowable error;
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;
    public T v1;
    public T v2;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableSequenceEqual$EqualCoordinator(Subscriber<? super Boolean> subscriber, int i2, BiPredicate<? super T, ? super T> biPredicate) {
        super(subscriber);
        this.comparer = biPredicate;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i2);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i2);
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        if (this.wip.getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            int i2 = 1;
            do {
                SimpleQueue<T> simpleQueue = this.first.queue;
                SimpleQueue<T> simpleQueue2 = this.second.queue;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!isCancelled()) {
                        if (((Throwable) this.error.get()) != null) {
                            cancelAndClear();
                            this.downstream.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.v1;
                        if (t == null) {
                            try {
                                t = simpleQueue.poll();
                                this.v1 = t;
                            } catch (Throwable th2) {
                                qw.ad(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = false;
                        boolean z3 = t == null;
                        boolean z4 = this.second.done;
                        T t2 = this.v2;
                        if (t2 == null) {
                            try {
                                t2 = simpleQueue2.poll();
                                this.v2 = t2;
                            } catch (Throwable th3) {
                                qw.ad(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        if (t2 == null) {
                            z2 = true;
                        }
                        if (z && z4 && z3 && z2) {
                            complete(Boolean.TRUE);
                            return;
                        } else if (z && z4 && z3 != z2) {
                            cancelAndClear();
                            complete(Boolean.FALSE);
                            return;
                        } else if (!z3 && !z2) {
                            try {
                                if (!this.comparer.qw(t, t2)) {
                                    cancelAndClear();
                                    complete(Boolean.FALSE);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th4) {
                                qw.ad(th4);
                                cancelAndClear();
                                this.error.addThrowable(th4);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (((Throwable) this.error.get()) != null) {
                    cancelAndClear();
                    this.downstream.onError(this.error.terminate());
                    return;
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    public void innerError(Throwable th2) {
        if (this.error.addThrowable(th2)) {
            drain();
        } else {
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void subscribe(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        publisher.subscribe(this.first);
        publisher2.subscribe(this.second);
    }
}
