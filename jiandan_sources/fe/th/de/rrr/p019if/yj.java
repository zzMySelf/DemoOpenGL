package fe.th.de.rrr.p019if;

import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.tls.TrustRootIndex;
import fe.th.de.ggg;
import fe.th.de.rrr.when.ad;
import fe.th.de.rrr.when.de;
import fe.th.de.rrr.when.qw;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

/* renamed from: fe.th.de.rrr.if.yj  reason: invalid package */
public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static final Logger f5309ad = Logger.getLogger(ggg.class.getName());
    public static final yj qw = m349if();

    public static List<String> ad(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: if  reason: not valid java name */
    public static yj m349if() {
        if (xxx()) {
            return o();
        }
        return pf();
    }

    public static boolean nn() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static yj o() {
        yj a = qw.a();
        if (a != null) {
            return a;
        }
        yj a2 = ad.a();
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static yj pf() {
        de rrr;
        if (nn() && (rrr = de.rrr()) != null) {
            return rrr;
        }
        fe rrr2 = fe.rrr();
        if (rrr2 != null) {
            return rrr2;
        }
        yj rrr3 = rg.rrr();
        if (rrr3 != null) {
            return rrr3;
        }
        return new yj();
    }

    public static <T> T qqq(Object obj, Class<T> cls, String str) {
        Object qqq;
        Class<Object> cls2 = Object.class;
        Class cls3 = obj.getClass();
        while (cls3 != cls2) {
            try {
                Field declaredField = cls3.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null) {
                    if (cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                }
                return null;
            } catch (NoSuchFieldException unused) {
                cls3 = cls3.getSuperclass();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (str.equals("delegate") || (qqq = qqq(obj, cls2, "delegate")) == null) {
            return null;
        }
        return qqq(qqq, cls, str);
    }

    /* renamed from: switch  reason: not valid java name */
    public static yj m350switch() {
        return qw;
    }

    public static byte[] th(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static boolean xxx() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public void aaa(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mmm(5, str, (Throwable) obj);
    }

    public boolean ddd(String str) {
        return true;
    }

    public de de(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager eee = eee(sSLSocketFactory);
        if (eee != null) {
            return fe(eee);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + m350switch() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public X509TrustManager eee(SSLSocketFactory sSLSocketFactory) {
        try {
            Object qqq = qqq(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (qqq == null) {
                return null;
            }
            return (X509TrustManager) qqq(qqq, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public de fe(X509TrustManager x509TrustManager) {
        return new qw(rg(x509TrustManager));
    }

    public String ggg(SSLSocket sSLSocket) {
        return null;
    }

    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void mmm(int i2, String str, Throwable th2) {
        f5309ad.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th2);
    }

    public SSLContext ppp() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public void qw(SSLSocket sSLSocket) {
    }

    public TrustRootIndex rg(X509TrustManager x509TrustManager) {
        return new ad(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
    }

    public Object vvv(String str) {
        if (f5309ad.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String when() {
        return "OkHttp";
    }

    public void yj(SSLSocketFactory sSLSocketFactory) {
    }
}
