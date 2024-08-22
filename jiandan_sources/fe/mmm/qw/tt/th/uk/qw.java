package fe.mmm.qw.tt.th.uk;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

public final class qw implements Camera.AutoFocusCallback {

    /* renamed from: th  reason: collision with root package name */
    public static final String f8545th = qw.class.getSimpleName();

    /* renamed from: yj  reason: collision with root package name */
    public static final Collection<String> f8546yj;

    /* renamed from: ad  reason: collision with root package name */
    public final Camera f8547ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8548de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f8549fe;
    public final boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public AsyncTask<?, ?, ?> f8550rg;

    public final class ad extends AsyncTask<Object, Object, Object> {
        public ad() {
        }

        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            } catch (InterruptedException unused) {
            }
            qw.this.de();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f8546yj = arrayList;
        arrayList.add("auto");
        f8546yj.add("macro");
    }

    public qw(Context context, Camera camera) {
        this.f8547ad = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.qw = f8546yj.contains(focusMode);
        "Current focus mode '" + focusMode + "'; use auto focus? " + this.qw;
        de();
    }

    public final synchronized void ad() {
        if (this.f8550rg != null) {
            if (this.f8550rg.getStatus() != AsyncTask.Status.FINISHED) {
                this.f8550rg.cancel(true);
            }
            this.f8550rg = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void de() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.qw     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001c
            r0 = 0
            r1.f8550rg = r0     // Catch:{ all -> 0x001e }
            boolean r0 = r1.f8548de     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x001c
            boolean r0 = r1.f8549fe     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x001c
            android.hardware.Camera r0 = r1.f8547ad     // Catch:{ RuntimeException -> 0x0019 }
            r0.autoFocus(r1)     // Catch:{ RuntimeException -> 0x0019 }
            r0 = 1
            r1.f8549fe = r0     // Catch:{ RuntimeException -> 0x0019 }
            goto L_0x001c
        L_0x0019:
            r1.qw()     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r1)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.th.uk.qw.de():void");
    }

    public synchronized void fe() {
        this.f8548de = true;
        if (this.qw) {
            ad();
            try {
                this.f8547ad.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f8549fe = false;
        qw();
    }

    public final synchronized void qw() {
        if (!this.f8548de && this.f8550rg == null) {
            ad adVar = new ad();
            try {
                adVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f8550rg = adVar;
            } catch (RejectedExecutionException unused) {
            }
        }
    }
}
