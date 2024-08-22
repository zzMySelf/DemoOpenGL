package fe.uk.qw.ppp;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.RequestCoordinator;

public final class ad implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final RequestCoordinator f6006ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile Request f6007de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile Request f6008fe;
    public final Object qw;
    @GuardedBy("requestLock")

    /* renamed from: rg  reason: collision with root package name */
    public RequestCoordinator.RequestState f6009rg;
    @GuardedBy("requestLock")

    /* renamed from: th  reason: collision with root package name */
    public RequestCoordinator.RequestState f6010th;

    public ad(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f6009rg = requestState;
        this.f6010th = requestState;
        this.qw = obj;
        this.f6006ad = requestCoordinator;
    }

    public boolean ad(Request request) {
        boolean z;
        synchronized (this.qw) {
            z = pf() && i(request);
        }
        return z;
    }

    public void begin() {
        synchronized (this.qw) {
            if (this.f6009rg != RequestCoordinator.RequestState.RUNNING) {
                this.f6009rg = RequestCoordinator.RequestState.RUNNING;
                this.f6007de.begin();
            }
        }
    }

    public void clear() {
        synchronized (this.qw) {
            this.f6009rg = RequestCoordinator.RequestState.CLEARED;
            this.f6007de.clear();
            if (this.f6010th != RequestCoordinator.RequestState.CLEARED) {
                this.f6010th = RequestCoordinator.RequestState.CLEARED;
                this.f6008fe.clear();
            }
        }
    }

    public boolean de() {
        boolean z;
        synchronized (this.qw) {
            z = this.f6009rg == RequestCoordinator.RequestState.CLEARED && this.f6010th == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    public boolean fe(Request request) {
        boolean z;
        synchronized (this.qw) {
            z = o() && i(request);
        }
        return z;
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.qw) {
            root = this.f6006ad != null ? this.f6006ad.getRoot() : this;
        }
        return root;
    }

    @GuardedBy("requestLock")
    public final boolean i(Request request) {
        return request.equals(this.f6007de) || (this.f6009rg == RequestCoordinator.RequestState.FAILED && request.equals(this.f6008fe));
    }

    @GuardedBy("requestLock")
    /* renamed from: if  reason: not valid java name */
    public final boolean m383if() {
        RequestCoordinator requestCoordinator = this.f6006ad;
        return requestCoordinator == null || requestCoordinator.rg(this);
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.qw) {
            if (this.f6009rg != RequestCoordinator.RequestState.SUCCESS) {
                if (this.f6010th != RequestCoordinator.RequestState.SUCCESS) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.qw) {
            if (this.f6009rg != RequestCoordinator.RequestState.RUNNING) {
                if (this.f6010th != RequestCoordinator.RequestState.RUNNING) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean o() {
        RequestCoordinator requestCoordinator = this.f6006ad;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    public void pause() {
        synchronized (this.qw) {
            if (this.f6009rg == RequestCoordinator.RequestState.RUNNING) {
                this.f6009rg = RequestCoordinator.RequestState.PAUSED;
                this.f6007de.pause();
            }
            if (this.f6010th == RequestCoordinator.RequestState.RUNNING) {
                this.f6010th = RequestCoordinator.RequestState.PAUSED;
                this.f6008fe.pause();
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean pf() {
        RequestCoordinator requestCoordinator = this.f6006ad;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public boolean qw() {
        boolean z;
        synchronized (this.qw) {
            if (!this.f6007de.qw()) {
                if (!this.f6008fe.qw()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean rg(Request request) {
        boolean z;
        synchronized (this.qw) {
            z = m383if() && i(request);
        }
        return z;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m384switch(Request request, Request request2) {
        this.f6007de = request;
        this.f6008fe = request2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(com.dxmbumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.qw
            monitor-enter(r0)
            com.dxmbumptech.glide.request.Request r1 = r2.f6008fe     // Catch:{ all -> 0x002f }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0020
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002f }
            r2.f6009rg = r3     // Catch:{ all -> 0x002f }
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f6010th     // Catch:{ all -> 0x002f }
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r1 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002f }
            if (r3 == r1) goto L_0x001e
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002f }
            r2.f6010th = r3     // Catch:{ all -> 0x002f }
            com.dxmbumptech.glide.request.Request r3 = r2.f6008fe     // Catch:{ all -> 0x002f }
            r3.begin()     // Catch:{ all -> 0x002f }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x0020:
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002f }
            r2.f6010th = r3     // Catch:{ all -> 0x002f }
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.f6006ad     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002d
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.f6006ad     // Catch:{ all -> 0x002f }
            r3.th(r2)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.ad.th(com.dxmbumptech.glide.request.Request):void");
    }

    public boolean uk(Request request) {
        if (!(request instanceof ad)) {
            return false;
        }
        ad adVar = (ad) request;
        if (!this.f6007de.uk(adVar.f6007de) || !this.f6008fe.uk(adVar.f6008fe)) {
            return false;
        }
        return true;
    }

    public void yj(Request request) {
        synchronized (this.qw) {
            if (request.equals(this.f6007de)) {
                this.f6009rg = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.f6008fe)) {
                this.f6010th = RequestCoordinator.RequestState.SUCCESS;
            }
            if (this.f6006ad != null) {
                this.f6006ad.yj(this);
            }
        }
    }
}
