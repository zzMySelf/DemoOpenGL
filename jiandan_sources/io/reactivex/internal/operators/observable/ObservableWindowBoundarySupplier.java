package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;
import th.de.when.ad;

public final class ObservableWindowBoundarySupplier<T, B> extends th.de.p039if.fe.rg.qw<T, rg<T>> {

    /* renamed from: th  reason: collision with root package name */
    public final Callable<? extends ObservableSource<B>> f10285th;

    /* renamed from: yj  reason: collision with root package name */
    public final int f10286yj;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final qw<Object, Object> BOUNDARY_DISPOSED = new qw<>((WindowBoundaryMainObserver) null);
        public static final Object NEXT_WINDOW = new Object();
        public static final long serialVersionUID = 2233020065421370272L;
        public final AtomicReference<qw<T, B>> boundaryObserver = new AtomicReference<>();
        public final int capacityHint;
        public volatile boolean done;
        public final Observer<? super rg<T>> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final Callable<? extends ObservableSource<B>> other;
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public Disposable upstream;
        public UnicastSubject<T> window;
        public final AtomicInteger windows = new AtomicInteger(1);

        public WindowBoundaryMainObserver(Observer<? super rg<T>> observer, int i2, Callable<? extends ObservableSource<B>> callable) {
            this.downstream = observer;
            this.capacityHint = i2;
            this.other = callable;
        }

        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        public void disposeBoundary() {
            Disposable andSet = this.boundaryObserver.getAndSet(BOUNDARY_DISPOSED);
            if (andSet != null && andSet != BOUNDARY_DISPOSED) {
                andSet.dispose();
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
                                try {
                                    Object call = this.other.call();
                                    th.de.p039if.ad.qw.rg(call, "The other Callable returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) call;
                                    qw qwVar = new qw(this);
                                    if (this.boundaryObserver.compareAndSet((Object) null, qwVar)) {
                                        observableSource.subscribe(qwVar);
                                        observer.onNext(th2);
                                    }
                                } catch (Throwable th3) {
                                    th.de.o.qw.ad(th3);
                                    atomicThrowable.addThrowable(th3);
                                    this.done = true;
                                }
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
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        public void innerError(Throwable th2) {
            this.upstream.dispose();
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerNext(qw<T, B> qwVar) {
            this.boundaryObserver.compareAndSet(qwVar, (Object) null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            disposeBoundary();
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
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    public static final class qw<T, B> extends ad<B> {

        /* renamed from: th  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f10287th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10288yj;

        public qw(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f10287th = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f10288yj) {
                this.f10288yj = true;
                this.f10287th.innerComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10288yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10288yj = true;
            this.f10287th.innerError(th2);
        }

        public void onNext(B b) {
            if (!this.f10288yj) {
                this.f10288yj = true;
                dispose();
                this.f10287th.innerNext(this);
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i2) {
        super(observableSource);
        this.f10285th = callable;
        this.f10286yj = i2;
    }

    public void subscribeActual(Observer<? super rg<T>> observer) {
        this.f10756ad.subscribe(new WindowBoundaryMainObserver(observer, this.f10286yj, this.f10285th));
    }
}
