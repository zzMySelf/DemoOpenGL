package fe.th.de.rrr.yj;

import fe.th.de.rrr.qw;
import fe.th.de.yj;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f5490ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public boolean f5491de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f5492fe;
    public final List<yj> qw;

    public ad(List<yj> list) {
        this.qw = list;
    }

    public boolean ad(IOException iOException) {
        this.f5492fe = true;
        if (!this.f5491de || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException)) {
            return true;
        }
        return false;
    }

    public final boolean de(SSLSocket sSLSocket) {
        for (int i2 = this.f5490ad; i2 < this.qw.size(); i2++) {
            if (this.qw.get(i2).de(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public yj qw(SSLSocket sSLSocket) throws IOException {
        yj yjVar;
        int i2 = this.f5490ad;
        int size = this.qw.size();
        while (true) {
            if (i2 >= size) {
                yjVar = null;
                break;
            }
            yjVar = this.qw.get(i2);
            if (yjVar.de(sSLSocket)) {
                this.f5490ad = i2 + 1;
                break;
            }
            i2++;
        }
        if (yjVar != null) {
            this.f5491de = de(sSLSocket);
            qw.qw.de(yjVar, sSLSocket, this.f5492fe);
            return yjVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5492fe + ", modes=" + this.qw + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }
}
