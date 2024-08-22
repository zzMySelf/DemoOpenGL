package fe.fe.o.fe.qw.de;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public class ad implements HttpRequestInterceptor {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ qw f2525ad;

    public ad(qw qwVar) {
        this.f2525ad = qwVar;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
        for (String str : this.f2525ad.f2549th.keySet()) {
            httpRequest.addHeader(str, (String) this.f2525ad.f2549th.get(str));
        }
    }
}
