package fe.th.de;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.th.de.rrr.when.de;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
import okio.ByteString;

public final class fe {

    /* renamed from: de  reason: collision with root package name */
    public static final fe f5153de = new qw().qw();

    /* renamed from: ad  reason: collision with root package name */
    public final de f5154ad;
    public final Set<ad> qw;

    public static final class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final String f5155ad;

        /* renamed from: de  reason: collision with root package name */
        public final String f5156de;

        /* renamed from: fe  reason: collision with root package name */
        public final ByteString f5157fe;
        public final String qw;

        public boolean equals(Object obj) {
            if (obj instanceof ad) {
                ad adVar = (ad) obj;
                return this.qw.equals(adVar.qw) && this.f5156de.equals(adVar.f5156de) && this.f5157fe.equals(adVar.f5157fe);
            }
        }

        public int hashCode() {
            return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5156de.hashCode()) * 31) + this.f5157fe.hashCode();
        }

        public boolean qw(String str) {
            if (!this.qw.startsWith(CertificatePinner.Pin.WILDCARD)) {
                return str.equals(this.f5155ad);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f5155ad.length()) {
                String str2 = this.f5155ad;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return this.f5156de + this.f5157fe.base64();
        }
    }

    public static final class qw {
        public final List<ad> qw = new ArrayList();

        public fe qw() {
            return new fe(new LinkedHashSet(this.qw), (de) null);
        }
    }

    public fe(Set<ad> set, de deVar) {
        this.qw = set;
        this.f5154ad = deVar;
    }

    public static String de(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + rg((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static ByteString fe(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static ByteString rg(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public List<ad> ad(String str) {
        List<ad> emptyList = Collections.emptyList();
        for (ad next : this.qw) {
            if (next.qw(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fe) {
            fe feVar = (fe) obj;
            if (!fe.th.de.rrr.fe.vvv(this.f5154ad, feVar.f5154ad) || !this.qw.equals(feVar.qw)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        de deVar = this.f5154ad;
        return ((deVar != null ? deVar.hashCode() : 0) * 31) + this.qw.hashCode();
    }

    public void qw(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<ad> ad2 = ad(str);
        if (!ad2.isEmpty()) {
            de deVar = this.f5154ad;
            if (deVar != null) {
                list = deVar.qw(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = ad2.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    ad adVar = ad2.get(i3);
                    if (adVar.f5156de.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = rg(x509Certificate);
                        }
                        if (adVar.f5157fe.equals(byteString)) {
                            return;
                        }
                    } else if (adVar.f5156de.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = fe(x509Certificate);
                        }
                        if (adVar.f5157fe.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + adVar.f5156de);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(de(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = ad2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(ad2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public fe th(de deVar) {
        if (fe.th.de.rrr.fe.vvv(this.f5154ad, deVar)) {
            return this;
        }
        return new fe(this.qw, deVar);
    }
}
