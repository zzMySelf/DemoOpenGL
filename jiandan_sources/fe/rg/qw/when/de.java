package fe.rg.qw.when;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;

public class de implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final RequestCoordinator f5080ad;

    /* renamed from: th  reason: collision with root package name */
    public Request f5081th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f5082uk;

    /* renamed from: yj  reason: collision with root package name */
    public Request f5083yj;

    @VisibleForTesting
    public de() {
        this((RequestCoordinator) null);
    }

    public boolean ad(Request request) {
        return m325if() && request.equals(this.f5081th) && !qw();
    }

    public void begin() {
        this.f5082uk = true;
        if (!this.f5081th.isComplete() && !this.f5083yj.isRunning()) {
            this.f5083yj.begin();
        }
        if (this.f5082uk && !this.f5081th.isRunning()) {
            this.f5081th.begin();
        }
    }

    public void clear() {
        this.f5082uk = false;
        this.f5083yj.clear();
        this.f5081th.clear();
    }

    public boolean de() {
        return this.f5081th.de();
    }

    public boolean fe(Request request) {
        return m326switch() && (request.equals(this.f5081th) || !this.f5081th.th());
    }

    public void i(Request request) {
        if (!request.equals(this.f5083yj)) {
            RequestCoordinator requestCoordinator = this.f5080ad;
            if (requestCoordinator != null) {
                requestCoordinator.i(this);
            }
            if (!this.f5083yj.isComplete()) {
                this.f5083yj.clear();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m325if() {
        RequestCoordinator requestCoordinator = this.f5080ad;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public boolean isComplete() {
        return this.f5081th.isComplete() || this.f5083yj.isComplete();
    }

    public boolean isRunning() {
        return this.f5081th.isRunning();
    }

    public boolean o(Request request) {
        return pf() && request.equals(this.f5081th);
    }

    public final boolean pf() {
        RequestCoordinator requestCoordinator = this.f5080ad;
        return requestCoordinator == null || requestCoordinator.o(this);
    }

    public void ppp(Request request, Request request2) {
        this.f5081th = request;
        this.f5083yj = request2;
    }

    public boolean qw() {
        return when() || th();
    }

    public void recycle() {
        this.f5081th.recycle();
        this.f5083yj.recycle();
    }

    public void rg(Request request) {
        RequestCoordinator requestCoordinator;
        if (request.equals(this.f5081th) && (requestCoordinator = this.f5080ad) != null) {
            requestCoordinator.rg(this);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m326switch() {
        RequestCoordinator requestCoordinator = this.f5080ad;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    public boolean th() {
        return this.f5081th.th() || this.f5083yj.th();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uk(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof fe.rg.qw.when.de
            r1 = 0
            if (r0 == 0) goto L_0x0028
            fe.rg.qw.when.de r4 = (fe.rg.qw.when.de) r4
            com.bumptech.glide.request.Request r0 = r3.f5081th
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.f5081th
            if (r0 != 0) goto L_0x0028
            goto L_0x0018
        L_0x0010:
            com.bumptech.glide.request.Request r2 = r4.f5081th
            boolean r0 = r0.uk(r2)
            if (r0 == 0) goto L_0x0028
        L_0x0018:
            com.bumptech.glide.request.Request r0 = r3.f5083yj
            com.bumptech.glide.request.Request r4 = r4.f5083yj
            if (r0 != 0) goto L_0x0021
            if (r4 != 0) goto L_0x0028
            goto L_0x0027
        L_0x0021:
            boolean r4 = r0.uk(r4)
            if (r4 == 0) goto L_0x0028
        L_0x0027:
            r1 = 1
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.when.de.uk(com.bumptech.glide.request.Request):boolean");
    }

    public final boolean when() {
        RequestCoordinator requestCoordinator = this.f5080ad;
        return requestCoordinator != null && requestCoordinator.qw();
    }

    public boolean yj() {
        return this.f5081th.yj();
    }

    public de(@Nullable RequestCoordinator requestCoordinator) {
        this.f5080ad = requestCoordinator;
    }
}
