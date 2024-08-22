package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;
import th.de.p039if.fe.ad.fe;

public final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    public static final long serialVersionUID = -2945777694260521066L;
    public final Subscriber<? super R> downstream;
    public final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(function, i2);
        this.downstream = subscriber;
        this.veryEnd = z;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z = this.done;
                    if (!z || this.veryEnd || ((Throwable) this.errors.get()) == null) {
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.downstream.onError(terminate);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    qw.rg(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request((long) i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.downstream.onNext(call);
                                            } else {
                                                this.active = true;
                                                FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                                flowableConcatMap$ConcatMapInner.setSubscription(new fe(call, flowableConcatMap$ConcatMapInner));
                                            }
                                        } catch (Throwable th2) {
                                            th.de.o.qw.ad(th2);
                                            this.upstream.cancel();
                                            this.errors.addThrowable(th2);
                                            this.downstream.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th3) {
                                    th.de.o.qw.ad(th3);
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th3);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            th.de.o.qw.ad(th4);
                            this.upstream.cancel();
                            this.errors.addThrowable(th4);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    } else {
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            if (!this.veryEnd) {
                this.upstream.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void innerNext(R r) {
        this.downstream.onNext(r);
    }

    public void onError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            this.done = true;
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void request(long j) {
        this.inner.request(j);
    }

    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}
