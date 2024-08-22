package fe.rg.qw.o.fe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.fe.Cswitch;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f4849ad = new Handler(Looper.getMainLooper(), new C0208qw());
    @VisibleForTesting

    /* renamed from: de  reason: collision with root package name */
    public final Map<Key, fe> f4850de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public Cswitch.qw f4851fe;
    public final boolean qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public ReferenceQueue<Cswitch<?>> f4852rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public Thread f4853th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public volatile de f4854uk;

    /* renamed from: yj  reason: collision with root package name */
    public volatile boolean f4855yj;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            Process.setThreadPriority(10);
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
        public final boolean f4857ad;
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public Resource<?> f4858de;
        public final Key qw;

        public fe(@NonNull Key key, @NonNull Cswitch<?> switchR, @NonNull ReferenceQueue<? super Cswitch<?>> referenceQueue, boolean z) {
            super(switchR, referenceQueue);
            Resource<?> resource;
            uk.fe(key);
            this.qw = key;
            if (!switchR.rg() || !z) {
                resource = null;
            } else {
                Resource<?> fe2 = switchR.fe();
                uk.fe(fe2);
                resource = fe2;
            }
            this.f4858de = resource;
            this.f4857ad = switchR.rg();
        }

        public void qw() {
            this.f4858de = null;
            clear();
        }
    }

    /* renamed from: fe.rg.qw.o.fe.qw$qw  reason: collision with other inner class name */
    public class C0208qw implements Handler.Callback {
        public C0208qw() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            qw.this.de((fe) message.obj);
            return true;
        }
    }

    public qw(boolean z) {
        this.qw = z;
    }

    public void ad() {
        while (!this.f4855yj) {
            try {
                this.f4849ad.obtainMessage(1, (fe) this.f4852rg.remove()).sendToTarget();
                de deVar = this.f4854uk;
                if (deVar != null) {
                    deVar.qw();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void de(@NonNull fe feVar) {
        Resource<?> resource;
        i.qw();
        this.f4850de.remove(feVar.qw);
        if (feVar.f4857ad && (resource = feVar.f4858de) != null) {
            Cswitch switchR = new Cswitch(resource, true, false);
            switchR.yj(feVar.qw, this.f4851fe);
            this.f4851fe.fe(feVar.qw, switchR);
        }
    }

    public void fe(Key key) {
        fe remove = this.f4850de.remove(key);
        if (remove != null) {
            remove.qw();
        }
    }

    public void qw(Key key, Cswitch<?> switchR) {
        fe put = this.f4850de.put(key, new fe(key, switchR, th(), this.qw));
        if (put != null) {
            put.qw();
        }
    }

    @Nullable
    public Cswitch<?> rg(Key key) {
        fe feVar = this.f4850de.get(key);
        if (feVar == null) {
            return null;
        }
        Cswitch<?> switchR = (Cswitch) feVar.get();
        if (switchR == null) {
            de(feVar);
        }
        return switchR;
    }

    public final ReferenceQueue<Cswitch<?>> th() {
        if (this.f4852rg == null) {
            this.f4852rg = new ReferenceQueue<>();
            Thread thread = new Thread(new ad(), "glide-active-resources");
            this.f4853th = thread;
            thread.start();
        }
        return this.f4852rg;
    }

    public void yj(Cswitch.qw qwVar) {
        this.f4851fe = qwVar;
    }
}
