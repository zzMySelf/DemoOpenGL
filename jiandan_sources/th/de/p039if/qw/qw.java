package th.de.p039if.qw;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: th.de.if.qw.qw  reason: invalid package */
public final class qw implements Disposable, DisposableContainer {

    /* renamed from: ad  reason: collision with root package name */
    public List<Disposable> f10915ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f10916th;

    public boolean ad(Disposable disposable) {
        th.de.p039if.ad.qw.rg(disposable, "d is null");
        if (!this.f10916th) {
            synchronized (this) {
                if (!this.f10916th) {
                    List list = this.f10915ad;
                    if (list == null) {
                        list = new LinkedList();
                        this.f10915ad = list;
                    }
                    list.add(disposable);
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
            java.lang.String r0 = "Disposable item is null"
            th.de.p039if.ad.qw.rg(r3, r0)
            boolean r0 = r2.f10916th
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f10916th     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.reactivex.disposables.Disposable> r0 = r2.f10915ad     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.qw.qw.de(io.reactivex.disposables.Disposable):boolean");
    }

    public void dispose() {
        if (!this.f10916th) {
            synchronized (this) {
                if (!this.f10916th) {
                    this.f10916th = true;
                    List<Disposable> list = this.f10915ad;
                    this.f10915ad = null;
                    fe(list);
                }
            }
        }
    }

    public void fe(List<Disposable> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (Disposable dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
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
        return this.f10916th;
    }

    public boolean qw(Disposable disposable) {
        if (!de(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }
}
