package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends th.de.p040switch.qw<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {

    /* renamed from: i  reason: collision with root package name */
    public static final qw f10185i = new i();

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10186ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<ReplayObserver<T>> f10187th;

    /* renamed from: uk  reason: collision with root package name */
    public final ObservableSource<T> f10188uk;

    /* renamed from: yj  reason: collision with root package name */
    public final qw<T> f10189yj;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements rg<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = (Node) head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add(NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        public final void error(Throwable th2) {
            addLast(new Node(enterTransform(NotificationLite.error(th2))));
            truncateFinal();
        }

        public Node getHead() {
            return (Node) get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        public final void removeFirst() {
            this.size--;
            setFirst((Node) ((Node) get()).get());
        }

        public final void removeSome(int i2) {
            Node node = (Node) get();
            while (i2 > 0) {
                node = (Node) node.get();
                i2--;
                this.size--;
            }
            setFirst(node);
        }

        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    Node node = (Node) innerDisposable.index();
                    if (node == null) {
                        node = getHead();
                        innerDisposable.index = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.index = node;
                            i2 = innerDisposable.addAndGet(-i2);
                        } else if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.index = null;
                    return;
                } while (i2 != 0);
            }
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public final void trimHead() {
            Node node = (Node) get();
            if (node.value != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void truncate();

        public void truncateFinal() {
            trimHead();
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = 2728361546769921047L;
        public volatile boolean cancelled;
        public final Observer<? super T> child;
        public Object index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
                this.index = null;
            }
        }

        public <U> U index() {
            return this.index;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        public static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        public static final long serialVersionUID = -533785617179540163L;
        public final rg<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplayObserver(rg<T> rgVar) {
            this.buffer = rgVar;
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                replayFinal();
            }
        }

        public void onError(Throwable th2) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th2);
                replayFinal();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                replay();
            }
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = EMPTY;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public void replay() {
            for (InnerDisposable replay : this.observers.get()) {
                this.buffer.replay(replay);
            }
        }

        public void replayFinal() {
            for (InnerDisposable replay : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final th.de.th scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i2, long j, TimeUnit timeUnit, th.de.th thVar) {
            this.scheduler = thVar;
            this.limit = i2;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        public Object enterTransform(Object obj) {
            return new th.de.vvv.ad(obj, this.scheduler.ad(this.unit), this.unit);
        }

        public Node getHead() {
            Node node;
            long ad2 = this.scheduler.ad(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    th.de.vvv.ad adVar = (th.de.vvv.ad) node2.value;
                    if (NotificationLite.isComplete(adVar.ad()) || NotificationLite.isError(adVar.ad()) || adVar.qw() > ad2) {
                        break;
                    }
                    obj = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        public Object leaveTransform(Object obj) {
            return ((th.de.vvv.ad) obj).ad();
        }

        public void truncate() {
            Node node;
            long ad2 = this.scheduler.ad(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i3 = this.size;
                    if (i3 <= this.limit) {
                        if (((th.de.vvv.ad) node2.value).qw() > ad2) {
                            break;
                        }
                        i2++;
                        this.size--;
                        node3 = (Node) node2.get();
                    } else {
                        i2++;
                        this.size = i3 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void truncateFinal() {
            /*
                r10 = this;
                th.de.th r0 = r10.scheduler
                java.util.concurrent.TimeUnit r1 = r10.unit
                long r0 = r0.ad(r1)
                long r2 = r10.maxAge
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003c
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L_0x003c
                java.lang.Object r5 = r2.value
                th.de.vvv.ad r5 = (th.de.vvv.ad) r5
                long r7 = r5.qw()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003c
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x003c:
                if (r4 == 0) goto L_0x0041
                r10.setFirst(r3)
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i2) {
            this.limit = i2;
        }

        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements rg<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.size++;
        }

        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.child;
                int i2 = 1;
                while (!innerDisposable.isDisposed()) {
                    int i3 = this.size;
                    Integer num = (Integer) innerDisposable.index();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i3) {
                        if (!NotificationLite.accept(get(intValue), observer) && !innerDisposable.isDisposed()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.index = Integer.valueOf(intValue);
                    i2 = innerDisposable.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public static final class ad<R> implements Consumer<Disposable> {

        /* renamed from: ad  reason: collision with root package name */
        public final ObserverResourceWrapper<R> f10190ad;

        public ad(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f10190ad = observerResourceWrapper;
        }

        /* renamed from: qw */
        public void accept(Disposable disposable) {
            this.f10190ad.setResource(disposable);
        }
    }

    public static final class de<R, U> extends th.de.rg<R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Callable<? extends th.de.p040switch.qw<U>> f10191ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super th.de.rg<U>, ? extends ObservableSource<R>> f10192th;

        public de(Callable<? extends th.de.p040switch.qw<U>> callable, Function<? super th.de.rg<U>, ? extends ObservableSource<R>> function) {
            this.f10191ad = callable;
            this.f10192th = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                Object call = this.f10191ad.call();
                th.de.p039if.ad.qw.rg(call, "The connectableFactory returned a null ConnectableObservable");
                th.de.p040switch.qw qwVar = (th.de.p040switch.qw) call;
                Object apply = this.f10192th.apply(qwVar);
                th.de.p039if.ad.qw.rg(apply, "The selector returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                qwVar.ad(new ad(observerResourceWrapper));
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
            }
        }
    }

    public static final class fe<T> extends th.de.p040switch.qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.p040switch.qw<T> f10193ad;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.rg<T> f10194th;

        public fe(th.de.p040switch.qw<T> qwVar, th.de.rg<T> rgVar) {
            this.f10193ad = qwVar;
            this.f10194th = rgVar;
        }

        public void ad(Consumer<? super Disposable> consumer) {
            this.f10193ad.ad(consumer);
        }

        public void subscribeActual(Observer<? super T> observer) {
            this.f10194th.subscribe(observer);
        }
    }

    public static final class i implements qw<Object> {
        public rg<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public interface qw<T> {
        rg<T> call();
    }

    public interface rg<T> {
        void complete();

        void error(Throwable th2);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    public static final class th<T> implements qw<T> {
        public final int qw;

        public th(int i2) {
            this.qw = i2;
        }

        public rg<T> call() {
            return new SizeBoundReplayBuffer(this.qw);
        }
    }

    public static final class uk<T> implements qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final long f10195ad;

        /* renamed from: de  reason: collision with root package name */
        public final TimeUnit f10196de;

        /* renamed from: fe  reason: collision with root package name */
        public final th.de.th f10197fe;
        public final int qw;

        public uk(int i2, long j, TimeUnit timeUnit, th.de.th thVar) {
            this.qw = i2;
            this.f10195ad = j;
            this.f10196de = timeUnit;
            this.f10197fe = thVar;
        }

        public rg<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.qw, this.f10195ad, this.f10196de, this.f10197fe);
        }
    }

    public static final class yj<T> implements ObservableSource<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicReference<ReplayObserver<T>> f10198ad;

        /* renamed from: th  reason: collision with root package name */
        public final qw<T> f10199th;

        public yj(AtomicReference<ReplayObserver<T>> atomicReference, qw<T> qwVar) {
            this.f10198ad = atomicReference;
            this.f10199th = qwVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(io.reactivex.Observer<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f10198ad
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0020
                io.reactivex.internal.operators.observable.ObservableReplay$qw<T> r0 = r3.f10199th
                io.reactivex.internal.operators.observable.ObservableReplay$rg r0 = r0.call()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f10198ad
                r2 = 0
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r1
            L_0x0020:
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.add(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0035
                r0.remove(r1)
                return
            L_0x0035:
                io.reactivex.internal.operators.observable.ObservableReplay$rg<T> r4 = r0.buffer
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.yj.subscribe(io.reactivex.Observer):void");
        }
    }

    public ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, qw<T> qwVar) {
        this.f10188uk = observableSource;
        this.f10186ad = observableSource2;
        this.f10187th = atomicReference;
        this.f10189yj = qwVar;
    }

    public static <T> th.de.p040switch.qw<T> i(ObservableSource<T> observableSource, qw<T> qwVar) {
        AtomicReference atomicReference = new AtomicReference();
        return th.de.ppp.qw.ggg(new ObservableReplay(new yj(atomicReference, qwVar), observableSource, atomicReference, qwVar));
    }

    /* renamed from: if  reason: not valid java name */
    public static <T> th.de.p040switch.qw<T> m1142if(th.de.p040switch.qw<T> qwVar, th.de.th thVar) {
        return th.de.ppp.qw.ggg(new fe(qwVar, qwVar.observeOn(thVar)));
    }

    public static <T> th.de.p040switch.qw<T> o(ObservableSource<? extends T> observableSource) {
        return i(observableSource, f10185i);
    }

    public static <U, R> th.de.rg<R> pf(Callable<? extends th.de.p040switch.qw<U>> callable, Function<? super th.de.rg<U>, ? extends ObservableSource<R>> function) {
        return th.de.ppp.qw.when(new de(callable, function));
    }

    public static <T> th.de.p040switch.qw<T> rg(ObservableSource<T> observableSource, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return o(observableSource);
        }
        return i(observableSource, new th(i2));
    }

    public static <T> th.de.p040switch.qw<T> th(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th.de.th thVar) {
        return uk(observableSource, j, timeUnit, thVar, Integer.MAX_VALUE);
    }

    public static <T> th.de.p040switch.qw<T> uk(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th.de.th thVar, int i2) {
        return i(observableSource, new uk(i2, j, timeUnit, thVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.f10187th
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservableReplay$qw<T> r1 = r4.f10189yj
            io.reactivex.internal.operators.observable.ObservableReplay$rg r1 = r1.call()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.f10187th
            boolean r0 = r1.compareAndSet(r0, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            r5.accept(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            io.reactivex.ObservableSource<T> r5 = r4.f10186ad
            r5.subscribe(r0)
        L_0x0044:
            return
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.shouldConnect
            r0.compareAndSet(r2, r3)
        L_0x004d:
            th.de.o.qw.ad(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.fe(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.ad(io.reactivex.functions.Consumer):void");
    }

    public void qw(Disposable disposable) {
        this.f10187th.compareAndSet((ReplayObserver) disposable, (Object) null);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10188uk.subscribe(observer);
    }
}
