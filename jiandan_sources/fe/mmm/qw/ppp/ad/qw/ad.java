package fe.mmm.qw.ppp.ad.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ad {
    public static int qw(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 0) {
            return 1;
        }
        return 2;
    }
}
