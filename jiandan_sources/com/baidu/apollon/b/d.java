package com.baidu.apollon.b;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class d {
    public static final X509TrustManager a = b();

    public static X509TrustManager a() {
        return a;
    }

    public static X509TrustManager b() {
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
}
