package fe.th.de.rrr.pf;

import com.duxiaoman.okhttp3.internal.URLFilter;
import com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection;
import fe.th.de.ggg;
import fe.th.de.o;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class de extends ad {

    /* renamed from: ad  reason: collision with root package name */
    public final OkHttpURLConnection f5439ad;

    public de(URL url, ggg ggg, URLFilter uRLFilter) {
        this(new OkHttpURLConnection(url, ggg, uRLFilter));
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f5439ad.qw.ppp();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f5439ad.qw.e();
    }

    public o qw() {
        OkHttpURLConnection okHttpURLConnection = this.f5439ad;
        if (okHttpURLConnection.f3802rg != null) {
            return okHttpURLConnection.ppp;
        }
        throw new IllegalStateException("Connection has not yet been established");
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        OkHttpURLConnection okHttpURLConnection = this.f5439ad;
        ggg.ad nn = okHttpURLConnection.qw.nn();
        nn.m335if(hostnameVerifier);
        okHttpURLConnection.qw = nn.ad();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != null) {
            OkHttpURLConnection okHttpURLConnection = this.f5439ad;
            ggg.ad nn = okHttpURLConnection.qw.nn();
            nn.vvv(sSLSocketFactory);
            okHttpURLConnection.qw = nn.ad();
            return;
        }
        throw new IllegalArgumentException("sslSocketFactory == null");
    }

    public de(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        this.f5439ad = okHttpURLConnection;
    }
}
