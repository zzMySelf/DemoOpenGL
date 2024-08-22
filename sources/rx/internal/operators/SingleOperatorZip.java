package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class SingleOperatorZip {
    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singles, final FuncN<? extends R> zipper) {
        return Single.create(new Single.OnSubscribe<R>() {
            public void call(SingleSubscriber<? super R> subscriber) {
                if (singles.length == 0) {
                    subscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                final AtomicInteger wip = new AtomicInteger(singles.length);
                final AtomicBoolean once = new AtomicBoolean();
                Object[] values = new Object[singles.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                subscriber.add(compositeSubscription);
                int i2 = 0;
                while (i2 < singles.length && !compositeSubscription.isUnsubscribed() && !once.get()) {
                    final int j2 = i2;
                    final Object[] objArr = values;
                    final SingleSubscriber<? super R> singleSubscriber = subscriber;
                    SingleSubscriber<T> singleSubscriber2 = new SingleSubscriber<T>() {
                        public void onSuccess(T value) {
                            objArr[j2] = value;
                            if (wip.decrementAndGet() == 0) {
                                try {
                                    singleSubscriber.onSuccess(zipper.call(objArr));
                                } catch (Throwable e2) {
                                    Exceptions.throwIfFatal(e2);
                                    onError(e2);
                                }
                            }
                        }

                        public void onError(Throwable error) {
                            if (once.compareAndSet(false, true)) {
                                singleSubscriber.onError(error);
                            } else {
                                RxJavaHooks.onError(error);
                            }
                        }
                    };
                    compositeSubscription.add(singleSubscriber2);
                    if (!compositeSubscription.isUnsubscribed() && !once.get()) {
                        singles[i2].subscribe(singleSubscriber2);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        });
    }
}
