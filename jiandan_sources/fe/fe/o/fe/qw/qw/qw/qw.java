package fe.fe.o.fe.qw.qw.qw;

import android.text.TextUtils;
import com.baidu.down.loopj.android.a.a.b;
import com.baidu.down.loopj.android.http.exp.HandlerRetryException;
import fe.fe.o.ad.yj;
import fe.fe.o.de.uk.de;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.fe.qw.de.vvv;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class qw implements b {

    /* renamed from: ad  reason: collision with root package name */
    public HttpContext f2573ad;

    /* renamed from: de  reason: collision with root package name */
    public HttpUriRequest f2574de;

    /* renamed from: fe  reason: collision with root package name */
    public HttpUriRequest f2575fe;
    public AbstractHttpClient qw;

    /* renamed from: rg  reason: collision with root package name */
    public HttpResponse f2576rg;

    /* renamed from: th  reason: collision with root package name */
    public vvv f2577th;

    public qw(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest) {
        this.f2573ad = httpContext;
        this.qw = abstractHttpClient;
        this.f2574de = httpUriRequest;
        this.f2577th = abstractHttpClient.getHttpRequestRetryHandler();
    }

    public int a() {
        return this.f2576rg.getStatusLine().getStatusCode();
    }

    public String a(String str) {
        Header firstHeader = this.f2574de.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public String a(boolean z) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!z) {
            sb.append("Uri:");
            sb.append(this.f2574de.getURI().toString());
            sb.append(" ");
            sb.append(this.f2576rg.getStatusLine().getStatusCode());
        } else {
            sb = new StringBuilder();
            sb.append("Uri:");
            sb.append(this.f2574de.getURI().toString());
        }
        sb.append(StringUtils.LF);
        sb2.append(sb.toString());
        Header[] allHeaders = this.f2574de.getAllHeaders();
        if (allHeaders != null) {
            for (Header header : allHeaders) {
                sb2.append(header.toString() + StringUtils.LF);
            }
            sb2.append(StringUtils.LF);
        }
        if (!z) {
            sb2.append(this.f2576rg.getStatusLine().getReasonPhrase() + ": \n");
            Header[] allHeaders2 = this.f2576rg.getAllHeaders();
            if (allHeaders2 != null) {
                for (Header header2 : allHeaders2) {
                    sb2.append(header2.toString() + StringUtils.LF);
                }
            }
        }
        return sb2.toString();
    }

    public void a(String str, String str2) {
        this.f2574de.setHeader(str, str2);
    }

    public void ad(o oVar, yj yjVar, boolean z) {
        this.f2576rg = this.qw.execute(this.f2574de, this.f2573ad);
    }

    public de b() {
        de deVar = new de(this.f2574de.getMethod(), this.f2574de.getURI().toString(), this.f2576rg.getStatusLine().getStatusCode());
        for (Header header : this.f2574de.getAllHeaders()) {
            deVar.f2505fe.put(header.getName(), header.getValue());
        }
        for (Header header2 : this.f2576rg.getAllHeaders()) {
            deVar.f2506rg.put(header2.getName(), header2.getValue());
        }
        return deVar;
    }

    public void b(boolean z) {
    }

    public boolean b(String str) {
        return this.f2574de.containsHeader(str);
    }

    public void c(String str) {
        this.f2574de.removeHeaders(str);
    }

    public boolean c() {
        return this.f2574de == null;
    }

    public String d() {
        return this.f2574de.getURI().toString();
    }

    public boolean de(String str) {
        Header[] allHeaders = this.f2574de.getAllHeaders();
        if (str == null) {
            return false;
        }
        HttpGet httpGet = new HttpGet(str);
        httpGet.setHeaders(allHeaders);
        this.f2574de.abort();
        this.f2574de = httpGet;
        return true;
    }

    public void e() {
        try {
            if (this.f2574de != null) {
                this.f2574de.abort();
            }
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    public InputStream f() {
        return this.f2576rg.getEntity().getContent();
    }

    public String fe(String str) {
        Header firstHeader = this.f2576rg.getFirstHeader(str);
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }

    public long g() {
        return this.f2576rg.getEntity().getContentLength();
    }

    public void h() {
        if (this.qw.getConnectionManager() != null) {
            this.qw.getConnectionManager().closeExpiredConnections();
            this.qw.getConnectionManager().closeIdleConnections(60000, TimeUnit.MILLISECONDS);
        }
    }

    public void i() {
        HttpUriRequest httpUriRequest = this.f2575fe;
        if (httpUriRequest != null) {
            this.f2574de = httpUriRequest;
            this.f2575fe = null;
        }
    }

    public void j() {
        this.f2575fe = this.f2574de;
    }

    public void k() {
    }

    public void qw(fe.fe.o.qw.yj yjVar) {
        Header[] allHeaders = this.f2575fe.getAllHeaders();
        HttpGet httpGet = new HttpGet(yjVar.qw);
        httpGet.setHeaders(allHeaders);
        this.f2574de = httpGet;
        if (!yjVar.f2595ad.isEmpty()) {
            for (Map.Entry entry : yjVar.f2595ad.entrySet()) {
                if (TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    this.f2574de.removeHeaders((String) entry.getKey());
                } else {
                    this.f2574de.setHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
    }

    public boolean rg(IOException iOException, int i2, int i3) {
        return this.f2577th.ad(iOException, i2, this.f2573ad, this.f2574de.getURI().getHost());
    }

    public void th(HashSet hashSet) {
        Header firstHeader = this.f2576rg.getFirstHeader("Location");
        if (firstHeader != null) {
            this.f2574de.removeHeaders("host");
            Header[] allHeaders = this.f2574de.getAllHeaders();
            String value = firstHeader.getValue();
            if (!hashSet.contains(value)) {
                try {
                    if (TextUtils.isEmpty(new URI(value).getHost())) {
                        value = this.f2574de.getURI().toString().replace(this.f2574de.getURI().getPath(), value);
                    }
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                    } catch (IllegalArgumentException unused) {
                        throw new RedirectException("Invalid uri: " + this.f2574de.getURI());
                    }
                }
                HttpGet httpGet = new HttpGet(value);
                httpGet.setHeaders(allHeaders);
                this.f2574de.abort();
                this.f2574de = httpGet;
                throw new HandlerRetryException("Redirect");
            }
            throw new RedirectException("### Redirect circle : " + hashSet);
        }
        throw new RedirectException("### Redirect null Location : " + this.f2574de.getURI());
    }
}
