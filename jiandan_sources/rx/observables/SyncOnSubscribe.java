package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.fe.qw;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscription;

public abstract class SyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    public static final class SubscriptionProducer<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final de<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(de<? super T> deVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = deVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.de(this.state);
            } catch (Throwable th2) {
                qw.rg(th2);
                p041if.uk.de.i(th2);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            de<? super T> deVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th2) {
                    handleThrownError(deVar, th2);
                    return;
                }
            } while (!tryUnsubscribe());
        }

        private void handleThrownError(de<? super T> deVar, Throwable th2) {
            if (this.hasTerminated) {
                p041if.uk.de.i(th2);
                return;
            }
            this.hasTerminated = true;
            deVar.onError(th2);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.ad(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            de<? super T> deVar = this.actualSubscriber;
            do {
                long j2 = j;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                        if (!tryUnsubscribe()) {
                            if (this.onNextCalled) {
                                j2--;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        handleThrownError(deVar, th2);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        private boolean tryUnsubscribe() {
            if (!this.hasTerminated && get() >= -1) {
                return false;
            }
            set(-1);
            doUnsubscribe();
            return true;
        }

        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onCompleted();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onError(Throwable th2) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onError(th2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        public void request(long j) {
            if (j > 0 && p041if.rg.qw.qw.ad(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        public void unsubscribe() {
            long j;
            do {
                j = get();
                if (compareAndSet(0, -1)) {
                    doUnsubscribe();
                    return;
                }
            } while (!compareAndSet(j, -2));
        }
    }

    public abstract S ad(S s, Observer<? super T> observer);

    public abstract void de(S s);
}
