package fe.th.de;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.duxiaoman.okhttp3.Authenticator;
import com.duxiaoman.okhttp3.Dns;
import com.duxiaoman.okhttp3.Protocol;
import fe.th.de.Cif;
import fe.th.de.rrr.fe;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final Dns f5233ad;

    /* renamed from: de  reason: collision with root package name */
    public final SocketFactory f5234de;

    /* renamed from: fe  reason: collision with root package name */
    public final Authenticator f5235fe;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f5236i;

    /* renamed from: o  reason: collision with root package name */
    public final HostnameVerifier f5237o;

    /* renamed from: pf  reason: collision with root package name */
    public final fe f5238pf;
    public final Cif qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<Protocol> f5239rg;

    /* renamed from: th  reason: collision with root package name */
    public final List<yj> f5240th;

    /* renamed from: uk  reason: collision with root package name */
    public final Proxy f5241uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ProxySelector f5242yj;

    public qw(String str, int i2, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, fe feVar, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<yj> list2, ProxySelector proxySelector) {
        Cif.qw qwVar = new Cif.qw();
        qwVar.vvv(sSLSocketFactory != null ? "https" : "http");
        qwVar.rg(str);
        qwVar.m341if(i2);
        this.qw = qwVar.qw();
        if (dns != null) {
            this.f5233ad = dns;
            if (socketFactory != null) {
                this.f5234de = socketFactory;
                if (authenticator != null) {
                    this.f5235fe = authenticator;
                    if (list != null) {
                        this.f5239rg = fe.nn(list);
                        if (list2 != null) {
                            this.f5240th = fe.nn(list2);
                            if (proxySelector != null) {
                                this.f5242yj = proxySelector;
                                this.f5241uk = proxy;
                                this.f5236i = sSLSocketFactory;
                                this.f5237o = hostnameVerifier;
                                this.f5238pf = feVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public List<yj> ad() {
        return this.f5240th;
    }

    public Dns de() {
        return this.f5233ad;
    }

    public boolean equals(Object obj) {
        if (obj instanceof qw) {
            qw qwVar = (qw) obj;
            return this.qw.equals(qwVar.qw) && fe(qwVar);
        }
    }

    public boolean fe(qw qwVar) {
        return this.f5233ad.equals(qwVar.f5233ad) && this.f5235fe.equals(qwVar.f5235fe) && this.f5239rg.equals(qwVar.f5239rg) && this.f5240th.equals(qwVar.f5240th) && this.f5242yj.equals(qwVar.f5242yj) && fe.vvv(this.f5241uk, qwVar.f5241uk) && fe.vvv(this.f5236i, qwVar.f5236i) && fe.vvv(this.f5237o, qwVar.f5237o) && fe.vvv(this.f5238pf, qwVar.f5238pf) && m345if().qqq() == qwVar.m345if().qqq();
    }

    public int hashCode() {
        int hashCode = (((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5233ad.hashCode()) * 31) + this.f5235fe.hashCode()) * 31) + this.f5239rg.hashCode()) * 31) + this.f5240th.hashCode()) * 31) + this.f5242yj.hashCode()) * 31;
        Proxy proxy = this.f5241uk;
        int i2 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f5236i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f5237o;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        fe feVar = this.f5238pf;
        if (feVar != null) {
            i2 = feVar.hashCode();
        }
        return hashCode4 + i2;
    }

    public ProxySelector i() {
        return this.f5242yj;
    }

    /* renamed from: if  reason: not valid java name */
    public Cif m345if() {
        return this.qw;
    }

    public SocketFactory o() {
        return this.f5234de;
    }

    public SSLSocketFactory pf() {
        return this.f5236i;
    }

    public fe qw() {
        return this.f5238pf;
    }

    public HostnameVerifier rg() {
        return this.f5237o;
    }

    public List<Protocol> th() {
        return this.f5239rg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.qw.m338if());
        sb.append(":");
        sb.append(this.qw.qqq());
        if (this.f5241uk != null) {
            sb.append(", proxy=");
            sb.append(this.f5241uk);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f5242yj);
        }
        sb.append("}");
        return sb.toString();
    }

    public Authenticator uk() {
        return this.f5235fe;
    }

    public Proxy yj() {
        return this.f5241uk;
    }
}
