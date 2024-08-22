package fe.th.de.rrr.p019if;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
/* renamed from: fe.th.de.rrr.if.qw  reason: invalid package */
public class qw extends ad {
    public qw(Class<?> cls) {
        super(cls, (th<Socket>) null, (th<Socket>) null, (th<Socket>) null, (th<Socket>) null);
    }

    public static yj a() {
        if (!yj.xxx()) {
            return null;
        }
        try {
            if (ad.b() >= 29) {
                return new qw(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    public final void d(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @IgnoreJRERequirement
    public String ggg(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            d(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) yj.ad(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
