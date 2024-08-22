package com.cmic.sso.sdk.c;

import android.os.Build;
import com.cmic.sso.sdk.a;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class c extends a {
    public static final String[] a = {"TLSv1.2"};
    public final a b;

    public c(SSLSocketFactory sSLSocketFactory, a aVar) {
        this.delegate = sSLSocketFactory;
        this.b = aVar;
    }

    private Socket a(Socket socket) {
        if ((socket instanceof SSLSocket) && Build.VERSION.SDK_INT < 20) {
            com.cmic.sso.sdk.e.c.b("Tls12SocketFactory", "5.0以下启动tls 1.2");
            SSLSocket sSLSocket = (SSLSocket) socket;
            for (String a2 : sSLSocket.getEnabledProtocols()) {
                com.cmic.sso.sdk.e.c.a("enableProtocol", a2);
            }
            sSLSocket.setEnabledProtocols(a);
            sSLSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"});
        }
        this.b.a("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }

    public Socket createSocket() {
        return a(this.delegate.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public String toString() {
        return "Tls12SocketFactory";
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z) {
        return a(this.delegate.createSocket(socket, str, i2, z));
    }

    public Socket createSocket(String str, int i2) {
        return a(this.delegate.createSocket(str, i2));
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return a(this.delegate.createSocket(str, i2, inetAddress, i3));
    }

    public Socket createSocket(InetAddress inetAddress, int i2) {
        return a(this.delegate.createSocket(inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return a(this.delegate.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
