package th.de.p039if.fe.ad;

import io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryMainSubscriber;
import th.de.ddd.qw;

/* renamed from: th.de.if.fe.ad.vvv  reason: invalid package */
public final class vvv<T, B> extends qw<B> {

    /* renamed from: th  reason: collision with root package name */
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> f10504th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f10505yj;

    public vvv(FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> flowableWindowBoundary$WindowBoundaryMainSubscriber) {
        this.f10504th = flowableWindowBoundary$WindowBoundaryMainSubscriber;
    }

    public void onComplete() {
        if (!this.f10505yj) {
            this.f10505yj = true;
            this.f10504th.innerComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f10505yj) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f10505yj = true;
        this.f10504th.innerError(th2);
    }

    public void onNext(B b) {
        if (!this.f10505yj) {
            this.f10504th.innerNext();
        }
    }
}
