package fe.fe.ddd.p001switch.pf;

import com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection;
import com.baidu.searchbox.http.okurlconnection.URLFilter;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;

/* renamed from: fe.fe.ddd.switch.pf.fe  reason: invalid package */
public final class fe extends ad {

    /* renamed from: ad  reason: collision with root package name */
    public final OkHttpURLConnection f1614ad;

    public fe(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(new OkHttpURLConnection(url, okHttpClient, uRLFilter));
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f1614ad.qw.hostnameVerifier();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f1614ad.qw.sslSocketFactory();
    }

    public Handshake qw() {
        OkHttpURLConnection okHttpURLConnection = this.f1614ad;
        if (okHttpURLConnection.f1050rg != null) {
            return okHttpURLConnection.ppp;
        }
        throw new IllegalStateException("Connection has not yet been established");
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        OkHttpURLConnection okHttpURLConnection = this.f1614ad;
        okHttpURLConnection.qw = okHttpURLConnection.qw.newBuilder().hostnameVerifier(hostnameVerifier).build();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != null) {
            OkHttpURLConnection okHttpURLConnection = this.f1614ad;
            okHttpURLConnection.qw = okHttpURLConnection.qw.newBuilder().sslSocketFactory(sSLSocketFactory).build();
            return;
        }
        throw new IllegalArgumentException("sslSocketFactory == null");
    }

    public fe(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        this.f1614ad = okHttpURLConnection;
    }
}
