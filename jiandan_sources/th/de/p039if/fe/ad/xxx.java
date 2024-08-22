package th.de.p039if.fe.ad;

import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber;
import th.de.ddd.qw;

/* renamed from: th.de.if.fe.ad.xxx  reason: invalid package */
public final class xxx<T, B> extends qw<B> {

    /* renamed from: th  reason: collision with root package name */
    public final FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber<T, B> f10508th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f10509yj;

    public xxx(FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber<T, B> flowableWindowBoundarySupplier$WindowBoundaryMainSubscriber) {
        this.f10508th = flowableWindowBoundarySupplier$WindowBoundaryMainSubscriber;
    }

    public void onComplete() {
        if (!this.f10509yj) {
            this.f10509yj = true;
            this.f10508th.innerComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f10509yj) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f10509yj = true;
        this.f10508th.innerError(th2);
    }

    public void onNext(B b) {
        if (!this.f10509yj) {
            this.f10509yj = true;
            dispose();
            this.f10508th.innerNext(this);
        }
    }
}
