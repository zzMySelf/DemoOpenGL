package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import p041if.qw;
import rx.Observable;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;

public final class ScalarSynchronousObservable<T> extends Observable<T> {

    /* renamed from: th  reason: collision with root package name */
    public final T f11471th;

    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        public static final long serialVersionUID = -2466317989629281651L;
        public final p041if.de<? super T> actual;
        public final Func1<Action0, Subscription> onSchedule;
        public final T value;

        public ScalarAsyncProducer(p041if.de<? super T> deVar, T t, Func1<Action0, Subscription> func1) {
            this.actual = deVar;
            this.value = t;
            this.onSchedule = func1;
        }

        public void call() {
            p041if.de<? super T> deVar = this.actual;
            if (!deVar.isUnsubscribed()) {
                T t = this.value;
                try {
                    deVar.onNext(t);
                    if (!deVar.isUnsubscribed()) {
                        deVar.onCompleted();
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.yj(th2, deVar, t);
                }
            }
        }

        public void request(long j) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + "]";
        }
    }

    public class ad implements Func1<Action0, Subscription> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ p041if.qw f11472ad;

        public class qw implements Action0 {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Action0 f11473ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ qw.C0349qw f11474th;

            public qw(ad adVar, Action0 action0, qw.C0349qw qwVar) {
                this.f11473ad = action0;
                this.f11474th = qwVar;
            }

            public void call() {
                try {
                    this.f11473ad.call();
                } finally {
                    this.f11474th.unsubscribe();
                }
            }
        }

        public ad(ScalarSynchronousObservable scalarSynchronousObservable, p041if.qw qwVar) {
            this.f11472ad = qwVar;
        }

        /* renamed from: ad */
        public Subscription call(Action0 action0) {
            qw.C0349qw qw2 = this.f11472ad.qw();
            qw2.de(new qw(this, action0, qw2));
            return qw2;
        }
    }

    public static final class de<T> implements Observable.OnSubscribe<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final T f11475ad;

        /* renamed from: th  reason: collision with root package name */
        public final Func1<Action0, Subscription> f11476th;

        public de(T t, Func1<Action0, Subscription> func1) {
            this.f11475ad = t;
            this.f11476th = func1;
        }

        /* renamed from: ad */
        public void call(p041if.de<? super T> deVar) {
            deVar.setProducer(new ScalarAsyncProducer(deVar, this.f11475ad, this.f11476th));
        }
    }

    public class qw implements Func1<Action0, Subscription> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ p041if.rg.de.ad f11477ad;

        public qw(ScalarSynchronousObservable scalarSynchronousObservable, p041if.rg.de.ad adVar) {
            this.f11477ad = adVar;
        }

        /* renamed from: ad */
        public Subscription call(Action0 action0) {
            return this.f11477ad.de(action0);
        }
    }

    static {
        Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    }

    public Observable<T> qqq(p041if.qw qwVar) {
        Func1 func1;
        if (qwVar instanceof p041if.rg.de.ad) {
            func1 = new qw(this, (p041if.rg.de.ad) qwVar);
        } else {
            func1 = new ad(this, qwVar);
        }
        return Observable.ad(new de(this.f11471th, func1));
    }
}
