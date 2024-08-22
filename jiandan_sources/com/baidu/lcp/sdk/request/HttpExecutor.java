package com.baidu.lcp.sdk.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.dxmpay.wallet.core.StatusCode;
import fe.fe.p004if.qw.yj.fe;
import java.io.IOException;
import java.net.SocketException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpExecutor {
    public static ad qw;

    public interface HttpRequest {
        String ad();

        byte[] fe();

        String getMediaType();

        String getMethod();

        Map<String, String> qw();
    }

    public interface ResponseHandler {
        void de(byte[] bArr);

        void onFailure(int i2, String str);
    }

    public static class ad implements X509TrustManager {
        public ad() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public /* synthetic */ ad(qw qwVar) {
            this();
        }
    }

    public static class de implements HostnameVerifier {
        public de() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public /* synthetic */ de(qw qwVar) {
            this();
        }
    }

    public class qw implements Callback {
        public final /* synthetic */ ResponseHandler qw;

        public qw(ResponseHandler responseHandler) {
            this.qw = responseHandler;
        }

        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            String str = "HttpRequest error :" + iOException.toString();
            if (iOException instanceof SocketException) {
                str = "HttpRequest SocketException :" + iOException.toString();
            }
            HttpExecutor.de(this.qw, 10003, str);
        }

        public void onResponse(@NonNull Call call, @NonNull Response response) {
            try {
                if (response.code() != 200) {
                    HttpExecutor.de(this.qw, response.code(), response.message());
                } else if (response.body() == null) {
                    HttpExecutor.de(this.qw, StatusCode.ERROR_NOT_IMPLEMENTED, "response body empty");
                } else {
                    byte[] bytes = response.body().bytes();
                    fe.ad("HttpExecutor", "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                    this.qw.de(bytes);
                }
            } catch (IOException e) {
                ResponseHandler responseHandler = this.qw;
                HttpExecutor.de(responseHandler, 10001, "parse response exception ：" + e);
            }
        }
    }

    public static SSLSocketFactory ad() {
        try {
            qw = new ad((qw) null);
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{qw}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void de(@NonNull ResponseHandler responseHandler, int i2, String str) {
        responseHandler.onFailure(i2, str);
        fe.ad("HttpExecutor", "failedResponse errorCode ：" + i2 + ", errorMsg :" + str);
    }

    public static Headers fe(Map<String, String> map) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    String str2 = str.toString();
                    builder.add(str2, map.get(str2));
                }
            }
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void rg(@NonNull HttpRequest httpRequest, @NonNull ResponseHandler responseHandler) {
        Request request;
        try {
            String ad2 = httpRequest.ad();
            byte[] fe2 = httpRequest.fe();
            if (fe2 != null) {
                if (fe2.length > 0) {
                    OkHttpClient build = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
                    if (httpRequest.getMethod().equals("POST")) {
                        request = new Request.Builder().url(ad2).post(RequestBody.create(MediaType.parse(httpRequest.getMediaType()), fe2)).build();
                    } else {
                        if (fe2 != null && fe2.length > 0) {
                            ad2 = ad2 + "?" + new String(fe2);
                        }
                        request = new Request.Builder().url(ad2).build();
                    }
                    Map<String, String> qw2 = httpRequest.qw();
                    Headers fe3 = fe(qw2);
                    if (!(qw2 == null || fe3 == null)) {
                        request = request.newBuilder().headers(fe3).build();
                        String str = qw2.get("Host");
                        if (!TextUtils.isEmpty(str) && str.contains("https://httpsdns.baidu.com/")) {
                            build = build.newBuilder().sslSocketFactory(ad(), qw).hostnameVerifier(new de((qw) null)).build();
                        }
                    }
                    fe.qw("HttpExecutor", "request url :" + ad2 + " , method :" + httpRequest.getMethod() + " , body :" + new String(httpRequest.fe()));
                    build.newCall(request).enqueue(new qw(responseHandler));
                    return;
                }
            }
            de(responseHandler, 10000, "request args exception");
        } catch (Exception e) {
            de(responseHandler, StatusCode.ERROR_NOT_IMPLEMENTED, "request exception :" + e);
        }
    }
}
