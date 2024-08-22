package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    final FirstTimeoutStub<T> firstTimeoutStub;
    final Observable<? extends T> other;
    final Scheduler scheduler;
    final TimeoutStub<T> timeoutStub;

    interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub2, TimeoutStub<T> timeoutStub2, Observable<? extends T> other2, Scheduler scheduler2) {
        this.firstTimeoutStub = firstTimeoutStub2;
        this.timeoutStub = timeoutStub2;
        this.other = other2;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker inner = this.scheduler.createWorker();
        subscriber.add(inner);
        SerializedSubscriber<T> synchronizedSubscriber = new SerializedSubscriber<>(subscriber);
        SerialSubscription serial = new SerialSubscription();
        synchronizedSubscriber.add(serial);
        TimeoutSubscriber<T> timeoutSubscriber = new TimeoutSubscriber<>(synchronizedSubscriber, this.timeoutStub, serial, this.other, inner);
        synchronizedSubscriber.add(timeoutSubscriber);
        synchronizedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serial.set((Subscription) this.firstTimeoutStub.call(timeoutSubscriber, 0L, inner));
        return timeoutSubscriber;
    }

    static final class TimeoutSubscriber<T> extends Subscriber<T> {
        long actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Scheduler.Worker inner;
        final Observable<? extends T> other;
        final SerialSubscription serial;
        final SerializedSubscriber<T> serializedSubscriber;
        boolean terminated;
        final TimeoutStub<T> timeoutStub;

        TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber2, TimeoutStub<T> timeoutStub2, SerialSubscription serial2, Observable<? extends T> other2, Scheduler.Worker inner2) {
            this.serializedSubscriber = serializedSubscriber2;
            this.timeoutStub = timeoutStub2;
            this.serial = serial2;
            this.other = other2;
            this.inner = inner2;
        }

        public void setProducer(Producer p) {
            this.arbiter.setProducer(p);
        }

        public void onNext(T value) {
            long a2;
            boolean onNextWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    a2 = this.actual + 1;
                    this.actual = a2;
                    onNextWins = true;
                } else {
                    a2 = this.actual;
                }
            }
            if (onNextWins) {
                this.serializedSubscriber.onNext(value);
                this.serial.set((Subscription) this.timeoutStub.call(this, Long.valueOf(a2), value, this.inner));
            }
        }

        public void onError(Throwable error) {
            boolean onErrorWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onErrorWins = true;
                }
            }
            if (onErrorWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(error);
            }
        }

        public void onCompleted() {
            boolean onCompletedWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onCompletedWins = true;
                }
            }
            if (onCompletedWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        public void onTimeout(long seqId) {
            long expected = seqId;
            boolean timeoutWins = false;
            synchronized (this) {
                if (expected == this.actual && !this.terminated) {
                    this.terminated = true;
                    timeoutWins = true;
                }
            }
            if (!timeoutWins) {
                return;
            }
            if (this.other == null) {
                this.serializedSubscriber.onError(new TimeoutException());
                return;
            }
            Subscriber<T> second = new Subscriber<T>() {
                public void onNext(T t) {
                    TimeoutSubscriber.this.serializedSubscriber.onNext(t);
                }

                public void onError(Throwable e2) {
                    TimeoutSubscriber.this.serializedSubscriber.onError(e2);
                }

                public void onCompleted() {
                    TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                }

                public void setProducer(Producer p) {
                    TimeoutSubscriber.this.arbiter.setProducer(p);
                }
            };
            this.other.unsafeSubscribe(second);
            this.serial.set(second);
        }
    }
}
