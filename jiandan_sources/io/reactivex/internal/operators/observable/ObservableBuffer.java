package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends th.de.p039if.fe.rg.qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final int f10045th;

    /* renamed from: uk  reason: collision with root package name */
    public final Callable<U> f10046uk;

    /* renamed from: yj  reason: collision with root package name */
    public final int f10047yj;

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = -8223395059921494546L;
        public final Callable<U> bufferSupplier;
        public final ArrayDeque<U> buffers = new ArrayDeque<>();
        public final int count;
        public final Observer<? super U> downstream;
        public long index;
        public final int skip;
        public Disposable upstream;

        public BufferSkipObserver(Observer<? super U> observer, int i2, int i3, Callable<U> callable) {
            this.downstream = observer;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % ((long) this.skip) == 0) {
                try {
                    U call = this.bufferSupplier.call();
                    th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.buffers.offer((Collection) call);
                } catch (Throwable th2) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t);
                if (this.count <= collection.size()) {
                    it.remove();
                    this.downstream.onNext(collection);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class qw<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super U> f10048ad;

        /* renamed from: i  reason: collision with root package name */
        public int f10049i;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f10050o;

        /* renamed from: th  reason: collision with root package name */
        public final int f10051th;

        /* renamed from: uk  reason: collision with root package name */
        public U f10052uk;

        /* renamed from: yj  reason: collision with root package name */
        public final Callable<U> f10053yj;

        public qw(Observer<? super U> observer, int i2, Callable<U> callable) {
            this.f10048ad = observer;
            this.f10051th = i2;
            this.f10053yj = callable;
        }

        public void dispose() {
            this.f10050o.dispose();
        }

        public boolean isDisposed() {
            return this.f10050o.isDisposed();
        }

        public void onComplete() {
            U u = this.f10052uk;
            if (u != null) {
                this.f10052uk = null;
                if (!u.isEmpty()) {
                    this.f10048ad.onNext(u);
                }
                this.f10048ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f10052uk = null;
            this.f10048ad.onError(th2);
        }

        public void onNext(T t) {
            U u = this.f10052uk;
            if (u != null) {
                u.add(t);
                int i2 = this.f10049i + 1;
                this.f10049i = i2;
                if (i2 >= this.f10051th) {
                    this.f10048ad.onNext(u);
                    this.f10049i = 0;
                    qw();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10050o, disposable)) {
                this.f10050o = disposable;
                this.f10048ad.onSubscribe(this);
            }
        }

        public boolean qw() {
            try {
                U call = this.f10053yj.call();
                th.de.p039if.ad.qw.rg(call, "Empty buffer supplied");
                this.f10052uk = (Collection) call;
                return true;
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10052uk = null;
                Disposable disposable = this.f10050o;
                if (disposable == null) {
                    EmptyDisposable.error(th2, (Observer<?>) this.f10048ad);
                    return false;
                }
                disposable.dispose();
                this.f10048ad.onError(th2);
                return false;
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i2, int i3, Callable<U> callable) {
        super(observableSource);
        this.f10045th = i2;
        this.f10047yj = i3;
        this.f10046uk = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        int i2 = this.f10047yj;
        int i3 = this.f10045th;
        if (i2 == i3) {
            qw qwVar = new qw(observer, i3, this.f10046uk);
            if (qwVar.qw()) {
                this.f10756ad.subscribe(qwVar);
                return;
            }
            return;
        }
        this.f10756ad.subscribe(new BufferSkipObserver(observer, this.f10045th, this.f10047yj, this.f10046uk));
    }
}
