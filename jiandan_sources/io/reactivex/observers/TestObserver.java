package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: if  reason: not valid java name */
    public final Observer<? super T> f483if;

    /* renamed from: switch  reason: not valid java name */
    public final AtomicReference<Disposable> f484switch;
    public QueueDisposable<T> when;

    public enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f484switch);
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f484switch.get());
    }

    public void onComplete() {
        if (!this.f10323i) {
            this.f10323i = true;
            if (this.f484switch.get() == null) {
                this.f10328yj.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.f10327uk++;
            this.f483if.onComplete();
        } finally {
            this.f10322ad.countDown();
        }
    }

    public void onError(Throwable th2) {
        if (!this.f10323i) {
            this.f10323i = true;
            if (this.f484switch.get() == null) {
                this.f10328yj.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th2 == null) {
                this.f10328yj.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f10328yj.add(th2);
            }
            this.f483if.onError(th2);
        } finally {
            this.f10322ad.countDown();
        }
    }

    public void onNext(T t) {
        if (!this.f10323i) {
            this.f10323i = true;
            if (this.f484switch.get() == null) {
                this.f10328yj.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.f10325pf == 2) {
            while (true) {
                try {
                    T poll = this.when.poll();
                    if (poll != null) {
                        this.f10326th.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    this.f10328yj.add(th2);
                    this.when.dispose();
                    return;
                }
            }
        } else {
            this.f10326th.add(t);
            if (t == null) {
                this.f10328yj.add(new NullPointerException("onNext received a null value"));
            }
            this.f483if.onNext(t);
        }
    }

    public void onSubscribe(Disposable disposable) {
        Thread.currentThread();
        if (disposable == null) {
            this.f10328yj.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f484switch.compareAndSet((Object) null, disposable)) {
            disposable.dispose();
            if (this.f484switch.get() != DisposableHelper.DISPOSED) {
                this.f10328yj.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i2 = this.f10324o;
            if (i2 != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.when = queueDisposable;
                int requestFusion = queueDisposable.requestFusion(i2);
                this.f10325pf = requestFusion;
                if (requestFusion == 1) {
                    this.f10323i = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.when.poll();
                            if (poll != null) {
                                this.f10326th.add(poll);
                            } else {
                                this.f10327uk++;
                                this.f484switch.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th2) {
                            this.f10328yj.add(th2);
                            return;
                        }
                    }
                }
            }
            this.f483if.onSubscribe(disposable);
        }
    }

    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public TestObserver(Observer<? super T> observer) {
        this.f484switch = new AtomicReference<>();
        this.f483if = observer;
    }
}
