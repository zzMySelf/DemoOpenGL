package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.o;
import th.de.ppp.qw;

public final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    public static final FlowableReplay$InnerSubscription[] EMPTY = new FlowableReplay$InnerSubscription[0];
    public static final FlowableReplay$InnerSubscription[] TERMINATED = new FlowableReplay$InnerSubscription[0];
    public static final long serialVersionUID = 7224554242710036740L;
    public final o<T> buffer;
    public boolean done;
    public final AtomicInteger management = new AtomicInteger();
    public long maxChildRequested;
    public long maxUpstreamRequested;
    public final AtomicBoolean shouldConnect = new AtomicBoolean();
    public final AtomicReference<FlowableReplay$InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

    public FlowableReplay$ReplaySubscriber(o<T> oVar) {
        this.buffer = oVar;
    }

    public boolean add(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr2;
        if (flowableReplay$InnerSubscription != null) {
            do {
                flowableReplay$InnerSubscriptionArr = (FlowableReplay$InnerSubscription[]) this.subscribers.get();
                if (flowableReplay$InnerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = flowableReplay$InnerSubscriptionArr.length;
                flowableReplay$InnerSubscriptionArr2 = new FlowableReplay$InnerSubscription[(length + 1)];
                System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr2, 0, length);
                flowableReplay$InnerSubscriptionArr2[length] = flowableReplay$InnerSubscription;
            } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
            return true;
        }
        throw null;
    }

    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    public void manageRequests() {
        if (this.management.getAndIncrement() == 0) {
            int i2 = 1;
            while (!isDisposed()) {
                FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr = (FlowableReplay$InnerSubscription[]) this.subscribers.get();
                long j = this.maxChildRequested;
                long j2 = j;
                for (FlowableReplay$InnerSubscription flowableReplay$InnerSubscription : flowableReplay$InnerSubscriptionArr) {
                    j2 = Math.max(j2, flowableReplay$InnerSubscription.totalRequested.get());
                }
                long j3 = this.maxUpstreamRequested;
                Subscription subscription = (Subscription) get();
                long j4 = j2 - j;
                if (j4 != 0) {
                    this.maxChildRequested = j2;
                    if (subscription == null) {
                        long j5 = j3 + j4;
                        if (j5 < 0) {
                            j5 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j5;
                    } else if (j3 != 0) {
                        this.maxUpstreamRequested = 0;
                        subscription.request(j3 + j4);
                    } else {
                        subscription.request(j4);
                    }
                } else if (!(j3 == 0 || subscription == null)) {
                    this.maxUpstreamRequested = 0;
                    subscription.request(j3);
                }
                i2 = this.management.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.buffer.complete();
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(th2);
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            this.buffer.next(t);
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.get()) {
                this.buffer.replay(replay);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            manageRequests();
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.get()) {
                this.buffer.replay(replay);
            }
        }
    }

    public void remove(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr2;
        do {
            flowableReplay$InnerSubscriptionArr = (FlowableReplay$InnerSubscription[]) this.subscribers.get();
            int length = flowableReplay$InnerSubscriptionArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (flowableReplay$InnerSubscriptionArr[i3].equals(flowableReplay$InnerSubscription)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        flowableReplay$InnerSubscriptionArr2 = EMPTY;
                    } else {
                        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr3 = new FlowableReplay$InnerSubscription[(length - 1)];
                        System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr3, 0, i2);
                        System.arraycopy(flowableReplay$InnerSubscriptionArr, i2 + 1, flowableReplay$InnerSubscriptionArr3, i2, (length - i2) - 1);
                        flowableReplay$InnerSubscriptionArr2 = flowableReplay$InnerSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
    }
}
