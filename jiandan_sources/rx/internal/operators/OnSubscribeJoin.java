package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p041if.de;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observable<TLeft> f11400ad;

    /* renamed from: i  reason: collision with root package name */
    public final Func2<TLeft, TRight, R> f11401i;

    /* renamed from: th  reason: collision with root package name */
    public final Observable<TRight> f11402th;

    /* renamed from: uk  reason: collision with root package name */
    public final Func1<TRight, Observable<TRightDuration>> f11403uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Func1<TLeft, Observable<TLeftDuration>> f11404yj;

    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public final p041if.pf.ad group = new p041if.pf.ad();
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap = new HashMap();
        public final de<? super R> subscriber;

        public final class ad extends de<TRight> {

            public final class qw extends de<TRightDuration> {

                /* renamed from: ad  reason: collision with root package name */
                public final int f11406ad;

                /* renamed from: th  reason: collision with root package name */
                public boolean f11407th = true;

                public qw(int i2) {
                    this.f11406ad = i2;
                }

                public void onCompleted() {
                    if (this.f11407th) {
                        this.f11407th = false;
                        ad.this.de(this.f11406ad, this);
                    }
                }

                public void onError(Throwable th2) {
                    ad.this.onError(th2);
                }

                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public ad() {
            }

            public void de(int i2, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.rightMap.remove(Integer.valueOf(i2)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone;
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.ad(subscription);
            }

            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    z = true;
                    ResultSink.this.rightDone = true;
                    if (!ResultSink.this.leftDone) {
                        if (!ResultSink.this.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.ad(this);
            }

            public void onError(Throwable th2) {
                ResultSink.this.subscriber.onError(th2);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TRight tright) {
                int i2;
                int i3;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i2 = resultSink.rightId;
                    resultSink.rightId = i2 + 1;
                    ResultSink.this.rightMap.put(Integer.valueOf(i2), tright);
                    i3 = ResultSink.this.leftId;
                }
                ResultSink.this.group.qw(new p041if.pf.de());
                try {
                    qw qwVar = new qw(i2);
                    ResultSink.this.group.qw(qwVar);
                    OnSubscribeJoin.this.f11403uk.call(tright).aaa(qwVar);
                    ArrayList<Object> arrayList = new ArrayList<>();
                    synchronized (ResultSink.this) {
                        for (Map.Entry entry : ResultSink.this.leftMap().entrySet()) {
                            if (((Integer) entry.getKey()).intValue() < i3) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object qw2 : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.f11401i.qw(qw2, tright));
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.th(th2, this);
                }
            }
        }

        public final class qw extends de<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$qw$qw  reason: collision with other inner class name */
            public final class C0363qw extends de<TLeftDuration> {

                /* renamed from: ad  reason: collision with root package name */
                public final int f11410ad;

                /* renamed from: th  reason: collision with root package name */
                public boolean f11411th = true;

                public C0363qw(int i2) {
                    this.f11410ad = i2;
                }

                public void onCompleted() {
                    if (this.f11411th) {
                        this.f11411th = false;
                        qw.this.de(this.f11410ad, this);
                    }
                }

                public void onError(Throwable th2) {
                    qw.this.onError(th2);
                }

                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public qw() {
            }

            public void de(int i2, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.leftMap().remove(Integer.valueOf(i2)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone;
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.ad(subscription);
            }

            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    z = true;
                    ResultSink.this.leftDone = true;
                    if (!ResultSink.this.rightDone) {
                        if (!ResultSink.this.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.ad(this);
            }

            public void onError(Throwable th2) {
                ResultSink.this.subscriber.onError(th2);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TLeft tleft) {
                int i2;
                int i3;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i2 = resultSink.leftId;
                    resultSink.leftId = i2 + 1;
                    ResultSink.this.leftMap().put(Integer.valueOf(i2), tleft);
                    i3 = ResultSink.this.rightId;
                }
                try {
                    C0363qw qwVar = new C0363qw(i2);
                    ResultSink.this.group.qw(qwVar);
                    OnSubscribeJoin.this.f11404yj.call(tleft).aaa(qwVar);
                    ArrayList<Object> arrayList = new ArrayList<>();
                    synchronized (ResultSink.this) {
                        for (Map.Entry next : ResultSink.this.rightMap.entrySet()) {
                            if (((Integer) next.getKey()).intValue() < i3) {
                                arrayList.add(next.getValue());
                            }
                        }
                    }
                    for (Object qw : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.f11401i.qw(tleft, qw));
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.th(th2, this);
                }
            }
        }

        public ResultSink(de<? super R> deVar) {
            this.subscriber = deVar;
        }

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            qw qwVar = new qw();
            ad adVar = new ad();
            this.group.qw(qwVar);
            this.group.qw(adVar);
            OnSubscribeJoin.this.f11400ad.aaa(qwVar);
            OnSubscribeJoin.this.f11402th.aaa(adVar);
        }
    }
}
