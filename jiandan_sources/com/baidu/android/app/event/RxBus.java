package com.baidu.android.app.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p041if.o.de;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class RxBus {
    public static final boolean DEBUG = false;
    public static final String TAG = "RxBus";
    public static volatile RxBus mInstance;
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, Observable>> mObservables = new ConcurrentHashMap<>();
    public final de<Object, Object> mRxBusSubject = new de<>(PublishSubject.eee());
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, List<p041if.de>>> mSubscribers = new ConcurrentHashMap<>();

    public class Remover implements Subscription {
        public boolean isUnsubscribed;
        public Subscription mSubscription;
        public Object mTag;
        public Class mType;

        public Remover(Object obj, Class cls, Subscription subscription) {
            this.mTag = obj;
            this.mType = cls;
            this.mSubscription = subscription;
        }

        public boolean isUnsubscribed() {
            return this.isUnsubscribed;
        }

        public void unsubscribe() {
            if (!this.mSubscription.isUnsubscribed()) {
                this.mSubscription.unsubscribe();
            }
            RxBus.this.unregister(this.mTag, this.mType);
            this.isUnsubscribed = true;
        }
    }

    public class TagKeeperOperator<T> implements Observable.Operator<T, T> {
        public final Object tag;
        public final Class<T> type;

        public TagKeeperOperator(Object obj, Class<T> cls) {
            this.tag = obj;
            this.type = cls;
        }

        public p041if.de<? super T> call(final p041if.de<? super T> deVar) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) RxBus.this.mSubscribers.get(this.tag);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) RxBus.this.mSubscribers.putIfAbsent(this.tag, concurrentHashMap);
                if (concurrentHashMap2 != null) {
                    concurrentHashMap = concurrentHashMap2;
                }
            }
            List list = (List) concurrentHashMap.get(this.type);
            if (list == null) {
                list = new ArrayList();
                List list2 = (List) concurrentHashMap.putIfAbsent(this.type, list);
                if (list2 != null) {
                    list = list2;
                }
            }
            AnonymousClass1 r0 = new p041if.de<T>() {
                public void onCompleted() {
                    if (!deVar.isUnsubscribed()) {
                        deVar.onCompleted();
                    }
                }

                public void onError(Throwable th2) {
                    if (!deVar.isUnsubscribed()) {
                        deVar.onError(th2);
                    }
                }

                public void onNext(T t) {
                    if (!deVar.isUnsubscribed()) {
                        deVar.onNext(t);
                    }
                }
            };
            r0.add(new Remover(this.tag, this.type, deVar));
            list.add(r0);
            return r0;
        }
    }

    private <T> void clearObservables(Object obj, Class<T> cls) {
        ConcurrentHashMap concurrentHashMap = this.mObservables.get(obj);
        if (concurrentHashMap != null) {
            if (cls == null) {
                concurrentHashMap.clear();
            } else {
                concurrentHashMap.remove(cls);
            }
            if (concurrentHashMap.isEmpty()) {
                this.mObservables.remove(obj);
            }
        }
    }

    private <T> void clearSubscriberAndUnsubscribe(Object obj, Class<T> cls) {
        Collection<List> values;
        ConcurrentHashMap concurrentHashMap = this.mSubscribers.get(obj);
        if (concurrentHashMap != null) {
            if (cls == null) {
                ConcurrentHashMap remove = this.mSubscribers.remove(obj);
                if (remove != null && (values = remove.values()) != null && !values.isEmpty()) {
                    for (List<p041if.de> list : values) {
                        if (list != null && !list.isEmpty()) {
                            for (p041if.de deVar : list) {
                                if (deVar != null && !deVar.isUnsubscribed()) {
                                    deVar.unsubscribe();
                                }
                            }
                            list.clear();
                        }
                    }
                    values.clear();
                    return;
                }
                return;
            }
            List<p041if.de> list2 = (List) concurrentHashMap.remove(cls);
            if (list2 != null) {
                for (p041if.de deVar2 : list2) {
                    if (deVar2 != null && !deVar2.isUnsubscribed()) {
                        deVar2.unsubscribe();
                    }
                }
                list2.clear();
            }
        }
    }

    private <T> Observable<T> createObservable(final Object obj, Class<T> cls) {
        return this.mRxBusSubject.m2375if(cls).th(new TagKeeperOperator(obj, cls)).m2376switch().fe(new Action1<T>() {
            public void call(T t) {
            }
        }).xxx();
    }

    public static RxBus get() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    public <T> boolean isRegistered(Object obj, Class<T> cls) {
        ConcurrentHashMap concurrentHashMap;
        if (obj == null || cls == null || (concurrentHashMap = this.mObservables.get(obj)) == null || ((Observable) concurrentHashMap.get(cls)) == null) {
            return false;
        }
        return true;
    }

    public void post(Object obj) {
        if (obj != null) {
            this.mRxBusSubject.onNext(obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r0 = new java.util.concurrent.ConcurrentHashMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> rx.Observable<T> register(java.lang.Object r3, java.lang.Class<T> r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r4 != 0) goto L_0x0007
            return r0
        L_0x0007:
            java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.util.concurrent.ConcurrentHashMap<java.lang.Class, rx.Observable>> r0 = r2.mObservables
            java.lang.Object r0 = r0.get(r3)
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0
            if (r0 != 0) goto L_0x0021
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.util.concurrent.ConcurrentHashMap<java.lang.Class, rx.Observable>> r1 = r2.mObservables
            java.lang.Object r1 = r1.putIfAbsent(r3, r0)
            java.util.concurrent.ConcurrentHashMap r1 = (java.util.concurrent.ConcurrentHashMap) r1
            if (r1 == 0) goto L_0x0021
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.get(r4)
            rx.Observable r1 = (rx.Observable) r1
            if (r1 != 0) goto L_0x0036
            rx.Observable r1 = r2.createObservable(r3, r4)
            java.lang.Object r3 = r0.putIfAbsent(r4, r1)
            rx.Observable r3 = (rx.Observable) r3
            if (r3 == 0) goto L_0x0036
            r1 = r3
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.event.RxBus.register(java.lang.Object, java.lang.Class):rx.Observable");
    }

    public <T> void unregister(Object obj) {
        unregister(obj, (Class) null);
    }

    public <T> void unregister(Object obj, Class<T> cls) {
        if (obj != null) {
            clearObservables(obj, cls);
            clearSubscriberAndUnsubscribe(obj, cls);
        }
    }
}
