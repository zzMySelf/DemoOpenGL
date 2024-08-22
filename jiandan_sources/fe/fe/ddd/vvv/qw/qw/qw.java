package fe.fe.ddd.vvv.qw.qw;

import android.os.Handler;
import android.os.Looper;

public class qw {
    public static synchronized void qw(Runnable runnable, String str, long j, boolean z) {
        synchronized (qw.class) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }
}
