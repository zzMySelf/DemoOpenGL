package th.de.uk.ad;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import th.de.th;

public final class ad extends th {

    /* renamed from: th  reason: collision with root package name */
    public final Handler f11020th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f11021yj;

    /* renamed from: th.de.uk.ad.ad$ad  reason: collision with other inner class name */
    public static final class C0343ad implements Runnable, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Handler f11022ad;

        /* renamed from: th  reason: collision with root package name */
        public final Runnable f11023th;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f11024yj;

        public C0343ad(Handler handler, Runnable runnable) {
            this.f11022ad = handler;
            this.f11023th = runnable;
        }

        public void dispose() {
            this.f11022ad.removeCallbacks(this);
            this.f11024yj = true;
        }

        public boolean isDisposed() {
            return this.f11024yj;
        }

        public void run() {
            try {
                this.f11023th.run();
            } catch (Throwable th2) {
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public static final class qw extends th.de {

        /* renamed from: ad  reason: collision with root package name */
        public final Handler f11025ad;

        /* renamed from: th  reason: collision with root package name */
        public final boolean f11026th;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f11027yj;

        public qw(Handler handler, boolean z) {
            this.f11025ad = handler;
            this.f11026th = z;
        }

        @SuppressLint({"NewApi"})
        public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f11027yj) {
                return th.de.i.ad.qw();
            } else {
                C0343ad adVar = new C0343ad(this.f11025ad, th.de.ppp.qw.mmm(runnable));
                Message obtain = Message.obtain(this.f11025ad, adVar);
                obtain.obj = this;
                if (this.f11026th) {
                    obtain.setAsynchronous(true);
                }
                this.f11025ad.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f11027yj) {
                    return adVar;
                }
                this.f11025ad.removeCallbacks(adVar);
                return th.de.i.ad.qw();
            }
        }

        public void dispose() {
            this.f11027yj = true;
            this.f11025ad.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f11027yj;
        }
    }

    public ad(Handler handler, boolean z) {
        this.f11020th = handler;
        this.f11021yj = z;
    }

    @SuppressLint({"NewApi"})
    public Disposable fe(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0343ad adVar = new C0343ad(this.f11020th, th.de.ppp.qw.mmm(runnable));
            Message obtain = Message.obtain(this.f11020th, adVar);
            if (this.f11021yj) {
                obtain.setAsynchronous(true);
            }
            this.f11020th.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return adVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public th.de qw() {
        return new qw(this.f11020th, this.f11021yj);
    }
}
