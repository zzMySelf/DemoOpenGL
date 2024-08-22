package fe.fe.p004if.qw.de;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.baidu.apollon.restnet.http.b;
import fe.fe.p004if.qw.yj.fe;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;

/* renamed from: fe.fe.if.qw.de.rg  reason: invalid package */
public class rg extends ad {

    /* renamed from: de  reason: collision with root package name */
    public Socket f1962de;

    /* renamed from: fe  reason: collision with root package name */
    public InputStream f1963fe;

    /* renamed from: rg  reason: collision with root package name */
    public OutputStream f1964rg;

    /* renamed from: th  reason: collision with root package name */
    public String f1965th;

    public rg(Context context, String str) {
        super(context);
        this.f1965th = str;
    }

    public InputStream ad() throws EOFException, IOException {
        return new DataInputStream(this.f1963fe);
    }

    public void de(de deVar) {
        this.f1911ad = deVar;
        if (deVar != null) {
            this.f1963fe = deVar.f1914fe;
            this.f1964rg = deVar.f1915rg;
            return;
        }
        this.f1963fe = null;
        this.f1964rg = null;
    }

    public boolean fe() {
        return pf(this.f1911ad);
    }

    @SuppressLint({"NewApi"})
    public final Socket i(String str, int i2) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.qw);
        if (str.contains("baidu.com")) {
            fe.qw("TcpMessageHandler", "localdns begin...,domain:" + str);
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    int length = allByName.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        InetAddress inetAddress = allByName[i3];
                        if (inetAddress instanceof Inet4Address) {
                            str = inetAddress.getHostAddress();
                            break;
                        }
                        i3++;
                    }
                }
            } catch (Exception e) {
                fe.de("TcpMessageHandler", "createSocketOnLine", e);
            }
        }
        if (str.contains("baidu.com")) {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
        }
        if (sSLCertificateSocketFactory == null) {
            return null;
        }
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i2);
        sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
        sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
        sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
        sSLSocket.startHandshake();
        return sSLSocket;
    }

    public final Socket o(String str, int i2) throws UnknownHostException, IOException {
        return new Socket(str, i2);
    }

    public boolean pf(de deVar) {
        if (deVar == null || !deVar.qw.booleanValue()) {
            return true;
        }
        try {
            if (deVar.f1913de != null) {
                deVar.f1913de.close();
                deVar.f1913de = null;
            }
            if (deVar.f1914fe != null) {
                deVar.f1914fe.close();
                deVar.f1914fe = null;
            }
            if (deVar.f1915rg == null) {
                return true;
            }
            deVar.f1915rg.close();
            deVar.f1915rg = null;
            return true;
        } catch (IOException e) {
            fe.de("TcpMessageHandler", "destroy:", e);
            return false;
        }
    }

    public de rg(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return yj(str, i2);
    }

    public void th(qw qwVar) throws IOException {
        OutputStream outputStream;
        if (this.f1962de != null && (outputStream = this.f1964rg) != null) {
            outputStream.write(qwVar.qw);
            this.f1964rg.flush();
        }
    }

    public final Socket uk(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f1965th.equals(b.c.d)) {
            return o(str, i2);
        }
        return i(str, i2);
    }

    public final de yj(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        fe.fe("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
        this.f1962de = uk(str, i2);
        de deVar = new de();
        Socket socket = this.f1962de;
        if (socket == null) {
            return deVar;
        }
        deVar.f1913de = socket;
        deVar.f1914fe = socket.getInputStream();
        deVar.f1915rg = this.f1962de.getOutputStream();
        Boolean bool = Boolean.TRUE;
        deVar.qw = bool;
        deVar.f1912ad = bool;
        return deVar;
    }
}
