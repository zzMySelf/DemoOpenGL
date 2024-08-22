package th.de.i;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import th.de.p039if.yj.th;

public final class qw implements Disposable, DisposableContainer {

    /* renamed from: ad  reason: collision with root package name */
    public th<Disposable> f10463ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f10464th;

    public boolean ad(Disposable disposable) {
        th.de.p039if.ad.qw.rg(disposable, "disposable is null");
        if (!this.f10464th) {
            synchronized (this) {
                if (!this.f10464th) {
                    th<Disposable> thVar = this.f10463ad;
                    if (thVar == null) {
                        thVar = new th<>();
                        this.f10463ad = thVar;
                    }
                    thVar.qw(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean de(io.reactivex.disposables.Disposable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposables is null"
            th.de.p039if.ad.qw.rg(r3, r0)
            boolean r0 = r2.f10464th
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f10464th     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            th.de.if.yj.th<io.reactivex.disposables.Disposable> r0 = r2.f10463ad     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.rg(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.i.qw.de(io.reactivex.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.f10464th) {
            synchronized (this) {
                if (!this.f10464th) {
                    this.f10464th = true;
                    th<Disposable> thVar = this.f10463ad;
                    this.f10463ad = null;
                    fe(thVar);
                }
            }
        }
    }

    public void fe(th<Disposable> thVar) {
        if (thVar != null) {
            ArrayList arrayList = null;
            for (Object obj : thVar.ad()) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).dispose();
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.fe((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public boolean isDisposed() {
        return this.f10464th;
    }

    public boolean qw(Disposable disposable) {
        if (!de(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int rg() {
        /*
            r2 = this;
            boolean r0 = r2.f10464th
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f10464th     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x000d:
            th.de.if.yj.th<io.reactivex.disposables.Disposable> r0 = r2.f10463ad     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.yj()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.i.qw.rg():int");
    }
}
