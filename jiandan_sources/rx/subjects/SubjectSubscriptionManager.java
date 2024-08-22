package rx.subjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.fe;
import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;

public final class SubjectSubscriptionManager<T> extends AtomicReference<ad<T>> implements Observable.OnSubscribe<T> {
    public static final long serialVersionUID = 6035251036011671568L;
    public boolean active = true;
    public volatile Object latest;
    public Action1<de<T>> onAdded = Actions.qw();
    public Action1<de<T>> onStart = Actions.qw();
    public Action1<de<T>> onTerminated = Actions.qw();

    public static final class ad<T> {

        /* renamed from: de  reason: collision with root package name */
        public static final de[] f11479de;

        /* renamed from: fe  reason: collision with root package name */
        public static final ad f11480fe;

        /* renamed from: rg  reason: collision with root package name */
        public static final ad f11481rg = new ad(false, f11479de);

        /* renamed from: ad  reason: collision with root package name */
        public final de[] f11482ad;
        public final boolean qw;

        static {
            de[] deVarArr = new de[0];
            f11479de = deVarArr;
            f11480fe = new ad(true, deVarArr);
        }

        public ad(boolean z, de[] deVarArr) {
            this.qw = z;
            this.f11482ad = deVarArr;
        }

        public ad ad(de deVar) {
            de[] deVarArr = this.f11482ad;
            if (r1 == 1 && deVarArr[0] == deVar) {
                return f11481rg;
            }
            if (r1 == 0) {
                return this;
            }
            int i2 = r1 - 1;
            de[] deVarArr2 = new de[i2];
            int i3 = 0;
            for (de deVar2 : deVarArr) {
                if (deVar2 != deVar) {
                    if (i3 == i2) {
                        return this;
                    }
                    deVarArr2[i3] = deVar2;
                    i3++;
                }
            }
            if (i3 == 0) {
                return f11481rg;
            }
            if (i3 < i2) {
                de[] deVarArr3 = new de[i3];
                System.arraycopy(deVarArr2, 0, deVarArr3, 0, i3);
                deVarArr2 = deVarArr3;
            }
            return new ad(this.qw, deVarArr2);
        }

        public ad qw(de deVar) {
            de[] deVarArr = this.f11482ad;
            int length = deVarArr.length;
            de[] deVarArr2 = new de[(length + 1)];
            System.arraycopy(deVarArr, 0, deVarArr2, 0, length);
            deVarArr2[length] = deVar;
            return new ad(this.qw, deVarArr2);
        }
    }

    public static final class de<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final p041if.de<? super T> f11483ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11484i;

        /* renamed from: th  reason: collision with root package name */
        public boolean f11485th = true;

        /* renamed from: uk  reason: collision with root package name */
        public List<Object> f11486uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f11487yj;

        public de(p041if.de<? super T> deVar) {
            this.f11483ad = deVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            de((java.util.List<java.lang.Object>) null, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void ad(java.lang.Object r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.f11485th     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r1.f11487yj     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                r0 = 0
                r1.f11485th = r0     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0010
                r0 = 1
            L_0x0010:
                r1.f11487yj = r0     // Catch:{ all -> 0x001c }
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0019
                r0 = 0
                r1.de(r0, r2)
            L_0x0019:
                return
            L_0x001a:
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.de.ad(java.lang.Object):void");
        }

        public void de(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object qw : list) {
                            qw(qw);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.f11487yj = false;
                            }
                        }
                        throw th;
                    }
                }
                if (z2) {
                    qw(obj);
                    z2 = false;
                }
                synchronized (this) {
                    try {
                        list = this.f11486uk;
                        this.f11486uk = null;
                        if (list == null) {
                            this.f11487yj = false;
                            try {
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.f11484i = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void fe(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r1.f11484i
                if (r0 != 0) goto L_0x0026
                monitor-enter(r1)
                r0 = 0
                r1.f11485th = r0     // Catch:{ all -> 0x0023 }
                boolean r0 = r1.f11487yj     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r0 = r1.f11486uk     // Catch:{ all -> 0x0023 }
                if (r0 != 0) goto L_0x0017
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
                r0.<init>()     // Catch:{ all -> 0x0023 }
                r1.f11486uk = r0     // Catch:{ all -> 0x0023 }
            L_0x0017:
                java.util.List<java.lang.Object> r0 = r1.f11486uk     // Catch:{ all -> 0x0023 }
                r0.add(r2)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                r0 = 1
                r1.f11484i = r0
                goto L_0x0026
            L_0x0023:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                throw r2
            L_0x0026:
                if.de<? super T> r0 = r1.f11483ad
                rx.internal.operators.NotificationLite.qw(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.de.fe(java.lang.Object):void");
        }

        public void onCompleted() {
            this.f11483ad.onCompleted();
        }

        public void onError(Throwable th2) {
            this.f11483ad.onError(th2);
        }

        public void onNext(T t) {
            this.f11483ad.onNext(t);
        }

        public void qw(Object obj) {
            if (obj != null) {
                NotificationLite.qw(this.f11483ad, obj);
            }
        }
    }

    public class qw implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ de f11488ad;

        public qw(de deVar) {
            this.f11488ad = deVar;
        }

        public void call() {
            SubjectSubscriptionManager.this.remove(this.f11488ad);
        }
    }

    public SubjectSubscriptionManager() {
        super(ad.f11481rg);
    }

    public boolean add(de<T> deVar) {
        ad adVar;
        do {
            adVar = (ad) get();
            if (adVar.qw) {
                this.onTerminated.call(deVar);
                return false;
            }
        } while (!compareAndSet(adVar, adVar.qw(deVar)));
        this.onAdded.call(deVar);
        return true;
    }

    public void addUnsubscriber(p041if.de<? super T> deVar, de<T> deVar2) {
        deVar.add(fe.qw(new qw(deVar2)));
    }

    public Object getLatest() {
        return this.latest;
    }

    public de<T>[] next(Object obj) {
        setLatest(obj);
        return ((ad) get()).f11482ad;
    }

    public de<T>[] observers() {
        return ((ad) get()).f11482ad;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.subjects.SubjectSubscriptionManager.de<T> r3) {
        /*
            r2 = this;
        L_0x0000:
            java.lang.Object r0 = r2.get()
            rx.subjects.SubjectSubscriptionManager$ad r0 = (rx.subjects.SubjectSubscriptionManager.ad) r0
            boolean r1 = r0.qw
            if (r1 == 0) goto L_0x000b
            return
        L_0x000b:
            rx.subjects.SubjectSubscriptionManager$ad r1 = r0.ad(r3)
            if (r1 == r0) goto L_0x0017
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 == 0) goto L_0x0000
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.remove(rx.subjects.SubjectSubscriptionManager$de):void");
    }

    public void setLatest(Object obj) {
        this.latest = obj;
    }

    public de<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (((ad) get()).qw) {
            return ad.f11479de;
        }
        return ((ad) getAndSet(ad.f11480fe)).f11482ad;
    }

    public void call(p041if.de<? super T> deVar) {
        de deVar2 = new de(deVar);
        addUnsubscriber(deVar, deVar2);
        this.onStart.call(deVar2);
        if (!deVar.isUnsubscribed() && add(deVar2) && deVar.isUnsubscribed()) {
            remove(deVar2);
        }
    }
}
