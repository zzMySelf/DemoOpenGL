package fe.mmm.qw.nn.qw.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public String f8134ad;

    /* renamed from: de  reason: collision with root package name */
    public String f8135de;

    /* renamed from: fe  reason: collision with root package name */
    public int f8136fe;
    public String qw;

    public qw(Context context) {
        ad(context);
    }

    public final void ad(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                this.f8135de = "wifi";
            } else {
                qw(context, networkInfo);
                this.f8135de = this.qw;
            }
            this.f8136fe = networkInfo.getSubtype();
            networkInfo.getSubtypeName();
        }
    }

    public String de() {
        return this.f8135de;
    }

    public int fe() {
        return this.f8136fe;
    }

    public final void qw(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (!(networkInfo.getExtraInfo() == null || (lowerCase = networkInfo.getExtraInfo().toLowerCase()) == null)) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.qw = lowerCase;
                this.f8134ad = "10.0.0.172";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.qw = lowerCase;
                this.f8134ad = "10.0.0.200";
                return;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.qw = lowerCase;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0) {
            this.f8134ad = defaultHost;
            if (!"10.0.0.172".equals(defaultHost.trim()) && !"10.0.0.200".equals(this.f8134ad.trim())) {
                Integer.toString(defaultPort);
            }
        }
    }
}
