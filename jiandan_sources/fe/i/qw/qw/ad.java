package fe.i.qw.qw;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.net.ssl.X509TrustManager;

public class ad implements X509TrustManager {

    /* renamed from: ad  reason: collision with root package name */
    public final Set<de> f4489ad;
    public final X509TrustManager qw = fe.qw();

    public ad(@NonNull Set<de> set) {
        this.f4489ad = set;
    }

    public static boolean qw(List<X509Certificate> list, Set<de> set) {
        for (X509Certificate deVar : list) {
            if (set.contains(new de(deVar))) {
                return true;
            }
        }
        return false;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.qw.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.qw.checkServerTrusted(x509CertificateArr, str);
        if (!this.f4489ad.isEmpty() && !qw(Arrays.asList(x509CertificateArr), this.f4489ad)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Pin verification failed");
            sb.append("\n  Configured pins: ");
            for (de append : this.f4489ad) {
                sb.append(append);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("\n  Peer certificate chain: ");
            for (Certificate certificate : Arrays.asList(x509CertificateArr)) {
                sb.append("\n    ");
                sb.append(new de(certificate));
                sb.append(" - ");
                sb.append(((X509Certificate) certificate).getSubjectDN());
            }
            throw new CertificateException(sb.toString());
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.qw.getAcceptedIssuers();
    }
}
