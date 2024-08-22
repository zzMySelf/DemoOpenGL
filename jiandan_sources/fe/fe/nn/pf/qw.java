package fe.fe.nn.pf;

import android.os.Handler;
import android.os.HandlerThread;

public class qw extends HandlerThread {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f2296ad;

    /* renamed from: th  reason: collision with root package name */
    public static Handler f2297th;

    public qw() {
        super("BackgroundThread", 10);
    }

    public static Handler ad() {
        Handler handler;
        synchronized (qw.class) {
            qw();
            handler = f2297th;
        }
        return handler;
    }

    public static void qw() {
        if (f2296ad == null) {
            qw qwVar = new qw();
            f2296ad = qwVar;
            qwVar.start();
            f2297th = new Handler(f2296ad.getLooper());
        }
    }
}
