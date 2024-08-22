package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.baidu.searchbox.message.push.IAchPluginInvoker;
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
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

class AndroidPlatform extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final CloseGuard closeGuard = CloseGuard.get();
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;

    AndroidPlatform(Class<?> sslParametersClass2, OptionalMethod<Socket> setUseSessionTickets2, OptionalMethod<Socket> setHostname2, OptionalMethod<Socket> getAlpnSelectedProtocol2, OptionalMethod<Socket> setAlpnProtocols2) {
        this.sslParametersClass = sslParametersClass2;
        this.setUseSessionTickets = setUseSessionTickets2;
        this.setHostname = setHostname2;
        this.getAlpnSelectedProtocol = getAlpnSelectedProtocol2;
        this.setAlpnProtocols = setAlpnProtocols2;
    }

    public void connectSocket(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        try {
            socket.connect(address, connectTimeout);
        } catch (AssertionError e2) {
            if (Util.isAndroidGetsocknameError(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException ioException = new IOException("Exception in connect");
            ioException.initCause(e3);
            throw ioException;
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException ioException2 = new IOException("Exception in connect");
                ioException2.initCause(e4);
                throw ioException2;
            }
            throw e4;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Object context = readFieldOrNull(sslSocketFactory, this.sslParametersClass, "sslParameters");
        if (context == null) {
            try {
                context = readFieldOrNull(sslSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sslSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e2) {
                return super.trustManager(sslSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) readFieldOrNull(context, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) readFieldOrNull(context, X509TrustManager.class, "trustManager");
    }

    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) throws IOException {
        if (hostname != null) {
            this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sslSocket, true);
            this.setHostname.invokeOptionalWithoutCheckedException(sslSocket, hostname);
        }
        OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
        if (optionalMethod != null && optionalMethod.isSupported(sslSocket)) {
            this.setAlpnProtocols.invokeWithoutCheckedException(sslSocket, concatLengthPrefixed(protocols));
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket socket) {
        byte[] alpnResult;
        OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
        if (optionalMethod == null || !optionalMethod.isSupported(socket) || (alpnResult = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(socket, new Object[0])) == null) {
            return null;
        }
        return new String(alpnResult, Util.UTF_8);
    }

    public void log(int level, String message, @Nullable Throwable t) {
        int logLevel = 5;
        if (level != 5) {
            logLevel = 3;
        }
        if (t != null) {
            message = message + 10 + Log.getStackTraceString(t);
        }
        int i2 = 0;
        int length = message.length();
        while (i2 < length) {
            int newline = message.indexOf(10, i2);
            int newline2 = newline != -1 ? newline : length;
            do {
                int end = Math.min(newline2, i2 + 4000);
                Log.println(logLevel, "OkHttp", message.substring(i2, end));
                i2 = end;
            } while (i2 < newline2);
            i2++;
        }
    }

    public Object getStackTraceForCloseable(String closer) {
        return this.closeGuard.createAndOpen(closer);
    }

    public void logCloseableLeak(String message, Object stackTrace) {
        if (!this.closeGuard.warnIfOpen(stackTrace)) {
            log(5, message, (Throwable) null);
        }
    }

    public boolean isCleartextTrafficPermitted(String hostname) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.isCleartextTrafficPermitted(hostname);
        }
        try {
            Class<?> networkPolicyClass = Class.forName("android.security.NetworkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(hostname, networkPolicyClass, networkPolicyClass.getMethod(IAchPluginInvoker.INSTANCE_METHOD, new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            return super.isCleartextTrafficPermitted(hostname);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            throw Util.assertionError("unable to determine cleartext support", e3);
        }
    }

    private boolean api24IsCleartextTrafficPermitted(String hostname, Class<?> networkPolicyClass, Object networkSecurityPolicy) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) networkPolicyClass.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(networkSecurityPolicy, new Object[]{hostname})).booleanValue();
        } catch (NoSuchMethodException e2) {
            return api23IsCleartextTrafficPermitted(hostname, networkPolicyClass, networkSecurityPolicy);
        }
    }

    private boolean api23IsCleartextTrafficPermitted(String hostname, Class<?> networkPolicyClass, Object networkSecurityPolicy) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) networkPolicyClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(networkSecurityPolicy, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e2) {
            return super.isCleartextTrafficPermitted(hostname);
        }
    }

    private static boolean supportsAlpn() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager trustManager) {
        try {
            Class<?> extensionsClass = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(extensionsClass.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{trustManager}), extensionsClass.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception e2) {
            return super.buildCertificateChainCleaner(trustManager);
        }
    }

    public static Platform buildIfSupported() {
        Class<?> sslParametersClass2;
        OptionalMethod<Socket> setAlpnProtocols2;
        OptionalMethod<Socket> getAlpnSelectedProtocol2;
        Class<byte[]> cls = byte[].class;
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            sslParametersClass2 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException e2) {
            try {
                sslParametersClass2 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException e3) {
                return null;
            }
        }
        OptionalMethod<Socket> setUseSessionTickets2 = new OptionalMethod<>((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        OptionalMethod<Socket> setHostname2 = new OptionalMethod<>((Class<?>) null, "setHostname", String.class);
        if (supportsAlpn()) {
            OptionalMethod<Socket> getAlpnSelectedProtocol3 = new OptionalMethod<>(cls, "getAlpnSelectedProtocol", new Class[0]);
            setAlpnProtocols2 = new OptionalMethod<>((Class<?>) null, "setAlpnProtocols", cls);
            getAlpnSelectedProtocol2 = getAlpnSelectedProtocol3;
        } else {
            getAlpnSelectedProtocol2 = null;
            setAlpnProtocols2 = null;
        }
        return new AndroidPlatform(sslParametersClass2, setUseSessionTickets2, setHostname2, getAlpnSelectedProtocol2, setAlpnProtocols2);
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager trustManager) {
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            method.setAccessible(true);
            return new AndroidTrustRootIndex(trustManager, method);
        } catch (NoSuchMethodException e2) {
            return super.buildTrustRootIndex(trustManager);
        }
    }

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        AndroidCertificateChainCleaner(Object x509TrustManagerExtensions2, Method checkServerTrusted2) {
            this.x509TrustManagerExtensions = x509TrustManagerExtensions2;
            this.checkServerTrusted = checkServerTrusted2;
        }

        public List<Certificate> clean(List<Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
            try {
                return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{(X509Certificate[]) chain.toArray(new X509Certificate[chain.size()]), "RSA", hostname});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException exception = new SSLPeerUnverifiedException(e2.getMessage());
                exception.initCause(e2);
                throw exception;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public boolean equals(Object other) {
            return other instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class CloseGuard {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        CloseGuard(Method getMethod2, Method openMethod2, Method warnIfOpenMethod2) {
            this.getMethod = getMethod2;
            this.openMethod = openMethod2;
            this.warnIfOpenMethod = warnIfOpenMethod2;
        }

        /* access modifiers changed from: package-private */
        public Object createAndOpen(String closer) {
            Method method = this.getMethod;
            if (method != null) {
                try {
                    Object closeGuardInstance = method.invoke((Object) null, new Object[0]);
                    this.openMethod.invoke(closeGuardInstance, new Object[]{closer});
                    return closeGuardInstance;
                } catch (Exception e2) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean warnIfOpen(Object closeGuardInstance) {
            if (closeGuardInstance == null) {
                return false;
            }
            try {
                this.warnIfOpenMethod.invoke(closeGuardInstance, new Object[0]);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }

        static CloseGuard get() {
            Method openMethod2;
            Method getMethod2;
            Method warnIfOpenMethod2;
            try {
                Class<?> closeGuardClass = Class.forName("dalvik.system.CloseGuard");
                getMethod2 = closeGuardClass.getMethod("get", new Class[0]);
                openMethod2 = closeGuardClass.getMethod("open", new Class[]{String.class});
                warnIfOpenMethod2 = closeGuardClass.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception e2) {
                getMethod2 = null;
                openMethod2 = null;
                warnIfOpenMethod2 = null;
            }
            return new CloseGuard(getMethod2, openMethod2, warnIfOpenMethod2);
        }
    }

    static final class AndroidTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        AndroidTrustRootIndex(X509TrustManager trustManager2, Method findByIssuerAndSignatureMethod2) {
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod2;
            this.trustManager = trustManager2;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate cert) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{cert});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw Util.assertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException e3) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex that = (AndroidTrustRootIndex) obj;
            if (!this.trustManager.equals(that.trustManager) || !this.findByIssuerAndSignatureMethod.equals(that.findByIssuerAndSignatureMethod)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    public SSLContext getSSLContext() {
        boolean tryTls12;
        try {
            tryTls12 = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22;
        } catch (NoClassDefFoundError e2) {
            tryTls12 = true;
        }
        if (tryTls12) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException e3) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e4) {
            throw new IllegalStateException("No TLS provider", e4);
        }
    }

    static int getSdkInt() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError e2) {
            return 0;
        }
    }
}
