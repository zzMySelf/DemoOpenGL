package fe.fe.nn.uk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.sso.SSOManager;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import fe.fe.nn.ppp.de;
import fe.fe.nn.ppp.fe;
import fe.fe.nn.ppp.th;
import fe.fe.nn.ppp.uk;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

@SuppressLint({"TrulyRandom"})
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f2394ad = new byte[1024];

    /* renamed from: de  reason: collision with root package name */
    public HttpURLConnection f2395de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2396fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2397i = false;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f2398rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2399th = 10000;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f2400uk = false;

    /* renamed from: yj  reason: collision with root package name */
    public int f2401yj = 10000;

    public ad(Context context, Handler handler) {
        this.qw = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String ad(java.lang.String r2, byte[] r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "POST"
            r1.fe(r0, r2)
            r0 = 0
            java.io.InputStream r2 = r1.qw(r3, r4, r2)     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x001b
            if (r2 == 0) goto L_0x0011
            r2.close()
        L_0x0011:
            java.net.HttpURLConnection r2 = r1.f2395de
            if (r2 == 0) goto L_0x001a
            r2.disconnect()
            r1.f2395de = r0
        L_0x001a:
            return r0
        L_0x001b:
            java.lang.String r3 = r1.th(r2)     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x0024
            r2.close()
        L_0x0024:
            java.net.HttpURLConnection r2 = r1.f2395de
            if (r2 == 0) goto L_0x002d
            r2.disconnect()
            r1.f2395de = r0
        L_0x002d:
            return r3
        L_0x002e:
            r3 = move-exception
            goto L_0x0032
        L_0x0030:
            r3 = move-exception
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x0037
            r2.close()
        L_0x0037:
            java.net.HttpURLConnection r2 = r1.f2395de
            if (r2 == 0) goto L_0x0040
            r2.disconnect()
            r1.f2395de = r0
        L_0x0040:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.uk.ad.ad(java.lang.String, byte[], java.util.Map):java.lang.String");
    }

    public final HttpURLConnection de(Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str = null;
        if (this.f2397i || TextUtils.isEmpty(this.f2396fe) || TextUtils.isEmpty(this.f2398rg)) {
            return null;
        }
        if (!this.f2396fe.equals("POST") && !this.f2396fe.equals(ShareTarget.METHOD_GET)) {
            this.f2396fe = "POST";
        }
        URL url = new URL(this.f2398rg);
        int i2 = 80;
        if (2 != de.uk(this.qw)) {
            if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i2 = Integer.parseInt(property);
                    } catch (Throwable unused) {
                    }
                }
                i2 = -1;
            } else {
                str = Proxy.getHost(this.qw);
                i2 = Proxy.getPort(this.qw);
            }
        }
        if (str == null || i2 <= 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
        }
        if (this.f2398rg.startsWith("https")) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        httpURLConnection.setRequestMethod(this.f2396fe);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.f2396fe)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.f2399th);
        httpURLConnection.setReadTimeout(this.f2401yj);
        httpURLConnection.setRequestProperty("x-device-id", uk.ad(fe.qw(this.qw)));
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        String str2 = SSOManager.f1098ad;
        String rg2 = de.rg(this.qw);
        httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + rg2 + "/" + "1.2.6");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        StringBuilder sb = new StringBuilder();
        sb.append("sso/");
        sb.append("1.2.6");
        httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
        httpURLConnection.setRequestProperty("x-plu-ver", "sso/" + "1.2.6");
        httpURLConnection.setRequestProperty("x-app-ver", this.qw.getPackageName() + "/" + de.rg(this.qw));
        httpURLConnection.setRequestProperty("x-auth-ver", BannerBaseItemInfo.TYPE_LOGIN);
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        return httpURLConnection;
    }

    public final void fe(String str, String str2) {
        this.f2396fe = str;
        this.f2398rg = str2;
    }

    public final InputStream qw(byte[] bArr, Map<String, String> map, String str) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            if (de.uk(this.qw) == 0) {
                return null;
            }
            HttpURLConnection de2 = de(map);
            this.f2395de = de2;
            if (de2 == null) {
                return null;
            }
            if (bArr == null) {
                if ("gzip".equalsIgnoreCase(de2.getContentEncoding())) {
                    this.f2400uk = true;
                } else {
                    this.f2400uk = false;
                }
                this.f2395de.getResponseCode();
                return this.f2395de.getInputStream();
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f2395de.getOutputStream());
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                if ("gzip".equalsIgnoreCase(this.f2395de.getContentEncoding())) {
                    this.f2400uk = true;
                } else {
                    this.f2400uk = false;
                }
                this.f2395de.getResponseCode();
                InputStream inputStream = this.f2395de.getInputStream();
                try {
                    bufferedOutputStream2.close();
                } catch (Throwable th2) {
                    de.fe(th2);
                }
                return inputStream;
            } catch (Exception e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th5) {
                        de.fe(th5);
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw e;
        }
    }

    public final byte[] rg(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f2394ad);
            if (read != -1) {
                byteArrayOutputStream.write(this.f2394ad, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public final String th(InputStream inputStream) {
        byte[] rg2;
        if (inputStream == null || (rg2 = rg(inputStream)) == null) {
            return null;
        }
        if (this.f2400uk) {
            rg2 = th.fe(rg2);
        }
        if (rg2 == null) {
            return "";
        }
        return new String(rg2);
    }
}
