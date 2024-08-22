package fe.th.de.rrr.yj;

import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.EventListener;
import fe.th.de.Cif;
import fe.th.de.qqq;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class rg {

    /* renamed from: ad  reason: collision with root package name */
    public final fe f5504ad;

    /* renamed from: de  reason: collision with root package name */
    public final Call f5505de;

    /* renamed from: fe  reason: collision with root package name */
    public final EventListener f5506fe;
    public final fe.th.de.qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public List<Proxy> f5507rg = Collections.emptyList();

    /* renamed from: th  reason: collision with root package name */
    public int f5508th;

    /* renamed from: uk  reason: collision with root package name */
    public final List<qqq> f5509uk = new ArrayList();

    /* renamed from: yj  reason: collision with root package name */
    public List<InetSocketAddress> f5510yj = Collections.emptyList();

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f5511ad = 0;
        public final List<qqq> qw;

        public qw(List<qqq> list) {
            this.qw = list;
        }

        public boolean ad() {
            return this.f5511ad < this.qw.size();
        }

        public void de() {
            for (int i2 = 0; i2 < this.qw.size(); i2++) {
                if (this.qw.get(i2).fe().getAddress() instanceof Inet4Address) {
                    this.f5511ad = i2;
                    return;
                }
            }
        }

        public qqq fe() {
            if (ad()) {
                List<qqq> list = this.qw;
                int i2 = this.f5511ad;
                this.f5511ad = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<qqq> qw() {
            return new ArrayList(this.qw);
        }
    }

    public rg(fe.th.de.qw qwVar, fe feVar, Call call, EventListener eventListener) {
        this.qw = qwVar;
        this.f5504ad = feVar;
        this.f5505de = call;
        this.f5506fe = eventListener;
        uk(qwVar.m345if(), qwVar.yj());
    }

    public static String ad(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public boolean de() {
        return fe() || !this.f5509uk.isEmpty();
    }

    public final boolean fe() {
        return this.f5508th < this.f5507rg.size();
    }

    public void qw(qqq qqq, IOException iOException) {
        if (!(qqq.ad().type() == Proxy.Type.DIRECT || this.qw.i() == null)) {
            this.qw.i().connectFailed(this.qw.m345if().c(), qqq.ad().address(), iOException);
        }
        this.f5504ad.ad(qqq);
    }

    public qw rg() throws IOException {
        if (de()) {
            ArrayList arrayList = new ArrayList();
            while (fe()) {
                Proxy th2 = th();
                int size = this.f5510yj.size();
                for (int i2 = 0; i2 < size; i2++) {
                    qqq qqq = new qqq(this.qw, th2, this.f5510yj.get(i2));
                    if (this.f5504ad.de(qqq)) {
                        this.f5509uk.add(qqq);
                    } else {
                        arrayList.add(qqq);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f5509uk);
                this.f5509uk.clear();
            }
            return new qw(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final Proxy th() throws IOException {
        if (fe()) {
            List<Proxy> list = this.f5507rg;
            int i2 = this.f5508th;
            this.f5508th = i2 + 1;
            Proxy proxy = list.get(i2);
            yj(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.qw.m345if().m338if() + "; exhausted proxy configurations: " + this.f5507rg);
    }

    public final void uk(Cif ifVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f5507rg = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.qw.i().select(ifVar.c());
            if (select == null || select.isEmpty()) {
                list = fe.mmm(Proxy.NO_PROXY);
            } else {
                list = fe.nn(select);
            }
            this.f5507rg = list;
        }
        this.f5508th = 0;
    }

    public final void yj(Proxy proxy) throws IOException {
        String str;
        int i2;
        this.f5510yj = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.qw.m345if().m338if();
            i2 = this.qw.m345if().qqq();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = ad(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f5510yj.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            this.f5506fe.dnsStart(this.f5505de, str);
            List<InetAddress> lookup = this.qw.de().lookup(str);
            if (!lookup.isEmpty()) {
                this.f5506fe.dnsEnd(this.f5505de, str, lookup);
                int size = lookup.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f5510yj.add(new InetSocketAddress(lookup.get(i3), i2));
                }
                return;
            }
            throw new UnknownHostException(this.qw.de() + " returned no addresses for " + str);
        }
    }
}
