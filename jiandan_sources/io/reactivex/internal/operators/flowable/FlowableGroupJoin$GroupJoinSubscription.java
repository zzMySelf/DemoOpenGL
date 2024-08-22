package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.i.qw;
import th.de.p039if.fe.ad.yj;

public final class FlowableGroupJoin$GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, yj {
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_CLOSE = 4;
    public static final Integer RIGHT_VALUE = 2;
    public static final long serialVersionUID = -6071216598687999801L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final qw disposables = new qw();
    public final Subscriber<? super R> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
    public final th.de.p039if.rg.qw<Object> queue = new th.de.p039if.rg.qw<>(ad.qw());
    public final AtomicLong requested = new AtomicLong();
    public final BiFunction<? super TLeft, ? super ad<TRight>, ? extends R> resultSelector;
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
    public int rightIndex;
    public final Map<Integer, TRight> rights = new LinkedHashMap();

    public FlowableGroupJoin$GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super ad<TRight>, ? extends R> biFunction) {
        this.downstream = subscriber;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
        this.active = new AtomicInteger(2);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            th.de.p039if.rg.qw<Object> qwVar = this.queue;
            Subscriber<? super R> subscriber = this.downstream;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    qwVar.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) qwVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    for (UnicastProcessor<TRight> onComplete : this.lefts.values()) {
                        onComplete.onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = qwVar.poll();
                    if (num == LEFT_VALUE) {
                        UnicastProcessor i3 = UnicastProcessor.i();
                        int i4 = this.leftIndex;
                        this.leftIndex = i4 + 1;
                        this.lefts.put(Integer.valueOf(i4), i3);
                        try {
                            Object apply = this.leftEnd.apply(poll);
                            th.de.p039if.ad.qw.rg(apply, "The leftEnd returned a null Publisher");
                            Publisher publisher = (Publisher) apply;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber = new FlowableGroupJoin$LeftRightEndSubscriber(this, true, i4);
                            this.disposables.ad(flowableGroupJoin$LeftRightEndSubscriber);
                            publisher.subscribe(flowableGroupJoin$LeftRightEndSubscriber);
                            if (this.error.get() != null) {
                                qwVar.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            try {
                                Object apply2 = this.resultSelector.apply(poll, i3);
                                th.de.p039if.ad.qw.rg(apply2, "The resultSelector returned a null value");
                                if (this.requested.get() != 0) {
                                    subscriber.onNext(apply2);
                                    th.de.p039if.yj.qw.rg(this.requested, 1);
                                    for (TRight onNext : this.rights.values()) {
                                        i3.onNext(onNext);
                                    }
                                } else {
                                    fail(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, qwVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fail(th2, subscriber, qwVar);
                                return;
                            }
                        } catch (Throwable th3) {
                            fail(th3, subscriber, qwVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i5 = this.rightIndex;
                        this.rightIndex = i5 + 1;
                        this.rights.put(Integer.valueOf(i5), poll);
                        try {
                            Object apply3 = this.rightEnd.apply(poll);
                            th.de.p039if.ad.qw.rg(apply3, "The rightEnd returned a null Publisher");
                            Publisher publisher2 = (Publisher) apply3;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, i5);
                            this.disposables.ad(flowableGroupJoin$LeftRightEndSubscriber2);
                            publisher2.subscribe(flowableGroupJoin$LeftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                qwVar.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            for (UnicastProcessor<TRight> onNext2 : this.lefts.values()) {
                                onNext2.onNext(poll);
                            }
                        } catch (Throwable th4) {
                            fail(th4, subscriber, qwVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        UnicastProcessor remove = this.lefts.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber3.index));
                        this.disposables.qw(flowableGroupJoin$LeftRightEndSubscriber3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber4 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber4.index));
                        this.disposables.qw(flowableGroupJoin$LeftRightEndSubscriber4);
                    }
                }
            }
            qwVar.clear();
        }
    }

    public void errorAll(Subscriber<?> subscriber) {
        Throwable ad2 = ExceptionHelper.ad(this.error);
        for (UnicastProcessor<TRight> onError : this.lefts.values()) {
            onError.onError(ad2);
        }
        this.lefts.clear();
        this.rights.clear();
        subscriber.onError(ad2);
    }

    public void fail(Throwable th2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
        th.de.o.qw.ad(th2);
        ExceptionHelper.qw(this.error, th2);
        simpleQueue.clear();
        cancelAll();
        errorAll(subscriber);
    }

    public void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            this.queue.m2355if(z ? LEFT_CLOSE : RIGHT_CLOSE, flowableGroupJoin$LeftRightEndSubscriber);
        }
        drain();
    }

    public void innerCloseError(Throwable th2) {
        if (ExceptionHelper.qw(this.error, th2)) {
            drain();
        } else {
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.de(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        drain();
    }

    public void innerError(Throwable th2) {
        if (ExceptionHelper.qw(this.error, th2)) {
            this.active.decrementAndGet();
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void innerValue(boolean z, Object obj) {
        synchronized (this) {
            this.queue.m2355if(z ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
        }
    }
}
