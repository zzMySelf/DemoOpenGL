package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p040switch.ad;

public final class ObservableGroupBy<T, K, V> extends th.de.p039if.fe.rg.qw<T, ad<K, V>> {

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10104i;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends K> f10105th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10106uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super T, ? extends V> f10107yj;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        public static final Object NULL_KEY = new Object();
        public static final long serialVersionUID = -3688291656102519502L;
        public final int bufferSize;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final boolean delayError;
        public final Observer<? super ad<K, V>> downstream;
        public final Map<Object, qw<K, V>> groups;
        public final Function<? super T, ? extends K> keySelector;
        public Disposable upstream;
        public final Function<? super T, ? extends V> valueSelector;

        public GroupByObserver(Observer<? super ad<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.downstream = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i2;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            ArrayList<qw> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (qw onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayList<qw> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (qw onError : arrayList) {
                onError.onError(th2);
            }
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            Object obj;
            try {
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                qw qwVar = this.groups.get(obj);
                if (qwVar == null) {
                    if (!this.cancelled.get()) {
                        qwVar = qw.ad(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, qwVar);
                        getAndIncrement();
                        this.downstream.onNext(qwVar);
                    } else {
                        return;
                    }
                }
                try {
                    Object apply2 = this.valueSelector.apply(t);
                    th.de.p039if.ad.qw.rg(apply2, "The value supplied is null");
                    qwVar.onNext(apply2);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.upstream.dispose();
                    onError(th2);
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.upstream.dispose();
                onError(th3);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        public static final long serialVersionUID = -3852313036005250360L;
        public final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final AtomicBoolean once = new AtomicBoolean();
        public final GroupByObserver<?, K, T> parent;
        public final th.de.p039if.rg.qw<T> queue;

        public State(int i2, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new th.de.p039if.rg.qw<>(i2);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet((Object) null);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        this.actual.lazySet((Object) null);
                        observer.onError(th2);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.actual.lazySet((Object) null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    this.actual.lazySet((Object) null);
                    if (th3 != null) {
                        observer.onError(th3);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet((Object) null);
                this.parent.cancel(this.key);
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                th.de.p039if.rg.qw<T> qwVar = this.queue;
                boolean z = this.delayError;
                Observer observer = this.actual.get();
                int i2 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z2 = this.done;
                            T poll = qwVar.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, observer, z)) {
                                if (z3) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        if (observer == null) {
                            observer = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.actual.lazySet(observer);
                if (this.cancelled.get()) {
                    this.actual.lazySet((Object) null);
                } else {
                    drain();
                }
            } else {
                EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (Observer<?>) observer);
            }
        }
    }

    public static final class qw<K, T> extends ad<K, T> {

        /* renamed from: th  reason: collision with root package name */
        public final State<T, K> f10108th;

        public qw(K k, State<T, K> state) {
            super(k);
            this.f10108th = state;
        }

        public static <T, K> qw<K, T> ad(K k, int i2, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new qw<>(k, new State(i2, groupByObserver, k, z));
        }

        public void onComplete() {
            this.f10108th.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10108th.onError(th2);
        }

        public void onNext(T t) {
            this.f10108th.onNext(t);
        }

        public void subscribeActual(Observer<? super T> observer) {
            this.f10108th.subscribe(observer);
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
        super(observableSource);
        this.f10105th = function;
        this.f10107yj = function2;
        this.f10106uk = i2;
        this.f10104i = z;
    }

    public void subscribeActual(Observer<? super ad<K, V>> observer) {
        this.f10756ad.subscribe(new GroupByObserver(observer, this.f10105th, this.f10107yj, this.f10106uk, this.f10104i));
    }
}
