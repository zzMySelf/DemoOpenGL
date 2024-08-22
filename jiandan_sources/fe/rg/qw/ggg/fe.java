package fe.rg.qw.ggg;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class fe {
    public static final double qw;

    static {
        double d = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        qw = d;
    }

    @TargetApi(17)
    public static long ad() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double qw(long j) {
        return ((double) (ad() - j)) * qw;
    }
}
