package fe.th.qw.qw.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class uk {
    public static int qw(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return 1;
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null) {
                        NetworkInfo.State state2 = networkInfo2.getState();
                        String subtypeName = networkInfo2.getSubtypeName();
                        if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                case 18:
                                    return 3;
                                case 13:
                                    return 4;
                                case 20:
                                    return 5;
                                default:
                                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA")) {
                                        if (!subtypeName.equalsIgnoreCase("WCDMA")) {
                                            if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                                                return 3;
                                            }
                                            return 0;
                                        }
                                    }
                                    return 3;
                            }
                            return -2;
                        }
                    }
                }
            }
            return -1;
        } catch (Exception unused) {
            return -2;
        }
    }
}
