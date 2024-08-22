package fe.th.de;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;

public final class qqq {

    /* renamed from: ad  reason: collision with root package name */
    public final Proxy f5231ad;

    /* renamed from: de  reason: collision with root package name */
    public final InetSocketAddress f5232de;
    public final qw qw;

    public qqq(qw qwVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (qwVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.qw = qwVar;
            this.f5231ad = proxy;
            this.f5232de = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Proxy ad() {
        return this.f5231ad;
    }

    public boolean de() {
        return this.qw.f5236i != null && this.f5231ad.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof qqq) {
            qqq qqq = (qqq) obj;
            return qqq.qw.equals(this.qw) && qqq.f5231ad.equals(this.f5231ad) && qqq.f5232de.equals(this.f5232de);
        }
    }

    public InetSocketAddress fe() {
        return this.f5232de;
    }

    public int hashCode() {
        return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5231ad.hashCode()) * 31) + this.f5232de.hashCode();
    }

    public qw qw() {
        return this.qw;
    }

    public String toString() {
        return "Route{" + this.f5232de + "}";
    }
}
