package p041if.o;

import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

/* renamed from: if.o.qw  reason: invalid package */
public final class qw<T> extends fe<T, T> {

    /* renamed from: yj  reason: collision with root package name */
    public static final Object[] f11133yj = new Object[0];

    /* renamed from: th  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f11134th;

    /* renamed from: if.o.qw$qw  reason: collision with other inner class name */
    public static class C0347qw implements Action1<SubjectSubscriptionManager.de<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f11135ad;

        public C0347qw(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f11135ad = subjectSubscriptionManager;
        }

        /* renamed from: ad */
        public void call(SubjectSubscriptionManager.de<T> deVar) {
            deVar.ad(this.f11135ad.getLatest());
        }
    }

    public qw(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f11134th = subjectSubscriptionManager;
    }

    public static <T> qw<T> eee() {
        return rrr((Object) null, false);
    }

    public static <T> qw<T> rrr(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.uk(t));
        }
        C0347qw qwVar = new C0347qw(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = qwVar;
        subjectSubscriptionManager.onTerminated = qwVar;
        return new qw<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    public void onCompleted() {
        if (this.f11134th.getLatest() == null || this.f11134th.active) {
            Object ad2 = NotificationLite.ad();
            for (SubjectSubscriptionManager.de fe2 : this.f11134th.terminate(ad2)) {
                fe2.fe(ad2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f11134th.getLatest() == null || this.f11134th.active) {
            Object de2 = NotificationLite.de(th2);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.de fe2 : this.f11134th.terminate(de2)) {
                try {
                    fe2.fe(de2);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th3);
                }
            }
            p041if.fe.qw.fe(arrayList);
        }
    }

    public void onNext(T t) {
        if (this.f11134th.getLatest() == null || this.f11134th.active) {
            Object uk2 = NotificationLite.uk(t);
            for (SubjectSubscriptionManager.de fe2 : this.f11134th.next(uk2)) {
                fe2.fe(uk2);
            }
        }
    }
}
