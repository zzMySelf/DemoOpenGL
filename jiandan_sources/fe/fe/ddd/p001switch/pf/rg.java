package fe.fe.ddd.p001switch.pf;

import com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection;
import com.baidu.searchbox.http.okurlconnection.URLFilter;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.OkHttpClient;
import okhttp3.internal.annotations.EverythingIsNonNull;

@EverythingIsNonNull
/* renamed from: fe.fe.ddd.switch.pf.rg  reason: invalid package */
public final class rg implements URLStreamHandlerFactory, Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public OkHttpClient f1617ad;

    /* renamed from: th  reason: collision with root package name */
    public URLFilter f1618th;

    /* renamed from: fe.fe.ddd.switch.pf.rg$qw */
    public class qw extends URLStreamHandler {
        public final /* synthetic */ String qw;

        public qw(String str) {
            this.qw = str;
        }

        public int getDefaultPort() {
            if ("https".equals(this.qw)) {
                return 80;
            }
            if ("https".equals(this.qw)) {
                return 443;
            }
            throw new AssertionError();
        }

        public URLConnection openConnection(URL url) {
            return rg.this.de(url);
        }

        public URLConnection openConnection(URL url, Proxy proxy) {
            return rg.this.fe(url, proxy);
        }
    }

    public rg(OkHttpClient okHttpClient) {
        this.f1617ad = okHttpClient;
    }

    /* renamed from: ad */
    public rg clone() {
        return new rg(this.f1617ad);
    }

    public URLStreamHandler createURLStreamHandler(String str) {
        if ("http".equals(str) || "https".equals(str)) {
            return new qw(str);
        }
        return null;
    }

    public HttpURLConnection de(URL url) {
        return fe(url, this.f1617ad.proxy());
    }

    public HttpURLConnection fe(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient build = this.f1617ad.newBuilder().proxy(proxy).build();
        if ("http".equals(protocol)) {
            return new OkHttpURLConnection(url, build, this.f1618th);
        }
        if ("https".equals(protocol)) {
            return new fe(url, build, this.f1618th);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }
}
