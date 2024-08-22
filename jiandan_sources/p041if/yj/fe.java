package p041if.yj;

import p041if.de;
import rx.Observer;

/* renamed from: if.yj.fe  reason: invalid package */
public final class fe {

    /* renamed from: if.yj.fe$ad */
    public static class ad extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ de f11367ad;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(de deVar, de deVar2) {
            super(deVar);
            this.f11367ad = deVar2;
        }

        public void onCompleted() {
            this.f11367ad.onCompleted();
        }

        public void onError(Throwable th2) {
            this.f11367ad.onError(th2);
        }

        public void onNext(T t) {
            this.f11367ad.onNext(t);
        }
    }

    /* renamed from: if.yj.fe$qw */
    public static class qw extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Observer f11368ad;

        public qw(Observer observer) {
            this.f11368ad = observer;
        }

        public void onCompleted() {
            this.f11368ad.onCompleted();
        }

        public void onError(Throwable th2) {
            this.f11368ad.onError(th2);
        }

        public void onNext(T t) {
            this.f11368ad.onNext(t);
        }
    }

    public static <T> de<T> ad(Observer<? super T> observer) {
        return new qw(observer);
    }

    public static <T> de<T> de(de<? super T> deVar) {
        return new ad(deVar, deVar);
    }

    public static <T> de<T> qw() {
        return ad(qw.qw());
    }
}
