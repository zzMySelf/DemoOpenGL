package fe.th.de.rrr.when;

import fe.th.de.rrr.p019if.yj;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class de {
    public static de ad(X509TrustManager x509TrustManager) {
        return yj.m350switch().fe(x509TrustManager);
    }

    public abstract List<Certificate> qw(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
