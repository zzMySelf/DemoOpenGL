package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.th.ggg;

public class pf {

    /* renamed from: ad  reason: collision with root package name */
    public String f2534ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2535de;

    /* renamed from: fe  reason: collision with root package name */
    public n f2536fe = n.TYPE_UNKNOWN;
    public String qw;

    public pf(Context context) {
        ad(context);
    }

    public final void ad(Context context) {
        NetworkInfo o2 = ggg.o(context);
        if (o2 == null) {
            return;
        }
        if ("wifi".equals(o2.getTypeName().toLowerCase())) {
            this.f2536fe = n.TYPE_WF;
            this.f2535de = false;
            return;
        }
        de(context, o2);
        this.f2536fe = qw(o2);
    }

    public final void de(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (!(networkInfo.getExtraInfo() == null || (lowerCase = networkInfo.getExtraInfo().toLowerCase()) == null)) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.f2535de = true;
                this.qw = "10.0.0.172";
            } else if (lowerCase.startsWith("ctwap")) {
                this.f2535de = true;
                this.qw = "10.0.0.200";
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.f2535de = false;
                return;
            }
            this.f2534ad = "80";
            return;
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0) {
            this.f2535de = false;
            return;
        }
        this.qw = defaultHost;
        if (!"10.0.0.172".equals(defaultHost.trim()) && !"10.0.0.200".equals(this.qw.trim())) {
            this.f2535de = false;
            this.f2534ad = Integer.toString(defaultPort);
            return;
        }
        this.f2535de = true;
        this.f2534ad = "80";
    }

    public boolean fe() {
        return this.f2535de;
    }

    public final n qw(NetworkInfo networkInfo) {
        String lowerCase = networkInfo.getTypeName().toLowerCase();
        n nVar = n.TYPE_UNKNOWN;
        if ("wifi".equals(lowerCase)) {
            return n.TYPE_WF;
        }
        n nVar2 = n.TYPE_2G;
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 11:
                return nVar2;
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return n.TYPE_3G;
            default:
                return n.TYPE_4G;
        }
    }

    public String rg() {
        return this.qw;
    }

    public String th() {
        return this.f2534ad;
    }

    public n yj() {
        return this.f2536fe;
    }
}
