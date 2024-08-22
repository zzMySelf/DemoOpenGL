package fe.uk.qw.pf.fe;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.fe.Cswitch;
import fe.uk.qw.vvv.i;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class qw {
    @VisibleForTesting

    /* renamed from: ad  reason: collision with root package name */
    public final Map<Key, fe> f5824ad;

    /* renamed from: de  reason: collision with root package name */
    public final ReferenceQueue<Cswitch<?>> f5825de;

    /* renamed from: fe  reason: collision with root package name */
    public Cswitch.qw f5826fe;
    public final boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f5827rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public volatile de f5828th;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            qw.this.ad();
        }
    }

    @VisibleForTesting
    public interface de {
        void qw();
    }

    @VisibleForTesting
    public static final class fe extends WeakReference<Cswitch<?>> {

        /* renamed from: ad  reason: collision with root package name */
        public final boolean f5830ad;
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public Resource<?> f5831de;
        public final Key qw;

        public fe(@NonNull Key key, @NonNull Cswitch<?> switchR, @NonNull ReferenceQueue<? super Cswitch<?>> referenceQueue, boolean z) {
            super(switchR, referenceQueue);
            Resource<?> resource;
            i.fe(key);
            this.qw = key;
            if (!switchR.rg() || !z) {
                resource = null;
            } else {
                Resource<?> fe2 = switchR.fe();
                i.fe(fe2);
                resource = fe2;
            }
            this.f5831de = resource;
            this.f5830ad = switchR.rg();
        }

        public void qw() {
            this.f5831de = null;
            clear();
        }
    }

    /* renamed from: fe.uk.qw.pf.fe.qw$qw  reason: collision with other inner class name */
    public class C0234qw implements ThreadFactory {

        /* renamed from: fe.uk.qw.pf.fe.qw$qw$qw  reason: collision with other inner class name */
        public class C0235qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Runnable f5832ad;

            public C0235qw(C0234qw qwVar, Runnable runnable) {
                this.f5832ad = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f5832ad.run();
            }
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new C0235qw(this, runnable), "glide-active-resources");
        }
    }

    public qw(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new C0234qw()));
    }

    public void ad() {
        while (!this.f5827rg) {
            try {
                de((fe) this.f5825de.remove());
                de deVar = this.f5828th;
                if (deVar != null) {
                    deVar.qw();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void de(@NonNull fe feVar) {
        synchronized (this) {
            this.f5824ad.remove(feVar.qw);
            if (feVar.f5830ad) {
                if (feVar.f5831de != null) {
                    this.f5826fe.fe(feVar.qw, new Cswitch(feVar.f5831de, true, false, feVar.qw, this.f5826fe));
                }
            }
        }
    }

    public synchronized void fe(Key key) {
        fe remove = this.f5824ad.remove(key);
        if (remove != null) {
            remove.qw();
        }
    }

    public synchronized void qw(Key key, Cswitch<?> switchR) {
        fe put = this.f5824ad.put(key, new fe(key, switchR, this.f5825de, this.qw));
        if (put != null) {
            put.qw();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized fe.uk.qw.pf.fe.Cswitch<?> rg(com.dxmbumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.dxmbumptech.glide.load.Key, fe.uk.qw.pf.fe.qw$fe> r0 = r1.f5824ad     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            fe.uk.qw.pf.fe.qw$fe r2 = (fe.uk.qw.pf.fe.qw.fe) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            fe.uk.qw.pf.fe.switch r0 = (fe.uk.qw.pf.fe.Cswitch) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.de(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.fe.qw.rg(com.dxmbumptech.glide.load.Key):fe.uk.qw.pf.fe.switch");
    }

    public void th(Cswitch.qw qwVar) {
        synchronized (qwVar) {
            synchronized (this) {
                this.f5826fe = qwVar;
            }
        }
    }

    @VisibleForTesting
    public qw(boolean z, Executor executor) {
        this.f5824ad = new HashMap();
        this.f5825de = new ReferenceQueue<>();
        this.qw = z;
        executor.execute(new ad());
    }
}
