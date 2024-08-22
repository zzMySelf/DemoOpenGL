package fe.vvv.qw.p037if;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: fe.vvv.qw.if.yj  reason: invalid package */
public class yj {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f9030rg = CameraLogger.qw(yj.class.getSimpleName());

    /* renamed from: th  reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<yj>> f9031th = new ConcurrentHashMap<>(4);

    /* renamed from: yj  reason: collision with root package name */
    public static yj f9032yj;

    /* renamed from: ad  reason: collision with root package name */
    public HandlerThread f9033ad;

    /* renamed from: de  reason: collision with root package name */
    public Handler f9034de = new Handler(this.f9033ad.getLooper());

    /* renamed from: fe  reason: collision with root package name */
    public Executor f9035fe = new ad();
    public String qw;

    /* renamed from: fe.vvv.qw.if.yj$ad */
    public class ad implements Executor {
        public ad() {
        }

        public void execute(@NonNull Runnable runnable) {
            yj.this.pf(runnable);
        }
    }

    /* renamed from: fe.vvv.qw.if.yj$de */
    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9037ad;

        public de(yj yjVar, CountDownLatch countDownLatch) {
            this.f9037ad = countDownLatch;
        }

        public void run() {
            this.f9037ad.countDown();
        }
    }

    /* renamed from: fe.vvv.qw.if.yj$qw */
    public class qw extends HandlerThread {
        public qw(yj yjVar, String str) {
            super(str);
        }

        @NonNull
        public String toString() {
            return super.toString() + "[" + getThreadId() + "]";
        }
    }

    public yj(@NonNull String str) {
        this.qw = str;
        qw qwVar = new qw(this, str);
        this.f9033ad = qwVar;
        qwVar.setDaemon(true);
        this.f9033ad.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        i(new de(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public static void ad(@NonNull Runnable runnable) {
        de().i(runnable);
    }

    @NonNull
    public static yj de() {
        yj fe2 = fe("FallbackCameraThread");
        f9032yj = fe2;
        return fe2;
    }

    @NonNull
    public static yj fe(@NonNull String str) {
        if (f9031th.containsKey(str)) {
            yj yjVar = (yj) f9031th.get(str).get();
            if (yjVar == null) {
                f9030rg.i("get:", "Thread reference died. Removing.", str);
                f9031th.remove(str);
            } else if (!yjVar.yj().isAlive() || yjVar.yj().isInterrupted()) {
                yjVar.qw();
                f9030rg.i("get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                f9031th.remove(str);
            } else {
                f9030rg.i("get:", "Reusing cached worker handler.", str);
                return yjVar;
            }
        }
        f9030rg.de("get:", "Creating new handler.", str);
        yj yjVar2 = new yj(str);
        f9031th.put(str, new WeakReference(yjVar2));
        return yjVar2;
    }

    public void i(@NonNull Runnable runnable) {
        this.f9034de.post(runnable);
    }

    public void o(@NonNull Runnable runnable) {
        this.f9034de.removeCallbacks(runnable);
    }

    public void pf(@NonNull Runnable runnable) {
        if (Thread.currentThread() == yj()) {
            runnable.run();
        } else {
            i(runnable);
        }
    }

    public void qw() {
        HandlerThread yj2 = yj();
        if (yj2.isAlive()) {
            yj2.interrupt();
            yj2.quit();
        }
        f9031th.remove(this.qw);
    }

    @NonNull
    public Executor rg() {
        return this.f9035fe;
    }

    @NonNull
    public Handler th() {
        return this.f9034de;
    }

    public void uk(long j, @NonNull Runnable runnable) {
        this.f9034de.postDelayed(runnable, j);
    }

    @NonNull
    public HandlerThread yj() {
        return this.f9033ad;
    }
}
