package com.pichillilorenzo.flutter_inappwebview;

import android.content.Context;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.utils.SapiUtils;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
    public static final String ANDROID_ASSET_URL = "file:///android_asset/";
    public static final String LOG_TAG = "Util";

    public static class PrivateKeyAndCertificates {
        public X509Certificate[] certificates;
        public PrivateKey privateKey;

        public PrivateKeyAndCertificates(PrivateKey privateKey2, X509Certificate[] x509CertificateArr) {
            this.privateKey = privateKey2;
            this.certificates = x509CertificateArr;
        }
    }

    public static class WaitFlutterResult {
        public String error;
        public Object result;

        public WaitFlutterResult(Object obj, String str) {
            this.result = obj;
            this.error = str;
        }
    }

    @RequiresApi(api = 19)
    public static String JSONStringify(@Nullable Object obj) {
        return obj == null ? StringUtil.NULL_STRING : obj instanceof Map ? new JSONObject((Map) obj).toString() : obj instanceof List ? new JSONArray((List) obj).toString() : obj instanceof String ? JSONObject.quote((String) obj) : JSONObject.wrap(obj).toString();
    }

    public static InputStream getFileAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        return inAppWebViewFlutterPlugin.applicationContext.getResources().getAssets().open(registrar != null ? registrar.lookupKeyForAsset(str) : inAppWebViewFlutterPlugin.flutterAssets.getAssetFilePathByName(str));
    }

    public static Object getOrDefault(Map map, String str, Object obj) {
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static float getPixelDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(socketFactory, (X509TrustManager) trustManagerArr[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            return builder.connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrlAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        String lookupKeyForAsset = registrar != null ? registrar.lookupKeyForAsset(str) : inAppWebViewFlutterPlugin.flutterAssets.getAssetFilePathByName(str);
        IOException iOException = null;
        InputStream fileAsset = getFileAsset(inAppWebViewFlutterPlugin, str);
        if (fileAsset != null) {
            try {
                fileAsset.close();
            } catch (IOException e) {
                iOException = e;
            }
        }
        if (iOException == null) {
            return "file:///android_asset/" + lookupKeyForAsset;
        }
        throw iOException;
    }

    public static X509Certificate getX509CertFromSslCertHack(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException unused) {
            }
        }
        return null;
    }

    public static WaitFlutterResult invokeMethodAndWait(MethodChannel methodChannel, String str, Object obj) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        HashMap hashMap = new HashMap();
        hashMap.put("result", (Object) null);
        hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, (Object) null);
        final MethodChannel methodChannel2 = methodChannel;
        final String str2 = str;
        final Object obj2 = obj;
        final HashMap hashMap2 = hashMap;
        final CountDownLatch countDownLatch2 = countDownLatch;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                methodChannel2.invokeMethod(str2, obj2, new MethodChannel.Result() {
                    public void error(String str, String str2, Object obj) {
                        Map map = hashMap2;
                        map.put(SapiUtils.KEY_QR_LOGIN_ERROR, "ERROR: " + str + " " + str2);
                        hashMap2.put("result", obj);
                        countDownLatch2.countDown();
                    }

                    public void notImplemented() {
                        countDownLatch2.countDown();
                    }

                    public void success(Object obj) {
                        hashMap2.put("result", obj);
                        countDownLatch2.countDown();
                    }
                });
            }
        });
        countDownLatch.await();
        return new WaitFlutterResult(hashMap.get("result"), (String) hashMap.get(SapiUtils.KEY_QR_LOGIN_ERROR));
    }

    public static boolean isClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isIPv6(String str) {
        try {
            Inet6Address.getByName(str);
            return true;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public static PrivateKeyAndCertificates loadPrivateKeyAndCertificate(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str, String str2, String str3) {
        PrivateKeyAndCertificates privateKeyAndCertificates = null;
        try {
            InputStream fileAsset = getFileAsset(inAppWebViewFlutterPlugin, str);
            KeyStore instance = KeyStore.getInstance(str3);
            instance.load(fileAsset, str2 != null ? str2.toCharArray() : null);
            String nextElement = instance.aliases().nextElement();
            Key key = instance.getKey(nextElement, str2.toCharArray());
            if (key instanceof PrivateKey) {
                privateKeyAndCertificates = new PrivateKeyAndCertificates((PrivateKey) key, new X509Certificate[]{(X509Certificate) instance.getCertificate(nextElement)});
            }
            fileAsset.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return privateKeyAndCertificates;
    }

    public static void log(String str, String str2) {
        int min;
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str2.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + 4000);
                str2.substring(i2, min);
                if (min >= indexOf) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }

    public static String normalizeIPv6(String str) {
        if (isIPv6(str)) {
            return InetAddress.getByName(str).getCanonicalHostName();
        }
        throw new Exception("Invalid address: " + str);
    }

    public static boolean objEquals(@Nullable Object obj, @Nullable Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.equals(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String replaceAll(String str, String str2, String str3) {
        return TextUtils.join(str3, str.split(Pattern.quote(str2)));
    }
}
