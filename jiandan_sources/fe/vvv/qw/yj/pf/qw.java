package fe.vvv.qw.yj.pf;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class qw extends CameraOrchestrator {

    /* renamed from: th  reason: collision with root package name */
    public CameraState f9216th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9217uk = 0;

    /* renamed from: yj  reason: collision with root package name */
    public CameraState f9218yj;

    public class ad implements Callable<Task<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CameraState f9219ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f9220i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f9222th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ Callable f9223uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ CameraState f9224yj;

        /* renamed from: fe.vvv.qw.yj.pf.qw$ad$qw  reason: collision with other inner class name */
        public class C0322qw implements Continuation<T, Task<T>> {
            public C0322qw() {
            }

            public Task<T> qw(@NonNull Task<T> task) {
                if (task.isSuccessful() || ad.this.f9220i) {
                    ad adVar = ad.this;
                    CameraState unused = qw.this.f9216th = adVar.f9224yj;
                }
                return task;
            }

            public /* bridge */ /* synthetic */ Object then(@NonNull Task task) throws Exception {
                qw(task);
                return task;
            }
        }

        public ad(CameraState cameraState, String str, CameraState cameraState2, Callable callable, boolean z) {
            this.f9219ad = cameraState;
            this.f9222th = str;
            this.f9224yj = cameraState2;
            this.f9223uk = callable;
            this.f9220i = z;
        }

        /* renamed from: qw */
        public Task<T> call() throws Exception {
            if (qw.this.ppp() != this.f9219ad) {
                CameraOrchestrator.f6728rg.i(this.f9222th.toUpperCase(), "- State mismatch, aborting. current:", qw.this.ppp(), "from:", this.f9219ad, "to:", this.f9224yj);
                return Tasks.forCanceled();
            }
            return ((Task) this.f9223uk.call()).continueWithTask(qw.this.qw.qw(this.f9222th).rg(), new C0322qw());
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CameraState f9225ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Runnable f9226th;

        public de(CameraState cameraState, Runnable runnable) {
            this.f9225ad = cameraState;
            this.f9226th = runnable;
        }

        public void run() {
            if (qw.this.ppp().isAtLeast(this.f9225ad)) {
                this.f9226th.run();
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CameraState f9228ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Runnable f9229th;

        public fe(CameraState cameraState, Runnable runnable) {
            this.f9228ad = cameraState;
            this.f9229th = runnable;
        }

        public void run() {
            if (qw.this.ppp().isAtLeast(this.f9228ad)) {
                this.f9229th.run();
            }
        }
    }

    /* renamed from: fe.vvv.qw.yj.pf.qw$qw  reason: collision with other inner class name */
    public class C0323qw implements OnCompleteListener<T> {
        public final /* synthetic */ int qw;

        public C0323qw(int i2) {
            this.qw = i2;
        }

        public void onComplete(@NonNull Task<T> task) {
            if (this.qw == qw.this.f9217uk) {
                qw qwVar = qw.this;
                CameraState unused = qwVar.f9218yj = qwVar.f9216th;
            }
        }
    }

    public qw(@NonNull CameraOrchestrator.Callback callback) {
        super(callback);
        CameraState cameraState = CameraState.OFF;
        this.f9216th = cameraState;
        this.f9218yj = cameraState;
    }

    @NonNull
    public Task<Void> ddd(@NonNull String str, @NonNull CameraState cameraState, @NonNull Runnable runnable) {
        return uk(str, true, new de(cameraState, runnable));
    }

    @NonNull
    public CameraState ggg() {
        return this.f9218yj;
    }

    public void nn(@NonNull String str, @NonNull CameraState cameraState, long j, @NonNull Runnable runnable) {
        o(str, j, new fe(cameraState, runnable));
    }

    @NonNull
    public CameraState ppp() {
        return this.f9216th;
    }

    public boolean vvv() {
        synchronized (this.f6730de) {
            Iterator<CameraOrchestrator.rg> it = this.f6729ad.iterator();
            while (it.hasNext()) {
                CameraOrchestrator.rg next = it.next();
                if ((next.qw.contains(" >> ") || next.qw.contains(" << ")) && !next.f6743ad.isComplete()) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public <T> Task<T> xxx(@NonNull CameraState cameraState, @NonNull CameraState cameraState2, boolean z, @NonNull Callable<Task<T>> callable) {
        String str;
        int i2 = this.f9217uk + 1;
        this.f9217uk = i2;
        this.f9218yj = cameraState2;
        boolean z2 = !cameraState2.isAtLeast(cameraState);
        if (z2) {
            str = cameraState.name() + " << " + cameraState2.name();
        } else {
            str = cameraState.name() + " >> " + cameraState2.name();
        }
        return i(str, z, new ad(cameraState, str, cameraState2, callable, z2)).addOnCompleteListener(new C0323qw(i2));
    }
}
