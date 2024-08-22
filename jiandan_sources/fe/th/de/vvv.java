package fe.th.de;

import com.duxiaoman.okhttp3.internal.URLFilter;
import com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection;
import fe.th.de.ggg;
import fe.th.de.rrr.pf.de;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class vvv implements URLStreamHandlerFactory, Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public ggg f5555ad;

    /* renamed from: th  reason: collision with root package name */
    public URLFilter f5556th;

    public class qw extends URLStreamHandler {
        public final /* synthetic */ String qw;

        public qw(String str) {
            this.qw = str;
        }

        public int getDefaultPort() {
            if (this.qw.equals("http")) {
                return 80;
            }
            if (this.qw.equals("https")) {
                return 443;
            }
            throw new AssertionError();
        }

        public URLConnection openConnection(URL url) {
            return vvv.this.fe(url);
        }

        public URLConnection openConnection(URL url, Proxy proxy) {
            return vvv.this.rg(url, proxy);
        }
    }

    public vvv(ggg ggg) {
        this.f5555ad = ggg;
    }

    public ggg ad() {
        return this.f5555ad;
    }

    public URLStreamHandler createURLStreamHandler(String str) {
        if (str.equals("http") || str.equals("https")) {
            return new qw(str);
        }
        return null;
    }

    /* renamed from: de */
    public vvv clone() {
        return new vvv(this.f5555ad);
    }

    public HttpURLConnection fe(URL url) {
        return rg(url, this.f5555ad.rrr());
    }

    public HttpURLConnection rg(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        ggg.ad nn = this.f5555ad.nn();
        nn.ppp(proxy);
        ggg ad2 = nn.ad();
        if (protocol.equals("http")) {
            return new OkHttpURLConnection(url, ad2, this.f5556th);
        }
        if (protocol.equals("https")) {
            return new de(url, ad2, this.f5556th);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public vvv th(ggg ggg) {
        this.f5555ad = ggg;
        return this;
    }
}
