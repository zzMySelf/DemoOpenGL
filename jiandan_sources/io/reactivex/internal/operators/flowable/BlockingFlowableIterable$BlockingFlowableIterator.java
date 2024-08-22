package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.ad;

public final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
    public static final long serialVersionUID = 6695226475494099826L;
    public final long batchSize;
    public final Condition condition;
    public volatile boolean done;
    public Throwable error;
    public final long limit;
    public final Lock lock;
    public long produced;
    public final SpscArrayQueue<T> queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int i2) {
        this.queue = new SpscArrayQueue<>(i2);
        this.batchSize = (long) i2;
        this.limit = (long) (i2 - (i2 >> 2));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean hasNext() {
        while (true) {
            boolean z = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    throw ExceptionHelper.fe(th2);
                } else if (isEmpty) {
                    return false;
                }
            }
            if (!isEmpty) {
                return true;
            }
            ad.ad();
            this.lock.lock();
            while (!this.done && this.queue.isEmpty()) {
                try {
                    this.condition.await();
                } catch (InterruptedException e) {
                    run();
                    throw ExceptionHelper.fe(e);
                } catch (Throwable th3) {
                    this.lock.unlock();
                    throw th3;
                }
            }
            this.lock.unlock();
        }
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public T next() {
        if (hasNext()) {
            T poll = this.queue.poll();
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0;
                ((Subscription) get()).request(j);
            } else {
                this.produced = j;
            }
            return poll;
        }
        throw new NoSuchElementException();
    }

    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        signalConsumer();
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            SubscriptionHelper.cancel(this);
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        }
        signalConsumer();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, this.batchSize);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
