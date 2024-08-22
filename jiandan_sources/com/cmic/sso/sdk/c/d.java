package com.cmic.sso.sdk.c;

import android.net.Network;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.e.c;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class d extends a {
    public static final String[] b = {"TLSv1.2"};
    public HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();
    public final String c = d.class.getSimpleName();
    public final HttpsURLConnection d;
    public final Network e;
    public final a f;

    public d(HttpsURLConnection httpsURLConnection, Network network, a aVar) {
        this.d = httpsURLConnection;
        this.e = network;
        this.f = aVar;
    }

    public Socket createSocket(String str, int i2) {
        return null;
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i2) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z) {
        String requestProperty = this.d.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        String str2 = this.c;
        c.b(str2, "customized createSocket. host: " + str);
        String str3 = this.c;
        c.b(str3, "plainSocket localAddress: " + socket.getLocalAddress().getHostAddress());
        if (z) {
            c.b(this.c, "plainSocket close");
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket();
        Network network = this.e;
        if (network != null && Build.VERSION.SDK_INT >= 21) {
            network.bindSocket(sSLSocket);
        }
        sSLSocket.connect(socket.getRemoteSocketAddress());
        this.f.a("socketip", sSLSocket.getLocalAddress().getHostAddress());
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 20) {
            c.b(this.c, "5.0以下启动tls 1.2");
            sSLSocket.setEnabledProtocols(b);
            sSLSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"});
        }
        if (i3 >= 17) {
            c.b(this.c, "Setting SNI hostname");
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        } else {
            c.b(this.c, "No documented SNI support on Android <4.2, trying with reflection");
            try {
                sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{str});
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a(this.c, "SNI not useable");
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (this.a.verify(str, session)) {
            String str4 = this.c;
            c.b(str4, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
