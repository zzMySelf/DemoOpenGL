package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.n;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class ppp extends DefaultHttpClient {

    /* renamed from: th  reason: collision with root package name */
    public static final String f2537th = ppp.class.getSimpleName();

    /* renamed from: ad  reason: collision with root package name */
    public String f2538ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2539de;

    /* renamed from: fe  reason: collision with root package name */
    public n f2540fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public RuntimeException f2541rg = new IllegalStateException("ProxyHttpClient created and never closed");

    public ppp(Context context, String str, ThreadSafeClientConnManager threadSafeClientConnManager, BasicHttpParams basicHttpParams) {
        super(threadSafeClientConnManager, basicHttpParams);
        qw(context, str, (pf) null);
    }

    public boolean ad() {
        return this.f2539de;
    }

    public HttpParams createHttpParams() {
        HttpParams createHttpParams = ppp.super.createHttpParams();
        HttpProtocolParams.setUseExpectContinue(createHttpParams, false);
        return createHttpParams;
    }

    public n de() {
        return this.f2540fe;
    }

    public void finalize() {
        ppp.super.finalize();
        RuntimeException runtimeException = this.f2541rg;
    }

    public void qw(Context context, String str, pf pfVar) {
        int i2;
        HttpParams httpParams;
        if (pfVar == null) {
            pfVar = new pf(context);
        }
        this.f2539de = pfVar.fe();
        this.qw = pfVar.rg();
        this.f2538ad = pfVar.th();
        this.f2540fe = pfVar.yj();
        String str2 = this.qw;
        if (str2 == null || str2.length() <= 0) {
            getParams().setParameter("http.route.default-proxy", (Object) null);
            httpParams = getParams();
            i2 = 30000;
        } else {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.qw, Integer.valueOf(this.f2538ad).intValue()));
            httpParams = getParams();
            i2 = CometHttpRequestInterceptor.a;
        }
        HttpConnectionParams.setConnectionTimeout(httpParams, i2);
        HttpConnectionParams.setSoTimeout(getParams(), i2);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }
}
