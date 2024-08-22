package fe.rg.qw.when;

import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;

public final class qw implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final RequestCoordinator f5098ad;

    /* renamed from: th  reason: collision with root package name */
    public Request f5099th;

    /* renamed from: yj  reason: collision with root package name */
    public Request f5100yj;

    public qw(@Nullable RequestCoordinator requestCoordinator) {
        this.f5098ad = requestCoordinator;
    }

    public boolean ad(Request request) {
        return m330switch() && pf(request);
    }

    public void begin() {
        if (!this.f5099th.isRunning()) {
            this.f5099th.begin();
        }
    }

    public void clear() {
        this.f5099th.clear();
        if (this.f5100yj.isRunning()) {
            this.f5100yj.clear();
        }
    }

    public boolean de() {
        return (this.f5099th.yj() ? this.f5100yj : this.f5099th).de();
    }

    public boolean fe(Request request) {
        return when() && pf(request);
    }

    public void ggg(Request request, Request request2) {
        this.f5099th = request;
        this.f5100yj = request2;
    }

    public void i(Request request) {
        RequestCoordinator requestCoordinator = this.f5098ad;
        if (requestCoordinator != null) {
            requestCoordinator.i(this);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m329if() {
        RequestCoordinator requestCoordinator = this.f5098ad;
        return requestCoordinator == null || requestCoordinator.o(this);
    }

    public boolean isComplete() {
        return (this.f5099th.yj() ? this.f5100yj : this.f5099th).isComplete();
    }

    public boolean isRunning() {
        return (this.f5099th.yj() ? this.f5100yj : this.f5099th).isRunning();
    }

    public boolean o(Request request) {
        return m329if() && pf(request);
    }

    public final boolean pf(Request request) {
        return request.equals(this.f5099th) || (this.f5099th.yj() && request.equals(this.f5100yj));
    }

    public final boolean ppp() {
        RequestCoordinator requestCoordinator = this.f5098ad;
        return requestCoordinator != null && requestCoordinator.qw();
    }

    public boolean qw() {
        return ppp() || th();
    }

    public void recycle() {
        this.f5099th.recycle();
        this.f5100yj.recycle();
    }

    public void rg(Request request) {
        if (request.equals(this.f5100yj)) {
            RequestCoordinator requestCoordinator = this.f5098ad;
            if (requestCoordinator != null) {
                requestCoordinator.rg(this);
            }
        } else if (!this.f5100yj.isRunning()) {
            this.f5100yj.begin();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m330switch() {
        RequestCoordinator requestCoordinator = this.f5098ad;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public boolean th() {
        return (this.f5099th.yj() ? this.f5100yj : this.f5099th).th();
    }

    public boolean uk(Request request) {
        if (!(request instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) request;
        if (!this.f5099th.uk(qwVar.f5099th) || !this.f5100yj.uk(qwVar.f5100yj)) {
            return false;
        }
        return true;
    }

    public final boolean when() {
        RequestCoordinator requestCoordinator = this.f5098ad;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    public boolean yj() {
        return this.f5099th.yj() && this.f5100yj.yj();
    }
}
