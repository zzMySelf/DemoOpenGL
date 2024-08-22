package com.unionpay.a;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class b implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private X509TrustManager f6077a = null;

    /* renamed from: b  reason: collision with root package name */
    private X509TrustManagerExtensions f6078b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f6079c;

    public b(Context context) {
        this.f6079c = context;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length != 0) {
            this.f6077a = (X509TrustManager) trustManagers[0];
            if (Build.VERSION.SDK_INT > 23) {
                this.f6078b = new X509TrustManagerExtensions(this.f6077a);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.f6077a.checkClientTrusted(x509CertificateArr, str);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        boolean z;
        X509TrustManagerExtensions x509TrustManagerExtensions;
        if (Build.VERSION.SDK_INT <= 23 || (x509TrustManagerExtensions = this.f6078b) == null) {
            this.f6077a.checkServerTrusted(x509CertificateArr, str);
        } else {
            x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, "");
        }
        boolean z2 = false;
        try {
            X500Principal issuerX500Principal = x509CertificateArr[0].getIssuerX500Principal();
            ArrayList arrayList = new ArrayList(0);
            arrayList.add(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*");
            String a2 = com.unionpay.utils.b.a(this.f6079c);
            if (!TextUtils.isEmpty(a2)) {
                arrayList.add(a2);
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    z = false;
                    break;
                } else if (Pattern.compile((String) arrayList.get(i2), 2).matcher(issuerX500Principal.getName()).matches()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                X500Principal subjectX500Principal = x509CertificateArr[0].getSubjectX500Principal();
                ArrayList arrayList2 = new ArrayList(0);
                arrayList2.add(".*CN=.*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)");
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList2.size()) {
                        break;
                    } else if (Pattern.compile((String) arrayList2.get(i3), 2).matcher(subjectX500Principal.getName()).matches()) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    throw new CertificateException();
                }
                return;
            }
            throw new CertificateException();
        } catch (Exception e2) {
            throw new CertificateException();
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.f6077a.getAcceptedIssuers();
    }
}
