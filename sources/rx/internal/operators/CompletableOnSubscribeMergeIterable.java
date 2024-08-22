package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> sources2) {
        this.sources = sources2;
    }

    public void call(CompletableSubscriber s) {
        CompositeSubscription set = new CompositeSubscription();
        s.onSubscribe(set);
        try {
            Iterator<? extends Completable> iterator = this.sources.iterator();
            if (iterator == null) {
                s.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            final AtomicInteger wip = new AtomicInteger(1);
            AtomicBoolean once = new AtomicBoolean();
            while (!set.isUnsubscribed()) {
                try {
                    if (!iterator.hasNext()) {
                        if (wip.decrementAndGet() == 0 && once.compareAndSet(false, true)) {
                            s.onCompleted();
                            return;
                        }
                        return;
                    } else if (!set.isUnsubscribed()) {
                        try {
                            Completable c2 = (Completable) iterator.next();
                            if (!set.isUnsubscribed()) {
                                if (c2 == null) {
                                    set.unsubscribe();
                                    NullPointerException npe = new NullPointerException("A completable source is null");
                                    if (once.compareAndSet(false, true)) {
                                        s.onError(npe);
                                        return;
                                    } else {
                                        RxJavaHooks.onError(npe);
                                        return;
                                    }
                                } else {
                                    wip.getAndIncrement();
                                    final CompositeSubscription compositeSubscription = set;
                                    final AtomicBoolean atomicBoolean = once;
                                    final CompletableSubscriber completableSubscriber = s;
                                    c2.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                                        public void onSubscribe(Subscription d2) {
                                            compositeSubscription.add(d2);
                                        }

                                        public void onError(Throwable e2) {
                                            compositeSubscription.unsubscribe();
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                completableSubscriber.onError(e2);
                                            } else {
                                                RxJavaHooks.onError(e2);
                                            }
                                        }

                                        public void onCompleted() {
                                            if (wip.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                                                completableSubscriber.onCompleted();
                                            }
                                        }
                                    });
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable e2) {
                            set.unsubscribe();
                            if (once.compareAndSet(false, true)) {
                                s.onError(e2);
                                return;
                            } else {
                                RxJavaHooks.onError(e2);
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable e3) {
                    set.unsubscribe();
                    if (once.compareAndSet(false, true)) {
                        s.onError(e3);
                        return;
                    } else {
                        RxJavaHooks.onError(e3);
                        return;
                    }
                }
            }
        } catch (Throwable e4) {
            s.onError(e4);
        }
    }
}
