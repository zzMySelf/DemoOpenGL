package fe.mmm.qw.a.uk;

import android.os.Handler;
import android.os.Looper;

public class fe {
    public static volatile Handler qw;

    public static Handler qw() {
        if (qw == null) {
            synchronized (fe.class) {
                if (qw == null) {
                    qw = new Handler(Looper.getMainLooper());
                }
            }
        }
        return qw;
    }
}
