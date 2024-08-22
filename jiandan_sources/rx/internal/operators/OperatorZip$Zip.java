package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.pf.ad;
import p041if.rg.fe.th;
import rx.Observable;
import rx.Observer;
import rx.exceptions.MissingBackpressureException;
import rx.functions.FuncN;

public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = ((int) (((double) th.f11231yj) * 0.7d));
    public static final long serialVersionUID = 5995274816189928317L;
    public final Observer<? super R> child;
    public final ad childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final FuncN<? extends R> zipFunction;

    public final class qw extends de {

        /* renamed from: ad  reason: collision with root package name */
        public final th f11444ad = th.qw();

        public qw() {
        }

        public void de(long j) {
            request(j);
        }

        public void onCompleted() {
            this.f11444ad.fe();
            OperatorZip$Zip.this.tick();
        }

        public void onError(Throwable th2) {
            OperatorZip$Zip.this.child.onError(th2);
        }

        public void onNext(Object obj) {
            try {
                this.f11444ad.rg(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        public void onStart() {
            request((long) th.f11231yj);
        }
    }

    public OperatorZip$Zip(de<? super R> deVar, FuncN<? extends R> funcN) {
        ad adVar = new ad();
        this.childSubscription = adVar;
        this.child = deVar;
        this.zipFunction = funcN;
        deVar.add(adVar);
    }

    public void start(Observable[] observableArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[observableArr.length];
        for (int i2 = 0; i2 < observableArr.length; i2++) {
            qw qwVar = new qw();
            objArr[i2] = qwVar;
            this.childSubscription.qw(qwVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i3 = 0; i3 < observableArr.length; i3++) {
            observableArr[i3].aaa((qw) objArr[i3]);
        }
    }

    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            Observer<? super R> observer = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i2 = 0; i2 < length; i2++) {
                    th thVar = ((qw) objArr[i2]).f11444ad;
                    Object th2 = thVar.th();
                    if (th2 == null) {
                        z = false;
                    } else if (thVar.de(th2)) {
                        observer.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i2] = thVar.ad(th2);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        observer.onNext(this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            th thVar2 = ((qw) obj).f11444ad;
                            thVar2.yj();
                            if (thVar2.de(thVar2.th())) {
                                observer.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > THRESHOLD) {
                            for (Object obj2 : objArr) {
                                ((qw) obj2).de((long) this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th3) {
                        p041if.fe.qw.yj(th3, observer, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
