package fe.mmm.qw.nn.de;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public ConnectivityManager f8117ad;
    public Context qw = null;

    public rg(Context context) {
        this.qw = context;
    }

    public Boolean ad() {
        if (qw() == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final int qw() {
        Context context = this.qw;
        if (context != null) {
            this.f8117ad = (ConnectivityManager) context.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.f8117ad;
        if (connectivityManager == null) {
            return 3;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return 3;
            }
            return 0;
        } catch (Exception unused) {
        }
    }
}
