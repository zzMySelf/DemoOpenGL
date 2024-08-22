package fe.th.de.rrr.p019if;

import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* renamed from: fe.th.de.rrr.if.de  reason: invalid package */
public class de extends yj {
    public static de rrr() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new de();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public X509TrustManager eee(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.eee(sSLSocketFactory);
        }
        try {
            Object qqq = yj.qqq(sSLSocketFactory, Object.class, "sslParameters");
            if (qqq != null) {
                return (X509TrustManager) yj.qqq(qqq, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
        }
    }

    public String ggg(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.ggg(sSLSocket);
    }

    public SSLContext ppp() {
        try {
            return SSLContext.getInstance("TLSv1.3", tt());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", tt());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    public final Provider tt() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) yj.ad(list).toArray(new String[0]));
            return;
        }
        super.uk(sSLSocket, str, list);
    }

    public void yj(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
