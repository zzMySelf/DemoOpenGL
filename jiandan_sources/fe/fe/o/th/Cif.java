package fe.fe.o.th;

import android.net.TrafficStats;
import android.os.Build;

/* renamed from: fe.fe.o.th.if  reason: invalid class name */
public class Cif {
    public static void ad(int i2) {
        if (Build.VERSION.SDK_INT >= 15) {
            TrafficStats.setThreadStatsTag(i2);
        }
    }

    public static void qw() {
        if (Build.VERSION.SDK_INT >= 15) {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
