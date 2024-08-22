package fe.fe.nn.when;

import android.os.Handler;
import android.os.HandlerThread;

public class qw extends HandlerThread {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f2416ad;

    /* renamed from: th  reason: collision with root package name */
    public static Handler f2417th;

    public qw() {
        super("SSOHandlerThread", 10);
    }

    public static Handler ad() {
        Handler handler;
        synchronized (qw.class) {
            qw();
            handler = f2417th;
        }
        return handler;
    }

    public static void qw() {
        if (f2416ad == null) {
            qw qwVar = new qw();
            f2416ad = qwVar;
            qwVar.start();
            f2417th = new Handler(f2416ad.getLooper());
        }
    }
}
