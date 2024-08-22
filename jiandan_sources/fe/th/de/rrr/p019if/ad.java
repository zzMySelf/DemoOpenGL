package fe.th.de.rrr.p019if;

import android.os.Build;
import android.util.Log;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.tls.TrustRootIndex;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: fe.th.de.rrr.if.ad  reason: invalid package */
public class ad extends yj {

    /* renamed from: de  reason: collision with root package name */
    public final Class<?> f5287de;

    /* renamed from: fe  reason: collision with root package name */
    public final th<Socket> f5288fe;

    /* renamed from: rg  reason: collision with root package name */
    public final th<Socket> f5289rg;

    /* renamed from: th  reason: collision with root package name */
    public final th<Socket> f5290th;

    /* renamed from: uk  reason: collision with root package name */
    public final de f5291uk = de.ad();

    /* renamed from: yj  reason: collision with root package name */
    public final th<Socket> f5292yj;

    /* renamed from: fe.th.de.rrr.if.ad$ad  reason: collision with other inner class name */
    public static final class C0223ad implements TrustRootIndex {

        /* renamed from: ad  reason: collision with root package name */
        public final Method f5293ad;
        public final X509TrustManager qw;

        public C0223ad(X509TrustManager x509TrustManager, Method method) {
            this.f5293ad = method;
            this.qw = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0223ad)) {
                return false;
            }
            C0223ad adVar = (C0223ad) obj;
            if (!this.qw.equals(adVar.qw) || !this.f5293ad.equals(adVar.f5293ad)) {
                return false;
            }
            return true;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5293ad.invoke(this.qw, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw fe.ad("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.qw.hashCode() + (this.f5293ad.hashCode() * 31);
        }
    }

    /* renamed from: fe.th.de.rrr.if.ad$de */
    public static final class de {

        /* renamed from: ad  reason: collision with root package name */
        public final Method f5294ad;

        /* renamed from: de  reason: collision with root package name */
        public final Method f5295de;
        public final Method qw;

        public de(Method method, Method method2, Method method3) {
            this.qw = method;
            this.f5294ad = method2;
            this.f5295de = method3;
        }

        public static de ad() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new de(method3, method, method2);
        }

        public boolean de(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f5295de.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public Object qw(String str) {
            Method method = this.qw;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.f5294ad.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    /* renamed from: fe.th.de.rrr.if.ad$qw */
    public static final class qw extends fe.th.de.rrr.when.de {

        /* renamed from: ad  reason: collision with root package name */
        public final Method f5296ad;
        public final Object qw;

        public qw(Object obj, Method method) {
            this.qw = obj;
            this.f5296ad = method;
        }

        public boolean equals(Object obj) {
            return obj instanceof qw;
        }

        public int hashCode() {
            return 0;
        }

        public List<Certificate> qw(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f5296ad.invoke(this.qw, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public ad(Class<?> cls, th<Socket> thVar, th<Socket> thVar2, th<Socket> thVar3, th<Socket> thVar4) {
        this.f5287de = cls;
        this.f5288fe = thVar;
        this.f5289rg = thVar2;
        this.f5290th = thVar3;
        this.f5292yj = thVar4;
    }

    public static yj a() {
        Class<?> cls;
        th thVar;
        th thVar2;
        Class<byte[]> cls2 = byte[].class;
        if (!yj.xxx()) {
            return null;
        }
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        th thVar3 = new th((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        th thVar4 = new th((Class<?>) null, "setHostname", String.class);
        if (c()) {
            th thVar5 = new th(cls2, "getAlpnSelectedProtocol", new Class[0]);
            thVar = new th((Class<?>) null, "setAlpnProtocols", cls2);
            thVar2 = thVar5;
        } else {
            thVar2 = null;
            thVar = null;
        }
        return new ad(cls3, thVar3, thVar4, thVar2, thVar);
    }

    public static int b() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    public static boolean c() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void aaa(String str, Object obj) {
        if (!this.f5291uk.de(obj)) {
            mmm(5, str, (Throwable) null);
        }
    }

    public boolean ddd(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.ddd(str);
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return tt(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.ddd(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw fe.ad("unable to determine cleartext support", e);
        }
    }

    public X509TrustManager eee(SSLSocketFactory sSLSocketFactory) {
        Object qqq = yj.qqq(sSLSocketFactory, this.f5287de, "sslParameters");
        if (qqq == null) {
            try {
                qqq = yj.qqq(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.eee(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) yj.qqq(qqq, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) yj.qqq(qqq, X509TrustManager.class, "trustManager");
    }

    public fe.th.de.rrr.when.de fe(X509TrustManager x509TrustManager) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new qw(cls2.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls2.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls, cls}));
        } catch (Exception unused) {
            return super.fe(x509TrustManager);
        }
    }

    public String ggg(SSLSocket sSLSocket) {
        byte[] bArr;
        th<Socket> thVar = this.f5290th;
        if (thVar == null || !thVar.yj(sSLSocket) || (bArr = (byte[]) this.f5290th.th(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, fe.f5257i);
    }

    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e) {
            if (fe.a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    public void mmm(int i2, String str, Throwable th2) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th2 != null) {
            str = str + 10 + Log.getStackTraceString(th2);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public SSLContext ppp() {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public TrustRootIndex rg(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C0223ad(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.rg(x509TrustManager);
        }
    }

    public final boolean rrr(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.ddd(str);
        }
    }

    public final boolean tt(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return rrr(str, cls, obj);
        }
    }

    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (str != null) {
            this.f5288fe.rg(sSLSocket, Boolean.TRUE);
            this.f5289rg.rg(sSLSocket, str);
        }
        th<Socket> thVar = this.f5292yj;
        if (thVar != null && thVar.yj(sSLSocket)) {
            this.f5292yj.th(sSLSocket, yj.th(list));
        }
    }

    public Object vvv(String str) {
        return this.f5291uk.qw(str);
    }
}
