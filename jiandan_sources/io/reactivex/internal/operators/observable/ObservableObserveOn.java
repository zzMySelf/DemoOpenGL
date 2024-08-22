package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import th.de.p039if.fe.rg.qw;
import th.de.p039if.th.uk;
import th.de.th;

public final class ObservableObserveOn<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final th f10156th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10157uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10158yj;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        public static final long serialVersionUID = 6576896619930983584L;
        public final int bufferSize;
        public final boolean delayError;
        public volatile boolean disposed;
        public volatile boolean done;
        public final Observer<? super T> downstream;
        public Throwable error;
        public boolean outputFused;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public Disposable upstream;
        public final th.de worker;

        public ObserveOnObserver(Observer<? super T> observer, th.de deVar, boolean z, int i2) {
            this.downstream = observer;
            this.worker = deVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (this.delayError) {
                    if (!z2) {
                        return false;
                    }
                    this.disposed = true;
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th2 != null) {
                    this.disposed = true;
                    this.queue.clear();
                    observer.onError(th2);
                    this.worker.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.disposed = true;
                    observer.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        public void clear() {
            this.queue.clear();
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drainFused() {
            int i2 = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th2 = this.error;
                if (this.delayError || !z || th2 == null) {
                    this.downstream.onNext(null);
                    if (z) {
                        this.disposed = true;
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            this.downstream.onError(th3);
                        } else {
                            this.downstream.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
        }

        public void drainNormal() {
            SimpleQueue<T> simpleQueue = this.queue;
            Observer<? super T> observer = this.downstream;
            int i2 = 1;
            while (!checkTerminated(this.done, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, observer)) {
                            if (z2) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        this.disposed = true;
                        this.upstream.dispose();
                        simpleQueue.clear();
                        observer.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            schedule();
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new th.de.p039if.rg.qw(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.ad(this);
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, th thVar, boolean z, int i2) {
        super(observableSource);
        this.f10156th = thVar;
        this.f10158yj = z;
        this.f10157uk = i2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        th thVar = this.f10156th;
        if (thVar instanceof uk) {
            this.f10756ad.subscribe(observer);
            return;
        }
        this.f10756ad.subscribe(new ObserveOnObserver(observer, thVar.qw(), this.f10158yj, this.f10157uk));
    }
}
