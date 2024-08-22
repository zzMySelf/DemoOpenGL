package com.otaliastudios.cameraview.engine.orchestrator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.p037if.yj;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class CameraOrchestrator {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f6728rg = CameraLogger.qw(CameraOrchestrator.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayDeque<rg> f6729ad = new ArrayDeque<>();

    /* renamed from: de  reason: collision with root package name */
    public final Object f6730de = new Object();

    /* renamed from: fe  reason: collision with root package name */
    public final Map<String, Runnable> f6731fe = new HashMap();
    public final Callback qw;

    public interface Callback {
        void ad(@NonNull String str, @NonNull Exception exc);

        @NonNull
        yj qw(@NonNull String str);
    }

    public class ad implements OnCompleteListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Callable f6732ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ yj f6733de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ boolean f6734fe;
        public final /* synthetic */ String qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f6735rg;

        public class qw implements OnCompleteListener<T> {
            public qw() {
            }

            public void onComplete(@NonNull Task<T> task) {
                Exception exception = task.getException();
                if (exception != null) {
                    CameraOrchestrator.f6728rg.i(ad.this.qw.toUpperCase(), "- Finished with ERROR.", exception);
                    ad adVar = ad.this;
                    if (adVar.f6734fe) {
                        CameraOrchestrator.this.qw.ad(adVar.qw, exception);
                    }
                    ad.this.f6735rg.trySetException(exception);
                } else if (task.isCanceled()) {
                    CameraOrchestrator.f6728rg.de(ad.this.qw.toUpperCase(), "- Finished because ABORTED.");
                    ad.this.f6735rg.trySetException(new CancellationException());
                } else {
                    CameraOrchestrator.f6728rg.de(ad.this.qw.toUpperCase(), "- Finished.");
                    ad.this.f6735rg.trySetResult(task.getResult());
                }
            }
        }

        public ad(String str, Callable callable, yj yjVar, boolean z, TaskCompletionSource taskCompletionSource) {
            this.qw = str;
            this.f6732ad = callable;
            this.f6733de = yjVar;
            this.f6734fe = z;
            this.f6735rg = taskCompletionSource;
        }

        public void onComplete(@NonNull Task task) {
            synchronized (CameraOrchestrator.this.f6730de) {
                CameraOrchestrator.this.f6729ad.removeFirst();
                CameraOrchestrator.this.rg();
            }
            try {
                CameraOrchestrator.f6728rg.de(this.qw.toUpperCase(), "- Executing.");
                CameraOrchestrator.fe((Task) this.f6732ad.call(), this.f6733de, new qw());
            } catch (Exception e) {
                CameraOrchestrator.f6728rg.de(this.qw.toUpperCase(), "- Finished.", e);
                if (this.f6734fe) {
                    CameraOrchestrator.this.qw.ad(this.qw, e);
                }
                this.f6735rg.trySetException(e);
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f6737ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Runnable f6738th;

        public de(String str, Runnable runnable) {
            this.f6737ad = str;
            this.f6738th = runnable;
        }

        public void run() {
            CameraOrchestrator.this.uk(this.f6737ad, true, this.f6738th);
            synchronized (CameraOrchestrator.this.f6730de) {
                if (CameraOrchestrator.this.f6731fe.containsValue(this)) {
                    CameraOrchestrator.this.f6731fe.remove(this.f6737ad);
                }
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OnCompleteListener f6740ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Task f6741th;

        public fe(OnCompleteListener onCompleteListener, Task task) {
            this.f6740ad = onCompleteListener;
            this.f6741th = task;
        }

        public void run() {
            this.f6740ad.onComplete(this.f6741th);
        }
    }

    public class qw implements Callable<Task<Void>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Runnable f6742ad;

        public qw(CameraOrchestrator cameraOrchestrator, Runnable runnable) {
            this.f6742ad = runnable;
        }

        /* renamed from: qw */
        public Task<Void> call() {
            this.f6742ad.run();
            return Tasks.forResult(null);
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public final Task<?> f6743ad;
        public final String qw;

        public /* synthetic */ rg(String str, Task task, qw qwVar) {
            this(str, task);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof rg) && ((rg) obj).qw.equals(this.qw);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.qw, this.f6743ad});
        }

        public rg(@NonNull String str, @NonNull Task<?> task) {
            this.qw = str;
            this.f6743ad = task;
        }
    }

    public CameraOrchestrator(@NonNull Callback callback) {
        this.qw = callback;
        rg();
    }

    public static <T> void fe(@NonNull Task<T> task, @NonNull yj yjVar, @NonNull OnCompleteListener<T> onCompleteListener) {
        if (task.isComplete()) {
            yjVar.pf(new fe(onCompleteListener, task));
        } else {
            task.addOnCompleteListener(yjVar.rg(), onCompleteListener);
        }
    }

    @NonNull
    public <T> Task<T> i(@NonNull String str, boolean z, @NonNull Callable<Task<T>> callable) {
        f6728rg.de(str.toUpperCase(), "- Scheduling.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        yj qw2 = this.qw.qw(str);
        synchronized (this.f6730de) {
            fe(this.f6729ad.getLast().f6743ad, qw2, new ad(str, callable, qw2, z, taskCompletionSource));
            this.f6729ad.addLast(new rg(str, taskCompletionSource.getTask(), (qw) null));
        }
        return taskCompletionSource.getTask();
    }

    public void o(@NonNull String str, long j, @NonNull Runnable runnable) {
        de deVar = new de(str, runnable);
        synchronized (this.f6730de) {
            this.f6731fe.put(str, deVar);
            this.qw.qw(str).uk(j, deVar);
        }
    }

    public final void rg() {
        synchronized (this.f6730de) {
            if (this.f6729ad.isEmpty()) {
                this.f6729ad.add(new rg("BASE", Tasks.forResult(null), (qw) null));
            }
        }
    }

    public void th(@NonNull String str) {
        synchronized (this.f6730de) {
            if (this.f6731fe.get(str) != null) {
                this.qw.qw(str).o(this.f6731fe.get(str));
                this.f6731fe.remove(str);
            }
            while (this.f6729ad.remove(new rg(str, Tasks.forResult(null), (qw) null))) {
            }
            rg();
        }
    }

    @NonNull
    public Task<Void> uk(@NonNull String str, boolean z, @NonNull Runnable runnable) {
        return i(str, z, new qw(this, runnable));
    }

    public void yj() {
        synchronized (this.f6730de) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f6731fe.keySet());
            Iterator<rg> it = this.f6729ad.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().qw);
            }
            for (String th2 : arrayList) {
                th(th2);
            }
        }
    }
}
