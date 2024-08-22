package com.baidu.apollon.b;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.net.ssl.X509TrustManager;

public class b implements X509TrustManager {
    public final X509TrustManager a = d.a();
    public final Set<c> b;

    public b(@NonNull Set<c> set) {
        this.b = set;
    }

    public static boolean a(List<X509Certificate> list, Set<c> set) {
        for (X509Certificate cVar : list) {
            if (set.contains(new c((Certificate) cVar))) {
                return true;
            }
        }
        return false;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.a.checkServerTrusted(x509CertificateArr, str);
        if (!this.b.isEmpty() && !a(Arrays.asList(x509CertificateArr), this.b)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Pin verification failed");
            sb.append("\n  Configured pins: ");
            for (c append : this.b) {
                sb.append(append);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("\n  Peer certificate chain: ");
            for (Certificate certificate : Arrays.asList(x509CertificateArr)) {
                sb.append("\n    ");
                sb.append(new c(certificate));
                sb.append(" - ");
                sb.append(((X509Certificate) certificate).getSubjectDN());
            }
            throw new CertificateException(sb.toString());
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
