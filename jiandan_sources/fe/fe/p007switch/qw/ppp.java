package fe.fe.p007switch.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.apollon.heartbeat.a;
import com.baidu.mobstat.dxmpay.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/* renamed from: fe.fe.switch.qw.ppp  reason: invalid package */
public final class ppp {

    /* renamed from: ad  reason: collision with root package name */
    public static final Proxy f3046ad = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));
    public static final Proxy qw = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));

    @SuppressLint({"DefaultLocale"})
    public static HttpURLConnection ad(Context context, String str, int i2, int i3) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null || !networkInfo2.isAvailable()) {
            if (networkInfo != null && networkInfo.isAvailable()) {
                String extraInfo = networkInfo.getExtraInfo();
                String lowerCase = extraInfo != null ? extraInfo.toLowerCase() : "";
                if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(qw);
                } else if (lowerCase.startsWith("ctwap")) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(f3046ad);
                }
            }
            httpURLConnection = null;
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (httpURLConnection == null) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(i2);
        httpURLConnection.setReadTimeout(i3);
        return httpURLConnection;
    }

    public static void de(Context context, String str, String str2, boolean z) {
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                ddd.ad(new ByteArrayInputStream(str2.getBytes(a.h)), fileOutputStream);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                ddd.qw(fileOutputStream);
                throw th2;
            }
            ddd.qw(fileOutputStream);
        }
    }

    public static byte[] fe(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (ddd.ad(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static String qw(Context context, String str) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(str);
            byte[] fe2 = fe(fileInputStream);
            if (fe2 != null) {
                String str2 = new String(fe2, a.h);
                ddd.qw(fileInputStream);
                return str2;
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            ddd.qw((Closeable) null);
            throw th2;
        }
        ddd.qw(fileInputStream);
        return "";
    }

    public static boolean rg(Context context, String str) {
        return context.deleteFile(str);
    }

    public static boolean th(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    public static boolean uk(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (!z) {
            h o2 = h.o();
            o2.th("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        return z;
    }

    public static HttpURLConnection yj(Context context, String str) throws IOException {
        return ad(context, str, 50000, 50000);
    }
}
