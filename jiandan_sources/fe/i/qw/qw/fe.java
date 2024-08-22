package fe.i.qw.qw;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class fe {
    public static final X509TrustManager qw = ad();

    public static X509TrustManager ad() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            X509TrustManager x509TrustManager = null;
            instance.init((KeyStore) null);
            for (TrustManager trustManager : instance.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                }
            }
            if (x509TrustManager != null) {
                return x509TrustManager;
            }
            throw new IllegalStateException("Should never happen");
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        } catch (KeyStoreException unused2) {
            throw new IllegalStateException("Should never happen");
        }
    }

    public static X509TrustManager qw() {
        return qw;
    }
}
