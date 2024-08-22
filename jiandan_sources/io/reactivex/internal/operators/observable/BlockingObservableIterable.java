package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import th.de.p039if.rg.qw;
import th.de.p039if.yj.ad;

public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T> f10038ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f10039th;

    public static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        public static final long serialVersionUID = 6695226475494099826L;
        public final Condition condition;
        public volatile boolean done;
        public Throwable error;
        public final Lock lock;
        public final qw<T> queue;

        public BlockingObservableIterator(int i2) {
            this.queue = new qw<>(i2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
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
                        DisposableHelper.dispose(this);
                        signalConsumer();
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
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public T next() {
            if (hasNext()) {
                return this.queue.poll();
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
            this.queue.offer(t);
            signalConsumer();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
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

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i2) {
        this.f10038ad = observableSource;
        this.f10039th = i2;
    }

    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f10039th);
        this.f10038ad.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
