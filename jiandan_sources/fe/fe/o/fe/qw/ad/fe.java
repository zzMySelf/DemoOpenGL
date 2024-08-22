package fe.fe.o.fe.qw.ad;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class fe implements HostnameVerifier {
    public fe(ad adVar) {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        HttpsURLConnection.getDefaultHostnameVerifier();
        return true;
    }
}
