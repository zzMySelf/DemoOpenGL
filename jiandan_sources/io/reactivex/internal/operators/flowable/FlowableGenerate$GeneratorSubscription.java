package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
    public static final long serialVersionUID = 7565982551505011832L;
    public volatile boolean cancelled;
    public final Consumer<? super S> disposeState;
    public final Subscriber<? super T> downstream;
    public final BiFunction<S, ? super Emitter<T>, S> generator;
    public boolean hasNext;
    public S state;
    public boolean terminate;

    public FlowableGenerate$GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
        this.downstream = subscriber;
        this.generator = biFunction;
        this.disposeState = consumer;
        this.state = s;
    }

    private void dispose(S s) {
        try {
            this.disposeState.accept(s);
        } catch (Throwable th2) {
            qw.ad(th2);
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (th.de.p039if.yj.qw.qw(this, 1) == 0) {
                S s = this.state;
                this.state = null;
                dispose(s);
            }
        }
    }

    public void onComplete() {
        if (!this.terminate) {
            this.terminate = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.terminate) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.terminate = true;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (this.terminate) {
            return;
        }
        if (this.hasNext) {
            onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.hasNext = true;
            this.downstream.onNext(t);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j) && th.de.p039if.yj.qw.qw(this, j) == 0) {
            S s = this.state;
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.generator;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            this.state = s;
                            j = addAndGet(-j2);
                        }
                    } else if (this.cancelled) {
                        this.state = null;
                        dispose(s);
                        return;
                    } else {
                        this.hasNext = false;
                        try {
                            s = biFunction.apply(s, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                dispose(s);
                                return;
                            }
                            j2++;
                        } catch (Throwable th2) {
                            qw.ad(th2);
                            this.cancelled = true;
                            this.state = null;
                            onError(th2);
                            dispose(s);
                            return;
                        }
                    }
                }
            } while (j != 0);
        }
    }
}
