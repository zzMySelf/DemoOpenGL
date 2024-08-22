package fe.th.de.rrr.p019if;

import com.duxiaoman.okhttp3.Protocol;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: fe.th.de.rrr.if.fe  reason: invalid package */
public final class fe extends yj {

    /* renamed from: de  reason: collision with root package name */
    public final Method f5297de;

    /* renamed from: fe  reason: collision with root package name */
    public final Method f5298fe;

    public fe(Method method, Method method2) {
        this.f5297de = method;
        this.f5298fe = method2;
    }

    public static fe rrr() {
        try {
            return new fe(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public X509TrustManager eee(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    public String ggg(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5298fe.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw fe.th.de.rrr.fe.ad("failed to get ALPN selected protocol", e);
        } catch (IllegalAccessException e2) {
            throw fe.th.de.rrr.fe.ad("failed to get ALPN selected protocol", e2);
        }
    }

    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> ad2 = yj.ad(list);
            this.f5297de.invoke(sSLParameters, new Object[]{ad2.toArray(new String[ad2.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fe.th.de.rrr.fe.ad("unable to set ssl parameters", e);
        }
    }
}
