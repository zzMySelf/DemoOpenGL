package fe.th.de.rrr.when;

import com.duxiaoman.okhttp3.internal.tls.TrustRootIndex;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class ad implements TrustRootIndex {
    public final Map<X500Principal, Set<X509Certificate>> qw = new LinkedHashMap();

    public ad(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = this.qw.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.qw.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ad) || !((ad) obj).qw.equals(this.qw)) {
            return false;
        }
        return true;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.qw.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public int hashCode() {
        return this.qw.hashCode();
    }
}
