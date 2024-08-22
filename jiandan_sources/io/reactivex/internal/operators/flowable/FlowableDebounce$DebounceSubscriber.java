package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 6725975399620862591L;
    public final Function<? super T, ? extends Publisher<U>> debounceSelector;
    public final AtomicReference<Disposable> debouncer = new AtomicReference<>();
    public boolean done;
    public final Subscriber<? super T> downstream;
    public volatile long index;
    public Subscription upstream;

    public static final class qw<T, U> extends th.de.ddd.qw<U> {

        /* renamed from: i  reason: collision with root package name */
        public boolean f9981i;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicBoolean f9982o = new AtomicBoolean();

        /* renamed from: th  reason: collision with root package name */
        public final FlowableDebounce$DebounceSubscriber<T, U> f9983th;

        /* renamed from: uk  reason: collision with root package name */
        public final T f9984uk;

        /* renamed from: yj  reason: collision with root package name */
        public final long f9985yj;

        public qw(FlowableDebounce$DebounceSubscriber<T, U> flowableDebounce$DebounceSubscriber, long j, T t) {
            this.f9983th = flowableDebounce$DebounceSubscriber;
            this.f9985yj = j;
            this.f9984uk = t;
        }

        public void de() {
            if (this.f9982o.compareAndSet(false, true)) {
                this.f9983th.emit(this.f9985yj, this.f9984uk);
            }
        }

        public void onComplete() {
            if (!this.f9981i) {
                this.f9981i = true;
                de();
            }
        }

        public void onError(Throwable th2) {
            if (this.f9981i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f9981i = true;
            this.f9983th.onError(th2);
        }

        public void onNext(U u) {
            if (!this.f9981i) {
                this.f9981i = true;
                qw();
                de();
            }
        }
    }

    public FlowableDebounce$DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
        this.downstream = subscriber;
        this.debounceSelector = function;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long j, T t) {
        if (j != this.index) {
            return;
        }
        if (get() != 0) {
            this.downstream.onNext(t);
            th.de.p039if.yj.qw.rg(this, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (!DisposableHelper.isDisposed(disposable)) {
                ((qw) disposable).de();
                DisposableHelper.dispose(this.debouncer);
                this.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            long j = this.index + 1;
            this.index = j;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Object apply = this.debounceSelector.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The publisher supplied is null");
                Publisher publisher = (Publisher) apply;
                qw qwVar = new qw(this, j, t);
                if (this.debouncer.compareAndSet(disposable, qwVar)) {
                    publisher.subscribe(qwVar);
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this, j);
        }
    }
}
