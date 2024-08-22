package fe.mmm.qw.ppp.ad.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.concurrent.atomic.AtomicBoolean;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f8196ad;

    /* renamed from: de  reason: collision with root package name */
    public static long f8197de;

    /* renamed from: fe  reason: collision with root package name */
    public static long f8198fe;
    public static boolean qw;

    static {
        new AtomicBoolean(false);
    }

    public static boolean ad(Context context) {
        if (System.currentTimeMillis() - f8197de > 10000) {
            qw = de(context);
            f8197de = System.currentTimeMillis();
            fe.mmm.qw.i.qw.ad("NetworkState", "isConnected--after delay time--" + qw);
            return qw;
        }
        fe.mmm.qw.i.qw.ad("NetworkState", "isConnected--within delay time--" + qw);
        return qw;
    }

    public static boolean de(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean fe(Context context) {
        if (System.currentTimeMillis() - f8198fe > 10000) {
            f8196ad = rg(context);
            f8198fe = System.currentTimeMillis();
            fe.mmm.qw.i.qw.ad("NetworkState", "isWifi--after delay time--" + f8196ad);
            return f8196ad;
        }
        fe.mmm.qw.i.qw.ad("NetworkState", "isWifi--within delay time--" + f8196ad);
        return f8196ad;
    }

    public static String qw(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String typeName;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (typeName = activeNetworkInfo.getTypeName()) == null) {
            return null;
        }
        if (typeName.toLowerCase().contains("mobile")) {
            typeName = activeNetworkInfo.getExtraInfo();
        }
        if (typeName == null) {
            return null;
        }
        return typeName.toLowerCase();
    }

    public static boolean rg(Context context) {
        return new de().qw(context);
    }
}
