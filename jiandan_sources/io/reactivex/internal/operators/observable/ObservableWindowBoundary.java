package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;
import th.de.when.ad;

public final class ObservableWindowBoundary<T, B> extends th.de.p039if.fe.rg.qw<T, rg<T>> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<B> f10281th;

    /* renamed from: yj  reason: collision with root package name */
    public final int f10282yj;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final Object NEXT_WINDOW = new Object();
        public static final long serialVersionUID = 2233020065421370272L;
        public final qw<T, B> boundaryObserver = new qw<>(this);
        public final int capacityHint;
        public volatile boolean done;
        public final Observer<? super rg<T>> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public UnicastSubject<T> window;
        public final AtomicInteger windows = new AtomicInteger(1);

        public WindowBoundaryMainObserver(Observer<? super rg<T>> observer, int i2) {
            this.downstream = observer;
            this.capacityHint = i2;
        }

        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super rg<T>> observer = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i2 = 1;
                while (this.windows.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.window;
                    boolean z = this.done;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastSubject != null) {
                                    this.window = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.window = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != NEXT_WINDOW) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.window = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                UnicastSubject<T> th2 = UnicastSubject.th(this.capacityHint, this);
                                this.window = th2;
                                this.windows.getAndIncrement();
                                observer.onNext(th2);
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.window = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.window = null;
            }
        }

        public void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }

        public void innerError(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.boundaryObserver.dispose();
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.upstream, disposable)) {
                innerNext();
            }
        }

        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public static final class qw<T, B> extends ad<B> {

        /* renamed from: th  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f10283th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10284yj;

        public qw(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f10283th = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f10284yj) {
                this.f10284yj = true;
                this.f10283th.innerComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10284yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10284yj = true;
            this.f10283th.innerError(th2);
        }

        public void onNext(B b) {
            if (!this.f10284yj) {
                this.f10283th.innerNext();
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i2) {
        super(observableSource);
        this.f10281th = observableSource2;
        this.f10282yj = i2;
    }

    public void subscribeActual(Observer<? super rg<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f10282yj);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.f10281th.subscribe(windowBoundaryMainObserver.boundaryObserver);
        this.f10756ad.subscribe(windowBoundaryMainObserver);
    }
}
