package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p041if.de;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.OnSubscribe<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observable<T1> f11383ad;

    /* renamed from: i  reason: collision with root package name */
    public final Func2<? super T1, ? super Observable<T2>, ? extends R> f11384i;

    /* renamed from: th  reason: collision with root package name */
    public final Observable<T2> f11385th;

    /* renamed from: uk  reason: collision with root package name */
    public final Func1<? super T2, ? extends Observable<D2>> f11386uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Func1<? super T1, ? extends Observable<D1>> f11387yj;

    public final class ResultManager extends HashMap<Integer, Observer<T2>> implements Subscription {
        public static final long serialVersionUID = -3035156013812425335L;
        public final RefCountSubscription cancel;
        public final p041if.pf.ad group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final p041if.de<? super R> subscriber;

        public final class ad extends p041if.de<T1> {
            public ad() {
            }

            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager.this.leftDone = true;
                    if (ResultManager.this.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorAll(th2);
            }

            public void onNext(T1 t1) {
                int i2;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject eee = PublishSubject.eee();
                    p041if.yj.de deVar = new p041if.yj.de(eee);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i2 = resultManager.leftIds;
                        resultManager.leftIds = i2 + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i2), deVar);
                    }
                    Observable ad2 = Observable.ad(new qw(eee, ResultManager.this.cancel));
                    qw qwVar = new qw(i2);
                    ResultManager.this.group.qw(qwVar);
                    ((Observable) OnSubscribeGroupJoin.this.f11387yj.call(t1)).aaa(qwVar);
                    Object qw = OnSubscribeGroupJoin.this.f11384i.qw(t1, ad2);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList<>(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(qw);
                    for (Object onNext : arrayList) {
                        deVar.onNext(onNext);
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.th(th2, this);
                }
            }
        }

        public final class de extends p041if.de<D2> {

            /* renamed from: ad  reason: collision with root package name */
            public final int f11389ad;

            /* renamed from: th  reason: collision with root package name */
            public boolean f11390th = true;

            public de(int i2) {
                this.f11389ad = i2;
            }

            public void onCompleted() {
                if (this.f11390th) {
                    this.f11390th = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.f11389ad));
                    }
                    ResultManager.this.group.ad(this);
                }
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorMain(th2);
            }

            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        public final class fe extends p041if.de<T2> {
            public fe() {
            }

            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager.this.rightDone = true;
                    if (ResultManager.this.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorAll(th2);
            }

            public void onNext(T2 t2) {
                int i2;
                ArrayList<Observer> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i2 = resultManager.rightIds;
                        resultManager.rightIds = i2 + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i2), t2);
                    }
                    de deVar = new de(i2);
                    ResultManager.this.group.qw(deVar);
                    ((Observable) OnSubscribeGroupJoin.this.f11386uk.call(t2)).aaa(deVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList<>(ResultManager.this.leftMap().values());
                    }
                    for (Observer onNext : arrayList) {
                        onNext.onNext(t2);
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.th(th2, this);
                }
            }
        }

        public final class qw extends p041if.de<D1> {

            /* renamed from: ad  reason: collision with root package name */
            public final int f11393ad;

            /* renamed from: th  reason: collision with root package name */
            public boolean f11394th = true;

            public qw(int i2) {
                this.f11393ad = i2;
            }

            public void onCompleted() {
                Observer observer;
                if (this.f11394th) {
                    this.f11394th = false;
                    synchronized (ResultManager.this) {
                        observer = (Observer) ResultManager.this.leftMap().remove(Integer.valueOf(this.f11393ad));
                    }
                    if (observer != null) {
                        observer.onCompleted();
                    }
                    ResultManager.this.group.ad(this);
                }
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorMain(th2);
            }

            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        public ResultManager(p041if.de<? super R> deVar) {
            this.subscriber = deVar;
            this.group = new p041if.pf.ad();
            this.cancel = new RefCountSubscription(this.group);
        }

        public void complete(List<Observer<T2>> list) {
            if (list != null) {
                for (Observer<T2> onCompleted : list) {
                    onCompleted.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        public void errorAll(Throwable th2) {
            ArrayList<Observer> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (Observer onError : arrayList) {
                onError.onError(th2);
            }
            this.subscriber.onError(th2);
            this.cancel.unsubscribe();
        }

        public void errorMain(Throwable th2) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th2);
            this.cancel.unsubscribe();
        }

        public void init() {
            ad adVar = new ad();
            fe feVar = new fe();
            this.group.qw(adVar);
            this.group.qw(feVar);
            OnSubscribeGroupJoin.this.f11383ad.aaa(adVar);
            OnSubscribeGroupJoin.this.f11385th.aaa(feVar);
        }

        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        public Map<Integer, Observer<T2>> leftMap() {
            return this;
        }

        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    public static final class qw<T> implements Observable.OnSubscribe<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final RefCountSubscription f11396ad;

        /* renamed from: th  reason: collision with root package name */
        public final Observable<T> f11397th;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$qw$qw  reason: collision with other inner class name */
        public final class C0362qw extends de<T> {

            /* renamed from: ad  reason: collision with root package name */
            public final de<? super T> f11398ad;

            /* renamed from: th  reason: collision with root package name */
            public final Subscription f11399th;

            public C0362qw(qw qwVar, de<? super T> deVar, Subscription subscription) {
                super(deVar);
                this.f11398ad = deVar;
                this.f11399th = subscription;
            }

            public void onCompleted() {
                this.f11398ad.onCompleted();
                this.f11399th.unsubscribe();
            }

            public void onError(Throwable th2) {
                this.f11398ad.onError(th2);
                this.f11399th.unsubscribe();
            }

            public void onNext(T t) {
                this.f11398ad.onNext(t);
            }
        }

        public qw(Observable<T> observable, RefCountSubscription refCountSubscription) {
            this.f11396ad = refCountSubscription;
            this.f11397th = observable;
        }

        /* renamed from: ad */
        public void call(de<? super T> deVar) {
            Subscription qw = this.f11396ad.qw();
            C0362qw qwVar = new C0362qw(this, deVar, qw);
            qwVar.add(qw);
            this.f11397th.aaa(qwVar);
        }
    }
}
