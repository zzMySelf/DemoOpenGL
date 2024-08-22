package com.baidu.searchbox.aps.net.base;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SNISocketFactory extends SSLSocketFactory {
    private HttpsURLConnection connection;
    HostnameVerifier mHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public SNISocketFactory(HttpsURLConnection connection2) {
        this.connection = connection2;
    }

    public Socket createSocket() throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress host, int port) throws IOException {
        return null;
    }

    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return null;
    }

    public Socket createSocket(String host, int port) throws IOException {
        return null;
    }

    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        String peerHost = this.connection.getRequestProperty("Host");
        if (peerHost != null) {
            peerHost = host;
        }
        InetAddress address = s.getInetAddress();
        if (autoClose) {
            s.close();
        }
        SSLCertificateSocketFactory sslSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket ssl = (SSLSocket) sslSocketFactory.createSocket(address, port);
        ssl.setEnabledProtocols(ssl.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sslSocketFactory.setHostname(ssl, peerHost);
        } else {
            try {
                ssl.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(ssl, new Object[]{peerHost});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.mHostnameVerifier.verify(peerHost, ssl.getSession())) {
            return ssl;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + peerHost);
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
