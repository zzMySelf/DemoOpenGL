package fe.fe.o.fe.qw.ad;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.n.a;
import com.baidu.down.loopj.android.http.n;
import com.baidu.uaq.dnsproxy.DNSProxy;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import fe.fe.o.fe.qw.de.pf;
import fe.fe.o.th.fe;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import kotlin.text.Typography;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class ad {

    /* renamed from: i  reason: collision with root package name */
    public static int f2510i = 30000;

    /* renamed from: uk  reason: collision with root package name */
    public static int f2511uk = 30000;

    /* renamed from: ad  reason: collision with root package name */
    public pf f2512ad;

    /* renamed from: de  reason: collision with root package name */
    public Context f2513de;

    /* renamed from: fe  reason: collision with root package name */
    public th f2514fe;
    public boolean qw = true;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f2515rg = false;

    /* renamed from: th  reason: collision with root package name */
    public HostnameVerifier f2516th;

    /* renamed from: yj  reason: collision with root package name */
    public String f2517yj = "";

    public ad(Context context, boolean z) {
        this.f2513de = context.getApplicationContext();
        when();
        this.f2512ad = new pf(this.f2513de);
        this.f2515rg = z;
    }

    public ad(Context context, long[] jArr) {
        this.f2513de = context.getApplicationContext();
        when();
        pf();
        this.f2514fe = new th(jArr);
    }

    public final String ad(List list, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) it.next();
            stringBuffer.append(Typography.amp);
            String name = nameValuePair.getName();
            if (z) {
                name = Uri.encode(name);
            }
            stringBuffer.append(name);
            stringBuffer.append(a.h);
            stringBuffer.append(Uri.encode(nameValuePair.getValue()));
        }
        return stringBuffer.toString();
    }

    public HttpURLConnection de(String str, Map map) {
        return fe(str, map, ShareTarget.METHOD_GET, (List) null, false, true);
    }

    public HttpURLConnection fe(String str, Map map, String str2, List list, boolean z, boolean z2) {
        HostnameVerifier hostnameVerifier;
        if (m161switch()) {
            str = qw(str);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(f2511uk);
        httpURLConnection.setReadTimeout(f2510i);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(this.qw);
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.addRequestProperty(str3, (String) map.get(str3));
            }
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            if (z) {
                try {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init((KeyManager[]) null, new X509TrustManager[]{new de(this)}, new SecureRandom());
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(instance.getSocketFactory());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (m161switch() && (hostnameVerifier = this.f2516th) != null) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
                httpURLConnection.addRequestProperty("host", this.f2517yj);
                this.f2516th = null;
            } else if (z2) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new fe(this));
            }
        }
        httpURLConnection.setRequestMethod(str2);
        if (str2.equals("POST") && !i(httpURLConnection, list)) {
            httpURLConnection.setFixedLengthStreamingMode(0);
        }
        return httpURLConnection;
    }

    public final boolean i(HttpURLConnection httpURLConnection, List list) {
        if (list == null) {
            return false;
        }
        String ad2 = ad(list, true);
        httpURLConnection.setFixedLengthStreamingMode(ad2.length());
        httpURLConnection.setDoOutput(true);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type"))) {
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(ad2.getBytes());
        dataOutputStream.close();
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public th m160if() {
        return this.f2514fe;
    }

    public n o() {
        return this.f2512ad.yj();
    }

    public void pf() {
        this.f2512ad = new pf(this.f2513de);
        int i2 = uk() ? CometHttpRequestInterceptor.a : 30000;
        f2511uk = i2;
        f2510i = i2;
    }

    public final String qw(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String host = new URL(str).getHost();
                System.currentTimeMillis();
                JSONObject iPByDomains = DNSProxy.getInstance(this.f2513de).getIPByDomains(host);
                if (iPByDomains != null && !TextUtils.isEmpty(iPByDomains.getString(host))) {
                    String replace = str.replace(host, iPByDomains.getString(host));
                    this.f2517yj = host;
                    this.f2516th = new rg(this, host);
                    return replace;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f2515rg = false;
        return str;
    }

    public HttpURLConnection rg(String str, Map map, boolean z) {
        return fe(str, map, ShareTarget.METHOD_GET, (List) null, z, true);
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m161switch() {
        return this.f2515rg && fe.de(this.f2513de, "pref_config_host_type", fe.qw).equals(fe.f2668ad);
    }

    public HttpURLConnection th(String str, Map map, boolean z, boolean z2) {
        return fe(str, map, ShareTarget.METHOD_GET, (List) null, z, z2);
    }

    public boolean uk() {
        return this.f2512ad.fe();
    }

    public final void when() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public void yj(boolean z) {
        this.qw = z;
    }
}
