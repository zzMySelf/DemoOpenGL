package fe.uk.qw.ppp;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.RequestCoordinator;

public class fe implements RequestCoordinator, Request {

    /* renamed from: ad  reason: collision with root package name */
    public final Object f6011ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile Request f6012de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile Request f6013fe;
    @Nullable
    public final RequestCoordinator qw;
    @GuardedBy("requestLock")

    /* renamed from: rg  reason: collision with root package name */
    public RequestCoordinator.RequestState f6014rg;
    @GuardedBy("requestLock")

    /* renamed from: th  reason: collision with root package name */
    public RequestCoordinator.RequestState f6015th;
    @GuardedBy("requestLock")

    /* renamed from: yj  reason: collision with root package name */
    public boolean f6016yj;

    public fe(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f6014rg = requestState;
        this.f6015th = requestState;
        this.f6011ad = obj;
        this.qw = requestCoordinator;
    }

    public boolean ad(Request request) {
        boolean z;
        synchronized (this.f6011ad) {
            z = o() && request.equals(this.f6012de) && !qw();
        }
        return z;
    }

    public void begin() {
        synchronized (this.f6011ad) {
            this.f6016yj = true;
            try {
                if (!(this.f6014rg == RequestCoordinator.RequestState.SUCCESS || this.f6015th == RequestCoordinator.RequestState.RUNNING)) {
                    this.f6015th = RequestCoordinator.RequestState.RUNNING;
                    this.f6013fe.begin();
                }
                if (this.f6016yj && this.f6014rg != RequestCoordinator.RequestState.RUNNING) {
                    this.f6014rg = RequestCoordinator.RequestState.RUNNING;
                    this.f6012de.begin();
                }
            } finally {
                this.f6016yj = false;
            }
        }
    }

    public void clear() {
        synchronized (this.f6011ad) {
            this.f6016yj = false;
            this.f6014rg = RequestCoordinator.RequestState.CLEARED;
            this.f6015th = RequestCoordinator.RequestState.CLEARED;
            this.f6013fe.clear();
            this.f6012de.clear();
        }
    }

    public boolean de() {
        boolean z;
        synchronized (this.f6011ad) {
            z = this.f6014rg == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    public boolean fe(Request request) {
        boolean z;
        synchronized (this.f6011ad) {
            z = i() && request.equals(this.f6012de) && this.f6014rg != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f6011ad) {
            root = this.qw != null ? this.qw.getRoot() : this;
        }
        return root;
    }

    @GuardedBy("requestLock")
    public final boolean i() {
        RequestCoordinator requestCoordinator = this.qw;
        return requestCoordinator == null || requestCoordinator.fe(this);
    }

    /* renamed from: if  reason: not valid java name */
    public void m385if(Request request, Request request2) {
        this.f6012de = request;
        this.f6013fe = request2;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f6011ad) {
            z = this.f6014rg == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f6011ad) {
            z = this.f6014rg == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean o() {
        RequestCoordinator requestCoordinator = this.qw;
        return requestCoordinator == null || requestCoordinator.ad(this);
    }

    public void pause() {
        synchronized (this.f6011ad) {
            if (!this.f6015th.isComplete()) {
                this.f6015th = RequestCoordinator.RequestState.PAUSED;
                this.f6013fe.pause();
            }
            if (!this.f6014rg.isComplete()) {
                this.f6014rg = RequestCoordinator.RequestState.PAUSED;
                this.f6012de.pause();
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean pf() {
        RequestCoordinator requestCoordinator = this.qw;
        return requestCoordinator == null || requestCoordinator.rg(this);
    }

    public boolean qw() {
        boolean z;
        synchronized (this.f6011ad) {
            if (!this.f6013fe.qw()) {
                if (!this.f6012de.qw()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean rg(Request request) {
        boolean z;
        synchronized (this.f6011ad) {
            z = pf() && (request.equals(this.f6012de) || this.f6014rg != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(com.dxmbumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6011ad
            monitor-enter(r0)
            com.dxmbumptech.glide.request.Request r1 = r2.f6012de     // Catch:{ all -> 0x0020 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x0011
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0020 }
            r2.f6015th = r3     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0011:
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0020 }
            r2.f6014rg = r3     // Catch:{ all -> 0x0020 }
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.qw     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x001e
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.qw     // Catch:{ all -> 0x0020 }
            r3.th(r2)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.fe.th(com.dxmbumptech.glide.request.Request):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uk(com.dxmbumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof fe.uk.qw.ppp.fe
            r1 = 0
            if (r0 == 0) goto L_0x002e
            fe.uk.qw.ppp.fe r4 = (fe.uk.qw.ppp.fe) r4
            com.dxmbumptech.glide.request.Request r0 = r3.f6012de
            if (r0 != 0) goto L_0x0010
            com.dxmbumptech.glide.request.Request r0 = r4.f6012de
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.dxmbumptech.glide.request.Request r0 = r3.f6012de
            com.dxmbumptech.glide.request.Request r2 = r4.f6012de
            boolean r0 = r0.uk(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.dxmbumptech.glide.request.Request r0 = r3.f6013fe
            if (r0 != 0) goto L_0x0023
            com.dxmbumptech.glide.request.Request r4 = r4.f6013fe
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.dxmbumptech.glide.request.Request r0 = r3.f6013fe
            com.dxmbumptech.glide.request.Request r4 = r4.f6013fe
            boolean r4 = r0.uk(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.fe.uk(com.dxmbumptech.glide.request.Request):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void yj(com.dxmbumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6011ad
            monitor-enter(r0)
            com.dxmbumptech.glide.request.Request r1 = r2.f6013fe     // Catch:{ all -> 0x002d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0011
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002d }
            r2.f6015th = r3     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0011:
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = com.dxmbumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002d }
            r2.f6014rg = r3     // Catch:{ all -> 0x002d }
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.qw     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x001e
            com.dxmbumptech.glide.request.RequestCoordinator r3 = r2.qw     // Catch:{ all -> 0x002d }
            r3.yj(r2)     // Catch:{ all -> 0x002d }
        L_0x001e:
            com.dxmbumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f6015th     // Catch:{ all -> 0x002d }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002b
            com.dxmbumptech.glide.request.Request r3 = r2.f6013fe     // Catch:{ all -> 0x002d }
            r3.clear()     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.fe.yj(com.dxmbumptech.glide.request.Request):void");
    }
}
