package fe.fe.pf.th.qw;

import android.os.Bundle;
import com.baidu.helios.OnGetIdResultCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class de<T> implements OnGetIdResultCallback<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final CountDownLatch f2920ad = new CountDownLatch(1);

    /* renamed from: de  reason: collision with root package name */
    public ad<T> f2921de = null;

    /* renamed from: fe  reason: collision with root package name */
    public qw f2922fe = null;
    public volatile boolean qw = false;

    public static class ad<T> {

        /* renamed from: ad  reason: collision with root package name */
        public Bundle f2923ad;
        public T qw;
    }

    public static class qw {
        public Bundle qw;
    }

    public boolean ad(int i2) {
        try {
            this.f2920ad.await((long) i2, TimeUnit.MILLISECONDS);
            if (this.f2922fe == null) {
                this.f2922fe = new qw();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.qw;
    }

    public qw de() {
        return this.f2922fe;
    }

    public void onError(int i2, Throwable th2, Bundle bundle) {
        qw qwVar = new qw();
        this.f2922fe = qwVar;
        qwVar.qw = bundle;
        this.qw = false;
        this.f2920ad.countDown();
    }

    public void onResult(T t, Bundle bundle) {
        ad<T> adVar = new ad<>();
        this.f2921de = adVar;
        adVar.qw = t;
        adVar.f2923ad = bundle;
        this.qw = true;
        this.f2920ad.countDown();
    }

    public ad<T> qw() {
        return this.f2921de;
    }
}
