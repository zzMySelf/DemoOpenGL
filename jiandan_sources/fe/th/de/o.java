package fe.th.de;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.duxiaoman.okhttp3.TlsVersion;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public final rg f5217ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<Certificate> f5218de;

    /* renamed from: fe  reason: collision with root package name */
    public final List<Certificate> f5219fe;
    public final TlsVersion qw;

    public o(TlsVersion tlsVersion, rg rgVar, List<Certificate> list, List<Certificate> list2) {
        this.qw = tlsVersion;
        this.f5217ad = rgVar;
        this.f5218de = list;
        this.f5219fe = list2;
    }

    public static o ad(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            rg qw2 = rg.qw(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = fe.mmm(certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = fe.mmm(localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new o(forJavaName, qw2, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public List<Certificate> de() {
        return this.f5219fe;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.qw.equals(oVar.qw) || !this.f5217ad.equals(oVar.f5217ad) || !this.f5218de.equals(oVar.f5218de) || !this.f5219fe.equals(oVar.f5219fe)) {
            return false;
        }
        return true;
    }

    public Principal fe() {
        if (!this.f5219fe.isEmpty()) {
            return ((X509Certificate) this.f5219fe.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public int hashCode() {
        return ((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5217ad.hashCode()) * 31) + this.f5218de.hashCode()) * 31) + this.f5219fe.hashCode();
    }

    public rg qw() {
        return this.f5217ad;
    }

    public List<Certificate> rg() {
        return this.f5218de;
    }

    public Principal th() {
        if (!this.f5218de.isEmpty()) {
            return ((X509Certificate) this.f5218de.get(0)).getSubjectX500Principal();
        }
        return null;
    }
}
