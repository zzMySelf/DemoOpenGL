package fe.fe.o.fe.qw.ad;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class rg implements HostnameVerifier {
    public final /* synthetic */ String qw;

    public rg(ad adVar, String str) {
        this.qw = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.qw, sSLSession);
    }
}
