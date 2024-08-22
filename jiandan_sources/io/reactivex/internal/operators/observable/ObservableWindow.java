package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableWindow<T> extends qw<T, rg<T>> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10278th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10279uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10280yj;

    public static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final long serialVersionUID = -7481782523886138128L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final Observer<? super rg<T>> downstream;
        public long size;
        public Disposable upstream;
        public UnicastSubject<T> window;

        public WindowExactObserver(Observer<? super rg<T>> observer, long j, int i2) {
            this.downstream = observer;
            this.count = j;
            this.capacityHint = i2;
        }

        public void dispose() {
            this.cancelled = true;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th2);
            }
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject == null && !this.cancelled) {
                unicastSubject = UnicastSubject.th(this.capacityHint, this);
                this.window = unicastSubject;
                this.downstream.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.size + 1;
                this.size = j;
                if (j >= this.count) {
                    this.size = 0;
                    this.window = null;
                    unicastSubject.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        public static final long serialVersionUID = 3366976432059579510L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final Observer<? super rg<T>> downstream;
        public long firstEmission;
        public long index;
        public final long skip;
        public Disposable upstream;
        public final ArrayDeque<UnicastSubject<T>> windows;
        public final AtomicInteger wip = new AtomicInteger();

        public WindowSkipObserver(Observer<? super rg<T>> observer, long j, long j2, int i2) {
            this.downstream = observer;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i2;
            this.windows = new ArrayDeque<>();
        }

        public void dispose() {
            this.cancelled = true;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject th2 = UnicastSubject.th(this.capacityHint, this);
                arrayDeque.offer(th2);
                this.downstream.onNext(th2);
            }
            long j3 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.count) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.cancelled) {
                    this.firstEmission = j3 - j2;
                } else {
                    this.upstream.dispose();
                    return;
                }
            } else {
                this.firstEmission = j3;
            }
            this.index = j + 1;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j, long j2, int i2) {
        super(observableSource);
        this.f10278th = j;
        this.f10280yj = j2;
        this.f10279uk = i2;
    }

    public void subscribeActual(Observer<? super rg<T>> observer) {
        if (this.f10278th == this.f10280yj) {
            this.f10756ad.subscribe(new WindowExactObserver(observer, this.f10278th, this.f10279uk));
            return;
        }
        this.f10756ad.subscribe(new WindowSkipObserver(observer, this.f10278th, this.f10280yj, this.f10279uk));
    }
}
