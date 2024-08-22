package fe.de.qw.qw;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

public final /* synthetic */ class mmm implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Future f1266ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Runnable f1267th;

    public /* synthetic */ mmm(Future future, Runnable runnable) {
        this.f1266ad = future;
        this.f1267th = runnable;
    }

    public final void run() {
        Future future = this.f1266ad;
        Runnable runnable = this.f1267th;
        if (!future.isDone() && !future.isCancelled()) {
            future.cancel(true);
            zzb.zzo("BillingClient", "Async task is taking too long, cancel it!");
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
