package fe.mmm.qw.tt.ad.ppp;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public final class fe extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final CountDownLatch f8411ad = new CountDownLatch(1);

    /* renamed from: th  reason: collision with root package name */
    public ad f8412th;

    public fe() {
        setName("barcode decode thread");
    }

    public void ad() {
        qw().getLooper().quit();
        ad adVar = this.f8412th;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages((Object) null);
        }
        this.f8412th = null;
    }

    public Handler qw() {
        try {
            this.f8411ad.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f8412th;
    }

    public void run() {
        Looper.prepare();
        this.f8412th = new ad();
        this.f8411ad.countDown();
        Looper.loop();
    }
}
